package com.crudsprint.cl.crudsprint.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.crudsprint.cl.crudsprint.controller.res.ClientReq;
import com.crudsprint.cl.crudsprint.controller.res.ClientResp;
import com.crudsprint.cl.crudsprint.controller.res.ClientRespList;
import com.crudsprint.cl.crudsprint.entity.Client;
import com.crudsprint.cl.crudsprint.service.ClientService;
import com.crudsprint.cl.crudsprint.util.Utils;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;
    Logger logger = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/client")
    @ResponseBody
    public ClientRespList listClient() {
        try {
            List<Client> response = clientService.findAll();
            return new ClientRespList("ok", 200, response);
        } catch (Exception e) {
            logger.error("get /client:error:" + e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "error server");
        }
    }

    @GetMapping("/client/{rut}")
    @ResponseBody
    public ClientResp findClient(@PathVariable String rut) {
        try {
            Client response = clientService.find(rut);
            if (response != null) {
                return new ClientResp("ok", 200, response);
            }
            return new ClientResp("invalid content", 404, null);
        } catch (Exception e) {
            logger.error("get /client/{rut}:error:" + e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "error server");
        }
    }

    @PostMapping("/client")
    @ResponseBody
    public ClientResp insertClient(@RequestBody ClientReq req) {
        try {
            if (!validateBody(req)) {
                return new ClientResp("invalid content", 404, null);
            }
            Client response = clientService.insertClient(req.toClient());
            return new ClientResp("ok", 200, response);
        } catch (Exception e) {
            logger.error("post /client:error:" + e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "error server");
        }
    }

    private boolean validateBody(ClientReq req) {
        if (req.getName().isEmpty()) {
            return false;
        }
        if (!Utils.emailValidator(req.getEmail())) {
            return false;
        }
        if (!Utils.validaRut(req.getRut())) {
            return false;
        }
        if (req.getAmount1() <= 0) {
            return false;
        }
        if (req.getAmount2() <= 0) {
            return false;
        }
        return true;
    }

}