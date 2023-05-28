package com.example.WeatherApp.database;

public class CustomHashMap<T> extends CustomLinkedList<T> {
    
    private CustomLinkedList<T>[] array_in_Hash;
    private int size_of_array;
    @SuppressWarnings("unchecked")
    public CustomHashMap(){
        array_in_Hash = new CustomLinkedList[20];
        fillHash();
        size_of_array = -1;
    }
    public void fillHash(){
        for(int x = 0; x < array_in_Hash.length; ++x){
            array_in_Hash[x] = new CustomLinkedList<T>();
        }
    }
    public boolean append_element(T element){
        int index_to_place = element.hashCode() % array_in_Hash.length;
        if(obtain_element(element) != null){
            return false;
        }
        size_of_array += 1;
        array_in_Hash[index_to_place].append_Node(element);
        return true;
    }
    public T obtain_element(T element){
        int index_to_place = element.hashCode() % array_in_Hash.length;
        size_of_array += 1;
        CustomNode iterateNode = array_in_Hash[index_to_place].get_the_head();
        while(iterateNode != null){
            if(iterateNode.getValueNode().equals(element)){
                return iterateNode.getValueNode();
            }
            iterateNode = iterateNode.getNextNode();
        }
        return null;
    }
    void dispArray(){
        System.out.println(array_in_Hash[2]+ " hello");
        System.out.print("[");
        int index = 0;
        for(CustomLinkedList<T> x: array_in_Hash){
            CustomNode iterateNode = x.get_the_head();
            while(iterateNode != null){
                System.out.print(iterateNode.getValueNode() + " index:" + index + ", ");
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
        System.out.println(array.obtain_element(19)+ " element obtained");
        

    }

    
    
}
