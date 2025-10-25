import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Iterator;

class Transaction {
    private String transactionId;
    private double amount;

    public Transaction(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return "ID: " + transactionId + ", Amount: " + amount;
    }
}


public class PalindromeChecker {

    /**
     * Checks if the sequence of transaction amounts in a LinkedList forms a palindrome.
     *
     * @param transactions The list of transactions to check.
     * @return true if the sequence of amounts is a palindrome, false otherwise.
     */
    public static boolean isTransactionPalindrome(LinkedList<Transaction> transactions) {
        // A list with 0 or 1 element is always a palindrome.
        if (transactions.size() <= 1) {
            return true;
        }

        Stack<Double> stack = new Stack<>();
        Queue<Double> queue = new LinkedList<>(); // LinkedList implements the Queue interface.

        // Step 1: Populate the Stack and Queue in a single pass.
        for (Transaction tx : transactions) {
            stack.push(tx.getAmount());
            queue.offer(tx.getAmount());
        }

        // Step 2: Compare elements.
        // Dequeue from the front (FIFO) and pop from the top (LIFO).
        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (Double.compare(stack.pop(), queue.poll()) != 0) {
                return false; // Mismatch found, not a palindrome.
            }
        }

        // If the loops complete without returning false, it's a palindrome.
        return true;
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        // Test Case 1: A palindrome list
        LinkedList<Transaction> palindromeList = new LinkedList<>();
        palindromeList.add(new Transaction("A1", 100.50));
        palindromeList.add(new Transaction("B2", 250.00));
        palindromeList.add(new Transaction("C3", 250.00));
        palindromeList.add(new Transaction("D4", 100.50));

        System.out.println("Checking list 1: " + palindromeList);
        boolean result1 = isTransactionPalindrome(palindromeList);
        System.out.println("Is it a palindrome? " + result1); // Expected: true
        System.out.println("Original list remains unchanged: " + palindromeList);


        System.out.println("\n-----------------------------\n");

        // Test Case 2: A non-palindrome list
        LinkedList<Transaction> nonPalindromeList = new LinkedList<>();
        nonPalindromeList.add(new Transaction("X1", 50.00));
        nonPalindromeList.add(new Transaction("Y2", 75.25));
        nonPalindromeList.add(new Transaction("Z3", 50.50));

        System.out.println("Checking list 2: " + nonPalindromeList);
        boolean result2 = isTransactionPalindrome(nonPalindromeList);
        System.out.println("Is it a palindrome? " + result2); // Expected: false
        System.out.println("Original list remains unchanged: " + nonPalindromeList);
    }
}