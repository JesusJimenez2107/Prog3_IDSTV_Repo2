package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class AuthModel {
	 
 	public AuthModel() {
 		
 	}
 
 	public boolean login(String email, String contra) {
		
 		String url = "data/Users.txt";
 		
 		BufferedReader reader;

 		  try {
 		   reader = new BufferedReader(new FileReader(url));
 		   String line = reader.readLine();

 		   while (line != null) {
 		    
 			String [] data= line.split(",");   
 		    line = reader.readLine();
 		    
 		   if(email.equals(data[2])) {
				if(contra.equals(data[3])) {
 		   return true;
 		   }
 		   }
 		   }
 		   reader.close();
 		  } catch (IOException e) {
 		   e.printStackTrace();
 		  }
 		 
 		
 		return false;
 		
 	}
 	
 	public boolean registrarUsuario(String nombre, String apellido, String email, String contra, String repetirContra) {
 	    if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || contra.isEmpty() || repetirContra.isEmpty()) {
 	        JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
 	        return false;
 	    }

 	    if (!contra.equals(repetirContra)) {
 	        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
 	        return false;
 	    }

 	    if (email.contains(" ")) {
 	        JOptionPane.showMessageDialog(null, "El correo no debe contener espacios", "Error", JOptionPane.ERROR_MESSAGE);
 	        return false;
 	    }

 	    try {
 	        String ruta = "data/Users.txt";
 	        BufferedWriter writer = new BufferedWriter(new FileWriter(ruta, true));
 	        writer.newLine();
 	        writer.write(nombre + "," + apellido + "," + email + "," + contra);
 	        writer.close();

 	        JOptionPane.showMessageDialog(null, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
 	        return true;
 	    } catch (IOException e) {
 	        e.printStackTrace();
 	        JOptionPane.showMessageDialog(null, "Error al guardar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
 	        return false;
 	    }
 	}
 }