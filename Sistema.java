import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;


public class Sistema {
    JFrame frame;
    Control control = new Control();
    JButton boton1 = new JButton("Agregar Instrumento");
    JButton boton2 = new JButton("Consultar por Autor");
    JButton boton3 = new JButton("Filtrar por Clave");
    JButton boton4 = new JButton("Consultar por Tipo de Instrumento");
    JButton boton5 = new JButton("Consultar por Evaluacion");
    JButton boton6 = new JButton("Consultar por Tipo de Condicion");
    JButton boton7 = new JButton("Eliminar Instrumento por Clave");
    JButton boton8 = new JButton("Mostrar a partir del Primer Autor");
    JButton boton9 = new JButton("Mostrar por clave de menor a mayor");
    JButton boton10 = new JButton("Guardar Informacion en Archivo");
    JButton botonSalir = new JButton("Salir");
    JLabel labelPregunta = new JLabel("Que desea seleccionar?");
    String ultimoEliminado;
    int claveActual = 1;
    String autor;
    String tipoCondicion;
    String tipo;
    Boolean evaluacion;
    int pasos;


    public Sistema() {
        frame = new JFrame();
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);


        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(Color.black);


        JLabel labelTitulo = new JLabel("Salud Mental Integral");
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        labelTitulo.setForeground(Color.white);
        panelTitulo.add(labelTitulo);
        frame.add(panelTitulo, BorderLayout.NORTH);


        JPanel panelInformacionCentral = new JPanel();
        panelInformacionCentral.setLayout(new GridLayout(13, 1));

        boton1();
        boton2();
        boton3();
        boton4();
        boton5();
        boton6();
        boton7();
        boton8();
        boton9();
        boton10();
        botonSalir();

        labelPregunta.setHorizontalAlignment(JLabel.CENTER);

        panelInformacionCentral.add(labelPregunta);
        panelInformacionCentral.add(boton1);
        panelInformacionCentral.add(boton2);
        panelInformacionCentral.add(boton3);
        panelInformacionCentral.add(boton4);
        panelInformacionCentral.add(boton5);
        panelInformacionCentral.add(boton6);
        panelInformacionCentral.add(boton7);
        panelInformacionCentral.add(boton8);
        panelInformacionCentral.add(boton9);
        panelInformacionCentral.add(boton10);
        panelInformacionCentral.add(botonSalir);


