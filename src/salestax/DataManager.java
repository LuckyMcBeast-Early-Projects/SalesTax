package salestax;

import java.io.*;
import java.util.Scanner;

/**
 * Manages data from files for the SalesTax class
 */
public class DataManager {

    protected File src; //File located at provided file path

    /**
     * DataManager Constructor
     *
     * @param filePath location of chosen file
     */
    public DataManager(String filePath) {
        this.src = fileSelector(filePath);
    }

    DataManager() { } //Default Constructor

    /**
     * Selects file located at a selected path within the project (Format: /location/filename.extension)
     *
     * @param filepath target file's location
     * @return targeted file
     */
    public File fileSelector(String filepath) {
        String base = new File(filepath).getAbsolutePath();
        return new File(base);
    }

    /**
     * Places all files within a given directory into an array
     *
     * @param directoryPath location of directory
     * @return array of files within given directory path
     */
    public File[] directory(String directoryPath) {
        return this.fileSelector(directoryPath).listFiles();
    }

    /**
     * Prints a given file to System
     */
    public void filePrinter() {
        try (Scanner scan = new Scanner(src)) {
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (NullPointerException e) {
            System.out.println("File Selection Error");
        }
    }
}
