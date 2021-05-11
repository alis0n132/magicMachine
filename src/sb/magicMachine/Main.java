package sb.magicMachine;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int result = solution(14, 29);
        System.out.println(result);
    }



    private static int solution(int a, int b) {
        Queue<Integer> queue = new ArrayDeque<>();
        if (a == b) return 0;
        goDeeper(a, queue);
        int operationsCounter = 1;//т.к одна операция уже была выше

        while (!queue.isEmpty()) {
            Queue<Integer> nextLevelQueue = new ArrayDeque<>();

            if (queue.contains(b)) {
                System.out.println("Чтобы с числа " + a + " сделать число " +
                        b + " нужно было минимум " + operationsCounter + " Нажатий");
                return operationsCounter;
            } else {

                while (!queue.isEmpty()) {
                    goDeeper(queue.poll(), nextLevelQueue);
                }
                operationsCounter += 1;
                queue = nextLevelQueue;
            }

        }
        return operationsCounter;
    }

    private static void goDeeper(int a, Queue<Integer> queue) {
        multiplicationX3(a, queue);
        sumOfElementsToQueue(a, queue);
        minus(a, queue);


    }

    static void multiplicationX3(int a, Queue<Integer> queue) {
        queue.add(a * 3);
    }

    static void minus(int a, Queue<Integer> queue) {
        queue.add(a - 2);
    }


    static void sumOfElementsToQueue(int a, Queue<Integer> queue) {
        queue.add(sumEl(a) + a);
    }

    static int sumEl(int a) {
        int result = 0;
        while (a >= 1) {
            result += a % 10;
            a = a / 10;
        }
        return result;
    }

}
