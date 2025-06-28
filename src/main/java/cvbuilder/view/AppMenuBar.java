package cvbuilder.view;

import cvbuilder.controller.AllSeeing;
import cvbuilder.controller.MenuProfileActions;
import cvbuilder.controller.UserProfileActions;

import javax.swing.*;

public class AppMenuBar extends JMenuBar {

    public AppMenuBar(){
        JMenu fileMenuBar = new JMenu("file");
        JMenuItem loadItem = new JMenuItem("Load");
        loadItem.setActionCommand("Load");
        JMenuItem openItem = new JMenuItem("Open");
        openItem.setActionCommand("OPEN");
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setActionCommand("SAVE");
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.setActionCommand("QUIT");
        JMenuItem printItem = new JMenuItem("Print");
        printItem.setActionCommand("PRINT");

        loadItem.addActionListener(new MenuProfileActions());
        openItem.addActionListener(new MenuProfileActions());
        saveItem.addActionListener(new MenuProfileActions());
        quitItem.addActionListener(new MenuProfileActions());
        printItem.addActionListener(new MenuProfileActions());


        fileMenuBar.add(loadItem);
        fileMenuBar.add(openItem);
        fileMenuBar.add(saveItem);
        fileMenuBar.add(quitItem);
        fileMenuBar.add(printItem);

        add(fileMenuBar);

    }

}

