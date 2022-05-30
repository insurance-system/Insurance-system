package core.insurance.repository;

import java.io.IOException;

public class InsuranceRepository {
    private static final String insuranceFile = "insurance.txt";

    public String insert(String clientStr) throws IOException {
//        return FileCRUD.insertOne(insuranceFile, clientStr);
        return null;
    }

    public String findById(String clientId){
//        return FileCRUD.findById(clientId, insuranceFile);
        return null;
    }

    public String update(String clientId, String clientStr) throws IOException {
//        return FileCRUD.updateOne(clientId, insuranceFile, clientStr);
        return null;
    }

    public void deleteById(String clientId) throws IOException {
//        FileCRUD.deleteById(clientId, insuranceFile);
    }
}
