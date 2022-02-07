package MaxHeap;

public class TestMaxHeap {

    public static void main(String[] args) {
        //test constructors
        //constructor 1
        MaxHeap heap0 = new MaxHeap(7);
        System.out.println("Heap: "+ heap0.toString());
        System.out.println("size of array (including empty index, 0): "+heap0.getAsize());
        System.out.println("heap size: "+heap0.getHsize());
        System.out.println();
        
        //constructor 2
        Integer[] a0 = {60,30,40,12,70,2,50,45,5,10,55};
        MaxHeap heap1 = new MaxHeap(a0);
        System.out.println("Heap: "+heap1.toString());
        System.out.println("size of array (including empty index, 0): "+heap1.getAsize());
        System.out.println("heap size: "+heap1.getHsize());
        System.out.println();
        
        //test insert
        heap1.insert(5);//should make a new array of double the size, 5 is also a duplicate which should be allowed
        heap1.insert(100);//should percolate to the beginning of the array
        System.out.println("Heap: "+heap1.toString());
        System.out.println("size of array (including empty index, 0): "+heap1.getAsize());
        System.out.println("heap size: "+heap1.getHsize());
        System.out.println();
        
        //test getArray
        System.out.println(heap1.getArray());
        System.out.println();
//        System.out.println(heap1.deleteMax());
//        System.out.println("Heap: "+heap1.toString());
        
        //test heapsort() and deleteMax()
        System.out.println("The unsorted array is: ");  
        for(int i = 0; i<a0.length; i++)
        {
            System.out.print(a0[i]+" ");
        }
        System.out.println();
        System.out.println("The sorted array is: ");        
        MaxHeap.heapsort(a0);
        for(int i = 0; i<a0.length; i++)
        {
            System.out.print(a0[i]+" ");
        }
        
        
    }
    
}//end test class
