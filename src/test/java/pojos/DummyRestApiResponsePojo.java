package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyRestApiResponsePojo {

    private String status;
    private DummyRestApiPojo data;
    private String message;

    public DummyRestApiResponsePojo() {
    }

    public DummyRestApiResponsePojo(String status, DummyRestApiPojo data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public DummyRestApiPojo getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(DummyRestApiPojo data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyRestApiResponsePojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
