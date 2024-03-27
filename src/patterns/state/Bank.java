package patterns.state;

public class Bank {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount(1234567812345678l, "Mykola", 823, StatesStatuses.NORMAL);
        BankAccount bankAccount2 = new BankAccount(1234567812345688l, "Tymothy", 1000.45, StatesStatuses.FROZEN);
        BankAccount bankAccount3 = new BankAccount(1234567812345699l, "Johnathan", 100234.76, StatesStatuses.BLOCKED);
        BankAccount bankAccount4 = new BankAccount(1234567812345632l, "Vasyl", 823.98, StatesStatuses.OVERLIMITED);
        BankAccount bankAccount5 = new BankAccount(1234567812345671l, "Jaroslav", 14356.98, StatesStatuses.CLOSE);

        System.out.println("Bank account no. 1");
        bankAccount1.showBalance();
        bankAccount1.deposit(123);
        bankAccount1.withdrawn(45);

        System.out.println("Bank account no. 2");
        bankAccount2.showBalance();
        bankAccount2.deposit(65);
        bankAccount2.withdrawn(455);

        System.out.println("Bank account no. 3");
        bankAccount3.showBalance();
        bankAccount3.deposit(123);
        bankAccount3.withdrawn(456);

        System.out.println("Bank account no. 4");
        bankAccount4.showBalance();
        bankAccount4.deposit(12);
        bankAccount4.withdrawn(456);

        System.out.println("Bank account no. 5");
        bankAccount5.showBalance();
        bankAccount5.deposit(9888);
        bankAccount5.withdrawn(12344);
    }
}
