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
            players.add(new Player(1));
            players.add(new Player(2));

            for (Player player : players) {
                player.addCardToHand(deck.drawCard());
                player.addCardToHand(deck.drawCard());
            }

            List<Card> dealerHand = new ArrayList<>();
            dealerHand.add(deck.drawCard());
            dealerHand.add(deck.drawCard());
// mostra as regras do jogo BlackJack
            System.out.println("Bem-vindo ao Blackjack!");
            System.out.println("\n                 ~~ REGRAS DO JOGO BLACKJACK ~~ \n");
            System.out.println("1. Objetivo:");
            System.out.println(
                    "   - O objetivo do Blackjack é somar cartas para chegar o mais próximo possível de 21 pontos,");
            System.out.println("     sem ultrapassar esse valor.");
            System.out.println("   - Se a mão do jogador ultrapassar 21 pontos, ele perde automaticamente (bust).");
            System.out.println("   - O jogador ganha se tiver uma mão com um valor maior do que a mão do dealer,");
            System.out.println("     desde que não ultrapasse 21.");

            System.out.println("\n2. Valores das Cartas:");
            System.out.println("   - Cartas numéricas valem o valor impresso nelas (2 a 10).");
            System.out.println("   - Valete (J), Dama (Q) e Rei (K) valem cada um 10 pontos.");
            System.out.println(
                    "   - Ás (A) pode valer 1 ou 11 pontos, dependendo do que for mais benéfico para o jogador.");

            System.out.println("\n3. Desenvolvimento do Jogo:");
            System.out.println("   - O jogador recebe duas cartas iniciais.");
            System.out.println("   - O dealer também recebe duas cartas, uma delas oculta.");
            System.out.println("   - O jogador pode pedir mais cartas (hit) para tentar melhorar sua mão.");
            System.out.println("   - O jogador pode parar (stand) a qualquer momento.");
            System.out.println("   - O dealer deve pedir cartas até atingir pelo menos 17 pontos.");

            System.out.println("\n4. Vitória e Derrota:");
            System.out.println("   - O jogador ganha se sua mão for maior que a do dealer sem ultrapassar 21.");
            System.out.println("   - Se o jogador ultrapassar 21 pontos (bust), ele perde automaticamente.");
            System.out
                    .println("   - Se o jogador e o dealer tiverem mãos com o mesmo valor, o jogo é um empate (push).");
            System.out
                    .println("   - Se o jogador tiver um Blackjack natural (Ás + carta de 10 pontos) e o dealer não,");
            System.out.println("     o jogador ganha automaticamente.");
            System.out.println("\n5. Opções Adicionais:");
            System.out.println("   - Seguro (insurance): O jogador pode fazer um seguro se o dealer mostrar um Ás.");
            System.out.println(
                    "   - Split (divisão): Se o jogador tiver duas cartas do mesmo valor, ele pode dividir a mão em duas.");
            System.out.println(
                    "   - Double Down (dobrar): O jogador pode dobrar sua aposta após receber as duas primeiras cartas.");
            System.out.println("\nLembre-se de que estas são apenas regras básicas do Blackjack.");
            System.out.println("As regras podem variar dependendo da versão específica do jogo ou do cassino.");

            int count = 1;

            displayDealerHand(dealerHand, true, false);
// faz um loop para que todos os jogadores sejam utilizados, mostrando suas duas cartas iniciais 
// e se caso o jogador queira comprar mais uma carta para aumentar o valor de sua mão
            for (Player player : players) {
                System.out.printf("\n Vez do jogador %d !\n", count);
                displayPlayerHand(player, null);

                // Pergunte ao jogador se deseja comprar mais uma cartas
                System.out.print("\n Deseja comprar mais uma carta? (S/N): ");
                choice = scanner.nextLine().toUpperCase();
                while (choice.equals("S")) {
                    Card newCard = deck.drawCard();
                    player.addCardToHand(newCard);
// mostra a carta que foi comprada
                    System.out.println("\n Você comprou: " + newCard);
                    displayPlayerHand(player, newCard);
// valor da mão maior que 21
                    if (player.getTotalHandValue() > 21) {
                        System.out.println("\n Você PERDEU! Sua pontuação é maior que 21.");
                        break;
                    }
                    System.out.print("\n Deseja comprar mais uma carta? (S/N): ");
                    choice = scanner.nextLine().toUpperCase();
                }
                count++;
            }

            Player winnerPlayer = null;
            int winnerValue = 0;
            boolean isDraw = false;
            for (Player player : players) {
                // compara as cartas dos jogadores para saber qual mão tem o maior valor
                if (player.getTotalHandValue() > winnerValue && player.getTotalHandValue() <= 21) {
                    winnerPlayer = player;
                    winnerValue += player.getTotalHandValue();
            // caso o valor da mão dos jogadores forem identicos, há um empate.
                } else if (player.getTotalHandValue() == winnerValue && player.getTotalHandValue() <= 21) {
                    isDraw = true;
                }
            }
