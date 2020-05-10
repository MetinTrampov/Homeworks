package NumberSystem;

import java.util.Random;
import java.util.Scanner;

public class Homework5 {

    static Scanner scanner = new Scanner(System.in);
    static int[] arrayOfNumbers ;

    public static void main(String[] args) {


        System.out.println("Въведете n на брой числа :");
        int n = Integer.parseInt(scanner.nextLine());
        arrayOfNumbers = new int[n];
        System.out.printf("Въведете %d числа :\n ", n);
      //  printUserChosenNumbers11(arrayOfNumbers);
        for (int i = 0; i < arrayOfNumbers.length ; i++) {

            arrayOfNumbers[i] = scanner.nextInt();

            //  if (( array[0] <0 && array[0]>100)){
            //    System.out.print("Опитай отново :");
            //     break;
        }


        printMenu();
        int chosenNum = 0 ;
        chooseOption(chosenNum);

    }

    public static void printMenu() {
        System.out.println("1. Сортиране на въведените числа във възходящ ред");
        System.out.println("2. Сортиране на въведените числа в низходящ ред");
        System.out.println("3. Търсене на позиция на конкретно число");
        System.out.println("4. Разбъркване на числата");
        System.out.println("5. Изчисляване на сбора на всички числа");
        System.out.println("6. Намиране на най-голямото число");
        System.out.println("7. Намиране на най-малкото число");
        System.out.println("8. Намиране средно-аритметично на числата");
        System.out.println("9. Проверка за симетричност на масива от числа");
        System.out.println("10. Обръщане на масива от числа");
        System.out.println("11. Визуализирай въведените числа");
        System.out.println("12. Изход");
       // System.out.println("Изберете опция : ");
    }

        public static void chooseOption (int yourOption){
              //  System.out.println("Изберете опция");
            yourOption = Integer.parseInt(scanner.nextLine());
            while (yourOption!=12) {
                switch (yourOption) {
                    case 1:
                        System.out.println();
                        printArray(bubbleSort1(arrayOfNumbers));
                        break;
                    case 2:
                        System.out.println();
                        printArray(bubbleSort2(arrayOfNumbers));
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        System.out.println();
                        sumAllNumbersInOurArray(arrayOfNumbers);
                        break;
                    case 6:
                        System.out.println();
                        findBiggerNumberInArray6(arrayOfNumbers);
                        break;
                    case 7:
                        System.out.println();
                        findSmallerNumberInArray7(arrayOfNumbers);
                        break;
                    case 8:
                        //      findAverageOfNumbers(arrayOfNumbers,n);
                        break;
                    case 9:
                        //      symmHelper(arrayOfNumbers,n,0);break;
                    case 10:
                        printArray(reversedArray10(arrayOfNumbers));
                        break;
                    case 11:
                        printArray(arrayOfNumbers);
                        break;
                    default:
                        continue;
                }
                yourOption = Integer.parseInt(scanner.nextLine());
            }

        }

    public static boolean symmHelper(int[] A, int n, int i) {

        if (i > n/2) {
            System.out.println("Масива е симентичен .");
            return true;
       }
        else if (A[i] != A[n-1-i]) {
            System.out.println("Масива  не е симентичен .");
            return false;
        }
        else
           return symmHelper(A, n, i+1);
    }
    /**
     *  Обръща нашия масив във обратен ред
     * @param array Нашия масив
     * @return Обърнатия масив
     */
     public static int[]   reversedArray10 (int [] array){
        int[] reversed= new int [array.length];
        for (int i = 0, j = reversed.length - 1 ; i < array.length ; i++,j--){
                  reversed[j] = array[i];
         }
          return reversed;
    }

    /**
     * Изчислява средно аритметично на подадените числа от потребителя
     * @param array  Подадения масив от потребителя за обработка
     * @param n Броя на числата въведени от потребителя
     */
    public static void findAverageOfNumbers (int [] array, int n ){

        int sum = 0;
        for( int i : array)
        {
            sum += i;
        }

        System.out.printf("Средно-аритметично на числата  e :%d%n ",(sum/n));
    }
    /**
     * Намира най - голямото число измежду всички останали в групата
     * @param array Подадения масив от потребителя за обработка
     */
    public static void findSmallerNumberInArray7(int [] array){
        int smallerNumber= Integer.MAX_VALUE;
        for (int i = 0; i <array.length ; i++) {
            if( array[i]   < smallerNumber){
                smallerNumber  = array[i];
            }

        }
        System.out.printf("Най-малкото число е : %d%n",smallerNumber);

    }

    /**
     * Намира най - голямото число измежду всички останали в групата
     * @param array Подадения масив от потребителя за обработка
     */

        public static  void findBiggerNumberInArray6(int [] array){


            int biggerNum = Integer.MIN_VALUE;
            for (int i = 0 ; i < array.length ; i++){
                if(array[i]   > biggerNum){
                    biggerNum = array[i];

                }

            }
            System.out.printf("Най-голямото число е : %d%n",biggerNum);
            //System.out.println(biggerNum);

        }
    /**
     * Изчислява сбора на всички числа в масива
     * @param array Нашичт масив
     */
        public static void sumAllNumbersInOurArray (int [] array){

            int sum = 0;
            for( int i : array) {
                sum += i;
            }

            System.out.println(sum);
        }

    /**
     * Генерира масив от случайни числа
     * @param array началния масив
     * @return масива от случайни числа
     */
    public static int[] generateRandomArray4(int[] array) {
        //TODO незавършен
        Random random = new Random();
       // Random rd = new Random(); // creating Random object
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(); // storing ra
            // ndom integers in an array
            // printing each array element

        }
        return array;
    }
    /**
     * Трансформира въведените ни числа във низходящ  ред
     * @param ourNumbers Масива от начално въведените от нас числа
     * @return Нашия масив подреден във низходящ ред
     */
    public  static  int [] bubbleSort2(int [] ourNumbers) {
        int n = ourNumbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ourNumbers[j] < ourNumbers[j + 1]) {
                    int swichNums       = ourNumbers[j];
                    ourNumbers[j]       = ourNumbers[j + 1];
                    ourNumbers[j + 1]   = swichNums;

                }
            }
        }
        return ourNumbers;

    }

    /**
     * Трансформира въведените ни числа във възходящ ред
     * @param ourNumbers Масива от начално въведените от нас числа
     * @return Нашия масив подреден във възходящ ред
     */
    public  static  int [] bubbleSort1(int [] ourNumbers) {
        int n = ourNumbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ourNumbers[j] > ourNumbers[j + 1]) {
                    int swichNums       = ourNumbers[j];
                    ourNumbers[j]       = ourNumbers[j + 1];
                     ourNumbers[j + 1]  = swichNums;

                }
            }
        }
        return ourNumbers;

    }

    /**
     * Принтира масив на въведените от потребителя числа
     * @param// array Масива от начално въведените от потрбителя числа
     * @return Принтира същичят масив в конзолата
     */

    //public  static  void printUserChosenNumbers11(int[] array){

     //   for (int i = 0; i < array.length ; i++) {

       //     array[i] = scanner.nextInt();
//
             //  if (( array[0] <0 && array[0]>100)){
               //    System.out.print("Опитай отново :");
               //     break;

          //     }
//
     //   }
   // }

    /*
     * Принтира всякакъв вид масиви
     * @param arr масива подаден от потребителя за принтиране
     */
    public static void printArray(int arr[]){

        int n = arr.length;
        System.out.println("Твоите числа са :");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
