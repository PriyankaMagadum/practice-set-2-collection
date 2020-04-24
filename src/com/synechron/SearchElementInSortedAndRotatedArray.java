package com.synechron;

public class SearchElementInSortedAndRotatedArray {

	public int findPivot(int[] arr, int low, int high) {

		if (low > high) {
			return -1;
		}
		if (high == low) {
			return low;
		}

		int mid = (high + low) / 2;
		if (mid < high && arr[mid] > arr[mid + 1]) {
			return mid;
		}
		if (mid > low && arr[mid] < arr[mid - 1]) {
			return mid - 1;
		}
		if (arr[low] >= arr[mid]) {
			return findPivot(arr, low, mid - 1);
		}

		return findPivot(arr, mid + 1, high);

	}

	public int pivoteBinarySearch(int arr[], int key) {
		int pivote = findPivot(arr, 0, arr.length - 1);
		if (pivote == -1) {
			return binarySearch(arr, 0, arr.length - 1, key);
		}
		if (arr[pivote] == key) {
			return pivote;
		}
		if (arr[0] <= key) {
			return binarySearch(arr, 0, pivote - 1, key);
		}
		return binarySearch(arr, pivote + 1, arr.length - 1, key);
	}

	int binarySearch(int arr[], int low, int high, int key) {
		if (high < low)
			return -1;

		int mid = (low + high) / 2;
		if (key == arr[mid])
			return mid;
		if (key > arr[mid])
			return binarySearch(arr, (mid + 1), high, key);
		return binarySearch(arr, low, (mid - 1), key);
	}

	public static void main(String[] args) {
		SearchElementInSortedAndRotatedArray array = new SearchElementInSortedAndRotatedArray();
		int arr[] = { 3, 4, 5, 6, 7, 1, 2 };
		System.out.println("key found at index=" + array.pivoteBinarySearch(arr, 4));
	}

}
