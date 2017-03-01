package com.company;

import java.io.File;
import java.io.FileReader;

/**
 * Created by hackeru on 2/28/2017.
 */

public class MyFile extends File {

    public MyFile(String pathname) {
        super(pathname);
    }


    public boolean checkIfExists(){
       boolean isExist;
        isExist=this.exists();
        if (isExist) {
            FileReader reader = null;
            try {
                reader = new FileReader(this);
                reader.read();
            } catch (java.io.IOException e) {
                return false;
            }
        }
        return isExist;
    }
}
