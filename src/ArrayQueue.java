// Array implementation of Queue

import java.util.Scanner;

class ArrayQueue {
    private int front;
    private int rear;
    private int size;
    private int[] que;

    public static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException() {}
    }

    public static class OverflowQueueException extends RuntimeException {
        public OverflowQueueException() {}
    }

    public ArrayQueue(int n) {
        // to store n elements, create array of n + 1 elements and always leave 1 slot empty
        // so that empty queue and full queue can be distinguished
        que = new int[n + 1];
        size = n + 1;
        front = rear = 0;
    }

    public boolean isEmpty() {
        return (front == rear);
    }

    public boolean isFull() {
        return ((rear + 1) % size == front);
    }

    public void enqueue(int x) throws OverflowQueueException {
        if (isFull())
            throw new OverflowQueueException();
        rear = (rear + 1) % size;   // advance pointer first
        que[rear] = x;              // then enqueue
    }

    public int dequeue() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        front = (front + 1) % size;     // advance pointer first
        return que[front];              // then dequeue
    }

    public int peek() {
        if (isEmpty())
            throw new EmptyQueueException();
        return que[front + 1];
    }

    public int numelt() {
        return ((rear - front) % size + size) % size;
    } // return number of stored elements

    public int size() {
        return size;
    }
}

class TestArrayQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayQueue queue = new ArrayQueue(10);

        while (true) {
            System.out.printf("current number of elements : %d/%d\n", queue.numelt(), queue.size() - 1);
            System.out.println("(1) enqueue  (2) dequeue  (3) peek  (0) exit");
            int menu;
            do {
                menu = sc.nextInt();
            } while(menu < 0 || menu > 3);

            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("data : ");
                    x = sc.nextInt();
                    try {
                        queue.enqueue(x);
                    } catch (ArrayQueue.OverflowQueueException e) {
                        System.out.println("OVERFLOW");
                    }
                    System.out.println();
                    break;

                case 2:
                    try {
                        x = queue.dequeue();
                        System.out.println(x);
                    } catch (ArrayQueue.EmptyQueueException e) {
                        System.out.println("EMPTY");
                    }
                    System.out.println();
                    break;

                case 3:
                    try {
                        x = queue.peek();
                        System.out.println(x);
                    } catch (ArrayQueue.EmptyQueueException e) {
                        System.out.println("EMPTY");
                    }
                    System.out.println();
                    break;
            }
        }
    }
}