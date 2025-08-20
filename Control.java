import java.util.ArrayList;
import java.util.Scanner;

public class Control {
        ArrayList<Instrumento> instrumentos;

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

    public void agregarInstrumento(Instrumento instrumento) {
        this.instrumentos.add(instrumento);
    }
}
