//Linked List implementation of stack

class LinkedListStack {
    Node top;
    int numelt;
    int size;

    private class Node {
        int key;
        Node next;
    }

    public static class EmptyStackException extends RuntimeException {
        public EmptyStackException() {}
    }

    public static class OverflowStackException extends RuntimeException {
        public OverflowStackException() {}
    }

    public LinkedListStack(int n) {
        top = null;
        numelt = 0;
        size = n;
    }

    public boolean isEmpty() {
        return numelt == 0;
    }

    public boolean isFull() {
        return numelt == size;
    }

    public void push(int x) throws OverflowStackException {
        if (isFull())
                throw new OverflowStackException();
        Node newNode = new Node();
        newNode.key = x;
        newNode.next = top;
        top = newNode;
        numelt++;
    }

    public int Pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        int y = top.key;
        top = top.next;
        numelt++;
        return y;
    }
}

class TestLinkedListStack {
    public static void main(String[] args) {
        LinkedListStack stk = new LinkedListStack(5);

        System.out.println(stk.isEmpty());

        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);

        System.out.println(stk.isFull());

        System.out.println(stk.Pop());
        System.out.println(stk.Pop());
        System.out.println(stk.Pop());
        System.out.println(stk.Pop());
        System.out.println(stk.Pop());
    }
}
