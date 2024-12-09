import java.util.List;
import java.util.Random;

public class Scoring {
    private static Random ran = new Random();

    public static double calculatescore(List<Task> taskList) {
        // random scoring from 0 to 10 till the class is written
        return ran.nextDouble() * 10;
    }

}
