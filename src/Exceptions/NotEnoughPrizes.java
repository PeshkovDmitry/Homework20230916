package Exceptions;

public class NotEnoughPrizes extends ToyLotteryException {
    public NotEnoughPrizes(String message, String text) {
        super(message, text);
    }
}
