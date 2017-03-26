package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/26/2017.
 */
public class FileEncryptor {

    public File encryptFile (File sourceFile,Algorithm algorithm){
        File newFile=createEncryptFile(sourceFile.getAbsolutePath());
        try {
            InputStream inputStream=new FileInputStream(sourceFile);
            OutputStream outputStream=new FileOutputStream(newFile);
            algorithm.encrypt(inputStream,outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newFile;
    }

    public File decryptFile (File sourceFile,Algorithm algorithm){
        File newFile=createDecryptFile(sourceFile.getAbsolutePath());
        try {
            InputStream inputStream=new FileInputStream(sourceFile);
            OutputStream outputStream=new FileOutputStream(newFile);
            algorithm.decrypt(inputStream,outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newFile;
    }


    public File createEncryptFile(String path ) {
        int p= path.lastIndexOf('.');
        path=path.substring(0,p);
        path +=   "_encrypted.txt";
        return new File(path);
    }

    public File createDecryptFile(String path ){
        int p= path.lastIndexOf('.');
        path=path.substring(0,p);
        path += "_decrypted.txt";
        return new File(path);
    }

}
