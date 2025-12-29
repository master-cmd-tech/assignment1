public class Main {

    public static void main(String[] args) {


        Rectangle r = new Rectangle(5, 3);
        System.out.println(r);
        System.out.println("Area: " + r.area());
        System.out.println("Perimeter: " + r.perimeter());


        LibraryApp app = new LibraryApp();
        app.run();
    }
}
