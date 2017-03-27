package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class XorAlgorithm extends Algorithm {
    @Override
    public void encrypt (InputStream inputStream, OutputStream outputStream) throws IOException {
        int actuallyRead;
        while(( actuallyRead=inputStream.read())!=-1){
            byte actuallyWrite = (byte) (getKey()^actuallyRead);
            outputStream.write(actuallyWrite);
        }
    }

    public void decrypt(InputStream inputStream, OutputStream outputStream) throws IOException {
        encrypt(inputStream,outputStream);
        }
    }

