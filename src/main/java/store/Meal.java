package store;

public enum Meal {
	Empanada(1000),
	Pizza(1500),
	Churro(800),
	Papas_Fritas(600),
	Humita(1200);

	private double price;
	private Meal(double price) {
		this.price=price;
	}
	public double getPrice(){
		return this.price;
	}

	public static Meal getMeal(int i){
            if(i==0)return Empanada;
            if(i==1)return Pizza;
            if(i==2)return Churro;
            if(i==3)return Papas_Fritas;
            if(i==4)return Humita;
            else return null;
	}

	public String toString(){
		return name()+": $"+getPrice();
	}
	public String toStringLista(){
		return name()+": $"+getPrice()+"\n";
	}

}