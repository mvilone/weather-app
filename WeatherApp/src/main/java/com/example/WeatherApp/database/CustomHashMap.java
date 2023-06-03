package com.example.WeatherApp.database;
import com.example.WeatherApp.model.*;
/*import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.Comparator;*/
public class CustomHashMap<T> extends CustomLinkedList<T>{
    
    private CustomLinkedList<T>[] array_in_Hash;
    @SuppressWarnings("unchecked")
    public CustomHashMap(){
        array_in_Hash = new CustomLinkedList[20];
        fillHash();
    }
    public void fillHash(){
        for(int x = 0; x < array_in_Hash.length; ++x){
            array_in_Hash[x] = new CustomLinkedList<T>();
        }
    }
    public boolean append_element(T element){
        int index_to_place = generate_Hash_index(element);
        if(obtain_element(element) != null){
            return false;
        }
        array_in_Hash[index_to_place].append_Node(element);
        return true;
    }
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
    public boolean remove_element(T element){
        int index_to_place = element.hashCode() % array_in_Hash.length;
        CustomLinkedList<T> linked_list;
        linked_list = array_in_Hash[index_to_place];
        return linked_list.remove_Node(element);
    }
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
    /*public boolean add(T element){
        return append_element(element);
    }
    public void add(int index, T element){
        add(element);
    }
    public boolean addAll(Collection<? extends T> collection){
        return false;
    }
    public boolean addAll(int index, Collection<? extends T> collection){
        return false;
    }
    public void clear(){

    }
    @SuppressWarnings("unchecked")
    public boolean contains(Object element){
        if(obtain_element((T)element) != null){
            return true;
        }
        return false;

    }
    public boolean containsAll(Collection<?> collection){
        return false;
    }
    public boolean equals(Object element){
        return this.equals(element);
    }
    public T get(int index){
        return null;
    }
    public int hashCode(){
        return 0;
    }
    public int indexOf(Object o){
        return -1;
    }
    public boolean isEmpty(){
        return false;
    }
    public Iterator<T> iterator(){
        return null;
    }
    public int lastIndexOf(Object o){
        return -1;
    }
    public ListIterator<T> listIterator(){
        return null;
    }
    public T remove(int index){
        return null;
    }
    @SuppressWarnings("unchecked")
    public boolean remove(Object object){
        return remove_element((T)object);
    }
    public void replaceAll(Collection<?> collection){

    }
    public T set(int index, T element){
        return null;
    }
    public int size(){
        return -1;
    }
    public void sort(Comparator<? super T> collection){

    }
    public Spliterator<T> spliterator(){
        return null;
    }
    public List<T> subList(int fromIndex, int toIndex){
        return null;
    }
    public Object[] toArray(){
        return null;
    }
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] array){
        for(int x = 0; x < array_in_Hash.length; ++x){
            array[x] = (T) array_in_Hash[x];

        }
        return array;
    }
    public boolean retainAll(Collection<?> collection){
        return false;
    }
    public boolean removeAll(Collection<?> collection){
        return false;
    }
    public ListIterator<T> listIterator(int index){
        return null;
    }*/

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
