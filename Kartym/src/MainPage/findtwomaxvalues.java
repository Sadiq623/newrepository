package MainPage;

public class findtwomaxvalues {
	
	public void gettwomaxvalues(int[] nums)
	{
		int maxOne = 0;
		
		int maxTwo = 0;
		
		for(int n : nums)
		{
			if(maxOne<n)
			{
				maxTwo = maxOne;
				maxOne = n;
			}
			
			else if(maxTwo<n)
			{
				maxTwo=n;
			}
			
				
			}
		
		System.out.println("Max value:"+maxOne);
		
		System.out.println("Max value:"+maxTwo);
		}
	
	
	public static void main(String[] args) 
	{
	int[] list= {25,45,35,75,68,21,34,53};	
	
	findtwomaxvalues max = new findtwomaxvalues();
	
	max.gettwomaxvalues(list);
	
	}
	}


