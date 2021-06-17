/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 * Date : 19-Apr-2021
 * Time : 8:40:43 pm
 */
public class DesignLinkedList {

	
	private DoubleListNode head;
	private DoubleListNode tail;
	private int size;
	
	/**
	 * 
	 */
	public DesignLinkedList() {
		this.head = this.tail = null;
		this.size = -1;
	}
	
	/** Get the value of the index-th DoubleListNode in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(size == -1 || index > size){
            return -1;
        }
        if(size == index) return tail.data;
        DoubleListNode temp = head;
        while(temp != null && index-- > 0){
            temp = temp.next;
        }
        return temp.data;
    }
    
    /** Add a DoubleListNode of value val before the first element of the linked list. After the insertion, the new DoubleListNode will be the first DoubleListNode of the linked list. */
    public void addAtHead(int val) {
        if(size == -1){
            head = tail = new DoubleListNode(val,null,null);
        }else{
            DoubleListNode curr = new DoubleListNode(val,null,head);
            head.prev = curr;
            head = curr;
        }
        size++;
        
    }
    
    /** Append a DoubleListNode of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(size == -1){
            head = tail = new DoubleListNode(val,null,null);
        }else{
            tail.next = new DoubleListNode(val,tail,null);
            tail = tail.next;
        }
        size++;
    }
    
    /** Add a DoubleListNode of value val before the index-th DoubleListNode in the linked list. If index equals to the length of linked list, the DoubleListNode will be appended to the end of linked list. If index is greater than the length, the DoubleListNode will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(size == -1 || index == 0) {
            addAtHead(val);
        }else{
            DoubleListNode temp = head;
            while(temp != null && index-->1){
                temp = temp.next;
            }
            DoubleListNode curr = new DoubleListNode (val,temp,temp.next);
            temp.next = curr;
            if(curr.next != null)
                curr.next.prev = curr;
            size++;
        }
        
    }
    
    /** Delete the index-th DoubleListNode in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || size == 0)   return;
        if(index == size) {
            tail = tail.prev;
            tail.next = null;
        }else if(index == 0){
        	head = head.next;
        }else{
            DoubleListNode temp = head;
            while(temp != null && index--> 0){
                temp = temp.next;
            }
            DoubleListNode toDelete = temp.next;
            temp.next = 
                
            toDelete.prev = null;
            toDelete.next = null;
        }
        size--;
    }
    
    public void print() {
    	DoubleListNode temp = head;
    	while(temp != null) {
    		System.out.print(temp.data + " ");
    		temp = temp.next;
    	}
    }
	
}
