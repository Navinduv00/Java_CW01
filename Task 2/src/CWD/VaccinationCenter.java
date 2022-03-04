package CWD;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VaccinationCenter {
    Booth[] Vpatients = new Booth[6];
    Booth myVBooth = new Booth();

    Scanner x = new Scanner(System.in);

    public void Vaccineprogram() {
        for (int x = 0; x < Vpatients.length; x++) {
            Vpatients[x] = new Booth();
        }
        initialise(Vpatients);
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
                    viewVBooth(Vpatients);
                    break;
                case "101":
                case "veb":
                    emptyVBooth(Vpatients);
                    break;
                case "102":
                case "apb":
                    AddBooth(Vpatients);
                    break;
                case "103":
                case "rpb":
                    removeFromBooth(Vpatients);
                    break;
                case "104":
                case "vps":
                    sortBooth(Vpatients);
                    break;
                case "105":
                case "spd":
                    storeData(Vpatients);
                    break;
                case "106":
                case "lpd":
                    ReadData(Vpatients);
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
    private static void initialise(Booth[] patientRef) {
        for (int x = 0; x < patientRef.length; x++) { //parameter to check if we have exceeded the booth count(used in all the methods)
            patientRef[x].setName("Booth Empty");

        }
    }
    //METHOD View Booth
    public static void viewVBooth(Booth[] patientRef) {
        for (int x = 0; x < patientRef.length; ++x) {
            if (patientRef[x].getName().equals("Booth Empty")) {
                System.out.println("Booth " + x + " is empty");
            } else {
                System.out.println("Booth " + x + " Already Occupied By " + patientRef[x].getName());
            }
        }
    }
    //METHOD to show the available booths
    public static void emptyVBooth(Booth[] patientsRef) {
        int count = 0;
        for (int x = 0; x < patientsRef.length; ++x) {
            if (patientsRef[x].getName().equals("Booth Empty")) {
                System.out.println("Booth " + x + " is empty");
                count = count + 1;
            }
        }
        if (count == 0) {
            System.out.println("No Empty Booths Available!");
        }
    }
    //METHOD to add patients and assign a booth
    public void AddBooth(Booth[] patientRef) {
        boolean adding = true;
        int count = 0;
        while (adding) {
            for (int x = 0; x < patientRef.length; ++x) {
                if (!patientRef[x].getName().equals("Booth Empty")) {
                    count = count + 1;
                }
            }
            if (count == 6) {
                System.out.println("All Booths Are Filled");
                adding = false;
            } else {
                Scanner y = new Scanner(System.in);
                System.out.print("Please Enter Your Name: ");
                String name = y.nextLine().trim();
                if (name.length() > 0) {//if the field is empty "Enter your name" will be repeated
                    System.out.print("Please Enter Booth Number(0-5) or (6) to exit: ");
                    int num = y.nextInt();
                    if (num == 6) {
                        adding = false;
                    } else {
                        System.out.print("Please Enter Your Name:");

                    }
                    if (num <= 5 && num >= 0) {
                        if (!patientRef[num].getName().equals("Booth Empty")) {
                            System.out.println("Booth Already Occupied");
                            count = 0;
                        } else {
                            patientRef[num].setName(name);
                            System.out.println(name + " Added to Booth Number " + num);
                            myVBooth.adding(-1);
                            adding = false;
                        }
                    } else {
                        if (num != 6) {
                            System.out.println("Invalid Booth Number");
                            count = 0;
                        }
                    }

                }
            }
        }
    }
    //METHOD to remove Patient from a booth
    public static void removeFromBooth(Booth[] patientRef) {
        boolean removing = true;
        int count = 0;
        while (removing) {
            for (int x = 0; x < patientRef.length; ++x) {
                if (patientRef[x].getName().equals("Booth Empty")) {
                    count = count + 1;
                }
            }
            if (count == 6) {
                System.out.println("All Booths Are Empty No Patients to Remove");
                removing = false;
            } else {
                Scanner y = new Scanner(System.in);
                System.out.println("Please Enter Booth Number(0-5) or (6) to exit: ");
                int num = y.nextInt();
                if (num == 6) {
                    removing = false;
                }
                if (num <= 5 && num >= 0) {
                    if (patientRef[num].getName().equals("Booth Empty")) {
                        System.out.println("Booth Already Empty");
                        count = 0;
                    } else {
                        System.out.println(patientRef[num].getName() + " Removed from Booth Number " + num);
                        patientRef[num].setName("Booth Empty");
                        removing = false;
                    }
                } else {
                    if (num != 6) {
                        System.out.println("Invalid Booth Number");
                        count = 0;
                    }
                }
            }
        }
    }
    //METHOD to sort pateints in alphebetical Order
    public static void sortBooth(Booth[] patientRef) {
        String[] sorting = new String[patientRef.length];
        for (int r = 0; r < patientRef.length; ++r) {
            sorting[r] = patientRef[r].getName();
        }
        int j = 0;
        String temp;
        for (int i = 0; i < sorting.length; i++) {
            for (j = i + 1; j < sorting.length; ++j) {
                if (sorting[i].compareTo(sorting[j]) > 0) {
                    temp = sorting[i];
                    sorting[i] = sorting[j];
                    sorting[j] = temp;
                }
            }
        }
        int count = 0;
        for (int k = 0; k < sorting.length; k++) {
            if (!sorting[k].equals("Booth Empty")) {
                System.out.println(sorting[k]);
                count = count + 1;
            }
        }
        if (count == 0) {
            System.out.println("All Booths Are Empty");
        }
    }
    //METHOD to store data in a Text file called Task2 in the project folder
    private void storeData(Booth[] patientRef) {
        try {
            FileWriter myFile = new FileWriter("Task2.txt");
            for (int x = 0; x < patientRef.length; x++) {
                myFile.write("Name : " + patientRef[x].getName() + "\n");
                myFile.write("Booth Number: " + (x) + "\n");
                myFile.write("________________________________________________________________________________________" + "\n");
                myFile.write("\n\n ");
            }
            myFile.write("Remaining Vaccine Count: " + Integer.toString(myVBooth.getCount()));
            myFile.close();
            System.out.println("Data Successfully Stored");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
    //METHOD to view data inside the java program that are taken from the Task2.txt file
    private static void ReadData(Booth[] patientRef) {
        try {
            File myFile = new File("Task2.txt");
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An Error occurred.");
            e.printStackTrace();
        }
    }
    //METHOD to add vaccines to the main stock(150 starting stock)
    public void addVaccine() {
        Scanner adder = new Scanner(System.in);
        System.out.print("Adding to the Vaccine count: ");
        int addCount = adder.nextInt();
        myVBooth.adding(addCount);
    }


}



