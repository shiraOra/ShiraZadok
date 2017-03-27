package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReverseAlgorithm extends Algorithm {
    private Algorithm algorithm;

    public ReverseAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public void encrypt (InputStream inputStream, OutputStream outputStream) throws IOException {
        algorithm.decrypt(inputStream,outputStream);
    }

    public void decrypt(InputStream inputStream, OutputStream outputStream) throws IOException {
       algorithm.encrypt(inputStream,outputStream);
        }
    }

