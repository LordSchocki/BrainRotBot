package de.ventilover;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MessageEventListener extends ListenerAdapter {

    private final ArrayList<String> triggers;
    private final HashMap<String, String> gifHash;

    MessageEventListener(){
        triggers = new ArrayList<>();
        gifHash = new HashMap<>();

        createArraylist(triggers);
        createGifHashMap(gifHash);
    }

    private ArrayList<String> getMonster(String message){
        ArrayList<String> monsters = new ArrayList<>();

        for (String monster : triggers){
            if (message.contains(monster)){
                switch (monster){
                    case "tung","sahur":
                        if (!monsters.contains("tung")){
                            monsters.add("tung");
                        }
                        break;
                    case "bombardilo", "crocodilo", "bombardino","bombardiro":
                        if (!monsters.contains("bombardilo")){
                            monsters.add("bombardilo");
                        }
                        break;
                    case "tralalero", "trala":
                        if (!monsters.contains("tralalero")){
                            monsters.add("tralalero");
                        }
                        break;
                    case "lirili","larila":
                        if (!monsters.contains("larila")){
                            monsters.add("larila");
                        }
                        break;
                    case "boneca","ambalabu":
                        if (!monsters.contains("boneca")){
                            monsters.add("boneca");
                        }
                        break;
                    case "brr","patapim":
                        if (!monsters.contains("patapim")){
                            monsters.add("patapim");
                        }
                        break;
                    case "chimpanzini","bananini":
                        if (!monsters.contains("chimpanzini")){
                            monsters.add("chimpanzini");
                        }
                        break;
                    case "bombombini","gusini":
                        if (!monsters.contains("bombombini")){
                            monsters.add("bombombini");
                        }
                        break;
                    case "cappuccino","assassino":
                        if (!monsters.contains("cappuccino")){
                            monsters.add("cappuccino");
                        }
                        break;
                    case "trippi","troppi":
                        if (!monsters.contains("trippi")){
                            monsters.add("trippi");
                        }
                        break;
                }
            }

        }
        return monsters;

    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);
        if (isBrainRotMessage(event)){
            String message = event.getMessage().getContentDisplay();

            ArrayList<String> messageMonsters = getMonster(message.toLowerCase().trim().strip());

            for (String monster : messageMonsters){
                event.getChannel().sendMessageEmbeds(makeResponse(monster).build()).queue();
            }

        }
    }

    private boolean isBrainRotMessage(MessageReceivedEvent event){
        if (event.isFromGuild()){
            String message = event.getMessage().getContentDisplay().toLowerCase().strip();

            for (String trigger : triggers){
                if (message.contains(trigger)){
                    return true;
                }
            }
        }
        else{
            return false;
        }
        return false;
    }

