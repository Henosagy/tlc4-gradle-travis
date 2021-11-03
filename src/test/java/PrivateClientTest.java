import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrivateClientTest {

    @Test
    void getContactPerson() {
        Client client1 = new PrivateClient("Henry", "1000", ServiceLevel.Premium);
        assertTrue(client1.getContactPerson() == "Henry");
    }
}