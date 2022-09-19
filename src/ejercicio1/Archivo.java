package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Archivo {

	private String ruta;

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) { this.ruta = ruta; }

	public boolean existe() {
		File archivo = new File(ruta); 
		if(archivo.exists()) return true;
		return false;
	}
	
	public boolean creaArchivo() {

		FileWriter escritura;
		try {
			escritura = new FileWriter(ruta, true);
			escritura.write("");
			escritura.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
			
	}
	
	public void escribe_lineas(String frase) {
		try 
		{	
			FileWriter entrada = new FileWriter(ruta, true);
			BufferedWriter miBuffer = new BufferedWriter(entrada);
			miBuffer.write(frase);
			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void lee_lineas() {
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
		   String linea = "";
			while (linea != null) {
				System.out.println(linea);
				linea = miBuffer.readLine();
			}
			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
		}
	}
	
	public List<Persona> devolverlista() {
		FileReader entrada;
		List<Persona> listaPersonas = new ArrayList<Persona>();
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
		   String linea = "";
			while (linea != null) {
				linea = miBuffer.readLine();
				if(linea!=null)
				{
					try {
						String [] vectorPersona = linea.split("[-]");

						if (datosValidos(vectorPersona)) {
							Persona p = new Persona(vectorPersona[0], vectorPersona[1], vectorPersona[2]);
							if (p.getDni() != 0 && !listaPersonas.contains(p)) listaPersonas.add(p);
						}
					}
					catch(ArrayIndexOutOfBoundsException e)
					{

					}
					
				}
			}
			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
		}
		return listaPersonas;
	}

	private boolean datosValidos(String [] vectorPersona){

		try {
			Persona.validarDNI(vectorPersona[2]);
			return true;
		} catch (DniInvalido e){
			return false;
		}

	}


}
