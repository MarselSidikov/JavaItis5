package custom;

/**
 * Created by User on 30.03.2017.
 */
public class MainOther {
    public static void main(String[] args) {
        throw new MyExceptionUnchecked();
    }
}
