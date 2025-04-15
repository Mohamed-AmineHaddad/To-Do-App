import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Task> taskList = new ArrayList<>();

        App app1 = new App("ToDoApp", taskList);

        app1.appLoop();
    }
}
