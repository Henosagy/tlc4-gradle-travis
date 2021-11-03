public class PrivateClient extends Client{
    public PrivateClient(String name, String id, ServiceLevel serviceLevel) {
        super(name, id, serviceLevel);
    }

    @Override
    public String getContactPerson() {
        return this.getName();
    }

}
