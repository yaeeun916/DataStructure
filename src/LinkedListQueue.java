import java.util.Scanner;

class LinkedListQueue {
    private Node front;
    private Node rear;
    private int numelt;
    private int size;

    private class Node {
        int key;
        Node next;  // references node after this
    }

    public static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException() {}
    }

    public static class OverflowQueueException extends RuntimeException {
        public OverflowQueueException() {}
    }

    public LinkedListQueue(int n) {
        front = null;
        rear = null;
        numelt = 0;
        size = n;
    }

    public boolean isEmpty() {
        return (numelt == 0);
    }

    public boolean isFull() {
        return (numelt == size);
    }

    public void enqueue(int x) throws OverflowQueueException {
        if (isFull())
            throw new OverflowQueueException();

        numelt++;
        Node newNode = new Node();
        newNode.key = x;

        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();

        numelt--;
        int y = front.key;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return y;
    }

    public int peek() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();

        return (front.key);
    }

    public int getNumelt() {
        return numelt;
    }

    public int getSize() {
        return size;
    }
}


class TestLinkedListQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListQueue queue = new LinkedListQueue(10);

        while (true) {
            System.out.printf("current number of elements : %d/%d\n", queue.getNumelt(), queue.getSize());
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
                    } catch (LinkedListQueue.OverflowQueueException e) {
                        System.out.println("OVERFLOW");
                    }
                    System.out.println();
                    break;

                case 2:
                    try {
                        x = queue.dequeue();
                        System.out.println(x);
                    } catch (LinkedListQueue.EmptyQueueException e) {
                        System.out.println("EMPTY");
                    }
                    System.out.println();
                    break;

                case 3:
                    try {
                        x = queue.peek();
                        System.out.println(x);
                    } catch (LinkedListQueue.EmptyQueueException e) {
                        System.out.println("EMPTY");
                    }
                    System.out.println();
                    break;
            }
        }
    }
}
