package NumberSystem;

import java.util.Random;
import java.util.Scanner;

public class Homework5 {

    static Scanner scanner = new Scanner(System.in);
    static int n;
    static int[] arrayOfNumbers ;

    /**
     * @author Metin Trampov
     * @param args
     */
    public static void main(String[] args) {


        System.out.println("Въведете n на брой числа :");
        n = Integer.parseInt(scanner.nextLine());
        arrayOfNumbers = new int[n];
        System.out.printf("Въведете %d числа :\n ", n);
        printUserChosenNumbers(arrayOfNumbers);

        printMenu();
        chooseOption();

    }

    /**
     * Дава избор на потребителя дали да продалжи с менюто или да приключи програмата
     */
    public  static  void chooseMenuOrExit(){
        System.out.println("Въведете 1 за меню или 0 за изход :");
         int num = Integer.parseInt(scanner.nextLine());
        if(num==1){
            printMenu();
        }else{
            System.out.println("Край ");
            System.exit(0);
        }

    }

    /**
     * Връща случайни числа от нашия масив
     * @param array Масива от потребителя
     */
    public static void shuffleNumbers(int []array) {
        Random random = new Random();
        int template;
        for (int i = 0; i < array.length; i++) {
            int pos = random.nextInt(array.length);
            template = array[pos];
            array[pos] = array[i];
            array[i] = template;
            System.out.print(" "+template);

        }System.out.println();

    }
    /**
     * Принтира менюто
     */
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

    /**
     * Дава възможност на потребителя да избира една от опциите на менюто
     */
        public static void chooseOption (){
                System.out.print("Изберете опция : ");
             int yourOption = Integer.parseInt(scanner.nextLine());
            while (yourOption!=12) {
                switch (yourOption) {
                    case 1:
                        printArray(orderNumsInIcreasingRoll(arrayOfNumbers));
                        System.out.println();
                        break;
                    case 2:
                        printArray(orderNumsInSrinkingRoll(arrayOfNumbers));
                        System.out.println();
                        break;
                    case 3:
                        System.out.print("Въведете число за търсене на позицията му в масива : ");
                        int searchingKay = Integer.parseInt(scanner.nextLine());
                        System.out.printf("Търсената стойност : %d e намерена на индекс : %d\n",searchingKay,findIndexOfCurrentNumber(arrayOfNumbers,searchingKay));
                        break;
                    case 4:
                        shuffleNumbers(arrayOfNumbers);
                       // getRandomNumber(arrayOfNumbers);
                        //RandArray(arrayOfNumbers);
                        break;
                    case 5:
                        sumAllNumbersInOurArray(arrayOfNumbers);
                        break;
                    case 6:
                        findBiggerNumberInArray6(arrayOfNumbers);
                        break;
                    case 7:
                        findSmallerNumberInArray7(arrayOfNumbers);
                        break;
                    case 8:
                        findAverageOfNumbers(arrayOfNumbers,n);
                        break;
                    case 9:
                        symmaryOrder(arrayOfNumbers,n,0);break;
                    case 10:
                        printArray(reversedArray10(arrayOfNumbers));
                        System.out.println();
                        break;
                    case 11:
                        printArray(arrayOfNumbers);
                        System.out.println();
                        break;

                }
                System.out.println();
                chooseMenuOrExit();
                System.out.print("Изберете опция : ");
                yourOption = Integer.parseInt(scanner.nextLine());
                System.out.println();
            }

       }

    /**
     *
     * @param array Въведения масив от потребителя
     * @param key Числото което да търси
     * @return Резултата от търсенето
     */
       public  static int findIndexOfCurrentNumber(int [] array,int key){
        int sizeOfArray = array.length;
        for (int i = 0; i <sizeOfArray ; i++) {
            if(array[i]==key){
                return i;
            }else {
                System.out.println("Няма такова число в вашия масив");
                chooseMenuOrExit();
            }
        }
       return -1;
    }

    /**
     * Проверява даден масив дали е семантичен или не .
     * @param A Подаденият масив
     * @param n Броят на елементите на масива
     * @param i Число за пресмчтане на семантичността
     * @return Резултата от проверката
     */
    public static boolean symmaryOrder(int[] A, int n, int i) {

        if (i > n/2) {
            System.out.println("Масива е симентичен .");
            return true;
       }
        else if (A[i] != A[n-1-i]) {
            System.out.println("Масива  не е симентичен .");
            return false;
        }
        else
           return symmaryOrder(A, n, i+1);
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

          return  reversed;
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
            System.out.println("Сбора на вашите числа е :" + sum);
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
    public  static  int [] orderNumsInSrinkingRoll(int [] ourNumbers) {
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
    public  static  int [] orderNumsInIcreasingRoll(int [] ourNumbers) {
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
public  static void validateInput (int max , int min){


}
    public  static  void printUserChosenNumbers(int[] array){

       for (int i = 0; i < array.length ; i++) {
               array[i] = Integer.parseInt(scanner.nextLine());

           if(array[i] < 0 || array[i] > 100){
               System.out.println("Опитай отново с число в рамките от 0 до 100:");
               printUserChosenNumbers(array);
                break;
           }
              // if (( array[0] >0 && array[0]<100)){
                //   System.out.print("Опитай отново :");
                 //  break;
              // }

        }
   }

    /*
     * Принтира всякакъв вид масиви
     * @param arr масива подаден от потребителя за принтиране
     */
    public static void printArray(int array[]){


        int n = array.length;
        System.out.println("Твоите числа са :");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }

    }

}
