package com.monitorizare_angajati;

import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repo.BD.UserRepoBD;
import service.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        Properties props=new Properties();
        try {
            props.load(new FileReader("bd.config"));
        } catch (IOException e) {
            System.out.println("Cannot find bd.config "+e);
        }


        Service service = new Service(new UserRepoBD());

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gui_login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 500);
        LoginController loginController = fxmlLoader.getController();
        loginController.setService(service);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}