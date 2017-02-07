/*
75. Sort Colors
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

public class Solution {
	public void sortColors(int[] nums) {
		// quickSort(nums);
		// mergeSort(nums);
		// selectSort(nums);
		// insertSort(nums);
		bubbleSort(nums);
	}



	//使用异或操作进行交换
	public void swap(int[] a, int i, int j){
		if(i!=j){
			a[i]=a[i]^a[j];
			a[j]=a[i]^a[j];
			a[i]=a[i]^a[j];
		}
	}

	public void quickSort(int[] a){
		// quickSort(a,0,a.length-1);
		quickSort2(a,0,a.length-1);
	}

	public void quickSort(int[] a, int left, int right){
		if(left>=right)
			return;
		int middle=(left+right)/2;
		int pivot=a[middle];
		int l=left,r=right;
		while(l<r){
			for(;a[l]<pivot;l++);
				for(;a[r]>pivot;r--);
					if(l<=r){
						swap(a,l,r);
						l++;
						r--;
					}
				}
				quickSort(a,left,r);
				quickSort(a,l,right);

	}


		public void quickSort2(int[] a, int left, int right){
				if(left>=right)
					return;
				int pivotIndex=(left+right)/2;
				int pivot=a[pivotIndex];
				//把pivot位置的值与right位置的值进行交换
				swap(a,pivotIndex,right);

				//直接从左到右遍历实现[left,pivotIndex-1]的值都<pivot,[pivotIndex,right]的值都>=pivot
				pivotIndex=left;
				for(int i=left;i<right;i++){
					if(a[i]<pivot){
						swap(a,i,pivotIndex);
						pivotIndex++;
					}
				}
				//最后记得把pivotIndex位置和right位置的值进行交换，确保pivotIndex位置的值等于pivot
				swap(a,pivotIndex,right);

				quickSort2(a,left,pivotIndex-1);
				quickSort2(a,pivotIndex+1,right);
			}


			public void mergeSort(int[] a){
				int[] temp=new int[a.length];
				mergeSort(a,0,a.length-1,temp);
			}

			public void mergeSort(int[] a, int left, int right, int[] temp){
				if(left>=right)
					return;
				int middle=(left+right)/2;
				mergeSort(a,left,middle,temp);
				mergeSort(a,middle+1,right,temp);
				int i=left,j=middle+1,k=left;
				while(i<=middle&&j<=right)
					temp[k++]=a[i]<=a[j]?a[i++]:a[j++];
				while(i<=middle)
					temp[k++]=a[i++];					
				while(j<=right)
					temp[k++]=a[j++];
				for(k--;k>=left;k--)
					a[k]=temp[k];
			}

	public void selectSort(int[] a){
		if(a==null)
			return;
		int len=a.length;
		int minIndex;
		for(int k=0;k<len-1;k++){
			minIndex=k;
			for(int i=k+1;i<len;i++){
				if(a[minIndex]>a[i])
					minIndex=i;
			}
			swap(a,minIndex,k);
		}
	}

	public void insertSort(int[] a){
		if(a==null)
			return;
		int len=a.length;
		for(int k=1;k<len;k++){
			int i=k;
			while(i>0&&a[i]<a[i-1]){
				swap(a,i,i-1);
				i=i-1;
			}
		}
	}

	public void bubbleSort(int[] a){
		if(a==null)
			return;
		int len=a.length;
		for(int k=len-1;k>0;k--){
			for(int i=0;i<k;i++){
				if(a[i]>a[i+1])
					swap(a,i,i+1);
			}
		}
	}

}


