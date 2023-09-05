public class DeckOfCardsTest
{
   // execute application
   public static int main(String[] args)
   {
      DeckOfCards myDeckOfCards = new DeckOfCards();
      myDeckOfCards.shuffle(); // place Cards in random order
      
      // print all 52 Cards in the order in which they are dealt
      for (int i = 1; i <= 52; i++)
      {
         System.out.printf("%-19s", myDeckOfCards.dealCard());
         myDeckOfCards.counter();

		 if (i % 4 == 0) // output a newline after every fourth card
		    System.out.println();
      } 
      return 0;
   } 
} // end class DeckOfCardsTest
