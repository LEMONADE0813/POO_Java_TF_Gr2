/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Cliente;
import Modelo.Contacto;
import Modelo.Empleado;
import Modelo.Empresa;
import Modelo.PersonaNatural;
import Modelo.Proyecto;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author SamuelOT
 */
public class UsaRegistrarProyecto extends javax.swing.JFrame {
    
    private ArrayList<Proyecto> losProyectos = new ArrayList<>();
    
    public String generarCodigo(ArrayList<Proyecto> losProyectos){
        int contador = losProyectos.size() + 1;
        return "PROY-" + contador;
        
    }
    public ArrayList<Proyecto> registrarProyecto(ArrayList<Proyecto> losProyectos){
        String codigo;
        String titulo;
        LocalDate fechaInicio = null;
        String unidadDuracion;
        byte duracionEstimada=0;
        String estado;
        
        boolean entradaInvalida = false;
        String msgEntradaInvalida = "¡Operación fallida!.\nEntrada inválida.";
        titulo = jTextFieldTitulo.getText();        
        if(titulo.isEmpty() || titulo.isBlank()){
            entradaInvalida = true;           
            msgEntradaInvalida += "\n Titulo: vacio, Obligatorio";
        }else if(titulo.length()<20 || titulo.length()>100 ){
            entradaInvalida = true;           
            msgEntradaInvalida += "\n Titulo: Se necesita una cantidad de 20 a 100 caracteres";
        }
        try{
            fechaInicio = LocalDate.parse(jTextFieldFechaInicio.getText());
        } catch(DateTimeException ex){
            entradaInvalida = true;
            msgEntradaInvalida += "\nFecha inicio: error formato." + ex.getMessage();
        }
        
        unidadDuracion = jComboBoxUnidadDuracion.getSelectedItem().toString();
        if (unidadDuracion.equals("")){
            entradaInvalida = true;
            msgEntradaInvalida += "\n Unidad de Duracion: No se selecciono una opcion";
        }
        estado = jComboBoxEstado.getSelectedItem().toString();
        
        try{
            duracionEstimada = Byte.parseByte(jTextFieldDuracionEstimada.getText());
        } catch(NumberFormatException ex){
            entradaInvalida = true;
            msgEntradaInvalida += "\nDuracion Estimada: error formato." + ex.getMessage();
        }
        switch (unidadDuracion){
            case("Semanas"):
                if (duracionEstimada<1 || duracionEstimada>3){
                    entradaInvalida = true;
                    msgEntradaInvalida += "\n Duracion Estima: Falla en la lógica, si la unidad de duracion es Semanas su duracion debe estar entre 1 y 3";
                }
                break;
            case("Meses"):
                if (duracionEstimada<1 || duracionEstimada>11 || duracionEstimada<13 || duracionEstimada>23 || duracionEstimada<25 || duracionEstimada>35 ){
                    entradaInvalida = true;
                    msgEntradaInvalida += "\n Duracion Estima: Falla en la lógica, si la unidad de duracion es Meses su duracion debe estar entre 1 y 11, o entre 13 y 23, o máximo entre 25 y 35";
                }
                break;
            case("Años"):
                if (duracionEstimada<1 || duracionEstimada>3){
                    entradaInvalida = true;
                    msgEntradaInvalida += "\n Duracion Estima: Falla en la lógica, si la unidad de duracion es Años su duracion debe estar entre 1 año minimo y 3 años maximo";
                }
                break;
        }
        Cliente suCliente;
        String numeroIdentificacion;
        String nombre;
        String nombreCiudad;
        
        numeroIdentificacion = jTextFieldNumeroIdentificacion1.getText();        
        if(numeroIdentificacion.isEmpty() || numeroIdentificacion.isBlank()){
            entradaInvalida = true;           
            msgEntradaInvalida += "\n Numero Identificacion: vacio, Obligatorio";
        }
        
        nombre = jTextFieldNombre1.getText();        
        if(nombre.isEmpty() || nombre.isBlank()){
            entradaInvalida = true;           
            msgEntradaInvalida += "\n Nombre: vacio, Obligatorio";
        }
        
        nombreCiudad = jTextFieldNombreCiudad1.getText();        
        if(nombreCiudad.isEmpty() || nombreCiudad.isBlank()){
            entradaInvalida = true;           
            msgEntradaInvalida += "\n Nombre Ciudad: vacio, Obligatorio";
        }
        
        String tipoCliente = jComboBoxTipo1.getSelectedItem().toString().toUpperCase();
        
        String numeroTelefono = null;
        String correo = null;
        
        Contacto suContacto;
        String nombreCompleto = null;
        String cargo = null;
        String telefono = null;
        String correoElectronico = null;
        
        switch(tipoCliente){
            case "PERSONA NATURAL":
                numeroTelefono = jTextFieldNumeroTelefonoPer1.getText();        
                if(numeroTelefono.isEmpty() || numeroTelefono.isBlank()){
                    entradaInvalida = true;           
                    msgEntradaInvalida += "\n Numero Telefono: vacio, Obligatorio";
                }
                    
                correo = jTextFieldCorreoElectronicoPer1.getText();        
                if(correo.isEmpty() || correo.isBlank()){
                    entradaInvalida = true;           
                    msgEntradaInvalida += "\n Correo: vacio, Obligatorio";
                }
                break;
            case "EMPRESA":
                nombreCompleto = jTextFieldNombreContacto1.getText();        
                if(nombreCompleto.isEmpty() || nombreCompleto.isBlank()){
                    entradaInvalida = true;           
                    msgEntradaInvalida += "\n Nombre Completo: vacio, Obligatorio";
                }
                
                cargo = jTextFieldCargo1.getText();        
                if(cargo.isEmpty() || cargo.isBlank()){
                    entradaInvalida = true;           
                    msgEntradaInvalida += "\n Cargo: vacio, Obligatorio";
                }
                
                telefono = jTextFieldNumeroTelefonicoEmp1.getText();        
                if(telefono.isEmpty() || telefono.isBlank()){
                    entradaInvalida = true;           
                    msgEntradaInvalida += "\n Numero Telefono: vacio, Obligatorio";
                }
                correoElectronico = jTextFieldCorreoElectronicoEmp1.getText();        
                if(correoElectronico.isEmpty() || correoElectronico.isBlank()){
                    entradaInvalida = true;           
                    msgEntradaInvalida += "\n Correo: vacio, Obligatorio";
                }
                break;
                
        }
        Empleado suGerente;
        ArrayList<Empleado> suEquipo;
        String numeroIde;
        String nombreComp;
        String tituloProfesional;
        byte aniosExperiencia = 0;
        
                
        numeroIde = jTextFieldNumeroIde.getText();        
        if(numeroIde.isEmpty() || numeroIde.isBlank()){
            entradaInvalida = true;           
            msgEntradaInvalida += "\n Numero Identificacion: vacio, Obligatorio";
        }
        
        nombreComp = jTextFieldNombreCompleto.getText();        
        if(nombreComp.isEmpty() || nombreComp.isBlank()){
            entradaInvalida = true;           
            msgEntradaInvalida += "\n Nombre Completo: vacio, Obligatorio";
        }
        
        tituloProfesional = jTextFieldTituloProfesional.getText();        
        if(tituloProfesional.isEmpty() || tituloProfesional.isBlank()){
            entradaInvalida = true;           
            msgEntradaInvalida += "\n Nombre Completo: vacio, Obligatorio";
        }
        
        try{
            aniosExperiencia = Byte.parseByte(jTextFieldAniosProfesional.getText());
        } catch(NumberFormatException ex){
            entradaInvalida = true;
            msgEntradaInvalida += "\nAños Experiencia: error formato." + ex.getMessage();
        }
        
        if(entradaInvalida){
            JOptionPane.showMessageDialog(null, msgEntradaInvalida, "REGISTRO", JOptionPane.ERROR_MESSAGE);
        }else{
            codigo = generarCodigo(losProyectos);
            jTextFieldCodigo.setText("codigo");
            Proyecto objeto = null;
            switch(tipoCliente){
                case "PERSONA NATURAL":
                    suCliente = new PersonaNatural(numeroTelefono,  correo,  numeroIdentificacion,  nombre,  nombreCiudad);
                    suGerente = new Empleado (numeroIde, nombreComp, tituloProfesional, aniosExperiencia);
                    suEquipo = new ArrayList<> ();
                    objeto = new Proyecto (codigo, titulo, fechaInicio, unidadDuracion, duracionEstimada, suCliente, suGerente, suEquipo, estado);
                    break;
                    
                case "EMPRESA":
                    suContacto = new Contacto (nombreCompleto,  cargo,  telefono, correoElectronico);
                    suCliente = new Empresa (suContacto, numeroIdentificacion, nombre, nombreCiudad);
                    suGerente = new Empleado (numeroIde, nombreComp, tituloProfesional, aniosExperiencia);
                    suEquipo = new ArrayList<> ();
                    objeto = new Proyecto (codigo, titulo, fechaInicio, unidadDuracion, duracionEstimada, suCliente, suGerente, suEquipo, estado);
                    break;
            }
            losProyectos.add(objeto);
            jTextFieldCodigo.setText(generarCodigo(losProyectos));
            JOptionPane.showMessageDialog(null, "¡Operación exitosa!.", "REGISTRO", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        return losProyectos;
        
    }
    public void inicializarEntradasRegistro(){
        jTextFieldAniosProfesional.setText("");
        jTextFieldDuracionEstimada.setText("");
        jTextFieldFechaInicio.setText("");
        jTextFieldNombreCompleto.setText("");
        jTextFieldNumeroIde.setText("");
        jTextFieldTitulo.setText("");
        jTextFieldTituloProfesional.setText("");
        jTextFieldNumeroIdentificacion1.setText("");
        jTextFieldNombre1.setText("");
        jTextFieldNombreCiudad1.setText("");
        jComboBoxTipo1.setSelectedIndex(0);
        jTextFieldNumeroTelefonoPer1.setText("");
        jTextFieldCorreoElectronicoPer1.setText("");
        jTextFieldNombreContacto1.setText("");
        jTextFieldCargo1.setText("");
        jTextFieldNumeroTelefonicoEmp1.setText("");
        jTextFieldCorreoElectronicoEmp1.setText("");
    }


    /**
     * Creates new form UsaRegistrarProyecto
     */
    public UsaRegistrarProyecto(ArrayList<Proyecto> losProyectos) {
    initComponents();

    this.losProyectos = losProyectos;

    jTextFieldCodigo.setText(generarCodigo(losProyectos));
}
    public UsaRegistrarProyecto() {
        initComponents();
        
        jTextFieldCodigo.setText(generarCodigo(losProyectos));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNumeroTelefonoPer = new javax.swing.JTextField();
        jTextFieldNombreContacto = new javax.swing.JTextField();
        jTextFieldCargo = new javax.swing.JTextField();
        jTextFieldNumeroTelefonicoEmp = new javax.swing.JTextField();
        jTextFieldCorreoElectronicoEmp = new javax.swing.JTextField();
        jTextFieldCorreoElectronicoPer = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jButtonRegistrar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldNumeroIdentificacion = new javax.swing.JTextField();
        jTextFieldNombreCiudad = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jTextFieldFechaInicio = new javax.swing.JTextField();
        jTextFieldDuracionEstimada = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBoxUnidadDuracion = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldNumeroTelefonoPer1 = new javax.swing.JTextField();
        jTextFieldNombreContacto1 = new javax.swing.JTextField();
        jTextFieldCargo1 = new javax.swing.JTextField();
        jTextFieldNumeroTelefonicoEmp1 = new javax.swing.JTextField();
        jTextFieldCorreoElectronicoEmp1 = new javax.swing.JTextField();
        jTextFieldCorreoElectronicoPer1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButtonSalir1 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jButtonRegistrarProyecto = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jComboBoxTipo1 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTextFieldNumeroIdentificacion1 = new javax.swing.JTextField();
        jTextFieldNombreCiudad1 = new javax.swing.JTextField();
        jTextFieldNombre1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jTextFieldAniosProfesional = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldNumeroIde = new javax.swing.JTextField();
        jTextFieldNombreCompleto = new javax.swing.JTextField();
        jTextFieldTituloProfesional = new javax.swing.JTextField();
        jTextFieldCodigo = new javax.swing.JTextField();

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Registrar Cliente");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Persona Natural");

        jLabel16.setText("Numero Identificacion:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Empresa");

        jLabel18.setText("Nombre:");

        jButtonSalir.setBackground(new java.awt.Color(255, 102, 102));
        jButtonSalir.setText("Salir");

        jLabel19.setText("Tipo Cliente:");

        jButtonRegistrar.setBackground(new java.awt.Color(204, 255, 204));
        jButtonRegistrar.setText("Registrar");

        jLabel20.setText("Nombre Ciudad:");

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Persona Natural", "Empresa" }));

        jLabel21.setText("Numero Telefono:");

        jLabel22.setText("Correo Electronico:");

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));

