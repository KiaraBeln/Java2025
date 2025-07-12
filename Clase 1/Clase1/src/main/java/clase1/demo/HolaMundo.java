package clase1.demo;

public class HolaMundo {
public static void main(String[] args) {
    //Tipo Comentario de linea
    System.out.println("¡Hola, Mundo!");
   /* Es un comentario en bloque */
    System.out.println("¡Hola, Mundo! desde la clase 1!");
  
    int numero = 122;//claración de una variable entera
    System.out.println("El número es: " + numero); // Imprime el valor de la variable

    boolean esVerdadero = true; // Declaración de una variable booleana
    System.out.println("¿Es verdadero? " + esVerdadero); // Imprime el valor de la variable'=

    char letra = 'A'; // Declaración de una variable de tipo carácter
    System.out.println("La letra es: " + letra); // Imprime el valor de la variable

    var esVariable = true; // Declaración de una variable con tipo inferido
    System.out.println("¿Es variable? " + esVariable); // Imprime el valor

    System.out.println("Hola el numero elegido es "+ numero +" es correcto? " + esVariable);

    String mensaje = String.format( "Hola el numero %d "
            +"es real: %b", numero, esVariable);  

    System.out.println(mensaje); // Imprime el mensaje formateado 

    String saludo = String.valueOf(numero) ;

    System .out.println("El saludo es: " + saludo); // Imprime el saludo convertido a String

    int valor = 10;
   
    System.out.println("El valor es: " + valor); // Imprime el valor
    
    Integer valor2= Integer.parseInt(saludo); // Convierte el saludo a un entero
    
    System.out.println("El valor2 es: " + valor2); // Imprime el
//Arreglos 
    int[] numeros = {1, 2, 3, 4, 5}; // Declaración de un arreglo de enteros
    System.out.println("El primer número del arreglo es: " + numeros[0]); // Imprime el primer elemento del arreglo

    String[] nombres = {"Juan", "María", "Pedro"}; // Declaración de un arreglo de cadenas
    System.out.println("El primer nombre del arreglo es: " + nombres[0]); // Imprime el primer elemento del arreglo

    // Estructuras de control
    if (numero > 100) {
        System.out.println("El número es mayor que 100");
    } else {
        System.out.println("El número es menor o igual a 100");
    }

    for (int i = 0; i < numeros.length; i++) {
        System.out.println("Número en la posición " + i + ": " + numeros[i]);
    }

    for (String nombre : nombres) {
        System.out.println("Nombre: " + nombre);
    }
//For Ech utilizar arreglos como ciclos 
    int [] numeros2 = {10, 20, 30, 40, 50}; // Declaración de un arreglo de enteros
    for (int numeroActual : numeros2) {
        System.out.println("Número actual: " + numeroActual);
    }
//For normal 
   for(int i=0; i < numeros2.length; i++) {
        System.out.println("Número en la posición " + i + ": " + numeros2[i]);
    }
 
  }
}
