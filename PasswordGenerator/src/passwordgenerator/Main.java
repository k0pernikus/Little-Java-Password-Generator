package passwordgenerator;

/**
 * @author Philipp Kretzschmar
 */
public class Main {
    public static void main(String[] args) {
        String password = PasswordGenerator.getPassword(10);
        System.out.println(password);
    }
}
