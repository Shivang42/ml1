import javafx.stage.*;
import javafx.scene.*;
import javafx.animation.*;
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
import javafx.util.Duration;
import javafx.scene.chart.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.css.*;


public class queen extends Application{
    public static void helk(String[] args){
        launch(args);
    }
    public void start(Stage stim){
        Group g1 = new Group();
        Button b1 = new Button("Go");
        /*
        NumberAxis y = new NumberAxis(0,10,2);
        NumberAxis x = new NumberAxis(1995,2020,5);
        StackedAreaChart<String,Number> ac = new StackedAreaChart(x,y);
        XYChart.Series ser1 = new XYChart.Series();
        ser1.getData().add(new XYChart.Data(1997,7.9));
        ser1.getData().add(new XYChart.Data(1999,8));
        ser1.getData().add(new XYChart.Data(2002,7.3));
        ser1.getData().add(new XYChart.Data(2007,8.2));
        ser1.getData().add(new XYChart.Data(2012,7.2));
        XYChart.Series ser2 = new XYChart.Series();
        ser2.getData().add(new XYChart.Data(2000,8.4));
        ser2.getData().add(new XYChart.Data(2002,7.2));
        ser2.getData().add(new XYChart.Data(2008,9));
        ser2.getData().add(new XYChart.Data(2010,8.8));
        ser2.getData().add(new XYChart.Data(2017,7.9));
        ser1.setName("Paul Thomas Anderson");
        ser2.setName("Christopher Nolan");
        ac.getData().addAll(ser1,ser2);
        ac.setTitle("PTA V/S Nolan");
        CategoryAxis xaxis = new CategoryAxis();
        xaxis.setCategories(FXCollections.<String>observableArrayList("CPU","GPU","Cost"));
        NumberAxis yaxis = new NumberAxis(0,100,10);
        xaxis.setLabel("Companies");
        yaxis.setLabel("Rating");
        StackedBarChart<String,Number> bc = new StackedBarChart(xaxis,yaxis);
        XYChart.Series<String,Number> seri1 = new XYChart.Series();
        seri1.getData().add(new XYChart.Data("CPU",95));
        seri1.getData().add(new XYChart.Data("GPU",70));
        seri1.getData().add(new XYChart.Data("Cost",70));
        seri1.setName("Intel");
        XYChart.Series<String,Number> seri2 = new XYChart.Series();
        seri2.getData().add(new XYChart.Data("CPU",5));
        seri2.getData().add(new XYChart.Data("GPU",100));
        seri2.getData().add(new XYChart.Data("Cost",60));
        seri2.setName("Nvidia");
        XYChart.Series<String,Number> seri3 = new XYChart.Series();
        seri3.getData().add(new XYChart.Data("CPU",90));
        seri3.getData().add(new XYChart.Data("GPU",88));
        seri3.getData().add(new XYChart.Data("Cost",100));
        seri3.setName("AMD");
        bc.getData().addAll(seri1,seri2,seri3);
        NumberAxis xa = new NumberAxis(0,100,10);
        NumberAxis ya = new NumberAxis(0,100,10);
        xa.setLabel("Rotten Tomatoes");
        ya.setLabel("Metacritic");
        BubbleChart bbc = new BubbleChart(xa,ya);
        XYChart.Series se1 = new XYChart.Series();
        se1.getData().add(new XYChart.Data(30,30,10));
        se1.getData().add(new XYChart.Data(50,60,6));
        se1.getData().add(new XYChart.Data(85,90,15));
        se1.setName("IMDB");
        bbc.getData().add(se1);
        bc.setTranslateX(300);
        bc.setTranslateY(300);
        VBox  hb = new VBox();
        TextField tf = new TextField();
        Button b1 = new Button("Go");
        Button b2 = new Button("Stop");
        Circle cc = new Circle(100,100,100);
        Sphere sp = new Sphere(50);
        cc.setFill(Color.RED);
        hb.setSpacing(20);
        hb.setMargin(tf,new Insets(30,30,30,30));
        hb.setMargin(b1,new Insets(30,30,30,30));
        hb.setMargin(b2,new Insets(30,30,30,30));
        BorderPane bp1 = new BorderPane();
        StackPane spa = new StackPane();
        AnchorPane ap1 = new AnchorPane();
        spa.setMargin(cc,new Insets(20,20,20,20));
        Label l1 = new Label("Top");
        Label l2 = new Label("Bottom");
        Label l3 = new Label("Left");
        Label l4 = new Label("Right");
        Label l5 = new Label("Center");
        l1.setTranslateY(10);
        l2.setTranslateY(20);
        l3.setTranslateY(30);
        ap1.setLeftAnchor(l1,10.0);
        ap1.setLeftAnchor(l2,10.0);
        ap1.setLeftAnchor(l3,10.0);
        bp1.setTop(l1);
        bp1.setBottom(l2);
        bp1.setLeft(l3);
        bp1.setRight(l4);
        bp1.setCenter(l5);
        hb.getChildren().addAll(tf,b1,b2);
        spa.getChildren().addAll(cc,sp,l1);
        ap1.getChildren().addAll(l1,l2,l3);
        TilePane tp = new TilePane();
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(10);
        gp.setHgap(3);
        gp.setPadding(new Insets(20,20,20,20));
        gp.add(new Text("A"),0,0);
        gp.add(new Button(),1,0);
        gp.add(new Text("C"),0,1);
        gp.add(new Button(),1,1);
        gp.add(new Text("E"),0,2);
        gp.add(new Button(),1,2);
        tp.setTileAlignment(Pos.CENTER);
        tp.setOrientation(Orientation.VERTICAL);
        tp.setPrefHeight(40);
        tp.setPrefWidth(40);
        tp.setPrefColumns(4);
        tp.setVgap(4);
        Button[] bm = new Button[]{
            new Button("1"),
            new Button("2"),
            new Button("3"),
            new Button("4"),
            new Button("5"),
            new Button("6")
        };
        tp.getChildren().addAll(bm);
        */
        Circle c1 = new Circle(50,50,30);
        Text t = new Text("LOCK");
        t.setTranslateX(36.0);
        t.setTranslateY(52.0);
        t.setFill(Color.WHITE);
        c1.setStrokeWidth(10);
        c1.setStroke(Color.BLACK);
        c1.setFill(Color.RED);
        g1.getChildren().addAll(c1,t,b1);
        g1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                if(t.getText()=="Unlocked"){
                t.setText("Locked");
                }
                else{
                    t.setText("Unlocked");
                }
            }
        });
        g1.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                c1.setFill(Color.BLUE);
            }
        });
        g1.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                c1.setFill(Color.RED);
            }
        } );
        Scene s1 = new Scene(g1);
        s1.getStylesheets().add("m.css");
        stim.setTitle("Testing");
        stim.setScene(s1);
        stim.show();
    }
}


