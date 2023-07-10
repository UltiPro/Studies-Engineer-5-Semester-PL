public class Administrator extends User {
    public Administrator(int id, String name, String surname, String email, String password) {
        super(id, name, surname, email, password);
    }

    @Override
    public void Description() {
        System.out.println("Administrator User");
    } // useless

    @Override
    public String toString() {
        return "[" + getId() + "] - " + getName() + " - " + getSurname();
    }
}