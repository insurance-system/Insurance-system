package domain.customer.entity;

public class Payer {
    private String payerId;
    private String customerId;
    private String contractId;
    private String account; //TODO 이거 Payer가 납부해야하는 account? right?

    @Override
    public String toString() {
        return "계약 납부자[납부자 ID:"+payerId+
                " / 고객 ID"+customerId+
                " / 계약 ID:" +contractId +
                " / 입금계좌번호:" + account +"]";
    }
}
