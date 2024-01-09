package anonymousClasses;

import java.util.Comparator;

public class SortingByLength implements Comparator<String> {
    @Override
    public int compare(String string1, String string2){
        return Integer.compare(string1.length(), string2.length());
    }
}
