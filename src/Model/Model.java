package Model;

import Exceptions.WrongFieldsNumberException;
import Exceptions.WrongIdException;
import Exceptions.WrongPrizesCountException;
import Exceptions.WrongWeightException;

public interface Model {

    void createNewToy(String text) throws WrongWeightException, WrongFieldsNumberException, WrongIdException;

    void changeWeight(String text) throws WrongFieldsNumberException, WrongIdException, WrongWeightException;

    void startLottery(Integer count) throws WrongPrizesCountException;

    void givePrizes(Integer count) throws WrongPrizesCountException;
}
