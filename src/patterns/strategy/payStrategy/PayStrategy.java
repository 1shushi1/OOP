package patterns.strategy.payStrategy;

public interface PayStrategy {
    void collectPaymentDetails();
    boolean pay(int sumOfMoney);
}
