package com.company.actions;

import com.company.MyFile;

import java.io.FileNotFoundException;

/**
 * Created by hackeru on 2/28/2017.
 */
public  class  FileAction {

    public void action(String path) throws Exception{
        MyFile myFile=new MyFile(path);
        if (!myFile.checkIfExists()||!myFile.isFile())
            throw new FileNotFoundException("The file isn't exist in the path");
    }



}
