package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.AuthUserDTO;
import model.UserType;
import service.Service;

import java.io.IOException;
import java.util.Optional;

public class LoginController {
    @FXML
    private Button bLogIn;
    @FXML
    private TextField tbUsername;
    @FXML
    private PasswordField pfPassword;

    @FXML
    private Label lbLoginMessage;
    private Service service;

    public void setService(Service service){
        this.service = service;
    }

    @FXML
    private void onbLogInClick(ActionEvent actionEvent) throws IOException {
//        bLogIn.setText("Yep");


         Optional<AuthUserDTO> auth = service.authenticate(tbUsername.getText(), pfPassword.getText());

        Optional<UserType> userTypeOpt = auth.map(AuthUserDTO::getUserType);
//        userTypeOpt = Optional.of(UserType.Angajat);



        if(userTypeOpt.isEmpty()){
            lbLoginMessage.setText("Invalid credentials!");
        } else{
             UserType userType = userTypeOpt.get();
             AuthUserDTO userDTO = auth.get();
        if (userType == UserType.Sef){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/monitorizare_angajati/gui_sef.fxml"));
            Parent root = loader.load();
            SefController sefController = loader.getController();
            sefController.setService(this.service);
            sefController.setSef(userDTO);

            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle("Bine ai venit, "+userDTO.getFullname()+"!" );
            stage.show();
//            closeWindow();
        } else if(userType == UserType.Angajat){
//            Programmer loggedInProgrammer = loginResponse.getProg();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/monitorizare_angajati/gui_angajat.fxml"));
            Parent root = loader.load();
            AngajatController angajatController = loader.getController();
            angajatController.setService(this.service);
            angajatController.setAngajat(userDTO);


            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle("Bine ai venit, "+userDTO.getFullname()+"!" );
            stage.show();
//            closeWindow();
        }
    }


    }

    private void closeWindow(){
        Stage thisStage = (Stage) bLogIn.getScene().getWindow();
        thisStage.close();
    }
}