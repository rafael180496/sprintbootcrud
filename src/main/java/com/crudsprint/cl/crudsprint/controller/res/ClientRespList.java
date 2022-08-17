package com.crudsprint.cl.crudsprint.controller.res;
import java.util.List;

import com.crudsprint.cl.crudsprint.entity.Client;
public class ClientRespList {
    public ClientRespList(String message, int code, List<Client> response) {
        this.message=message;
        this.code=code;
        this.clients=response;
    }
    private String message;
    private int code;
    private List<Client> clients;
    public List<Client> getClients() {
        return clients;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
