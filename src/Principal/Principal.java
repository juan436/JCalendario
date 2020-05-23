package Principal;

import Controlador.Controlador;
import Modelo.Modelo;
import Vista.IFormulario;
import Vista.VFormulario;



public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IFormulario vista = new VFormulario();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo,vista);
		vista.setControlador(controlador);
		vista.arrancar();
	}

}
