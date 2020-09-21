import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.io.*;

public class threed extends Application{
    public void start(Stage prim1){
        prim1.setTitle("Location");
        WebView wv = new WebView();
        WebEngine we = wv.getEngine();
        we.setJavaScriptEnabled(true);
        we.load("http://localhost:8080/y.html");
        Scene s1 = new Scene(wv,480,320,Color.web("#666970"));
        prim1.setScene(s1);
        System.out.println("hey hey hey 1st");
        prim1.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}