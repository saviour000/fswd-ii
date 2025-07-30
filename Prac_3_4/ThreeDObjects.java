import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class ThreeDObjects extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create Box
        Box box = new Box(100, 100, 100);
        PhongMaterial boxMaterial = new PhongMaterial(Color.BLUE);
        box.setMaterial(boxMaterial);
        box.setTranslateX(150);
        box.setTranslateY(150);
        box.setTranslateZ(400);

        // Create Sphere
        Sphere sphere = new Sphere(50);
        PhongMaterial sphereMaterial = new PhongMaterial(Color.ORANGE);
        sphere.setMaterial(sphereMaterial);
        sphere.setTranslateX(350);
        sphere.setTranslateY(150);
        sphere.setTranslateZ(400);

        // Create Cylinder
        Cylinder cylinder = new Cylinder(40, 100);
        PhongMaterial cylinderMaterial = new PhongMaterial(Color.PALEVIOLETRED);
        cylinder.setMaterial(cylinderMaterial);
        cylinder.setTranslateX(250);
        cylinder.setTranslateY(300);
        cylinder.setTranslateZ(400);

        // Create Point Light
        PointLight pointLight = new PointLight(Color.WHITE);
        pointLight.setTranslateX(250);
        pointLight.setTranslateY(100);
        pointLight.setTranslateZ(200);

        // Create Ambient Light
        AmbientLight ambientLight = new AmbientLight(Color.rgb(100, 100, 100));

        // Group all nodes
        Group root = new Group(box, sphere, cylinder, pointLight, ambientLight);

        // Create and position camera
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-1000);
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(35);

        // Create scene with depth buffer enabled
        Scene scene = new Scene(root, 600, 400, true);
        scene.setFill(Color.GRAY);
        scene.setCamera(camera);

        // Apply rotations to the whole group
        Rotate rotateX = new Rotate(20, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(30, Rotate.Y_AXIS);
        root.getTransforms().addAll(rotateX, rotateY);

        // Setup stage
        primaryStage.setTitle("JavaFX 3D Objects");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

// Then give 2 commands in terminal

// Compile :-

// javac --module-path "C:\javafx-sdk-24.0.2\lib" --add-modules
// javafx.controls,javafx.graphics ThreeDObjects.java

// Run :-
// java --module-path "C:\javafx-sdk-24.0.2\lib" --add-modules
// javafx.controls,javafx.graphics ThreeDObjects
