package com.company;


import java.io.File;
import java.util.Random;

/**
 * Created by hackeru on 2/28/2017.
 */

public  class MainMenu {

   static Input input =new UserInput();
   static Output output =new UserOutput();
   private static final String EXIT = "0";

    public static void showMenu() {

        Algorithm algorithm=null;
        output.output("Hi, Enter 1 for encrypt, 2 for decrypt and 0 for exit");
        String choice = null;
        choice = MainMenu.input.input();
        try {
            switch (choice) {
                case EXIT:
                    return;
                case "1":{
                    output.output("Choose algorithm for encrypt");
                    algorithm=chooseAlgorithm();
                    randomKey(algorithm);
                    String filePath = getFileFromUser();
                    new FileEncryptor().encryptFile(new File(filePath), algorithm);
                    break;
                }
                case "2": {
                    output.output("Choose algorithm for decrypt");
                    algorithm=chooseAlgorithm();
                    EnterKey(algorithm);
                    String filePath = getFileFromUser();
                    new FileEncryptor().decryptFile(new File(filePath),algorithm);
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

    private static void EnterKey(Algorithm algorithm)throws KeyException {
        if(algorithm instanceof MultAlgorithm) {
            boolean isValid = false;
            while (!isValid) {
                output.output("Enter the key ");
                int key = Integer.parseInt(input.input());
                if ((key % 2) != 0) {
                    algorithm.setKey(key);
                    isValid = true;
                }
                else throw new KeyException("The key shouldn't be even number");
            }
        }
        else {
            output.output("Enter the key ");
            int key = Integer.parseInt(input.input());
            algorithm.setKey(key);
        }
    }
/*    private static void EnterKeyMult(Algorithm algorithm) {
        boolean isValid=false;
        while(!isValid) {
            output.output("Enter the key ");
            int key = Integer.parseInt(input.input());
            if ((key%2)!=0) {
                algorithm.setKey(key);
                isValid = true;
            }
            else output.output("This key isn't valid for multiplication algorithm");
        }
    }*/
    private static void randomKey(Algorithm algorithm) {
        Random random=new Random(System.currentTimeMillis());
        if (algorithm instanceof MultAlgorithm)
            algorithm.setKey(random.nextInt(128)*2-1);
        else
            algorithm.setKey(random.nextInt(255));
       output.output("The key is: ");
       output.output(String.valueOf(algorithm.getKey()));
    }

 /*   private static void randomKeyMult(Algorithm algorithm) {
        Random random=new Random(System.currentTimeMillis());
        algorithm.setKey(random.nextInt(128)*2-1);
        output.output("The key is: ");
        output.output(String.valueOf(algorithm.getKey()));
    }*/

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

    public static Algorithm chooseAlgorithm(){
        String choice;
        Algorithm algorithm=null;
        output.output("For Caesar press 1");
        output.output("For Xor press 2");
        output.output("For Multiplication press 3");
        output.output("For Reverse press 4");
        choice=input.input();
        switch (choice){
            case "1":{
                algorithm=new CaesarAlgorithm();
                break;
            }
            case "2": {
                algorithm = new XorAlgorithm();
                break;
            }

            case "3": {
                algorithm = new MultAlgorithm();
                break;
            }
            case "4": {
                output.output("Choose Caesar 1 Xor 2 or Multiplication 3");
                choice=input.input();
                switch (choice){
                    case "1":{
                        algorithm=new ReverseAlgorithm(new CaesarAlgorithm());
                        break;
                    }
                    case "2":{
                        algorithm=new ReverseAlgorithm(new XorAlgorithm());
                        break;
                    }
                    case "3":{
                        algorithm=new ReverseAlgorithm(new MultAlgorithm());
                        break;
                    }
                }
            }

        }
        return algorithm;
    }
    //public class KeyException extends Exception(){}
}
