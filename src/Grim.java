import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.Group;
import javafx.collections.ObservableList;

public class Grim extends Application{
    @Override
    public void start(Stage gorm) throws Exception {
        Line line1 = new Line();
        Line line2 = new Line();
        line1.setStartX(0.0);
        line1.setStartY(0.0);
        line1.setEndX(720.0);
        line1.setEndY(480.0);
        line2.setStartX(0.0);
        line2.setStartY(480.0);
        line2.setEndX(720.0);
        line2.setEndY(0.0);
        Text text1 = new Text();
        text1.setFont(new Font(45));
        text1.setX(250);
        text1.setY(240);
        text1.setText("This is a cross");
        Group gh = new Group();
        ObservableList list = gh.getChildren();
        list.add(line1);
        list.add(line2);
        list.add(text1);
        Scene s1 = new Scene(gh,720,480);
        s1.setFill(Color.RED);
        gorm.setTitle("Shit");
        gorm.setScene(s1);
        gorm.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}