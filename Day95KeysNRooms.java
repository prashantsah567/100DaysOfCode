import java.util.*;

public class Day95KeysNRooms {

    // Keys and Rooms
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // to keep track of which the rooms that we have already visited or not
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;// since the first room is open

        Stack<Integer> stack = new Stack<>();// stack to keep the accessible keys
        stack.push(0);// since the first room is open so we push it to the stack

        while (!stack.isEmpty()) {// while we have keys
            int curr_key = stack.pop();
            for (int new_key : rooms.get(curr_key)) // for every keys in a room
                if (!seen[new_key]) { // if this key haven't been used
                    seen[new_key] = true; // mark that we entered the room
                    stack.push(new_key); // add the key to the stack
                }

        }

        // now check if we have any false value in seen means if there is any room we
        // haven't visited
        for (boolean visited : seen) {
            if (!visited)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Day95KeysNRooms solution = new Day95KeysNRooms();

        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1)); // Room 0 has key to Room 1
        rooms.add(Arrays.asList(2)); // Room 1 has key to Room 2
        rooms.add(Arrays.asList(3)); // Room 2 has key to Room 3
        rooms.add(new ArrayList<>()); // Room 3 has no keys

        boolean canVisitAllRooms = solution.canVisitAllRooms(rooms);
        System.out.println("Can visit all rooms: " + canVisitAllRooms);
    }
}
