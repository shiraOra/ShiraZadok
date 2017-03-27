package com.company;

import com.company.MyFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by hackeru on 2/28/2017.
 */
public  class  FileAction {
    private int key;

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {

        return key;
    }

    public void action(InputStream inputStream, OutputStream outputStream) throws Exception{
       /* MyFile myFile=new MyFile(path);
        if (!myFile.checkIfExists()||!myFile.isFile())
            throw new FileNotFoundException("The file isn't exist in the path");*/
    }

    //public boolean isExist(S)

    public File createFile(String path, boolean bool  ) {
      int p= path.lastIndexOf('.');
      path=path.substring(0,p);
        if (bool)
            path +=   "_encrepted.txt";
        else
            path += "_decrepted.txt";
        return new File(path);
    }

}
