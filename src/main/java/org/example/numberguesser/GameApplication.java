package org.example.numberguesser;

import javafx.application.Application;
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
        // 2. Conception de l'interface
        //Prompt
        Label inviteDeSaisie = new Label("Veuillez saisir votre proposition entre 1 et 10");
        // Champ input
        TextField champARemplir = new TextField();
        //button de validation de la saisie
        Button btnValider = new Button("Valider");
        //Feedback
        Label retourUtilisateur = new Label();

        Button btnRestart = new Button("restart");
        btnRestart.setVisible(false);

        //boite Colonne verticale avec 8 d'espace
        VBox layout = new VBox(8);
        //Ajout des composants dans la boite verticale
        layout.getChildren().addAll(inviteDeSaisie,champARemplir, btnValider,retourUtilisateur,btnRestart);

        //alignement de tous les elements au centre
        layout.setAlignment(CENTER);

        // 2. Création de la Scene (attachement du nœud racine + dimensions)
        Scene scene = new Scene(layout, 400, 400);

        // 3. Attachement de la Scene au Stage
        primaryStage.setScene(scene);

        //Affichage de la scene de theatre
        primaryStage.show();

        btnValider.setOnAction(e -> {
            //On recupere la reponse text qu'on converti en int
            int reponse = Integer. parseInt(champARemplir.getText());

            //Verification des limites
            if (reponse > 10 || reponse < 1){
                retourUtilisateur.setText("Le nombre doit etre compris entre 1 et 10");
            }
            //l'utilisateur a rentré un nombre valide
            else{
                //on incremente de 1 le nombre d'essais
                nombreEssai++;
                //si la reponse est trop grande
                if(reponse > nombreATrouver){
                    //on change le texte du label
                    retourUtilisateur.setText("Trop grand");
                }
                //si la reponse est trop petite
                else if(reponse < nombreATrouver){
                    //on change le texte du label
                    retourUtilisateur.setText("Trop petit");
                }
                //si la reponse est juste
                else{
                    //on change le texte du label avec le nombre d'essais
                    retourUtilisateur.setText("BRAVO, trouvé en "+ nombreEssai + " essais");

                    //empeche de cliquer sur valider à la fin du jeu
                    btnValider.setVisible(false);
                    champARemplir.setVisible(false);
                    inviteDeSaisie.setText("voulez vous rejouer ?");

                    //affichage du bouton restart
                    btnRestart.setVisible(true);

                }
                //effacer le champ à remplir
                champARemplir.clear();
            }
        });



        btnRestart.setOnAction(e -> {
            nombreEssai = 0;
            nombreATrouver = new Random().nextInt(1,11) ;
            btnValider.setVisible(true);
            champARemplir.setVisible(true);
            inviteDeSaisie.setText("Veuillez saisir votre proposition entre 1 et 10");
            retourUtilisateur.setText("");
            btnRestart.setVisible(false);
        });
    }
}