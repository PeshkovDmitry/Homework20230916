package Presenter;

import Exceptions.WrongFieldsNumberException;
import Exceptions.WrongIdException;
import Exceptions.WrongPrizesCountException;
import Exceptions.WrongWeightException;
import Model.Model;
import View.View;
import View.Messages;

public class ToyLotteryPresenter implements Presenter {
    private Model model;
    private View view;

    public ToyLotteryPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onButtonClicked() {
        Boolean run = true;
        while (run) {
            String operation = view.getUserInput(Messages.MAIN_MENU);
            switch (operation) {
                case "1":
                    try {
                        model.createNewToy(
                                view.getUserInput(Messages.LOAD_NEW_TOY)
                        );
                        view.showMessage("Игрушка добавлена");
                    } catch (WrongWeightException | WrongFieldsNumberException | WrongIdException e) {
                        view.showMessage(e.getMessage());
                    }
                    break;
                case "2":
                    try {
                        model.changeWeight(
                                view.getUserInput(Messages.SET_NEW_WEIGHT)
                        );
                    } catch (WrongFieldsNumberException | WrongIdException | WrongWeightException e) {
                        view.showMessage(e.getMessage());
                    }
                    view.showMessage("Вес игрушки изменен");
                    break;
                case "3":
                    try {
                        model.startLottery(
                                Integer.parseInt(
                                        view.getUserInput(Messages.START_LOTTERY)
                                )
                        );
                        view.showMessage("Игрушки добавлены в очередь на выдачу");
                    } catch (NumberFormatException | WrongPrizesCountException e) {
                        view.showMessage("Количество игрушек должно быть целым числом");
                    }
                    break;
                case "4":
                    try {
                        model.givePrizes(
                                Integer.parseInt(
                                        view.getUserInput(Messages.GIV_PRIZES)
                                )
                        );
                        view.showMessage("Игрушки розданы");
                    } catch (NumberFormatException | WrongPrizesCountException e) {
                        view.showMessage("Количество игрушек должно быть целым числом");
                    }
                    break;
                case "5":
                    run = false;
                    break;
            }
        }
    }
}
