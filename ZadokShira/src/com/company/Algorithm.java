package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by hackeru on 3/26/2017.
 */
public abstract class Algorithm {
    private int key;

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {

        return key;
    }


    public void encrypt (InputStream inputStream, OutputStream outputStream) throws IOException {};
    public void decrypt (InputStream inputStream, OutputStream outputStream)throws IOException{};
}
