import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand;
    private int totalHandValue;
    private int id;
// indica qual jogador é
    public Player(int id) {
        this.hand = new ArrayList<>();
        this.id = id;
    }
// retorna o ID do jogador
    public int getId(){
        return id;
    }
// adiciona carta se necessário
    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getTotalHandValue() {
        return totalHandValue;
    }
// método para calcular a mão do jogador
    public int calculateHandValue(Card newCardBought) {
        int value = 0;
        int numAces = 0;

        // quando uma carta for comprada
        if (newCardBought != null){
            int valueOfCard = newCardBought.getCustomValue();
            this.totalHandValue += valueOfCard;
// se o valor da carta for 11, acrescenta um Ás
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
// enquanto o valor for maior que 21 ou o numero de Aces maior que 0, diminui o valor de um Ás e subtrai 10 do valor
        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }

        totalHandValue = value;
        return value;
    }
}
