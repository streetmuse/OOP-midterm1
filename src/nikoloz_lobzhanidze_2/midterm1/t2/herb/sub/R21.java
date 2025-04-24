package nikoloz_lobzhanidze_2.midterm1.t2.herb.sub;
import nikoloz_lobzhanidze_2.midterm1.t2.blender.conductor.A22;
import nikoloz_lobzhanidze_2.midterm1.t2.herb.A21;
import java.time.Month;
public class R21 {
    public static void main(String[] args) {
        A21 a21object = new A21();
        int width = a21object.getWidth();
        int height = a21object.getHeight();

        int area = width * height;
        System.out.println("the area of a rectangle is: " +area);

        A22 a22object = new A22();
        int monthNumber = a22object.getMonth();

        try {
            Month month = Month.of(monthNumber); // throws exception if invalid
            System.out.println("The name of the month is: " + month.name());
        } catch (Exception e) {
            System.out.println("Invalid month number: " + monthNumber);
        }

    }
}
