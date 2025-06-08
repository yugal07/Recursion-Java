

public class CheckIfArrayIsSorted {
    public static Boolean isSorted(int arr[] , int n) {
        // n is the size of the array
        if(n == 0 || n == 1) return true;

        return arr[n - 1] >= arr[n - 2] && isSorted(arr, n - 1);
    }
    public static void main(String[] args) {
        System.out.println(isSorted(new int[] {1,2,6,4}, 4));
    }
}
