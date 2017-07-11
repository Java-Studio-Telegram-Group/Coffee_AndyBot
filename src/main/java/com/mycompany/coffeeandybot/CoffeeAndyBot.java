/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.coffeeandybot;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 *
 * @author turi
 */
public class CoffeeAndyBot extends TelegramLongPollingBot {

    // Este método debe devolver el token de nuestro bot para que 
    // conecte de manera correcta con telegram y pueda manejar los mensajes
    @Override
    public String getBotToken() {
        return "TOKEN-BOT";
    }

    // En este metodo va toda la logica del bot. Es donde nuestro bot
    // maneja los mensajes que lee y actua en funcion de lo que programemos.
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            System.out.println(message);
            List<User> newUsers = update.getMessage().getNewChatMembers();
            if (newUsers != null) {
                String welcomeMessage = "Bienvenido al grupo Java Studio: ";

                for (User newUser : newUsers) {
                    String user = newUser.getUserName().equals("null") ? newUser.getFirstName()
                            : "@" + newUser.getUserName();
                    welcomeMessage += user + " ";
                }
                SendMessage welcomeSendMessage = new SendMessage()
                        .setChatId(message.getChatId())
                        .setText(welcomeMessage);
                try {
                    sendMessage(welcomeSendMessage);
                } catch (TelegramApiException ex) {
                    Logger.getLogger(CoffeeAndyBot.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    @Override
    public String getBotUsername() {
        return "Coffee_AndyBot";
    }

    @Override
    public void onClosing() {
        super.onClosing(); //To change body of generated methods, choose Tools | Templates.
    }

}
