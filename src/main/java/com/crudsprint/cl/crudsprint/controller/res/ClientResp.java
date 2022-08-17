package com.crudsprint.cl.crudsprint.controller.res;

import com.crudsprint.cl.crudsprint.entity.Client;

public class ClientResp {
    public ClientResp(String message, int code, Client response) {
        this.message=message;
        this.code=code;
        this.client=response;
    }
    private String message;
    private int code;
    private Client client;
    public Client getClients() {
        return client;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
