package views;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import controllers.AuthController;
import models.AuthModel; 

public class AuthView {
	
	public AuthView() { 
	}
	
	public void login()
	{
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("Login"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true); 
		
		Border border = BorderFactory.createLineBorder(Color.decode("#16404D"), 2);
		
		JPanel mipanel = new JPanel();
		mipanel.setBackground(Color.decode("#F2EFE7"));
		mipanel.setOpaque(true); //se necesita para poder ver el color
		mipanel.setSize(1000,600);
		mipanel.setLocation(0, 0);
		mipanel.setLayout(null);//permite poner los elementos donde quieras
		
		JLabel etiqueta1 = new JLabel("Bienvenido");
		etiqueta1.setSize(200, 30);
		etiqueta1.setLocation(105, 30);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setFont(new Font ("Verdana", Font.BOLD, 30));
		mipanel.add(etiqueta1);
		
		JLabel etiqueta2 = new JLabel("Ingrese su correo:");
		etiqueta2.setSize(200, 30);
		etiqueta2.setLocation(40, 130);
		etiqueta2.setFont(new Font ("Verdana", Font.BOLD, 16));
		mipanel.add(etiqueta2);
		
		ImageIcon imagen1 = new ImageIcon(this.getClass().getResource("/images/loginIcon.png"));
		JLabel iconoLog = new JLabel();
		iconoLog.setSize(30, 30);
		iconoLog.setLocation(40, 160);
		iconoLog.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		iconoLog.setOpaque(true);
		iconoLog.setBackground(Color.decode("#6b9394"));
		iconoLog.setBorder(border);
		mipanel.add(iconoLog);
		
		JTextField email = new JTextField();
		email.setSize(300, 30);
		email.setLocation(73, 160);
		email.setOpaque(true);
		email.setBackground(Color.decode("#A6CDC6"));
		email.setFont(new Font ("Verdana", Font.BOLD, 16));
		email.setBorder(border);
		mipanel.add(email);
		
		JLabel etiqueta3 = new JLabel("Contraseña:");
		etiqueta3.setSize(200, 30);
		etiqueta3.setLocation(40, 210);
		etiqueta3.setFont(new Font ("Verdana", Font.BOLD, 16));
		mipanel.add(etiqueta3);
		
		ImageIcon imagen2 = new ImageIcon(this.getClass().getResource("/images/passIcon.png"));
		JLabel iconoPass = new JLabel();
		iconoPass.setSize(30, 30);
		iconoPass.setLocation(40, 240);
		iconoPass.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		iconoPass.setOpaque(true);
		iconoPass.setBackground(Color.decode("#6b9394"));
		iconoPass.setBorder(border);
		mipanel.add(iconoPass);
		
		JPasswordField  contra = new JPasswordField ();
		contra.setSize(300, 30);
		contra.setLocation(73, 240);
		contra.setOpaque(true);
		contra.setBackground(Color.decode("#A6CDC6"));
		contra.setFont(new Font ("Verdana", Font.BOLD, 16));
		contra.setBorder(border);
		mipanel.add(contra);
		
		JCheckBox recuerdame = new JCheckBox("Recuerdame",false);
		recuerdame.setSize(120, 30);
		recuerdame.setLocation(36, 280);
		recuerdame.setFont(new Font ("Verdana", Font.BOLD, 12));
		mipanel.add(recuerdame);
		
		JLabel etiqueta4 = new JLabel("¿Olvidó su Contraseña?");
		etiqueta4.setSize(200, 30);
		etiqueta4.setLocation(230, 280);
		etiqueta4.setFont(new Font ("Verdana", Font.ITALIC, 12));
		mipanel.add(etiqueta4);
		
		JButton acceder = new JButton("ACCEDER") {
		    @Override
		    protected void paintComponent(Graphics g) {
		        Graphics2D g2 = (Graphics2D) g.create();
		        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		        // Dibuja el botón con bordes redondeados
		        g2.setColor(getBackground());
		        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Radio de borde 30px

		        super.paintComponent(g);
		        g2.dispose();
		    }
		};

		acceder.setSize(200, 40);
		acceder.setLocation(105, 350);
		acceder.setOpaque(false); 
		acceder.setContentAreaFilled(false);
		acceder.setBorderPainted(false);
		acceder.setBackground(Color.decode("#DDA853"));
		acceder.setHorizontalAlignment(JButton.CENTER);
		acceder.setFont(new Font("Verdana", Font.BOLD, 20));
		acceder.setForeground(Color.decode("#FBFBFB"));
		acceder.setBorder(border);

		acceder.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        acceder.setBackground(Color.decode("#16404d"));
		        acceder.repaint();
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        acceder.setBackground(Color.decode("#DDA853"));
		        acceder.repaint();
		    }
		   
		});
		
		
		acceder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean bandera1=false, bandera2=false;
				
				if(email.getText().equals("")) {
					email.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					email.setBorder(BorderFactory.createLineBorder(Color.green,3));
					bandera1=true;
				}
				
				if(new String(contra.getPassword()).equals("")) {
					contra.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					contra.setBorder(BorderFactory.createLineBorder(Color.green,3));
					bandera2=true;
				
				}
				if(bandera1&&bandera2) {
					
					AuthModel am = new AuthModel();
					boolean is_login = am.login(email.getText(), new String(contra.getPassword()));
					if(is_login) {
						
							JOptionPane.showMessageDialog(null, "Beinvenido de nuevo","hello",JOptionPane.WARNING_MESSAGE);
						
					}else {
						JOptionPane.showMessageDialog(null, "Contraseña o correo invalido","error",JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		mipanel.add(acceder);
		
		JButton regresarRegistro = new JButton("REGISTRARSE") {
		    @Override
		    protected void paintComponent(Graphics g) {
		        Graphics2D g2 = (Graphics2D) g.create();
		        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		        // Dibuja el botón con bordes redondeados
		        g2.setColor(getBackground());
		        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Radio de borde 30px

		        super.paintComponent(g);
		        g2.dispose();
		    }
		};

		regresarRegistro.setSize(200, 40);
		regresarRegistro.setLocation(105, 400);
		regresarRegistro.setOpaque(false); 
		regresarRegistro.setContentAreaFilled(false);
		regresarRegistro.setBorderPainted(false);
		regresarRegistro.setBackground(Color.decode("#DDA853"));
		regresarRegistro.setHorizontalAlignment(JButton.CENTER);
		regresarRegistro.setFont(new Font("Verdana", Font.BOLD, 20));
		regresarRegistro.setForeground(Color.decode("#FBFBFB"));
		regresarRegistro.setBorder(border);

		regresarRegistro.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	regresarRegistro.setBackground(Color.decode("#16404d"));
		    	regresarRegistro.repaint();
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	regresarRegistro.setBackground(Color.decode("#DDA853"));
		    	regresarRegistro.repaint();
		    }
		   
		});
		
		regresarRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
 				AuthView.this.register();			
			}
		});
		
		mipanel.add(regresarRegistro);
		
		ImageIcon imagen3 = new ImageIcon(this.getClass().getResource("/images/fondoLog.png"));
		JLabel fondoLog = new JLabel();
		fondoLog.setSize(500, 600);
		fondoLog.setLocation(500, 0);
		fondoLog.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(500, 600, Image.SCALE_SMOOTH)));
		mipanel.add(fondoLog);
		
		//return mipanel;
		
		
		ventana.add(mipanel);
		ventana.repaint();
		ventana.revalidate();
	}	
	
	public void register()
	{ 	
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("registro"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true); 
			
		Border border = BorderFactory.createLineBorder(Color.decode("#16404D"), 2);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.decode("#FBF5DD"));
		panel2.setOpaque(true); //se necesita para poder ver el color
		panel2.setSize(500,500);
		panel2.setLocation(0, 0);
		panel2.setLayout(null);//permite poner los elementos donde quieras
		
		JLabel etq1 = new JLabel("REGISTRO");
		etq1.setSize(200, 30);
		etq1.setLocation(150, 10);
		etq1.setHorizontalAlignment(JLabel.CENTER);
		etq1.setFont(new Font ("Verdana", Font.BOLD, 30));
		panel2.add(etq1);
		
		JLabel etq2 = new JLabel("");
		etq2.setSize(500, 30);
		etq2.setLocation(0, 60);
		etq2.setBackground(Color.decode("#16404D"));
		etq2.setOpaque(true);
		etq2.setHorizontalAlignment(JLabel.CENTER);
		etq2.setFont(new Font ("Verdana", Font.BOLD, 20));
		etq2.setForeground(Color.decode("#FBFBFB"));
		panel2.add(etq2);
		
		JLabel etq3 = new JLabel("Nombre de usuario:");
		etq3.setSize(200, 30);
		etq3.setLocation(40, 100);
		etq3.setFont(new Font ("Verdana", Font.BOLD, 16));
		panel2.add(etq3);
		
		JTextField nUsuario = new JTextField();
		nUsuario.setSize(300, 30);
		nUsuario.setLocation(38, 130);
		nUsuario.setOpaque(true);
		nUsuario.setBackground(Color.decode("#A6CDC6"));
		nUsuario.setFont(new Font ("Verdana", Font.BOLD, 16));
		nUsuario.setBorder(border);
		nUsuario.addActionListener(null);
		panel2.add(nUsuario);
		
		JLabel etq4 = new JLabel("Contraseña:");
		etq4.setSize(200, 30);
		etq4.setLocation(40, 170);
		etq4.setFont(new Font ("Verdana", Font.BOLD, 16));
		panel2.add(etq4);
		
		JTextField cUsuario = new JPasswordField();
		cUsuario.setSize(300, 30);
		cUsuario.setLocation(38, 200);
		cUsuario.setOpaque(true);
		cUsuario.setBackground(Color.decode("#A6CDC6"));
		cUsuario.setFont(new Font ("Verdana", Font.BOLD, 16));
		cUsuario.setBorder(border);
		panel2.add(cUsuario);
		
		JLabel etq5 = new JLabel("Repetir Contraseña:");
		etq5.setSize(200, 30);
		etq5.setLocation(40, 240);
		etq5.setFont(new Font ("Verdana", Font.BOLD, 16));
		panel2.add(etq5);
		
		JTextField repetirContra = new JTextField();
		repetirContra.setSize(300, 30);
		repetirContra.setLocation(38, 270);
		repetirContra.setOpaque(true);
		repetirContra.setBackground(Color.decode("#A6CDC6"));
		repetirContra.setFont(new Font ("Verdana", Font.BOLD, 16));
		repetirContra.setBorder(border);
		panel2.add(repetirContra);
		
		JLabel etq6 = new JLabel("Correo:");
		etq6.setSize(200, 30);
		etq6.setLocation(40, 300);
		etq6.setFont(new Font ("Verdana", Font.BOLD, 16));
		panel2.add(etq6);
		
		JTextField email = new  JTextField(); //field correo
		email.setSize(300, 30);
		email.setLocation(38, 340);
		email.setOpaque(true);
		email.setBackground(Color.decode("#A6CDC6"));
		email.setFont(new Font ("Verdana", Font.BOLD, 16));
		email.setBorder(border);
		panel2.add(email);
		
		JLabel etq7 = new JLabel("Nombre:");
		etq7.setSize(200, 30);
		etq7.setLocation(40, 380);
		etq7.setFont(new Font ("Verdana", Font.BOLD, 16));
		panel2.add(etq7);
		
		JTextField nombre = new  JTextField(); 
		nombre.setSize(300, 30);
		nombre.setLocation(38, 410);
		nombre.setOpaque(true);
		nombre.setBackground(Color.decode("#A6CDC6"));
		nombre.setFont(new Font ("Verdana", Font.BOLD, 16));
		nombre.setBorder(border);
		panel2.add(nombre);
		
		JLabel etq11 = new JLabel("Apellidos:");
		etq11.setSize(200, 30);
		etq11.setLocation(40, 450);
		etq11.setFont(new Font ("Verdana", Font.BOLD, 16));
		panel2.add(etq11);
		
		JTextField apellido = new  JTextField(); 
		apellido.setSize(300, 30);
		apellido.setLocation(38, 480);
		apellido.setOpaque(true);
		apellido.setBackground(Color.decode("#A6CDC6"));
		apellido.setFont(new Font ("Verdana", Font.BOLD, 16));
		apellido.setBorder(border);
		panel2.add(apellido);
		
		JLabel etq8 = new JLabel("Empresa:");
		etq8.setSize(200, 30);
		etq8.setLocation(40, 520);
		etq8.setFont(new Font ("Verdana", Font.BOLD, 16));
		panel2.add(etq8);
		
		JTextField empresa = new  JTextField(); 
		empresa.setSize(300, 30);
		empresa.setLocation(38, 550);
		empresa.setOpaque(true);
		empresa.setBackground(Color.decode("#A6CDC6"));
		empresa.setFont(new Font ("Verdana", Font.BOLD, 16));
		empresa.setBorder(border);
		panel2.add(empresa);
		
		JLabel etq12 = new JLabel("Ámbito de la empresa:");
		etq12.setSize(200, 30);
		etq12.setLocation(40, 590);
		etq12.setFont(new Font ("Verdana", Font.BOLD, 16));
		panel2.add(etq12);
		
		String[] opciones = {"Tecnología", "Salud", "Educación", "Comercio", "Otro"};
		JComboBox<String> colonias = new JComboBox<>(opciones);
		colonias.setSize(200, 30);
		colonias.setLocation(40, 620);
		colonias.setFont(new Font ("Verdana", Font.BOLD, 14));
		panel2.add(colonias);
		
		JLabel etq10 = new JLabel("Puesto:");
		etq10.setSize(350, 30);
		etq10.setLocation(40, 660);
		etq10.setFont(new Font ("Verdana", Font.BOLD, 16));
		panel2.add(etq10);
		
		JTextField puesto = new  JTextField(); 
		puesto.setSize(300, 30);
		puesto.setLocation(38, 690);
		puesto.setOpaque(true);
		puesto.setBackground(Color.decode("#A6CDC6"));
		puesto.setFont(new Font ("Verdana", Font.BOLD, 16));
		puesto.setBorder(border);
		panel2.add(puesto);
		
		
		JButton  confirmar = new JButton ("Crear Cuenta");
		confirmar.setSize(200, 40);
		confirmar.setLocation(20, 730);
		confirmar.setOpaque(true);
		confirmar.setBackground(Color.decode("#DDA853"));
		confirmar.setHorizontalAlignment(JButton.CENTER);
		confirmar.setFont(new Font ("Verdana", Font.BOLD, 20));
		
		confirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String usuario = nUsuario.getText();
		        String contra = cUsuario.getText();
		        String repetir = repetirContra.getText();
		        String correo = email.getText();
		        String nombreTxt = nombre.getText();
		        String apellidoTxt = apellido.getText();
			
				if(nUsuario.getText().equals("")) {
					nUsuario.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					nUsuario.setBorder(BorderFactory.createLineBorder(Color.green,3));
				}
				
				if(cUsuario.getText().equals("")) {
					cUsuario.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					cUsuario.setBorder(BorderFactory.createLineBorder(Color.green,3));
				}
				
				if(repetirContra.getText().equals("")) {
					repetirContra.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					repetirContra.setBorder(BorderFactory.createLineBorder(Color.green,3));
				}
				
				if(email.getText().equals("")) {
					email.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					email.setBorder(BorderFactory.createLineBorder(Color.green,3));
				}
				
				if(nombre.getText().equals("")) {
					nombre.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					nombre.setBorder(BorderFactory.createLineBorder(Color.green,3));
				}
				
				if(apellido.getText().equals("")) {
					apellido.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					apellido.setBorder(BorderFactory.createLineBorder(Color.green,3));
				}
				
				if(empresa.getText().equals("")) {
					empresa.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					empresa.setBorder(BorderFactory.createLineBorder(Color.green,3));
				}
				
				if(puesto.getText().equals("")) {
					puesto.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}else {
					puesto.setBorder(BorderFactory.createLineBorder(Color.green,3));
				}
				
				 AuthModel modelo = new AuthModel();
			        boolean registrado = modelo.registrarUsuario(nombreTxt, apellidoTxt, correo, contra, repetir);

			        if (registrado) {
			            ventana.dispose(); 
			            login();
			        }
			}
		});

		panel2.add(confirmar);
		
		JButton  irLogin = new JButton ("Regresar");
		irLogin.setSize(200, 40);
		irLogin.setLocation(250, 730);
		irLogin.setOpaque(true);
		irLogin.setBackground(Color.decode("#DDA853"));
		irLogin.setHorizontalAlignment(JButton.CENTER);
		irLogin.setFont(new Font ("Verdana", Font.BOLD, 20));
		irLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				ventana.dispose();
 				AuthView.this.login();
			}
		});
		panel2.add(irLogin);
		
		ImageIcon imagen3 = new ImageIcon(this.getClass().getResource("/images/fondoLog.png"));
		JLabel fondoLog = new JLabel();
		fondoLog.setSize(700, 800);
		fondoLog.setLocation(500, 0);
		fondoLog.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(700, 800, Image.SCALE_SMOOTH)));
		panel2.add(fondoLog);
		
		ventana.add(panel2);
		ventana.repaint();
		ventana.revalidate();
		
	}
	
	public void forgot()
	{ 
	}

}