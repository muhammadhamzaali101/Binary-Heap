public class Heap
{
	private int currentSize;
	private int maxSize;
	private int []heapArray;
	
	//cunstructor
	Heap( int mx)
	{
		currentSize = 0;
		maxSize = mx;
		heapArray = new int[maxSize];
	}//end of cunstructor
	
	public boolean insert(int data)
	{
		if(currentSize == maxSize)
			return false;
	

	heapArray[currentSize] = data;		
	percolateUp(currentSize++);
	return true;
		
	}
	
	private void percolateUp(int currentIndex)
	{
		
		int parent = (currentIndex - 1) / 2;
		int child = heapArray[currentIndex];
		
		while(currentIndex > 0 && heapArray[parent] < child)
		{
			heapArray[currentIndex] = heapArray[parent];
			currentIndex = parent;
			parent = (parent - 1) / 2;
			
			
		}
		heapArray[currentIndex] = child;
		
	}
	
		
	int remove()
	{
		heapArray[0] = heapArray[--currentSize];
		percolatedown(0);
		
		return heapArray[0];
	}
	
	void percolatedown(int index)
	{
		int child;
		int parent = heapArray[index];
		
		while(index < currentSize/2)
		{
			int lchild = 2*index+1;
			int rchild = lchild+1;
			
			if(rchild < currentSize && heapArray[lchild] < heapArray[rchild])
				child = rchild;
			
			else
				child = lchild;
			
			if(parent >= heapArray[child])
				break;
			
			heapArray[index] = heapArray[child];
			index = child;
		}
		heapArray[index] = parent ;
	}
	
	void insertat(int index , int data)
	{
		heapArray[index] = data;
	}
	public void displayHeap()
	{
		System.out.print("heapArray: "); // array format
		
		for(int m=0; m<currentSize; m++)
			if(heapArray[m] != -1)
			System.out.print( heapArray[m] + " ");
			else
			System.out.print( "-- ");
			System.out.println();
			// heap format
			int nBlanks = 32;
			
			int itemsPerRow = 1;
			
			int column = 0;
			
			int j = 0; // current item
			
			String dots = ("...............................");
			
			System.out.println(dots+dots); // dotted top line
			
			while(currentSize > 0) // for each heap item
			{
				if(column == 0) // first item in row?
				for(int k=0; k<nBlanks; k++) // preceding blanks
				System.out.print(' ');
				System.out.print(heapArray[j]);
				
				if(++j == currentSize) // done?
					break;
			if(++column==itemsPerRow) // end of row?
			{
				nBlanks /= 2; // half the blanks
				itemsPerRow *= 2; // twice the items
				column = 0; // start over on
				System.out.println(); // new row
			}
			else // next item on row
				for(int k=0; k<nBlanks*2-2; k++)
				System.out.print(' '); // interim blanks
			} // end for
		System.out.println("\n"+dots+dots); // dotted bottom line
	} // end displayHeap()

	void displayarray()
	{
		for(int i=0 ; i<maxSize; i++)
			System.out.print(heapArray[i]+" ");
		System.out.print("");
	}

}