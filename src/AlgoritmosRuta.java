import java.util.*;

public class AlgoritmosRuta {
    private Grafo grafo;

    public AlgoritmosRuta(Grafo grafo) {
        this.grafo = grafo;
    }

    public Map<String, Double> dijkstra(String origen, Map<String, String> predecesores) {
        Map<String, Double> dist = new HashMap<>();
        PriorityQueue<NodoDistancia> cola = new PriorityQueue<>();
        Set<String> visitados = new HashSet<>();

        for (String nodo : grafo.getListaAdyacencia().keySet())
            dist.put(nodo, Double.POSITIVE_INFINITY);

        dist.put(origen, 0.0);
        cola.add(new NodoDistancia(origen, 0.0));

        while (!cola.isEmpty()) {
            NodoDistancia actual = cola.poll();
            if (visitados.contains(actual.nodo)) continue;
            visitados.add(actual.nodo);

            Map<String, Double> vecinos = grafo.getListaAdyacencia().getOrDefault(actual.nodo, new HashMap<>());
            for (Map.Entry<String, Double> entry : vecinos.entrySet()) {
                String vecino = entry.getKey();
                double peso = entry.getValue();
                if (dist.get(actual.nodo) + peso < dist.get(vecino)) {
                    dist.put(vecino, dist.get(actual.nodo) + peso);
                    predecesores.put(vecino, actual.nodo);
                    cola.add(new NodoDistancia(vecino, dist.get(vecino)));
                }
            }
        }
        return dist;
    }

    public List<String> reconstruirRuta(String origen, String destino, Map<String, String> predecesores) {
        LinkedList<String> ruta = new LinkedList<>();
        String actual = destino;
        while (actual != null && !actual.equals(origen)) {
            ruta.addFirst(actual);
            actual = predecesores.get(actual);
        }
        if (actual != null) ruta.addFirst(origen);
        return ruta;
    }

    public double[][] floydWarshall(List<String> nodos) {
        int n = nodos.size();
        double[][] dist = new double[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Double.POSITIVE_INFINITY);

        for (int i = 0; i < n; i++)
            dist[i][i] = 0;

        for (int i = 0; i < n; i++) {
            String u = nodos.get(i);
            Map<String, Double> vecinos = grafo.getListaAdyacencia().get(u);
            for (Map.Entry<String, Double> v : vecinos.entrySet()) {
                int j = nodos.indexOf(v.getKey());
                dist[i][j] = v.getValue();
            }
        }

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        return dist;
    }
}
