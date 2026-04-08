/*
Program 5 Generic Methods
Use Generics
CS160-03
4/7/2026
@author Asher Plotsky
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class GenMethods {
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        ArrayList<E> newList = new ArrayList();
        for(int i = 0; i < list.size(); i++){
            if(!newList.contains(list.get(i))){
                newList.add(list.get(i));
            }
        }
        return newList;
    }
    public static <E> String randomize(Vector<E> list, long seed){
        Random rand = new Random(seed);
        Vector<E> newList = new Vector<>();
        for(int i = 0; i < list.size(); i++){
            newList.add(list.get(i));
        }
        int pos1;
        int pos2;
        E swap1;
        E swap2;
        for (int i = 0; i < 30; i++){
            pos1 = rand.nextInt(list.size());
            pos2 = rand.nextInt(list.size());
            swap1 = newList.get(pos1);
            swap2 = newList.get(pos2);
            newList.set(pos1, swap2);
            newList.set(pos2, swap1);
        }
        return newList.toString();
    }
    public static <E extends Comparable<E>> E secondMin(ArrayList<E> list){
        E min = list.get(0);
        E second = list.get(0);
        for(int i = 1; i < list.size(); i++){
            if(list.get(i).compareTo(min) < 0){
                min = list.get(i);
            }
        }
        for (int i = 1; i < list.size(); i++){
            if(list.get(i).compareTo(second) < 0 && list.get(i).compareTo(min) > 0){
                second = list.get(i);
            }
        }
        return second;
    }
    public static <E extends Comparable<E>> int binarySearch(E[] list, E key){
        int low = 0;
        int high = list.length - 1;
        while(low <= high){
            int mid =  low + (high - low)/2;
            if(list[mid].compareTo(key) == 0){
                return mid;
            }
            else if(list[mid].compareTo(key) > 0){
                high = mid - 1;
            }
            else if(list[mid].compareTo(key) < 0){
                low = mid + 1;
            }
        }
        return -1;
    }
    public static <E extends Comparable<E>> E secondMin(E[] list){
        E min = list[0];
        E second = list[0];
        for(int i = 0; i < list.length; i++){
            if(list[i].compareTo(min) < 0){
                min = list[i];
            }
        }
        for (int i = 0; i < list.length; i++){
            if(list[i].compareTo(second) < 0 && list[i].compareTo(min) > 0){
                second = list[i];
            }
        }
        return second;
    }
    public static <E extends Comparable<E>> E min(E[][] list){
        E min = list[0][0];
        for(int i = 1; i < list.length; i++){
            for(int j = 0; j < list[i].length; j++){
                if(list[i][j].compareTo(min) < 0){
                    min = list[i][j];
                }
            }
        }
        return min;
    }
}
