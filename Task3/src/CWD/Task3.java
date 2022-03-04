package CWD;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


import java.util.Scanner;
public class Task3 {

    private static int vaccineCount = 150;
    public static void main(String[] args) {

        String [] booth = new String[6];
        String [] firstName = new String[6];
        String [] surName = new String[6];
        String [] vaccine = new String[6];
        String [] request = {"AstraZeneca","Sinopharm","Pfizer"};

        for (int i = 0; i < booth.length; ++i){
            booth[i] = "-";
            firstName[i] = "-";
            surName[i] = "-";
            vaccine[i] = "-";
        }
        initialise(booth);

        label:
        while (true){

            Scanner x = new Scanner(System.in);
            System.out.println();
            System.out.println("Enter Following Numbers/KeyWords To View Details!");
            System.out.println();

            System.out.println(
                    "100 or VVB: View all Vaccination Booths"+"\n"+
                    "101 or VEB: View all Empty Booths"+"\n"+
                    "102 or APB: Add Patient to a Booth"+"\n"+
                    "103 or RPB: Remove Patient from a Booth"+"\n"+
                    "104 or VPS: View Patients Sorted in alphabetical order"+"\n"+
                    "105 or SPD: Store Program Data into file"+"\n"+
                    "106 or LPD: Load Program Data from file"+"\n"+
                    "107 or VRV: View Remaining Vaccinations"+"\n"+
                    "108 or AVS: Add Vaccinations to the Stock"+"\n"+
                    "999 or EXT: Exit the Program"

            );
            System.out.println();
            System.out.print("Please Enter Respective Number: ");
            String number = x.nextLine().toLowerCase();

            switch (number) {
                case "100":
                case "vvb":
                    viewVBooth(booth,firstName,surName,vaccine);
                    break;
                case "101":
                case "veb":
                    emptyVBooth(booth);
                    break;
                case "102":
                case "apb":
                    AddBooth(booth,firstName,surName,vaccine,request);
                    break;
                case "103":
                case "rpb":
                    removeFromBooth(booth,firstName,surName,vaccine);
                    break;
                case "104":
                case "vps":
                    sortBooth(booth,firstName,surName);
                    break;
                case "105":
                case "spd":
                    storeData(booth,firstName,surName,vaccine);
                    break;
                case "106":
                case "lpd":
                    readData();
                    break;
                case "107":
                case "vrv":
                    System.out.println("Remaining Vaccine Count: " + vaccineCount);//Remaining vaccine count
                    break;
                case "108":
                case "avs":
                    Scanner r = new Scanner(System.in);
                    System.out.print("Adding Vaccine Count: ");
                    int add = r.nextInt();
                    vaccineCount = vaccineCount + add;
                    System.out.println(add + " Vaccines Added To Store");
                    System.out.println("Total Vaccine Count: " + vaccineCount);
                    break;
                case "999":
                case "ext":
                    System.out.println("Program End!");
                    break label;
                default:
                    System.out.println("Invalid Input Please Follow Given Instructions");
                    break;
            }
        }

    }
    //Initializing Method
    private static void initialise(String[] patientRef) {//parameter to check if we have exceeded the booth count(used in all the methods)
        for (int x = 0; x < patientRef.length; x++) {
            patientRef[x] = "Booth Empty";

        }
    }
    //METHOD to View Booth
    private static void viewVBooth(String [] patientRef, String[] firstName, String[] surName, String[] vaccine) {
        for (int x = 0; x < patientRef.length; x++) {
            if (patientRef[x].equals("Booth Empty")) {
                System.out.println("Booth " + x + " is Empty");
            } else {
                System.out.println();
                System.out.println("Booth " + x + " Already Occupied By " + patientRef[x]);
                System.out.println("Name : " + firstName[x]+" "+ surName[x] );
                System.out.println();
                System.out.println("Vaccine : " + vaccine[x]);
                System.out.println();
            }
        }
    }
    //METHOD to show the available booths
    private static void emptyVBooth(String[] patientRef) {
        int count = 0;
        for (int x = 0; x < patientRef.length; x++) {
            if (patientRef[x].equals("Booth Empty")) {
                System.out.println("Booth " + x + " is Empty");
                count = count + 1;
            }
        }
        if (count == 0){
            System.out.println("No Empty Booths Available");
        }
    }
    //METHOD to remove Patient from a booth
    public static void AddBooth(String [] patientRef, String[] firstName, String[] surName, String[] vaccine, String[] request){
        boolean adding = true;
        int count = 0;
        int count2 = 0;
        Scanner input = new Scanner(System.in);
        while (adding){
            for (int x = 0; x < patientRef.length; ++x){
                if (!patientRef[x].equals("Booth Empty")){
                    count2 = count2 + 1;
                }
            }
            if (count2 == 6){
                System.out.println("All Booths Are Filled!");
                adding = false;
            }
            else {
                System.out.print("Please Request Your Vaccine\nAstraZeneca(0)\nSinoPharm(1)\nPfizer(2):" );
                int order = input.nextInt();
                if (order >= 0 && order <= 2){
                    for (int i = 0; i < vaccine.length; ++i){
                        if (vaccine[i].equals(request[order])){
                            count = count + 1;
                        }
                    }
                    if (count == 2){
                        System.out.println("No Empty Booths Available for the Requested Vaccine!");
                        adding = false;
                    }
                    else {
                        System.out.println("First Name: ");
                        String fname = input.next().trim();
                        System.out.println("SurName: ");
                        String lname = input.next();
                        if (order == 0){
                            System.out.println("Booth No 0/1 to add or (6) to exit: ");
                            int boothNum = input.nextInt();
                            if (boothNum == 0 || boothNum == 1 || boothNum == 6){
                                if (boothNum == 6){
                                    System.out.println("Exited");
                                    adding = false;
                                }
                                else if (!patientRef[boothNum].equals("Booth Empty")){
                                    System.out.println("Booth Already Occupied By Someone!");
                                    count = 0;
                                    count2 = 0;
                                }
                                else {
                                    System.out.println("Booth No " + boothNum + " Occupied By " + fname);
                                    System.out.println("Vaccine: "+ request[order]);
                                    patientRef[boothNum] = fname;
                                    firstName[boothNum] = fname;
                                    surName[boothNum] = lname;
                                    vaccine[boothNum] = request[order];
                                    vaccineCount = vaccineCount - 1;
                                    adding = false;
                                }
                            }
                            else {
                                System.out.println("Invalid Booth Number");
                                count = 0;
                                count2 = 0;
                            }
                        }
                        else if (order == 1){
                            System.out.println("Booth No 2/3 to add or (6) to exit: ");
                            int boothNum = input.nextInt();
                            if (boothNum == 2 || boothNum == 3 || boothNum == 6){
                                if (boothNum == 6){
                                    System.out.println("Exited");
                                    adding = false;
                                }
                                else if (!patientRef[boothNum].equals("Booth Empty")){
                                    System.out.println("Booth Already Occupied By Someone!");
                                    count = 0;
                                    count2 = 0;
                                }
                                else {
                                    System.out.println("Booth No " + boothNum + " Occupied By " + fname);
                                    System.out.println("Vaccine: "+ request[order]);
                                    patientRef[boothNum] = fname;
                                    firstName[boothNum] = fname;
                                    surName[boothNum] = lname;
                                    vaccine[boothNum] = request[order];
                                    vaccineCount = vaccineCount - 1;
                                    adding = false;
                                }
                            }
                            else {
                                System.out.println("Invalid Booth Number");
                                count = 0;
                                count2 = 0;
                            }
                        }
                        else if (order == 2){
                            System.out.println("Booth No 4/5 to add or (6) to exit: ");
                            int boothNum = input.nextInt();
                            if (boothNum == 4 || boothNum == 5 || boothNum == 6){
                                if (boothNum == 6){
                                    System.out.println("Exited");
                                    adding = false;
                                }
                                else if (!patientRef[boothNum].equals("Booth Empty")){
                                    System.out.println("Booth Already Occupied By Someone!");
                                    count = 0;
                                    count2 = 0;
                                }
                                else {
                                    System.out.println("Booth No " + boothNum + " Occupied By " + fname);
                                    System.out.println("Vaccine: "+ request[order]);
                                    patientRef[boothNum] = fname;
                                    firstName[boothNum] = fname;
                                    surName[boothNum] = lname;
                                    vaccine[boothNum] = request[order];
                                    vaccineCount = vaccineCount - 1;
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
    public static void removeFromBooth(String [] patientRef, String[] firstName, String[] surName, String[] vaccine){
        int count = 0;
        boolean removing = true;
        Scanner rmv = new Scanner(System.in);
        while (removing){
            for (int x = 0; x < patientRef.length; ++x){
                if (patientRef[x].equals("Booth Empty")){
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
                        if (patientRef[remove].equals("Booth Empty")){
                            System.out.println("Booth Already Empty ");
                            count = 0;
                        }
                        else {
                            System.out.println("Patient " + patientRef[remove] + " Removed From Booth " + remove );
                            System.out.println("Vaccine Used: " + vaccine[remove]);
                            patientRef[remove] = "Booth Empty";
                            firstName[remove] = "-";
                            surName[remove] = "-";
                            vaccine[remove] = "-";
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
    private static void sortBooth(String [] patientRef, String[] firstName, String[] surName){
        String [] sorting = new String[patientRef.length];
        for (int i = 0; i < patientRef.length; i++) {
            sorting[i] = firstName[i] + " " + surName[i];
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
            if(!sorting[i].equals("Booth Empty") && !sorting[i].equals("- -")) {
                System.out.println(sorting[i] );
            }

        }

    }
    //METHOD to store data in a Text file called Task3 in the project folder
    private static void storeData(String [] patientRef,String[] firstName,String[] surName,String[] vaccine){
        try{
            FileWriter myFile = new FileWriter("Task3.txt");
            for(int x =0 ; x < patientRef.length; x++){
                myFile.write(" -------------------------- Booth Details --------------------------" + "\n");
                myFile.write("Name : " + patientRef[x] + "\n");
                myFile.write("Booth Number: " + x + "\n");
                myFile.write("      First Name : " + firstName[x] + "\n" + "      SurName : " + surName[x]+ "\n" + "      Vaccine : " + vaccine[x] + "\n");
                myFile.write("________________________________________________________________________________________" + "\n");
                myFile.write("\n\n ");
            }
            myFile.write("Remaining Vaccine Count: " + Integer.toString(vaccineCount));
            myFile.close();
            System.out.println("Data Successfully Stored");
        }catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
    //METHOD to view data inside the java program that are taken from the Task3.txt file
    private static void readData(){
        try{
            File myFile = new File("Task3.txt");
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
    public static void addVaccine(int addCount){
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
                addCount = addCount + add;
                System.out.println("Vaccines Added: " + add);
                System.out.println("Total Count: " + addCount);
                adding = false;
            }
            else {
                System.out.println("Invalid Entry!");
            }
        }
    }
}
