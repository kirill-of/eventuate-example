package pro.ofitserov.tramMessage;

import java.util.ArrayList;
import java.util.Map;

public class ManageMessage {
    private Map<String, String> message;
    private ArrayList<String> additionalInfo;

    public ManageMessage(Map<String, String> message) {
        this.message = message;
    }

    public ManageMessage() {
    }

    public ManageMessage(Map<String, String> message, ArrayList<String> additionalInfo) {
        this.message = message;
        this.additionalInfo = additionalInfo;
    }

    public Map<String, String> getMessage() {
        return this.message;
    }

    public ArrayList<String> getAdditionalInfo() {
        return this.additionalInfo;
    }

    public void setMessage(Map<String, String> message) {
        this.message = message;
    }

    public void setAdditionalInfo(ArrayList<String> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String toString() {
        return "ManageMessage(message=" + this.getMessage() + ", additionalInfo=" + this.getAdditionalInfo() + ")";
    }
}
