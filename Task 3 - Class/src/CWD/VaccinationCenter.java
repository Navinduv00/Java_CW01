package CWD;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VaccinationCenter {
    Booth [] boothRef = new Booth[6];
    Patient [] patientRef = new Patient[6];;
    Booth myVBooth = new Booth();
    Patient myPatient = new Patient();

    Scanner x = new Scanner(System.in);

    public void Vaccineprogram() {
        for (int x = 0; x < boothRef.length; x++) {
            boothRef[x] = new Booth();
            patientRef[x] = new Patient();
        }
        initialise(boothRef);
        while (true) {

            System.out.println();
            System.out.println("Enter Following Numbers/KeyWords To View Details!");
            System.out.println();

            System.out.println(
                            "100 or VVB: View all Vaccination Booths" + "\n" +
                            "101 or VEB: View all Empty Booths" + "\n" +
                            "102 or APB: Add Patient to a Booth" + "\n" +
                            "103 or RPB: Remove Patient from a Booth" + "\n" +
                            "104 or VPS: View Patients Sorted in alphabetical order" + "\n" +
                            "105 or SPD: Store Program Data into file" + "\n" +
                            "106 or LPD: Load Program Data from file" + "\n" +
                            "107 or VRV: View Remaining Vaccinations" + "\n" +
                            "108 or AVS: Add Vaccinations to the Stock" + "\n" +
                            "999 or EXT: Exit the Program"

            );
            System.out.println();
            System.out.print("Please Enter Respective Number: ");
            String number = x.nextLine().toLowerCase().trim();
            System.out.println();
            switch (number) {
                case "100":
                case "vvb":
                    viewVBooth(boothRef,patientRef);
                    break;
                case "101":
                case "veb":
                    emptyVBooth(boothRef);
                    break;
                case "102":
                case "apb":
                    AddBooth(boothRef,patientRef);
                    break;
                case "103":
                case "rpb":
                    removeFromBooth(boothRef,patientRef);
                    break;
                case "104":
                case "vps":
                    sortBooth(boothRef,patientRef);
                    break;
                case "105":
                case "spd":
                    storeData(boothRef,patientRef);
                    break;
                case "106":
                case "lpd":
                    ReadData();
                    break;
                case "107":
                case "vrv":
                    System.out.println("Remaining Vaccine Count: " + myVBooth.getCount());
                    break;
                case "108":
                case "avs":
                    addVaccine();
                    break;
                case "999":
                case "ext":
                    System.out.println("Program End!");
                    break;
                default:
                    System.out.println("Invalid Input Please Follow Given Instructions");
                    break;
            }

        }
    }
    //METHOD INITIALISE
    private static void initialise(Booth[] boothRef) {
        for (int x = 0; x < boothRef.length; x++) {//parameter to check if we have exceeded the booth count(used in all the methods)
            boothRef[x].setName("Booth Empty");
        }
    }
    //METHOD View Booth
    private void viewVBooth(Booth [] boothRef,Patient[] patientRef) {
        for (int x = 0; x < boothRef.length; x++) {
            if (boothRef[x].getName().equals("Booth Empty")) {
                System.out.println("Booth " + x + " is Empty");
            } else {
                System.out.println("Booth " + x + " Already Occupied By " + boothRef[x].getName());
                System.out.println("First Name : " + patientRef[x].getFirstName());
                System.out.println("SurName : " + patientRef[x].getSurName());
                System.out.println("Age : " + patientRef[x].getAge());
                System.out.println("City : " + patientRef[x].getCity());
                System.out.println("Passport No/ID : " + patientRef[x].getPassport());
                System.out.println("Vaccine : " + patientRef[x].getVaccine());
                System.out.println();
            }
        }
    }
    //METHOD to show the available booths
    private void emptyVBooth(Booth[] boothRef) {
        int count = 0;
        for (int x = 0; x < boothRef.length; x++) {
            if (boothRef[x].getName().equals("Booth Empty")) {
                System.out.println("Booth " + x + " is Empty");
                count = count + 1;
            }
        }
        if (count == 0){
            System.out.println("No Empty Booths Available");
        }
    }
    //METHOD to add patients and assign a booth
    public void AddBooth(Booth [] boothRef,Patient[] patientRef){
        boolean adding = true;
        int count = 0;
        int count2 = 0;
        Scanner input = new Scanner(System.in);
        while (adding){
            for (int x = 0; x < boothRef.length; ++x){
                if (!boothRef[x].getName().equals("Booth Empty")){
                    count2 = count2 + 1;
                }
            }
            if (count2 == 6){
                System.out.println("All Booths Are Filled!");
                adding = false;
            }
            else {
                System.out.print("Please Request Your Vaccine AstraZeneca(0)/SinoPharm(1)/Pfizer(2): ");
                int order = input.nextInt();
                if (order >= 0 && order <= 2){
                    for (int i = 0; i < boothRef.length; ++i){
                        if (patientRef[i].getVaccine().equals(myPatient.setRequest(order))){
                            count = count + 1;
                        }
                    }
                    if (count == 2){
                        System.out.println("No Empty Booths Available for the Requested Vaccine!");
                        adding = false;
                    }
                    else {
                        Scanner y = new Scanner(System.in);
                        System.out.print("First Name: ");
                        String fname = input.next().trim();
                        System.out.print("SurName: ");
                        String lname = input.next();
                        System.out.print("Age: ");
                        int age = input.nextInt();
                        System.out.print("City: ");
                        String city = input.next();
                        System.out.print("Passport/ID: ");
                        int passID = input.nextInt();
                        if (order == 0){// if they put 0 AstraZeneca
                            System.out.println("Booth No 0/1 to add or (6) to exit: ");
                            int boothNum = input.nextInt();
                            if (boothNum == 0 || boothNum == 1 || boothNum == 6){
                                if (boothNum == 6){
                                    System.out.println("Exited");
                                    adding = false;
                                }
                                else if (!boothRef[boothNum].getName().equals("Booth Empty")){
                                    System.out.println("Booth Already Occupied By Someone!");
                                    count = 0;
                                    count2 = 0;
                                }
                                else {
                                    System.out.println("Booth No " + boothNum + " Occupied By " + fname);
                                    System.out.println("Vaccine: "+ myPatient.setRequest(order));
                                    boothRef[boothNum].setName(fname);
                                    patientRef[boothNum].setFirstName(fname);
                                    patientRef[boothNum].setSurName(lname);
                                    patientRef[boothNum].setAge(age);
                                    patientRef[boothNum].setCity(city);
                                    patientRef[boothNum].setPassport(passID);
                                    patientRef[boothNum].setVaccine(myPatient.setRequest(order));
                                    myVBooth.adding(-1);
                                    adding = false;
                                }
                            }
                            else {
                                System.out.println("Invalid Booth Number");
                                count = 0;
                                count2 = 0;
                            }
                        }
                        else if (order == 1){// if they put 1 SinoPharm
                            System.out.println("Booth No 2/3 to add or (6) to exit: ");
                            int boothNum = input.nextInt();
                            if (boothNum == 2 || boothNum == 3 || boothNum == 6){
                                if (boothNum == 6){
                                    System.out.println("Exited");
                                    adding = false;
                                }
                                else if (!boothRef[boothNum].getName().equals("Booth Empty")){
                                    System.out.println("Booth Already Occupied By Someone!");
                                    count = 0;
                                    count2 = 0;
                                }
                                else {
                                    System.out.println("Booth No " + boothNum + " Occupied By " + fname);
                                    System.out.println("Vaccine: "+ myPatient.setRequest(order));
                                    boothRef[boothNum].setName(fname);
                                    patientRef[boothNum].setFirstName(fname);
                                    patientRef[boothNum].setSurName(lname);
                                    patientRef[boothNum].setAge(age);
                                    patientRef[boothNum].setCity(city);
                                    patientRef[boothNum].setPassport(passID);
                                    patientRef[boothNum].setVaccine(myPatient.setRequest(order));
                                    myVBooth.adding(-1);
                                    adding = false;
                                }
                            }
                            else {
                                System.out.println("Invalid Booth Number");
                                count = 0;
                                count2 = 0;
                            }
                        }
                        else if (order == 2){// if they put 2 Pfizer
                            System.out.println("Booth No 4/5 to add or (6) to exit: ");
                            int boothNum = input.nextInt();
                            if (boothNum == 4 || boothNum == 5 || boothNum == 6){
                                if (boothNum == 6){
                                    System.out.println("Exited");
                                    adding = false;
                                }
                                else if (!boothRef[boothNum].getName().equals("Booth Empty")){
                                    System.out.println("Booth Already Occupied By Someone!");
                                    count = 0;
                                    count2 = 0;
                                }
                                else {
                                    System.out.println("Booth No " + boothNum + " Occupied By " + fname);
                                    System.out.println("Vaccine: "+ myPatient.setRequest(order));
                                    boothRef[boothNum].setName(fname);
                                    patientRef[boothNum].setFirstName(fname);
                                    patientRef[boothNum].setSurName(lname);
                                    patientRef[boothNum].setAge(age);
                                    patientRef[boothNum].setCity(city);
                                    patientRef[boothNum].setPassport(passID);
                                    patientRef[boothNum].setVaccine(myPatient.setRequest(order));
                                    myVBooth.adding(-1);
                                    adding = false;
                                }
                            }
                            else {
                                System.out.println("Invalid Booth Number");
                                count = 0;
                                count2 = 0;
                            }
                        }
                    }
                }
                else {
                    System.out.println("Invalid Request!");
                    count = 0;
                    count2 = 0;
                }
            }
        }
    }
    //METHOD to remove Patient from a booth
    public static void removeFromBooth(Booth [] boothRef,Patient[] patientRef){
        int count = 0;
        boolean removing = true;
        Scanner rmv = new Scanner(System.in);
        while (removing){
            for (int x = 0; x < boothRef.length; ++x){
                if (boothRef[x].getName().equals("Booth Empty")){
                    count = count + 1;
                }
            }
            if (count == 6){
                System.out.println("All Booths Are Empty No Patients To Remove");
                removing = false;
            }
            else {
                System.out.print("Please Enter Booth Number (0-5) to Remove or (6) to exit: ");
                int remove = rmv.nextInt();
                if (remove >= 0 && remove <= 6){
                    if (remove == 6){
                        System.out.println("Exited");
                        removing = false;
                    }
                    else {
                        if (boothRef[remove].getName().equals("Booth Empty")){
                            System.out.println("Booth Already Empty ");
                            count = 0;
                        }
                        else {
                            System.out.println("Patient " + boothRef[remove].getName() + " Removed From Booth " + remove );
                            System.out.println("Vaccine Used: " + patientRef[remove].getVaccine());
                            boothRef[remove].setName("Booth Empty");
                            patientRef[remove].setFirstName("");
                            patientRef[remove].setSurName("");
                            patientRef[remove].setAge(0);
                            patientRef[remove].setCity("");
                            patientRef[remove].setPassport(0);
                            patientRef[remove].setVaccine("");
                            removing = false;
                        }
                    }
                }
                else {
                    System.out.println("Invalid Booth Number");
                    count = 0;
                }
            }
        }
    }
    //METHOD to sort pateints in alphebetical Order
    private static void sortBooth(Booth [] boothRef, Patient[] patientRef){
        String [] sorting = new String[boothRef.length];
        for (int i = 0; i < boothRef.length; i++) {
            sorting[i] = patientRef[i].getFirstName() + " " + patientRef[i].getSurName();
        }
        for(int i = 0; i < sorting.length; i++){
            for (int j = i + 1;j < sorting.length; j++){
                if (sorting[i].compareTo(sorting[j]) > 0 ){
                    String temp = sorting[i];
                    sorting[i] = sorting[j];
                    sorting[j] = temp;
                }
            }
        }
        for (int i = 0; i < sorting.length; i++){
            if(!sorting[i].equals("Booth Empty") && !sorting[i].equals(" ")) {
                System.out.println(sorting[i] );
            }
        }
    }
    //METHOD to store data in a Text file called Task3-Class in the project folder
    private static void storeData(Booth [] boothRef,Patient[] patientRef){
        try{
            FileWriter myFile = new FileWriter("Task3-Class.txt") ;
            for(int x =0 ; x < boothRef.length; x++){
                myFile.write(" -------------------------- Booth Details --------------------------" + "\n");
                myFile.write("Name : " + boothRef[x].getName() + "\n");
                myFile.write("Booth Number: " + x + "\n");
                myFile.write("      First Name : " + patientRef[x].getFirstName() + "\n" + "      SurName : " + patientRef[x].getSurName()+ "\n" + "      Vaccine : " + patientRef[x].getVaccine() + "\n");
                myFile.write("      Age : " + patientRef[x].getAge() + "\n" + "      City : " + patientRef[x].getCity()+ "\n" + "      Passport/ID : " + patientRef[x].getPassport() + "\n");
                myFile.write("________________________________________________________________________________________" + "\n");
                myFile.write("\n\n ");
            }
            myFile.close();
            System.out.println("Data Successfully Stored");
        }catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
    //METHOD to view data inside the java program that are taken from the Task3-Class.txt file
    private static void ReadData(){
        try{
            File myFile = new File("Task3-Class.txt");
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()){
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        }catch (FileNotFoundException e){
            System.out.println("An Error Occurred.");
            e.printStackTrace();
        }
    }
    //METHOD to add vaccines to the main stock(150 starting stock)
    public void addVaccine(){
        boolean adding = true;
        Scanner adder = new Scanner(System.in);
        while (adding){
            System.out.println("Enter Adding Vaccine Count or 0 to exit: ");
            int add = adder.nextInt();
            if (add == 0){
                System.out.println("Exited");
                adding = false;
            }
            else if (add > 0){
                myVBooth.adding(add);
                System.out.println("Vaccines Added: " + add);
                System.out.println("Total Count: " + myVBooth.getCount());
                adding = false;
            }
            else {
                System.out.println("Invalid Entry!");
            }
        }
    }
}
