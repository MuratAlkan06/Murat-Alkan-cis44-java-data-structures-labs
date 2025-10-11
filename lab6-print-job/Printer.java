// You will need a functioning Queue implementation (like LinkedQueue) for this to work.
// interface Queue { ... }
// class LinkedQueue implements Queue { ... }

/**
 * Represents a single document to be printed.
 */
class PrintJob {
    private String documentName;
    private int pageCount;

    // TODO: Implement the constructor
    public PrintJob(String documentName, int pageCount) {
        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    // TODO: Implement the toString method to return a descriptive string
    // e.g., "PrintJob[Document: report.docx, Pages: 15]"
    @Override
    public String toString() {
        return "PrintJob[Document: " + documentName + ", Pages: " + pageCount + "]";
    }
}

interface Queue {
    void enqueue(Object e);
    Object dequeue();
    boolean isEmpty();
}

class LinkedQueue implements Queue {
    private static class Node {
        Object data;
        Node next;
        Node(Object data) { this.data = data; }
    }
    private Node head;
    private Node tail;

    public void enqueue(Object e) {
        Node n = new Node(e);
        if (tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public Object dequeue() {
        if (head == null) return null;
        Object val = head.data;
        head = head.next;
        if (head == null) tail = null;
        return val;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

/**
 * Simulates a printer that manages a queue of print jobs.
 */
public class Printer {
    private Queue jobQueue;

    public Printer() {
        // TODO: Initialize the jobQueue with a LinkedQueue
        jobQueue = new LinkedQueue();
    }

    /**
     * Adds a new print job to the rear of the queue.
     * @param job The print job to add.
     */
    public void addJob(PrintJob job) {
        System.out.println("Adding to queue: " + job);
        // TODO: Enqueue the job
        jobQueue.enqueue(job);
    }

    /**
     * Processes the job at the front of the queue.
     */
    public void processNextJob() {
        // TODO: Check if the queue is empty. If so, print a message.
        // If not empty, dequeue the job and print a "Processing..." message.
        if (jobQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            PrintJob job = (PrintJob) jobQueue.dequeue();
            System.out.println("Processing: " + job);
        }
    }

    public static void main(String[] args) {
        Printer officePrinter = new Printer();

        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting to Print ---");
        officePrinter.processNextJob(); // Should print Annual_Report.pdf
        officePrinter.processNextJob(); // Should print Meeting_Agenda.docx

        System.out.println("\nNew high-priority job arrives...");
        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

        officePrinter.processNextJob(); // Should print Presentation_Slides.pptx
        officePrinter.processNextJob(); // Should print Urgent_Memo.pdf
        officePrinter.processNextJob(); // Should say the queue is empty
    }
}
