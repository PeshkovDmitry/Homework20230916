public class ToyLotteryPresenter implements Presenter{
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
                    break;
                case "2":
                    model.changeWeight(
                            view.getUserInput(Messages.SET_NEW_WEIGHT)
                    );
                    break;
                case "3":
                    model.startLottery(
                            Integer.parseInt(
                                    view.getUserInput(Messages.START_LOTTERY)
                            )
                    );
                    break;
                case "4":
                    model.givePrizes(
                            Integer.parseInt(
                                    view.getUserInput(Messages.GIV_PRIZES)
                            )
                    );
                    break;
                case "5":
                    run = false;
                    break;
            }
        }
    }


}
