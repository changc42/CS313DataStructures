import java.*;

public class MinHeapPriorityQueue<Integer>{
   private Integer data[];
   private int size;
   public MinHeapPriorityQueue(){
      this(100);
   }
   public MinHeapPriorityQueue(int cap){
      size = 0;
      data = (Integer[]) new Comparable[cap];
   }
   public MinHeapPriorityQueue(Integer[] a){
		   data = (Integer[]) new Comparable[a.length];
		   for(int i=0; i<a.length; i++){
				data[i]=a[i];
		   }
		   for(int i=a.length-1; i>=0; i--){
			   bubbleDown(i);
		   }
   }
   public void add(Integer d) throws Exception{
      if (size >= data.length - 1) throw new Exception("Full");
      data[++size] = d;
      bubbleUp(size);
   }
   public Integer peek() throws Exception{
      if (size <= 0) throw new Exception("Empty");
      return data[1];
   }
   public Integer remove() throws Exception{
      if (size <= 0) throw new Exception("Empty");
      Integer ans = data[1];
      data[1] = data[size--];
      bubbleDown(1);
      return ans;
   }
   private void swap2(int i, int j){
      Integer temp = data[i];
      data[i] = data[j];
      data[j] = temp;
   }
   private void bubbleUp(int i){
      if (i <= 1) return;
      if (data[i].compareTo(data[i / 2]) >= 0) return;
      swap2(i, i / 2);
      bubbleUp(i / 2);
   }
   private void bubbleDown(int i){
      if ((i * 2) > size) return;
      int min_i = i * 2;
      if (min_i + 1 <= size) {
         if (data[min_i].compareTo(data[min_i + 1]) > 0)
	    min_i += 1;
      }
      if (data[i].compareTo(data[min_i]) <= 0) return;
      swap2(i, min_i);
      bubbleDown(min_i);
   }
   public static void main(String[] args){
      int[] a = {3,2,7,5,1,6,4,8,9};
	  Integer[] b = new Integer[a.length];
	  for(int i=0; i<a.length; i++){
		  b[i]=a[i];
	  }
      try {
         long time, nextTime;
         time = System.nanoTime();
         MinHeapPriorityQueue minHeap = new MinHeapPriorityQueue(a.length + 1);
         for (int i = 0; i < a.length; ++i){
            minHeap.add(a[i]);
         }
         nextTime = System.nanoTime();
         System.out.println("\tTime used: " + (nextTime - time) + " nseconds");
         for (int i = 0; i < a.length; ++i){
	    System.out.print(minHeap.remove() + ",");
	 }
         System.out.println();
      }catch (Exception e){
	 e.printStackTrace();
      }
      try {
         long time, nextTime;
         time = System.nanoTime();
         MinHeapPriorityQueue<Integer> minHeap = new MinHeapPriorityQueue<>(b);
         nextTime = System.nanoTime();
         System.out.println("\tTime used: " + (nextTime - time) + " nseconds");
         for (int i = 0; i < a.length; ++i){
	    System.out.print(minHeap.remove() + ",");
	 }
         System.out.println();
      }catch (Exception e){
	 e.printStackTrace();
      }
   }

}