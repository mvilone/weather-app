package com.example.WeatherApp.database;
/**
 * This class implements our Custom Linked List which is used for the CustomHashMap.
 * @param = <T> allows the Linked list to be of any type.
 */
public class CustomLinkedList <T>{
    /**
     * This is the first Node of the CustomLinked list.
     */
    private CustomNode the_head_node;
    /**
     * This is the last Node of the CustomLinked list.
     */
    private CustomNode the_tail_node;
    /**
     * This class implements a CustomNode class for the CustomLinkedList.
     * Uses CusomLinkedList's <T> for variable.
     */
    public class CustomNode{
        /**
         * The value of type T that exists in a Node.
         */
        private T val_in_node;
        /**
         * Of type CustomNode, points to the next_node of the current node.
         */
        private CustomNode next_node;
        /**
         * This is the constructor for the Custom node class.
         * @param current is the value that exists in the node.
         * @param next is the next node that a current node has.
         */
        public CustomNode(T current, CustomNode next){
            this.val_in_node = current;
            this.next_node = next;
        }
        /**
         * This method gives back the value contained in an instance of a node.
         * @return value within an instance of a node.
         */
        public T getValueNode(){
            return val_in_node;
        }
        /**
         * This method gives back the next node linked to an instance of a node.
         * @return is the next node linked to an instance of a node.
         */
        public CustomNode getNextNode(){
            return next_node;
        }
        /**
         * This method sets a value within a node to new_val_in_node
         * @param new_val_in_node is the new value that nodes value will be updated to.
         */
        public void setValueNode(T new_val_in_node){
            this.val_in_node = new_val_in_node;
        }
        /**
         * This method sets the next node varible linked to an instance of a node
         * to a new node.
         * @param value_new is the CustomNode that a next node variable linked instance of a node is set to.
         */
        public void setNextNode(CustomNode value_new){
            this.next_node = value_new;
        }
    }
    /**
     * This is the constructor custom linked list and sets head node and tail node to null.
     */
    public CustomLinkedList(){
        this.the_head_node = null;
        this.the_tail_node = null;        
    }
    /**
     * This method gets the first node of the linked list.
     * @return the_head_node which is the first node of the linkedList.
     */
    public CustomNode get_the_head(){
        return the_head_node;
    }
    /**
     * This method gets the last node of the linked list.
     * @return the_tail_node which is the last node of the linkedList.
     */
    public CustomNode get_the_tail(){
        return the_tail_node;
    }
    /**
     * This method adds an element to the linked list at the end of it.
     * @param element is the value of type to place in the linked list.
     * @return true if it was successfully added.
     */
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
    /**
     * This method removed a node from a linked list.
     * @param element of type Object is what is removed from the linked list.
     * @return true if the element is found in the linked list and successfully removed, false otherwise.
     */
    public boolean remove_Node(Object element){
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

        return true;

    }
    public String toString(){
        String total = "[";
        CustomNode iterateNode = the_head_node;
        while(iterateNode != null){
            if(iterateNode.getNextNode() != null){
                total += iterateNode.getValueNode().toString() + ", ";
            }
            else{
                total += iterateNode.getValueNode().toString();
            }
            iterateNode = iterateNode.getNextNode();
        }
        total += "]";
        return total;


    }

    public static void main(String[] args){
        CustomLinkedList<Integer> array = new CustomLinkedList<>();
        array.append_Node(1);
        array.append_Node(2);
        array.append_Node(3);
        array.append_Node(4);
        System.out.println(array.get_the_tail().getValueNode());
        System.out.println(array);
        array.remove_Node(3);
        System.out.println(array);
        //array.dispArray2();
    }
    
}