        jLabel23.setText("Nombre Contacto:");

        jLabel24.setText("Cargo:");

        jLabel25.setText("Numero Telefono:");

        jLabel26.setText("Correo Electronico:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Codigo:");

        jLabel3.setText("Titulo:");

        jLabel4.setText("Fecha Inicio:");

        jLabel5.setText("Unidad de Duracion:");

        jLabel6.setText("Duracion Estimada:");

        jTextFieldTitulo.addActionListener(this::jTextFieldTituloActionPerformed);

        jTextFieldFechaInicio.addActionListener(this::jTextFieldFechaInicioActionPerformed);

        jTextFieldDuracionEstimada.addActionListener(this::jTextFieldDuracionEstimadaActionPerformed);

        jLabel8.setText("Estado:");

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INICIADO", "EN CURSO", "CANCELADO", "FINALIZADO", "SUSPENDIDO", "APLAZADO" }));
        jComboBoxEstado.addActionListener(this::jComboBoxEstadoActionPerformed);

        jLabel10.setText("Equipo:");

        jComboBoxUnidadDuracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semanas", "Meses", "Años" }));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Registrar Proyecto");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Registrar Cliente");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Persona Natural");

        jLabel29.setText("Numero Identificacion:");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Empresa");

        jLabel31.setText("Nombre:");

        jButtonSalir1.setBackground(new java.awt.Color(255, 102, 102));
        jButtonSalir1.setText("Salir");
        jButtonSalir1.addActionListener(this::jButtonSalir1ActionPerformed);

        jLabel32.setText("Tipo Cliente:");

        jButtonRegistrarProyecto.setBackground(new java.awt.Color(204, 255, 204));
        jButtonRegistrarProyecto.setText("Registrar");
        jButtonRegistrarProyecto.addActionListener(this::jButtonRegistrarProyectoActionPerformed);

        jLabel33.setText("Nombre Ciudad:");

        jComboBoxTipo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Persona Natural", "Empresa" }));

        jLabel34.setText("Numero Telefono:");

        jLabel35.setText("Correo Electronico:");

        jSeparator3.setForeground(new java.awt.Color(153, 153, 153));

        jLabel36.setText("Nombre Contacto:");

        jLabel37.setText("Cargo:");

        jLabel38.setText("Numero Telefono:");

        jLabel39.setText("Correo Electronico:");

        jTextFieldNumeroIdentificacion1.addActionListener(this::jTextFieldNumeroIdentificacion1ActionPerformed);

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));

        jSeparator5.setForeground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Registro Empleado Gerente");

        jLabel7.setText("Numero de Identificación:");

        jLabel9.setText("Nombre completo:");

        jLabel11.setText("Titulo profesional:");

        jLabel12.setText("Años profesional:");

        jTextFieldCodigo.setEditable(false);
        jTextFieldCodigo.addActionListener(this::jTextFieldCodigoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldTitulo))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxUnidadDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldDuracionEstimada, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel37)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldCargo1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldNombreContacto1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel38)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldNumeroTelefonicoEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel39)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldCorreoElectronicoEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(12, 12, 12)
                                .addComponent(jTextFieldNumeroTelefonoPer1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCorreoElectronicoPer1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator5)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonSalir1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldNumeroIde, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFieldAniosProfesional))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel9))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextFieldNombreCompleto)
                                                    .addComponent(jTextFieldTituloProfesional))))
                                        .addGap(102, 102, 102)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldNombreCiudad1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldNumeroIdentificacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jButtonRegistrarProyecto)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 286, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 285, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxUnidadDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldDuracionEstimada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jTextFieldNumeroIdentificacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jTextFieldNombreCiudad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jTextFieldNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jComboBoxTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel35)
                                    .addComponent(jTextFieldCorreoElectronicoPer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel34)
                                .addComponent(jTextFieldNumeroTelefonoPer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel37)
                                            .addComponent(jTextFieldCargo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel36)
                                        .addComponent(jTextFieldNombreContacto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel38)
                                    .addComponent(jTextFieldNumeroTelefonicoEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39)
                                    .addComponent(jTextFieldCorreoElectronicoEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldNumeroIde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTituloProfesional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldAniosProfesional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegistrarProyecto)
                    .addComponent(jButtonSalir1))
                .addGap(24, 24, 24))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 330, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 330, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTituloActionPerformed

    private void jTextFieldFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFechaInicioActionPerformed

    private void jTextFieldDuracionEstimadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDuracionEstimadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDuracionEstimadaActionPerformed

    private void jComboBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEstadoActionPerformed

    private void jTextFieldNumeroIdentificacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroIdentificacion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroIdentificacion1ActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jButtonRegistrarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarProyectoActionPerformed
        losProyectos = registrarProyecto(losProyectos);
        inicializarEntradasRegistro();
    }//GEN-LAST:event_jButtonRegistrarProyectoActionPerformed

    private void jButtonSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalir1ActionPerformed
        JOptionPane.showMessageDialog(null, "Saliendo del Sistema");
        inicializarEntradasRegistro();
        this.dispose();
    }//GEN-LAST:event_jButtonSalir1ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new UsaRegistrarProyecto().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonRegistrarProyecto;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonSalir1;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JComboBox<String> jComboBoxTipo1;
    private javax.swing.JComboBox<String> jComboBoxUnidadDuracion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextFieldAniosProfesional;
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldCargo1;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldCorreoElectronicoEmp;
    private javax.swing.JTextField jTextFieldCorreoElectronicoEmp1;
    private javax.swing.JTextField jTextFieldCorreoElectronicoPer;
    private javax.swing.JTextField jTextFieldCorreoElectronicoPer1;
    private javax.swing.JTextField jTextFieldDuracionEstimada;
    private javax.swing.JTextField jTextFieldFechaInicio;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNombre1;
    private javax.swing.JTextField jTextFieldNombreCiudad;
    private javax.swing.JTextField jTextFieldNombreCiudad1;
    private javax.swing.JTextField jTextFieldNombreCompleto;
    private javax.swing.JTextField jTextFieldNombreContacto;
    private javax.swing.JTextField jTextFieldNombreContacto1;
    private javax.swing.JTextField jTextFieldNumeroIde;
    private javax.swing.JTextField jTextFieldNumeroIdentificacion;
    private javax.swing.JTextField jTextFieldNumeroIdentificacion1;
    private javax.swing.JTextField jTextFieldNumeroTelefonicoEmp;
    private javax.swing.JTextField jTextFieldNumeroTelefonicoEmp1;
    private javax.swing.JTextField jTextFieldNumeroTelefonoPer;
    private javax.swing.JTextField jTextFieldNumeroTelefonoPer1;
    private javax.swing.JTextField jTextFieldTitulo;
    private javax.swing.JTextField jTextFieldTituloProfesional;
    // End of variables declaration//GEN-END:variables
}
