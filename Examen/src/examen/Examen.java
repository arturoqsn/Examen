/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

/**
 *
 * @author Arturo
 */

import javax.swing.*;
public class Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
	// Solicitando datos
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
        int edad = Integer.parseInt(JOptionPane.showInputDialog(" Ingrese la edad"));
        char sexo = JOptionPane.showInputDialog("Ingrese el sexo ( H o M ) ").charAt(0);
        float peso = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el peso en Kg"));
        float altura = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la estatura en metros"));
        
	//Creando el objeto persona
        Persona person = new Persona( nombre, edad, sexo, peso, altura );
	//Indicador de peso
        indicadorPeso(person);
	//Indicador de edad
        indicadorEdad(person);
	//Imprimiendo el objeto
        System.out.println(person.toString());
    }
    
    public static void indicadorPeso(Persona p){
        if( p.obtenerSexo() == 'H'){
            switch( p.calcularIMCH()){
                case Persona.PESOIDEAL: System.out.println("--Persona masculina en su peso ideal--"); break;
                case Persona.MENORPESOIDEAL: System.out.println("--Persona masculina por debajo de su peso ideal--"); break;
                case Persona.MAYORPESOIDEAL: System.out.println("--Persona masculina en sobrepeso--"); break;
            }
        }else{
             switch( p.calcularIMCM()){
                case Persona.PESOIDEAL: System.out.println("--Persona femenina en su peso ideal--"); break;
                case Persona.MENORPESOIDEAL: System.out.println("--Persona femenina por debajo de su peso ideal--"); break;
                case Persona.MAYORPESOIDEAL: System.out.println("--Persona femenina en sobrepeso--"); break;
            }
        }
    }
    
    public static void indicadorEdad( Persona p){
        System.out.println( p.esMayorDeEdad() ? "**Es mayor de edad**" : "**Es menor de edad** ");
    }
    
    
    
}
