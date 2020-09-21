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
import java.util.*;
public class asi extends Application{
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage prim){
        ImageView im = new ImageView("red1.png");
        Group m = new Group(im);
        Circle c1 = new Circle(300,300,50);
        Circle c2 = new Circle(300,300,50);
        Box bb = new Box(100,100,100);
        Rotate rx = new Rotate(0,0,0,0,Rotate.X_AXIS);
        Rotate ry = new Rotate(0,0,0,0,Rotate.Y_AXIS);
        Rotate rz = new Rotate(0,0,0,0,Rotate.Z_AXIS);
        bb.setTranslateX(500);
        bb.setTranslateY(500);
        bb.setTranslateZ(500);
        rx.setAngle(60);
        ry.setAngle(30);
        rz.setAngle(45);
        Shear s = new Shear();
        Polygon pk = new Polygon();
        Polygon pk2 = new Polygon();
        Scale sc = new Scale();
        s.setX(0.2);
        s.setY(0.2);
        s.setPivotX(100);
        s.setPivotY(110);
        pk.getPoints().addAll(new Double[]{
            200.0,50.0,
            300.0,80.0,
            300.0,110.0,
            100.0,110.0,
            100.0,80.0
        });
        pk2.getPoints().addAll(new Double[]{
            200.0,50.0,
            300.0,80.0,
            300.0,110.0,
            100.0,110.0,
            100.0,80.0
        });
        pk2.getTransforms().add(s);
        pk.setFill(Color.YELLOW);
        sc.setX(2);
        sc.setY(2);
        sc.setPivotX(300);
        sc.setPivotY(300);
        c1.setFill(Color.RED);
        c2.setFill(Color.BLUE);
        c2.getTransforms().add(sc);
        bb.getTransforms().addAll(rx,ry,rz);
        Scene scen = new Scene(m,720,480);
        Rotate ro = new Rotate();
        ro.setAngle(90);
        ro.setPivotX(50);
        ro.setPivotY(50);
        im.getTransforms().add(ro);
        m.getChildren().addAll(c2,c1,pk,pk2,bb);
        prim.setScene(scen);
        prim.show();
    }
}