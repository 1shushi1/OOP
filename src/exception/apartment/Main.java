package exception.apartment;

public class Main {
    public static void main(String[] args){
        Domophone domophone = new Domophone();
        Building building = new Building();
        building.connectDomophone(domophone);
    }
}
