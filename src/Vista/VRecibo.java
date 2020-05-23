package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VRecibo extends JFrame {
	public VRecibo(String nombre, String ci, String fecha, double monto, int meses, double cuota, double intereses, double total, String pago, double porcentaje) {
	
		super("Recibo");
		this.setVisible(true);
		this.setSize(450, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container cp= getContentPane();
		cp.setLayout(new BorderLayout());
		JLabel titulo= new JLabel("RECIBO POR: "+ monto+" Bs.", JLabel.CENTER);
		titulo.setFont(new Font("Arial",Font.BOLD+Font.ITALIC, 18));
		titulo.setForeground(new Color(0, 155, 0));
		cp.add(titulo, BorderLayout.NORTH);
		
		JPanel Pcontenido= new JPanel();
		Pcontenido.setLayout(new FlowLayout(0));
		Pcontenido.add(new JLabel("Por medio se hace entrega al ciudadano(a) ")) ;
		JLabel nom = new JLabel(nombre+", ");
		nom.setFont(new Font("Arial", Font.ITALIC, 12));
		Pcontenido.add(nom) ;
		
		Pcontenido.add(new JLabel(" el monto indicado en el recibo, la forma de pago es, ")) ;
		JLabel pag = new JLabel(pago+", ");
		pag.setFont(new Font("Arial", Font.ITALIC, 12));
		Pcontenido.add(pag) ;
		
		Pcontenido.add(new JLabel(" dividido en ")) ;
		JLabel mes = new JLabel(meses+" cuotas, ");
		mes.setFont(new Font("Arial", Font.ITALIC, 12));
		Pcontenido.add(mes);
		
		Pcontenido.add(new JLabel(" con un porcentaje de interes y gastos administrativos de, ")) ;
		JLabel porc = new JLabel(porcentaje+"%, ");
		porc.setFont(new Font("Arial", Font.ITALIC, 12));
		Pcontenido.add(porc) ;
		
 
		Pcontenido.add(new JLabel(" el monto de las cuotas es de, ")) ;
		JLabel cuo = new JLabel(cuota +"Bs, ");
		cuo.setFont(new Font("Arial", Font.ITALIC, 12));
		Pcontenido.add(cuo) ;
		
		Pcontenido.add(new JLabel(" Total a cancelar: ")) ;
		JLabel tot = new JLabel(total +"Bs. ");
		tot.setFont(new Font("Arial", Font.ITALIC, 12));
		Pcontenido.add(tot) ;
				
		cp.add(Pcontenido, BorderLayout.CENTER);
		
		cp.add(new JLabel(" Firma Autorizada, en la fecha "+fecha),BorderLayout.SOUTH) ;
		
	}

}