package ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;


public class Principal {

    public static void main(String[] args) {

		/*             PARTE A     */
        //Instancia Persona, pide DNI y lo valida.
        // Si está ok lo pasa a int, lo setea y muestra. Sino muestra cartel de error.

		System.out.println("Punto A: Validación de DNI: ");

        Persona persona = new Persona();
		String dni = JOptionPane.showInputDialog("Ingrese DNI: ");

		try {
			if ( Persona.validarDNI(dni) ) {
			    persona.setDni(Integer.parseInt(dni));
			    System.out.println(persona.getDni());
			}
		} catch (DniInvalido e) {
			e.printStackTrace();
			//System.out.println("El dni no es valido!");
		}


		/*             PARTE B     */
		System.out.println(" \n ---------------------------------- \n");
		System.out.println("Punto B: Lee archivo Personas.txt y lo pasa a una lista sin duplicados y ordenado: \n");

		List<Persona> listaPersonas = new ArrayList<Persona>();
        Archivo archivo = new Archivo();
		archivo.setRuta("./Personas.txt");

		if(archivo.existe()) {

			listaPersonas = archivo.devolverlista();

		} else {
			System.out.println("No existe archivo");
		}

		Collections.sort(listaPersonas,new SortApellidos());


        //Punto C: pasar la informacion a un archivo llamado Resultado.txt
        for(Persona x : listaPersonas)
        {
        	System.out.println(x.toString());
        	archivo.setRuta("./Resultado.txt");
        	archivo.escribe_lineas(x.toString()+ "\n");
        }
    }
}
