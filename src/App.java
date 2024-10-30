import java.util.Scanner;
import java.util.Arrays;

public class App {

    public static <T extends Comparable<T>> void bubbleSort(T[] array){

        int l = array.length;
        boolean moved;

        for(int i = 0; i < l-1; i++){
            moved = false;
            for(int j = 0; j < l-1; j++){
                if(array[j].compareTo(array[j+1])>0){
                    T holder = array[j];
                    array[j] = array[j+1];
                    array[j+1] = holder;
                    moved = true;
                }
            }
            if(!moved){
                break;
            }
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] array){

        if(array.length < 2){
            return;
        }

        int middle = (array.length)/2;
        T[] start = Arrays.copyOfRange(array, 0, middle);
        T[] end = Arrays.copyOfRange(array, middle, array.length);
        
        mergeSort(start);
        mergeSort(end);
        merge(array, start, end);
    }

    public static <T extends Comparable<T>> void merge(T[] array, T[] start, T[] end){
        int i = 0, j = 0, k = 0;

        while(i < start.length && j < end.length){
            if(start[i].compareTo(end[j])<=0){
                array[k++] = start[i++];
            }
            else{
                array[k++] = end[j++];
            }
        }

        while(i < start.length){
            array[k++] = start[i++];
        }

        while(j < end.length){
            array[k++] = end[j++];
        }
    }
    
    public static void main(String[] args) throws Exception {
       
        boolean using = true;

        Scanner main = new Scanner(System.in);

        while(using){
        String input;

        System.out.println("Please select a command from the list below\nand type the word in parenthesis ;\n\nUse bubble sort to organize an array: (bubble)\nUse merge sort to organize array: (merge)\nStop: (stop)");

        int arrayLength;
        String arrayType;

        input = main.nextLine();

        switch(input){

            case "bubble":
            System.out.print("Enter 'string' or 'int': ");
            arrayType = main.nextLine();

            if(arrayType.equals("string")){
                System.out.print("Enter array length: ");
                arrayLength = Integer.parseInt(main.nextLine());

                System.out.println("Array length = " + arrayLength);

                String[] string = new String[arrayLength];
                for(int i = 0; i < arrayLength; i++){
                    System.out.println("Enter string " + (i+1) + ": ");
                    string[i] = main.nextLine();
                }

                bubbleSort(string);
                System.out.println("\nSorted Array;");
                for (String str : string){
                    System.out.println(str);
                }
            }
            else if(arrayType.equals("int")){
                System.out.print("Enter array length: ");
                arrayLength = Integer.parseInt(main.nextLine());

                System.out.println("Array length = " + arrayLength);

                Integer[] arr = new Integer[arrayLength];
                for(int i = 0; i < arrayLength; i++){
                    System.out.println("Enter integer " + (i+1) + ": ");
                    arr[i] = Integer.parseInt(main.nextLine());
                }

                bubbleSort(arr);
                System.out.println("\nSorted Array;");
                for (int i : arr){
                    System.out.println(i);
                }
            }
            else{
                System.out.println("Invalid input.");
            }

            break;

            case "merge":
            System.out.print("Enter 'string' or 'int': ");
            arrayType = main.nextLine();

            if(arrayType.equals("string")){
                System.out.print("Enter array length: ");
                arrayLength = Integer.parseInt(main.nextLine());

                System.out.println("Array length = " + arrayLength);

                String[] string = new String[arrayLength];
                for(int i = 0; i < arrayLength; i++){
                    System.out.println("Enter string " + (i+1) + ": ");
                    string[i] = main.nextLine();
                }

                mergeSort(string);
                System.out.println("\nSorted Array;");
                for (String str : string){
                    System.out.println(str);
                }
            }
            else if(arrayType.equals("int")){
                System.out.print("Enter array length: ");
                arrayLength = Integer.parseInt(main.nextLine());

                System.out.println("Array length = " + arrayLength);

                Integer[] arr = new Integer[arrayLength];
                for(int i = 0; i < arrayLength; i++){
                    System.out.println("Enter integer " + (i+1) + ": ");
                    arr[i] = Integer.parseInt(main.nextLine());
                }

                mergeSort(arr);
                System.out.println("\nSorted Array;");
                for (int i : arr){
                    System.out.println(i);
                }
            }
            else{
                System.out.println("Invalid input.");
            }

            break;

            case "stop":
            using = false;

            break;

            default:
            System.out.println("An error has occured.");

            break;

        }
        }
        main.close();
    }
}
