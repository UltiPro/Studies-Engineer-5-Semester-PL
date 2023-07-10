public class User extends Person {
    public User(int id, String name, String surname, String email, String password) {
        super(id, name, surname, email, password);
    }

    public User(int id, String name, String surname, String email, String password, int accountType) {
        super(id, name, surname, email, password, accountType);
    }

    @Override
    public void Description() {
        System.out.println("User");
    }
}