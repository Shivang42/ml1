import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Mlak extends Application{
    @Override
    public void start(Stage prim) throws Exception {
        Group group1 = new Group();
        Scene scen1 = new Scene(group1,1280,1024);
        scen1.setFill(Color.RED);
        prim.setTitle("It has begun,man");
        prim.setScene(scen1);
        prim.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}