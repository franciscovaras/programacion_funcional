package figuras;

public class Rectangulo implements FiguraGeometrica
{
    private int base, altura;

    public Rectangulo (int base, int altura)
    {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea()
    {
        return base * altura;
    }

    @Override
    public double calcularPerimetro()
    {
        return 2 * base + 2 * altura;
    }
}
