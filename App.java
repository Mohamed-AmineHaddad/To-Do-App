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

    public void displayTasks() {
        for (int i = 0; i < this.tasks.size(); i++) {

            if (this.tasks.get(i).getIsDone() == false) { // Si tâche non accomplie, afficher une case vide [ ]
                System.out.println(i + 1 + " [" + ' ' + "] " + this.tasks.get(i).getName());
            }

            else { // Si tâche accomplie, afficher une case cochée [X]
                System.out.println(i + 1 + " [" + 'X' + "] " + this.tasks.get(i).getName());
            }
        }
    }

    public void addTask() { // Méthode permettant d'ajouter une tâche à la liste
        Scanner addTaskInput = new Scanner(System.in);

        System.out.print("Entrez le nom de la tâche à ajouter : ");
        String userChoiceAdd = addTaskInput.nextLine();
        Task task = new Task(userChoiceAdd, false);
        this.tasks.add(task);
    }

    public void removeTask() { // Méthode permettant de supprimer une tâche de la liste
        Scanner removeTaskInput = new Scanner(System.in);

        try {
            System.out.print("Entrez le numéro de la tâche à supprimer : ");
            int userChoiceRemove = removeTaskInput.nextInt();
    
            if (userChoiceRemove < 1 || userChoiceRemove > this.tasks.size()) {
                return;
            }
            this.tasks.remove(userChoiceRemove - 1);
        } 
        catch (InputMismatchException e) {}
    }

    public void toggleTaskStatus() {
        Scanner checkTaskInput = new Scanner(System.in);

        try {
            System.out.print("Entrez le numéro de la tâche à cocher / décocher : ");
            int userChoiceCheck = checkTaskInput.nextInt();

            if (userChoiceCheck < 1 || userChoiceCheck > this.tasks.size()) {
            return;
            }        
        
            if (this.tasks.get(userChoiceCheck - 1).getIsDone() == false) {
                this.tasks.get(userChoiceCheck - 1).setIsDone(true);
            }

            else {
                this.tasks.get(userChoiceCheck - 1).setIsDone(false);
            }
            
        } catch (InputMismatchException e) {}
    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    

    public void appLoop() {

        Scanner userChoiceInput = new Scanner(System.in);
    
        while (true) {
            System.out.println("[ To-Do List ]");
            System.out.println("--------------------------");
            System.out.println("Liste des tâches");
            displayTasks();
            System.out.println("--------------------------");
            System.out.println("1 - Ajouter une tâche");
            System.out.println("2 - Supprimer une tâche");
            System.out.println("3 - Marquer une tâche");
            System.out.println("4 - Quitter l'application");
            System.out.print("----> ");
    
            String input = userChoiceInput.nextLine(); // on lit toute la ligne
    
            int userChoice;
    
            try {
                userChoice = Integer.parseInt(input); // conversion en int
            } catch (NumberFormatException e) {
                clearConsole();
                continue;
            }
    
            if (userChoice == 1) {
                addTask();
            }
    
            else if (userChoice == 2) {
                removeTask();
            }
    
            else if (userChoice == 3) {
                toggleTaskStatus();
            }
    
            else if (userChoice == 4) {
                System.out.println("À bientôt !");
                break;
            }
    
            else {
                clearConsole();
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