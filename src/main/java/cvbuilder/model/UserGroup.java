package cvbuilder.model;

import cvbuilder.view.Observer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public final class UserGroup {


    private static final UserGroup INSTANCE = new UserGroup();

///////////////////// observers & Selections /////////////////////////
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    private ArrayList<String> selections = new ArrayList<>();

    public ArrayList<String> getSelections() {
        return selections;
    }

    public void setSelections(ArrayList<String> selections) {
        this.selections = selections;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }
////////////////////////////////////////////////////////////////////////
    private UserGroup() {
        // empty constructor
    }

    public static UserGroup getInstance() {
        return INSTANCE;
    }


    ///////////////////////////////////////////

    //this looks for changes
    public  void modelChanged(){
        for (Observer oi: observers) oi.update();
    }


    ///////////////////////////////////////////


    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<String> emails = new ArrayList<>();

    private final ArrayList<String> institution1 = new ArrayList<>();

    private final ArrayList<String> institution2 = new ArrayList<>();

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    public void setTitles(ArrayList<String> titles) {
        this.titles = titles;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public ArrayList<String> getInstitution1() {
        return institution1;
    }

    public ArrayList<String> getInstitution2() {
        return institution2;
    }



    public String generateTextPreview() {
        StringBuilder sb = new StringBuilder();
//        sb.append("Titles{" + "titles=" + titles + "}").append("\n");
//        sb.append("Names{" + "names=" + names + "}").append("\n");
//        sb.append("Emails{" + "emails=" + emails + "}").append("\n");
//        sb.append("Selections{" + "selections=" + selections + "}").append("\n");

        for(var t: titles){
            if (selections.contains(t)){
                sb.append(t).append(" ");
            }
        }

        for(var n: names){
            if (selections.contains(n)){
                sb.append(n).append(" ");
            }
        }


        for(var e: emails){
            if (selections.contains(e)){
                sb.append(" (").append(e).append(") ");
            }
        }

        for(var i1: institution1){
            if (selections.contains(i1)){
                sb.append("").append(i1).append(" ");
            }
        }
        for(var i2: institution2){
            if (selections.contains(i2)){
                sb.append("").append(i2).append(" ");
            }
        }


        return sb.toString();

    }

    public void readCSVFile (String filename){

        clearCSVData();

            try(
                FileReader file = new FileReader(filename);
                BufferedReader b = new BufferedReader(file);
            ){
                while (b.ready()) {
                    String line = b.readLine();
//                    line = line.replace("%%%%"," ");
                    String[] fields = line.split(",");

                    for (int i=1; i < fields.length; i++)
                    {
//                        fields[i] =fields[i].replace("%%%%","\n");
                        fields[i] =fields[i].replace("%%%%",", ");
                        fields[i] =fields[i].replace("////"," ");
                    }

                    switch (fields[0]) {
                        case "Selections" -> {
                            for (int i = 2; i < fields.length; i++) {
                                this.selections.add(fields[i]);
                            }
                        }
                        case "User" -> {
                            switch (fields[1]) {
                                case "Title" -> {
                                    // create a for loop if you want our want to add more to it
                                    for (int i = 2; i < fields.length; i++) {
                                        this.titles.add(fields[i]);
                                    }
                                }
                                case "Email" -> {
                                    // create a for loop if you want our want to add more to it
                                    for (int i = 2; i < fields.length; i++) {
                                        this.emails.add(fields[i]);
                                    }
                                }
                                case "Name" -> {
                                    // create a for loop if you want our want to add more to it
                                    for (int i = 2; i < fields.length; i++) {
                                        this.names.add(fields[i]);
                                    }
                                }
                            }
                        }
                        case "Education" -> {

                            if (fields[1].equals("Institution 1")) {
                                // create a for loop if you want our want to add more to it
                                for (int i = 2; i < fields.length; i++) {
                                    this.institution1.add(fields[i]);
                                }
                            } else if (fields[1].equals("Institution 2")) {
                                // create a for loop if you want our want to add more to it
                                for (int i = 2; i < fields.length; i++) {
                                    this.institution2.add(fields[i]);
                                }
                            }
                        }
                    }

                    System.out.println(names);
                    System.out.println(titles);
                    System.out.println(emails);
                    System.out.println(institution1);
                    System.out.println(institution2);



                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    private void clearCSVData(){
        names.clear();
        emails.clear();
        titles.clear();
        institution2.clear();
        institution1.clear();


    }



    public void saveCSVFile(String filename) {
        try (FileWriter file = new FileWriter(filename);
             BufferedWriter b = new BufferedWriter(file)) {
            b.write("Section,Sub-Section,Variants\n");
            b.write("User,Name," + String.join(",", names).replace(" ", "%%%%") + "\n");
            b.write("User,Title," + String.join(",", titles).replace(" ", "%%%%") + "\n");
            b.write("User,Email," + String.join(",", emails).replace(" ", "%%%%") + "\n");
            b.write("Education,Institution 1," + String.join(",", institution1).replace(" ", "%%%%") + "\n");
            b.write("Education,Institution 2," + String.join(",", institution2).replace(" ", "%%%%") + "\n");
            b.write("Selections,," + String.join(",", selections).replace(" ", "%%%%") + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public String printCV() {
        StringBuilder sb = new StringBuilder();

        for(var t: titles){
            if (selections.contains(t)){
                sb.append(t).append(" "+ "\n");
            }
        }

        for(var n: names){
            if (selections.contains(n)){
                sb.append(n).append(" "+ "\n");
            }
        }

        for(var e: emails){
            if (selections.contains(e)){
                sb.append(e).append(" "+ "\n");
            }
        }

        for(var i1: institution1){
            if (selections.contains(i1)){
                sb.append("").append(i1).append(" "+ "\n");
            }
        }
        for(var i2: institution2){
            if (selections.contains(i2)){
                sb.append("").append(i2).append(" "+ "\n");
            }
        }

        return sb.toString();

    }




//    public void saveCSVFile (String filename){
//        try(
//                FileWriter file = new FileWriter(filename);
//                BufferedWriter b = new BufferedWriter(file);
//        ){
//            b.write("Section,Sub-Section,Variants\n");
//            b.write("User,Title,");
//            b.write(String.join(",",titles));
//            b.write("\nUser,Name,");
//            b.write(String.join(",",names));
//            b.write("\nUser,Email,");
//            b.write(String.join(",",emails));
//            b.write("\nEducation,Institution 1,");
//            b.write(String.join(",",institution1));
//            b.write("\nEducation,Institution 2,");
//            b.write(String.join(",",institution2));
//
//            b.write("\nSelections,,");
//            b.write(String.join(",",selections));
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



}
