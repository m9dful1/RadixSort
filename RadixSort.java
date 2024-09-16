public class RadixSort {
    /**
    * Sorts an array of integers using the Radix Sort algorithm
    * Radix Sort processes each digit of the numbers, starting from the least significant digit (LSD)
    * to the most significant digit (MSD).  It uses Counting Sort as a subroutine to sort the numbers
    * based on each digit.
    * 
    * @param arr The array of integers to be sorted.
    */
    public static void radixSort(int[] arr) {
        // Find the maximum number to know the number of digits
        int max = getMax(arr); // Get the maximum value in the array
        
        // Do counting sort for every digit.
        // exp is 1, 10, 100, representing the digit's place value
        for (int exp = 1; max / exp > 0; exp *= 10) { // Loop through each digit place
            countingSort(arr, exp); // Perform counting sort based on the current digit
        }
    }

    /**
    * Finds and returns the maximum value in an array.
    * This is necessary to determine the number of digits in the largest number.
    * 
    * @param arr The array of integers.
    * @return the maximum integer in the array
    */
    private static int getMax(int[] arr) {
        int max = arr[0]; // Initialize max with the first element
        for (int i=1; i<arr.length; i++) {// Iterate over the array starting from the second element
            if (arr[i] > max) {// If the current element is greater than max
                max = arr[i]; // Update max with the current element
            }      
        }   
        return max; // Return the maximum value found
    }

    /**
    * Performs Counting Sort on the array based on the digit represented by exp.
    * Counting Sort is a stable sort that sorts elements based on a single digit.
    * 
    * @param arr The array to be sorted.
    * @param exp the exponent representing the digit position (1 for units, 10 for tens, 100 for hundredths)
    */
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length; // Get the number of elements in the array
        int output[] = new int[n]; // Output array to store the sorted elements
        int count[] = new int[10]; // Count array to store count of occurences for digits 0-9
        
        // Store count of occurrences of each digiti in count[]
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10; // Extract the digit at the current exponenet (digit position)
            count[digit]++; // Increment the count for this digit
        }

        // Change count[i] so that it contains the actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1]; // Update count[i] by adding the count of the previous digit
        }

        // Build the output array by placing elements in their correct positions
        for (int i = n - 1; i >= 0; i--) { // Iterate from the end to maintain stability
            int digit = (arr[i] / exp) % 10; // Extract the digit at the current exponent 
            output[count[digit] - 1] = arr[i]; // Place the element at the correct position in output[]
            count[digit]--; // Decrement the count for this digit
        }

        // Copy the output array to arr[]
        System.arraycopy(output, 0, arr, 0, n);
    }
}
