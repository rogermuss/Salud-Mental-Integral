import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Control {
        private ArrayList<Instrumento> instrumentos;
        private HashSet<String> autores = new HashSet<>();
        Control() {
            instrumentos = new ArrayList<>();

        }

        public String consultarTodos(){
            String cadena = "";
            instrumentos.forEach(i -> System.out.println(i));
            return cadena;
        }
        public String consultarPorEvaluacion(boolean evaluacion) {
            String cadena = "";
            for(Instrumento instrumento : instrumentos) {
                if(instrumento.getEvaluacion() == evaluacion){
                    cadena = cadena + instrumento.toString();
                }
            }
            return cadena;
        }

        public String consultarPorAutor(String autor) {
            String cadena = "";
            for(Instrumento instrumento : instrumentos) {
                if(autor.equals(instrumento.getAutor())){
                    cadena = cadena + instrumento.toString();
                }
            }
            return cadena;
        }

        public String consultarPorTipo(String tipo) {
            String cadena = "";
            for(Instrumento instrumento : instrumentos) {
                if(tipo.equals(instrumento.getTipo())) {
                    cadena = cadena + instrumento.toString();
                }
            }
            return cadena;
        }

        public String consultarPorTipoCondicion(String tipoCondicion) {
            String cadena = "";
            for(Instrumento instrumento : instrumentos) {
                if(instrumento.getTipoCondicion().equals(tipoCondicion)) {
                    cadena = cadena + instrumento.toString();
                }
            }
            return cadena;
        }

        public String consultarPorTipoEvaluacion(String tipoEvaluacion) {
            String cadena = "";
            for(Instrumento instrumento : instrumentos) {
                if(tipoEvaluacion.equals(instrumento.getTipo())) {
                    cadena = cadena + instrumento.toString();
                }
            }
            return cadena;
        }

        public String filtrarPorClave(int clave) {
            for(Instrumento instrumento : instrumentos) {
               if(clave==instrumento.getClave()){
                   return instrumento.toString();
               }
            }
            return null;
        }

        public String eliminarPorClave(int clave) {
            String cadena = "";
            instrumentos.removeIf(i -> i.getClave()==clave);
            for(Instrumento instrumento : instrumentos) {
                if(clave==instrumento.getClave()){
                    cadena = cadena + instrumento.toString();
                }
            }
            return cadena;
        }

        public ArrayList<Instrumento> ordenarPorClave() {
            ArrayList<Instrumento> instrumentosOrdenados = instrumentos.stream()
                    .sorted((i1, i2) -> Integer.compare(i1.getClave(), i2.getClave()))
                    .collect(Collectors.toCollection(ArrayList::new)
                    );
            return instrumentosOrdenados;
        }

        public ArrayList<Instrumento> ordenarPorPrimerAutor() {
            ArrayList<Instrumento> instrumentosOrdenados = new ArrayList<>();
            for(String autor : autores) {
                for(Instrumento instrumento : instrumentos) {
                    if(instrumento.getAutor().equals(autor)) {
                        instrumentosOrdenados.add(instrumento);
                    }
                }
            }
            return instrumentosOrdenados;
        }

        public boolean esClaveValida(int clave) {
            for(Instrumento instrumento : instrumentos) {
                if(instrumento.getClave() == clave){
                    return true;
                }
            }
            return false;
        }

    public void setAutores(String autor) {
            if(!autores.contains(autor)){
                autores.add(autor);
            }
    }

    public void agregarInstrumento(Instrumento instrumento) {
        this.instrumentos.add(instrumento);
    }
}
