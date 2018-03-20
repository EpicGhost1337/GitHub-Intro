

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Main extends Application {

	public static final double WINDOW_WIDTH = 800;
	public static final double WINDOW_HEIGHT = 800;
	public static final double Raket_SIZE = 75;

	public static final ArrayList<KeyCode> keys = new ArrayList<KeyCode>();

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();

		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

		Raket Raket = new Raket(Raket_SIZE);

		root.getChildren().add(Raket);

		scene.setOnKeyPressed(event -> {

			if (!keys.contains(event.getCode())) {
				keys.add(event.getCode());
			}

		});

		scene.setOnKeyReleased(event -> {

			if (keys.contains(event.getCode())) {

				keys.remove(event.getCode());
			}
		});

		AnimationTimer at = new AnimationTimer() {

			@Override
			public void handle(long now) {

				for (int i = 0; i < keys.size(); i++) {

					KeyCode key = keys.get(i);

					switch (key) {

					case W:
					case UP:
						Raket.moveUp();
						break;
					case S:
					case DOWN:
						Raket.moveDown();
						break;
					case A:
					case LEFT:
						Raket.moveLeft();
						
						break;
					case D:
					case RIGHT:
						Raket.moveRight();
						break;
					case SPACE:
						Raket.tuta(); // LOL
						Raket.changeColor();
						break;
					case E:
						Raket.setRotate(Raket.getRotate() + 2);
						break;
					case Q:
						Raket.setRotate(Raket.getRotate() - 2);
						break;
					}

					if (Raket.getTranslateX() > WINDOW_WIDTH) {
						Raket.setTranslateX(0 - Raket_SIZE);
					} else if (Raket.getTranslateX() < -Raket_SIZE) {
						Raket.setTranslateX(WINDOW_WIDTH);
					}

					if (Raket.getTranslateY() > WINDOW_HEIGHT) {
						Raket.setTranslateY(0 - Raket_SIZE);
					} else if (Raket.getTranslateY() < Raket_SIZE) {
						Raket.setTranslateY(WINDOW_HEIGHT);
					}

				}

			}

		};

		at.start();

		primaryStage.setScene(scene);
		primaryStage.show();

	}

}