package org.example.numberguesser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static javafx.geometry.Pos.*;

public class GameApplication extends Application {

    // 1. Declaration des variables
    //nombre d'essais
    private int nombreEssai = 0;

    //nombre à trouver (entre 1 et 10)
    private int nombreATrouver = new Random().nextInt(1,11) ;

    //L'utilisateur a-t-il trouvé le nombre ?
    boolean trouve = false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
         * 1. Initialiser le loader FXML
         */
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("home-view.fxml"));

        /*
         * 2. Initialiser la scène
         */
        var scene = new Scene(fxmlLoader.load(), 300, 400);

        // 3. Attachement de la Scene au Stage
        primaryStage.setScene(scene);

        //Affichage de la scene de theatre
        primaryStage.show();

    }
}