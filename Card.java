public class Card {
    private int value;
    private boolean isAs = false;

    public Card(int value) {
        this.value = value;
        if (this.value == 11 || this.value == 1){
            isAs = true;
        }
    }

    public int getValue(){
        return this.value;
    }

    public int getCustomValue() {
        if (isAs){
            int asValue = Util.makeQuestionAs(" Você recebeu um Ás, qual valor deseja para ele (1 ou 11)");
            
            return asValue;
        }
        else if (value > 10) {
            return 10;  // Valor das cartas de 10 a 13 (rei, rainha, valete) é 10.
        }
        
        return value;
    }

    @Override
    public String toString() {
        if (value == 11 || value == 1) return "A";
        if (value == 10) return "10";
        if (value == 12) return "J";
        if (value == 13) return "Q";
        if (value == 14) return "K";
        return Integer.toString(value);
    }
}

