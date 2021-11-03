import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorporateClientTest {

    @Test
    void getContactPerson() {
        AccountManager accountManager = new AccountManager("Bismark", "A100");
        Client client1 = new CorporateClient("Henry", "1000", ServiceLevel.Gold, accountManager);
        assertTrue(client1.getContactPerson()=="Bismark");
    }
}