package patterns.strategy.payStrategy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CreditCardController {
    private Path path = Path.of("credit_cards");

    public boolean verifyAvailability(String cardNumber, String cvv, Date date) {
        int month = date.getMonth();
        int year = date.getYear();
        try {
            Files.lines(path, StandardCharsets.UTF_8).map(e -> e.split(",")).filter(e -> e[0].equals(cardNumber) && e[2].equals(cvv)
                    && Integer.parseInt(e[3].split("/")[0]) == month && Integer.parseInt(e[3].split("/")[1]) == year);
            return true;
        } catch (IOException e) {
        }
        return false;
    }

    public boolean withdrawMoney(String cardNumber, String cvv, int sum, Date expirationDate) {
        int month = expirationDate.getMonth();
        int year = expirationDate.getYear() - 100;
        List<String[]> details = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path.toString())))) {
            String empty = "";
            while ((empty = reader.readLine()) != null) {
                String [] arr = empty.split(",");
                details.add(arr);
            }
            for (String [] array : details){
                if (array[0].equals(cardNumber) && array[2].equals(cvv) && Integer.parseInt(array[3].split("/")[0]) == month
                        && Integer.parseInt(array[3].split("/")[1]) == year){
                    if (Integer.parseInt(array[1]) >= sum){
                        array[1] = Integer.parseInt(array[1]) - sum + "";
                    }
                }
            }
        } catch (IOException e) {
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path.toString())))) {
            for (String[] array : details) {
                writer.append(array[0] + "," + array[1] + "," + array[2] + "," + array[3] + "\n");
            }
            return true;
        } catch (IOException e) {
        }
        return false;
    }
}
