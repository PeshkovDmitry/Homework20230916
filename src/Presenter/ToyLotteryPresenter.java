package Presenter;

import Model.Model;
import Presenter.Presenter;

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
                    model.createNewToy(
                            view.getUserInput(Messages.LOAD_NEW_TOY)
                    );
                    view.showMessage("Игрушка добавлена");
                    break;
                case "2":
                    model.changeWeight(
                            view.getUserInput(Messages.SET_NEW_WEIGHT)
                    );
                    view.showMessage("Вес игрушки изменен");
                    break;
                case "3":
                    model.startLottery(
                            Integer.parseInt(
                                    view.getUserInput(Messages.START_LOTTERY)
                            )
                    );
                    view.showMessage("Игрушки добавлены в очередь на выдачу");
                    break;
                case "4":
                    model.givePrizes(
                            Integer.parseInt(
                                    view.getUserInput(Messages.GIV_PRIZES)
                            )
                    );
                    view.showMessage("Игрушки розданы");
                    break;
                case "5":
                    run = false;
                    break;
            }
        }
    }
}
