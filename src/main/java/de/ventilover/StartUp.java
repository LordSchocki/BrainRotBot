package de.ventilover;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Properties;

public class StartUp {

    public void startBot() throws InterruptedException {
        Main.api = JDABuilder.createDefault(getToken(),intents)
                .addEventListeners(new MessageEventListener())
                .setActivity(Activity.watching("TikTok"))
                .setStatus(OnlineStatus.ONLINE)
                .disableCache(CacheFlag.EMOJI,CacheFlag.STICKER)
                .build();

        Main.api.awaitReady();
    }

    private static final EnumSet<GatewayIntent> intents = EnumSet.of(
            // Enables MessageReceivedEvent for guild (also known as servers)
            GatewayIntent.GUILD_MESSAGES,
            // Enables the event for private channels (also known as direct messages)
            GatewayIntent.DIRECT_MESSAGES,
            // Enables access to message.getContentRaw()
            GatewayIntent.MESSAGE_CONTENT,
            // Enables MessageReactionAddEvent for guild
            GatewayIntent.GUILD_MESSAGE_REACTIONS,
            // Enables MessageReactionAddEvent for private channels
            GatewayIntent.DIRECT_MESSAGE_REACTIONS,

            GatewayIntent.GUILD_VOICE_STATES,

            GatewayIntent.SCHEDULED_EVENTS
    );

    private String getToken() {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new FileNotFoundException("config.properties not found in resources");
            }
            props.load(input);  // <-- load from the InputStream here
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props.getProperty("DISCORD_TOKEN");
    }

}
