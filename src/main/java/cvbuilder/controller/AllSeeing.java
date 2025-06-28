package cvbuilder.controller;


import cvbuilder.model.UserGroup;
import cvbuilder.view.UserData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllSeeing extends MenuProfileActions{

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "OPEN":
                super.actionPerformed(e);


                break;
            default:
                super.actionPerformed(e);
        }
    }

}


