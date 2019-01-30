package structures;

import java.util.Comparator;
import java.util.Iterator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {
	
	public StudentArrayHeap(Comparator<P> c) {
		super(c);
	}
	
	public int getLeftChildOf(int i) {
		if(i<0) {
			throw new IndexOutOfBoundsException();
		} else {
			return 2*i+1;
		}
	}
	
	public int getRightChildOf(int i) {
		if(i<0) {
			throw new IndexOutOfBoundsException();
		} else {
			return 2*i+2;
		}
	}
	
	public int getParentOf(int i) {
		if(i<1) {
			throw new IndexOutOfBoundsException();
		} else {
			return (i-1)/2;
		}
	}
	
	public void bubbleUp(int i) {
		int hole = i;
		int parent = (hole-1)/2;
		while((hole>0) && this.comparator.compare(heap.get(hole).getPriority(), heap.get(parent).getPriority())>0) {
			this.swap(hole, parent);
			hole = parent;
			parent = (parent-1)/2;
		}
		heap.set(hole, heap.get(hole));
	}
	
	public void bubbleDown(int i) {
		int larger;
		int hole = i;
		int left = getLeftChildOf(i);
		int right = getRightChildOf(i);
		while (left<heap.size()) {
			if(right<=heap.size()-1 && this.comparator.compare(heap.get(left).getPriority(), heap.get(right).getPriority())<0) {
				larger = right;
			} else {
				larger = left;
			}
			if((this.comparator.compare(heap.get(hole).getPriority(), heap.get(larger).getPriority())>=0)) {
				break;
			} else {
			this.swap(hole, larger);
			hole = larger;
			left = (hole*2)+1;
			right = (hole*2)+2;
			}
		}
	}
	
}

