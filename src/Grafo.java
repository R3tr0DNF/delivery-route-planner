import java.io.*;
import java.util.*;

public class Grafo {
    private Map<String, Map<String, Double>> listaAdyacencia;

    public Grafo() {
        listaAdyacencia = new HashMap<>();
    }

    public void agregarArista(String origen, String destino, double peso) {
        if (peso < 0) throw new IllegalArgumentException("Peso negativo no permitido");
        listaAdyacencia.putIfAbsent(origen, new HashMap<>());
        listaAdyacencia.putIfAbsent(destino, new HashMap<>());
        listaAdyacencia.get(origen).put(destino, peso);
    }

    public void cargarDesdeArchivo(String rutaArchivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        String lineaNodos = br.readLine();
        String lineaAristas = br.readLine();
        br.close();

        String[] nodos = lineaNodos.replace("nodos:", "").trim().split(",");
        Set<String> setNodos = new HashSet<>();
        for (String nodo : nodos) {
            nodo = nodo.trim();
            if (!setNodos.add(nodo)) throw new IllegalArgumentException("Nodo duplicado: " + nodo);
            listaAdyacencia.put(nodo, new HashMap<>());
        }

        String[] aristas = lineaAristas.replace("aristas:", "").trim().split(",");
        for (String arista : aristas) {
            String[] partes = arista.trim().split("-");
            agregarArista(partes[0], partes[1], Double.parseDouble(partes[2]));
        }
    }

    public Map<String, Map<String, Double>> getListaAdyacencia() {
        return listaAdyacencia;
    }

    public void imprimirGrafo() {
        for (String nodo : listaAdyacencia.keySet()) {
            System.out.println(nodo + " -> " + listaAdyacencia.get(nodo));
        }
    }

    public Set<String> obtenerNodos() {
        return listaAdyacencia.keySet();
    }
}
