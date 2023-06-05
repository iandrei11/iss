package controller;

import javafx.fxml.FXML;
import model.AuthUserDTO;
import model.User;
import model.UserType;
import service.Service;

public class SefController {

    private Service service;
    private AuthUserDTO sef;



    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public AuthUserDTO getSef() {
        return sef;
    }

    public void setSef(AuthUserDTO sef) {
        this.sef = sef;
    }
}
