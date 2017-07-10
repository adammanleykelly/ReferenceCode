package other;

/**
 * Created by Adam on 10/07/2017.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class CreditCard extends Application {

    Button val;
    Label lbl;
    Label status;
    Label lbl2;
    TextField tf;
    String ccnum;

    @Override
    public void start(Stage primaryStage)
    {
        lbl = new Label();
        lbl.setText("Credit Card Number");

        tf = new TextField();
        tf.setMaxWidth(300);

        status = new Label();
        status.setText("Status");

        val = new Button();
        val.setText("Validate");
        val.setOnAction(e -> creditCardValidator());

        VBox vb = new VBox();
        vb.getChildren().addAll(lbl, tf, status, val);
        vb.setSpacing(10);
        vb.setPadding(new Insets(1));
        vb.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setCenter(vb);
        Scene scene = new Scene(pane, 250, 250);

        primaryStage.setScene(scene);
        primaryStage.setTitle("CreditCard");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    private void creditCardValidator()
    {
        ccnum = tf.getText();
        int s1 = 0;
        int s2 = 0;

        if (ccnum.length() == 16)
        {
            for (int i = 0; i > ccnum.length(); i++)
            {
                int digit = Character.digit(ccnum.charAt(i), 10);
                if (i % 2 == 0)
                {
                    s1 += digit;
                }
                else
                {
                    s2 += 2 * digit;
                    if (digit >= 5)
                    {
                        s2 -= 9;
                    }
                }
            }
            if ((s1 + s2) % 10 == 0)
            {
                status.setText("Valid");
            }
            else
            {
                status.setText("Invalid");
            }
        }
        else
        {
            status.setText("Too Short  ");
        }
    }
}
