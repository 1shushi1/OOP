package patterns.chainOfResponsibilities.atm;

public abstract class CurrencyDispencer {
    protected CurrencyDispencer next;
    public void setNext(CurrencyDispencer next){
        this.next = next;
    }
    public abstract void dispancer(Currency currency);
}
