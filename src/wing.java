import javafx.stage.*;
import javafx.scene.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.chart.*;
import javafx.collections.*;

public class wing extends Application{
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage ps) throws FileNotFoundException{
        ps.setTitle("Colors,Omar");
        Text text = new Text("Best Not Miss");
        text.setX(0);
        text.setY(30);
        text.setFont(Font.font("Calibri",30));
        Circle c1 = new Circle(300,300,108.5);
        c1.setStrokeWidth(2.5);
        Stop[] ss = new Stop[]{
            new Stop(0.0,Color.WHITE),
            new Stop(0.5,Color.GREEN),
            new Stop(1.0,Color.DARKGREEN)
        };
        Stop[] ss2 = new Stop[]{
            new Stop(0,Color.RED),
            new Stop(1.0,Color.YELLOW)
        };
        RadialGradient rg = new RadialGradient(0,0,80,90,28,false,CycleMethod.NO_CYCLE,ss);
        LinearGradient lg = new LinearGradient(0,0,1,0,true,CycleMethod.NO_CYCLE,ss2);
        FileInputStream min = new FileInputStream("C:\\yellow1.jpg");
        Image fis = new Image(min);
        int width = (int)fis.getWidth();
        int height = (int)fis.getHeight();
        /*
        WritableImage wi = new WritableImage(width,height);
        PixelReader pi = fis.getPixelReader();
        PixelWriter pw = wi.getPixelWriter();
        for(int x = 0;x<width;x++){
            for(int y = 0;y<height;y++){
                pw.setColor(x,y,Color.WHITE);
            }
        }
        int k = 50;
        for(int x = 0;x<width-k;x++){
            for(int y = 0;y<height-k;y++){
                Color col = pi.getColor(x,y);
                pw.setColor(x+k,y+k,col.invert());
            }
        }
        ImagePattern ip = new ImagePattern(wi,187.5,187.5,225,225,false);
        c1.setFill(ip);
        */
        c1.setFill(Color.YELLOW);
        Sphere sph = new Sphere();
        PhongMaterial pm = new PhongMaterial();
        pm.setBumpMap(new Image("wood.jpg"));
        pm.setDiffuseColor(Color.BROWN);
        sph.setMaterial(pm);
        sph.setRadius(50);
        sph.setTranslateX(400);
        sph.setTranslateY(470);
        sph.setCullFace(CullFace.BACK);
        text.setFill(lg);
        ObservableList<PieChart.Data> pcd = FXCollections.observableArrayList(
            new PieChart.Data("Doctor Who",20),
            new PieChart.Data("Star Trek",17),
            new PieChart.Data("Firefly",16),
            new PieChart.Data("Battlestar Galactica",19),
            new PieChart.Data("The Expanse",16),
            new PieChart.Data("StarGate",12)
        );
        PieChart pcc = new PieChart(pcd);
        NumberAxis xaxis = new NumberAxis(0,100,10);
        xaxis.setLabel("Book copies");
        NumberAxis yaxis = new NumberAxis(0,1700,170);
        yaxis.setLabel("Total Cost");
        XYChart.Series xs = new XYChart.Series();
        xs.getData().add(new XYChart.Data(10,180));
        xs.getData().add(new XYChart.Data(30,360));
        xs.getData().add(new XYChart.Data(50,480));
        xs.getData().add(new XYChart.Data(70,600));
        xs.getData().add(new XYChart.Data(90,720));
        LineChart xy = new LineChart(xaxis,yaxis);
        xy.getData().add(xs);
        xy.setTranslateX(600);
        xy.setTranslateY(450);
        xy.setTitle("Omar Coming");
        pcc.setTitle("Greatest Scifi TV");
        pcc.setTranslateX(600);
        pcc.setTranslateY(10);
        Group g1 = new Group(text,c1,sph,pcc,xy);
        Scene sc = new Scene(g1,720,480);
        ps.setScene(sc);
        ps.show();

    }
}