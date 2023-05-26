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
        if(the_head_node == null){
            the_head_node = new CustomNode(element, null);
            the_tail_node = the_head_node;
            return true;
        }
        the_head_node = new CustomNode(element, the_head_node);
        return true;

    }
    
}
