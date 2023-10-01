import java.util.Scanner;

public class Util {

    private static Scanner scanner = new Scanner(System.in);
// cria um método para chamar a questão do valor dos Aces
    public static int makeQuestionAs(String question){
        System.out.print(question + " ?");
        int answer = scanner.nextInt();
        return answer;
    }

}