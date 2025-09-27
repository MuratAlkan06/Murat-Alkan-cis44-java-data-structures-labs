import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
        Playlist playlist = new Playlist ();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Next Song");
            System.out.println("4. Display Playlist");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter song title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = sc.nextLine();
                    playlist.addSong(new Song(title, artist));
                    System.out.println("Song added!");
                    break;
                case "2":
                    System.out.print("Enter song title to remove: ");
                    String removeTitle = sc.nextLine();
                    playlist.removeSong(removeTitle);
                    System.out.println("Song removed");
                    break;
                case "3":
                    playlist.playNext();
                    break;
                case "4":
                    playlist.displayPlaylist();
                    break;
                case "5":
                    System.out.println("Exiting!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
