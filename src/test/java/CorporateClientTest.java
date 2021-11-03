import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorporateClientTest {

    @Test
    void getContactPerson() {
        Client client1 = new CorporateClient("Henry", "1000", ServiceLevel.Gold,"Bismark");
        assertTrue(client1.getContactPerson()=="Bismark");
    }
}