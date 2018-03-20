

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Raket extends Group {

	public Raket() {
		this(75);
	}

	public Raket(double width) {

	Rectangle Body = new Rectangle(width, width * 3);
		
		Polygon Front = new Polygon(40,0,30,16,50,16);
		Polygon Left = new Polygon(30,40,25,45,30,45);
		Polygon Right = new Polygon(50,40,55,45,50,45);
		
		Front.setScaleY(4);
		Front.setScaleX(4);
		Front.setTranslateX(347);
		Front.setTranslateY(105);
		
		Left.setScaleX(10);
		Left.setScaleY(10);
		Left.setTranslateX(300);
		Left.setTranslateY(300);
		
		Right.setScaleX(10);
		Right.setScaleY(10);
		Right.setTranslateX(390);
		Right.setTranslateY(300);
		
		Body.setX(350);
		Body.setY(143);
		
		Front.setFill(Color.BLACK);
		Left.setFill(Color.BLACK);
		Right.setFill(Color.BLACK);
		
		this.getChildren().addAll(Body,Front,Left,Right);
   
		
		
	}

	public void changeColor() {

		Color color = new Color(Math.random(), Math.random(), Math.random(), 1);

		for (int i = 0; i < this.getChildren().size(); i++) {
			Shape s = (Shape) this.getChildren().get(i);
			s.setFill(color);
			
			this.setTranslateY(this.getTranslateY() - 2);

		}

	}

	public void tuta() {
		System.out.println("SSSSKRRRRR");
	}

	public void moveUp() {
		this.setTranslateY(this.getTranslateY() - 5);
	}

	public void moveDown() {
		this.setTranslateY(this.getTranslateY() + 5);
	}

	public void moveLeft() {
		double deg = this.getRotate();
		deg = Math.toRadians(deg);

		this.setTranslateY(this.getTranslateY() - Math.sin(deg) * 5);
		this.setTranslateX(this.getTranslateX() - Math.cos(deg) * 5);
	}

	public void moveRight() {
		double deg = this.getRotate();
		deg = Math.toRadians(deg);

		this.setTranslateY(this.getTranslateY() + Math.sin(deg) * 5);
		this.setTranslateX(this.getTranslateX() + Math.cos(deg) * 5);
	}

	
}