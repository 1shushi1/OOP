package patterns.strategy.payStrategy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductController {
    public static List<Product> convertedListOfProducts(String path){
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))){
            String empty = "";
            while ((empty = reader.readLine()) != null){
                String [] info = empty.split(",");
                products.add(new Product(info[0], Integer.parseInt(info[1])));
            }
        } catch (IOException e){
        }
        return products;
    }
}
