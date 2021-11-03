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

    public List<Client> goldClients(){
        return allClients().stream().filter(c -> c.getServiceLevel().equals(ServiceLevel.Gold)).collect(Collectors.toList());
    }

    public String clientName(String id){
        return allClients().stream().filter(c -> c.getId() == id).map(c -> c.getName()).findAny().orElse("");
    }

    public List<Integer> countServiceLevel(){
        var goldCount =  goldClients().size();
        var platinumCount = platinumClients().size();
        var premiumCount = premiumClients().size();

        List<Integer> count = List.of(goldCount, platinumCount, premiumCount);
        return count;
//        System.out.println("There are " + goldCount + " Gold clients.");
//        System.out.println("There are " + platinumCount + " Platinum clients.");
//        System.out.println("There are " + premiumCount + " Premium clients.");
    }

    public List<Client> platinumClients(){
        return allClients().stream().filter(c -> c.getServiceLevel().equals(ServiceLevel.Platinum)).collect(Collectors.toList());
    }

    public List<Client> premiumClients(){
        return allClients().stream().filter(c -> c.getServiceLevel().equals(ServiceLevel.Premium)).collect(Collectors.toList());
    }


}
