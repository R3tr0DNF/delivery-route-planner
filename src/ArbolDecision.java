public class ArbolDecision {
    public String evaluarRuta(String clima, String prioridad, boolean congestion) {
        if (clima.equalsIgnoreCase("lluvia")) {
            return "Evitar rutas largas y de montaña";
        } else if (prioridad.equalsIgnoreCase("alta") && !congestion) {
            return "Elegir ruta más rápida sin importar distancia";
        } else if (congestion) {
            return "Evitar zonas céntricas por tráfico";
        } else {
            return "Ruta estándar optimizada";
        }
    }
}
