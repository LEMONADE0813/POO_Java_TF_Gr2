/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.Empresa;
import Modelo.PersonaNatural;
import Modelo.Proyecto;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.EOFException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Gundi
 */
public class UsaProyectoGUI extends javax.swing.JFrame {
    private ArrayList<Proyecto> losProyectos = new ArrayList<>();
    

    /**
     * Creates new form UsaProyecto
     */
    public UsaProyectoGUI(ArrayList<Proyecto> losProyectos) {
        initComponents();
        this.losProyectos = losProyectos;
    }
    public UsaProyectoGUI() {
        initComponents();
        
    }
    public String consultarTodosProyectos(ArrayList<Proyecto> losProyectos){
        String resultado = "CONSULTAR TODOS LOS CLIENTES\n";
        if(losProyectos.isEmpty()){
            resultado += "\n No hay información en la lista.";
            return resultado;
        } 
        for(Proyecto objeto : losProyectos){
            resultado += objeto.toString();
            resultado += "\n     Fecha Finalizacion: " + objeto.determinarFechaFinalizacion();
            resultado += "\n";
        }
        return resultado;
    }
    
    public String consultarProyectosEnCurso(ArrayList<Proyecto> losProyectos){
    String resultado = "CONSULTAR PROYECTOS EN CURSO\n";
    boolean encontrado = false;

    if(losProyectos.isEmpty()){
        return resultado + "\nNo hay información en la lista.";
    }

    for(Proyecto objeto : losProyectos){
        if(objeto.getEstado().equalsIgnoreCase("EN CURSO")){
            resultado += objeto.toString();
            resultado += "\nFecha Finalizacion: " + objeto.determinarFechaFinalizacion();
            resultado += "\n\n";
            encontrado = true;
        }
    }

    if(!encontrado){
        resultado += "\nNo hay proyectos en curso.";
    }

    return resultado;
}
    public String consultarPrimerProyecto(ArrayList<Proyecto> losProyectos){
    String resultado = "CONSULTAR PRIMER PROYECTO\n";

    if(losProyectos.isEmpty()){
        return resultado + "\nNo hay información en la lista.";
    }

    Proyecto objeto = losProyectos.get(0);

    resultado += objeto.toString();
    resultado += "\nFecha Finalizacion: " + objeto.determinarFechaFinalizacion();

    return resultado;
}
    public String consultarUltimoProyecto(ArrayList<Proyecto> losProyectos){
    String resultado = "CONSULTAR ULTIMO PROYECTO\n";

    if(losProyectos.isEmpty()){
        return resultado + "\nNo hay información en la lista.";
    }

    Proyecto objeto = losProyectos.get(losProyectos.size()-1);

    resultado += objeto.toString();
    resultado += "\nFecha Finalizacion: " + objeto.determinarFechaFinalizacion();

    return resultado;
}
    public String consultarProyectoDadoCodigo(ArrayList<Proyecto> losProyectos, String codigoProyecto){
    String resultado = "CONSULTAR PROYECTO DADO CODIGO\n";

    if(losProyectos.isEmpty()){
        return resultado + "\nNo hay información en la lista.";
    }

    for(Proyecto objeto : losProyectos){
        if(objeto.getCodigo().equalsIgnoreCase(codigoProyecto)){
            resultado += objeto.toString();
            resultado += "\nFecha Finalizacion: " + objeto.determinarFechaFinalizacion();
            return resultado;
        }
    }

    resultado += "\nNo se encontró un proyecto con el código: " + codigoProyecto;

    return resultado;
}
    
    public String consultarGerenteProyectoDadoCodigo(ArrayList<Proyecto> losProyectos, String codigoProyecto){
    String resultado = "CONSULTAR GERENTE DE UN PROYECTO\n";

    if(losProyectos.isEmpty()){
        return resultado + "\nNo hay información en la lista.";
    }

    for(Proyecto objeto : losProyectos){
        if(objeto.getCodigo().equalsIgnoreCase(codigoProyecto)){
            resultado += "\nProyecto: " + objeto.getCodigo();
            resultado += "\nGerente:\n";
            resultado += objeto.getSuGerente().toString();

            return resultado;
        }
    }

    resultado += "\nNo se encontró un proyecto con el código: " + codigoProyecto;

    return resultado;
}
    
