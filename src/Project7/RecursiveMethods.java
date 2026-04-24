package Project7;
/*
Program 7 Recursive Methods
Create and test 3 separate recursive methods.
CS160-03
4/24/2026
@author Asher Plotsky
*/
public class RecursiveMethods {
    public static void main(String[] args) {
        RecursiveMethods p6 = new RecursiveMethods();
        System.out.println("Part 1: " + p6.byLeapsAndBounds(5));
        System.out.println(p6.byLeapsAndBounds(15));
        String str = "abcabcabcdabcde";
        System.out.println("Part 2: " + p6.subCount(str, "abc"));
        System.out.println(p6.subCount(str, "cd"));
        int[] test = {1, 4, 7, 29, 92, 187, 472, 982};
        System.out.println("Part 3: " + p6.binarySearch(test, 4, 0, test.length - 1));
        System.out.println(p6.binarySearch(test, 784, 0, test.length - 1));
    }
    public int byLeapsAndBounds(int n) {
        int count = 0;
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        count += byLeapsAndBounds(n - 1);
        count += byLeapsAndBounds(n - 2);
        return count;
    }
    public int subCount(String str, String subStr) {
        int count = 0;
        if (str.length() < subStr.length() || str.indexOf(subStr) == -1) {
            return 0;
        }
        String newStr = str.substring(str.indexOf(subStr) +  subStr.length());
        count++;
        count += subCount(newStr, subStr);
        return count;
    }
    public int binarySearch(int[] array, int target, int left, int right) {
        int mid = (left + right) / 2;
        if (array.length == 0){
            return -1;
        }
        if (array[mid] == target) {
            return mid;
        }
        if (left > right) {
            return -1;
        }
        else if (array[mid] > target) {
            return binarySearch(array, target, left, mid - 1);
        }
        else if (array[mid] < target) {
            return binarySearch(array, target, mid + 1, right);
        }
        return -1;
    }
}
