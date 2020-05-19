import java.util.Random;
import java.util.Scanner;

public class Homework6 {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static int[] arrayOfNumbers;

    public static void main(String[] args) {
        arrayOfNumbers = new int[n];
        printMenu();
        chooseOption();

    }

    /**
     * Принтира  главното меню
     */
    public static void printMenu() {
        System.out.println("1. Работа с числа");
        System.out.println("2. Работа с думи");
        System.out.println("3. Изход от програмата");


    }

    /**
     * Дава възможност на потребителя да избере една от опциите в главното меню
     */
    public static void chooseOption() {
        System.out.print("Изберете една от тези опции :");
        int yourOption = scanner.nextInt();     //Integer.parseInt(scanner.nextLine());
        switch (yourOption) {
            case 1:
                printUserChosenNumbers();
                break;
            case 2:
                printUserChosenStrings();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    /**
     * Въвежда масив от числа който потребителя сам избира
     */
    public static void printUserChosenNumbers() {

        System.out.println("Въведете n на брой числа :");
        n = scanner.nextInt();
        int[] array = new int[n];
        System.out.printf("Въведете %d числа :\n ", n);
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();

            if (array[i] < 0 || array[i] > 10000) {
                System.out.println("Опитай отново с число в рамките от 0 до 10 000:");
                printUserChosenNumbers();
                break;
            }

        }
        printSubMenuOfNumbers(array);
    }

    /**
     * Принтира менюто за сортировка  на цели числа
     *
     * @param arr Подадения масив
     */
    public static void printSubMenuOfNumbers(int[] arr) {
        System.out.print("Изберете една от тези опции :\n");
        System.out.println("1. Извеждане само на простите числа от масива");
        System.out.println("2. Извеждане на най-често срещан елемент в масива");
        System.out.println("3. Извеждане на максимална редица от нарастващи елементи в масива");
        System.out.println("4. Извеждане на максимална редица от намаляващи елементи в масива");
        System.out.println("5. Извеждане на максимална редица от еднакви елементи в масива");
        System.out.println("6. Извеждане на последователност от числа от масива, които имат сума\n" +
                "равна на число, генерирано на случаен принцип");
        System.out.println("7. Връщане назад към основното меню\n");

        chooseOptionToSortNumbers(arr);
    }

    /**
     * Дава възможност на потребителя да избере една от сортировките на масива от числа
     *
     * @param array подадения масив от цели числа
     */
    public static void chooseOptionToSortNumbers(int[] array) {
        System.out.print("Изберете опция : ");
        int option = scanner.nextInt();
        while (option != 7) {
            switch (option) {
                case 1:
                    findPrimeNumbers(array);
                    break;
                case 2:
                    mostRepeatingNum(array);
                    break;
                case 3:
                    maxRollOfIncreasingElements(array, 0, n - 1);
                    break;
                case 4:
                    maxRollOfShrinkingNums(array, 0, n - 1);
                    break;
                case 5:
                    maxRollOfEqualsNums(array, 0, n - 1);
                    break;
                case 6:
                    randomNumber(array);
                    break;
                case 7:
                    printMenu();
                    break;
            }
            option = scanner.nextInt();

        }
    }

    public static void findPrimeNumbers(int[] array) {
        boolean isPrime = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 2; j < array[i]; j++) {
                if (array[i] % j == 0) {
                    isPrime = false;
                    break;
                }

            }
            if (isPrime) {
                System.out.println(array[i] + " е просто число");
            }
        }

    }


    static void eqalTORandom(int[] arr, int low, int high) {
        Random rand = new Random(scanner.nextInt());
        int max = arr[low];
        for (int i = low; i <= high; i++) {
            if ((arr[i] + arr[i + 1] + arr[i + 2]) == 12) {
                // System.out.println(arr[i] , arr[i+1] , arr[i+2]);
            }
            // if(arr[i]==max){
            //    max=arr[i];
            //     System.out.print(arr[i] + " ");
            //   }
        }

    }

    /**
     * Генерира случайно число и търси за редица чиисто сбор е равен на неговата стойност
     *
     * @param array масива за сортиране
     */
    public static void randomNumber(int[] array) {
        Random rand = new Random();
        int i ;
        int sum = 0 ;
        boolean isEqualsToRandom = false;
        int generateNumber = rand.nextInt(100);//ако ще въвеждате по големи числа го променете на по голямо число
        System.out.printf("Твойто число е %d%n", generateNumber);
        for ( i = 0; i < array.length; i++) {
            sum += array[i];
            for (int j = 1; j < array.length; j++) {
                sum += array[j];
                if (sum == generateNumber) {

                    isEqualsToRandom = true;
                    System.out.printf("Последователната редица е : %d %d % d %n", array[i],array[i+1],array[i+2]);
                    break;
                }
                if (sum > generateNumber) {
                    i += 1;
                    sum = 0;
                    j= i+1;
                    break;
                }

            }

        }
        if (!isEqualsToRandom) {
            System.out.println("Няма намерени последоватлни числа равни на генерираното ");
        }
        //  for (int val : array  ) {
        //      sum+=val;
        //    if(sum==generateNumber){
        //       isEqualsToRandom =true;
        //       System.out.printf("Последователната редица е : %d%n",val);
        //         break;
        //   }
        //   }

    }


    /**
     * Извежда редица от последователно  повтарящи се  числа в нашия масив
     * @param arr  нашия масив
     * @param low минимална стойност на масива
     * @param high  максимална  стойност на масива
     */
    static void maxRollOfEqualsNums (int arr[], int low, int high){
        int max =arr[low];
        System.out.println("Максимала редица от повтарчщите числа е:");
        for (int i = low; i <=high ; i++) {

            if(arr[i]==max){
                max=arr[i];
                System.out.print(arr[i] + " ");
            }
        }

    }
    /**
     * Извежда редица от максимално намаляващите числа в нашия масив
     * @param arr  нашия масив
     * @param low минимална стойност на масива
     * @param high  максимална  стойност на масива
     */
    static void maxRollOfShrinkingNums (int arr[], int low, int high){
        int max =arr[low];
        System.out.println("Максимално намаляващата редица е");
        for (int i = low; i <=high ; i++) {
            if(arr[i]<=max){
                max=arr[i];
                System.out.print(arr[i] + " ");
            }
        }

    }

    /**
     * Извежда редица от максимално нарастващите  числа в нашия масив
     * @param arr  нашия масив
     * @param low минимална стойност на масива
     * @param high  максимална  стойност на масива
     */
    static void maxRollOfIncreasingElements(int [] arr, int low, int high)
    {
        int max = arr[low];
        int i;
        System.out.println("Максимално нарастваща редица е");
        for (i = low; i <= high; i++)
        {
            if (arr[i] >= max) {
                max = arr[i];
                System.out.print(arr[i] + " ");
            }

        }

    }

    /**
     * Извежда на конзолата кое число от нашият масив се повтаря най - много пъти в масива си
     * и колко пъти се среща
     * @param array Нашия масив
     */
    public static  void mostRepeatingNum (int [ ] array){
       int count= 0 , curr_cnt = 1, frequent_num = 0, searchingKey = 0;
        for(int i = 0; i < n-1; i++)
        {
            searchingKey =  array[i];
            for(int j =i+1; j < n; j++)
            {
                if(searchingKey == array[j] && frequent_num != searchingKey)
                {
                    curr_cnt++;
                }

            }
            if(count < curr_cnt)    {
            count = curr_cnt;
            curr_cnt = 1;
            frequent_num = searchingKey;
                                    }

        }
        System.out.printf("Num = %d and it repeat %d times ", frequent_num,count);

    }

    /**
     * Принтира масив от цели числа
     * @param array подадения масив
     */
    public static void printAnyArray (int [] array) {
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]+" ");


        }
    }

    /**
     * Дава възможност на потребителя да избере една от сортировките на масива от стрингове
     * @param arr масива подаден от потребителя за сортиране
     */
    public static void chooseOptionFromStringMenu(String [] arr){
        System.out.print("Изберете опция : ");
        int option = scanner.nextInt();
        while (option!=5){
            switch (option) {
                case 1 :printAnyStringArray(reverseWordsInArray(arr)); break;
                case 2 : repeatingChars(arr); break;
                case 3 :getCountOfLettersInArray(arr); break;
                case 4 : checkForEqualsWords(arr); break;
                case 5 :printMenu(); break;
            }
            option=scanner.nextInt();
        }


    }

    /**
     * Принтира менюто за сортиране на стрингове
     * @param arr масива за сортиране
     */
    public static  void printSubMenuOfWords(String [] arr ){
        System.out.println("1. Обърнете буквите на думите от масива наобратно и ги\n" +
                "визуализирайте в конзолата");
        System.out.println("2. Изведете броя на повтарящите се символи за всяка една от думите в\n" +
                "масива");
        System.out.println("3. Изведете броя на символите за всяка една от думите в масива");
        System.out.println("4. Изведете броя на повтарящите се думи от масива");
        System.out.println("5. Връщане назад към основното меню\n");
        System.out.print("Изберете една от тези опции : ");
        chooseOptionFromStringMenu(arr);
    }

    public static void printAnyStringArray (String  [] array) {
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] + " ");

        }
    }
    public  static  void  printUserChosenStrings(){
        System.out.println("Въведете n на брой думи :");
        n = scanner.nextInt();
        System.out.printf("Въведете %d думи",n);
        String [] ourStringArray = new String[n+1];
        for (int i = 0; i < ourStringArray.length  ; i++) {
            ourStringArray[i]=scanner.nextLine();

            if(ourStringArray[i].length() > 20){
                System.out.println("Опитай отново с дума която съдържа до 20 символа");
                printUserChosenStrings();
                break;
            }

        }
        printSubMenuOfWords(ourStringArray);
    }
    public static void repeatingChars(String[] words) {
        int countOfSymbol = 1;
        char repeatedSymbol = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                for (int k = j + 1; k < words[i].length(); k++) {
                    if (words[i].charAt(j) == words[i].charAt(k)) {
                        countOfSymbol++;
                        repeatedSymbol = words[i].charAt(j);
                        System.out.printf("Думата %s съдуржа буквата %c кочто се повтаря %d%n",words[i],repeatedSymbol,countOfSymbol);
                    }
                }
                countOfSymbol = 1;
            }
        }
    }

    /**
     * Обръща буквореда на обратно :D
     * @param words Подадения масив за обхождане
     * @return
     */
    public static  String [] reverseWordsInArray (String [] words){
        String [] reversed = new String[words.length];
            for (int i = 0; i <words.length ; i++) {
                reversed[i]="";
                for (int j = words[i].length()-1; j >= 0  ; j--) {
                    reversed[i] +=  words[i].charAt(j);
                }
            }
            return reversed;

        }

        public static  void getCountOfLettersInArray(String [] words){
            int count =0;
            for ( String currWord :  words ) {
               count+= currWord.length();
                System.out.printf("Думата  %s има %d символа%n",currWord,count);
                count=0;
            }
          // System.out.println(count);
        }
        public  static  void checkForEqualsWords (String [] words ){
        int count =0;
        boolean haveEqualsWords =false;
        for (int i = 0;i < words.length; i++){
            for (int j = 1; j <words.length ; j++) {
                if(words[i].toLowerCase().equals(words[j].toLowerCase())){
                    haveEqualsWords=true;
                    count++;
                }
            }
            if(haveEqualsWords){
                System.out.printf("Думата %s се повтаря %d пъти%n",words[i].toLowerCase(),count);
                count=0;
            }else {
                System.out.printf("Думата %s няма намерени повторения!%n",words[i].toLowerCase());
            }

        }

    }


}
