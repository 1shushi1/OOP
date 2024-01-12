package lambdas;

public class Main {
    public static void main(String[] args) {
//        Action action = new Action() {
//            @Override
//            public void execute() {
//                System.out.println("Singing");
//            }
//        };
//        action.execute();
        Action lambdaAction = () -> System.out.println("lambda do it");
        lambdaAction.execute();

        ActionTo actionTo = (String text) -> {
            int sumOfNum = 0;
            int counter = 0;
            char[] arr = text.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= '0' && arr[i] <= '9') {
                    sumOfNum += Character.getNumericValue(arr[i]);
                    counter++;
                }
            }
            double avg = 1.0 * sumOfNum / counter;
            return avg;
        };
        double avg = actionTo.execute("V3as7ya6");
        System.out.println(avg);
//        AbstractActions abstractActions = () -> System.out.println("walk"); 
    }
}
