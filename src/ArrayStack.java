// Array implementation of Stack
class ArrayStack {
    private int size;
    private int top;
    private int[] stack;

    public static class EmptyStackException extends RuntimeException {
        public EmptyStackException() {}
    }

    public static class OverflowStackException extends RuntimeException {
        public OverflowStackException() {}
    }

    public ArrayStack(int n) {
        stack = new int[n];
        size = n;
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int x) throws OverflowStackException {
        if (isFull())
            throw new OverflowStackException();
        stack[++top] = x;
    }

    public int pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        return stack[top--];
    }
}


class TestArrayStack {
    public static void main(String[] args) {
        ArrayStack stk = new ArrayStack(5);

        System.out.println(stk.isEmpty());

        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);

        System.out.println(stk.isFull());

        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
    }
}
