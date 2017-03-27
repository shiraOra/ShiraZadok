package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by hackeru on 3/26/2017.
 */
class MainMenuTest {
    static Input input;
    static Output output;

    @BeforeEach
    void setUp() {
        input= mock(Input.class);
        output=mock(Output.class);
        MainMenu.input=input;
        MainMenu.output=output;
    }

    @Test
    void firstIoBlank() {
        String s = " ";
        when(input.input()).thenReturn(s).thenReturn("0");
        MainMenu.showMenu();
        verify(output).output("Your in" +
                "put is incorrect try again");
    }

    @Test
    void firstIoLetter() {
        String s = "p";
        when(input.input()).thenReturn(s).thenReturn("0");
        MainMenu.showMenu();
        verify(output).output("Your input is incorrect try again");
    }

    @Test
    void firstIoNull(){
        String s = "";
        when(input.input()).thenReturn(s).thenReturn("0");
        MainMenu.showMenu();
        verify(output).output("Your input is incorrect try again");
    }

    @Test
    void firstIoValid(){
        String s = "1";
        when(input.input()).thenReturn(s).thenReturn("0");
        MainMenu.showMenu();
        verify(output).output("Enter a path of file");
    }

    @Test
    void firstIoInValid(){
        String s = "9";
        when(input.input()).thenReturn(s).thenReturn("0");
        MainMenu.showMenu();
        verify(output).output("Your input is incorrect try again");
    }


   @Test
    void showMenu_invalidPath_fail(){
        String s = "hello";
        when(input.input()).thenReturn("1").thenReturn(s).thenReturn("0");
        MainMenu.showMenu();
       verify(output).output("The file isn't exist, enter a correct path again or enter 0 for exit");
    }

    @Test
    void validPathDecrypt(){
        String s = "\\Users\\hackeru.HACKERU3\\Documents\\SOA\\Files\\aaa.txt";
        when(input.input()).thenReturn("2").thenReturn(s).thenReturn("34").thenReturn("0");
        MainMenu.showMenu();
        verify(output).output("Enter the key ");
    }

    @Test
    void validPathEncrypt(){
        String s = "\\Users\\hackeru.HACKERU3\\Documents\\SOA\\Files\\aaa.txt";
        when(input.input()).thenReturn("1").thenReturn(s).thenReturn("0");
        MainMenu.showMenu();
        verify(output).output("The key is: " );
    }

    @AfterEach
    void tearDown() {

    }

}