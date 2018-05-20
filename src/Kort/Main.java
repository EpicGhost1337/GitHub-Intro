package Kort;



import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static final double MARGIN = 10;
	public static final double WIDTH = (Card.WIDTH + MARGIN) * 7 + MARGIN;
	public static final double HEIGHT = (Card.HEIGHT + MARGIN) * 4 + MARGIN;
	public static BlakJack Spelare1, Spelare2;

	public static Group root = new Group();

	public static Scene scene = new Scene(root, WIDTH, HEIGHT, Color.FORESTGREEN);

	
	public void start(Stage primaryStage) throws Exception {

		Spelare1 = new BlakJack();

		Spelare2 = new BlakJack();

		Spelare2.setTranslateX(0);
		Spelare2.setTranslateY(300);

		root.getChildren().addAll(Spelare1, Spelare2);

		Spelare1.Board();
		Spelare2.Board();

		primaryStage.setScene(scene);
		primaryStage.show();
	
	}

	public static void Won() { // Om Spelare1 vinner så vinner det annars Spelare2 som vinner eller Lika 

		Rectangle rec = new Rectangle(Main.WIDTH, Main.HEIGHT);
		rec.setFill(Color.BLACK);
		rec.setOpacity(0.80);
		
		int compare = Spelare1.compare(Spelare2);
		Text winText = new Text();
		if (compare == 1) {
			winText.setText("Spelare1 Vann!");
		} else if (compare == 0) {
			winText.setText("Det blev Lika!");
		} else {
			winText.setText("Spelare2 Vann!");
		}
		
		winText.setFill(Color.YELLOW);
		winText.setFont(new Font(100));
		winText.setTranslateX(Main.WIDTH/2-winText.getBoundsInLocal().getWidth()/2);
		winText.setTranslateY(325);

		root.getChildren().addAll(rec, winText);
	}
	
	public static void main(String[] args) {
		launch();
	}


}
