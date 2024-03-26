import java.util.Stack;

public class Day85AsteroidCollision {

    public static void main(String[] args) {
        int[] asteroids = { 4, 6, -1, -4, 10, -11, 2 };

        int[] result = asteroidCollision(asteroids);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i : asteroids) {
            if (i > 0) {
                st.add(i);
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(i)) {
                    st.pop();
                }

                if (st.isEmpty() || st.peek() < 0) {
                    st.add(i);
                } else if (st.peek() == Math.abs(i)) {
                    st.pop();
                }
            }
        }

        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}
