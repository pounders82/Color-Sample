import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


// Name:    Nick Pounders
// Brief Description: This program creates an application that allows the user to change the Hue, Saturation, and
//Brightness of a color based on the buttons that are pressed.


public class ColorSampler extends Application {
    private ColorPane cp;

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane bpane = new BorderPane();
        StackPane st1 = new StackPane();
        cp = new ColorPane();

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        Button btms = new Button("More Saturated");
        Button btls = new Button("Less Saturated");
        hBox.getChildren().add(btms);
        hBox.getChildren().add(btls);
        btms.setOnAction(event -> cp.moreSaturated());
        btls.setOnAction(event -> cp.lessSaturated());
        st1.getChildren().add(hBox);
        bpane.setTop(st1);



        HBox hBox2 = new HBox();
        hBox2.setAlignment(Pos.CENTER);
        Button btd = new Button("Darker");
        Button btb = new Button("Brighter");
        hBox2.getChildren().add(btd);
        hBox2.getChildren().add(btb);
        btd.setOnAction(event -> cp.darker());
        btb.setOnAction(event -> cp.brighter());
        StackPane st2 = new StackPane();
        st2.getChildren().add(hBox2);
        bpane.setBottom(st2);


        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        Button bthu = new Button("Hue up");
        Button bthd = new Button("Hue down");
        vBox.getChildren().add(bthu);
        vBox.getChildren().add(bthd);
        bpane.setRight(vBox);
        bthu.setOnAction(event -> cp.hueUp());
        bthd.setOnAction(event -> cp.hueDown());


        bpane.setCenter(cp);


        Scene scene = new Scene(bpane, 400, 400);
        primaryStage.setTitle("Color Sample");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



}
class ColorPane extends Pane {
    private Rectangle rec = new Rectangle();


    public ColorPane() {
        rec.heightProperty().bind(heightProperty());
        rec.widthProperty().bind(widthProperty());
        rec.setFill(Color.hsb(180,.5,.5));
        this.getChildren().add(rec);
    }


    public void brighter() {
        Color a = (Color) rec.getFill();
        if (a.getBrightness() <= .99) {
            double h = a.getHue();
            double s = a.getSaturation();
            double b = Math.sqrt(a.getBrightness());
            rec.setFill(Color.hsb(h, s, b));
        }
        else {
            //do nothing
        }

    }

    public void darker(){
        Color a = (Color) rec.getFill();
        if (a.getBrightness() >= 0.01) {
            double h = a.getHue();
            double s = a.getSaturation();
            double b = Math.pow(a.getBrightness(), 2);
            rec.setFill(Color.hsb(h, s, b));
        }
        else {
            //do nothing
        }

    }

    public void hueUp(){
        Color a = (Color) rec.getFill();
        double c = a.getHue();
        if (c < 330){
            System.out.println(a.getHue());
            double h = c + 30;
            double s = a.getSaturation();
            double b = a.getBrightness();
            rec.setFill(Color.hsb(h,s,b));
        }
        else{
            //do nothing
        }

    }

    public void hueDown(){
        Color a = (Color) rec.getFill();
        if (a.getHue() >=30) {
            double h = a.getHue() - 30;
            double s = a.getSaturation();
            double b = a.getBrightness();
            rec.setFill(Color.hsb(h, s, b));
        }
        else {
            //do nothing
        }

    }

    public void moreSaturated(){
        Color a = (Color) rec.getFill();
        if (a.getSaturation() <= 1){
            double h = a.getHue();
            double s = Math.sqrt(a.getSaturation());
            double b = a.getBrightness();
            rec.setFill(Color.hsb(h,s,b));}
        else{
            //do nothing
        }

    }

    public void lessSaturated(){
        Color a = (Color) rec.getFill();
        if (a.getSaturation() > 0.01){
            double h = a.getHue();
            double s = Math.pow(a.getSaturation(), 2);
            double b = a.getBrightness();
            rec.setFill(Color.hsb(h,s,b));}
        else{
            //do nothing
        }

    }
}

