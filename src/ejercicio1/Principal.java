package ejercicio1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

import ejemplo1_Equals.Persona;
import ejemplo4_HashSet.Libro;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.io.BufferedReader;


public class Principal {

    public static void main(String[] args) {

        //Instancia Persona, pide DNI y lo valida.
        // Si est√° ok lo pasa a int, lo setea y muestra. Sino muestra cartel de error.
        Persona persona = new Persona();
        /*String dni = JOptionPane.showInputDialog("Ingrese DNI: ");

        if ( Persona.validarDNI(dni) ) {
            persona.setDni(Integer.parseInt(dni));
            System.out.println(persona.getDni());
        }
        */
        
        FileReader entrada;
        ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		try {
		   entrada = new FileReader("./files/Personas.txt");
		   BufferedReader miBuffer = new BufferedReader(entrada);
			
		   String linea = "";
		   while(true) {
			    linea = miBuffer.readLine();
			    System.out.println(linea);
			    if(linea == null) {
			    	break;
			    }
			    String[] user = linea.split("-");
				String dni = user[2];
				System.out.println(dni);
				//verifica que el dni sea v·lido
		        try {
		        	if(Persona.validarDNI(dni))
		        	{
		        		listaPersonas.add(new Persona(Integer.parseInt(user[2]),user[0],user[1]));
		        	}
		        }
				catch (Exception e) {
				}
			}
		   	System.out.println("llego hasta el final");
			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
		}
		
	  /*Iterator<Persona> it = listaPersonas.iterator();
	  Iterator<Persona> it2 = listaPersonas.iterator();
	  while(it.hasNext())
	  {
		  Persona p1 = (Persona)it;
		  while(it2.hasNext()) {
			  boolean tipo = Persona.findMax(it2.next());
			  System.out.println(tipo);
			  System.out.println(p1);
		  }
	  }		  
	  }*/

}
    }
