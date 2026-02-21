
package figuras;


public class Square extends Figure{
   private double lado;

    public Square(double lado) {
        this.lado = lado;
    }
    
    @Override
    public double calcularArea(){
        return lado*lado;
    }
    
    @Override
    public double calcularPerimetro(){
        return lado*4;
    }
    @Override
public String getNombre() {
    return "Cuadrado";
}
    
}
