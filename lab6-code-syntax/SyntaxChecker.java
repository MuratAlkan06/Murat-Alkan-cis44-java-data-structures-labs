import java.util.EmptyStackException;

interface Stack<E> {
    void push(E e);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
}

class ArrayStack<E> implements Stack<E> {
    private Object[] data;
    private int top;

    public ArrayStack(int capacity) {
        if (capacity < 1) capacity = 16;
        data = new Object[capacity];
        top = 0;
    }

    @Override
    public void push(E e) {
        if (top == data.length) {
            Object[] nd = new Object[data.length * 2];
            System.arraycopy(data, 0, nd, 0, data.length);
            data = nd;
        }
        data[top++] = e;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E val = (E) data[--top];
        data[top] = null;
        return val;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return (E) data[top - 1];
    }

    @Override public boolean isEmpty() { return top == 0; }
    @Override public int size() { return top; }
}

public class SyntaxChecker {

    /**
     * Uses a stack to check if a line of code has balanced symbols.
     * @param line The string of code to check.
     * @return true if symbols are balanced, false otherwise.
     */
    public static boolean isBalanced(String line) {
        Stack<Character> buffer = new ArrayStack<>(line.length());
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                buffer.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (buffer.isEmpty()) return false;
                char open = buffer.pop();
                if (!matches(open, c)) return false;
            }
        }
        return buffer.isEmpty();
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }"; // Should be true
        String line2 = "int x = (5 + [a * 2]);"; // Should be true
        String line3 = "System.out.println('Hello');)"; // Should be false (extra closing parenthesis)
        String line4 = "List list = new ArrayList<{String>();"; // Should be false (mismatched)
        String line5 = "if (x > 0) {"; // Should be false (unmatched opening brace)

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}