    public String consultarEquipoProyectoDadoCodigo(ArrayList<Proyecto> losProyectos, String codigoProyecto){
    String resultado = "CONSULTAR EQUIPO DE UN PROYECTO\n";
    boolean encontrado = false;

    if(losProyectos.isEmpty()){
        return resultado + "\nNo hay información en la lista.";
    }

    for(Proyecto objeto : losProyectos){
        if(objeto.getCodigo().equalsIgnoreCase(codigoProyecto)){

            resultado += "\nProyecto: " + objeto.getCodigo();
            resultado += "\nIntegrantes del equipo:\n";

            if(objeto.getSuEquipo().isEmpty()){
                resultado += "\nEl proyecto no tiene integrantes registrados.";
            }else{
                for(Empleado integrante : objeto.getSuEquipo()){
                    resultado += "\n" + integrante.toString() + "\n";
                }
            }

            encontrado = true;
            break;
        }
    }

    if(!encontrado){
        resultado += "\nNo se encontró un proyecto con el código: " + codigoProyecto;
    }

    return resultado;
}
    public String consultarProyectosDadoNumIDEGerente(ArrayList<Proyecto> losProyectos, String numIDEGerente){
    String resultado = "CONSULTAR PROYECTOS DADO NUMERO IDE DEL GERENTE\n";
    boolean encontrado = false;

    if(losProyectos.isEmpty()){
        return resultado + "\nNo hay información en la lista.";
    }

    for(Proyecto objeto : losProyectos){
        if(objeto.getSuGerente().getNumeroIde().equalsIgnoreCase(numIDEGerente)){
            resultado += objeto.toString();
            resultado += "\nFecha Finalizacion: " + objeto.determinarFechaFinalizacion();
            resultado += "\n\n";
            encontrado = true;
        }
    }

    if(!encontrado){
        resultado += "\nNo se encontraron proyectos para el gerente con identificación: " + numIDEGerente;
    }

    return resultado;
}
    public String consultarProyectosDadoNumIDECliente(ArrayList<Proyecto> losProyectos, String numIDECliente){
    String resultado = "CONSULTAR PROYECTOS DADO NUMERO IDE DEL CLIENTE\n";
    boolean encontrado = false;

    if(losProyectos.isEmpty()){
        return resultado + "\nNo hay información en la lista.";
    }

    for(Proyecto objeto : losProyectos){
        if(objeto.getSuCliente().getNumeroIdentificacion().equalsIgnoreCase(numIDECliente)){
            resultado += objeto.toString();
            resultado += "\nFecha Finalizacion: " + objeto.determinarFechaFinalizacion();
            resultado += "\n\n";
            encontrado = true;
        }
    }

    if(!encontrado){
        resultado += "\nNo se encontraron proyectos para el cliente con identificación: " + numIDECliente;
    }

    return resultado;
}
    public String consultarProyectosDadoTipoCliente(ArrayList<Proyecto> losProyectos, String tipoCliente){
    String resultado = "CONSULTAR PROYECTOS DADO TIPO DE CLIENTE\n";
    boolean encontrado = false;

    if(losProyectos.isEmpty()){
        return resultado + "\nNo hay información en la lista.";
    }

    for(Proyecto objeto : losProyectos){

        switch(tipoCliente.toUpperCase().replace(" ", "")){

            case "EMPRESA":
                if(objeto.getSuCliente() instanceof Empresa){
                    resultado += objeto.toString();
                    resultado += "\nFecha Finalizacion: " + objeto.determinarFechaFinalizacion();
                    resultado += "\n\n";
                    encontrado = true;
                }
                break;

            case "PERSONANATURAL":
                if(objeto.getSuCliente() instanceof PersonaNatural){
                    resultado += objeto.toString();
                    resultado += "\nFecha Finalizacion: " + objeto.determinarFechaFinalizacion();
                    resultado += "\n\n";
                    encontrado = true;
                }
                break;
        }
    }

    if(!encontrado){
        resultado += "\nNo se encontraron proyectos para el tipo de cliente: " + tipoCliente;
    }

    return resultado;
}
    
