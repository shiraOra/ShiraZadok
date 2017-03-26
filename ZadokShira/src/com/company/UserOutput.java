package com.company;

/**
 * Created by hackeru on 3/26/2017.
 */
public class UserOutput implements Output {
    @Override
    public void output(String string) {
        System.out.println(string);
    }
}
