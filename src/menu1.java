import javafx.stage.*;
import javafx.scene.*;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.application.*;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;

public class menu1 extends Application{
    Label l1 = new Label();
    TextField tf = new TextField();
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage prim1){
        prim1.setTitle("Menus,shieeeeeeeeeeeet");
        BorderPane bp = new BorderPane();
        Scene sc = new Scene(bp,480,360);
        prim1.setScene(sc);
        FlowPane fp = new FlowPane(10,10);

        MenuBar mb = new MenuBar();

        MenuItem k1 = new MenuItem("Cut");
        MenuItem k2 = new MenuItem("Copy");
        MenuItem k3 = new MenuItem("Paste");
        final ContextMenu conmen = new ContextMenu(k1,k2,k3);

        Menu m1 = new Menu("_File");
        m1.setMnemonicParsing(true);
        MenuItem mi1 = new MenuItem("New");
        MenuItem mi2 = new MenuItem("Open");
        MenuItem mi3 = new MenuItem("Save");
        MenuItem mi4 = new MenuItem("Save As");
        MenuItem mi5 = new MenuItem("Exit");
        m1.getItems().addAll(mi1,mi2,mi3,mi4,mi5);

        Menu m2 = new Menu("_Options");
        m2.setMnemonicParsing(true);
        MenuItem o1 = new MenuItem("Edit");
        MenuItem o2 = new MenuItem("Find");
        MenuItem o3 = new MenuItem("Replace");
        m2.getItems().addAll(o1,o2,o3);

        Menu m3 = new Menu("_HBO");
        m3.setMnemonicParsing(true);
        MenuItem h1 = new MenuItem("The Wire",new ImageView("wire.jpg"));
        MenuItem h2 = new MenuItem("The Sopranos",new ImageView("sopranos.jpg"));
        MenuItem h3 = new MenuItem("Deadwood",new ImageView("deadwood.jpg"));
        MenuItem h4 = new MenuItem("Boardwalk Empire",new ImageView("boardwalk.jpg"));
        m3.getItems().addAll(m2,h1,h2,h3,h4);

        Menu m4 = new Menu("_AMC");
        m3.setMnemonicParsing(true);
        Menu drama = new Menu("Drama");
        Menu horror = new Menu("Horror");
        CheckMenuItem c1 = new CheckMenuItem("Breaking Bad");
        CheckMenuItem c2 = new CheckMenuItem("Better Call Saul");
        CheckMenuItem c3 = new CheckMenuItem("Mad Men");
        drama.getItems().addAll(c1,c2,c3);
        ToggleGroup tg = new ToggleGroup();
        RadioMenuItem r1 = new RadioMenuItem("The Walking Dead");
        RadioMenuItem r2 = new RadioMenuItem("Fear the Walking Dead");
        RadioMenuItem r3 = new RadioMenuItem("The Horror");
        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);
        r3.setToggleGroup(tg);
        horror.getItems().addAll(r1,r2,r3);

        m4.getItems().addAll(drama,horror);
        mb.getMenus().addAll(m1,m3,m4);

        Button b1 = new Button("Movies",new ImageView("movies.jpg"));
        Button b2 = new Button("TV Shows",new ImageView("tv.jpg"));
        Button b3 = new Button("Games",new ImageView("games.jpg"));
        Button b4 = new Button("Music",new ImageView("music.png"));
        Button b5 = new Button("Books",new ImageView("books.jpg"));
        b1.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        b2.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        b3.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        b4.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        b5.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        b1.setTooltip(new Tooltip("Movies"));
        b2.setTooltip(new Tooltip("TV"));
        b3.setTooltip(new Tooltip("Games"));
        b4.setTooltip(new Tooltip("Music"));
        b5.setTooltip(new Tooltip("Books"));
        ToolBar tb = new ToolBar(b1,b2,b3,b4,b5);

        EventHandler<ActionEvent> e2 = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                l1.setText(((Button)ae.getTarget()).getText());
            }
        };
        b1.setOnAction(e2);
        b2.setOnAction(e2);
        b3.setOnAction(e2);
        b4.setOnAction(e2);
        b5.setOnAction(e2);
        tb.setOrientation(Orientation.VERTICAL);
    
        EventHandler<ActionEvent> e = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                String msg = ((MenuItem)ae.getTarget()).getText();
                if (msg.equals("Exit")) Platform.exit();
                l1.setText(msg);
            }
        };
        bp.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>(){
            public void handle(ContextMenuEvent ae){
                conmen.show(bp,ae.getScreenX(),ae.getScreenY());
            }
        });

        fp.setAlignment(Pos.CENTER);
        fp.getChildren().addAll(l1,tf);
        tf.setContextMenu(conmen);
        mi1.setOnAction(e);
        mi2.setOnAction(e);
        mi3.setOnAction(e);
        mi4.setOnAction(e);
        mi5.setOnAction(e);
        o1.setOnAction(e);
        o2.setOnAction(e);
        o3.setOnAction(e);
        h1.setOnAction(e);
        h2.setOnAction(e);
        h3.setOnAction(e);
        h4.setOnAction(e);
        k1.setOnAction(e);
        k2.setOnAction(e);
        k3.setOnAction(e);
        tf.setOnAction(e);

        mi1.setAccelerator(KeyCombination.keyCombination("shortcut+n"));
        mi2.setAccelerator(KeyCombination.keyCombination("shortcut+o"));
        mi3.setAccelerator(KeyCombination.keyCombination("shortcut+s"));
        mi4.setAccelerator(KeyCombination.keyCombination("shortcut+shift+s"));
        mi5.setAccelerator(KeyCombination.keyCombination("shortcut+w"));
        bp.setTop(mb);
        bp.setCenter(fp);
        bp.setLeft(tb);
        prim1.show();
    }
}