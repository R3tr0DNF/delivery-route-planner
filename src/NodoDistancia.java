public class NodoDistancia implements Comparable<NodoDistancia> {
    String nodo;
    double distancia;

    public NodoDistancia(String nodo, double distancia) {
        this.nodo = nodo;
        this.distancia = distancia;
    }

    public int compareTo(NodoDistancia otro) {
        return Double.compare(this.distancia, otro.distancia);
    }
}
