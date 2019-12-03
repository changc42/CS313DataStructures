public class MergeSort{
   public static void mergeSort(int[] a, int l, int h){
      if (l >= h) return;
      int mid = (h + l) / 2;
      mergeSort(a, l, mid); 
      mergeSort(a, mid + 1, h);
      merge(a, l, mid + 1, h); 
   }
   static void merge(int[] a, int l, int m, int h){ //m is first element of second partition
		int middle = m;
		int[] temp = new int[a.length];
		for(int i=0; i<a.length; i++){
			temp[i]=a[i];
		}
		for(int i=l; i<=h; i++){
			if(l>=middle){
				temp[i]=a[m];
				m++;
			}
			else if(m>h){
				temp[i]=a[l];
				l++;
			}
			else if(a[l]<=a[m]){
				temp[i]=a[l];
				l++;
			}
			else if(a[m]<a[l]){
				temp[i]=a[m];
				m++;
			}
	    }
		for(int i=0; i<a.length; i++){
			a[i]=temp[i];
		}
		
		
		
   }
   public static void main(String[] args){
      int[] a = {3,2,7,5,1,6,4,8,9};
      System.out.println("mergeSort a: ");
      long time, nextTime;
      time = System.nanoTime();
      mergeSort(a, 0, a.length - 1);
      nextTime = System.nanoTime();
      System.out.println("\tTime used: " + (nextTime - time) + " nseconds");
      for (int i = 0; i < a.length; i++) System.out.print(a[i] + ",");
      System.out.println();
   }

}