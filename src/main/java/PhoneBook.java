import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PhoneBook {
    private Map<String, String> book = new HashMap<>();
    private int freq;

    public int add(String name, String number){
        book.put(name,number);
        return freq+=1;
    }

    public String findByNumber(String number){
        Optional<String> result = book.entrySet()
                .stream()
                .filter(entry -> number.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();

        if(result.isPresent()){
            return result.get();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String findByName(String name){
        return null;
    }
}
