public class CorporateClient extends Client{
    private String accountManager;

    public CorporateClient(String name, String id, ServiceLevel serviceLevel, String accountManager) {
        super(name, id, serviceLevel);
        this.accountManager = accountManager;
    }

    public String getAccountManager() {
        return accountManager;
    }

    @Override
    public String getContactPerson() {
        return this.accountManager;
    }

}

