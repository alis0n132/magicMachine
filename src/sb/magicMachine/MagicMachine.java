package sb.magicMachine;

import java.util.*;

public class MagicMachine {

    static boolean[] visited = new boolean[10000];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int result = solution(a, b);
        System.out.println(result);
    }

    static private int solution(int a, int b) {
        Queue<Integer> queue = new ArrayDeque<>();
        if (a == b) return 0;

        goDeeper(a, queue);

        int operationsCounter = 1;//т.к одна операция уже была выше

        while (!queue.isEmpty()) {

            Queue<Integer> nextLevelQueue = new ArrayDeque<>(); //Deeper level queue

            if (queue.contains(b)) {
                return operationsCounter;
            } else {
                //У нас две очереди: queue - текущая, и nextLevelQueue - очередь на уровень ниже
                //Под уровнем имеется ввиду количество нажатий
                // проходим до конца текущую, извлекая каждый элемент и из него делаем 3 новых, которые
                // добавляем уже в новую очередь.
                while (!queue.isEmpty()) {
                    goDeeper(queue.poll(), nextLevelQueue);
                }

                operationsCounter += 1;
                queue = nextLevelQueue;
                nextLevelQueue = null;
            }
        }
        return operationsCounter;
    }

    private static boolean isAddToQueue(Queue<Integer> queue, int i) {
        if (i <= 9999 && i > 0 && !visited[i]) {
            visited[i] = true;
            return queue.add(i);
        }
        return false;
    }

    private static void goDeeper(int a, Queue<Integer> queue) {
        multiplicationX3(a, queue);
        sumOfElementsToQueue(a, queue);
        minus(a, queue);
    }

    static void multiplicationX3(int a, Queue<Integer> queue) {
        if (a * 3 <= 9999) {
            isAddToQueue(queue, a * 3);
        } else {
            isAddToQueue(queue, a);
        }

    }

    static void minus(int a, Queue<Integer> queue) {
        isAddToQueue(queue, a - 2);
    }


    static void sumOfElementsToQueue(int a, Queue<Integer> queue) {
        int sumOfDigits = sumEl(a);
        if (sumOfDigits + a <= 9999) {
            isAddToQueue(queue, sumOfDigits + a);
        } else {
            isAddToQueue(queue, a);
        }
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