import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Exercise 14.1
 * @author Xinyi Zhao
 * */

public class C14E1DisplayImages extends Application {
    @Override
    public void start(Stage primaryStage)  {
        //Create a pane and initialize its properties
        GridPane flagPane = new GridPane();
        flagPane.setAlignment(Pos.CENTER);
        flagPane.setPadding(new Insets(10, 10, 10, 10));
        flagPane.setHgap(2.5);
        flagPane.setVgap(2.5);

        //Place nodes in the pane
        Image imageUK = new Image("image/Flag_of_UK.jpg");
        ImageView viewUK = new ImageView(imageUK);
        viewUK.setFitHeight(100);
        viewUK.setFitWidth(150);
        flagPane.add(viewUK, 0, 0);

        Image imageCanada = new Image("image/Flag_of_Canada.png");
        ImageView viewCanada = new ImageView(imageCanada);
        viewCanada.setFitHeight(100);
        viewCanada.setFitWidth(150);
        flagPane.add(viewCanada, 0, 1);

        Image imageChina = new Image("image/Flag_of_China.png");
        ImageView viewChina = new ImageView(imageChina);
        viewChina.setFitHeight(100);
        viewChina.setFitWidth(150);
        flagPane.add(viewChina, 1, 0);

        Image imageUSA = new Image("image/Flag_of_US.png");
        ImageView viewUSA = new ImageView(imageUSA);
        viewUSA.setFitHeight(100);
        viewUSA.setFitWidth(150);
        flagPane.add(viewUSA, 1, 1);

        //Create a scene and place it in the stage
        Scene scene = new Scene(flagPane);
        primaryStage.setTitle("Exercise14_01");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("\nEnd of Exercise14.01\n");
    }

    public static void main(String[] args){
        launch(args);
    }

}
