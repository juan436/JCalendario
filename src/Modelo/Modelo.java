package Modelo;

public class Modelo {

	final static double CONTADO=5.0;
	final static double CREDITO=28.0;
	
	public double getTasaContado() {
		return CONTADO;
	}
	
	public double getTasaCredito() {
		return CREDITO;
	}
	
	public double gettasa(String pago) {
		double porc;
		if(pago.equals("contado"))
			porc=this.getTasaContado();
			else
				porc=this.getTasaCredito();
		return porc;
	} 
	public double getIntereses(double monto, String pago) {
		double porc;
		double interes;
		if(pago.equals("contado"))
			porc=this.getTasaContado();
			else
				porc=this.getTasaCredito();
		interes=monto*porc/100;
		return interes;
	}
	
	public double getCuotas(double monto, String pago,int meses) {
		double total;
		total=monto+this.getIntereses(monto, pago);
		return total/meses;
	}
	
	
	
	
	
}
