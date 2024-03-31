import java.util.LinkedList;
import java.util.Queue;

public class Day87Dota2Senate {

    public static void main(String[] args) {
        String senate = "RDRDDDRRR";

        System.out.println("Winner is: " + predictPartyVictory(senate));
    }

    public static String predictPartyVictory(String senate) {
        // queues to store indices of Radiant and Dire
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);// add radiant senator index to queue
            } else {
                dire.offer(i);// add dire senator index to queue
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll(); // get the index of the next radiant senator
            int dIndex = dire.poll(); // get the index of the next dire senator

            if (rIndex < dIndex) {
                // if rIndex is less than dIndex then radiant senator survives,
                // and add back to the queue with an offset for the next round
                radiant.offer(rIndex + n);
            } else {
                dire.offer(dIndex + n); // in this case dire senator survives
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";// return the winner based on remaining senator
    }
}
