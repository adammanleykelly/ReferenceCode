package guess;

/**
 * Created by Adam on 10/07/2017.
 */
import javafx.scene.*;
import javafx.event.*;
import javafx.scene.text.*;//font
import javafx.scene.layout.*;//HBox
import javafx.scene.control.*;//label
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.TilePane;//tilepane layout

public class GuessFx extends Application
{
    //@Override
    public void start(Stage primaryStage)
    {
        final int rand=(int)(Math.random()*100);
        //Creating label Guess my number text
        //Label label1 =new Label("Guess my number game");
        // label1.setFont(new Font("Arial",24));

        //Creating label Enter a number.....
        // Label label2=new Label("Enter a number b/w 1-100");
        //label2.setFont(new Font("Arial",17));

        //Lives
        Label labelLives = new Label("Lives");
        labelLives.setFont(new Font("Arial",17));

        final Label lives = new Label("5");
        lives.setFont(new Font("Arial",17));

        //Creating TextField for input guess
        Label yourLabel = new Label("Your Guess");
        final TextField t1 =new TextField();
        HBox hb = new HBox();
        hb.getChildren().addAll(yourLabel, t1);
        hb.setSpacing(10);

        //Creating Label for Display message
        final Label label3=new Label("Try and guess my number");
        label3.setFont(new Font("Arial",17));

        //creating 2 buttons
        Button b1=new Button("Guess");
        b1.setOnAction(new EventHandler<ActionEvent>()
                       {

                           public void handle(ActionEvent event)
                           {
                               int a = Integer.parseInt(t1.getText());
                               int iLives = Integer.parseInt(lives.getText());;
                               if(a<rand)
                               {
                                   if(iLives ==0)
                                   {
                                       label3.setText("Game Over");
                                   }
                                   else
                                   {
                                       label3.setText(a+" is too low, try again!!");
                                       iLives--;
                                   }
                               }
                               else if(a>rand)
                               {
                                   if(iLives ==0)
                                   {
                                       label3.setText("Game Over");
                                   }
                                   else
                                   {
                                       label3.setText(a+" is too high, try again!!");
                                       iLives--;
                                   }
                               }
                               else if(iLives == 0)
                               {
                                   label3.setText("Game Over");
                               }
                               else
                               {
                                   label3.setText("CORRECT, YOU WIN!!!!");
                                   iLives++;
                               }
                               String str = Integer.toString(iLives);
                               lives.setText(str);
                           }
                       }
        );

        Button b2=new Button("Play Again");
        b2.setOnAction(new EventHandler<ActionEvent>()

                       {
                           public void handle(ActionEvent event)
                           {
                               //Reset Lives to 5
                               //Takes lives and converts value to int(iLives)
                               int iLives = Integer.parseInt(lives.getText());;
                               if(iLives != 5)
                               {
                                   iLives = iLives+5;
                               }
                               //Converts iLives back to String(str)
                               String str = Integer.toString(iLives);
                               lives.setText(str);
                               //Resets Random Number between 1-100
                               int rand=(int)(Math.random()*100);
                               t1.setText("");
                               label3.setText("Try and guess my number");
                           }
                       }
        );

        HBox buttons = new HBox();
        buttons.getChildren().addAll(b1,b2);
        buttons.setSpacing(10);
        //Place the components in the pane
        TilePane root = new TilePane();
        //root.getChildren().add(label1);
        //root.getChildren().add(label2);
        root.getChildren().add(label3);
        root.getChildren().add(labelLives);
        root.getChildren().add(lives);
        root.getChildren().add(hb);
        root.getChildren().add(buttons);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Guessing Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}