    public Empleado solicitarDatosEmpleado(){

    String numeroIdentificacion;
    String nombreCompleto;
    String tituloProfesional;
    byte aniosExperiencia = 0;

    numeroIdentificacion = JOptionPane.showInputDialog("Ingrese el número de identificación:");

    if(numeroIdentificacion == null || numeroIdentificacion.isBlank()){
        return null;
    }

    nombreCompleto = JOptionPane.showInputDialog("Ingrese el nombre completo:");

    if(nombreCompleto == null || nombreCompleto.isBlank()){
        return null;
    }

    tituloProfesional = JOptionPane.showInputDialog("Ingrese el título profesional:");

    if(tituloProfesional == null || tituloProfesional.isBlank()){
        return null;
    }

    try{
        String entrada = JOptionPane.showInputDialog("Ingrese los años de experiencia:");

        if(entrada == null){
            return null;
        }

        aniosExperiencia = Byte.parseByte(entrada);

        if(aniosExperiencia < 0){
            JOptionPane.showMessageDialog(null, "Los años de experiencia no pueden ser negativos.");
            return null;
        }

    }catch(NumberFormatException ex){
        JOptionPane.showMessageDialog(null, "Error en el formato de los años de experiencia.");
        return null;
    }

    Empleado objeto = new Empleado(numeroIdentificacion, nombreCompleto,
                                    tituloProfesional, aniosExperiencia);

    return objeto;
}
    public String registrarIntegranteProyectoDadoCodigo(ArrayList<Proyecto> datos, String codigoProyecto){

    String resultado = "REGISTRAR INTEGRANTE A UN PROYECTO\n";

    if(datos.isEmpty()){
        resultado += "\nNo hay proyectos registrados.";
        return resultado;
    }

    for(Proyecto objeto : datos){

        if(objeto.getCodigo().equalsIgnoreCase(codigoProyecto)){

            Empleado integrante = solicitarDatosEmpleado();

            if(integrante == null){
                return resultado + "\nRegistro cancelado o datos inválidos.";
            }

            objeto.getSuEquipo().add(integrante);

            resultado += "\nIntegrante registrado exitosamente.";
            resultado += "\nProyecto: " + objeto.getCodigo();
            resultado += "\nIntegrante: " + integrante.toString();

            return resultado;
        }
    }

    resultado += "\nNo se encontró un proyecto con el código: " + codigoProyecto;

    return resultado;
}
    public String registrarEquipoProyectoDadoCodigo(ArrayList<Proyecto> datos, String codigoProyecto){

    String resultado = "REGISTRAR EQUIPO A UN PROYECTO\n";

    if(datos.isEmpty()){
        resultado += "\nNo hay proyectos registrados.";
        return resultado;
    }

    boolean encontrado = false;

    for(Proyecto objeto : datos){

        if(objeto.getCodigo().equalsIgnoreCase(codigoProyecto)){

            encontrado = true;

            int cantidad = 0;

            try{
                cantidad = Integer.parseInt(
                    JOptionPane.showInputDialog("Ingrese la cantidad de integrantes a registrar:")
                );

                if(cantidad <= 0){
                    return "La cantidad de integrantes debe ser mayor a cero.";
                }

            }catch(Exception ex){
                return "Cantidad de integrantes inválida.";
            }

            ArrayList<Empleado> equipo = new ArrayList<>();

            for(int i = 0; i < cantidad; i++){

                String numeroIde = JOptionPane.showInputDialog("Número de identificación del integrante " + (i+1) + ":");

                if(numeroIde == null || numeroIde.isBlank()){
                    return "Registro cancelado o identificación vacía.";
                }

                String nombreCompleto = JOptionPane.showInputDialog("Nombre completo del integrante " + (i+1) + ":");

                if(nombreCompleto == null || nombreCompleto.isBlank()){
                    return "Registro cancelado o nombre vacío.";
                }

                String tituloProfesional = JOptionPane.showInputDialog("Título profesional del integrante " + (i+1) + ":");

                if(tituloProfesional == null || tituloProfesional.isBlank()){
                    return "Registro cancelado o título vacío.";
                }

                byte aniosExperiencia;

                try{
                    aniosExperiencia = Byte.parseByte(
                        JOptionPane.showInputDialog("Años de experiencia del integrante " + (i+1) + ":")
                    );
                }catch(Exception ex){
                    return "Años de experiencia inválidos.";
                }

                Empleado integrante = new Empleado(
                    numeroIde,
                    nombreCompleto,
                    tituloProfesional,
                    aniosExperiencia
                );

                equipo.add(integrante);
            }

            objeto.getSuEquipo().addAll(equipo);

            resultado += "\nSe registraron " + cantidad + " integrantes correctamente.";
            resultado += "\nProyecto: " + codigoProyecto;

            break;
        }
    }

    if(!encontrado){
        resultado += "\nNo se encontró el proyecto con código: " + codigoProyecto;
    }

    return resultado;
}
    public void retirarIntegranteProyectoDadoCodigo(ArrayList<Proyecto> datos, String codigoProyecto){

    if(datos.isEmpty()){
        JOptionPane.showMessageDialog(null, "No hay proyectos registrados.");
        return;
    }

    String numeroIdentificacion = JOptionPane.showInputDialog(
            "Ingrese el número de identificación del integrante que desea eliminar:");

    if(numeroIdentificacion == null || numeroIdentificacion.isBlank()){
        JOptionPane.showMessageDialog(null, "Operación cancelada.");
        return;
    }

    for(Proyecto objeto : datos){

        if(objeto.getCodigo().equalsIgnoreCase(codigoProyecto)){

            if(objeto.getSuEquipo().isEmpty()){
                JOptionPane.showMessageDialog(null, "El proyecto no tiene integrantes registrados.");
                return;
            }

            Iterator<Empleado> recorrido = objeto.getSuEquipo().iterator();

            while(recorrido.hasNext()){

                Empleado integrante = recorrido.next();

                if(integrante.getNumeroIde().equalsIgnoreCase(numeroIdentificacion)){

                    recorrido.remove();

                    JOptionPane.showMessageDialog(null,
                            "Integrante eliminado exitosamente del proyecto.");

                    return;
                }
            }

            JOptionPane.showMessageDialog(null,
                    "No se encontró un integrante con esa identificación.");

            return;
        }
    }

    JOptionPane.showMessageDialog(null,
            "No se encontró un proyecto con el código: " + codigoProyecto);
}
    
