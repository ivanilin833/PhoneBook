import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PhoneBookTest {
    private static PhoneBook phoneBook;

    @BeforeAll
    public static void init(){
        phoneBook = new PhoneBook();
    }

    @Test
    public void testAdd(){
        //arrange
        int freq;
        //act
        phoneBook.add("Ivan", "8(963)721-11-22");
        phoneBook.add("Anna", "8(920)723-89-72");
        freq = phoneBook.add("Misha", "8(910)123-11-22");
        //assert
        Assertions.assertEquals(3, freq);
    }
}
