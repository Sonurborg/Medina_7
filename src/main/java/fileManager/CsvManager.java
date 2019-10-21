package fileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import store.*;

public class CsvManager {
    
    private static Path file=Paths.get("boletas.csv");
    
    public static void addTicket(Ticket tckt){
        String line=(tckt.getID()+","+tckt.getDate()+","+tckt.getMealsString()+","+tckt.getTotal());
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
        Date date=Date.valueOf(data[1]);
        ArrayList meals=getMeals(data);
        int total=Integer.parseInt(data[data.length]);
        Store.tickets.add(new Ticket(ID,date,meals,total));
    }
    
    private static ArrayList getMeals(String[] data){
        ArrayList<Meal> acc=new ArrayList<>();
        for (int i=2;i<data.length-1;i++) {
            acc.add(Meal.valueOf(data[i]));
        }
        return acc;
    }
}
