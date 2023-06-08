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
        assertFalse(exceptionThrown);
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
    @Test
    void TestAppendElement3(){
        String expected3 = "[[0], [1], [2], [3], [4], [], [], [], [], [], " +
        "[], [], [], [], [], [], [], [], [18], []]";
        CustomHashMap<Integer> array3 = new CustomHashMap<>();
        array3.append_element(0); array3.append_element(0);
        array3.append_element(1); array3.append_element(1);
        array3.append_element(1); array3.append_element(2);
        array3.append_element(3); array3.append_element(4);
        assertTrue(array3.append_element(18)); array3.append_element(18);
        assertFalse(array3.append_element(18)); array3.append_element(18);
        array3.append_element(18); array3.append_element(18);
        assertEquals(expected3, array3.toString());
        String expected4 = "[[], [], [Chantilly], [], [], [], [], [], [], [], " +
        "[], [], [], [], [], [], [], [], [], []]";
        CustomHashMap<City> array4 = new CustomHashMap<>();
        City c1 = new City("Chantilly");
        City c2 = new City("Chantilly");
        City c3 = new City("Chantilly");
        assertTrue(array4.append_element(c1));
        assertFalse(array4.append_element(c2));
        array4.append_element(c3);
        assertEquals(expected4, array4.toString());

    }
    @Test 
    void TestObtainElement1(){
        CustomHashMap<Integer> array1 = new CustomHashMap<>();
        int input[] = {0, 20, 100, 60, 54, 14, 38};
        for(int i: input){
            array1.append_element(i);
        }
        assertEquals(0, array1.obtain_element(0));
        assertEquals(20, array1.obtain_element(20));
        assertEquals(100, array1.obtain_element(100));
        assertEquals(60, array1.obtain_element(60));
        assertEquals(54, array1.obtain_element(54));
        assertEquals(14, array1.obtain_element(14));
        assertEquals(38, array1.obtain_element(38));
        assertNull(array1.obtain_element(18));
    }
    @Test
    void TestObtainElement2(){
        String city1 = "Chantilly";
        City city2 = new City("Chantilly");
        City city3 = new City("Chantilly");
        CustomHashMap<City> array2 = new CustomHashMap<>();
        array2.append_element(city2);
        assertEquals(city2, array2.obtain_element(city2));
        assertEquals(city2, array2.obtain_element(city3));
        assertEquals(city3, array2.obtain_element(city2));
        assertEquals(city2, array2.obtain_element(city1));
        assertTrue(city2 == array2.obtain_element(city2));
        assertFalse(city3 == array2.obtain_element(city3));
    }
    public static void main(String [] args){
        TestHashMap test = new TestHashMap();
        test.TestFillHash();
        test.TestEmptyHashMap();
        test.TestAppendElement3();
    }
    
}
