import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
            return "";
        }

        public String eliminarPorClave(int clave) {
            String cadena = "";
            for(Instrumento instrumento : instrumentos) {
                if(clave==instrumento.getClave()){
                    cadena = cadena + instrumento.toString();
                }
            }
            instrumentos.removeIf(i -> i.getClave()==clave);
            return cadena;
        }

        public String ordenarPorClave() {
            String cadena = "";
            ArrayList<Instrumento> instrumentosOrdenados = instrumentos.stream()
                    .sorted((i1, i2) -> Integer.compare(i1.getClave(), i2.getClave()))
                    .collect(Collectors.toCollection(ArrayList::new)
                    );
            for(Instrumento instrumento : instrumentosOrdenados) {
                cadena = cadena + instrumento.toString();
            }
            return cadena;
        }

        public String ordenarPorPrimerAutor() {
            String cadena = "";
            ArrayList<Instrumento> instrumentosOrdenados = new ArrayList<>();
            for(String autor : autores) {
                for(Instrumento instrumento : instrumentos) {
                    if(instrumento.getAutor().equals(autor)) {
                        instrumentosOrdenados.add(instrumento);
                    }
                }
            }
            for(Instrumento instrumento : instrumentosOrdenados) {
                cadena = cadena + instrumento.toString();
            }
            return cadena;
        }

        public boolean esClaveValida(int clave) {
            for(Instrumento instrumento : instrumentos) {
                if(instrumento.getClave() == clave){
                    return true;
                }
            }
            return false;
        }

        public String guardarEnArchivo() {
            String archivo = "ArchivoConsultas.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                writer.write("Autor,Clave,Tipo,Condicion,Evaluacion");
                writer.newLine();
                for(Instrumento i : instrumentos) {
                    writer.write("Autor: " + i.getAutor() + ", Clave: " + i.getClave() +
                            ", Tipo: " + i.getTipo() + ", Condiciones: " + i.getTipoCondicion() +
                            " , Evaluacion: " + i.getEvaluacion());
                    writer.newLine();
                }
                return "Archivo guardado en " + archivo;

            } catch (IOException e) {
                return "Error al guardar archivo " + archivo;
            }
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
