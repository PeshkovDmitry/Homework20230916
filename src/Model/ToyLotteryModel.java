package Model;

import Exceptions.WrongFieldsNumberException;
import Exceptions.WrongIdException;
import Exceptions.WrongPrizesCountException;
import Exceptions.WrongWeightException;
import Model.Model;

import java.util.*;

public class ToyLotteryModel implements Model {

    private List<Toy> toys = new ArrayList<>();

    private Queue<Toy> prizes = new PriorityQueue<>();

    @Override
    public void createNewToy(String text) throws WrongWeightException, WrongFieldsNumberException, WrongIdException {
        Toy toy = new PrizeToy(text);
        toys.add(toy);
    }

    @Override
    public void changeWeight(String text) throws WrongFieldsNumberException, WrongIdException, WrongWeightException {
        String[] data = text.split(" ");
        Integer id;
        if (data.length != 2)
            throw new WrongFieldsNumberException(
                    "Неправильное количество полей данных",
                    text,
                    data.length);
        try {
            id = Integer.parseInt(data[0]);
        } catch (NumberFormatException e) {
            throw new WrongIdException(
                    "Неверный формат ID, должно быть целое число",
                    data[0]
            );
        }
        try {
            Integer weight = Integer.parseInt(data[1]);
            if (weight <= 0)
                throw new WrongWeightException(
                        "Вес должен быть положительным",
                        data[2]
                );
            for (int i = 0; i < toys.size(); i++) {
                if (toys.get(i).getId() == id) {
                    toys.get(i).setWeight(weight);
                }
            }
        } catch (NumberFormatException e) {
            throw new WrongWeightException(
                    "Неверный формат веса, должно быть целое число",
                    data[2]
            );
        }
    }

    @Override
    public void startLottery(Integer count) throws WrongPrizesCountException {
        if (count <= 0)
            throw new WrongPrizesCountException(
                    "Количество разыгрываемых игрушек должно быть положительным",
                    count.toString()
            );
        for (int i = 0; i < count; i++) {
            prizes.add(getRandom());
        }
    }

    @Override
    public void givePrizes(Integer count) throws WrongPrizesCountException {
        Integer queueSize = prizes.size();
        for (int i = 0; i < count; i++) {
            PrizeGiver.getInstance().give(prizes.poll());
        }
        if (queueSize < count)
            throw new WrongPrizesCountException(
                    "Количество выдаваемых игрушек больше, чем есть в очереди. Раздали то, что есть",
                    queueSize.toString()
            );
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
