
public class Playlist {
    private static class Node {
        Song song;
        Node next;
        // Node constructor...
        public Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    public void addSong(Song song) {
        // Your implementation here...
        Node newNode = new Node(song);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void removeSong(String title) {
        // Handle two cases: removing the head and removing from elsewhere.
        // Don't forget to update the tail if the last song is removed.
        if (head == null) return; 
        while (head != null && head.song.title.equals(title)) {
            if (currentNode == head) {
                currentNode = (head.next != null) ? head.next : null;
            }
            head = head.next;
            size--;
        }

        if (head == null) {
            tail = null;
            currentNode = null;
            return;
        }

        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.song.title.equals(title)) {
                if (currentNode == curr) {
                    currentNode = (curr.next != null) ? curr.next : head;
                }
                prev.next = curr.next;
                if (curr == tail) {
                    tail = prev;
                }
                size--;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void playNext() {
        // If currentNode is null, start from the head.
        // Otherwise, advance to the next node.
        // If you reach the end, loop back to the head.
        if (head == null) {
            System.out.println("The playlist is empty.");
            return;
        }

        if (currentNode == null) {
            currentNode = head;
        } else {
            currentNode = (currentNode.next != null) ? currentNode.next : head;
        }
        System.out.println("Now playing: " + currentNode.song);
    }
    
    public void displayPlaylist() {
        // Traverse from the head and print each song.
        if (head == null) {
            System.out.println("[The playlist is empty.]");
            return;
        }

        Node p = head;
        int i = 1;
        while (p!= null) {
            System.out.println(i + ". " + p.song);
            p = p.next;
            i++;
        }
        System.out.println("Total songs: " + size);
    }
}