    public void generarArchivoDeObjetosProyectos(ArrayList<Proyecto> datos){

    String nombreArchivo = "datosProyectos";
    ObjectOutputStream salida = null;

    if(datos.isEmpty()){
        JOptionPane.showMessageDialog(null,
                "No hay proyectos registrados para generar el archivo.");
        return;
    }

    try{

        salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));

        for(Proyecto objeto : datos){
            salida.writeObject(objeto);
        }

        JOptionPane.showMessageDialog(null,
                "¡Operación exitosa!\nArchivo generado: " + nombreArchivo,
                "GENERACIÓN DE ARCHIVO",
                JOptionPane.INFORMATION_MESSAGE);

    }catch(Exception ex){

        JOptionPane.showMessageDialog(null,
                "¡Operación fallida!\nError almacenando datos en archivo "
                + nombreArchivo + "\n" + ex.getMessage(),
                "GENERACIÓN DE ARCHIVO",
                JOptionPane.ERROR_MESSAGE);

    }finally{

        try{
            if(salida != null){
                salida.close();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,
                    "Error cerrando el archivo " + nombreArchivo);
        }
    }
}
    public void generarArchivoDeObjetosClientes(ArrayList<Proyecto> datos){

    String nombreArchivo = "datosClientes";
    ObjectOutputStream salida = null;

    if(datos.isEmpty()){
        JOptionPane.showMessageDialog(null,
                "No hay proyectos registrados para generar el archivo.");
        return;
    }

    try{

        salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));

        for(Proyecto objeto : datos){
            salida.writeObject(objeto.getSuCliente());
        }

        JOptionPane.showMessageDialog(null,
                "¡Operación exitosa!\nArchivo generado: " + nombreArchivo,
                "GENERACIÓN DE ARCHIVO",
                JOptionPane.INFORMATION_MESSAGE);

    }catch(Exception ex){

        JOptionPane.showMessageDialog(null,
                "¡Operación fallida!\nError almacenando datos en archivo "
                + nombreArchivo + "\nRevisar serialización de clases.\n"
                + ex.getMessage(),
                "GENERACIÓN DE ARCHIVO",
                JOptionPane.ERROR_MESSAGE);

    }finally{

        try{
            if(salida != null){
                salida.close();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,
                    "Error cerrando el archivo " + nombreArchivo);
        }
    }
}
    public ArrayList<Proyecto> leerArchivoDeObjetosProyectos(){

    String nombreArchivo = "datosProyectos";
    ObjectInputStream entrada = null;

    ArrayList<Proyecto> datos = new ArrayList<>();

    try{

        entrada = new ObjectInputStream(new FileInputStream(nombreArchivo));

        while(true){

            Proyecto objeto = (Proyecto) entrada.readObject();

            datos.add(objeto);
        }

    }catch(EOFException ex){

        // Se llegó al final del archivo.

    }catch(Exception ex){

        JOptionPane.showMessageDialog(null,
                "¡Operación fallida!\nError recuperando datos desde el archivo "
                + nombreArchivo + "\n" + ex.getMessage(),
                "LECTURA DE ARCHIVO",
                JOptionPane.ERROR_MESSAGE);

        return datos;

    }finally{

        try{
            if(entrada != null){
                entrada.close();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,
                    "Error cerrando el archivo " + nombreArchivo);
        }
    }

    JOptionPane.showMessageDialog(null,
            "¡Operación exitosa!\nProyectos recuperados: " + datos.size(),
            "LECTURA DE ARCHIVO",
            JOptionPane.INFORMATION_MESSAGE);

    return datos;
}
    public ArrayList<Cliente> leerArchivoDeObjetosClientes(){

    String nombreArchivo = "datosClientes";
    ObjectInputStream entrada = null;

    ArrayList<Cliente> datos = new ArrayList<>();

    try{

        entrada = new ObjectInputStream(new FileInputStream(nombreArchivo));

        while(true){

            Cliente objeto = (Cliente) entrada.readObject();

            boolean repetido = false;

            for(Cliente cliente : datos){

                if(cliente.getNumeroIdentificacion().equals(
                        objeto.getNumeroIdentificacion())){

                    repetido = true;
                    break;
                }
            }

            if(!repetido){
                datos.add(objeto);
            }
        }

    }catch(EOFException ex){

        // Se llegó al final del archivo.

    }catch(Exception ex){

        JOptionPane.showMessageDialog(null,
                "¡Operación fallida!\nError recuperando datos desde el archivo "
                + nombreArchivo + "\n" + ex.getMessage(),
                "LECTURA DE ARCHIVO",
                JOptionPane.ERROR_MESSAGE);

        return datos;

    }finally{

        try{
            if(entrada != null){
                entrada.close();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,
                    "Error cerrando el archivo " + nombreArchivo);
        }
    }

    JOptionPane.showMessageDialog(null,
            "¡Operación exitosa!\nClientes recuperados: " + datos.size(),
            "LECTURA DE ARCHIVO",
            JOptionPane.INFORMATION_MESSAGE);

    return datos;
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButtonRegistrarProyecto = new javax.swing.JButton();
        jButtonRegistrarIntegrante = new javax.swing.JButton();
        jButtonRegistrarEquipo = new javax.swing.JButton();
        jButtonEliminarIntegrante = new javax.swing.JButton();
        jButtonActualizarEstado = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonEjecutar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButtonGenerarAchivoProyectos = new javax.swing.JButton();
        jButtonGenerarArchivoClientes = new javax.swing.JButton();
        jButtonLeerArchivoProyecto = new javax.swing.JButton();
        jButtonLeerArchivoCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Proyectos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Código del proyecto / Identificación del gerente o cliente / Tipo de cliente para consulta y registro:");

        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        jButtonRegistrarProyecto.setText("Registrar proyecto ");
        jButtonRegistrarProyecto.addActionListener(this::jButtonRegistrarProyectoActionPerformed);

        jButtonRegistrarIntegrante.setText("Registrar integrante dado Codigo");
        jButtonRegistrarIntegrante.addActionListener(this::jButtonRegistrarIntegranteActionPerformed);

        jButtonRegistrarEquipo.setText("Registrar equipo dado Codigo");
        jButtonRegistrarEquipo.addActionListener(this::jButtonRegistrarEquipoActionPerformed);

        jButtonEliminarIntegrante.setText("Eliminar integrante ");
        jButtonEliminarIntegrante.addActionListener(this::jButtonEliminarIntegranteActionPerformed);

        jButtonActualizarEstado.setText("Actualizar estado ");
        jButtonActualizarEstado.addActionListener(this::jButtonActualizarEstadoActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonRegistrarProyecto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonRegistrarIntegrante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonRegistrarEquipo)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonEliminarIntegrante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonActualizarEstado)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegistrarProyecto)
                    .addComponent(jButtonRegistrarIntegrante)
                    .addComponent(jButtonRegistrarEquipo)
                    .addComponent(jButtonEliminarIntegrante)
                    .addComponent(jButtonActualizarEstado))
                .addGap(35, 35, 35))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Consultas ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consultar todos los proyectos", "Consultar los proyectos en curso", "Consultar el primer proyecto registrado", "Consultar el último proyecto registrado", "Consultar un proyecto (dato: código)", "Consultar el gerente de un proyecto (dato: código)", "Consultar el equipo de un proyecto (dato: código)", "Consultar los proyectos de un gerente (dato: identificación)", "Consultar los proyectos de un cliente (dato: identificación)", "Consultar los proyectos por tipo de cliente (dato: Empresa o PersonaNatural)" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jButtonEjecutar.setText("Ejecutar ");
        jButtonEjecutar.addActionListener(this::jButtonEjecutarActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEjecutar)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Archivos de objetos ");

        jButtonGenerarAchivoProyectos.setText("Generar archivo de proyectos ");
        jButtonGenerarAchivoProyectos.addActionListener(this::jButtonGenerarAchivoProyectosActionPerformed);

        jButtonGenerarArchivoClientes.setText("Generar archivo de clientes ");
        jButtonGenerarArchivoClientes.addActionListener(this::jButtonGenerarArchivoClientesActionPerformed);

        jButtonLeerArchivoProyecto.setText("Leer archivo de proyectos ");
        jButtonLeerArchivoProyecto.addActionListener(this::jButtonLeerArchivoProyectoActionPerformed);

        jButtonLeerArchivoCliente.setText("Leer archivo de clientes ");
        jButtonLeerArchivoCliente.addActionListener(this::jButtonLeerArchivoClienteActionPerformed);

        jTextArea.setEditable(false);
        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane2.setViewportView(jTextArea);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jButtonGenerarAchivoProyectos)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonGenerarArchivoClientes)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonLeerArchivoProyecto)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonLeerArchivoCliente)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGenerarAchivoProyectos)
                    .addComponent(jButtonGenerarArchivoClientes)
                    .addComponent(jButtonLeerArchivoProyecto)
                    .addComponent(jButtonLeerArchivoCliente))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setText("Salir");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButtonRegistrarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarProyectoActionPerformed
        UsaRegistrarProyecto ventana = new UsaRegistrarProyecto(losProyectos);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonRegistrarProyectoActionPerformed

    private void jButtonEliminarIntegranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarIntegranteActionPerformed
        String codigoProyecto = jTextField1.getText().trim();

    if(codigoProyecto.isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese el código del proyecto.");
        return;
    }

    retirarIntegranteProyectoDadoCodigo(losProyectos, codigoProyecto);
    }//GEN-LAST:event_jButtonEliminarIntegranteActionPerformed

    private void jButtonActualizarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonActualizarEstadoActionPerformed

    private void jButtonGenerarArchivoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarArchivoClientesActionPerformed
        generarArchivoDeObjetosClientes(losProyectos);
    }//GEN-LAST:event_jButtonGenerarArchivoClientesActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonRegistrarIntegranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarIntegranteActionPerformed
        String codigoProyecto = jTextField1.getText().trim();

    if(codigoProyecto.isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese el código del proyecto.");
        return;
    }

    String resultado = registrarIntegranteProyectoDadoCodigo(losProyectos, codigoProyecto);

    JOptionPane.showMessageDialog(null, resultado);
    }//GEN-LAST:event_jButtonRegistrarIntegranteActionPerformed

    private void jButtonRegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarEquipoActionPerformed
        String codigoProyecto = jTextField1.getText().trim();

    if(codigoProyecto.isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese el código del proyecto.");
        return;
    }

    String resultado = registrarEquipoProyectoDadoCodigo(losProyectos, codigoProyecto);

    JOptionPane.showMessageDialog(null, resultado);
    }//GEN-LAST:event_jButtonRegistrarEquipoActionPerformed

    private void jButtonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEjecutarActionPerformed
        String resultado = "";
    String dato = jTextField1.getText().trim();

    switch(jComboBox1.getSelectedIndex()){

        case 0:
            resultado = consultarTodosProyectos(losProyectos);
            break;

        case 1:
            resultado = consultarProyectosEnCurso(losProyectos);
            break;

        case 2:
            resultado = consultarPrimerProyecto(losProyectos);
            break;

        case 3:
            resultado = consultarUltimoProyecto(losProyectos);
            break;

        case 4:
            resultado = consultarProyectoDadoCodigo(losProyectos, dato);
            break;

        case 5:
            resultado = consultarGerenteProyectoDadoCodigo(losProyectos, dato);
            break;

        case 6:
            resultado = consultarEquipoProyectoDadoCodigo(losProyectos, dato);
            break;

        case 7:
            resultado = consultarProyectosDadoNumIDEGerente(losProyectos, dato);
            break;

        case 8:
            resultado = consultarProyectosDadoNumIDECliente(losProyectos, dato);
            break;

        case 9:
            resultado = consultarProyectosDadoTipoCliente(losProyectos, dato);
            break;
    }

    jTextArea.setText(resultado);

    }//GEN-LAST:event_jButtonEjecutarActionPerformed

    private void jButtonGenerarAchivoProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarAchivoProyectosActionPerformed
        generarArchivoDeObjetosProyectos(losProyectos);
    }//GEN-LAST:event_jButtonGenerarAchivoProyectosActionPerformed

    private void jButtonLeerArchivoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeerArchivoProyectoActionPerformed

    losProyectos = leerArchivoDeObjetosProyectos();
    jTextArea.setText(consultarTodosProyectos(losProyectos));
    }//GEN-LAST:event_jButtonLeerArchivoProyectoActionPerformed

    private void jButtonLeerArchivoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeerArchivoClienteActionPerformed
        ArrayList<Cliente> losClientes = leerArchivoDeObjetosClientes();

    String resultado = "CLIENTES RECUPERADOS DEL ARCHIVO\n";

    for(Cliente objeto : losClientes){
        resultado += objeto.toString() + "\n\n";
    }

    jTextArea1.setText(resultado);
    }//GEN-LAST:event_jButtonLeerArchivoClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new UsaProyectoGUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonActualizarEstado;
    private javax.swing.JButton jButtonEjecutar;
    private javax.swing.JButton jButtonEliminarIntegrante;
    private javax.swing.JButton jButtonGenerarAchivoProyectos;
    private javax.swing.JButton jButtonGenerarArchivoClientes;
    private javax.swing.JButton jButtonLeerArchivoCliente;
    private javax.swing.JButton jButtonLeerArchivoProyecto;
    private javax.swing.JButton jButtonRegistrarEquipo;
    private javax.swing.JButton jButtonRegistrarIntegrante;
    private javax.swing.JButton jButtonRegistrarProyecto;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
