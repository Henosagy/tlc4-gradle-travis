import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientRegister {
    private List<CorporateClient> corporateClientList;
    private List<PrivateClient> privateClientList;

    public ClientRegister(List<CorporateClient> corporateClientList, List<PrivateClient> privateClientList) {
        this.corporateClientList = corporateClientList;
        this.privateClientList = privateClientList;
    }

    public List<Client> allClients(){
        return Stream.concat(corporateClientList.stream(),privateClientList.stream()).collect(Collectors.toList());
    }

    public List<String> getGoldClientsContactName(){
        return allClients().stream().filter(c -> c.getServiceLevel().equals(ServiceLevel.Gold)).map(c->c.getContactPerson()).collect(Collectors.toList());
    }

    public String clientName(String id){
        return allClients().stream().filter(c -> c.getId() == id).map(c -> c.getName()).findAny().orElse("");
    }

    public List<Integer> countServiceLevel(){
        var goldCount =  allClients().stream().filter(c -> c.getServiceLevel().equals(ServiceLevel.Gold)).collect(Collectors.toList()).size();
        var platinumCount = allClients().stream().filter(c -> c.getServiceLevel().equals(ServiceLevel.Platinum)).collect(Collectors.toList()).size();
        var premiumCount = allClients().stream().filter(c -> c.getServiceLevel().equals(ServiceLevel.Premium)).collect(Collectors.toList()).size();

        List<Integer> count = List.of(goldCount, platinumCount, premiumCount);
        return count;
//        System.out.println("There are " + goldCount + " Gold clients.");
//        System.out.println("There are " + platinumCount + " Platinum clients.");
//        System.out.println("There are " + premiumCount + " Premium clients.");
    }


}
