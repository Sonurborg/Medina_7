package main;
import fileManager.CsvManager;
import userInterface.Menu;

public class Main {
	public static void main(String[] aArgs) {
            CsvManager.readFile();
            Menu.run();
        }
}