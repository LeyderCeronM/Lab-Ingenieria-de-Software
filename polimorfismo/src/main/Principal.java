
package main;

import figuras.*;
import java.util.ArrayList;
import java.util.List;

public class Principal {

   
    public static void main(String[] args) {
        
        Figure figura1 = new Square(2.0);
        Figure figura2 = new Triangle(4.2, 5.4);
        Figure figura3 = new Circle (3.0);
    
    
      // Lista de figuras
        List<Figure> figuras = new ArrayList<>();
        figuras.add(figura1);
        figuras.add(figura2);
        figuras.add(figura3);

      // Polimorfismo en acción
        for (Figure fig : figuras) {
          System.out.println("Figuara: "+ fig.getNombre());
          System.out.println("Area: " + fig.calcularArea());
          System.out.println("Perimetro: " + fig.calcularPerimetro());
          System.out.println("------------------------");
        }
    }
}
