
package pruebas;

import figuras.*;

public class TestFiguras {

    public static void main(String[] args) {

        testCuadrado();
        testCirculo();
        testTriangulo();

        System.out.println("Todas las pruebas pasaron correctamente");
    }

    static void testCuadrado() {
        Figure f = new Square(2.0);

        if (f.calcularArea() != 4.0) {
            throw new RuntimeException("Error en área del cuadrado");
        }

        if (f.calcularPerimetro() != 8.0) {
            throw new RuntimeException("Error en perímetro del cuadrado");
        }
    }

    static void testCirculo() {
        Figure f = new Circle(3.0);
        double esperado = Math.PI * 9;

        if (Math.abs(f.calcularArea() - esperado) > 0.0001) {
            throw new RuntimeException("Error en área del círculo");
        }
    }

    static void testTriangulo() {
        Figure f = new Triangle(4.0, 6.0);

        if (f.calcularArea() != 12.0) {
            throw new RuntimeException("Error en área del triángulo");
        }
    }
}

