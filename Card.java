
public class Card 
{
   private final String face; // face of card ("Ace", "Deuce", ...)
   private final String suit; // suit of card ("Hearts", "Diamonds", ...)
   private int value;
   // two-argument constructor initializes card's face and suit
   public Card(String face, String suit, int value)
   {
      this.face = face;
      this.suit = suit; 
      this.value = value;

   } 

   // return String representation of Card
   public String toString() 
   { 
      return face + " de " + suit;
   } 

   public int counter(String face, int value){
      if(face == "A"){
         value+=1;
      }
      if(face == "2"){
         value+=2;
      }
      if(face == "3"){
         value+=3;
      }
      if(face == "4"){
         value+=4;
      }
      if(face == "5"){
         value+=5;
      }
      if(face == "6"){
         value+=6;
      }
      if(face == "7"){
         value+=7;
      }
      if(face == "8"){
         value+=8;
      }
      if(face == "9"){
         value+=9;
      }
      if(face == "10" || face == "J" || face ==  "Q" || face == "K"){
         value+=10;
      }
      return value;

   }
   
public int handValue(){
   return handValue(playerhand);
}
public void playerturn(){
   while (true){
      int playerscore = 
   }
}
   //fazer um if para paraatribuir os valores do 
} // end class Card