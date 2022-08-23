package com.crudsprint.cl.crudsprint.controller.res;

import java.util.Random;

import com.crudsprint.cl.crudsprint.entity.Client;

public class ClientReq {
    private String rut;
    private String name;
    private String email;
    private Double amount1;
    private Double amount2;

    public Client toClient() {
        Random rd = new Random();
        return new Client(rut, name, email, amount1, amount2, rd.nextBoolean());
    }

    public Double getAmount1() {
        return amount1;
    }

    public Double getAmount2() {
        return amount2;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getRut() {
        return rut;
    }

    public void setAmount1(Double amount1) {
        this.amount1 = amount1;
    }

    public void setAmount2(Double amount2) {
        this.amount2 = amount2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
