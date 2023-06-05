package com.example.WeatherApp.database;
import com.example.WeatherApp.model.*;
/**
 * This class implements our Custom HashMap that uses seperate chaining with a
 * custom build linked list. So uses an array of size 20 of linked list.
 * @param = <T> The type for items that go into each linked list.
 */
public class CustomHashMap<T> extends CustomLinkedList<T>{
    /**
     * The array of linked list variable.
     */
    private CustomLinkedList<T>[] array_in_Hash;
    /**
     * This method is the constructor for the CustomHashMap.
     * Initializes the array_in_Hash and fills it up with the Custom Linked list.
     */
    @SuppressWarnings("unchecked")
    public CustomHashMap(){
        array_in_Hash = new CustomLinkedList[20];
        fillHash();
    }
    /**
     * This method fills each index of array_in_Hash with a new object of Linked List.
     */
    public void fillHash(){
        for(int x = 0; x < array_in_Hash.length; ++x){
            array_in_Hash[x] = new CustomLinkedList<T>();
        }
    }
    /**
     * This method Hashes to a position and appends an element to the linked list
     * that exists at the index Hash position.
     * @param element is the item of type T placed into the HashMap.
     * @return False in this case if item already exists in HashMap. True otherwise.
     */
    public boolean append_element(T element){
        int index_to_place = generate_Hash_index(element);
        if(obtain_element(element) != null){
            return false;
        }
        array_in_Hash[index_to_place].append_Node(element);
        return true;
    }
    /**
     * This method hashes to an index postion on array_in_Hash
     * then iterates through linked list at that position to find element.
     * @param element of type Object to find in the array_in_Hash. Object to allow any input.
     * @return the element is returned if it exists in array_in_Hash, null otherwise.
     */
    public T obtain_element(Object element){
        int index_to_place = generate_Hash_index(element);
        CustomNode iterateNode = array_in_Hash[index_to_place].get_the_head();
        while(iterateNode != null){
            if(iterateNode.getValueNode().equals(element)){
                return iterateNode.getValueNode();
            }
            iterateNode = iterateNode.getNextNode();
        }
        return null;
    }
    /**
     * This method hashes to the index position that the element should exist at
     * iterated through that linked list, and removed that object.
     * @param element is the element to remove.
     * @return
     */
    public boolean remove_element(Object element){
        int index_to_place = element.hashCode() % array_in_Hash.length;
        CustomLinkedList<T> linked_list;
        linked_list = array_in_Hash[index_to_place];
        return linked_list.remove_Node(element);
    }
    /**
     * This method gived either getHashCode() index of a function if it extends CommonWeatherData
     * or gives the hash code index of the element if the class does not extend CommonWeatherData.
     * @param element is the element to produce the Hash code index for.
     * @return Hash code index of the element is returned.
     */
    public int generate_Hash_index(Object element){
        CommonWeatherData object_class;
        String city_name;
        if(element instanceof CommonWeatherData){
            object_class = (CommonWeatherData) element;
            return object_class.getHashCode() % array_in_Hash.length;
        }
        else{
            if(element instanceof String){
                city_name = (String)element;
                return city_name.toLowerCase().hashCode() % array_in_Hash.length;
            }
            return element.hashCode() % array_in_Hash.length;
        }

    }
    public void dispArray(){
        System.out.println(array_in_Hash[2]+ " hello");
        System.out.print("[");
        int index = 0;
        for(CustomLinkedList<T> x: array_in_Hash){
            CustomNode iterateNode = x.get_the_head();
            while(iterateNode != null){
                System.out.println(true);
                System.out.print(iterateNode.getValueNode().toString() + " index:" + index + ", ");
                iterateNode = iterateNode.getNextNode();
            }
            index += 1;
        }
        System.out.print("]");
        System.out.println();
    }
    

    public static void main(String[] args){
        CustomHashMap<Integer>array = new CustomHashMap<>();
        
        array.append_element(1);
        
        
        array.append_element(2);
        array.append_element(21);
        array.append_element(0);
        array.append_element(19);
        array.append_element(20);
        array.append_element(20);
        array.dispArray();
        array.remove_element(20);
        array.remove_element(0);

        array.dispArray();
        System.out.println(array.obtain_element(19)+ " element obtained");
        String s = "maher";
        String o = "maher";
        System.out.println(s.hashCode());
        System.out.println(o.hashCode());
        

    }

    
    
}
