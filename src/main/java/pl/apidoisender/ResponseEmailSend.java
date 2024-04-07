package pl.apidoisender;

import java.io.Serializable;
import java.util.List;

public class ResponseEmailSend implements Serializable {

    private boolean success;
    private List<String> message;
    private boolean contactExists;
    private String contactId;

    public ResponseEmailSend(boolean success, List<String> message, boolean contactExists, String contactId) {
        this.success = success;
        this.message = message;
        this.contactExists = contactExists;
        this.contactId = contactId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public boolean isContactExists() {
        return contactExists;
    }

    public void setContactExists(boolean contactExists) {
        this.contactExists = contactExists;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    @Override
    public String toString() {
        return "ResponseSend{" +
                "success=" + success +
                ", message=" + message +
                ", contactExists=" + contactExists +
                ", contactId='" + contactId + '\'' +
                '}';
    }
}
