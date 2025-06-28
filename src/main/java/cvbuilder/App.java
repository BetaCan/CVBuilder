package cvbuilder;


import cvbuilder.model.UserGroup;
import cvbuilder.view.MainViewer;

import java.io.File;

public class App {


        public static void main(String[] args) {
            // TODO code application logic here
            // This is where your application will start


            String FILENAME= System.getProperty("user.dir") + File.separator + "data"+ File.separator +"cv_repo_6.csv";
            UserGroup.getInstance().readCSVFile(FILENAME);



            MainViewer mv = new MainViewer();



        }
}

