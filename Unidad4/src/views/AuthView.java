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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
					if(email.getText().equals("jjimenez_23@alu.uabcs.mx")) {
						if(new String(contra.getPassword()).equals("contraseña")) {
							JOptionPane.showMessageDialog(null, "Beinvenido de nuevo","hello",JOptionPane.WARNING_MESSAGE);
						}
						else{
							JOptionPane.showMessageDialog(null, "Contraseña o correo invalido","error",JOptionPane.WARNING_MESSAGE);
						}
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
		System.out.println("Hola");
		JFrame ventana = new JFrame();
		
		ventana.setVisible(true);
		ventana.setSize(930, 600);
		ventana.setLocationRelativeTo(null); 
		ventana.setTitle("registro"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventana.setResizable(true); 
		
		
	}
	
	public void forgot()
	{ 
	}

}