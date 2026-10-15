package main.java.Week7.assignment_problems;

public class TrafficLightApp {

    static class TrafficLight {
        private static final String[] COLORS = {"RED", "GREEN", "YELLOW"};

        private final String id;
        private int position;

        TrafficLight(String id) {
            this.id = id;
            this.position = 0;
        }

        String getColor() {
            return COLORS[position];
        }

        String next() {
            position = (position + 1) % COLORS.length;
            return COLORS[position];
        }

        String getId() {
            return id;
        }
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Light " + t.getId());
        System.out.println(t.getColor());
        System.out.println(t.next());
        System.out.println(t.next());
        System.out.println(t.next());
        System.out.println(t.next());
    }
}
