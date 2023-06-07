package com.example.WeatherApp;
import com.example.WeatherApp.database.CustomHashMap;
import com.example.WeatherApp.model.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class TestHashMap{
    @Test
    void TestFillHash(){
        CustomHashMap<Integer> array = new CustomHashMap<>();
        boolean exceptionThrown = false;
        try{
            for(int x = 0; x < 20; ++x){
                array.obtain_element(x);
            }
        }
        catch (NullPointerException e){
            exceptionThrown = true;
        }
        assertEquals(false, exceptionThrown);
    }
    @Test
    void TestEmptyHashMap(){
        String expected = "[[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]";
        CustomHashMap<Integer> array1 = new CustomHashMap<>();
        CustomHashMap<City> array2 = new CustomHashMap<>();
        assertEquals(expected, array1.toString());
        assertEquals(expected, array2.toString());
    }
    @Test
    void TestAppendElement1(){
        String expected1 = "[[0, 20], [1, 21], [2], [], [], [], [], [], [], [], " +
        "[], [], [], [], [], [], [], [], [], [19]]";
        CustomHashMap<Integer> array1 = new CustomHashMap<>();
        array1.append_element(1); array1.append_element(2);
        array1.append_element(21); array1.append_element(0);
        array1.append_element(19); array1.append_element(20);
        assertEquals(expected1, array1.toString());
    }
    @Test
    void TestAppendElement2(){
        String expected2 = "[[], [], [Chantilly, Addis Ababa], [], [], [Rome], [], [], [], [], " +
        "[], [Kampala], [], [], [], [], [], [], [], [New York]]";
        CustomHashMap<City> array2 = new CustomHashMap<>();
        City c1 = new City("Chantilly");
        City c2 = new City("Addis Ababa"); City c3 = new City("New York");
        City c4 = new City("Rome"); City c5 = new City("Kampala");
        array2.append_element(c1); array2.append_element(c2);
        array2.append_element(c3); array2.append_element(c4);
        array2.append_element(c5);
        assertEquals(expected2, array2.toString());

    }
    public static void main(String [] args){
        TestHashMap test = new TestHashMap();
        test.TestFillHash();
        test.TestEmptyHashMap();
    }
    
}
