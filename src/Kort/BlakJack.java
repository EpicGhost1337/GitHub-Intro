package Kort;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
public class BlakJack extends Group {
	
	Text valueText = new Text();
	Text standText = new Text();
	Text hitText = new Text();
	int ACounter;

	public static CardDeck deck = new CardDeck();

	ArrayList<Card> hand = new ArrayList<Card>();
	boolean hasStopped = false;

	public void BlackJack() {

		deck.shuffle();
		hit();
		hit();

	}

	public int getHandValue() {

		int sum = 0;
		ACounter = 0;

		for (int i = 0; i < hand.size(); i++) {
			Card c = hand.get(i);
			int temp = c.getValue();
			if (temp == 14) {
				ACounter++;
				temp = 11;
			} else if (temp > 10) {
				temp = 10;
			}
			sum += temp;
		}

		for (int i = 0; i < ACounter; i++) {
			if (sum > 21) {
				sum -= 10;

			}

		}

		return sum;
	}

	public void hit() {

		if (!hasStopped && getHandValue() < 21) {

			Card c = deck.Draw();
			c.setTranslateX(hand.size() * Card.WIDTH + 10);
			hand.add(c);
			this.getChildren().add(c);
			valueText.setText("Value: " + getHandValue());
			if(getHandValue() > 21){
				stand();
			}
		}

	}

	public void stand() { 

		hasStopped = true;
		
		if(Main.Spelare2.hasStopped){
			Main.Won();
		}

	}

	public void Board() { // Själva bordet som man speler i med färger samtidig positonera knappar

		Button stand = new Button("S", Color.FIREBRICK);
		Button hit = new Button("H", Color.LIMEGREEN);

		stand.setOnMouseClicked(event -> {
			stand();
			stand.setFill(Color.RED);
		});

		hit.setOnMouseClicked(event -> {
			hit();
		});
		hit.setOnMousePressed(event -> {
			hit.setFill(Color.GREEN);
		});
		hit.setOnMouseReleased(event -> {
			hit.setFill(Color.LIMEGREEN);
		});

		stand.setTranslateX(300);
		stand.setTranslateY(Card.HEIGHT + 30);
		hit.setTranslateX(150);
		hit.setTranslateY(Card.HEIGHT + 30);

		this.getChildren().addAll(stand, hit);

		Rectangle valueRect = new Rectangle(200, 60);

		valueRect.setTranslateX(420);
		valueRect.setTranslateY(Card.HEIGHT + 30);
		valueRect.setFill(Color.YELLOW);
		valueRect.setStroke(Color.BLACK);
		valueRect.setStrokeWidth(5);

		valueText.setTranslateX(430);
		valueText.setTranslateY(Card.HEIGHT + 75);
		valueText.setFont(new Font(45));

		this.getChildren().addAll(valueRect, valueText);

	}

	public int compare(BlakJack otherPlayer) { // jämför kortet med både spelare //

		if (this.getHandValue() == 21 && this.hand.size() == 2) {
			if (otherPlayer.getHandValue() == 21 && otherPlayer.hand.size() == 2) {
				return 0;
			} else {
				return 1;
			}
		}

		if (otherPlayer.getHandValue() == 21 && otherPlayer.hand.size() == 2) {
			return 2;
		}

		if (this.getHandValue() > 21 && otherPlayer.getHandValue() <= 21) {
			return 2;
		}

		if (this.getHandValue() <= 21 && otherPlayer.getHandValue() > 21) {
			return 1;
		}

		if (this.getHandValue() > 21 && otherPlayer.getHandValue() > 21) {
			return 0;
		}
		
		if (this.getHandValue() > otherPlayer.getHandValue()) {
			return 1;
		}

		if (this.getHandValue() < otherPlayer.getHandValue()) {
			return 2;
		}
		
	

		return 0;

	}

}
