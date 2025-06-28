package cvbuilder.controller;



import cvbuilder.model.UserGroup;
import cvbuilder.view.RowPanel;
import cvbuilder.view.UserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MenuProfileActions implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not Supported yet ("+ e.getActionCommand()+") ogga boogalo");
        System.out.println(e.getActionCommand());

        switch(e.getActionCommand().toUpperCase()) {

            case "LOAD":
                UserGroup.getInstance().readCSVFile("data/cv_repo_6.csv");
                UserGroup.getInstance().modelChanged();
           break;


            case "OPEN":

                /////////////////////// old bit ////////////////////////

                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    // open the file
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        // Clear data from UserGroup
                        UserGroup.getInstance().getNames().clear();

                        // Read data from the file and add it to UserGroup
                        String line;
                        while ((line = reader.readLine()) != null) {
                            UserGroup.getInstance().getNames().add(line);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                break;

            case "SAVE":

                String dir = System.getProperty("user.dir")+ File.separator + "data" + File.separator;
                File directory = new File(dir);

                String fileName = JOptionPane.showInputDialog(null, "Enter file name:");
                if (fileName != null && !fileName.isEmpty()) {
                    // Constructing the file path
                    String filePath = dir + fileName+ ".csv";
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                       UserGroup.getInstance().saveCSVFile(filePath);

                      } catch (IOException ex) {
                       ex.printStackTrace();
                    }


                }

//                JFileChooser fileChooser1 = new JFileChooser();
//                int result1 = fileChooser1.showSaveDialog(null);
//                if (result1 == JFileChooser.APPROVE_OPTION) {
//                    File file1 = fileChooser1.getSelectedFile();
//                    //save data to the file
//                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file1))) {
//                       UserGroup.getInstance().saveCSVFile(String.valueOf(file1));
////
////                        }
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                }

                break;
            case "QUIT":
                System.exit(0);
                break;

            case "PRINT":
                System.out.println( );
                System.out.println(UserGroup.getInstance().printCV());


                System.out.println( );
                break;
            default:
                throw new UnsupportedOperationException("Not Supported yet ("+ e.getActionCommand()+") ogga boogalo");
        }
    }
}

