public class RadixSortTest {
    /**
    * The main method to test the Radix Sort method
    * It initializes an array, prints it, sorts it, and then prints the sorted array.
    * 
    * @param args Command-line arguments.
    */
    public static void main(String[] args) {
        // Initialize an array of integers to be sorted
        int[] arr = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};

        System.out.println("Original array:");
        printArray(arr); // Print the original unsorted array

        RadixSort.radixSort(arr); // Sort the array using Radix Sort

        System.out.println("Sorted array:");
        printArray(arr); // Print the sorted array
    }

    // Utility method to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) { // Loop through each element in the array
            System.out.print(num + " "); // Print the element followed by a space
        }
        System.out.println(); // Move to the next line after printing all elements
    }
}
