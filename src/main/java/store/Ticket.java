/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.util.ArrayList;
import java.util.Calendar;

public class Ticket {
    
    private int ID;
    private Calendar date=Calendar.getInstance();
    private ArrayList<Meal> meals = new ArrayList<>();
    private int total;
    
    public Ticket(Calendar date,ArrayList meals,int total) {
        this.date=date;
        this.meals=meals;
        this.total=total;
        
    }

    public int getID() {
        return ID;
    }
    public Calendar getDate() {
        return date;
    }
    public int getTotal() {
        return total;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    
}
