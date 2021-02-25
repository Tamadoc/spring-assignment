package se.lexicon.teri.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("userInput")
public class ScannerInputService implements UserInputService {

    @Autowired
    private Scanner scanner;

    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        return scanner.nextInt();
    }
}
