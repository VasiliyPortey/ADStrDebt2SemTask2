import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int arrLength = sc.nextInt();
        ArrayList<Integer> numbersArrayList = new ArrayList<>();
        for (int i = 0; i < arrLength; i++)
            numbersArrayList.add(new Integer(randomEntering(-10,10)));
        System.out.println("Получившийся массив: ".concat(numbersArrayList.toString()));
        System.out.println("Подпоследовательность с наибольшей суммой: ".concat(maxSumSequence(numbersArrayList).toString()));
    }

    private static int randomEntering(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private static ArrayList<Integer> maxSumSequence(ArrayList<Integer> numsArr){
        Integer endSum = 0;
        Integer currentSum = 0;
        ArrayList<Integer> endSubArray = new ArrayList<>();
        ArrayList<Integer> currentSubArray = new ArrayList<>();
        for (int i = 0; i < numsArr.size(); i++){
            if (numsArr.get(i)>=0) {
                currentSubArray.add(numsArr.get(i));
                currentSum += numsArr.get(i);
            }
            else {
                if (currentSum>endSum){
                    endSum = currentSum;
                    endSubArray.clear();
                    endSubArray.addAll(currentSubArray);
                }
                currentSum = 0;
                currentSubArray.clear();
            }
        }
        return endSubArray;
    }

}