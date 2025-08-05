import java.io.FileWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Grafo grafo = new Grafo();
        grafo.cargarDesdeArchivo("resources/rutas_cayambe.txt");

        System.out.println("📍 Mapa de rutas:");
        grafo.imprimirGrafo();

        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese punto de origen: ");
        String origen = sc.nextLine();

        System.out.print("Ingrese punto de destino: ");
        String destino = sc.nextLine();

        System.out.print("¿Clima (soleado/lluvia)? ");
        String clima = sc.nextLine();

        System.out.print("¿Prioridad del paquete (alta/baja)? ");
        String prioridad = sc.nextLine();

        System.out.print("¿Hay congestión vehicular (true/false)? ");
        boolean congestion = Boolean.parseBoolean(sc.nextLine());

        ArbolDecision decision = new ArbolDecision();
        String decisionRuta = decision.evaluarRuta(clima, prioridad, congestion);
        System.out.println("🔍 Sugerencia de entrega: " + decisionRuta);

        AlgoritmosRuta algoritmo = new AlgoritmosRuta(grafo);
        Map<String, String> predecesores = new HashMap<>();
        Map<String, Double> distancias = algoritmo.dijkstra(origen, predecesores);



        List<String> ruta = algoritmo.reconstruirRuta(origen, destino, predecesores);
        double total = distancias.getOrDefault(destino, Double.POSITIVE_INFINITY);

        System.out.println("\n🛣 Ruta recomendada: " + ruta);
        System.out.println("🧭 Distancia total: " + total + " km");

        FileWriter writer = new FileWriter("reporte_rutas.txt");
        writer.write("Ruta recomendada desde " + origen + " a " + destino + ":\n");
        writer.write("Secuencia: " + ruta + "\n");
        writer.write("Distancia total: " + total + " km\n");
        writer.write("Condiciones externas: clima=" + clima + ", prioridad=" + prioridad + ", congestion=" + congestion + "\n");
        writer.write("Sugerencia del árbol de decisión: " + decisionRuta + "\n");
        writer.close();

        System.out.println("📄 Reporte guardado en reporte_rutas.txt ✅");
    }
}
