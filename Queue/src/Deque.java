import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	
   private int N;                 // number of elements in deque
   private Node<Item> first;
   private Node<Item> last;
   private class Node<Item>{
	   Item item;
	   Node<Item> previous;
	   Node<Item> next;
   }
   
   // construct an empty deque
   public Deque() {
	   first = null;
	   last = null;
	   N = 0;
   }
   // is the deque empty?
   public boolean isEmpty() {
	   return (N==0);
   }
   // return the number of items on the deque
   public int size() {
	   return N;
   }
   // add the item to the front
   public void addFirst(Item item) {
	   if (item == null) {throw new NullPointerException();}
	   Node<Item> newFirst = new Node<Item>();
	   newFirst.item = item;
	   newFirst.previous = null;
	   newFirst.next = first;
	   if(isEmpty()) {last = newFirst;}
	   else {first.previous = newFirst;}
	   first = newFirst;
	   N++;
   }
   // add the item to the end
   public void addLast(Item item){
	   if(item == null) {throw new NullPointerException();}
	   Node<Item> newLast = new Node<Item>();
	   newLast.item = item;
	   newLast.previous = last;
	   newLast.next = null;
	   if(isEmpty()) {first = newLast;}
	   else {last.next = newLast;}
	   last = newLast;
	   N++;
   }
   // remove and return the item from the front
   public Item removeFirst() {
	  if(isEmpty()) {throw new NoSuchElementException("Queue is empty");}
	  Item item = first.item;
	  first = first.next;
	  N--;
	  if(isEmpty()) {last = null;}
	  else {first.previous = null;}
	  return item;
   }
   // remove and return the item from the end
   public Item removeLast() {
	   if(isEmpty()) {throw new NoSuchElementException("Queue is empty");}
	   Item item = last.item;
	   last = last.previous;
	   N--;
	   if(isEmpty()) {first = null;}
	   else{last.next = null;}
	   return item;
   
   }
   
   // return an iterator over items in order from front to end
   public Iterator<Item> iterator(){
	   return new DequeueIterator<item>(first);
   }
   
   
}












