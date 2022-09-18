package ejercicio1;

import javax.swing.*;

public class Persona {
    private int dni;
    private String nombre;
	private static String apellido;
    
    public Persona(){  }
    
    public Persona(int dni, String nombre, String apellido){ 
    	this.dni = dni;
    	this.nombre = nombre;
    	this.apellido = apellido;
    }
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    //MÉTODO QUE VERIFICA QUE EL DNI SOLO CONTENGA NÚMEROS
    public static boolean validarDNI(String entrada) throws DniInvalido {
        try {
            Integer.parseInt(entrada);
            return true;
        } catch (DniInvalido e) {
            throw new DniInvalido();
        }
    }

    public static boolean findMax(Persona p2) {
    	//mayor ser� true
    	String persona2 = p2.apellido;
    	//persona1 es menor
		if(apellido.compareTo(persona2)<0) return true;
		//persona2 es mayor o igual
		if(apellido.compareTo(persona2)>=0) return false;
	}
}
