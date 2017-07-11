package com.mycompany.coffeeandybot;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.telegram.telegrambots.*;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class Main {
    // Esta estructura es fija y no debe cambiarse
    public static void main(String[] args) {
        // Inicializamos el API Context
        ApiContextInitializer.init();
        // Creamos el objeto Bot Api que manejará nuestro bot
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            // Aqui registramos nuestro bot
            botsApi.registerBot(new CoffeeAndyBot());
        } catch (TelegramApiRequestException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
