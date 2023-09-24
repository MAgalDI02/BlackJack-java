import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand;
    private int totalHandValue;

    public Player() {
        hand = new ArrayList<>();
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getTotalHandValue() {
        return totalHandValue;
    }

    public int calculateHandValue(Card newCardBought) {
        int value = 0;
        int numAces = 0;

        // quando uma carta for comprada
        if (newCardBought != null){
            int valueOfCard = newCardBought.getCustomValue();
            this.totalHandValue += valueOfCard;

            if (valueOfCard == 11) {
                numAces++;
            }

            return totalHandValue;
        }

        else{
            for (Card card : hand) {
            ///System.out.println("Carta: " + card);
            int valueOfCard = card.getCustomValue();
            value += valueOfCard;
            if (valueOfCard == 11) {
                numAces++;
            }
        }
        }

        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }

        totalHandValue = value;
        return value;
    }
}
