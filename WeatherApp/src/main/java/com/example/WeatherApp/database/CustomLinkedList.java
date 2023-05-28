package com.example.WeatherApp.database;

public class CustomLinkedList <T>{
    private CustomNode the_head_node;
    private CustomNode the_tail_node;
        public class CustomNode{
        private T val_in_node;
        private CustomNode next_node;
        public CustomNode(T current, CustomNode next){
            this.val_in_node = current;
            this.next_node = next;
        }
        public T getValueNode(){
            return val_in_node;
        }
        public CustomNode getNextNode(){
            return next_node;
        }
        public void setValueNode(T new_val_in_node){
            this.val_in_node = new_val_in_node;
        }
        public void setNextNode(CustomNode value_new){
            this.next_node = value_new;
        }
    }
    public CustomLinkedList(){
        this.the_head_node = null;
        this.the_tail_node = null;        
    }
    public CustomNode get_the_head(){
        return the_head_node;
    }
    public CustomNode get_the_tail(){
        return the_tail_node;
    }

    public boolean append_Node(T element){
        CustomNode node_element = new CustomNode(element, null);
        if(the_head_node == null){
            the_head_node = new CustomNode(element, null);
            the_tail_node = the_head_node;
            return true;
        }
        the_tail_node.setNextNode(node_element);
        the_tail_node = the_tail_node.next_node;
        return true;

    }

    public boolean remove_Node(T element){
        if(the_head_node == null){
            return false;
        }
        CustomNode iterateNode = the_head_node;
        CustomNode prevNode = null;
        boolean element_not_found = true;
        while((iterateNode != null) && (element_not_found == true)){
            if(iterateNode.getValueNode().equals(element)){
                element_not_found = false;
            }
            else{
                prevNode = iterateNode;
                iterateNode = iterateNode.getNextNode();
            }
        }
        if(element_not_found == true){
            return false;
        }
        if(prevNode == null){
            the_head_node = the_head_node.getNextNode();
        }
        else{
            prevNode.setNextNode(iterateNode.getNextNode());
            the_tail_node = prevNode;
        }

        return false;

    }
    public void dispArray2(){
        CustomNode iterateNode = the_head_node;
        System.out.print("[");
        while(iterateNode != null){
            System.out.print(iterateNode.getValueNode() + ", ");
            iterateNode = iterateNode.getNextNode();
        }
        System.out.println("]");


    }

    public static void main(String[] args){
        CustomLinkedList<Integer> array = new CustomLinkedList<>();
        array.append_Node(1);
        array.append_Node(2);
        array.append_Node(3);
        array.append_Node(4);
        System.out.println(array.get_the_tail().getValueNode());
        array.dispArray2();
        array.remove_Node(3);
        array.dispArray2();
        //array.dispArray2();
    }
    
}
