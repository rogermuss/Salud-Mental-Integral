public class Instrumento {
        String autor;
        int clave;
        String tipo;
        String tipoCondicion;
        boolean evaluacion;


        public Instrumento(String autor, int clave, String tipo, String tipoCondicion, boolean evaluacion) {
            this.autor = autor;
            this.clave = clave;
            this.tipo = tipo;
            this.tipoCondicion = tipoCondicion;
            this.evaluacion = evaluacion;
        }

        public int getClave() {
            return clave;
        }

        public void setClave(int clave) {
            this.clave = clave;
        }

        public String getAutor() {
            return autor;
        }
        public void setAutor(String autor) {
            this.autor = autor;
        }
        public String getTipo() {
            return tipo;
        }
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
        public String getTipoCondicion() {
            return tipoCondicion;
        }
        public void setTipoCondicion(String tipoCondicion) {
            this.tipoCondicion = tipoCondicion;
        }
        public boolean getEvaluacion() {
            return evaluacion;
        }
        public void setEvaluacion(boolean evaluacion) {
            this.evaluacion = evaluacion;
        }

        public String toString() {
            return "Autor: " + autor + "\nClave: " + clave + "\nTipo: " + tipo + "\nCondiciones: " + tipoCondicion +
                    "\nEvaluacion: " + evaluacion + "\n\n";
        }
}
