



import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JavaFX extends Application {
	
	Scene scene;
	final double WIDTH = 600;
	final double HEIGTH = 600;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		scene = upg6();
		
		primaryStage.setScene(scene);	
		primaryStage.show();
		
	}
	public Scene upg1(){ // Cirkel i Mitten.
		Group root1 = new Group();
		Scene scene = new Scene(root1,WIDTH,HEIGTH);
		
		Circle cir = new Circle(100);
		cir.setTranslateX(WIDTH/2);
		cir.setTranslateY(HEIGTH/2);
		cir.setFill(Color.RED);
		
		root1.getChildren().add(cir);
		
		return scene;
		
	}
	
	public Scene upg2(){ // Slumpmässig position på 50 cirklar.
		Group root2 = new Group();
		Scene scene = new Scene(root2,WIDTH,HEIGTH);
		
		for(int i = 0 ; i < 50 ; i++){
		Circle cir = new Circle(50);
		cir.setTranslateX(Math.random()*WIDTH-cir.getCenterX());
		cir.setTranslateY(Math.random()*HEIGTH-cir.getCenterY());
		cir.setFill(Color.RED);
		
		root2.getChildren().add(cir);
		}
		
		
		return scene;
	}
	    
	public Scene upg3(){ // 4 Kvadrater vid ena hörn
		Group root3 = new Group();
		Scene scene = new Scene(root3,WIDTH,HEIGTH);
		
		Rectangle rect = new Rectangle();
		Rectangle rect2 = new Rectangle();
		Rectangle rect3 = new Rectangle();
		Rectangle rect4 = new Rectangle();
		
		rect.setFill(Color.BLACK);
		rect2.setFill(Color.BLUE);
		rect3.setFill(Color.RED);
		rect4.setFill(Color.CYAN);
		
		
	rect.setX(0);
	rect.setY(0);
	rect.setHeight(50);
	rect.setWidth(50);
	
	rect2.setX(550);
	rect2.setY(0);
	rect2.setHeight(50);
	rect2.setWidth(50);
	
	rect3.setX(0);
	rect3.setY(550);
	rect3.setHeight(50);
	rect3.setWidth(50);
	
	rect4.setX(550);
	rect4.setY(550);
	rect4.setHeight(50);
	rect4.setWidth(50);
	
	root3.getChildren().add(rect);
	root3.getChildren().add(rect2);
	root3.getChildren().add(rect3);
	root3.getChildren().add(rect4);
	    
		
		return scene;
			
		
	}
	
	public Scene upg4(){ // Sveriges flagga 

		Group root4 = new Group();
		Scene scene = new Scene(root4,WIDTH,HEIGTH);
		
		Rectangle rect = new Rectangle();
		Rectangle rect2 = new Rectangle();
		Rectangle rect3 = new Rectangle();
		
		rect.setFill(Color.BLUE);
		rect2.setFill(Color.YELLOW);
		rect3.setFill(Color.YELLOW);
		
		rect.setX(0);
		rect.setY(0);
		rect.setHeight(250);
		rect.setWidth(500);
		
		rect2.setX(150);
		rect2.setY(0);
		rect2.setHeight(250);
		rect2.setWidth(50);
		
		rect3.setX(0);
		rect3.setY(100);
		rect3.setHeight(50);
		rect3.setWidth(500);
		
		root4.getChildren().add(rect);
		root4.getChildren().add(rect2);
		root4.getChildren().add(rect3);
		
		
		
		
		
		return scene;
		
	}
	
	public Scene upg5(){ // Styr med Tagentbord (Pillar)

		Group root5 = new Group();
		Scene scene = new Scene(root5,WIDTH,HEIGTH);
		
		Rectangle rect = new Rectangle();
		rect.setFill(Color.BLUE);
		
		rect.setHeight(100);
		rect.setWidth(200);
		
		root5.getChildren().add(rect);
		rect.setTranslateX(250);
		rect.setTranslateY(250);
		
		scene.setOnKeyPressed(event ->{
			
			KeyCode key = event.getCode();
			
			int speed = 10;
			
			switch (key){
			
			case UP:
				rect.setTranslateY(rect.getTranslateY()- speed);
				if(rect.getTranslateY() < -250-rect.getTranslateY()){
					rect.setTranslateY(250+rect.getTranslateY());
				}
				
				break;
				
			case DOWN:
				rect.setTranslateY(rect.getTranslateY()+ speed);
				if(rect.getTranslateY() > 250+rect.getTranslateY()){
					rect.setTranslateY(-250-rect.getTranslateY());
				}
				break;
				
			case LEFT:
				rect.setTranslateX(rect.getTranslateX()- speed);
				if(rect.getTranslateX() < -250-rect.getTranslateX()){
					rect.setTranslateX(250+rect.getTranslateX());
				}
				break;
				
			case RIGHT:
				rect.setTranslateX(rect.getTranslateX()+ speed);
				if(rect.getTranslateX() > 250+rect.getTranslateX()){
					rect.setTranslateX(-250-rect.getTranslateX());
				}
				break;
			
			}
		});
		
		
		return scene;
	}
	
	public Scene upg6(){ // Inte helt klart XD / Styr med WASD inom scene 

		Group root6 = new Group();
		Scene scene = new Scene(root6,WIDTH,HEIGTH);
		
		Circle cir = new Circle(100);
		cir.setTranslateX(WIDTH/2);
		cir.setTranslateY(HEIGTH/2);
		cir.setFill(Color.RED);
		
		root6.getChildren().add(cir);
		
scene.setOnKeyPressed(event ->{
			
			KeyCode key = event.getCode();
			
			int speed = 10;
			
			switch (key){
			
			case W:
				cir.setTranslateY(cir.getTranslateY()- speed);
				if(cir.getTranslateY() < -250-cir.getTranslateY()){
					cir.setTranslateY(250+cir.getTranslateY());
				}
				
				break;
				
			case S:
				cir.setTranslateY(cir.getTranslateY()+ speed);
				if(cir.getTranslateY() > 250+cir.getTranslateY()){
					cir.setTranslateY(-250-cir.getTranslateY());
				}
				break;
				
			case A:
				cir.setTranslateX(cir.getTranslateX()- speed);
				if(cir.getTranslateX() < -250-cir.getTranslateX()){
					cir.setTranslateX(250+cir.getTranslateX());
				}
				break;
				
			case D:
				cir.setTranslateX(cir.getTranslateX()+ speed);
				if(cir.getTranslateX() > 250+cir.getTranslateX()){
					cir.setTranslateX(-250-cir.getTranslateX());
				}
				break;
			
			}
		});

		
		
		
		return scene;
	}
	
	
	
	public static void main(String[] args) {
		launch();
		
	}
	
	

}
