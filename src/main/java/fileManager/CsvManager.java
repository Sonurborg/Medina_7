package fileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import store.*;

/**
 *
 * @author sonur
 */
public class CsvManager {
    
    private static Path file=Paths.get("Tickets.csv");
    
    public static void addTicket(Ticket tckt){
        String line=(tckt.getID()+","+tckt.getDate()+","+tckt.getTotal());
        tryWrite(line);
    }
    
    public static void readFile(){
        tryRead();
    }
    
    private static void tryWrite(String line){
        String text="null";
        try {
            text=new String(Files.readAllBytes(file));
            text =text+ "\n" + line;
            Files.write(file, text.getBytes(), new OpenOption[0]);
        } catch (Exception ex) {
            System.out.println("Error, no se pudo agregar la nueva línea.");
        }
    }
    
    private static String tryRead(){
        String text="null";
        try {
            reader(new BufferedReader(new FileReader("boletas.csv")));
        } catch (Exception ex) {
            System.out.println("Error, no se pudo leer el archivo.");
        }
        return text;
    }
    
    private static void reader(BufferedReader csvReader) throws Exception{
        String row;
        while (csvReader.readLine() != null){
            row=csvReader.readLine();
            String[] data = row.split(",");
            interpreter(data);
        }
        csvReader.close();
    }
    
    private static void interpreter(String[] data){
        int ID=Integer.parseInt(data[0]);
        Calendar date=Calendar.(data[1]);
        String adress=(data[2]+","+data[3]+","+data[4]+","+data[5]);
        Main.tickets.add(new Ticket(name,rut,adress));
    }
}
