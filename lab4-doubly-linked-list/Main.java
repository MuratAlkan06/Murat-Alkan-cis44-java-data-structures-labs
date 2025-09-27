import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Simple Text Editor (Doubly Linked List) ===");
            System.out.println("1) Type (append) text");
            System.out.println("2) Undo");
            System.out.println("3) Redo");
            System.out.println("4) Print current");
            System.out.println("5) Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter text to append: ");
                    String toAdd = sc.nextLine();
                    editor.add(toAdd);
                    System.out.println("OK. Redo history cleared.");
                    break;
                case "2":
                    String afterUndo = editor.undo();
                    System.out.println("After undo -> \"" + afterUndo + "\"");
                    break;
                case "3":
                    String afterRedo = editor.redo();
                    System.out.println("After redo -> \"" + afterRedo + "\"");
                    break;
                case "4":
                    System.out.print("Current text: ");
                    editor.printCurrent();
                    break;
                case "5":
                    System.out.println("Bye.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
