package com.company;


import com.company.actions.*;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by hackeru on 2/28/2017.
 */

public  class MainMenu {

   static Input input =new UserInput();
   static Output output =new UserOutput();

    public static void showMenu() {

        Scanner in = new Scanner(System.in);
        Algorithm algorithm;
        output.output("Hi, Enter 1 for encrypt, 2 for decrypt and 0 for exit");
        String input = null;
        input = MainMenu.input.input();
        try {
            switch (input) {
                case "0":
                    return;
                case "1": {
                    algorithm=new CaesarAlgorithm();
                    randomKey(algorithm);
                    String s = getFileFromUser();
                    new FileEncryptor().encryptFile(new File(s), algorithm);
                    break;
                }
                case "2": {
                    algorithm = new CaesarAlgorithm();
                    EnterKey(algorithm);
                    String s = getFileFromUser();
                    new FileEncryptor().decryptFile(new File(s),algorithm);
                    break;
                }
                default: {
                    output.output("Your input is incorrect try again");
                    MainMenu.showMenu();
                }
            }
/*
            if (!input.equals("0")) {
                String s = getFileFromUser();
                if (!s.equals(null))
                    fileAction.action(s);
                else
                    return;
            }
            else
                return;*/

        } catch (Exception e) {
            output.output(e.getMessage());
        }
        MainMenu.showMenu();
    }

    private static void EnterKey(Algorithm algorithm) {
        output.output("Enter the key ");
        int key=Integer.parseInt(input.input());
        algorithm.setKey(key);
    }

    private static void randomKey(Algorithm algorithm) {
        Random random=new Random(System.currentTimeMillis());
        algorithm.setKey(random.nextInt(255));
       output.output("The key is: ");
       output.output(String.valueOf(algorithm.getKey()));
    }

    public static String getFileFromUser() {
        String s=null;
        output.output("Enter a path of file");
        s = input.input();
        MyFile myFile = new MyFile(s);
        while (!myFile.checkIfExists()||!myFile.isFile()) {
            output.output("The file isn't exist, enter a correct path again or enter 0 for exit");
            s = input.input();
            if(s.equals("0"))
                break;
            myFile = new MyFile(s);
        }
        return s;
    }
}
