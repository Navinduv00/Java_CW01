package application;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class VaccineWindowController {

    @FXML
    TextField fname;
    @FXML
    TextField sname;
    @FXML
    private TextField city;

    @FXML
    private TextField age;

    @FXML
    private TextField nc;

    @FXML
    private TextField Boothno;

    @FXML
    private RadioButton btAZ;

    @FXML
    private ToggleGroup tgV;

    @FXML
    private RadioButton btS;

    @FXML
    private RadioButton bt;

    @FXML
    private Label LbV;





    private Stage stage;
    private Scene scene;
    private Parent root;




    public void Genertaereceipt(ActionEvent event) throws IOException {//method when Generate Recipt is clicked


        if (fname.getText().length() == 0) {//validation every fiwld to see if the field was left empty
            fname.setStyle("-fx-border-color: red;-fx-border-width:4px;");//if the field is empty the textfield will get red and border will set to 3px

        } else {
            fname.setStyle(null);

        if (sname.getText().length() == 0) {
            sname.setStyle("-fx-border-color: red;-fx-border-width:4px;");
        } else {
            sname.setStyle(null);
        if (age.getText().length() == 0) {
            age.setStyle("-fx-border-color: red;-fx-border-width:4px;");
        } else {
            age.setStyle(null);
        if (city.getText().length() == 0) {
            city.setStyle("-fx-border-color: red;-fx-border-width:4px;");
        } else {
            city.setStyle(null);
        if (nc.getText().length() == 0) {
            nc.setStyle("-fx-border-color: red;-fx-border-width:4px;");
       } else {
            nc.setStyle(null);
       if (Boothno.getText().length() == 0) {
           Boothno.setStyle("-fx-border-color: red;-fx-border-width:4px;");
       } else {
           Boothno.setStyle(null);

                String username = fname.getText();
                String Surname = sname.getText();
                //int a = Integer.parseInt(age.getText());
                // LbV2.setText(Integer.toString(a));
                String Age = age.getText();
                String City = city.getText();
                String NIC = nc.getText();
                String booth = Boothno.getText();


                String message = "";

                if (btAZ.isSelected()) {
                    message += btAZ.getText() + "\n";
                }
                if (btS.isSelected()) {
                    message += btS.getText() + "\n";
                }
                if (bt.isSelected()) {
                    message += bt.getText() + "\n";
                }
                LbV.setText(message);


                FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
                root = loader.load();

                ReciptController ReciptController = loader.getController();
                ReciptController.displayName(username);
                ReciptController.displaysname(Surname);
                ReciptController.displaysage(Age);
                ReciptController.displayCity(City);
                ReciptController.displayNIC(NIC);
                ReciptController.displaybooth(booth);
                ReciptController.displayvaccine(message);
                ReciptController.Clock();

                //root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
        }
        }
        }
        }
        }
    }
}