// mão do dealer para efetuar a comparação com a mão do jogador de maior valor
            int dealerHandValue = displayDealerHand(dealerHand, false, true); // Exibir a primeira carta do dealer
// dealer tem mão menor que 21 e os jogadores possuem valores em suas mãos
            if (dealerHandValue <= 21 && winnerPlayer != null) {
// caso ocorra um empate
                if (isDraw) {
                    System.out.println("\n Houve um empate entre os players.");

                    if (winnerPlayer.getTotalHandValue() > dealerHandValue){
                        System.out.println(" Ambos ganharam, pois o valor é superior ao do dealer.");
                    }
                    else {
                        System.out.println("\n O Dealer ganhou! :P");
                    }
                }
// caso não haja um empate
                else {
                   if(winnerPlayer.getTotalHandValue() > dealerHandValue){
                    System.out.println("\n O vencedor é o Player " + winnerPlayer.getId() + ". Parabéns!!!");
                   } else if(winnerPlayer.getTotalHandValue() < dealerHandValue) {
                    System.out.println(" O Dealer ganhou! :P");
                   }
                }
            }
// se a mão do dealer estourou e os jogadores não possuem valores em suas mãos(ou estouraram suas mãos)
            else {
                
                if (winnerPlayer == null){
                    System.out.println("\n Ambos jogadores perderam. :/");
                    if(dealerHandValue < 21){
                         System.out.println(" Dealer ganhou esta rodada!");
                    } else{
                        System.out.println(" Dealer passou de 21. Está fora.");
                        System.out.println(" Não houve vencedores nesta rodada!");
                    }
                   
                }
                else if (isDraw) {
                    System.out.println(" Houve um empate entre os players.");
                }
                else {
                    System.out.println("\n O vencedor é o Player " + winnerPlayer.getId() + ". Parabéns!!!");
                }
            }

            // Aqui para baixo ele vai pedir se o jogador vai querer jogar novamente ou nao

            System.out.print("\n Deseja jogar novamente? (S/N): ");
            choice = scanner.nextLine().toUpperCase();
        } while (choice.equals("S"));

        System.out.println("\n Obrigado por jogar!");
        scanner.close();
    }
// mostra a mão do jogador e automaticamente calcula seu valor total
    public static void displayPlayerHand(Player player, Card cardBought) {
        System.out.println(" Mão do jogador: " + player.getHand());
        System.out.println(" Total da mão do jogador: " + player.calculateHandValue(cardBought));
    }
// método de amostragem do dealer e suas cartas e valor de sua mão
    public static int displayDealerHand(List<Card> dealerHand, boolean showFirstCard, boolean showAllCards) {
// apenas mostra a primeira carta         
        if (showFirstCard) {
            System.out.print("\n Mão do dealer: ");
            System.out.println(dealerHand.get(0) + " e uma carta oculta.");
            return 0;
// mostra todas as cartas da mão do dealer e calcula o valor total de sua mão
        } else if (showAllCards) {
            System.out.println("\n Carta oculta do dealer é: " + dealerHand.get(1));
            int dealerTotal = dealerHand.get(0).getCustomValue() + dealerHand.get(1).getCustomValue();
            System.out.println(" Mão do Dealer: [" + dealerHand.get(0) +", " + dealerHand.get(1) + "]\n Total do Dealer é: " + dealerTotal);
            return dealerTotal;
// apenas printa as cartas do dealer
        } else {
            System.out.println(dealerHand);
            return 0;
        }
    }
    // Métodos displayHands e calculateHandValue permanecem iguais.
}
