package com.company;


import com.company.actions.DecryptFile;
import com.company.actions.EncryptFile;
import com.company.actions.FileAction;

import java.util.Scanner;

/**
 * Created by hackeru on 2/28/2017.
 */

public  class MainMenu {


    public static void showMenu() {
        Scanner in = new Scanner(System.in);
        FileAction fileAction = new FileAction();
        System.out.println("Hi, Enter 1 for encrypt, 2 for decrypt and 0 for exit");
        String input = in.next();
        try {
            switch (input) {
                case "0":
                    break;
                case "1": {
                    fileAction = new EncryptFile();
                    break;
                }
                case "2": {
                    fileAction = new DecryptFile();
                    break;
                }
                default: {
                    System.out.println("Your input is incorrect try again");
                    MainMenu.showMenu();
                }
            }

            if (input != "0") {
                String s = getFileFromUser();
                fileAction.action(s);


            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        MainMenu.showMenu();
    }

    public static String getFileFromUser() {
        Scanner in = new Scanner(System.in);
        String s;
        System.out.println("Enter a path of file");
        s = in.next();
        return s;
    }
}
