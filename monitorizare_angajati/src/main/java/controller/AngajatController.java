package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.AuthUserDTO;
import service.Service;

public class AngajatController {
    private Service service;

    private AuthUserDTO angajat;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public AuthUserDTO getAngajat() {
        return angajat;
    }

    public void setAngajat(AuthUserDTO angajat) {
        this.angajat = angajat;
    }

    @FXML
    private Button bttnPrezent;
}
