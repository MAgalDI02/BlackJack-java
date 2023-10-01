import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
    private List<Card> deck;

    public DeckOfCards() {
        deck = new ArrayList<>();
        initializeDeck();
    }
// inicializa o deck com as 14 cartas possíveis
    private void initializeDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j <= 14; j++) {
                deck.add(new Card(j));
            }
        }
    }
// distribui as cartas aleatóriamente para os jogadores
    public Card drawCard() {
        if (deck.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * deck.size());
        return deck.remove(randomIndex);
    }
}
