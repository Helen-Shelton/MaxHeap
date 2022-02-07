package MaxHeap;

public class MaxHeap {
    private Integer[] array;
    private int Asize;
    private int Hsize;
    
    public MaxHeap(int n)
    {
        Asize = n+1;//size of memory allocated, add a space for the empty 0 index
        Hsize = 0;//number of items stored
        array = new Integer[Asize];
    } 
    
    public MaxHeap(Integer[] someArray)
    {
        Asize = someArray.length +1; //add a space for empty index [0]
        Hsize = someArray.length; //number of items stored is number of elements in someArray
        array = new Integer[Asize];
        array[0] = 0; //first index is not used in calculations
        for(int i = 1; i<Asize; i++)
            array[i] = someArray[i-1];
        this.Order();
    }
    
    private void Order()//used to organize this array into a heap
    {
        int temp;//switches node with parent node
        for(int i=1; i<array.length; i++)//for every index in the array
        {
            while((i != 1) && (array[i] > array[i/2]))//while we are not at the first index and the node we are at is greater than the parent node
            {
                temp = array[i/2];//switch the nodes
                array[i/2] = array[i];
                array[i] = temp;
                i /= 2; //decrement j to check if the same condition applies at the new index
            }//end while  
        }//end for
    }
    
    private void PercolateUp(int n)//used to order n into a max heap
    {
        array[Hsize+1] = n;//add element to next open space in heap, add 1 for the empty 0 index
        int i = Hsize+1;//start index at the end
        int temp;
        while((i != 1) && (array[i] > array[i/2]))//while we are not at the first index and the node we are at is greater than the parent node
            {
                temp = array[i/2];//switch the nodes
                array[i/2] = array[i];
                array[i] = temp;
                i /= 2; //decrement i to check if the same condition applies at the new index
            }//end while
    }
    
    public void insert(int n)
    {
        if(Hsize == Asize-1)//if there is no room in the array (# of elements = size)
        {
            MaxHeap tempH = new MaxHeap(2*Asize);//set a temp heap of size = (2 * original heapsize)
            for(int i = 0; i<Asize; i++)//go through every element in original heap (including empty first index)
                tempH.array[i] = array[i];//assign it to temp
            array = tempH.array; //reassign appropriate tempH fields to corresponding original heap variables
            Asize = tempH.Asize;
        }
        this.PercolateUp(n);
        Hsize++;//increase size of heap after inserting
    }
    
    private int deleteMax()
    {
        if(Hsize == 1)//if there is only 1 element in the array 
            return array[1];
        int max = array[1];//return first element (max number)
        array[1] = array[Hsize];//move last element to first index to percolate downward
        array[Hsize] = null;
        Hsize--;//decrease size of heap (removes last node)
        int i = 1, maxChild, temp;
        
        while ((i*2) <= Hsize) //while the current node is not the end of the heapsize (if there is no left child, there will be no right child))
        {
            maxChild = 0;//assumes left child is bigger than right child
            if ( (array[(i*2)+1] != null) && (array[i*2] < array[(i*2)+1]) )//while the right child exists and the right child is greater than the left
                maxChild = 1;//set right greater than left
            if( (maxChild == 0) && (array[i] < array[i*2]) ) //if the left child is bigger than the right, and parent node is less than the left child
            {
                temp = array[i*2];//switch the nodes
                array[i*2] = array[i];
                array[i] = temp;
                i *= 2;//move to left child index
            }
            else if( (maxChild == 1) && (array[i]<array[(i*2)+1]))//else if the right child is bigger than the left, and parent node is less than the right child
            {
                temp = array[(i*2)+1];//switch the nodes
                array[(i*2)+1] = array[i];
                array[i] = temp;
                i = (i*2) + 1; //move to right child index
            }
            else
                break; //if parent cannot be switched with either child, while loop should exit
        }
        return max;
    }
    
    public String toString()
    {
        String out = "";
        for(int i = 1; i<=Hsize; i++)
        {
            out = out+" "+array[i];
        }
        return out;
    }
    
    public static void heapsort(Integer[] arrayToSort)
    {
        MaxHeap sort = new MaxHeap(arrayToSort);//assign newheap
        for(int i = 0; i < arrayToSort.length; i++) //for every value in the array
        {
            arrayToSort[i] = sort.deleteMax(); //delete the max value and store in the corresponding index in arrayToSort
        }
    }
    
    public Integer[] getArray()
    {
        return array;
    }
    
    public int getAsize()
    {
        return Asize;
    }
    
    public int getHsize()
    {
        return Hsize;
    }
}//end MaxHeap()

