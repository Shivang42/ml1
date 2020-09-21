import javafx.scene.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.event.*;
import javafx.collections.*;
import javafx.beans.value.*;
import javafx.scene.effect.*;
import javafx.scene.transform.*;

public class buttons extends Application{
    TextField tf;
    Label l11  = new Label("Nothing much");

    public void start(Stage primstage){
        primstage.setTitle("CALNI");
        FlowPane rootnode = new FlowPane();
        rootnode.setAlignment(Pos.CENTER);
        Scene ascene = new Scene(rootnode,360,360);
        primstage.setScene(ascene);
        Canvas c1 = new Canvas(360,360);
        GraphicsContext g1 = c1.getGraphicsContext2D();
        g1.setFill(Color.GREY);
        Button but = new Button("");
        but.setGraphic(new ImageView(new Image("butn.jpg")));
        ToggleGroup tg = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Linguistics");
        RadioButton rb2 = new RadioButton("Memetics");
        RadioButton rb3 = new RadioButton("Sociology");
        ObservableList<String> trans = FXCollections.observableArrayList("It","The Stand","The Shining");
        ListView<String> lv = new ListView<String>(trans);
        lv.setPrefSize(80,80);
        MultipleSelectionModel<String> mv = lv.getSelectionModel();
        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        mv.selectedItemProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue <? extends String> changed,String old,String new1){
                String msg = "";
                ObservableList<String> selected = lv.getSelectionModel().getSelectedItems();
                for (int i = 0;i<selected.size();i++){
                    msg+="\n"+selected.get(i);
                }
                l11.setText("The following books are good: \n"+msg);
            }
        });
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb3.setToggleGroup(tg);
        Separator s1 = new Separator();
        s1.setPrefWidth(360);
        Separator s2 = new Separator();
        s2.setPrefWidth(360);
        Separator s3 = new Separator();
        s3.setPrefWidth(360);
        ObservableList<String> eps = FXCollections.observableArrayList("DJI","S&P","BN");
        ComboBox cb1 = new ComboBox<String>(eps);
        cb1.setValue("S&P");
        cb1.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                l11.setText("The index is: "+cb1.getValue());
            }
        });
        cb1.setEditable(true);
        rb1.setSelected(true);
        tf = new TextField();
        tf.setPromptText("Enter Search Item");
        tf.setPrefColumnCount(10);
        tf.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                l11.setText("Search String: "+tf.getText());
            }
        });
        tf.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                l11.setText("Search String: "+tf.getText());
            }
        });
        Label l2 = new Label("a\n\n\n\n\n\n\n\n\n\n\n\n");
        ScrollPane sp = new ScrollPane(l2);
        sp.setPrefViewportHeight(10);
        sp.setPrefViewportWidth(20);
        sp.setPannable(true);
        ObservableList<Transform> k = l11.getTransforms();
        ObservableList<Transform> k2 = sp.getTransforms();
        InnerShadow is1 = new InnerShadow(5,Color.RED);
        Rotate r = new Rotate(180,10,10);
        Scale s01 = new Scale(3,2);
        but.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                RadioButton rb = (RadioButton) tg.getSelectedToggle();
                l11.setText("Been reading about "+rb.getText()+"\n"+tf.getText());
                is1.setColor(Color.GREEN);
                k.add(r);
                k2.add(s01);
            }
        });
        Separator s4 = new Separator();
        s4.setPrefWidth(360);
        Button b2 = new Button("Reset");
        Glow glow2 = new Glow(0.4);
        b2.setEffect(glow2);
        l11.setEffect(is1);
        b2.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                if (but.isDisable()){
                    but.setDisable(false);
                }
                sp.setVvalue(0);
                sp.setHvalue(0);
                glow2.setLevel(0.8);
                but.setDisable(true);
            }
        });
        b2.setTooltip(new Tooltip("Reset everything man"));
        rootnode.getChildren().addAll(rb1,rb2,rb3,cb1,tf,s1,but,b2,s2,l11,s3,lv,sp,s4);
        primstage.show();
    }
}