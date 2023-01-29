public abstract class Person {
    public int id;
    public String name;
    public String surname;
    public String email;
    public String password;
    public int accountType;
    public Person(int id, String name, String surname, String email, String password){
        this.name = name;
        this.surname = surname;
        this.id  = id;
        this.email = email;
        this.password = password;
        this.accountType = 1;
    }
    public Person(int id, String name, String surname, String email, String password, int accountType){
        this.name = name;
        this.surname = surname;
        this.id  = id;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public int getId() { return id; }
    public  String getEmail() { return email; }
    public abstract void Description();
}
