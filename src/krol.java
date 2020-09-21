import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class krol extends Application{
    Label response;
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage astage){
        astage.setTitle("Something good");
        FlowPane rootnode = new FlowPane(25,25);
        rootnode.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(rootnode,720,720);
        astage.setScene(scene1);
        response = new Label("Press buttons");
        Button b1 = new Button("Mulder");
        Button b2 = new Button("Scully");
        b1.setOnAction((ea) ->
        response.setText("Mulder is believer.")
        );
        b2.setOnAction((ea) ->
        response.setText("Skully is sceptic")
        );
        rootnode.getChildren().addAll(b1,b2,response);
        astage.show();
    }
}