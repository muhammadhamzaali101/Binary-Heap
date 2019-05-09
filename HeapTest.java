import java.util.Scanner;

public class HeapTest
{

	public static void main(String [] args)
	{
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the array size.\n");
		int sizee = in.nextInt();
		Heap heap = new Heap(sizee);
		
		
				
				
				for(int i = 0 ; i< sizee; i++)
				{
					System.out.print("Enter the value you want to insert.\n");
					
					heap.insert(in.nextInt());
				}		
				
			
					
			heap.displayHeap();
					
		
		
		for(int i = sizee-1 ; i>= 0 ;i-- )
					{
						
						heap.insertat(i,heap.remove());
					}
					
		
		System.out.print("Sorted:");
					heap.displayarray();
	
	}

}