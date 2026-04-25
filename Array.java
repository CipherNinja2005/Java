import java.util.Arrays;
public class Array{
    public static void main(String[] args){
        int[] Arr;
        Arr = new int[5]; //first way to declare  an array
        Arr[0] = 20;
        Arr[1] = 11;
        Arr[2] = 45;
        Arr[3] = 29;
        Arr[4] = 36;

        int[] newArr = new int[]{100,200,300,400,500}; //another way to declare and initialise an array

        for(int i = 0; i < 5 ; i++){ //works for array 1
            System.out.println("Element " + (i+1) + " is " + Arr[i]);
        }

        for(int i1 = 0 ; i1 < 5; i1++){ //works for array 2
            if(newArr[i1]%2==0){
                System.out.println(newArr[i1] + " is an even number");
            }
            else{
                System.out.println(newArr[i1] + " is an odd number");
            }
        }

        for (int e : newArr){ //another way of executing for loop (works for array 2)
            System.out.println(e/10);
        }

        int[] Arr1 = new int[5];
        System.arraycopy(Arr, 0, Arr1, 0, 5); //Copies an existing array, part of System package

        for(int i =0; i<5; i++){
            System.out.println("Element " + (i+1) + " is " + Arr1[i]);
        }

        //int[] Arr2 = new int[7]; //Taking larger size than og array, this isn't possible
     //   System.arraycopy(Arr, 0, Arr2, 0, 7);

       // for(int i =0; i<5; i++){
       //     System.out.println("Element " + (i+1) + " is " + Arr2[i]); 
       // }

        //Start reading documentations of things that you learn or use in your code. It's pretty useful

        Arrays.sort(Arr); //used to sort an array
        System.err.println("========Sorted Array=========");
        for(int i =0; i<5; i++){
            System.out.println("Element " + (i+1) + " is " + Arr[i]);
        }



    }
}