public class Main {

    public static void main(String[] args) {

        // Task 1 demonstration (Rectangle)
        Rectangle r = new Rectangle(5, 3);
        System.out.println(r);
        System.out.println("Area: " + r.area());
        System.out.println("Perimeter: " + r.perimeter());

        // Task 3 start (Library App)
        LibraryApp app = new LibraryApp();
        app.run();
    }
}
