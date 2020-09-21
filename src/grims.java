import javafx.scene.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.event.*;
import javafx.beans.value.*;

public class grims extends Application{
    public static void main(String[] args){
        launch(args);
    }
    int m = 0;
    ImageView im1;
    public void start(Stage primstage){
    Image[] ims = {new Image("red.jpg"),new Image("yellow.jpg"),new Image("green.jpg")};
    primstage.setTitle("Belters");
    FlowPane rootnode = new FlowPane();
    rootnode.setAlignment(Pos.CENTER);
    Scene scen1 = new Scene(rootnode,360,360,Color.WHITE);
    primstage.setScene(scen1);
    Label l1 = new Label("Nothing is lit");
    ToggleButton tg1 = new ToggleButton("",new ImageView(new Image("off.jpg")));
    tg1.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                if (tg1.isSelected()){
                    tg1.setGraphic(new ImageView(new Image("on.jpg")));
                    im1.setImage(new Image("red.jpg"));
                    l1.setText("Red is lit");
                    m=0;
                }
                else{
                    tg1.setGraphic(new ImageView(new Image("off.jpg")));
                    im1.setImage(new Image("def.jpg"));
                    l1.setText("Nothing is lit");
                }
            }
        });
        ToggleGroup tgr1 = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Red");
        RadioButton rb2 = new RadioButton("Yellow");
        RadioButton rb3 = new RadioButton("Green");
        rb1.setToggleGroup(tgr1);
        rb2.setToggleGroup(tgr1);
        rb3.setToggleGroup(tgr1);      
        tgr1.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue <?extends Toggle> changed,Toggle oldval,Toggle newval){
                RadioButton rb = (RadioButton) newval;
                l1.setText(rb.getText()+" is lit");
                im1.setImage(new Image(rb.getText()+".jpg"));
                switch (rb.getText()){
                    case "red":
                        m = 0;
                        break;
                    case "yellow":
                        m = 1;
                        break;
                    case "green":
                        m = 2;
                        break;
                }
            }
        });
        rb1.setSelected(true);
        /*
        rb1.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                im1.setImage(new Image("red.jpg"));
                m=0;
            }
        });
        rb2.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                im1.setImage(new Image("yellow.jpg"));
                m=1;
            }
        });
        rb3.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                im1.setImage(new Image("green.jpg"));
                m=2;
            }
        });
        */
    Button b1 = new Button("",new ImageView(new Image("button.jpg")));
    im1 = new ImageView("def.jpg");
    b1.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    b1.setOnAction((ea) -> {
        im1.setImage(ims[m++]);
        if (m==ims.length){
            m=0;
        }
    });
    TreeItem<String> show = new TreeItem<String>("The Wire");
    
    TreeItem<String> s1 = new TreeItem<String>("Season 1");
    TreeItem<String> s2 = new TreeItem<String>("Season 2");
    TreeItem<String> s3 = new TreeItem<String>("Season 3");
    TreeItem<String> ss4 = new TreeItem<String>("Season 4");
    TreeItem<String> s5 = new TreeItem<String>("Season 5");
    show.getChildren().addAll(s1,s2,s3,ss4,s5);
    s1.getChildren().addAll(new TreeItem<String>("Avon Barksdale"),new TreeItem<String>("D'Angelo Barksdale"),new TreeItem<String>("Jimmy McNulty"),new TreeItem<String>("Stringer Bell"));
    TreeView<String> tree1 = new TreeView(show);
    MultipleSelectionModel sk = tree1.getSelectionModel();
    sk.selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>(){
        public void changed(ObservableValue<? extends TreeItem<String>> changed, TreeItem<String> oldv, TreeItem<String> newv){
            if (newv!=null){
                String pth = newv.getValue();
                TreeItem<String> tp = newv.getParent();
                while (tp!=null){
                    pth = tp.getValue()+" > "+pth;
                    tp = tp.getParent();
                }   
            l1.setText("Selected path is :"+pth);
            }
        }
    });
    Separator s = new Separator();
    s.setPrefWidth(360);
    rootnode.getChildren().addAll(l1,tg1,b1,im1,rb1,rb2,rb3,s,tree1);
    primstage.show();
}
}