        frame.add(panelInformacionCentral, BorderLayout.CENTER);


        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
    }

    public void boton1() {
        boton1.addActionListener(e -> {

            JDialog dialog = new JDialog();
            dialog.setLayout(new BorderLayout());
            dialog.setSize(300, 100);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setResizable(false);

            JLabel labelMensaje = new JLabel("Ingrese el nombre del Autor:");
            JButton botonAceptar = new JButton("Aceptar");
            JTextField field = new JTextField();

            pasos = 1;

            botonAceptar.addActionListener(e2 -> {
                if (pasos == 1 && !field.getText().equals("")) {
                    autor = field.getText();
                    field.setText("");
                    labelMensaje.setText("Introduzca el tipo de instrumento:");
                    pasos = 2;
                } else if (pasos == 2 && !field.getText().equals("")) {
                    tipo = field.getText();
                    field.setText("");
                    labelMensaje.setText("Introduzca el tipo de condicion:");
                    pasos = 3;
                } else if (pasos == 3 && !field.getText().equals("")) {
                    tipoCondicion = field.getText();
                    field.setText("");
                    labelMensaje.setText("Introduzca la evaluacion correspondiente (false/true):");
                    pasos = 4;
                } else if (pasos == 4 &&
                        (field.getText().equals("true") || field.getText().equals("false"))) {

                    evaluacion = field.getText().equals("true");


                    Instrumento instrumento = new Instrumento(autor, claveActual, tipo, tipoCondicion, evaluacion);
                    control.agregarInstrumento(instrumento);
                    control.setAutores(autor);


                    System.out.println("\nResumen:\n");
                    System.out.println("Autor: " + autor + "\n");
                    System.out.println("Tipo de instrumento: " + tipo + "\n");
                    System.out.println("Tipo de condicion: " + tipoCondicion + "\n");
                    System.out.println("Evaluación: " + evaluacion + "\n");
                    System.out.println("Clave: " + claveActual + "\n");

                    claveActual++;
                    pasos = 0;
                    dialog.dispose();
                }
            });

            dialog.add(labelMensaje, BorderLayout.NORTH);
            dialog.add(botonAceptar, BorderLayout.WEST);
            dialog.add(field, BorderLayout.CENTER);

            dialog.setVisible(true);
        });
    }


    public void boton2() {
        boton2.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setLayout(new BorderLayout());
            dialog.setSize(300, 100);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setResizable(false);
            JLabel labelMensaje = new JLabel("Ingrese el nombre del Autor:");
            JButton botonAceptar = new JButton("Aceptar");
            JTextField field = new JTextField();

            botonAceptar.addActionListener(e2 -> {
                if (!field.getText().equals("")) {
                    dialog.getContentPane().removeAll();
                    dialog.getContentPane().revalidate();
                    dialog.getContentPane().repaint();
                    JTextArea textArea = new JTextArea();
                    String instrumentosAutor = control.consultarPorAutor(field.getText());
                    if (!instrumentosAutor.isEmpty()) {
                        textArea.setText(instrumentosAutor);
                    } else {
                        textArea.setText("NO HUBO COINCIDENCIAS");
                    }
                    dialog.add(new JLabel("INSTRUMENTOS"), BorderLayout.NORTH);
                    dialog.add(textArea, BorderLayout.CENTER);
                    dialog.pack();
                }
            });
            dialog.add(labelMensaje, BorderLayout.NORTH);
            dialog.add(botonAceptar, BorderLayout.WEST);
            dialog.add(field, BorderLayout.CENTER);
            dialog.setVisible(true);

        });
    }

    public void boton3() {
        boton3.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setLayout(new BorderLayout());
            dialog.setSize(300, 100);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setResizable(false);
            JLabel labelMensaje = new JLabel("Ingrese la clave");
            JButton botonAceptar = new JButton("Aceptar");
            JTextField field = new JTextField();

            //Ayuda a descartar lo que no sea un digito valido (0-9)
            field.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent evt) {
                    char c = evt.getKeyChar();
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        evt.consume();
                    }
                }
            });

            botonAceptar.addActionListener(e2 -> {
                if (!field.getText().equals("")) {
                    dialog.getContentPane().removeAll();
                    dialog.getContentPane().revalidate();
                    dialog.getContentPane().repaint();
                    JTextArea textArea = new JTextArea();
                    String instrumentosAutor = control.filtrarPorClave(Integer.parseInt(field.getText()));
                    if (!instrumentosAutor.equals("")) {
                        textArea.setText(instrumentosAutor);
                    } else {
                        textArea.setText("NO HUBO COINCIDENCIAS");
                    }
                    dialog.add(new JLabel("INSTRUMENTOS"), BorderLayout.NORTH);
                    dialog.add(textArea, BorderLayout.CENTER);
                    dialog.pack();
                }
            });
            dialog.add(labelMensaje, BorderLayout.NORTH);
            dialog.add(botonAceptar, BorderLayout.WEST);
            dialog.add(field, BorderLayout.CENTER);
            dialog.setVisible(true);

        });
    }

    public void boton4() {
        boton4.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setLayout(new BorderLayout());
            dialog.setSize(300, 100);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setResizable(false);
            JLabel labelMensaje = new JLabel("Ingrese el tipo de instrumento:");
            JButton botonAceptar = new JButton("Aceptar");
            JTextField field = new JTextField();

            botonAceptar.addActionListener(e2 -> {
                if (!field.getText().equals("")) {
                    dialog.getContentPane().removeAll();
                    dialog.getContentPane().revalidate();
                    dialog.getContentPane().repaint();
                    JTextArea textArea = new JTextArea();
                    String instrumentosAutor = control.consultarPorTipo(field.getText());
                    if (!instrumentosAutor.isEmpty()) {
                        textArea.setText(instrumentosAutor);
                    } else {
                        textArea.setText("NO HUBO COINCIDENCIAS");
                    }
                    dialog.add(new JLabel("INSTRUMENTOS"), BorderLayout.NORTH);
                    dialog.add(textArea, BorderLayout.CENTER);
                    dialog.pack();
                }
            });
            dialog.add(labelMensaje, BorderLayout.NORTH);
            dialog.add(botonAceptar, BorderLayout.WEST);
            dialog.add(field, BorderLayout.CENTER);
            dialog.setVisible(true);

        });
    }

    public void boton5() {
        boton5.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setLayout(new BorderLayout());
            dialog.setSize(300, 100);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setResizable(false);
            JLabel labelMensaje = new JLabel("Ingrese la evaluacion (false/true):");
            JButton botonAceptar = new JButton("Aceptar");
            JTextField field = new JTextField();

            botonAceptar.addActionListener(e2 -> {
                if (!field.getText().equals("") && (field.getText().equals("false") || field.getText().equals("true"))) {
                    dialog.getContentPane().removeAll();
                    dialog.getContentPane().revalidate();
                    dialog.getContentPane().repaint();
                    JTextArea textArea = new JTextArea();
                    String instrumentosAutor = control.consultarPorEvaluacion(Boolean.parseBoolean(field.getText()));
                    if (!instrumentosAutor.isEmpty()) {
                        textArea.setText(instrumentosAutor);
                    } else {
                        textArea.setText("NO HUBO COINCIDENCIAS");
                    }
                    dialog.add(new JLabel("INSTRUMENTOS"), BorderLayout.NORTH);
                    dialog.add(textArea, BorderLayout.CENTER);
                    dialog.pack();
                }
            });
            dialog.add(labelMensaje, BorderLayout.NORTH);
            dialog.add(botonAceptar, BorderLayout.WEST);
            dialog.add(field, BorderLayout.CENTER);
            dialog.setVisible(true);

        });
    }

    public void boton6() {
        boton6.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setLayout(new BorderLayout());
            dialog.setSize(300, 100);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setResizable(false);
            JLabel labelMensaje = new JLabel("Ingrese el tipo de condicion:");
            JButton botonAceptar = new JButton("Aceptar");
            JTextField field = new JTextField();

            botonAceptar.addActionListener(e2 -> {
                if (!field.getText().equals("")) {
                    dialog.getContentPane().removeAll();
                    dialog.getContentPane().revalidate();
                    dialog.getContentPane().repaint();
                    JTextArea textArea = new JTextArea();
                    String instrumentosAutor = control.consultarPorTipoCondicion(field.getText());
                    if (!instrumentosAutor.isEmpty()) {
                        textArea.setText(instrumentosAutor);
                    } else {
                        textArea.setText("NO HUBO COINCIDENCIAS");
                    }
                    dialog.add(new JLabel("INSTRUMENTOS"), BorderLayout.NORTH);
                    dialog.add(textArea, BorderLayout.CENTER);
                    dialog.pack();
                }
            });
            dialog.add(labelMensaje, BorderLayout.NORTH);
            dialog.add(botonAceptar, BorderLayout.WEST);
            dialog.add(field, BorderLayout.CENTER);
            dialog.setVisible(true);

        });
    }

    public void boton7() {
        boton7.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setLayout(new BorderLayout());
            dialog.setSize(300, 100);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setResizable(false);
            JLabel labelMensaje = new JLabel("Ingrese la clave para eliminar un instrumento:");
            JButton botonAceptar = new JButton("Aceptar");
            JTextField field = new JTextField();

            //Ayuda a descartar lo que no sea un digito valido (0-9)
            field.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent evt) {
                    char c = evt.getKeyChar();
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        evt.consume();
                    }
                }
            });

            botonAceptar.addActionListener(e2 -> {
                if (!field.getText().equals("")) {
                    dialog.getContentPane().removeAll();
                    dialog.getContentPane().revalidate();
                    dialog.getContentPane().repaint();
                    JTextArea textArea = new JTextArea();
                    String instrumentosAutor = control.eliminarPorClave(Integer.parseInt(field.getText()));
                    if (!instrumentosAutor.equals("")) {
                        textArea.setText(instrumentosAutor + "\n\tSE HA ELIMINADO...");

                    } else {
                        textArea.setText("NO HUBO COINCIDENCIAS");
                    }
                    dialog.add(new JLabel("INSTRUMENTOS"), BorderLayout.NORTH);
                    dialog.add(textArea, BorderLayout.CENTER);
                    dialog.pack();
                }
            });
            dialog.add(labelMensaje, BorderLayout.NORTH);
            dialog.add(botonAceptar, BorderLayout.WEST);
            dialog.add(field, BorderLayout.CENTER);
            dialog.setVisible(true);
        });
    }

    public void boton8() {
        boton8.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setLayout(new BorderLayout());
            dialog.setSize(300, 100);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setResizable(false);

            JTextArea textArea = new JTextArea();
            String instrumentosAutor = control.ordenarPorPrimerAutor();
            if (!instrumentosAutor.isEmpty()) {
                textArea.setText(instrumentosAutor);
            } else {
                textArea.setText("NO HUBO COINCIDENCIAS");
            }
            dialog.add(new JLabel("INSTRUMENTOS"), BorderLayout.NORTH);
            dialog.add(textArea, BorderLayout.CENTER);
            dialog.pack();
            dialog.setVisible(true);

        });
    }

    public void boton9() {
        boton9.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setLayout(new BorderLayout());
            dialog.setSize(300, 100);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setResizable(false);

            JTextArea textArea = new JTextArea();
            String instrumentosAutor = control.ordenarPorClave();
            if (!instrumentosAutor.isEmpty()) {
                textArea.setText(instrumentosAutor);
            } else {
                textArea.setText("NO HUBO COINCIDENCIAS");
            }
            dialog.add(new JLabel("INSTRUMENTOS"), BorderLayout.NORTH);
            dialog.add(textArea, BorderLayout.CENTER);
            dialog.pack();
            dialog.setVisible(true);

        });
    }

    public void boton10() {
        boton10.addActionListener(e -> {

            JDialog dialog = new JDialog();
            dialog.setLayout(new BorderLayout());
            dialog.setSize(300, 100);
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setResizable(false);

            JTextArea textArea = new JTextArea(control.guardarEnArchivo());
            textArea.setFont(new Font("Arial", Font.PLAIN, 40));
            dialog.add(textArea, BorderLayout.CENTER);
            dialog.pack();
            dialog.setVisible(true);

        });
    }

    public void botonSalir() {
        botonSalir.addActionListener(e -> {
            frame.dispose();
        });
    }


}