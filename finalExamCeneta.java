import java.util.Stack;

public class finalExamCeneta {

    //Declare variables for creature and its power level
    static class Creature {
        String creatures;
        int powerLevel;

        //Constructor
        Creature(String creature, int pwrLvl) {
            this.creatures = creature;
            this.powerLevel = pwrLvl;
        }

        @Override
        public String toString() {
            return creatures + " - " + powerLevel;
        }
    }

    // Sort creatures in descending order through bubble sorting algorithm
    public static void descendingBubbleSort(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                //Swap if the current power level is less than the other
                if (creatures[j].powerLevel < creatures[j + 1].powerLevel) {
                    Creature temp = creatures[j];
                    creatures[j] = creatures[j + 1];
                    creatures[j + 1] = temp;
                }
            }
        }
    }

    //Sort creatures in ascending order through selection sort algorithm
    public static void ascendingSelectionSort(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                //Swap if the current power level is greater than other
                if (creatures[j].powerLevel < creatures[min].powerLevel) {
                    min = j;
                }
            }
            Creature temp = creatures[min];
            creatures[min] = creatures[i];
            creatures[i] = temp;
        }
    }

    //Push sorted creatures onto a stack and pop them
    public static void useStack(Creature[] creatures) {
        Stack<Creature> stack = new Stack<>();

        //Push the creatures into the stack
        for (Creature creature : creatures) {
            stack.push(creature);
        }

        //Pop and display each creature
        System.out.println("\n*** Stack Implementation: Popping Creatures ***");
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }

    public static void main(String[] args) {
        //Create an array for the specific creatures
        Creature[] creatures = {
            new Creature( "Dragon", 95),
            new Creature("Griffin", 88),
            new Creature("Unicorn", 78),
            new Creature("Phoenix", 92),
            new Creature("Centaur", 85),
        };

        //Sort creatures in descending order
        Creature[] bubbleSortCreatures = creatures.clone();
        descendingBubbleSort(bubbleSortCreatures);
        System.out.println("*** Bubble Sort: Descending Order by Power Level ***");
        for (Creature creature : bubbleSortCreatures) {
            System.out.println(creature);
        }

        //Sort creatures in ascending order
        Creature[] selectionSortCreatures = creatures.clone();
        ascendingSelectionSort(selectionSortCreatures);
        System.out.println("\n*** Selection Sort: Ascending Order by Power Level ***");
        for (Creature creature : selectionSortCreatures) {
            System.out.println(creature);
        }

        //Use stack through bubble sort implementation
        useStack(selectionSortCreatures);
    }
}