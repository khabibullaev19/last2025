package techproedapi.mains;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class PojoPractice03 {

    @SerializedName("status")
    @Expose
    private String status;

    @Override
    public String toString() {
        return "PojoPractice03{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public PojoPractice03() {
    }

    public PojoPractice03(String status, Data data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("message")
    @Expose
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}