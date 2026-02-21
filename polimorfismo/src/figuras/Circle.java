
package figuras;


public class Circle extends Figure{
    private double radio;
    

    public Circle(double radio) {
        this.radio = radio;
    }
    
    
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
    @Override
    public String getNombre() {
    return "Circulo";
}
}
