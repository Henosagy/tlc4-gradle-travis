public class CorporateClient extends Client{
    private AccountManager accountManager;

    public CorporateClient(String name, String id, ServiceLevel serviceLevel, AccountManager accountManager) {
        super(name, id, serviceLevel);
        this.accountManager = accountManager;
    }

    public String getAccountManager() {
        return accountManager.toString();
    }

    @Override
    public String getContactPerson() {
        return this.accountManager.getName();
    }

}

