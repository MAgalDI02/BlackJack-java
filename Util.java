import java.util.Scanner;

public class Util {

    private static Scanner scanner = new Scanner(System.in);

    public static int makeQuestionAs(String question){
        System.out.print(question + " ?");
        int answer = scanner.nextInt();
        return answer;
    }

}