package cvbuilder.view;

import cvbuilder.controller.AllSeeing;
import cvbuilder.controller.UserProfileActions;
import cvbuilder.model.UserGroup;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;


/**
 *
 * @author
 * This might be useful for defining you Main App Viewer e.g. a JFrame
 */
public class MainViewer extends JFrame {

////////////////////////////////////////////// CVBUILDER REFACTOR /////////////////////////////////////////////////////////////////////////////


    // the godly TABS
    private JTabbedPane userProfile = new JTabbedPane();
    private JPanel userNamePanel = new JPanel(new BorderLayout()); // =  new USER name JPanel();



    /////////////////////////////////////// new bit //////////////////////////////////////////
    private JPanel userTitlePanel= new JPanel(new BorderLayout()); // =  new USER title JPanel();
    private JPanel userEmailPanel = new JPanel(new BorderLayout()); // =  new USER email JPanel();


    // add button stuff (found this from this video = https://www.youtube.com/watch?v=Yemr-z4ZcYk )
    private JTextField input;
    private JButton addButton;


    //tabs
    private JPanel usrtab = new JPanel(new BorderLayout());
    private JPanel edutab = new JPanel(new BorderLayout());

    //sub tabs
    private JTabbedPane usrSubTabs = new JTabbedPane();
    private JTabbedPane eduSubTabs = new JTabbedPane();


    //education
    private JPanel institution1Panel = new JPanel(new BorderLayout()); // =  new USER email JPanel();
    private JPanel institution2Panel = new JPanel(new BorderLayout()); // =  new USER email JPanel();

    //////////////////////////////////////////////////////////////////////////////////////////




    // the main viewer
    public MainViewer() {
        super("CV Builder");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 500);
        this.add(userProfile);// TabbedPane added to the JFrame
        usrtab = new JPanel(new FlowLayout(FlowLayout.LEFT));




        // creating the appMenuBar
        AppMenuBar menuBar = new AppMenuBar();
        this.setJMenuBar(menuBar);

        userNamePanel.setLayout(new GridLayout(1,2));
        userNamePanel = new UserData(UserGroup.getInstance().getNames());
        // ADDING THE GODLY TABS INTO THE profile of the user
        //this.add(userProfile);// TabbedPane added to the JFrame
        usrtab.add("Name", userNamePanel);// Username Panel added as a tab
        usrSubTabs.addTab("Name", userNamePanel);
        UserGroup.getInstance().getObservers().add((Observer) userNamePanel);
        userNamePanel.setBorder(new TitledBorder("Name"));


        /////////////////////////////////////// new bit //////////////////////////////////////////

        //title
        userTitlePanel.setLayout(new GridLayout(1,2));
        userTitlePanel = new UserData(UserGroup.getInstance().getTitles());
        //this.add(userProfile);
        usrtab.add("Title", userTitlePanel);
        usrSubTabs.addTab("Title", userTitlePanel);
        UserGroup.getInstance().getObservers().add((Observer) userTitlePanel);
        userTitlePanel.setBorder(new TitledBorder("Title"));

        //email
        userEmailPanel.setLayout(new GridLayout(1,2));
        userEmailPanel= new UserData(UserGroup.getInstance().getEmails());
//        this.add(userProfile);
        usrtab.add("Email", userEmailPanel);
        usrSubTabs.addTab("Email", userEmailPanel);
        UserGroup.getInstance().getObservers().add((Observer) userEmailPanel);
        userEmailPanel.setBorder(new TitledBorder("Email"));



        edutab = new JPanel(new FlowLayout(FlowLayout.LEFT));


        institution1Panel = new UserData(UserGroup.getInstance().getInstitution1());
//        this.add(userProfile);
        edutab.add("institution1", institution1Panel);
        eduSubTabs.addTab("Institution 1", institution1Panel);
        UserGroup.getInstance().getObservers().add((Observer) institution1Panel);
        institution1Panel.setBorder(new TitledBorder("institution1"));



        institution2Panel = new UserData(UserGroup.getInstance().getInstitution2());
//        this.add(userProfile);
        edutab.add("institution2", institution2Panel);
        eduSubTabs.addTab("Institution 2", institution2Panel);
        UserGroup.getInstance().getObservers().add((Observer) institution2Panel);
        institution2Panel.setBorder(new TitledBorder("institution2"));


        // Add User Sub-Tabs to User Panel
        usrtab.add(usrSubTabs);
// Add Institution Sub-Tabs to Institution Panel
        edutab.add(eduSubTabs);



        // Add User Panel to User Tab
        userProfile.addTab("User", usrtab);
        // Add Institution Panel to Education Tab
        userProfile.addTab("Education", edutab);







        ///////////////////////////////////////////////////////////////////////////////////////////







        //make the app visible
        this.setVisible(true);


    }












/*
    //////////////////////////// third Try //////////////////////////////


    // the godly TABS
    private JTabbedPane userProfile = new JTabbedPane();
    private JPanel userNamePanel; // =  new JPanel();

    public JTabbedPane getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(JTabbedPane userProfile) {
        this.userProfile = userProfile;
    }


    // the main viewer
    public MainViewer() {
        super("User Profile Builder");
        //JFrame myWindow= new JFrame("User Profile Builder");
        //myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //myWindow.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // creating the appMenuBar
        AppMenuBar menuBar = new AppMenuBar();
        this.setJMenuBar(menuBar);


        this.setSize(600, 400);
        userNamePanel = new UserData();

        // ADDING THE GODLY TABS INTO THE profile of the user
        this.add(userProfile);// TabbedPane added to the JFrame
        userProfile.add("User Name", userNamePanel);// Username Panel added as a tab

        // the making of the greatest PANEL
        //JPanel jp = new RowPanel("boo");
        //userNamePanel.add(jp);

        // the FR FR GREATEST PANEL
        // old method
        //userNamePanel.add(new RowPanel("boo"));
        //userNamePanel.add(new RowPanel("boo"));
        //userNamePanel.add(new RowPanel("boo"));



//            //new method
//    for (String name:UserGroup.getInstance().getNames()){
//        userNamePanel.add(new RowPanel(name));
//    }



        userNamePanel.setBorder(new TitledBorder("Name"));

        //make the app visible
        this.setVisible(true);


    }

*/

}