package com.LIS;

public class LIS {
	
	static int maximum;									// stores the LongestIncreaseSubSequence
	   
    public static int lis(int arr[], int n)					// n= ArrayLength [arr.length]
    {
    	if (n == 1 )									// basic case
            return 1;
       
        int res, max_ending = 1;				 		// 'max_ending' is length of LIS ending with arr[n-1]				
       
        for (int i = 1; i < n; i++) 
        {
            res = lis(arr, i);
            if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending)
                max_ending = res + 1;
        }
          // Compare max_ending with the overall max
      
        if (maximum < max_ending) 
        {
        	maximum = max_ending;
        }
          return max_ending;							// Return length of LIS ending with arr[n-1]
	
    }
    
    static int lis2(int arr[], int n)					// The wrapper function for lis()
    {
    	maximum = 1;						 			// The maximum variable holds the result
          
        lis(arr, n);									// The function lis() stores its result in maximum
          
        return maximum;
        
    }
    
    public static void main(String args[])
    {
        int arr[] = { 0, 10, 6, 14, 2, 1, 9, 5, 8, 4, 12, 7, 15, 13, 3, 11 };
        int n = arr.length;
        System.out.println("Length of lis is "+ lis(arr, n));
    }
	

}
