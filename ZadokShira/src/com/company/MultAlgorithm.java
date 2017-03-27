package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MultAlgorithm extends Algorithm {
    @Override
    public void encrypt(InputStream inputStream, OutputStream outputStream) throws IOException {
        int actuallyRead;
        while ((actuallyRead = inputStream.read()) != -1) {
            byte actuallyWrite = (byte) ((getKey() * actuallyRead) & 0x000000FF);
            outputStream.write(actuallyWrite);
        }
    }

    public void decrypt(InputStream inputStream, OutputStream outputStream) throws IOException {
        int actuallyRead;
        int inverseKey =0;
        for (int i = 1; i < 256; i++) {
            if (((i * getKey())&0x000000FF) == 1) {
                inverseKey = i;
                break;
            }
        }
        setKey(inverseKey);
        while ((actuallyRead = inputStream.read()) != -1) {
            byte actuallyWrite = (byte) (actuallyRead *getKey());
            outputStream.write(actuallyWrite);
        }
    }
}

