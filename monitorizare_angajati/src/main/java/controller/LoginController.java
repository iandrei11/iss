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

    private Service service;

    public void setService(Service service){
        this.service = service;
    }

    @FXML
    private void onbLogInClick(ActionEvent actionEvent) throws IOException {
        bLogIn.setText("Yep");


         Optional<AuthUserDTO> auth = service.authenticate(tbUsername.getText(), pfPassword.getText());
//        System.out.println(userType.getLoginType());

        Optional<UserType> userTypeOpt = auth.map(AuthUserDTO::getUserType);
//        userTypeOpt = Optional.of(UserType.Angajat);



        if(userTypeOpt.isEmpty()){
            bLogIn.setText("Invalid credentials!");
        } else{
             UserType userType = userTypeOpt.get();
             AuthUserDTO userDTO = auth.get();
        if (userType == UserType.Sef){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/monitorizare_angajati/gui_sef.fxml"));
            Parent root = loader.load();
            SefController sefController = loader.getController();
//            sefController.setLoggedInQA(loggedInQA);
//              sefController.setWelcomeLabelQA();
//            sefController.setService(service);

            sefController.setService(this.service);
            sefController.setSef(userDTO);

            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle(userDTO.getFullname());
            stage.show();
            closeWindow();
        } else if(userType == UserType.Angajat){
//            Programmer loggedInProgrammer = loginResponse.getProg();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/monitorizare_angajati/gui_angajat.fxml"));
            Parent root = loader.load();
            AngajatController angajatController = loader.getController();
//            programmerController.setLoggedInProgrammer(loggedInProgrammer);
//            programmerController.setWelcomeLabelProgrammer(loggedInProgrammer);
//            programmerController.setService(service);


            angajatController.setService(this.service);
            angajatController.setAngajat(userDTO);


            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle(userDTO.getFullname());
            stage.show();
            closeWindow();
        }
    }

//        Optional<UserType> userType = service.autenthicate(tbUsername.getText(), pfPassword.getText());
//        System.out.println(loginResponse.getLoginType());
//        if(loginResponse. == LoginType.ERROR){
//            errorLabel.setText("Invalid credentials!");
//        } else if(loginResponse.getLoginType() == LoginType.QA){
//            QA loggedInQA = loginResponse.getQa();
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/views/qa-view.fxml"));
//            Parent root = loader.load();
//            QAController qaController = loader.getController();
//            qaController.setLoggedInQA(loggedInQA);
//            qaController.setWelcomeLabelQA();
//            qaController.setService(service);
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root, 600, 400));
//            stage.setTitle("Hello!");
//            stage.show();
//            closeWindow();
//        } else if(loginResponse.getLoginType() == LoginType.PROGRAMMER){
//            Programmer loggedInProgrammer = loginResponse.getProg();
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/views/experiment.fxml"));
//            Parent root = loader.load();
//            ProgrammerController programmerController = loader.getController();
//            programmerController.setLoggedInProgrammer(loggedInProgrammer);
//            programmerController.setWelcomeLabelProgrammer(loggedInProgrammer);
//            programmerController.setService(service);
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root, 600, 400));
//            stage.setTitle("Hello!");
//            stage.show();
//            closeWindow();
//        }

    }

    private void closeWindow(){
        Stage thisStage = (Stage) bLogIn.getScene().getWindow();
        thisStage.close();
    }
}