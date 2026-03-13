package org.example.numberguesser;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class HomeController {
    @FXML
    private Label promptLabel;
    @FXML
    private Label feedbackLevel;
    @FXML
    private TextField inputField;
    @FXML
    private Button guessButton;
    @FXML
    private Button restartBtn;

    private int magicNumber;
    private int numberOfTries;


    @FXML
    private void initialize() {
        // Création du nombre à trouver
        Random random = new Random();
        this.magicNumber = random.nextInt(10) + 1;
        guessButtonDefault();
    }

    @FXML
    private void handleGuessing() {
        String input = inputField.getText();
        int guessed = Integer.parseInt(input);
        this.numberOfTries++;

        if (guessed < magicNumber) {
            feedbackLevel.setText("Trop bas !");
        } else if (guessed > magicNumber) {
            feedbackLevel.setText("Trop haut !");
        } else {
            feedbackLevel.setText("Bravo ! Nombre d'essais : " + this.numberOfTries);
            // re-init
            this.initialize();
            restartBtn.setVisible(true);
            guessButton.setVisible(false);
            restartBtnDefault();
        }
        // effacer l'input field
        inputField.clear();
    }

    @FXML
    private void restart(){
        feedbackLevel.setText("");
        restartBtn.setVisible(false);
        guessButton.setVisible(true);
        guessButtonDefault();
    }

    private void restartBtnDefault(){
        guessButton.setDefaultButton(false);
        restartBtn.setDefaultButton(true);
    }

    private void guessButtonDefault(){
        guessButton.setDefaultButton(true);
        restartBtn.setDefaultButton(false);
    }
}