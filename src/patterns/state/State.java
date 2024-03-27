package patterns.state;

public interface State {
    void showBalance();
    void deposit(double depositAmount);
    void withdrawn(double withdrawnAmount);
}
