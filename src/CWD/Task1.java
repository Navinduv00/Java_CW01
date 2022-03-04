package CWD;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import java.util.Scanner;

public class Task1 {
    private static final String[] currentVBooth = new String[6];

    private static int Vaccinecount = 150;

    public static void main(String[] args) {

        viewVBooth(currentVBooth);


        label:
        while (true){

            if (Vaccinecount <= 20){
                System.out.println("Waring! Vaccine Count Reached The Limit of " + Vaccinecount);
            }

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
            System.out.print("Please Enter The Desired Number: ");
            String number = x.nextLine().toLowerCase();

            switch (number) {
                case "100":
                case "vvb":
                    viewVBooth(currentVBooth);
                    break;
                case "101":
                case "veb":
                    emptyVBooths(currentVBooth);
                    break;
                case "102":
                case "apb":
                    AddBooth(currentVBooth);
                    break;
                case "103":
                case "rpb":
                    removeFromBooth(currentVBooth);
                    break;
                case "104":
                case "vps":
                    sortBooth(currentVBooth);
                    break;
                case "105":
                case "spd":
                    storeData(currentVBooth);
                    break;
                case "106":
                case "lpd":
                    ReadData();
                    break;
                case "107":
                case "vrv":
                    System.out.println("Remaining Vaccine Count: " + Vaccinecount);
                    break;
                case "108":
                case "avs":
                    Scanner r = new Scanner(System.in);
                    System.out.print("Adding Vaccine Count: ");
                    int add = r.nextInt();
                    Vaccinecount = Vaccinecount + add;
                    System.out.println(add + " Vaccines Added To Store");
                    System.out.println("Total Vaccine Count: " + Vaccinecount);//adding vaccine to the vaccine stock(150)
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
    //METHOD INITIALISE
    public static void viewVBooth(String[] Vaccinebooth){
        for (int i = 0; i < Vaccinebooth.length; ++i){//parameter to check if we have exceeded the booth count(used in all the methods)
            if (Vaccinebooth[i] == null){
                Vaccinebooth[i] = "Booth Empty";
            }
            System.out.println(i + " - " + Vaccinebooth[i]);


        }
    }
    //METHOD to View Booth
    public static void emptyVBooths(String[] emptyBooth){
        for (int i = 0; i < emptyBooth.length; ++i){
            if (emptyBooth[i].equals("Booth Empty")){
                System.out.println(i + " - " + emptyBooth[i]);
            }
        }
        if (!emptyBooth[0].equals("Booth Empty") && !emptyBooth[1].equals("Booth Empty") && !emptyBooth[2].equals("Booth Empty") && !emptyBooth[3].equals("Booth Empty") &&
                !emptyBooth[4].equals("Booth Empty") && !emptyBooth[5].equals("Booth Empty")){
            System.out.println("No Empty Booths Available!");
        }

    }
    //METHOD to show the available booths
    public static void AddBooth(String[] addBooth){
        boolean innerLoop = true;
        while (innerLoop) {
            Scanner y = new Scanner(System.in);
            System.out.print("Enter Your Name: ");
            String name = y.nextLine().trim();
            if (name.length() > 0) {//if the field is empty "Enter your name" will be repeated
                System.out.print("Please Enter Booth Number(0-5) or (6) to exit: ");
                int num = y.nextInt();
                if (num == 6) {
                    innerLoop = false;
                } else {
                    System.out.print("Please Enter Your Name:");

                }
            System.out.print("Booth Number(0-5): ");
            int BoothNumber = y.nextInt();

                if (BoothNumber <= 5 && BoothNumber >= 0) {
                    if (addBooth[BoothNumber].equals("Booth Empty")) {
                        addBooth[BoothNumber] = name;
                        System.out.println("Booth Number " + BoothNumber + " Occupied By " + name);
                        Vaccinecount = Vaccinecount - 1;
                        System.out.println("Remaining Vaccine Count: " + Vaccinecount);
                        innerLoop = false;
                    } else if (!addBooth[BoothNumber].equals("Booth Empty")) {
                        System.out.println("Already Occupied!");
                        viewVBooth(currentVBooth);
                    }

                } else {
                    System.out.println("Invalid Booth Number!");
                }
            }
        }


    }
    //METHOD to remove Patient from a booth
    public static void removeFromBooth(String[] removeFromBooth) {
        Scanner r = new Scanner(System.in);
        boolean innerRemove = true;
        while (innerRemove){
            System.out.println("Enter Booth Number to Remove(0-5)");
            int patient = r.nextInt();

            if (patient <= 5 && patient >= 0){
                if (!removeFromBooth[patient].equals("Booth Empty")){
                    System.out.println(removeFromBooth[patient] + " Removed!");
                    removeFromBooth[patient] = "Booth Empty";
                    innerRemove = false;
                }
                else {
                    System.out.println("This Booth is Already Empty!");
                    viewVBooth(currentVBooth);
                }
            }
            else {
                System.out.println("Invalid Number");
            }
        }

    }
    //METHOD to sort pateints in alphebetical Order
    public static void sortBooth(String[] sortBooth){
        String[] sorting = Arrays.copyOfRange(sortBooth, 0, sortBooth.length);
        int j = 0;
        String temp;
        for (int i = 0; i < sorting.length ; i++){
            for (j = 0; j < sorting.length ; ++j){
                if(sorting[j].charAt(0)>sorting[i].charAt(0)){
                    temp=sorting[i];
                    sorting[i]=sorting[j];
                    sorting[j]=temp;
                }
            }
        }
        for(int k=0;k<sorting.length ;k++){
            if (!sorting[k].equals("Booth Empty")){
                System.out.println(sorting[k]);
            }

        }

    }
    //METHOD to store data in a Text file called Task2 in the project folder
    public static void storeData(String [] storeData ){

        try {
            FileWriter myFile = new FileWriter("Task1.txt");
            for(int x =0 ; x < storeData.length ; x++){
                myFile.write(" -------------------------- Booth Details --------------------------" + "\n");
                myFile.write("Name : " + storeData[x] + "\n");
                myFile.write("Booth Number: " + x + "\n");
                myFile.write("______________________________" + "\n");
                myFile.write("\n\n ");
            }
            myFile.write("Remaining Vaccine Count: " + Integer.toString(Vaccinecount));
            myFile.close();
            System.out.println("Data Successfully Stored");
        } catch (IOException e) {
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }

    }
    //METHOD to view data inside the java program that are taken from the Task2.txt file
    public static void ReadData(){
        try {
            File myFile = new File("Task1.txt");
            Scanner readFile = new Scanner(myFile) ;
            while (readFile.hasNextLine()){
                String data = readFile.nextLine();
                System.out.println(data);
                System.out.println();
            }
            readFile.close();
            System.out.println("Data Load Successfully! ");
        } catch (IOException e) {
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }
    }

}