/**
 * Created by paramasivami on 12/5/15.
 */
public class Test2 {
    public static void main(String[] args) {

        GreetingService gs = message -> System.out.println(message + " is a good boy.");
        gs.sayMessage("Iniyan");
    }

    interface GreetingService{
        void sayMessage(String message);
    }
}
