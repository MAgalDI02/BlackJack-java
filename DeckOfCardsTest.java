import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeckOfCardsTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;



do {
    DeckOfCards deck = new DeckOfCards();
    List<Player> players = new ArrayList<>();

    // Adicione jogadores à mesa
    players.add(new Player());
    players.add(new Player());

    for (Player player : players) {
        player.addCardToHand(deck.drawCard());
        player.addCardToHand(deck.drawCard());
    }

    List<Card> dealerHand = new ArrayList<>();
    dealerHand.add(deck.drawCard());
    dealerHand.add(deck.drawCard());

    System.out.println("Bem-vindo ao Blackjack!");

    for (Player player : players) {
        displayPlayerHand(player);

        // Pergunte ao jogador se deseja comprar mais uma carta
        System.out.print("Deseja comprar mais uma carta? (S/N): ");
        choice = scanner.nextLine().toUpperCase();
        while (choice.equals("S")) {
            Card newCard = deck.drawCard();
            player.addCardToHand(newCard);
            System.out.println("Você comprou: " + newCard);
            displayPlayerHand(player);
            if (player.calculateHandValue() > 21) {
                System.out.println("Você estourou! Sua pontuação é maior que 21.");
                break;
            }
            System.out.print("Deseja comprar mais uma carta? (S/N): ");
            choice = scanner.nextLine().toUpperCase();
        }
    }

    displayDealerHand(dealerHand, true); // Exibir a primeira carta do dealer

    // O restante do código do jogo pode ser mantido igual ao exemplo anterior.

    System.out.print("Deseja jogar novamente? (S/N): ");
    choice = scanner.nextLine().toUpperCase();
} while (choice.equals("S"));

System.out.println("Obrigado por jogar!");
scanner.close();


    public static void displayPlayerHand(Player player) {
        System.out.println("Mão do jogador: " + player.getHand());
        System.out.println("Total da mão do jogador: " + player.calculateHandValue());
    }

    public static void displayDealerHand(List<Card> dealerHand, boolean showFirstCard) {
        System.out.print("Mão do dealer: ");
        if (showFirstCard) {
            System.out.println(dealerHand.get(0) + " e uma carta oculta.");
        } else {
            System.out.println(dealerHand);
        }
    }

    // Métodos displayHands e calculateHandValue permanecem iguais.
}
