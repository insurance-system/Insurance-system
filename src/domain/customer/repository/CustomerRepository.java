package domain.customer.repository;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerRepository {

    private static final String clientFile = "client-informations";
    //고객 관심사항 파일
    private static final String clientInterestFile = "customer-advice";

    public String insert(String clientStr){
//        return FileCRUD.insertOne(clientFile, clientStr);
        return null;
    }

    public String findById(String clientId){
//        return FileCRUD.findById(clientId, clientFile);
        return null;
    }

    String update(String clientId, String clientStr) throws IOException {
//        return FileCRUD.updateOne(clientId, clientFile, clientStr);
        return null;
    }

    public void deleteById(String clientId) throws IOException {
//        FileCRUD.deleteById(clientId, clientFile);
    }

    public String insertInterest(ArrayList<String> clientStr){
        String asd = "";
        System.out.println(asd);
        for (String s : clientStr) asd += s + " ";
//        return FileCRUD.insertOne(clientInterestFile, asd);
        return null;
    }
}
