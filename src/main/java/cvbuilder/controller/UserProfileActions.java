package cvbuilder.controller;

import cvbuilder.model.UserGroup;
import cvbuilder.view.RowPanel;
import cvbuilder.view.UserData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class UserProfileActions implements ActionListener {

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {


        ////////////////////////////////////////////// pls work ///////////////////////////////////////////////////////////////////////////////


        //throw new UnsupportedOperationException("Not Supported yet ("+ e.getActionCommand()+") ogga boogalo");

        if (!(e.getSource() instanceof JButton || e.getSource() instanceof JRadioButton)) {
            return;
        }
        AbstractButton button = (AbstractButton) e.getSource();

        ////////////////////////// add ///////////////////

        if(e.getActionCommand().equals("ADD")){
            UserData userData = (UserData) button.getParent();
            String newValue = JOptionPane.showInputDialog(userData,"Enter the new value");

            if (newValue != null && !newValue.isBlank()) {
                userData.getBoundata().add(newValue);
                userData.update();
            }

        }else {

        ////////////////////////////////////////////////////


            RowPanel row = (RowPanel) button.getParent();
            UserData userData = (UserData) row.getParent();

            // retrieve text from the radio button
            String oldValue = row.getRadioButton().getText();

            switch (e.getActionCommand()) {
                case "EDIT":

                    //find swing control Radio button

                    //if (!(e.getSource() instanceof JButton)) return;
                    //JButton button = (JButton) e.getSource();
                    //RowPanel row = (RowPanel) button.getParent();
                    //UserData userData  = (UserData) row.getParent();

                    // retrieve text from the radio button
                    //String oldValue = row.getRadioButton().getText();

                    //allow user to edit
                    String newValue = JOptionPane.showInputDialog(
                            row.getParent(), "EDIT THE OLD TEXT", oldValue
                    );

                    //update data model
                    var kermit = userData.getBoundata();
                    kermit.set(kermit.indexOf(oldValue), newValue);
                    System.out.println(UserGroup.getInstance().toString());


                    //update view
                    if (newValue != null && !newValue.isBlank()) {
                        //row.getRadioButton().setText(newValue);
                        userData.update();
                    }
                    break;

                case "DELETE":
                    // delete the user in the row
                    //update model by deleting the selected user
                    // update the view by deleting the row panel

///////////////////////////////////////////// new bit //////////////////////////////////////////////////////////////
                    // uses UserData bound data to locate metamodel
                    kermit = userData.getBoundata();

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//              names = UserGroup.getInstance().getNames();
                    kermit.remove(kermit.indexOf(oldValue));
                    userData.update();
                    break;

                case "ADD":
                    userData = (UserData) row.getParent();
//                  userData.getBoundata().add(newValue);
                    break;


                case "SELECTION":
                    for (Enumeration <AbstractButton> buttons = userData.getButtonGroup().getElements();
                         //enumerates gets all buttons rg: i found one let me find another until i cant
                         buttons.hasMoreElements();
                    ) {
                        AbstractButton b = buttons.nextElement();
                        //System.out.println(b.isSelected() + ":" + b.getText());
                        if (b.isSelected()) {
                            UserGroup.getInstance().getSelections().add(
                                    b.getText()
                            );
                        } else {
                            UserGroup.getInstance().getSelections().remove(
                                    b.getText()
                            );
                        }
                    }
                    //System.out.println(UserGroup.getInstance().toString());
                    System.out.println(UserGroup.getInstance().generateTextPreview());
                    break;


                default:
                    throw new UnsupportedOperationException("Not Supported yet (" + e.getActionCommand() + ") ogga boogalo");
            }
        }
    }


}


