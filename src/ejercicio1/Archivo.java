package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Archivo {

	//Si en la variable ruta recibe solo un nombre de un archivo, entonces crea ese archivo dentro del proyecto
	//Si en ruta recibe una ruta absoluta, entonces lo crea en esa ruta
	
	private String ruta;

	public boolean existe()
	{
		File archivo = new File(ruta); 
		if(archivo.exists())
		      return true;
		return false;
	}
	
	public boolean creaArchivo()
	{
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
	

	public void escribe_letra_x_letra(String frase) {
		try {
			FileWriter fw = new FileWriter(ruta, true);
	
			for (int i = 0; i < frase.length(); i++) {
					fw.write(frase.charAt(i));
				}
			//fw.write(33); //Puede escribir caracteres
			//fw.write(frase); //Puede escribir frases enteras			
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void lee_letra_x_letra() {

		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			int c = entrada.read(); //Lee el primer caracter
			while (c != -1) 
			{
				char letra = (char) c;
				System.out.println(letra);
				c = entrada.read();
			}
			entrada.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
	
	public List devolverlista() {
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
						Persona p = new Persona( vectorPersona[0],vectorPersona[1],vectorPersona[2]);
						if(p.getDni()!=0 && !listaPersonas.contains(p))
						listaPersonas.add(p);
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
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
}