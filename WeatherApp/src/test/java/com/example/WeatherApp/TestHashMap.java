package com.example.WeatherApp;
import com.example.WeatherApp.database.CustomHashMap;
import com.example.WeatherApp.model.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class TestHashMap{
    @Test 
    void TestNullInput1(){
        CustomHashMap<Integer> array = new CustomHashMap<>();
        boolean appendElement = false;
        try{
            array.append_element(null);
        }
        catch (NullPointerException e){
            appendElement = true;
        }
        assertTrue(appendElement);
    }
    @Test
    void TestNullInput2(){
        CustomHashMap<Integer> array = new CustomHashMap<>();
        boolean generateHashIndex = false;
        try{
            array.generate_Hash_index(null);
        }
        catch (NullPointerException e){
            generateHashIndex = true;
        }
        assertTrue(generateHashIndex);
        
    }
    @Test
    void TestNullInput3(){
        CustomHashMap<Integer> array = new CustomHashMap<>();
        boolean obtainElement = false;
        try{
            array.obtain_element(null);
        }
        catch (NullPointerException e){
            obtainElement = true;
        }
        assertTrue(obtainElement);
    }
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
        int input[] = {1, 2, 21, 0, 19, 20};
        CustomHashMap<Integer> array1 = new CustomHashMap<>();
        for(int i:input){
            array1.append_element(i);
        }
        assertEquals(expected1, array1.toString());
    }
    @Test
    void TestAppendElement2(){
        String expected2 = "[[], [], [Chantilly, Addis Ababa], [], [], [Rome], [], [], [], [], " +
        "[], [Kampala], [], [], [], [], [], [], [], [New York]]";
        City input[] = {new City("Chantilly"), new City("Addis Ababa")
        , new City("New York"), new City("Rome"), new City("Kampala")};
        CustomHashMap<City> array2 = new CustomHashMap<>();
        for(City c: input){
            array2.append_element(c);
        }
        assertEquals(expected2, array2.toString());

    }
    @Test
    void TestAppendElement3(){
        String expected3 = "[[0], [1], [2], [3], [4], [], [], [], [], [], " +
        "[], [], [], [], [], [], [], [], [18], []]";
        int input[] = {0, 0, 1, 1, 1, 2, 3, 4};
        CustomHashMap<Integer> array3 = new CustomHashMap<>();
        for(int i: input){
            array3.append_element(i);
        }
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
        assertFalse(array4.append_element(c3));
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
    @Test
    void TestRemoveElement(){
        String expectedBefore1 = "[[0, 40], [1, 21, 41], [], [], [], [], [], [], [], [], " + 
        "[], [], [], [], [], [], [], [], [], [19, 39, 58]]";
        String expectedBefore2 = "[[40], [], [], [], [], [], [], [], [], [], " + 
        "[], [], [], [], [], [], [], [], [], [58]]";

    }
    public static void main(String [] args){
        TestHashMap test = new TestHashMap();
        test.TestFillHash();
        test.TestEmptyHashMap();
        test.TestAppendElement3();
    }
    
}
