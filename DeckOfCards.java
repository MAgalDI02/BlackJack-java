import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
    private List<Card> deck;

    public DeckOfCards() {
        deck = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j <= 14; j++) {
                deck.add(new Card(j));
            }
        }
    }

    public Card drawCard() {
        if (deck.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * deck.size());
        return deck.remove(randomIndex);
    }
}
