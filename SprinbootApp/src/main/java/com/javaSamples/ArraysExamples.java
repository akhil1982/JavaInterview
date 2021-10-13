package com.javaSamples;

public class ArraysExamples {

    public static void main(String[] args) throws Exception{
        int[] intArr = {3,5,-12,6,1,0,8,9,17,16,-21,23,15,-10,5,5,5};
        int[] intArrr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr[] = {5,10,15};
        //findMax(intArr);
        //findMin(intArr);
        sortArray(intArr);
        //findInSegment();
        //reverse(intArr);
        //kthLargestElement(intArr);
        //numberOfOccurences(intArr);
        //rangeAndCoeff(arr);
        //rearrange(intArr);

    }


    public static void rearrange(int[] intArr) {
        int temp,j=0;
        for (int i=0;i< intArr.length;i++){
            if(intArr[i] < 0 ){
                if(i!=j){//index is not the zero index
                    temp=intArr[i];
                    intArr[i]=intArr[j];
                    intArr[j]=temp;
                }
                j++;
            }
        }
        printArray(intArr);
    }
    public static void rangeAndCoeff(int[] intArr) {
        int min = findMin(intArr);
        int max = findMax (intArr);
        System.out.println("Range is "+(max-min));
        float coeff = ((max-min)/(max+min));
        System.out.println("Coeff is "+coeff);
    }

    public static int findMin(int[] intArr) {
        int min = intArr[0];
        for(int i =0;i< intArr.length;i++) {
            if (intArr[i]<min){
                min=intArr[i];
            }
        }
        System.out.println("Min is :: "+min);
        return min;
    }

    public static void numberOfOccurences(int[] intArr) {
        int count=0;
        int number = 5;
        for(int i=0; i< intArr.length;i++){
            if(intArr[i]==number){
                    count++;
            }
        }
        System.out.println("Number of occurences "+count);
    }

    public static void kthLargestElement(int[] intArr) throws Exception{
        int k = 3;
        int temp =0;

        if(k> intArr.length){
            throw new Exception("K greater then lenght of array");
        }
        for (int i=0;i< intArr.length;i++) {
            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[i] > intArr[j]) {
                    temp = intArr[i];
                    intArr[i] = intArr[j];
                    intArr[j] = temp;
                }
            }
        }
        System.out.println(k+"th largest element :: "+intArr[k-1]);
    }

    public static void reverse(int[] intArr){
        int[] newArr = new int[intArr.length];
        for(int i=0, j= intArr.length-1; i< intArr.length;i++, j--){
            newArr[j]=intArr[i];
        }
        for(int k=0; k< newArr.length;k++){
            System.out.print(newArr[k]+",");
        }
    }
    public static void findInSegment(){
        int[] intArr= {3,5,3,1,2,3,8,4,5};
        int segSize = 3;
        int key = 3;
        boolean flag=false;
        int segment=0;
        for(int i=0;i< intArr.length;i=i+segSize){
            segment++;
            for (int j=i;j<=i+(segSize-1);j++){
                //System.out.println("index"+j);
                if (intArr[j] == key) {

                    flag = true;
                    System.out.println("index::"+j+"flag::"+flag+"segment::"+segment);
                    break;
                } else {
                    flag=false;
                }
            }
        }
        System.out.print(flag);
    }

    public static int findMax(int[] intArr) {
        int max = intArr[0];
        for (int i=1; i <= intArr.length-1; i++){
            if (max <= intArr[i]) {
                max = intArr[i];
            }
        }
        System.out.println("Max is : "+max);
        return max;
    }

    public static void sortArray(int[] intArr) {
        for (int i=0; i< intArr.length; i++) {
            for (int k=i+1;k<intArr.length;k++) {
                int temp=0;
                if (intArr[i] > intArr[k]) {
                    temp = intArr[i];
                    intArr[i]=intArr[k];
                    intArr[k]=temp;
                }
            }
        }
        for (int j=0;j<intArr.length; j++){
            System.out.print(intArr[j]+",");
        }
    }

    public static void printArray(int arr[])
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
