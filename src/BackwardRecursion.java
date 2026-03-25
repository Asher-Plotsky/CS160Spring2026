public class BackwardRecursion {
    public static void main(String[] args){
        int[] array = {2, 4, 6, 8, 10, 12, 14};
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
        backward(array, array.length-1);
        for (int i = 0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
    public static void backward(int[] a, int n){
        if (n > (a.length-1) / 2){
            int temp = a[n];
            a[n] = a[a.length-1-n];
            a[a.length-1-n] = temp;
            backward(a, n-1);
        }
    }
}
