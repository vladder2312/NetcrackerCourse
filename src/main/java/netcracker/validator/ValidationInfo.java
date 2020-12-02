package netcracker.validator;

import java.util.List;

/**
 * Information about validation
 */
public class ValidationInfo {
    private long contractId;
    private ValidationStatus status;
    private List<String> messageList;

    public ValidationInfo(ValidationStatus status, List<String> messageList, long contractId) {
        this.status = status;
        this.messageList = messageList;
        this.contractId = contractId;
    }

    public ValidationStatus getStatus() {
        return status;
    }

    public void setStatus(ValidationStatus status) {
        this.status = status;
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    @Override
    public String toString() {
        return "ValidationInfo{" +
                "contractId=" + contractId +
                ", status=" + status +
                ", messageList=" + messageList +
                '}';
    }
}
