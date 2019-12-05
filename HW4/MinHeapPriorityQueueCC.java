import java.*;

class MinHeapPriorityQueueCC{
	Integer[] data;
	int size;
	MinHeapPriorityQueueCC(int cap){
		size=0;
		data = new Integer[cap];
	}
	MinHeapPriorityQueueCC(int[] a){
		size = a.length;
		data = new Integer[a.length+1];
		for(int i=1; i<a.length+1; i++){
			data[i]=a[i-1];
		}
		for(int i=a.length; i>0; i--){
			bubbleDown(i);
		}
	}
	void swap2(int i, int j){
		Integer temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	void bubbleDown(int i){
		if ((i * 2) > size) return;
		int min_i = i * 2;
		if (min_i + 1 <= size) {
			if (data[min_i].compareTo(data[min_i + 1]) > 0) min_i += 1;
		}
		if (data[i].compareTo(data[min_i]) <= 0) return;
		swap2(i, min_i);
		bubbleDown(min_i);
	}
	Integer remove() throws Exception{
      if (size <= 0){
		  System.out.println("size is <=0");
		  throw new Exception("Empty");
			
	  }
      Integer ans = data[1];
      data[1] = data[size--];
      bubbleDown(1);
      return ans;
   }
	public static void main(String[] args){
		int[] a = {3,2,7,5,1,6,4,8,9};
		MinHeapPriorityQueueCC b = new MinHeapPriorityQueueCC(a);
		try{
			int temp = b.size;
			for (int i = 0; i < temp; i++){
				System.out.println("removed: " +b.remove());
			}
		}catch(Exception e){
			System.out.println("Error: " +e.getMessage());
		}
		System.out.println();
	}
}