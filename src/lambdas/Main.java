package lambdas;

import java.util.Arrays;
import java.util.Comparator;

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
//        Action3 actionOne = () -> System.out.println("1");
        Action3 actionTwo = () -> System.out.println("1");
        Action3.staticMethod();
        actionTwo.defaultMethod();

        int [] arr = new int[]{4,5,8,9,0,3,1};
        //середнє парних using class and fields
        //Wrapper wrapper = new Wrapper();
//        Action4 action4 = (int [] intArr) -> {
////            wrapper = new Wrapper();
//            for (int i = 0; i < intArr.length; i++) {
//                if (intArr[i] % 2 == 0 && intArr[i] != 0){
//                    wrapper.setSum(wrapper.getSum() + intArr[i]);
//                    wrapper.setCounter(wrapper.getCounter() + 1);
//                }
//            }
//            double average = 1.0 * wrapper.getSum() / wrapper.getCounter();
//            return average;
////        };
//        double average = action4.avgValue(arr);
//        System.out.println(average);
        final int [] helper = new int[2];
        Action4 action4 = (int [] intArr) -> {
            for (int i = 0; i < intArr.length; i++) {
                if (intArr[i] % 2 == 0 && intArr[i] != 0){
                    helper[0] += intArr[i];
                    helper[1]++;
                }
            }
            double average = 1.0 * helper[0]/helper[1];
            return average;
        };
        double avgg = action4.avgValue(arr);
        System.out.println(avgg);
        //є масив типу дабл, сортонути його по спаданню
        Double [] arrDouble = new Double[]{1.5, 2.3, 4.7, 3.2, 5.8, 6.4, 9.1, 8.0, 7.6, 10.2};
        Comparator<Double> comparator = new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return -Double.compare(o1, o2);
            }
        };
        Arrays.sort(arrDouble, comparator);
        System.out.println(Arrays.toString(arrDouble));
        SortingDESC sorting = (Double [] arrDouble1) -> {
            for (int i = 0; i < arrDouble1.length; i++) {
                for (int j = i; j < arrDouble1.length; j++) {
                    if (arr[i] < arr[j]){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            return arrDouble1;
        };
        Comparator<Double> sort = (a, b) -> Double.compare(b,a);
        Arrays.sort(arrDouble, sort);
        System.out.println(Arrays.toString(arrDouble));
    }
}
