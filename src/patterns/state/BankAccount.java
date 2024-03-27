package patterns.state;

enum StatesStatuses {NORMAL, FROZEN, BLOCKED, OVERLIMITED, CLOSE}

public class BankAccount {
    private long cardNumber;
    private String ownerName;
    private double balance;
    private State currentState;

    public BankAccount(long cardNumber, String ownerName, double balance, StatesStatuses status) {
        this.cardNumber = cardNumber;
        this.ownerName = ownerName;
        this.balance = balance;

        if (status == StatesStatuses.NORMAL) {
            currentState = new NormalState();
        } else if (status == StatesStatuses.FROZEN) {
            currentState = new FrozenState();
        } else if (status == StatesStatuses.BLOCKED) {
            currentState = new BlockedState();
        } else if (status == StatesStatuses.OVERLIMITED) {
            currentState = new OverLimitedState();
        } else {
            currentState = new ClosedState();
        }
    }

    public void showBalance() {
        currentState.showBalance();
    }

    public void deposit(double amountToDeposit) {
        currentState.deposit(amountToDeposit);
    }

    public void withdrawn(double withdrawnAmount) {
        currentState.withdrawn(withdrawnAmount);
    }

    //inner NormalState
    private class NormalState implements State {
        @Override
        public void showBalance() {
            System.out.println("You have : " + balance + " on you balance");
        }

        @Override
        public void deposit(double depositAmount) {
            balance += depositAmount;
            System.out.println("You've successfully made a deposit of : " + depositAmount);
        }

        @Override
        public void withdrawn(double withdrawnAmount) {
            if (balance - withdrawnAmount < 0){
                System.out.println("You have not enough money");
                return;
            }
            balance -= withdrawnAmount;
            if (balance == 0){
                currentState = new OverLimitedState();
                System.out.println("You are over limit");
                return;
            }
            System.out.println("You've successfully withdraw : " + withdrawnAmount);
        }
    }

    //inner FrozenState
    private class FrozenState implements State {
        @Override
        public void showBalance() {
            System.out.println("Balance : " + balance + " on you balance");
        }
        @Override
        public void deposit(double depositAmount) {
            System.out.println("You cannot make deposit of : " + depositAmount + " while you account is frozen");
        }
        @Override
        public void withdrawn(double withdrawnAmount) {
            System.out.println("You cannot withdraw : " + withdrawnAmount + " while you account is frozen");
        }
    }

    //inner BlockedState
    private class BlockedState implements State {
        @Override
        public void showBalance() {
            System.out.println("You cannot see your balance state while you account is blocked");
        }

        @Override
        public void deposit(double depositAmount) {
            System.out.println("You cannot make deposit of : " + depositAmount + " while you account is frozen");
        }

        @Override
        public void withdrawn(double withdrawnAmount) {
            System.out.println("You cannot withdraw : " + withdrawnAmount + " while you account is frozen");
        }
    }

    //inner OverLimitedState
    private class OverLimitedState implements State {
        @Override
        public void showBalance() {
            System.out.println("Balance : " + balance + " on you balance");
        }

        @Override
        public void deposit(double depositAmount) {
            balance += depositAmount;
            if (balance >= 0){
                currentState = new NormalState();
            }
            System.out.println("You've successfully made a deposit of : " + depositAmount);
        }

        @Override
        public void withdrawn(double withdrawnAmount) {
            System.out.println("You cannot withdraw : " + withdrawnAmount + " while you account is frozen");
        }
    }

    //inner CloseState
    private class ClosedState implements State {
        @Override
        public void showBalance() {
            System.out.println("You cannot see your balance state while you account is blocked");
        }

        @Override
        public void deposit(double depositAmount) {
            System.out.println("You cannot make deposit of : " + depositAmount + " while you account is frozen");
        }

        @Override
        public void withdrawn(double withdrawnAmount) {
            System.out.println("You cannot withdraw : " + withdrawnAmount + " while you account is frozen");
        }
    }
}

