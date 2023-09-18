import java.util.*;

public class ToyLotteryModel implements Model{

    private List<Toy> toys = new ArrayList<>();

    private Queue<Toy> prizes = new PriorityQueue<>();

    @Override
    public void createNewToy(String text) {
        Toy toy = new PrizeToy(text);
        toys.add(toy);
    }

    @Override
    public void changeWeight(String text) {
        String[] data = text.split(" ");
        Integer id = Integer.parseInt(data[0]);
        Integer weight = Integer.parseInt(data[1]);
        for (int i = 0; i < toys.size(); i++) {
            if (toys.get(i).getId() == id) {
                toys.get(i).setWeight(weight);
            }
        }
    }

    @Override
    public void startLottery(Integer count) {
        for (int i = 0; i < count; i++) {
            prizes.add(getRandom());
        }
    }

    @Override
    public void givePrizes(Integer count) {
        for (int i = 0; i < count; i++) {
            System.out.println(prizes.poll());
        }
    }

    private Toy getRandom() {
        int sumWeight = 0;
        int curWeight = 0;
        for (Toy t: toys) {
            sumWeight += t.getWeight();
        }
        Integer randInt = new Random().nextInt(sumWeight);
        for (Toy t: toys) {
            if (randInt < curWeight + t.getWeight()) {
                return t;
            }
            curWeight += t.getWeight();
        }
        return null;
    }
}
