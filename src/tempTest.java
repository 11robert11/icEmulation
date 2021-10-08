import com.ic._74hc00.IC74hc00;

public class tempTest {
    public static void main(String[] args)  {
        IC74hc00 test = new IC74hc00();
        test.setIO(1, false);
        test.setIO(2, false);
        test.update();
        System.out.println(test.getIO(3));
    }
}
