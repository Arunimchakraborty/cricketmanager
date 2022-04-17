import java.util.Arrays;
import java.util.Random;

public class miscFuncs {
    int findMax(int a, int b){
        if(a>b){
            return a;
        }
        else{
            return b;
        }
    }

    static int count = 0;

    int findMaxInArray(int[] arr){
        int i;
        int max = arr[0];

        for (i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];

        return max;
    }

    float findMaxInArray(float[] arr){
        int i;
        float min = arr[0];

        for (i = 0; i < arr.length; i++) {
            if(arr[i]>min){
                min = arr[i];
            }
        }
        return min;
    }


    int findLeastInArray(int[] arr){
        int i;
        int max = arr[0];

        for (i = 1; i < arr.length; i++)
            if (arr[i] < max)
                max = arr[i];

        return max;
    }

    float findLeastInArray(float[] arr){
        int i;
        float min = arr[0];

        for (i = 0; i < arr.length; i++) {
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }

    int findMaxOfAll(int... arr){
        return findMaxInArray(arr);
    }

    int[] findElementInArray(int[] arr, int a){
        int[] indices = new int[arr.length];
        int j = 0;

        for (int i = 0; i < 22; i++) {
            indices[i] = -1;
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] == a){
                indices[j] = i;
                j++;
            }
        }



        return indices;
    }

    float[] findMaxElementInArray(float[] array){
        int pos = 0;
        float max = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
                max = array[i];
                pos = i;
            }
        }
        return new float[]{pos,max};
    }

    static int findSecondHighest(float[] arr){
        float max = arr[0];
        int pos1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
                pos1=i;
            }
        }

        int pos2 = 0;
        float[] arr2 = new float[arr.length-1];
        for (int i = 0; i < arr2.length; i++) {
            if(arr[i]==max){
                continue;
            }
            arr2[i]=arr[i];
        }

        float max2 = arr2[0];
        for (int i = 0; i < arr2.length; i++) {
            if(arr2[i]>max2){
                max2=arr2[i];
                pos2=i;
            }
        }

//        if(pos1>pos2){
//            return pos2;
//        }
//        else{
//            return (pos2+1);
//        }

        return pos2;

    }

    int findElementIndiceInArray(float[] arr, float a){
        int indice = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==a){
                indice = i;
            }
        }
        return indice;
    }

    int[] translateOneArrayToAnother(int[] arr1, int[] arr2){
        int[] output = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            output[i] = arr2[arr1[i]];
        }

        return output;
    }

    int[] orderArray(int[] array){
        int[] arr = array;

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                int tmp = 0;
                if (arr[i] > arr[j])
                {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }


        return arr;
    }

    static int findNthHighest(float[] arr, int n){

        if(n>=arr.length){
            System.out.println("Error");
        }

        float max = arr[0];
        int pos1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
                pos1=i;
            }
        }

        float[] arr2 = new float[arr.length-1];
        for (int i = 0; i < arr2.length; i++) {
            if(arr[i]==max){
                continue;
            }
            arr2[i]=arr[i];
        }

        if(count < n){
            count++;
            findNthHighest(arr2,n);
        }
        else{
            return pos1;
        }

        return pos1;

    }

    public static void main(String[] args) {
        float[] array = {1000,2,4,5,300,123,45,61000};
        int pos = findSecondHighest(array);
        System.out.println("Second Highest Element is : "+array[pos]+" At pos : "+pos);

        float f = 5;
        f = 10/f;
        System.out.println(f);
        int n =2;
        int pos2 = findNthHighest(array,n);
        System.out.println((n+1)+"th highest Element is : "+array[pos2]+" At pos : "+pos2);

        int a;
        a = new Random().nextInt(5);
        System.out.println(a);
        a = new Random().nextInt(5);
        System.out.println(a);
        a = new Random().nextInt(5);
        System.out.println(a);
        a = new Random().nextInt(5);
        System.out.println(a);
        a = new Random().nextInt(5);
        System.out.println(a);
        a = new Random().nextInt(5);
        System.out.println(a);


    }



}
