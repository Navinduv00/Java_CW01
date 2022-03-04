package CWD;

public class Patient {
    private String FirstName;
    private String SurName;
    private int Age;
    private String City;
    private int Passport;
    private String Vaccine;
    private String Astra = "AstraZeneca";
    private String Sino = "Sinopharm";
    private String Pfizer = "Pfizer";

    public Patient (){
        FirstName = "";
        SurName = "";
        Age = 0;
        City = "";
        Passport = 0;
        Vaccine = "";
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public void setSurName(String surName) {
        SurName = surName;
    }
    public void setAge(int age) {
        Age = age;
    }
    public void setCity(String city) {
        City = city;
    }
    public void setPassport(int passport){Passport = passport;}
    public void setVaccine(String vaccine) {
        Vaccine = vaccine;
    }
    public String getFirstName() {
        return FirstName;
    }
    public String getSurName() {
        return SurName;
    }
    public int getAge() {
        return Age;
    }
    public String getCity() {
        return City;
    }
    public int getPassport(){return Passport;}
    public String getVaccine() {
        return Vaccine;
    }
    public String setRequest(int req){
        if (req == 0){
            return Astra;
        }
        else if (req == 1){
            return Sino;
        }
        else {
            return Pfizer;
        }
    }


}
