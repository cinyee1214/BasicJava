import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Exercise 14.12
 * @author Xinyi Zhao
 * */

public class C14E12DisplayChart extends Application {
    @Override
    public void start(Stage primaryStage){
        final double SCENE_HEIGHT = 200;

        //Create a pane
        Pane rectanglePane = new Pane();

        //Declare and initialize rectangles
        Rectangle rProject = new Rectangle(10, SCENE_HEIGHT - 70 - 10,
                100, 70);
        Rectangle rQuiz = new Rectangle(rProject.getX() + rProject.getWidth() + 10, SCENE_HEIGHT - 35 - 10,
                100, 35);
        Rectangle rMidterm = new Rectangle( rQuiz.getX() + rQuiz.getWidth() + 10, SCENE_HEIGHT - 105 -10,
                100, 105);
        Rectangle rFinal = new Rectangle(rMidterm.getX() + rMidterm.getWidth() + 10, SCENE_HEIGHT - 140 - 10,
                100, 140);
        //Set properties of rectangles
        rProject.setStroke(Color.RED);
        rProject.setFill(Color.RED);
        rQuiz.setStroke(Color.BLUE);
        rQuiz.setFill(Color.BLUE);
        rMidterm.setStroke(Color.GREEN);
        rMidterm.setFill(Color.GREEN);
        rFinal.setStroke(Color.ORANGE);
        rFinal.setFill(Color.ORANGE);

        //Declare and initialize text files
        Text tProject = new Text(rProject.getX(), rProject.getY() - 5, "Project -- 20%");
        Text tQuiz = new Text(rQuiz.getX(), rQuiz.getY() - 5, "Quiz -- 10%");
        Text tMidterm = new Text(rMidterm.getX(), rMidterm.getY() - 5, "Midterm -- 30%");
        Text tFinal = new Text(rFinal.getX(), rFinal.getY() - 5, "Final -- 40%");

        //Place nodes in the pane
        rectanglePane.getChildren().addAll(tProject, rProject, tQuiz, rQuiz,
                tMidterm, rMidterm, tFinal, rFinal);

        //Create a scene and place it in the stage
        Scene scene = new Scene(rectanglePane,
                rFinal.getX() + rFinal.getWidth() + 10, SCENE_HEIGHT);
        primaryStage.setTitle("Exercise14_12");
        primaryStage.setScene(scene);
        primaryStage.show();

        System.out.println("\nEnd of Exercise 14.12\n");
    }

    public static void main(String[] args){
        launch(args);
    }
}
