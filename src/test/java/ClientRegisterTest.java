import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientRegisterTest {
    AccountManager accountManager1 = new AccountManager("Bismark", "ACM100");
    AccountManager accountManager2 = new AccountManager("Kwame", "ACM101");
    AccountManager accountManager3 = new AccountManager("Essel", "ACM102");
    AccountManager accountManager4 = new AccountManager("Kenneth", "ACM103");

    List<CorporateClient> corporateClientList = List.of(
            new CorporateClient("Henry", "1000", ServiceLevel.Gold, accountManager1),
            new CorporateClient("Yaw", "1001", ServiceLevel.Gold, accountManager2),
            new CorporateClient("Agnes", "1002", ServiceLevel.Platinum, accountManager3),
            new CorporateClient("Okai", "1003", ServiceLevel.Premium, accountManager4)
    );

    List<PrivateClient> privateClientList = List.of(
            new PrivateClient("Amfonia", "2000", ServiceLevel.Premium),
            new PrivateClient("Akonobea", "2001", ServiceLevel.Gold),
            new PrivateClient("Essuman", "2002", ServiceLevel.Premium),
            new PrivateClient("Jeffrey", "2003", ServiceLevel.Platinum)
    );

    ClientRegister clientRegister = new ClientRegister(corporateClientList, privateClientList);

    @Test
    void allClients() {
        assertEquals(8, clientRegister.allClients().size());
    }

    @Test
    void goldClients() {
        assertTrue(clientRegister.goldClients().stream().allMatch(s -> s.getServiceLevel() == ServiceLevel.Gold));
    }


    @Test
    void getGoldClientContactName(){
        var list = List.of("Bismark", "Kwame", "Akonobea");
        assertEquals(list, clientRegister.getGoldClientsContactname());
    }
    @Test
    void clientName() {
        assertEquals("Akonobea", clientRegister.clientName("2001"));
    }

    @Test
    void countServiceLevel() {
        List<Integer> expected = List.of(3, 2, 3);
        List<Integer> actual = clientRegister.countServiceLevel();
        assertEquals(expected , actual);
    }

}