private void createGifHashMap(HashMap<String,String> gifHash){
        gifHash.put("tung","https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExaW10aDNkcDJ2djYxOTFwMDY3Mm51bzNmYTdpamxpZGd6ZWcyNXJ5OSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/OVwHlQbBR6vrR2b3PE/giphy.gif");
        gifHash.put("bombardilo", "https://media4.giphy.com/media/v1.Y2lkPTc5MGI3NjExemV5MTFpeGF6MHU4N3A5aWI5N3dkamJscnRpbjlyajF2N2xkMm5iZyZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/oOodJn6hHMZAojqmie/giphy.gif");
        gifHash.put("tralalero", "https://media2.giphy.com/media/v1.Y2lkPTc5MGI3NjExbXQ2Y2xteXl5cnZmMnJ6MmUzYnhnZDRzNnIxNnNhNmR2ZXJjdHNvaCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/XqvXCxEmWCP8ADeDnS/giphy.gif");
        gifHash.put("larila","https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExNGd2OXVxN21qcHhxN3hzeWd4bzJob2xlYnRuN3JleXcxbjN2MGpvdyZlcD12MV9naWZzX3NlYXJjaCZjdD1n/EwYYWTuzeYq2RseDMy/giphy.gif");
        gifHash.put("boneca","https://upload.wikimedia.org/wikipedia/commons/9/9d/Boneca_Ambalabu.jpg");
        gifHash.put("patapim","https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Brr_brr_patapim.jpg/600px-Brr_brr_patapim.jpg?20250425034647");
        gifHash.put("chimpanzini", "https://media.printables.com/media/prints/4263dde6-ad97-47e5-afe7-b4bd01c630fa/images/9757104_47f29df6-e5a7-4de3-b6a6-589bc779b653_134d835e-3960-4c25-8909-cdff6f753fc2/thumbs/inside/1280x960/png/screenshot-2025-05-14-at-221603.webp");
        gifHash.put("bombombini","https://media2.giphy.com/media/v1.Y2lkPTc5MGI3NjExaHBlbWV2dXZsbzBreDhsbWdnbHVuam02NzVxbTlmYmhxdGNzOGM4MSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/2txAUPDUTHutHbylvI/giphy.gif");
        gifHash.put("cappuccino", "https://i.kym-cdn.com/entries/icons/facebook/000/053/991/cappu.jpg");
        gifHash.put("trippi","https://static.wikitide.net/italianbrainrotwiki/5/57/Trippi_Troppi.jpg");
    }

    private void createArraylist(ArrayList<String> triggers){
        triggers.add("tung");
        triggers.add("sahur");
        triggers.add("bombardilo");
        triggers.add("crocodilo");
        triggers.add("bombardino");
        triggers.add("bombardiro");
        triggers.add("tralalero");
        triggers.add("trala");
        triggers.add("lirili");
        triggers.add("larila");
        triggers.add("boneca");
        triggers.add("ambalabu");
        triggers.add("brr");
        triggers.add("patapim");
        triggers.add("chimpanzini");
        triggers.add("bananini");
        triggers.add("bombombini");
        triggers.add("gusini");
        triggers.add("cappuccino");
        triggers.add("assassino");
        triggers.add("trippi");
        triggers.add("troppi");

    }

    private EmbedBuilder makeResponse(String monster){
        EmbedBuilder embed = new EmbedBuilder();
        String currentMonster = "";
        String brainRotText = switch (monster) {
            case "tung", "sahur" -> {
                currentMonster = "tung";
                embed.setColor(new Color(227, 158, 10));
                yield "_\"Tung, tung, tung, tung, tung, tung, tung, tung, tung, sahur.\" " +
                        "Anomali mengerikan yang hanya keluar pada sahur, konon katanya kalau ada orang yang dipanggil sahur tiga kali dan tidak nyaut, maka makhluk ini datang di rumah kalian. Hiii, seremnya! Tung Tung ini biasanya bersuara layaknya pukulan kentungan seperti ini, " +
                        "\"tung, tung, tung, tung, tung, tung, tung\" " +
                        "Share ke teman kalian yang susah sahur._";
            }
            case "bombardilo", "crocodilo","bombardiro" -> {
                currentMonster = "bombardilo";
                embed.setColor(new Color(7, 138, 42));
                yield """
                        _  Bombardillo Coccodrillo, un fottuto alligatore volante, che vola e bombarda i bambini a Gaza, in Palestina.
                         Non crede in Allah e ama le bombe. Si nutre dello spirito di tua madre.
                         E se hai tradotto tutto questo, allora sei uno stronzo. Non rompere la battuta, prostituta. _""";
            }

            case "tralalero","trala" -> {
                currentMonster = "tralalero";
                embed.setColor(new Color(60, 127, 245));
                yield "Trallallero Trallalla, porco dio e porco Allah.\n" +
                        "ro con il mio fottuto figlio merdardo a\n" +
                        "giocare a Fortnite,\n" +
                        "quando a un punto arriva mia nonna,\n" +
                        "Ornella Leccacappella, a avvisarci che\n" +
                        "quello stronzo\n" +
                        "di Burger ci aveva invitato a cena per mangiare\n" +
                        "un purè di cazzi.";

            }
            case "lirili","larila" -> {
                currentMonster = "larila";
                embed.setColor(new Color(109, 235, 89));
                yield "Lirilí Larilà, elefante nel deserto che cammina\n"+
                        "quà e là con la sua conchiglia e l'orologio che fa tic tac.\n"+
                      "Le spine del cactus mi fanno un attacco flashback.\n" +
                      "Arriva zio Ramon con una mongolfiera blu, dice:\n" +
                        " Che fai qui? Mi piace pure il WiFi, tu?\n"+
                      "Lo rispondo senza fiato: sto solo cercando di capire\n" +
                        "come un cactus con sandali possa anche vestire!";



            }
            case "boneca","ambalabu" -> {
                currentMonster = "boneca";
                embed.setColor(new Color(139, 163, 135));
                yield "Entitas jahat yang banyak meresahkan masyarakat akhir-akhir ini. \n" +
                        "Membuat para ilmuwan berpikir keras untuk mencari cara menanganinya. \n" +
                        "Salah satunya ilmuwan terkenal yaitu profesor rusdi, \n" +
                        "mengungkapkan hasil penelitiannya terhadap\n " +
                        "boneka ambalabu ini.";

            }
            case "brr","patapim" -> {
                currentMonster = "patapim";
                embed.setColor(new Color(214, 194, 139));
                yield "Brr brr Patapim, il mio cappello è pieno di Slim! \n" +
                        "Nel bosco fitto e misterioso viveva un essere assai curioso.\n" +
                        " Con radici intrecciate e gambe incrociate,\n" +
                        " mani sottili, braccia agitate. Il suo naso lungo come un prosciutto, \n" +
                        "un po' babbuino, un po' cespugliotto. Si chiamava Patapim, oh che strano,\n" +
                        " e parlava italiano… ma con accento arcano!";

            }
            case "chimpanzini","bananini" -> {
                currentMonster = "chimpanzini";
                embed.setColor(new Color(231, 237, 140));
                yield "Chimpanzini Bananini, \n" +
                        "Wah! Wah! Wah!\n" +
                        "Bananuci, monkey, monkey, monkey, uchi.";

            }
            case "bombombini","gusini" -> {
                currentMonster = "bombombini";
                embed.setColor(new Color(239, 240, 230));
                yield "Bombombini Gusini! Fratello Bombardiro Crocodilo \n" +
                        "che svolge tutte le stesse funzioni \n" +
                        "del fratello e dà bombe alla gente.\n" +
                        " Uno scherzo per chi si è trasferito, \n" +
                        "un georgiano cammina portando 2 angurie sotto le ascelle,\n " +
                        "poi un uomo gli chiede: che ore sono?\n" +
                        "Ascolta tieni l'anguria.\n" +
                        "L'uomo la prese e il georgiano alzando le mani disse,\n" +
                        " come faccio a saperlo?\n";

            }
            case "cappuccino","assassino" -> {
                currentMonster = "cappuccino";
                embed.setColor(new Color(52, 56, 53));
                yield "Capu capu cappuccino, assassino assasini!\n " +
                        "Cappuccini questo killer furtivo si infiltra tra i \n" +
                        "nemici approfittando della notte attento odiatore di caffè.\n" +
                        " senondeiona tastari capuchino alma tino\n" +
                        " amelio noincro charqeusto tidso.\n";

            }
            case "trippi","troppi" -> {
                currentMonster = "trippi";
                embed.setColor(new Color(252, 188, 23));
                yield "Trippi troppi, troppa trippa, \n" +
                        "tre topi trotterellano tra tromboni tritati. \n" +
                        "Triplicando trottoline tropicali. \n" +
                        "E chi troppo vuole, nulla trippa!\n";

            }
            default -> "";
        };


        embed.setDescription(brainRotText);
        embed.setImage(gifHash.get(currentMonster));
        return embed;
    }

}
