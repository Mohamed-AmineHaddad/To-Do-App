import java.util.*;

public class App {
    private String name;
    private ArrayList<Task> tasks;

    public App(String name, ArrayList<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    public void displayTasks(ArrayList<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {

            if (tasks.get(i).getIsDone() == false) { // Si tâche non accomplie, afficher une case vide [ ]
                System.out.println(i + 1 + " [" + ' ' + "] " + tasks.get(i).getName());
            }

            else { // Si tâche accomplie, afficher une case cochée [X]
                System.out.println(i + 1 + " [" + 'X' + "] " + tasks.get(i).getName());
            }
        }
    }

    public void addTask(ArrayList<Task> tasks) { // Méthode permettant d'ajouter une tâche à la liste
        Scanner addTaskInput = new Scanner(System.in);

        System.out.print("Entrez le nom de la tâche à ajouter : ");
        String userChoiceAdd = addTaskInput.nextLine();
        Task task = new Task(userChoiceAdd, false);
        tasks.add(task);
    }

    public void removeTask(ArrayList<Task> tasks) { // Méthode permettant de supprimer une tâche de la liste
        Scanner removeTaskInput = new Scanner(System.in);

        System.out.print("Entrez le numéro de la tâche à supprimer : ");
        int userChoiceRemove = removeTaskInput.nextInt();
        tasks.remove(userChoiceRemove - 1);
    }

    public void checkTask(ArrayList<Task> tasks) {
        Scanner checkTaskInput = new Scanner(System.in);

        System.out.print("Entrez le numéro de la tâche à valider : ");
        int userChoiceRemove = checkTaskInput.nextInt();
        tasks.get(userChoiceRemove - 1).setIsDone(true);
    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    

    public void appLoop(ArrayList<Task> tasks) {

        Scanner userChoiceInput = new Scanner(System.in);

        while (true) {
            System.out.println("[ To-Do List ]");
            System.out.println("--------------------------");
            System.out.println("Liste des tâches");
            displayTasks(tasks);
            System.out.println("--------------------------");
            System.out.println("1 - Ajouter une tâche");
            System.out.println("2 - Supprimer une tâche");
            System.out.println("3 - Valider une tâche");
            System.out.println("4 - Quitter l'application");
            System.out.print("----> ");
            int userChoice = userChoiceInput.nextInt();
    
            if (userChoice == 1) {
                addTask(tasks);
            }

            else if (userChoice == 2) {
                removeTask(tasks);
            }

            else if (userChoice == 3) {
                checkTask(tasks);
            }
            
            else if (userChoice == 4) {
                System.out.println("À bientôt !");
                break;
            }

            else {
                System.out.println("Veuillez choisir une option valide");
            }

            clearConsole();
        }
    }


    @Override
    public String toString() {
        StringBuilder tasksToString = new StringBuilder();

        for (Task task : tasks) {
            tasksToString.append(task.getName());
            tasksToString.append(", ");
        }

        tasksToString.deleteCharAt(tasksToString.length() - 2);
        tasksToString.deleteCharAt(tasksToString.length() - 1);

        return "App[name = " + name + ", tasks = [" + tasksToString + "]]";
    }
    
}
