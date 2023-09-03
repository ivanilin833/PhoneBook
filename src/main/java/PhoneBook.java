import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> book = new HashMap<>();
    private int freq;

    public int add(String name, String number){
        book.put(name,number);
        return freq+=1;
    }
}
