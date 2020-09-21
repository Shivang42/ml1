import javafx.stage.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.application.*;
import javafx.scene.image.*;
import javafx.scene.canvas.*;
import javafx.scene.shape.*;
import javafx.scene.transform.*;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.event.*;
public class man extends Application{
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage prim){
        Button b1 = new Button();
        b1.setGraphic(new ImageView("red1.png"));
        b1.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                /*
                RotateTransition rt = new RotateTransition();
                rt.setByAngle(360);
                rt.setCycleCount(1);
                rt.setNode(b1);
                rt.setAutoReverse(true);
                rt.setDuration(Duration.millis(1500));
                rt.play();
                ScaleTransition st = new ScaleTransition();
                st.setCycleCount(1);
                st.setNode(b1);
                st.setDuration(Duration.millis(1000));
                st.setByX(0.5);
                st.setByY(0.5);
                st.play();
                */
                TranslateTransition tt = new TranslateTransition();
                tt.setByX(60);
                tt.setByY(60);
                tt.setNode(b1);
                tt.setAutoReverse(false);
                tt.setDuration(Duration.millis(1000));
                tt.play();
                b1.setGraphic(new ImageView("green1.jpg"));

            }
        });
        b1.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                b1.setGraphic(new ImageView("blue1.png"));
            }
        });
        b1.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                b1.setGraphic(new ImageView("red1.png"));
            }
        });
        Circle co = new Circle(400,400,40);
        Path path = new Path();
        MoveTo mt = new MoveTo(400,400);
        CubicCurveTo cct = new CubicCurveTo(400,400,700,700,1000,100);
        PathTransition ppt = new PathTransition();
        StrokeTransition ft = new StrokeTransition();
        PauseTransition ptr = new PauseTransition();
        ptr.setDuration(Duration.millis(2000));
        ft.setFromValue(Color.RED);
        ft.setToValue(Color.BLUE);
        ft.setDuration(Duration.millis(3000));
        ft.setShape(co);
        path.getElements().addAll(mt,cct);
        ppt.setPath(path);
        ppt.setNode(co);
        ppt.setDuration(Duration.millis(3000));
        ppt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        ParallelTransition ptt = new ParallelTransition(co,ppt,ft);
        SequentialTransition stt = new SequentialTransition(co,ppt,ptr,ft);
        stt.play();
        
        co.setStrokeWidth(10);
        co.setFill(Color.BLACK);
        co.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                StrokeTransition ft = new StrokeTransition();
                ft.setFromValue(Color.RED);
                ft.setToValue(Color.BLUE);
                ft.setDuration(Duration.millis(100));
                ft.setShape(co);
                ft.play();
            }
        });
        co.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                StrokeTransition ft = new StrokeTransition();
                ft.setFromValue(Color.BLUE);
                ft.setToValue(Color.RED);
                ft.setDuration(Duration.millis(100));
                ft.setShape(co);
                ft.play();
            }
        });
        Group m = new Group(b1,co);
        Scene scen = new Scene(m,1080,720);
        prim.setScene(scen);
        prim.show();
    }
}