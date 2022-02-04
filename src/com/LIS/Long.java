package com.LIS;

import java.util.ArrayList;
import java.util.List;

public class Long 
{
	public static int LIS(int[] arr)
	{
		if (arr == null || arr.length == 0) 				// base case i.e. Zero Elements in the arr[]
		{					
			return 0;
		}

		List<List<Integer>> LIS = new ArrayList<>();		// LIS is ArrayList with INT Type
		for (int i = 0; i < arr.length; i++) 
		{
			LIS.add(new ArrayList<>());
		}
		
		for (int i = 0; i < arr.length; i++)					// start from the second array element
		{
			for (int j = 0; j < i; j++)							
			{
				if (arr[j] < arr[i] && LIS.get(j).size() > LIS.get(i).size()) 	
					{
					LIS.set(i, new ArrayList<>(LIS.get(j)));
					}
			}

			LIS.get(i).add(arr[i]);						// include `arr[i]` in `LIS[i]`
		}
			
		int j = 0;										// `j` will store an index of LIS
		for (int i = 0; i < arr.length; i++)
		{
			if (LIS.get(j).size() < LIS.get(i).size()) 
			{
				j = i;
			}
		}
			
		System.out.print("Longest Subsequence is "+LIS.get(j)+"\n");					// print LIS
		System.out.println("Length of Longest Subsequence is  " +LIS.get(j).size());	// Length of LIS
		return j;
	}

	public static void main(String[] args)
	{
		int arr[] = { 0, 8, 4, 12, 7, 15, 10, 6, 14, 2, 1, 9, 5, 13, 3, 11 };
		
		LIS(arr);
	}	
}


