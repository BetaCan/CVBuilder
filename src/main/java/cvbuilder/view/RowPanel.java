package cvbuilder.view;
import cvbuilder.controller.UserProfileActions;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class RowPanel extends JPanel {


    // this is the RowPanel which extends from jPAnel to create an edit button and delete button
    // the main functionality of the button is done in UserProfileActions

        JRadioButton radioButton;
        JButton editButton, deleteButton;


        public JRadioButton getRadioButton() {
            return radioButton;
        }

        public RowPanel (String labelText)
        {
            super(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout with left alignment
            radioButton = new JRadioButton(labelText);
            radioButton.setPreferredSize(new Dimension(650, radioButton.getPreferredSize().height));
            // Set preferred size to force text wrapping (it doesnt work :( )

            radioButton.setActionCommand("SELECTION");
            radioButton.addActionListener(new UserProfileActions());


            editButton= new JButton("Edit");
            editButton.setActionCommand("EDIT");
            editButton.addActionListener(new UserProfileActions());

            deleteButton= new JButton("Delete");
            deleteButton.setActionCommand("DELETE");
            deleteButton.addActionListener(new UserProfileActions());





            this.add(radioButton);
            this.add(editButton);
            this.add(deleteButton);


        }
}



