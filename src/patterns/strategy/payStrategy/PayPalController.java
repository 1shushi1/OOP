package patterns.strategy.payStrategy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PayPalController {
    private Path path = Path.of("paypal_clients");

    public boolean verifyAvailability(String email, String password) {
        try {
            Files.lines(path, StandardCharsets.UTF_8).map(e -> e.split(",")).filter(e -> e[0].equals(email) && e[1].equals(password));
            return true;
        } catch (IOException e) {
        }
        return false;
    }

    public boolean withdrawMoney(String email, String password, int sum) {
        List<String[]> details = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path.toString())))) {
            String empty = "";
            while ((empty = reader.readLine()) != null) {
                String[] arr = new String[3];
                String[] splitInfo = empty.split(",");
                arr[0] = splitInfo[0];
                arr[1] = splitInfo[1];
                arr[2] = splitInfo[2];
                details.add(arr);
            }
            for (String[] array : details) {
                if (array[0].equals(email) && array[1].equals(password)) {
                    if (Integer.parseInt(array[2]) >= sum) {
                        array[2] = Integer.parseInt(array[2]) - sum + "";
                    } else {
                        return false;
                    }
                }
            }

        } catch (IOException e) {
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path.toString())))) {
            for (String[] array : details) {
                writer.append(array[0] + "," + array[1] + "," + array[2] + "\n");
            }
            return true;
        } catch (IOException e) {
        }
        return false;
    }
}
