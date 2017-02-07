/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
import java.util.*;
public class Solution {
	// public int findKthLargest(int[] nums, int k) {
	// 	Heap<Integer> heap=new Heap<>(k);
	// 	int len=nums.length;
	// 	int i=0;
	// 	for(;i<k;i++)
	// 		heap.add(nums[i]);
	// 	for(;i<len;i++){
	// 		if(nums[i]>heap.peek()){
	// 			heap.remove();
	// 			heap.add(nums[i]);
	// 		}
	// 	}
	// 	return heap.peek();
	// }

	public int findKthLargest(int[] nums, int k){
		if(k>nums.length)
			return -1;
		return quickSelect(nums,0,nums.length-1,nums.length-k);
	}

	private void swap(int[] nums, int a, int b){
		if(a!=b){
			nums[a]=nums[a]^nums[b];
			nums[b]=nums[a]^nums[b];
			nums[a]=nums[a]^nums[b];
		}
	}

	//返回数组nums在从小到大的情况下下标为k的元素值
	public int quickSelect(int[] nums, int left, int right, int k){
		int pivotIndex=(left+right)>>>1;
		int pivot=nums[pivotIndex];
		swap(nums,pivotIndex,right);
		pivotIndex=left;
		for(int i=left;i<right;i++){
			if(nums[i]<pivot){
				swap(nums,pivotIndex,i);
				pivotIndex++;
			}
		}
		swap(nums,pivotIndex,right);
		if(pivotIndex==k)
			return nums[pivotIndex];
		else if(pivotIndex>k)
			return quickSelect(nums,left,pivotIndex-1,k);
		else
			return quickSelect(nums,pivotIndex+1,right,k);

	}

}

class Heap<E>{
	E[] a;
	int size;
	Comparator<? super E> comparator;

	public Heap(int capacity){
		a=(E[])new Object[capacity];
		for(int i=0,len=a.length;i<len;i++)
			a[i]=null;
	}

	public Heap(Collection<? extends E> c){
		a=(E[])(c.toArray());
		size=a.length;
		heapify();
	}

	public void grow(){}

	public void add(E e){
		if(size>=a.length){
			grow();
		}
		if(size==0)
			a[size]=e;
		else
			siftUp(size,e);
		size++;
	}

	public E remove(){
		if(size==0)
			return null;
		size--;
		E result=a[0];
		E x=a[size];
		a[size]=null;
		if(size>0)
			siftDown(0,x);
		return result;
	} 

	public E peek(){
		if(size>0)
			return a[0];
		else
			return null;
	}

	private void siftUp(int k, E e){
		if(comparator!=null)
			siftUpUsingComparator(k,e);
		else
			siftUpComparable(k,e);
	}

	private void siftUpUsingComparator(int k, E e){
		int parentIndex;
		E parent;
		while(k>0){
			parentIndex=(k-1) >>> 1;
			parent=a[parentIndex];
			if(comparator.compare(e,parent)>=0)
				break;
			a[k]=parent;
			k=parentIndex;
		}
		a[k]=e;
	}

	private void siftUpComparable(int k, E e){
		Comparable<? super E> key=(Comparable<? super E>) e;
		int parentIndex;
		E parent;
		while(k>0){
			parentIndex=(k-1) >>> 1;
			parent=a[parentIndex];
			if(key.compareTo(parent)>=0)
				break;
			a[k]=parent;
			k=parentIndex;
		}
		a[k]=e;
	}

	private void siftDown(int k, E e){
		if(comparator!=null)
			siftDownUsingComparator(k,e);
		else
			siftDownComparable(k,e);
	}

	private void siftDownUsingComparator(int k, E e){
		int limit=size >>> 1;
		int minIndex;
		int right;
		while(k<limit){
			minIndex=(k<<1)+1;
			right=minIndex+1;
			if(right<size && comparator.compare(a[minIndex],a[right])>0){
				minIndex=right;
			}
			if(comparator.compare(e,a[minIndex])<=0)
				break;
			a[k]=a[minIndex];
			k=minIndex;
		}
		a[k]=e;
	}

	private void siftDownComparable(int k, E e){
		int limit=size >>> 1;
		int minIndex;
		int right;
		Comparable<? super E> key=(Comparable<? super E>) e;

		while(k<limit){
			minIndex=(k<<1)+1;
			right=minIndex+1;
			if(right<size && ((Comparable<? super E>) a[minIndex]).compareTo(a[right])>0){
				minIndex=right;
			}
			if(key.compareTo(a[minIndex])<=0)
				break;
			a[k]=a[minIndex];
			k=minIndex;
		}
		a[k]=e;
	}

	private void heapify(){
		for(int i=(size>>>1)-1;i>=0;i--)
			siftDown(i,a[i]);
	}
}