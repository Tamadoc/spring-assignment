package se.lexicon.teri.util;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("inputService")
public class ScannerInputService implements UserInputService {

    private final Scanner scanner;

    public ScannerInputService() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        int i = scanner.nextInt();
        scanner.nextLine();
        return i;
    }
}
