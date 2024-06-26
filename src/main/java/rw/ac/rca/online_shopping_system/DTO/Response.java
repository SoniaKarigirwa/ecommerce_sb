package rw.ac.rca.online_shopping_system.DTO;


import lombok.Data;
import rw.ac.rca.online_shopping_system.enums.ResponseType;

@Data
public class Response {
    private ResponseType responseType;
    private String message;
    private Object payload;

    public Response setResponseType(ResponseType responseType) {
        this.responseType = responseType;
        return this;
    }

    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    public Response setPayload(Object payload) {
        this.payload = payload;
        return this;
    }
}
