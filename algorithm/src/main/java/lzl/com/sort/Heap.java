package lzl.com.sort;

public class Heap {
    public static void main(String[] args) {
        boolean[] b = new boolean[10];
        System.out.println(b[1]);
    }


    public static int[] headSort(int[] array){
            return null;
    }



    private static int getLeft(int i){
        return (2 * i + 1);
    }

    private static int getRight(int i){
        return (2 * i + 2);
    }

    private static int getParent(int i){
        return (i - 1) / 2;
    }




}