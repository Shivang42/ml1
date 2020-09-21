import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.scene.control.*;

public class shapes extends Application{
    public static void main(String[] args){
        launch(args);
    }
    Color[] colors = {Color.RED,Color.YELLOW,Color.GREEN};
    int num = 0;
    int RAD = 50;
    int X = 360;
    int Y = 100;
    public void start(Stage mintstage){
        mintstage.setTitle("Pablo");
        FlowPane rootnode = new FlowPane(20,20);
        rootnode.setAlignment(Pos.CENTER);
        Scene scen1 = new Scene(rootnode,720,480);
        mintstage.setScene(scen1);
        Canvas canv = new Canvas(720,480);
        GraphicsContext somegc = canv.getGraphicsContext2D();
        Button b1 = new Button("Change Color");
        b1.setOnAction( (ea) ->{
        switch(num){
            case 0:
                somegc.setFill(colors[0]);
                somegc.fillOval(X,Y,RAD,RAD);
                somegc.setFill(Color.WHITE);
                somegc.fillOval(X,Y+52,RAD,RAD);
                somegc.fillOval(X,Y+104,RAD,RAD);
                break;
            case 1:
                somegc.setFill(Color.WHITE);
                somegc.fillOval(X,Y,RAD,RAD);
                somegc.setFill(colors[1]);
                somegc.fillOval(X,Y+52,RAD,RAD);
                somegc.setFill(Color.WHITE);
                somegc.fillOval(X,Y+104,RAD,RAD);
                break;
            case 2:
                somegc.setFill(Color.WHITE);
                somegc.fillOval(X,Y,RAD,RAD);
                somegc.fillOval(X,Y+52,RAD,RAD);
                somegc.setFill(colors[2]);
                somegc.fillOval(X,Y+104,RAD,RAD);
                break;
        }
        num++;
        if (num==colors.length) num = 0;
        }
        );
        somegc.setFill(Color.WHITE);
        somegc.strokeRect(X-2,Y-2,54,162);
        somegc.fillOval(X,Y,RAD,RAD);
        somegc.fillOval(X,Y+52,RAD,RAD);
        somegc.fillOval(X,Y+104,RAD,RAD);
        rootnode.getChildren().addAll(b1,canv);
        mintstage.show();
    }
}