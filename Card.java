public class Card {
    private int value;

    public Card(int value) {
        this.value = value;
    }

    public int getValue() {
        if (value > 10) {
            return 10;  // Valor das cartas de 10 a 13 (rei, rainha, valete) é 10.
        }
        return value;
    }

    @Override
    public String toString() {
        if (value == 11) return "As";
        if (value == 10) return "10";
        if (value == 12) return "Valete";
        if (value == 13) return "Rainha";
        if (value == 14) return "Rei";
        return Integer.toString(value);
    }
}

