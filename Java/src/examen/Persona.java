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
public class Persona {
    //constante de sexo
    private final static char SEXO4DFT = 'H';
    
    //constantes de peso
    public final static int PESOIDEAL = -1;
    public final static int MENORPESOIDEAL = 0;
    public final static int MAYORPESOIDEAL = 1;
    
    //Atributos de persona
    private String nombre;
    private int edad;
    private String NSS;
    private char sexo;
    private float peso;
    private float altura;
    
    //Estableciendo valores
    public Persona( String nombre, int edad, char sexo, float peso, float altura ){
        this.nombre = nombre;
        this.edad = edad;
        generarNSS();
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        comprobarSexo();
    }
	//Obtener sexo
    public char obtenerSexo(){
        return sexo;
    }
    
    private double calcularIMC(){
        return peso/(Math.pow(altura, 2));
    }
    
    public int calcularIMCH(){
        double pesoPersona = calcularIMC();
        if( pesoPersona < 20)
            return MENORPESOIDEAL;
        else if( pesoPersona >= 20 && pesoPersona <= 25 )
            return PESOIDEAL;
        else
            return MAYORPESOIDEAL;       
    }
    
    public int calcularIMCM(){ 
        double pesoPersona = calcularIMC();
        if( pesoPersona < 19)
            return MENORPESOIDEAL;
        else if( pesoPersona >= 19 && pesoPersona <= 24 )
            return PESOIDEAL;
        else
            return MAYORPESOIDEAL;        
    }
    
    public boolean esMayorDeEdad(){
        return (edad >= 18);
    }
    
    private void comprobarSexo(){
        if( sexo != 'H' && sexo != 'M')
            this.sexo = SEXO4DFT;
    }
    
    public String toString(){
        return "Datos de la persona: \n"+
                "Nombre: "+ nombre+ "\n"+
                "Edad: "+ edad+ "\n"+
                "NSS: "+ NSS+"\n"+
                "Sexo: "+ sexo+ "\n"+
                "Peso: "+ peso+" Kg\n"+
                "Altura: "+altura+"\n";
    }
    
    public void generarNSS(){
        int min = 1000000;
        int max = 10000000;
        int numNSS = ((int)(Math.random()*max-min)+min);
        int letraPos = ((int) (Math.random()*27-1)+1);
        char letra = generarLetra(letraPos);
        NSS = Integer.toString( numNSS )+letra;     
    }
    
    private char generarLetra(int pos){
        char letras[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        return letras[pos];
    }
}
