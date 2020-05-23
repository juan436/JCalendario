package Vista;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
 
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
 
import com.toedter.calendar.JDateChooser;
 
import Controlador.Controlador;

public class VFormulario extends JFrame implements IFormulario,ActionListener{

	JTextField nombre,ci,monto;
	JDateChooser fecha;
	JRadioButton contado,credito;
	JButton aceptar,limpiar,salir;
	JComboBox<String> meses;
	JLabel mm;
	
	public VFormulario(){
		
		super("Formulario");
		this.setSize(400,350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
			if(JOptionPane.showConfirmDialog(null, "Desea salir de la app","Salir",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
			System.exit(0);	
			}});
		
		Container cp = getContentPane();
		cp.setLayout(new GridBagLayout());
		GridBagConstraints restricciones = new GridBagConstraints();
		
		restricciones.gridx = 0;
		restricciones.gridy = 0;
		restricciones.gridheight = 1;
		restricciones.gridwidth = 4;
		restricciones.weightx = 1.1;
		restricciones.weighty = 1.1;
		JLabel titulo = new JLabel("RECIBO DE PAGO",JLabel.CENTER);
		titulo.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,18));
		cp.add(titulo,restricciones);
		
		//////////////////////////////////////
		
		restricciones.gridx = 0;
		restricciones.gridy = 1;
		restricciones.gridheight = 1;
		restricciones.gridwidth = 1;
		restricciones.anchor = GridBagConstraints.WEST;
		cp.add(new JLabel("NOMBRE"),restricciones);
		
	
		////////////////////////////////
		
		restricciones.gridx = 1;
		restricciones.gridy = 1;
		restricciones.gridheight = 1;
		restricciones.gridwidth = 3;
		restricciones.anchor = GridBagConstraints.CENTER;
		nombre = new JTextField(25);
		cp.add(nombre,restricciones);
		
		////////////////////////////////
				
		restricciones.gridx = 0;
		restricciones.gridy = 2;
		restricciones.gridheight = 1;
		restricciones.gridwidth = 1;
		restricciones.anchor = GridBagConstraints.WEST;
		cp.add(new JLabel("C.I:"),restricciones);
		
		////////////////////////////////
				
		restricciones.gridx = 1;
		restricciones.gridy = 2;
		restricciones.gridheight = 1;
		restricciones.gridwidth = 3;
		restricciones.anchor = GridBagConstraints.WEST;
		ci = new JTextField(15);
		cp.add(ci,restricciones);
		
		////////////////////////////////
				
		restricciones.gridx = 0;
		restricciones.gridy = 3;
		restricciones.gridheight = 1;
		restricciones.gridwidth = 1;
		restricciones.anchor = GridBagConstraints.WEST;
		cp.add(new JLabel("Fecha: "),restricciones);

		/////////////////////////////////////
		
		restricciones.gridx = 1;
		restricciones.gridy = 3;
		restricciones.gridheight = 1;
		restricciones.gridwidth = 1;
		restricciones.fill = GridBagConstraints.HORIZONTAL;
		fecha = new JDateChooser();
		fecha.setSize(new Dimension(100,20));
		cp.add(fecha,restricciones);
		

		/////////////////////////////////////
		
		restricciones.gridx = 0;
		restricciones.gridy = 4;
		restricciones.gridheight = 1;
		restricciones.gridwidth = 1;
		restricciones.anchor = GridBagConstraints.WEST;
		cp.add(new JLabel("Monto: "),restricciones);
		
		restricciones.gridx = 1;
		restricciones.gridy = 4;
		restricciones.gridheight = 1;
		restricciones.gridwidth = 1;
		monto = new JTextField(15);
		cp.add(monto,restricciones);
		
		JPanel pPago = new JPanel();
		pPago.setBorder(BorderFactory.createTitledBorder(" Forma de pago "));
		pPago.setLayout(new GridLayout(3,1));
		ButtonGroup bg = new ButtonGroup();
		contado = new JRadioButton("Contado");
		credito = new JRadioButton("Credito");
		contado.setSelected(true);
		bg.add(contado);
		bg.add(credito);
		pPago.add(contado);
		pPago.add(credito);
		
		JPanel pMeses = new JPanel();
		mm = new JLabel("Meses:");
		mm.setVisible(false);
		pMeses.add(mm);
		meses = new JComboBox<String>();
		meses.addItem("3");
		meses.addItem("6");
		meses.addItem("12");
		meses.addItem("24");
		meses.setEditable(false);
		meses.setVisible(false);
		pMeses.add(meses,JPanel.RIGHT_ALIGNMENT);
		pPago.add(pMeses);
		credito.addActionListener(this);
		contado.addActionListener(this);
		
		restricciones.gridx=2;
		restricciones.gridy=2;
		restricciones.gridheight=3;
		restricciones.gridwidth=2;
		cp.add(pPago,restricciones);
		
		//////////////////////////////////////////
		JPanel botones = new JPanel();
		aceptar= new  JButton("PROCESAR");
		limpiar= new JButton("LIMPIAR");
		salir =new JButton("SALIR");
		botones.add(aceptar); 
		botones.add(limpiar);
		botones.add(salir);
		aceptar.setActionCommand(IFormulario.ACEPTAR);
		limpiar.addActionListener(this);
		salir.addActionListener(this);
		
		restricciones.gridx = 0;
		restricciones.gridy = 5;
		restricciones.gridheight = 1;
		restricciones.gridwidth = 4;
		cp.add(botones,restricciones);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object boton = e.getSource();
		if(boton == credito)
			if(credito.isSelected()){
				mm.setVisible(true);
				meses.setVisible(true);
			}
		
		if(boton == contado)
			if(contado.isSelected()){
				mm.setVisible(false);
				meses.setVisible(false);
			}
		
		if(boton==salir){
			if(JOptionPane.showConfirmDialog(null, "Desea salir de la aplicacion","Salir",JOptionPane.YES_NO_OPTION)==0)
			{System.exit(0);}	
		}
	
	
		if(boton== limpiar) {
			nombre.setText("");
			ci.setText("");
			monto.setText("");
			contado.setSelected(true);	
			fecha.setCalendar(null);
		}
		
	
	
	}

	@Override
	public void setControlador(Controlador c) {
		// TODO Auto-generated method stub
		aceptar.addActionListener(c);
	}

	@Override
	public void arrancar() {
		// TODO Auto-generated method stub
		
		this.setVisible(true);
		
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre.getText();
	}

	@Override
	public String getCi() {
		// TODO Auto-generated method stub
		return ci.getText();
	}

	@Override
	public String getFecha() {
		// TODO Auto-generated method stub
		String fec;
		if(fecha.getCalendar()==null)
			fec="";
		else
		fec=String.valueOf(fecha.getCalendar().get(Calendar.DAY_OF_MONTH)) +"/"+String.valueOf(fecha.getCalendar().get(Calendar.MONTH)+1)+"/"+String.valueOf(fecha.getCalendar().get(Calendar.YEAR));
		return fec;
	}

	@Override
	public int getmeses() {
		// TODO Auto-generated method stub
		int mes=0;
		mes=Integer.parseInt(meses.getSelectedItem().toString());
		return mes;
	}

	@Override
	public String getPago() {
		// TODO Auto-generated method stub
		if(contado.isSelected())
			return "contado";
		else
		return "credito";
	}

	@Override
	public double getMonto() {
		// TODO Auto-generated method stub
		double monto=0.0;
		try {
			monto=Double.parseDouble(this.monto.getText());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Se espera un valor numerico", "Error de formato", JOptionPane.ERROR_MESSAGE);			
		}
		return monto;
	}

	
	
	
	
	
}
