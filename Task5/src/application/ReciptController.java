package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.omg.DynamicAny.DynArray;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ReciptController {

    @FXML
    private Label fname;

    @FXML
    private Label age;

    @FXML
    private Label sname;

    @FXML
    private Label Location;
    @FXML
    private Label nic;

    @FXML
    private Label vaccine;
    @FXML
    private Label Time;

    @FXML
    private Label date;

    @FXML
    private Label Boothno;




    public void displayName(String username) {//methods to get all the data from Vaccine window to print in receipt
        fname.setText("Firstname: " + username);
    }
    public void displaysname(String Surname) {
        sname.setText("Surname: " + Surname);
    }
    public void displayvaccine(String message) {
        vaccine.setText("Vaccine: " + message);
    }
    public void displayCity(String city) {
        Location.setText("City: " + city);
    }
    public void displayNIC(String NIC) {
        nic.setText("NIC No: " + NIC);
    }
    public void displaysage(String AGE) {
        age.setText("Age: " + AGE);
    }
    public void displaybooth(String Booth) {
        Boothno.setText("Booth no: "+ Booth);
    }
    public void Clock(){
        Calendar cal =new GregorianCalendar();
        int day =cal.get(Calendar.DAY_OF_MONTH);
        int Month =cal.get(Calendar.MONTH);
        int year =cal.get(Calendar.YEAR);

        int sec =cal.get(Calendar.SECOND);
        int Min =cal.get(Calendar.MINUTE);
        int hour =cal.get(Calendar.HOUR);
        Time.setText("Time  "+ hour+":"+Min+":"+ sec);
        date.setText("Date "+day+":"+Month+":"+year);



    }

}