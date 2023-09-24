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

    // Adicionando players
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
    System.out.println("\n                 ~~ REGRAS DO JOGO BLACKJACK ~~ \n");
    System.out.println("1. Objetivo:");
    System.out.println("   - O objetivo do Blackjack é somar cartas para chegar o mais próximo possível de 21 pontos,");
    System.out.println("     sem ultrapassar esse valor.");
             System.out.println("   - Se a mão do jogador ultrapassar 21 pontos, ele perde automaticamente (bust).");
             System.out.println("   - O jogador ganha se tiver uma mão com um valor maior do que a mão do dealer,");
             System.out.println("     desde que não ultrapasse 21.");
     
             System.out.println("\n2. Valores das Cartas:");
             System.out.println("   - Cartas numéricas valem o valor impresso nelas (2 a 10).");
             System.out.println("   - Valete (J), Dama (Q) e Rei (K) valem cada um 10 pontos.");
             System.out.println("   - Ás (A) pode valer 1 ou 11 pontos, dependendo do que for mais benéfico para o jogador.");
             
             System.out.println("\n3. Desenvolvimento do Jogo:");
             System.out.println("   - O jogador recebe duas cartas iniciais.");
             System.out.println("   - O dealer também recebe duas cartas, uma delas oculta.");
             System.out.println("   - O jogador pode pedir mais cartas (hit) para tentar melhorar sua mão.");
    System.out.println("   - O jogador pode parar (stand) a qualquer momento.");
    System.out.println("   - O dealer deve pedir cartas até atingir pelo menos 17 pontos.");
             
    System.out.println("\n4. Vitória e Derrota:");
    System.out.println("   - O jogador ganha se sua mão for maior que a do dealer sem ultrapassar 21.");
    System.out.println("   - Se o jogador ultrapassar 21 pontos (bust), ele perde automaticamente.");
    System.out.println("   - Se o jogador e o dealer tiverem mãos com o mesmo valor, o jogo é um empate (push).");
    System.out.println("   - Se o jogador tiver um Blackjack natural (Ás + carta de 10 pontos) e o dealer não,");
    System.out.println("     o jogador ganha automaticamente."); 
    System.out.println("\n5. Opções Adicionais:");
    System.out.println("   - Seguro (insurance): O jogador pode fazer um seguro se o dealer mostrar um Ás.");
    System.out.println("   - Split (divisão): Se o jogador tiver duas cartas do mesmo valor, ele pode dividir a mão em duas.");
    System.out.println("   - Double Down (dobrar): O jogador pode dobrar sua aposta após receber as duas primeiras cartas.");
    System.out.println("\nLembre-se de que estas são apenas regras básicas do Blackjack.");
    System.out.println("As regras podem variar dependendo da versão específica do jogo ou do cassino.");
   

    int count =1;
    /* TODO: -> mover a avaliacao de ganhadores para uma funcao externa, 
    onde a lista de jogadores será iterada e comparada a variavel "totalHandValue"
    entre ambos, sendo tbm comparada com a mao do dealer para decidir quem será o 
    ganhador ou se haverá um empate
    */
    for (Player player : players) {
         System.out.printf("\n Vez do jogador %d !\n",count);
        displayPlayerHand(player, null);

        // Pergunte ao jogador se deseja comprar mais uma carta
        System.out.print("\n Deseja comprar mais uma carta? (S/N): ");
        choice = scanner.nextLine().toUpperCase();
        while (choice.equals("S")) {
            Card newCard = deck.drawCard();
            player.addCardToHand(newCard);
            System.out.println("\n Você comprou: " + newCard);
            displayPlayerHand(player, newCard);
            if (player.getTotalHandValue() > 21) {
                System.out.println("\n Você PERDEU! Sua pontuação é maior que 21.");
                break;
            } else if(player.getTotalHandValue() == 21){
                System.out.println("\n PARABÉNS!! Você ganhou o jogo!");
                System.exit(0); 
                break;
            } 
            System.out.print("\n Deseja comprar mais uma carta? (S/N): ");
            choice = scanner.nextLine().toUpperCase();
        }
        count++;
    }

    displayDealerHand(dealerHand, true); // Exibir a primeira carta do dealer

    // Aqui para baixo ele vai pedir se o jogador vai querer jogar novamente ou nao

    System.out.print("\n Deseja jogar novamente? (S/N): ");
    choice = scanner.nextLine().toUpperCase();
} while (choice.equals("S"));

System.out.println("\n Obrigado por jogar!");
scanner.close();
}

public static void displayPlayerHand(Player player, Card cardBought) {
    System.out.println(" Mão do jogador: " + player.getHand());
    System.out.println(" Total da mão do jogador: " + player.calculateHandValue(cardBought));
}

public static void displayDealerHand(List<Card> dealerHand, boolean showFirstCard) {
    System.out.print("\n Mão do dealer: ");
    if (showFirstCard) {
        System.out.println(dealerHand.get(0) + " e uma carta oculta.");
    } else {
        System.out.println(dealerHand);
    }
    }
    // Métodos displayHands e calculateHandValue permanecem iguais.
}
