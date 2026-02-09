
package figuras;


public class Triangle extends Figure {
    private double base, altura;
    
    public Triangle(double base, double altura){
        this.base = base;
        this.altura = altura;
    
    }
    
    @Override
    public double calcularArea(){
        return (base*altura)/2;
    }
    
    @Override
    public double calcularPerimetro() {
        double lado = Math.sqrt(Math.pow(base / 2, 2) + Math.pow(altura, 2));
        return base + 2 * lado;
    }
}
