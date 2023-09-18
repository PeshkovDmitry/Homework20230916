package Model;

import java.io.FileWriter;
import java.io.IOException;

public class PrizeGiver {
    private static PrizeGiver prizeGiver;

    private FileWriter fileWriter;

    public static PrizeGiver getInstance() {
        if (prizeGiver == null) {
            prizeGiver = new PrizeGiver();
        }
        return prizeGiver;
    }

    public void give(Toy toy) {
        try (FileWriter fileWriter = new FileWriter("prizes.txt", true)) {
            fileWriter.write(toy.toString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
