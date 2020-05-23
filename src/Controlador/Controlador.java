package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Modelo.Modelo;
import Vista.IFormulario;
import Vista.VRecibo;



public class Controlador implements ActionListener {

	Modelo modelo;
	IFormulario vista;
	
	public Controlador(Modelo modelo,IFormulario vista)
	{
		this.modelo = modelo;
		this.vista = vista;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals(IFormulario.ACEPTAR))
		{
			double cuotas;
			int meses = vista.getmeses();
			double tasa = modelo.gettasa(vista.getPago());
			double interes = modelo.getIntereses(vista.getMonto(), vista.getPago());
			if (vista.getNombre().isEmpty())
				JOptionPane.showMessageDialog(null,"El campo nombre debe llenarse.","Advertencia" ,
						JOptionPane.INFORMATION_MESSAGE);
			else if (vista.getCi().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo C.I debe llenarse.","Advertencia" ,
						JOptionPane.INFORMATION_MESSAGE);
			else if (vista.getFecha().isEmpty())
				JOptionPane.showMessageDialog(null, "El campo fecha debe llenarse.", "Advertencia",
						JOptionPane.INFORMATION_MESSAGE);
			else if (vista.getMonto() == 0.0)
				JOptionPane.showMessageDialog(null, "El campo Monto debe llenarse.","Advertencia" ,
						JOptionPane.INFORMATION_MESSAGE);
			else {
				if (vista.getPago().equals("credito"))
					cuotas = modelo.getCuotas(vista.getMonto(), vista.getPago(), meses);
				else {
					cuotas = 0;
					meses = 0;
				}
				double total = vista.getMonto() + interes;
				VRecibo recibo = new VRecibo(vista.getNombre(), vista.getCi(), vista.getFecha(), vista.getMonto(),
						meses, cuotas, interes, total, vista.getPago(), tasa);
 
			}
 
			
			
			
		}
		
		
	}
	
	
}
