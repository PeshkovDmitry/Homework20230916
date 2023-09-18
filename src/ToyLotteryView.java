import java.util.Scanner;

public class ToyLotteryView implements View {

    private Scanner scanner;

    public ToyLotteryView(Scanner scanner) {
        this.scanner = scanner;
    }


    public String getUserInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
