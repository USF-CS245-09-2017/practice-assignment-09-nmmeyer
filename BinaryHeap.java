import java.util.*;
public class BinaryHeap{
	int size; 
	int[] data; 
	public BinaryHeap() {
		data = new int[10];
		size = 0; 
	}
	
	public int remove(){
		if (size == 0) throw new NoSuchElementException(); 
		
		swap (data, 0, size - 1);
		--size;
		if (size !=0){
			shiftdown(0);
			
		}
		return data[size];
	}

	public void add (int item){
	if (size >= data.length) {
		growarray();
	}
	data[size++] = item; 
	int current = size - 1;
	int parent = (current-1)/2;
	while (current != 0 && data[current] < data[parent]){
		swap (data, current, parent);
		current = parent; 
		parent = (current-1)/2; 
		}
	}

	private void shiftdown(int pos){
	
	if(pos*2+1< size){
		int child =pos*2+1;
		if (child+1 < size && data[child+1] < data[child]){
			child = child +1;
		}
		if (data[pos] > data[child]){
			swap(data,child,pos);
			shiftdown(child);
		}
	}
	}

	private void swap (int [] arr, int pos1, int pos2){
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp; 
	}
	
	private void growarray () {
		int [] temp = new int[data.length*2];
		System.arraycopy(data, 0, temp, 0, data.length);
		data = temp;
				
	}




}