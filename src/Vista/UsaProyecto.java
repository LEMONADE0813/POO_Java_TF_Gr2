package Vista;

import Modelo.Cliente;
import Modelo.Contacto;
import Modelo.Empleado;
import Modelo.Empresa;
import Modelo.PersonaNatural;
import Modelo.Proyecto;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UsaProyecto extends JFrame {

    static ArrayList<Proyecto> losProyectos = new ArrayList<>();
    static ArrayList<Cliente> losClientes = new ArrayList<>();

    private JComboBox<String> cmbOpciones;
    private JButton btnEjecutar;
    private JTextArea txtResultado;

    public UsaProyecto() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Gestión de Proyectos - POO_Java_TF_Gr2");
        setSize(760, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] opciones = {
            "1. Registrar un proyecto",
            "2. Consultar todos los proyectos",
            "3. Consultar los proyectos en curso",
            "4. Consultar el primer proyecto registrado",
            "5. Consultar el último proyecto registrado",
            "6. Consultar un proyecto dado su código",
            "7. Consultar el gerente de un proyecto",
            "8. Consultar el equipo de un proyecto",
            "9. Registrar un integrante a un proyecto",
            "10. Registrar el equipo completo a un proyecto",
            "11. Actualizar estado de un proyecto",
            "12. Eliminar un integrante de un proyecto",
            "13. Consultar proyectos de un gerente (IDE)",
            "14. Consultar proyectos de un cliente (IDE)",
            "15. Consultar proyectos por tipo de cliente",
            "16. Generar archivo de objetos de proyectos",
            "17. Leer archivo de objetos de proyectos",
            "18. Generar archivo de objetos de clientes",
            "19. Leer archivo de objetos de clientes"
        };

        cmbOpciones = new JComboBox<>(opciones);
        btnEjecutar = new JButton("Ejecutar");
        panelSuperior.add(new JLabel("Operación:"));
        panelSuperior.add(cmbOpciones);
        panelSuperior.add(btnEjecutar);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtResultado);

        add(panelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        btnEjecutar.addActionListener(e -> ejecutarOpcion());
    }

    private void ejecutarOpcion() {
        int opcion = cmbOpciones.getSelectedIndex() + 1;
        String cod, ide, tipo;

        switch (opcion) {
            case 1:
                losProyectos = registrarProyecto(losProyectos);
                txtResultado.setText("Total proyectos registrados: " + losProyectos.size());
                break;
            case 2:
                txtResultado.setText(consultarTodosProyectos(losProyectos));
                break;
            case 3:
                txtResultado.setText(consultarProyectosEnCurso(losProyectos));
                break;
            case 4:
                txtResultado.setText(consultarPrimerProyecto(losProyectos));
                break;
            case 5:
                txtResultado.setText(consultarUltimoProyecto(losProyectos));
                break;
            case 6:
                cod = JOptionPane.showInputDialog(this, "Ingrese código del proyecto (ej. 2026-001):");
                if (cod != null) txtResultado.setText(consultarProyectoDadoCodigo(losProyectos, cod));
                break;
            case 7:
                cod = JOptionPane.showInputDialog(this, "Ingrese código del proyecto:");
                if (cod != null) txtResultado.setText(consultarGerenteProyectoDadoCodigo(losProyectos, cod));
                break;
            case 8:
                cod = JOptionPane.showInputDialog(this, "Ingrese código del proyecto:");
                if (cod != null) txtResultado.setText(consultarEquipoProyectoDadoCodigo(losProyectos, cod));
                break;
            case 9:
                cod = JOptionPane.showInputDialog(this, "Ingrese código del proyecto:");
                if (cod != null) txtResultado.setText(registrarIntegranteProyectoDadoCodigo(losProyectos, cod));
                break;
            case 10:
                cod = JOptionPane.showInputDialog(this, "Ingrese código del proyecto:");
                if (cod != null) txtResultado.setText(registrarEquipoProyectoDadoCodigo(losProyectos, cod));
                break;
            case 11:
                cod = JOptionPane.showInputDialog(this, "Ingrese código del proyecto:");
                if (cod != null) txtResultado.setText(actualizarEstadoProyectoDadoCodigo(losProyectos, cod));
                break;
            case 12:
                cod = JOptionPane.showInputDialog(this, "Ingrese código del proyecto:");
                if (cod != null) txtResultado.setText(eliminarIntegranteProyectoDadoCodigo(losProyectos, cod));
                break;
            case 13:
                ide = JOptionPane.showInputDialog(this, "Ingrese identificación del gerente:");
                if (ide != null) txtResultado.setText(consultarProyectosDadoNumIDEGerente(losProyectos, ide));
                break;
            case 14:
                ide = JOptionPane.showInputDialog(this, "Ingrese identificación del cliente:");
                if (ide != null) txtResultado.setText(consultarProyectosDadoNumIDECliente(losProyectos, ide));
                break;
            case 15:
                tipo = JOptionPane.showInputDialog(this, "Tipo de cliente (Empresa / PersonaNatural):");
                if (tipo != null) txtResultado.setText(consultarProyectosDadoTipoCliente(losProyectos, tipo));
                break;
            case 16:
                generarArchivoDeObjetosProyectos(losProyectos);
                break;
            case 17:
                losProyectos = leerArchivoDeObjetosProyectos();
                txtResultado.setText("Proyectos cargados desde archivo: " + losProyectos.size());
                break;
            case 18:
                generarArchivoDeObjetosClientes(losProyectos);
                break;
            case 19:
                losClientes = leerArchivoDeObjetosClientes();
                StringBuilder sb = new StringBuilder("=== CLIENTES CARGADOS (" + losClientes.size() + ") ===\n");
                for (Cliente c : losClientes) {
                    sb.append(c.toString()).append("\n--------------------\n");
                }
                txtResultado.setText(sb.toString());
                break;
        }
    }

    // ==================== MÉTODOS DEL DIAGRAMA ====================

    public static String generarCodigoProyecto(ArrayList<Proyecto> datos) {
        int anioActual = LocalDate.now().getYear();
        int consecutivo = 1;
        if (datos != null) {
            for (Proyecto p : datos) {
                if (p.getCodigo() != null && p.getCodigo().startsWith(anioActual + "-")) {
                    consecutivo++;
                }
            }
        }
        return String.format("%d-%03d", anioActual, consecutivo);
    }

    public static ArrayList<Proyecto> registrarProyecto(ArrayList<Proyecto> datos) {
        if (datos == null) {
            datos = new ArrayList<>();
        }
        try {
            String codigo = generarCodigoProyecto(datos);
            String titulo = JOptionPane.showInputDialog("Código asignado: " + codigo + "\nTítulo del proyecto (20-100 caracteres):");
            if (titulo == null) return datos;

            String fechaStr = JOptionPane.showInputDialog("Fecha de inicio (aaaa-mm-dd):");
            if (fechaStr == null) return datos;
            LocalDate fechaInicio = LocalDate.parse(fechaStr.trim());

            String unidadDuracion = JOptionPane.showInputDialog("Unidad de duración (semanas, meses, años):");
            if (unidadDuracion == null) return datos;

            String durStr = JOptionPane.showInputDialog("Duración estimada:");
            if (durStr == null) return datos;
            byte duracionEstimada = Byte.parseByte(durStr.trim());

            String tipoCliente = JOptionPane.showInputDialog("Tipo de cliente (1: Empresa, 2: Persona Natural):");
            if (tipoCliente == null) return datos;

            String idCliente = JOptionPane.showInputDialog("Identificación del cliente:");
            String nomCliente = JOptionPane.showInputDialog("Nombre del cliente:");
            String ciudadCliente = JOptionPane.showInputDialog("Ciudad del cliente:");
            if (idCliente == null || nomCliente == null || ciudadCliente == null) return datos;

            Cliente cliente;
            if ("1".equals(tipoCliente.trim())) {
                String nomContacto = JOptionPane.showInputDialog("Nombre completo del contacto:");
                String cargoContacto = JOptionPane.showInputDialog("Cargo del contacto:");
                String telContacto = JOptionPane.showInputDialog("Teléfono del contacto:");
                String mailContacto = JOptionPane.showInputDialog("Correo del contacto:");
                Contacto contacto = new Contacto(nomContacto, cargoContacto, telContacto, mailContacto);
                cliente = new Empresa(contacto, idCliente, nomCliente, ciudadCliente);
            } else {
                String telNat = JOptionPane.showInputDialog("Teléfono del cliente:");
                String mailNat = JOptionPane.showInputDialog("Correo electrónico del cliente:");
                // Si PersonaNatural recibe primero los datos de Cliente, invierte el orden a: (idCliente, nomCliente, ciudadCliente, telNat, mailNat)
                cliente = new PersonaNatural(telNat, mailNat, idCliente, nomCliente, ciudadCliente);
            }

            Empleado gerente = solicitarDatosEmpleado("GERENTE");
            if (gerente == null) return datos;

            Proyecto nuevo = new Proyecto(codigo, titulo, fechaInicio, unidadDuracion, duracionEstimada, cliente, gerente, "INICIADO");
            datos.add(nuevo);
            JOptionPane.showMessageDialog(null, "Proyecto " + codigo + " registrado con éxito.");
        } catch (DateTimeParseException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de fecha o número ingresado: " + e.getMessage());
        }
        return datos;
    }

    private static Empleado solicitarDatosEmpleado(String rol) {
        String id = JOptionPane.showInputDialog("Identificación del " + rol + ":");
        if (id == null) return null;
        String nombre = JOptionPane.showInputDialog("Nombre completo del " + rol + ":");
        if (nombre == null) return null;
        String tituloProf = JOptionPane.showInputDialog("Título profesional del " + rol + ":");
        if (tituloProf == null) return null;
        String expStr = JOptionPane.showInputDialog("Años de experiencia del " + rol + ":");
        if (expStr == null) return null;
        byte exp = Byte.parseByte(expStr.trim());
        return new Empleado(id, nombre, tituloProf, exp);
    }

    private static String formatearProyecto(Proyecto p) {
        return p.toString() + "\nFecha de Finalización: " + p.determinarFechaFinalizacion() + "\n--------------------------------------\n";
    }

    public static String consultarTodosProyectos(ArrayList<Proyecto> datos) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía.";
        }
        StringBuilder sb = new StringBuilder("=== TODOS LOS PROYECTOS ===\n");
        for (Proyecto p : datos) {
            sb.append(formatearProyecto(p));
        }
        return sb.toString();
    }

    public static String consultarProyectosEnCurso(ArrayList<Proyecto> datos) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía.";
        }
        StringBuilder sb = new StringBuilder("=== PROYECTOS EN CURSO ===\n");
        boolean encontro = false;
        for (Proyecto p : datos) {
            if ("EN CURSO".equalsIgnoreCase(p.getEstado())) {
                sb.append(formatearProyecto(p));
                encontro = true;
            }
        }
        return encontro ? sb.toString() : "No hay proyectos en curso registrados.";
    }

    public static String consultarPrimerProyecto(ArrayList<Proyecto> datos) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía.";
        }
        return "=== PRIMER PROYECTO REGISTRADO ===\n" + formatearProyecto(datos.get(0));
    }

    public static String consultarUltimoProyecto(ArrayList<Proyecto> datos) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía.";
        }
        return "=== ÚLTIMO PROYECTO REGISTRADO ===\n" + formatearProyecto(datos.get(datos.size() - 1));
    }

    public static String consultarProyectoDadoCodigo(ArrayList<Proyecto> datos, String codigoProyecto) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía.";
        }
        for (Proyecto p : datos) {
            if (p.getCodigo().equalsIgnoreCase(codigoProyecto)) {
                return "=== PROYECTO ENCONTRADO ===\n" + formatearProyecto(p);
            }
        }
        return "No se encontró un proyecto con el código " + codigoProyecto;
    }

    public static String consultarGerenteProyectoDadoCodigo(ArrayList<Proyecto> datos, String codigoProyecto) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía.";
        }
        for (Proyecto p : datos) {
            if (p.getCodigo().equalsIgnoreCase(codigoProyecto)) {
                return "Proyecto: " + p.getTitulo() + "\nGerente:\n" + p.getSuGerente().toString();
            }
        }
        return "No se encontró un proyecto con el código " + codigoProyecto;
    }

    public static String consultarEquipoProyectoDadoCodigo(ArrayList<Proyecto> datos, String codigoProyecto) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía.";
        }
        for (Proyecto p : datos) {
            if (p.getCodigo().equalsIgnoreCase(codigoProyecto)) {
                ArrayList<Empleado> equipo = p.getSuEquipo();
                if (equipo == null || equipo.isEmpty()) {
                    return "Proyecto: " + p.getTitulo() + "\nEl proyecto aún no tiene equipo asignado.";
                }
                StringBuilder sb = new StringBuilder("Proyecto: " + p.getTitulo() + "\n=== EQUIPO DE TRABAJO ===\n");
                for (Empleado emp : equipo) {
                    sb.append(emp.toString()).append("\n--------------------\n");
                }
                return sb.toString();
            }
        }
        return "No se encontró un proyecto con el código " + codigoProyecto;
    }

    public static String registrarIntegranteProyectoDadoCodigo(ArrayList<Proyecto> datos, String codigoProyecto) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía.";
        }
        for (Proyecto p : datos) {
            if (p.getCodigo().equalsIgnoreCase(codigoProyecto)) {
                try {
                    Empleado nuevo = solicitarDatosEmpleado("INTEGRANTE");
                    if (nuevo == null) return "Registro de integrante cancelado.";
                    p.agregarIntegrante(nuevo);
                    return "Integrante agregado exitosamente al proyecto " + codigoProyecto;
                } catch (NumberFormatException e) {
                    return "Error en los años de experiencia ingresados.";
                }
            }
        }
        return "No se encontró un proyecto con el código " + codigoProyecto;
    }

    public static String registrarEquipoProyectoDadoCodigo(ArrayList<Proyecto> datos, String codigoProyecto) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía.";
        }
        for (Proyecto p : datos) {
            if (p.getCodigo().equalsIgnoreCase(codigoProyecto)) {
                try {
                    String cantStr = JOptionPane.showInputDialog("¿Cuántos integrantes desea registrar?");
                    if (cantStr == null) return "Registro de equipo cancelado.";
                    int cantidad = Integer.parseInt(cantStr.trim());
                    ArrayList<Empleado> equipo = new ArrayList<>();
                    for (int i = 1; i <= cantidad; i++) {
                        Empleado emp = solicitarDatosEmpleado("INTEGRANTE " + i);
                        if (emp != null) {
                            equipo.add(emp);
                        }
                    }
                    p.setSuEquipo(equipo);
                    return "Equipo de " + equipo.size() + " integrantes registrado en el proyecto " + codigoProyecto;
                } catch (NumberFormatException e) {
                    return "Error en el número ingresado.";
                }
            }
        }
        return "No se encontró un proyecto con el código " + codigoProyecto;
    }

    public static String actualizarEstadoProyectoDadoCodigo(ArrayList<Proyecto> datos, String codigoProyecto) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía.";
        }
        for (Proyecto p : datos) {
            if (p.getCodigo().equalsIgnoreCase(codigoProyecto)) {
                String nuevoEstado = JOptionPane.showInputDialog(
                        "Estado actual: " + p.getEstado()
                        + "\nNuevo estado (INICIADO, EN CURSO, CANCELADO, FINALIZADO, SUSPENDIDO, APLAZADO):");
                if (nuevoEstado == null) return "Actualización cancelada.";
                p.setEstado(nuevoEstado.trim().toUpperCase());
                return "Estado actualizado a " + p.getEstado() + " para el proyecto " + codigoProyecto;
            }
        }
        return "No se encontró un proyecto con el código " + codigoProyecto;
    }

    public static String eliminarIntegranteProyectoDadoCodigo(ArrayList<Proyecto> datos, String codigoProyecto) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía.";
        }
        for (Proyecto p : datos) {
            if (p.getCodigo().equalsIgnoreCase(codigoProyecto)) {
                String idEmpleado = JOptionPane.showInputDialog("Ingrese identificación del integrante a retirar:");
                if (idEmpleado == null) return "Operación cancelada.";
                Empleado eliminado = p.eliminarIntegrante(idEmpleado);
                if (eliminado != null) {
                    return "Se retiró del proyecto a: " + eliminado.getNombreCompleto();
                } else {
                    return "No se encontró un integrante con IDE " + idEmpleado + " en este proyecto.";
                }
            }
        }
        return "No se encontró un proyecto con el código " + codigoProyecto;
    }

    public static String consultarProyectosDadoNumIDEGerente(ArrayList<Proyecto> datos, String numIDEGerente) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía.";
        }
        StringBuilder sb = new StringBuilder("=== PROYECTOS DEL GERENTE " + numIDEGerente + " ===\n");
        boolean encontro = false;
        for (Proyecto p : datos) {
            if (p.getSuGerente().getNumeroIdentificacion().equalsIgnoreCase(numIDEGerente)) {
                sb.append(formatearProyecto(p));
                encontro = true;
            }
        }
        return encontro ? sb.toString() : "No se encontraron proyectos para el gerente indicado.";
    }

    public static String consultarProyectosDadoNumIDECliente(ArrayList<Proyecto> datos, String numIDECliente) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía.";
        }
        StringBuilder sb = new StringBuilder("=== PROYECTOS DEL CLIENTE " + numIDECliente + " ===\n");
        boolean encontro = false;
        for (Proyecto p : datos) {
            if (p.getSuCliente().getNumeroIdentificacion().equalsIgnoreCase(numIDECliente)) {
                sb.append(formatearProyecto(p));
                encontro = true;
            }
        }
        return encontro ? sb.toString() : "No se encontraron proyectos para el cliente indicado.";
    }

    public static String consultarProyectosDadoTipoCliente(ArrayList<Proyecto> datos, String tipoCliente) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía.";
        }
        StringBuilder sb = new StringBuilder("=== PROYECTOS POR TIPO CLIENTE: " + tipoCliente + " ===\n");
        boolean encontro = false;
        for (Proyecto p : datos) {
            boolean esEmpresa = "Empresa".equalsIgnoreCase(tipoCliente) && (p.getSuCliente() instanceof Empresa);
            boolean esNatural = "PersonaNatural".equalsIgnoreCase(tipoCliente) && (p.getSuCliente() instanceof PersonaNatural);
            if (esEmpresa || esNatural) {
                sb.append(formatearProyecto(p));
                encontro = true;
            }
        }
        return encontro ? sb.toString() : "No se encontraron proyectos para ese tipo de cliente.";
    }

    // ==================== PERSISTENCIA DE OBJETOS ====================

    public static void generarArchivoDeObjetosProyectos(ArrayList<Proyecto> datos) {
        if (datos == null || datos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La lista de proyectos está vacía. No se generó archivo.");
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datosProyectos"))) {
            for (Proyecto p : datos) {
                oos.writeObject(p);
            }
            JOptionPane.showMessageDialog(null, "Archivo 'datosProyectos' generado exitosamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar proyectos: " + e.getMessage());
        }
    }

    public static ArrayList<Proyecto> leerArchivoDeObjetosProyectos() {
        ArrayList<Proyecto> datos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datosProyectos"))) {
            while (true) {
                datos.add((Proyecto) ois.readObject());
            }
        } catch (EOFException eof) {
            // Fin normal del archivo
        } catch (FileNotFoundException fnf) {
            JOptionPane.showMessageDialog(null, "El archivo 'datosProyectos' aún no existe.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer 'datosProyectos': " + e.getMessage());
        }
        return datos;
    }

    public static void generarArchivoDeObjetosClientes(ArrayList<Proyecto> datos) {
        if (datos == null || datos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La lista de proyectos está vacía. No se generó archivo de clientes.");
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datosClientes"))) {
            for (Proyecto p : datos) {
                oos.writeObject(p.getSuCliente());
            }
            JOptionPane.showMessageDialog(null, "Archivo 'datosClientes' generado exitosamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar clientes: " + e.getMessage());
        }
    }

    public static ArrayList<Cliente> leerArchivoDeObjetosClientes() {
        ArrayList<Cliente> datos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datosClientes"))) {
            while (true) {
                Cliente c = (Cliente) ois.readObject();
                boolean existe = false;
                for (Cliente existente : datos) {
                    if (existente.getNumeroIdentificacion().equalsIgnoreCase(c.getNumeroIdentificacion())) {
                        existe = true;
                        break;
                    }
                }
                if (!existe) {
                    datos.add(c);
                }
            }
        } catch (EOFException eof) {
            // Fin normal del archivo
        } catch (FileNotFoundException fnf) {
            JOptionPane.showMessageDialog(null, "El archivo 'datosClientes' aún no existe.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer 'datosClientes': " + e.getMessage());
        }
        return datos;
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new UsaProyecto().setVisible(true);
        });
    }
}