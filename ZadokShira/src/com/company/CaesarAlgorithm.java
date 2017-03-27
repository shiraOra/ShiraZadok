package com.company;

import com.company.Algorithm;

import java.io.*;

public class CaesarAlgorithm extends Algorithm {
    @Override
    public void encrypt (InputStream inputStream, OutputStream outputStream) throws IOException {
        int actuallyRead;
        while(( actuallyRead=inputStream.read())!=-1){
            byte actuallyWrite = (byte) (getKey()+actuallyRead);
            outputStream.write(actuallyWrite);
        }
    }

    public void decrypt(InputStream inputStream, OutputStream outputStream) throws IOException {
        int actuallyRead;
        while ((actuallyRead = inputStream.read()) != -1) {
            byte actuallyWrite = (byte) (actuallyRead - getKey());
            outputStream.write(actuallyWrite);
        }
    }
}
