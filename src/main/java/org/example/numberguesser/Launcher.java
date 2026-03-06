package org.example.numberguesser;

import javafx.application.Application;

import java.util.Random;

public class Launcher {
    public static void main(String[] args){
        //lancement de notre application (méthode statique)
        Application.launch(GameApplication.class, args);
    }
}
