package de.ventilover;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

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
                monsters.add(monster);
            }
        }
        return monsters;

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        super.onMessageReceived(event);
        if (isBrainRotMessage(event)){
            String message = event.getMessage().getContentRaw();
            ArrayList<String> messageMonsters = getMonster(message.toLowerCase());
            for (String monster : messageMonsters){
                event.getChannel().sendMessage(makeResponse(monster)).queue();
            }

        }
    }

    private boolean isBrainRotMessage(MessageReceivedEvent event){
        if (event.isFromGuild()){
            String message = event.getMessage().getContentRaw();
            return triggers.contains(message.toLowerCase());
        }
        else{
            return false;
        }
    }

private void createGifHashMap(HashMap<String,String> gifHash){
        gifHash.put("tung","https://tenor.com/en-GB/view/tung-tungtung-tungtungtung-sahur-tungtungtungsahur-tungtungsahur-gif-6699270143817937548");
        gifHash.put("sahur","https://tenor.com/en-GB/view/tung-tungtung-tungtungtung-sahur-tungtungtungsahur-tungtungsahur-gif-6699270143817937548");


    }

    private void createArraylist(ArrayList<String> triggers){
        triggers.add("tung");
        triggers.add("sahur");
        triggers.add("bombardilo");
        triggers.add("crocodilo");
    }

    private String makeResponse(String monster){
        String currentMonster = "";
        String brainRotText = "";
        switch (monster){
            case "tung", "sahur":
                currentMonster = "tung";
                brainRotText = "_\"Tung, tung, tung, tung, tung, tung, tung, tung, tung, sahur.\" " +
                        "Anomali mengerikan yang hanya keluar pada sahur, konon katanya kalau ada orang yang dipanggil sahur tiga kali dan tidak nyaut, maka makhluk ini datang di rumah kalian. Hiii, seremnya! Tung Tung ini biasanya bersuara layaknya pukulan kentungan seperti ini, " +
                        "\"tung, tung, tung, tung, tung, tung, tung\" " +
                        "Share ke teman kalian yang susah sahur._";
                break;
            case "bombardilo", "crocodilo":
                currentMonster = "bombardilo";
                brainRotText = "_  Bombardillo Coccodrillo, un fottuto alligatore volante, che vola e bombarda i bambini a Gaza, in Palestina." + "\n" +
                        " Non crede in Allah e ama le bombe. Si nutre dello spirito di tua madre." + "\n" +
                        " E se hai tradotto tutto questo, allora sei uno stronzo. Non rompere la battuta, prostituta. _";
                break;
        }
        return gifHash.get(currentMonster) + "\n" + brainRotText;
    }

}
