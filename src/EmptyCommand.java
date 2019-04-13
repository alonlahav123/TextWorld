public class EmptyCommand implements Command {

    public EmptyCommand() {
    }

    public void init(String userString){
    }

    public void execute() {
        System.out.println("Commands: \"go <roomname>\", \"look\", drop \"<item name>\", take \"<item name>\", and \"quit\"");
    }

}
