import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    public void init(){
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

    @Test
    public void testFindByNumber(){
        //arrange
        String name = "Anna";
        String number = "8(920)723-89-72";
        String actual;
        //act
        phoneBook.add(name, number);
        actual = phoneBook.findByNumber(number);
        //assert
        Assertions.assertEquals(name, actual);
    }

    @Test
    public void testFindByNumber_IllegalArgument_throwsException(){
        //arrange
        String name = "Anna";
        String number = "8(920)723-89-72";
        String numberTwo = "8(920)723-88-72";
        //act
        phoneBook.add(name, number);
        //assert
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> phoneBook.findByNumber(numberTwo));
    }

    @Test
    public void testFindByName(){
        //arrange
        String name = "Anna";
        String number = "8(920)723-89-72";
        String actual;
        //act
        phoneBook.add(name, number);
        actual = phoneBook.findByName(name);
        //assert
        Assertions.assertEquals(number, actual);
    }

    @Test
    public void testFindByName_IllegalArgument_throwsException(){
        //arrange
        String name = "Anna";
        String number = "8(920)723-89-72";
        String nameTwo = "Ivan";
        //act
        phoneBook.add(name, number);
        //assert
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> phoneBook.findByName(nameTwo));
    }

    @Test
    public void testPrintAllNames(){
        //arrange
        List<String> names = List.of("Anna", "Boris", "Ivan");
        phoneBook.add("Ivan", "8(963)721-11-22");
        phoneBook.add("Anna", "8(920)723-89-72");
        phoneBook.add("Boris", "8(911)723-89-72");
        //act
        List<String> result = phoneBook.printAllNames();
        //assert
        Assertions.assertEquals(names,result);
    }
}
