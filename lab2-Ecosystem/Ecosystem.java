import java.util.Random;
import java.util.Arrays;

// Step 1: Create the abstract parent class
abstract class Animal {
    // You can add shared attributes or methods here if needed
    // An abstract method for toString() can be helpful for visualization
    public abstract String toString();
}

// Step 2: Create the concrete animal classes
class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }
}

// Main class to run the simulation
public class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();
        // You can add logic here to initially populate the river
        for (int i = 0; i < river.length; i++) {
            int r = random.nextInt(3);
            river[i] = (r == 1) ? new Bear() : (r == 2) ? new Fish() : null;
        }
    }

       
        

    public void runStep() {
         // This is the core logic for a single time step.
        // 1. Create a new array for the next state.
        // 2. Iterate through the current river array.
        // 3. For each animal, decide its next move.
        // 4. Handle collisions and place animals in the new array.
        // 5. Replace the old river with the new one.
        final int size = river.length;
        Animal[] nextState = new Animal[size];

        // destinationBySource[i] = cell index this animal wants to move to, or -1 if empty
        int[] destinationBySource = new int[size];
        Arrays.fill(destinationBySource, -1);

        // Decide each animal's destination from the OLD state
        for (int srcIndex = 0; srcIndex < size; srcIndex++) {
            Animal animal = river[srcIndex];
            if (animal == null) continue;

            int step; // -1 = left, 0 = stay, 1 = right
            if (srcIndex == 0) {
                step = (new int[]{0, 1})[random.nextInt(2)];
            } else if (srcIndex == size - 1) {
                step = (new int[]{-1, 0})[random.nextInt(2)];
            } else {
                step = (new int[]{-1, 0, 1})[random.nextInt(3)];
            }

            int destIndex = srcIndex + step;
            destinationBySource[srcIndex] = destIndex;
        }

        // Resolve who ends up in each destination cell
        for (int destIndex = 0; destIndex < size; destIndex++) {
            int bearsTargeting = 0, fishTargeting = 0;

            for (int srcIndex = 0; srcIndex < size; srcIndex++) {
                if (destinationBySource[srcIndex] == destIndex) {
                    if (river[srcIndex] instanceof Bear) bearsTargeting++;
                    else if (river[srcIndex] instanceof Fish) fishTargeting++;
                }
            }

            if (bearsTargeting == 0 && fishTargeting == 0) {
                nextState[destIndex] = null; // nobody moved here
            } else if (bearsTargeting > 0 && fishTargeting > 0) {
                nextState[destIndex] = new Bear(); // bear eats fish
            } else if (bearsTargeting > 0) {
                nextState[destIndex] = new Bear();
                if (bearsTargeting >= 2) spawnNew(new Bear(), nextState); // birth
            } else { // fishTargeting > 0
                nextState[destIndex] = new Fish();
                if (fishTargeting >= 2) spawnNew(new Fish(), nextState); // birth
            }
        }

        river = nextState; // advance one step
    }


    private void spawnNew(Animal baby, Animal[] next) {
        int [] empty = new int [next.length];
        int room = 0;
        for (int i = 0; i < next.length; i++) {
            if (next[i] == null) {
                empty[room++] = i;
            }
        }
        if (room == 0) return;
        int spot = empty[random.nextInt(room)];
        next[spot] = baby;
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystem eco = new Ecosystem(20); // Create a river of size 20
        eco.visualize();
        for (int step = 0; step < 10; step++) { // Run for 10 steps
            eco.runStep();
            eco.visualize();
        }
        // Loop to run multiple steps...
    }
}