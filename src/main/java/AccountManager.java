public class AccountManager {
    private String name;
    private String id;

    public AccountManager(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AccountManager{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
