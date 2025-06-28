package cvbuilder.view;

import cvbuilder.controller.AllSeeing;
import cvbuilder.controller.UserProfileActions;
import cvbuilder.model.UserGroup;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UserData extends JPanel implements Observer  {


    private ButtonGroup buttonGroup;

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    private ArrayList<String> boundData = new ArrayList<>();

    public ArrayList<String> getBoundata() {
        return boundData;
    }

    public UserData(ArrayList<String> incomingData){
        super();
        this.boundData=incomingData;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        update();
        /*
        for (String name: UserGroup.getInstance().getNames()){
            this.add(new RowPanel(name));
        }
        */

    }


    /*
   public void update (){
       this.removeAll(); //empties the panel
       for (String kermit: boundData){
      for (String name: UserGroup.getInstance().getNames()){
            this.add(new RowPanel(kermit));
        }
        this.repaint();
    }

     */

    /*
    public void update (){
        this.removeAll(); //empties the panel
        var buttonGroup = new ButtonGroup(); // we can use var cuz java will know what type since we link it to ButtonGroup
        for (String kermit: boundData){
            var rp = new RowPanel(kermit);
            buttonGroup.add(rp.getRadioButton());
            this.add(rp);
        }
        revalidate(); // revalidates the panel to make any changes if needed
        this.repaint(); // repaints the panel if needed
    }

     */
    public final void update (){
        this.removeAll(); //empties the panel
         buttonGroup = new ButtonGroup(); // we can use var cuz java will know what type since we link it to ButtonGroup
        for (String kermit: boundData){ //for each loop to loop through the data collected and insert it back
            var rp = new RowPanel(kermit);
            buttonGroup.add(rp.getRadioButton());
            this.add(rp);
        }


        JButton addButton = new JButton("Add");
        addButton.setActionCommand("ADD");
        addButton.addActionListener(new UserProfileActions());
        this.add(addButton);

        revalidate(); // revalidates the panel to make any changes if needed
        this.repaint(); // repaints the panel if needed
    }





}

