import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class TwoDShapes extends Application {
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Rectangle rect = new Rectangle(50, 50, 120, 80);
        rect.setFill(Color.LIGHTBLUE);
        rect.setStroke(Color.BLACK);

        Circle circle = new Circle(250, 90, 40);
        circle.setFill(Color.LIGHTGREEN);
        circle.setStroke(Color.BLACK);

        Ellipse el = new Ellipse(400, 90, 70, 40);
        el.setFill(Color.LIGHTPINK);
        el.setStroke(Color.BLACK);

        Line l = new Line(50, 200, 450, 200);
        l.setStroke(Color.RED);
        l.setStrokeWidth(3);

        pane.getChildren().addAll(rect, circle, el, l);

        Scene scene = new Scene(pane, 500, 300);
        primaryStage.setTitle("JavaFX 2D Shapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

// Then give 2 commands in terminal

// Compile :-

// javac --module-path "C:\javafx-sdk-24.0.2\lib" --add-modules javafx.controls
// TwoDShapes.java

// Run :-
// java --module-path "C:\javafx-sdk-24.0.2\lib" --add-modules javafx.controls
// TwoDShapes
