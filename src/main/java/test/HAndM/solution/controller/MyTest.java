package test.HAndM.solution.controller;

public class MyTest {

	// Java program for implementation of Selection Sort

	// Driver code to test above
	public static void main(String args[]) {
		System.out.println("in main method");
		final SelectionSort ob = new SelectionSort();
		final int arr[] = { 64, 25, 12, 22, 11, 1 };
		System.out.println("Original array");
		ob.printArray(arr);
		ob.sort(arr);
		System.out.println("Sorted array with pace movement :" + ob.getPlaceMoves());
		ob.printArray(arr);
	}

}

class SelectionSort {

	int placeMoves;

	public int getPlaceMoves() {
		return placeMoves;
	}

	public void setPlaceMoves(int placeMoves) {
		this.placeMoves = placeMoves;
	}

	void sort(int arr[]) {
		setPlaceMoves(0);
		final int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < (n - 1); i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min_idx]) {
					min_idx = j;
				}
			}

			// Swap the found minimum element with the first
			// element
			final int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
			placeMoves++;
		}
	}

	// Prints the array
	void printArray(int arr[]) {
		final int n = arr.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
