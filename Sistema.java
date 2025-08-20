import java.lang.classfile.instruction.SwitchCase;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args){
        int opc;
        int claveActual = 1;
        Control control =  new Control();
        ArrayList<String> autores;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Agregar Instrumento\n");
            System.out.println("2. Consultar por Autor\n");
            System.out.println("3. Mostrar por clave\n");
            System.out.println("4. Consultar por Tipo de Instrumento\n");
            System.out.println("5. Consultar por Evaluacion\n");
            System.out.println("6. Consultar por Tipo de Condicion\n");
            System.out.println("7. Eliminar Instrumento por Clave\n");
            System.out.println("8. Mostrar a partir del Primer Autor\n");
            System.out.println("9. Salir\n");
            System.out.println("Que desea seleccionar? ");
            sc.nextLine();
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    Scanner teclado = new Scanner(System.in);
                    String autor;
                    do {
                        System.out.print("Introduzca el nombre del autor: ");
                        autor = teclado.nextLine().trim();
                        if (autor.isEmpty()) {
                            System.out.println("El nombre del autor no puede estar vacío.");
                        }
                    } while (autor.isEmpty());

                    String tipo;
                    do {
                        System.out.print("Introduzca el tipo de instrumento: ");
                        tipo = teclado.nextLine().trim();
                        if (tipo.isEmpty()) {
                            System.out.println("El tipo de instrumento no puede estar vacío.");
                        }
                    } while (tipo.isEmpty());

                    String nombreInstrumento;
                    do {
                        System.out.print("Introduzca el nombre del instrumento: ");
                        nombreInstrumento = teclado.nextLine().trim();
                        if (nombreInstrumento.isEmpty()) {
                            System.out.println("El nombre del instrumento no puede estar vacío.");
                        }
                    } while (nombreInstrumento.isEmpty());

                    Boolean evaluacion = null;
                    while (evaluacion == null) {
                        System.out.print("Introduzca el tipo de evaluación (true/false): ");
                        if (teclado.hasNextBoolean()) {
                            evaluacion = teclado.nextBoolean();
                        } else {
                            System.out.println("Debe ingresar true o false.");
                            teclado.next(); // descartar entrada inválida
                        }
                    }

                    System.out.println("\nResumen:\n");
                    System.out.println("Autor: " + autor +"\n");
                    System.out.println("Tipo de instrumento: " + tipo+"\n");
                    System.out.println("Nombre instrumento: " + nombreInstrumento+"\n");
                    System.out.println("Evaluación: " + evaluacion+"\n");

                    Instrumento instrumento = new Instrumento(autor, claveActual, tipo, nombreInstrumento, evaluacion);
                    claveActual++;
                    control.agregarInstrumento(instrumento);
                    System.out.println("Instrumento agregado correctamente.\n");
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:

                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion Invalida, vuelva a intentarlo");
            }
        }while(opc != 9);
    }

}
