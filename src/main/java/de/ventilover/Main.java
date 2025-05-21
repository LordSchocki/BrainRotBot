package de.ventilover;

import net.dv8tion.jda.api.JDA;



public class Main {
    public static JDA api;

    public static void main(String[] args) {
        StartUp start = new StartUp();
        try {
            start.startBot();
        } catch (InterruptedException e) {
            System.out.println("IO EXCEPTION"+ e.getMessage()+e.getCause());
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.out.println(e.getCause() + e.getMessage() + "Interrupted Exception !");
        }

    }
}