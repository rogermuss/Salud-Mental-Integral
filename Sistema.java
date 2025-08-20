import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args){
        int opc;
        int claveActual = 1;
        String autor;
        String tipoCondicion;
        String tipo;
        Boolean evaluacion = null;
        String ultimoEliminado;

        int clave;
        Scanner scanner = new Scanner(System.in);

        Control control =  new Control();
        Scanner sc = new Scanner(System.in);
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("1. Agregar Instrumento\n");
            System.out.println("2. Consultar por Autor\n");
            System.out.println("3. Mostrar por clave\n");
            System.out.println("4. Consultar por Tipo de Instrumento\n");
            System.out.println("5. Consultar por Evaluacion\n");
            System.out.println("6. Consultar por Tipo de Condicion\n");
            System.out.println("7. Eliminar Instrumento por Clave\n");
            System.out.println("8. Mostrar a partir del Primer Autor\n");
            System.out.println("9. Mostrar por clave de menor a mayor\n");
            System.out.println("10. Mostrar Todos\n");
            System.out.println("11. Salir\n");
            System.out.println("Que desea seleccionar? ");
            sc.nextLine();
            opc = sc.nextInt();
            switch (opc) {
                case 1:


                    do {
                        System.out.print("Introduzca el nombre del autor: ");
                        autor = teclado.nextLine().trim();
                        if (autor.isEmpty()) {
                            System.out.println("El nombre del autor no puede estar vacío.");
                        }
                    } while (autor.isEmpty());


                    do {
                        System.out.print("Introduzca el tipo de instrumento: ");
                        tipo = teclado.nextLine().trim();
                        if (tipo.isEmpty()) {
                            System.out.println("El tipo de instrumento no puede estar vacío.");
                        }
                    } while (tipo.isEmpty());


                    do {
                        System.out.print("Introduzca el tipo de condiciones del instrumento: ");
                        tipoCondicion = teclado.nextLine().trim();
                        if (tipoCondicion.isEmpty()) {
                            System.out.println("El nombre del instrumento no puede estar vacío.");
                        }
                    } while (tipoCondicion.isEmpty());


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
                    System.out.println("Tipo de condicion: " + tipoCondicion+"\n");
                    System.out.println("Evaluación: " + evaluacion+"\n");
                    System.out.println("Clave: " + claveActual+"\n");


                    Instrumento instrumento = new Instrumento(autor, claveActual, tipo, tipoCondicion, evaluacion);
                    claveActual++;
                    control.agregarInstrumento(instrumento);
                    control.setAutores(autor);
                    System.out.println("Instrumento agregado correctamente.\n");
                    break;
                case 2:
                    do {
                        System.out.print("Introduzca el nombre del autor: ");
                        autor = teclado.nextLine().trim();
                        if (autor.isEmpty()) {
                            System.out.println("El nombre del autor no puede estar vacío.");
                        }
                    } while (autor.isEmpty());

                    System.out.println(control.consultarPorAutor(autor)+"\n");
                    break;
                case 3:
                    clave=-1;

                    do {
                        System.out.print("Introduzca la clave del Instrumento: ");
                        if(scanner.hasNextInt()) {
                            clave = scanner.nextInt();
                        }else {
                            System.out.println("Debe ingresar un numero valido");
                            scanner.next();
                        }
                    } while (!control.esClaveValida(clave));

                    System.out.println(control.filtrarPorClave(clave));
                    break;
                case 4:
                    do {
                        System.out.print("Introduzca el tipo de instrumento: ");
                        tipo = teclado.nextLine().trim();
                        if (tipo.isEmpty()) {
                            System.out.println("El tipo de instrumento no puede estar vacío.");
                        }
                    } while (tipo.isEmpty());

                    if(tipo.isEmpty()){
                        System.out.println("Debe ingresar un tipo de instrumento\n");
                    }else{
                        System.out.println(control.consultarPorTipo(tipo));
                    }

                    break;
                case 5:
                    if (teclado.hasNextBoolean()) {
                        evaluacion = teclado.nextBoolean();
                    } else {
                        System.out.println("Debe ingresar true o false.");
                        teclado.next(); // descartar entrada inválida

                    }

                    if(evaluacion == null){
                        System.out.println("Debe ingresar un tipo de instrumento\n");
                    }else{
                        System.out.println(control.consultarPorEvaluacion(evaluacion));
                    }

                    break;

                case 6:
                    do {
                        System.out.print("Introduzca el tipo de condicion: ");
                        tipoCondicion = teclado.nextLine().trim();
                        if (tipoCondicion.isEmpty()) {
                            System.out.println("El tipo de instrumento no puede estar vacío.");
                        }
                    } while (tipoCondicion.isEmpty());

                    if(tipoCondicion.isEmpty()){
                        System.out.println("Debe ingresar un tipo de instrumento\n");
                    }else{
                        System.out.println(control.consultarPorTipoCondicion(tipoCondicion));
                    }
                    break;
                case 7:
                    clave=-1;
                    scanner = new Scanner(System.in);
                    do {
                        System.out.print("Introduzca la clave del Instrumento: ");
                        if(scanner.hasNextInt()) {
                            clave = scanner.nextInt();
                        }else {
                            System.out.println("Debe ingresar un numero valido");
                            scanner.next();
                        }
                    } while (!control.esClaveValida(clave));

                    ultimoEliminado = control.eliminarPorClave(clave);

                    break;

                case 8:
                    ArrayList<Instrumento> ordenadosPorPrimerAutor = control.ordenarPorPrimerAutor();
                    ordenadosPorPrimerAutor.forEach(i -> System.out.println(i.toString()));
                    break;
                case 9:
                    ArrayList<Instrumento> ordenadosPorClave = control.ordenarPorClave();
                    ordenadosPorClave.forEach(i -> System.out.println(i.toString()));
                    break;
                case 10:
                    System.out.println(control.consultarTodos());
                    break;
                case 11:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion Invalida, vuelva a intentarlo");
            }
        }while(opc != 11);
    }

}
