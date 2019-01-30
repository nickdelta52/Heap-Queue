package structures;

import comparators.IntegerComparator;
import comparators.ReverseIntegerComparator;

import java.util.Comparator;
import java.util.Iterator;

public class MinQueue<V> implements PriorityQueue<Integer, V> {
	IntegerComparator c = new IntegerComparator();
	StudentArrayHeap<Integer, V> q = new StudentArrayHeap<Integer, V>(c);
	
	public PriorityQueue<Integer, V> enqueue(Integer priority, V val) {
		q.add(priority, val);
		return this;
	}
	
	public V dequeue() {
		V temp = q.heap.remove(0).getValue();
		return temp;
	}
	
	public V peek() {
		V temp = q.heap.get(0).getValue();
		return temp;
	}
	
	public Iterator<Entry<Integer, V>> iterator() {
		return q.heap.iterator();
	}
	
	public Comparator<Integer> getComparator() {
		return c;
	}
	
	public int size() {
		return q.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
}

