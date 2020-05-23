package Vista;

import Controlador.Controlador;

public interface IFormulario {
	final static String ACEPTAR="aceptar";
	
	public void setControlador(Controlador c);
	public void arrancar();
	public String getNombre();
	public String getCi();
	public String getFecha();
	public int getmeses();
	public String getPago();
	public double getMonto();
 
}