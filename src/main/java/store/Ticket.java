/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.util.ArrayList;
import java.util.Date;

public class Ticket {
    
    private int ID;
    private Date date;
    private ArrayList<Meal> meals = new ArrayList<>();
    private int total;
    
    public Ticket(int ID,Date date,ArrayList meals,int total) {
        this.ID=ID;
        this.date=date;
        this.meals=meals;
        this.total=getTotalPrice(meals);
    }
    
    
    public Ticket(Date date,ArrayList meals,int total) {
        this.date=date;
        this.meals=meals;
        this.total=getTotalPrice(meals);
        this.ID=Store.tickets.size();
    }
    
    private int getTotalPrice(ArrayList<Meal> meals){
        int acc= 0;
        for (int i=0;i<meals.size();i++) {
            acc+=meals.get(i).getPrice();
        }
        return acc;
    }

    public int getID() {
        return ID;
    }
    public Date getDate() {
        return date;
    }
    public int getTotal() {
        return total;
    }
    public String getMealsString(){
        String acc="";
        for (int i=0;i<meals.size();i++) {
            acc+=meals.get(i).name();
            if (i<meals.size()-1)acc+=",";
        }
        return acc;
    }
    
}
