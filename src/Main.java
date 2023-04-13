import java.util.Scanner;
import WorkProcess.Data;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите данные персоны");
        Scanner scanner = new Scanner(System.in);

        String buffer = scanner.nextLine();
        try {
            String resultString = Data.stringSplit(buffer);
            System.out.println(resultString);
        }catch (Exception e){
            System.out.println("Wrong data");
        }
    }
}

