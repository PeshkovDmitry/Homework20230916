import Model.Model;
import Presenter.Presenter;
import View.View;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Model model = new ToyLotteryModel();
        View view = new ToyLotteryView(new Scanner(System.in));
        Presenter presenter = new ToyLotteryPresenter(model, view);
        presenter.onButtonClicked();
    }
}