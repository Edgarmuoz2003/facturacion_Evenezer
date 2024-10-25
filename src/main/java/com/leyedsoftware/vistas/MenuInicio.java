package com.leyedsoftware.vistas;

import basededatos.ConexionDB;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edgar Muñoz
 */
public class MenuInicio extends javax.swing.JFrame {

    //varibles para los elementos del menú
    private JMenuItem mnVentas;
    private JMenuItem mnProductos;
    private JMenuItem mnClientes;
    private JMenuItem mnInventarios;
    private JMenuItem mnResportes;
    private JMenuItem mnConfig;
    private JMenuItem mnSalir;
    
    //rutas a los Iconos
    private String iconVentas = "/icons/iconoVentas.png";
    private String iconProductos = "/icons/iconoProductos.png"; 
    private String iconClientes = "/icons/iconoClientes.png"; 
    private String iconInventarios = "/icons/iconoInventarios.png";
    private String iconReportes = "/icons/iconoReportes.png";
    private String iconAjustes = "/icons/iconoAjustes.png";
    private String iconSalir = "/icons/iconoSalir.png";
    private String iconBuscar = "/icons/iconBuscar.png";
    private String iconCrear = "/icons/iconCrear.png";
    private String iconEditar = "/icons/iconEditar.png";
    
    //variable para los botones del crud productos
    private JButton btnBuscar;
    private JButton btnCrear;
    private JButton btnModificar;
    
    //variable para crear los botones de gestion de clientes
    private JButton btnBuscarCliente;
    private JButton btnCrearCliente;
    private JButton btnModificarCliente;
    
    //elementos del sub-menú ajustes
    private JMenuItem mnEmpresa;
    private JMenuItem mnResolucion;
    private JMenuItem mnMensajes;
     
    
    Color colorMenu = new Color(24, 127, 220); //Color azul para el menu
    
    public MenuInicio() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        panelBuscar.setLayout(null);
        
        //Creacion de las instancias de cada elemento
        mnVentas = new JMenuItem(" Ventas ", getIcono(iconVentas));
        mnProductos = new JMenuItem(" Productos ", getIcono(iconProductos));
        mnClientes = new JMenuItem(" Clientes ", getIcono(iconClientes));
        mnInventarios = new JMenuItem(" Inventarios ", getIcono(iconInventarios));
        mnResportes = new JMenuItem(" Reportes ", getIcono(iconReportes));
        mnConfig = new JMenu(" Ajustes ");
        mnEmpresa = new JMenuItem(" Empresa ");
        mnMensajes = new JMenuItem(" Mensajes ");
        mnResolucion = new JMenuItem(" Resolución ");
        mnSalir = new JMenuItem(" Salir ", getIcono(iconSalir));
        
        //botones del panelBotones de productos
        btnBuscar = new JButton("Buscar Productos", getIcono(iconBuscar));
        btnCrear = new JButton("Crear Producto", getIcono(iconCrear));
        btnModificar = new JButton("Modificar Producto", getIcono(iconEditar));
        
        //botones del panel de clientes
        btnBuscarCliente = new JButton("Buscar Cliente", getIcono(iconBuscar));
        btnCrearCliente = new JButton("Crear Cliente", getIcono(iconCrear));
        btnModificarCliente = new JButton("Modificar Cliente", getIcono(iconEditar));
        
        //configuraciones opcionales de color de fondo y otros para cada elemento del menú
        
        mnVentas.setOpaque(true);
        mnVentas.setBackground(colorMenu);
        mnVentas.setForeground(Color.WHITE);
        
        mnProductos.setOpaque(true);
        mnProductos.setBackground(colorMenu);
        mnProductos.setForeground(Color.WHITE);
        
        mnClientes.setOpaque(true);
        mnClientes.setBackground(colorMenu);
        mnClientes.setForeground(Color.WHITE);
        
        mnInventarios.setOpaque(true);
        mnInventarios.setBackground(colorMenu);
        mnInventarios.setForeground(Color.WHITE);
        
        mnResportes.setOpaque(true);
        mnResportes.setBackground(colorMenu);
        mnResportes.setForeground(Color.WHITE);
        
        mnConfig.setOpaque(true);
        mnConfig.setBackground(colorMenu);
        mnConfig.setForeground(Color.WHITE);
        
        mnSalir.setOpaque(true);
        mnSalir.setBackground(colorMenu);
        mnSalir.setForeground(Color.WHITE);
        
        //agregar los elementos al menú
        jMenuBar1.add(mnVentas);
        jMenuBar1.add(mnProductos);
        jMenuBar1.add(mnClientes);
        jMenuBar1.add(mnInventarios);
        jMenuBar1.add(mnResportes);
        jMenuBar1.add(mnConfig);
        jMenuBar1.add(mnSalir);
        
        //agregar elementos del sub-menu a Ajustes
        mnConfig.add(mnEmpresa);
        mnConfig.add(mnResolucion);
        mnConfig.add(mnMensajes);
        
        PanelBotones.setLayout(new GridLayout(3, 1)); // 3 filas, 1 columna
        PanelBotones.setPreferredSize(new Dimension(220, 200)); // Ajusta según sea necesario
        
        panelBotonesClientes.setLayout(new GridLayout(3, 1));
        panelBotonesClientes.setPreferredSize(new Dimension(220, 200));
        
        panelTituloProductos.setLayout(new FlowLayout(FlowLayout.CENTER));

        PanelBotones.add(btnBuscar);
        PanelBotones.add(btnCrear);
        PanelBotones.add(btnModificar);
        
        panelBotonesClientes.add(btnBuscarCliente);
        panelBotonesClientes.add(btnCrearCliente);
        panelBotonesClientes.add(btnModificarCliente);
        
        
        
        //tamaño de los botones del panelBotones
        Dimension buttonSize = new Dimension(200, 50); 
        
        btnBuscar.setPreferredSize(buttonSize);
        btnCrear.setPreferredSize(buttonSize);
        btnModificar.setPreferredSize(buttonSize);
        
        btnBuscarCliente.setPreferredSize(buttonSize);
        btnCrearCliente.setPreferredSize(buttonSize);
        btnModificarCliente.setPreferredSize(buttonSize);
                
        //aqui se añade Funcionalidad a los Botones del menú
        mnVentas.addActionListener((ActionEvent e) -> {
            cambiarVista(jPanelVentas);
        });
        
        mnProductos.addActionListener((ActionEvent e) -> {
            cambiarVista(jPanelProductos);
        });
        
        mnClientes.addActionListener((ActionEvent e) -> {
            cambiarVista(jPanelClientes);
        });
        
        mnInventarios.addActionListener((ActionEvent e) -> {
            cambiarVista(jPanelInventarios);
        });
        
        mnResportes.addActionListener((ActionEvent e) -> {
            cambiarVista(jPanelReportes);
        });
        
        mnEmpresa.addActionListener((ActionEvent e) -> {
            cambiarVista(jPanelEmpresa);
        });
        
        mnResolucion.addActionListener((ActionEvent e) -> {
            cambiarVista(jPanelResolucion);
        });
        
        mnMensajes.addActionListener((ActionEvent e) -> {
            cambiarVista(jPanelMensajes);
        });
        
        mnSalir.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        //funcionalidad botones del panelBotones
        btnBuscar.addActionListener((ActionEvent e) -> {
            cambiarVistaProductos(panelBuscar);
        });
        
        btnCrear.addActionListener((ActionEvent e) -> {
            cambiarVistaProductos(PanelCrear);
        });
        
        btnModificar.addActionListener((ActionEvent e) -> {
            cambiarVistaProductos(panelModificar);
        });
        
        //funcionalidad botobes Clientes
        btnBuscarCliente.addActionListener((ActionEvent e) -> {
            cambiarVistaClientes(panelBuscarCliente);
        });
        
        btnCrearCliente.addActionListener((ActionEvent e) -> {
            cambiarVistaClientes(PanelCrearCliente);
        });
        
        btnModificarCliente.addActionListener((ActionEvent e) -> {
            cambiarVistaClientes(panelModificarCliente);
        });
        
        txtCodigoModificar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    Connection conexion = ConexionDB.conectar();
                    String Codigo = txtCodigoModificar.getText();
                    
                    try{
                        String sql = "SELECT * FROM productos WHERE Codigo = ?";
                        PreparedStatement pst = conexion.prepareStatement(sql);
                        pst.setString(1, Codigo);

                        ResultSet rs = pst.executeQuery();
                        
                        if (!rs.isBeforeFirst()) {
                            JOptionPane.showMessageDialog(null, "No se encontraron productos con ese Código. Verifique e intente nuevamente.", "Producto no encontrado", JOptionPane.WARNING_MESSAGE);
                        } else {
                            while (rs.next()){
                                txtDescripcionModificar.setText(rs.getString("Descripcion"));
                                txtStockModificar.setText(String.valueOf(rs.getInt("Stock")));
                                txtPrecioModificar.setText(String.valueOf(rs.getInt("Precio")));
                                txtImpuestoModificar.setText(String.valueOf(rs.getInt("Impuesto")));
                                txtCategoriaModificar.setText(rs.getString("Categoria"));
                            }
                        }
                        rs.close();
                        pst.close();
                        conexion.close();
                    } catch (SQLException ex){
                        ex.printStackTrace();
                    }                   
                }
            }
        });
        
        //llamado a funcion que pone el efecto hover.
       ponerHover(mnSalir);
       ponerHover(mnProductos);
       ponerHover(mnClientes);
       ponerHover(mnVentas);
       ponerHover(mnInventarios);
       ponerHover(mnResportes);
       ponerHover(mnConfig);
       ponerHover(mnSalir);
       
       //metodo para buscar clientes
       txtDocCliente.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e){
               if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                   try {
                       //crear estancia de la coneccion
                       Connection conexion = ConexionDB.conectar();
                       
                       //traer datos del formulario
                       int Documento = Integer.parseInt(txtDocCliente.getText());
                       
                       //preparamos la consulta sql y los datos en el pst
                       String sql = "SELECT * FROM clientes WHERE Documento = ?";
                       PreparedStatement pst = conexion.prepareStatement(sql);
                       pst.setInt(1, Documento);
                       
                       //hacer consultar y recibir respuesta en variable resulset
                       ResultSet rs = pst.executeQuery();
                       
                       //creamos un modelo de tabla para pintar los datos y limpiamos antes de agregar las filas
                       DefaultTableModel modelo = (DefaultTableModel) tablaResultadosClientes.getModel();
                       modelo.setRowCount(0);
                       
                       //usamos condicionales y el metodo isBeforeFirst que nos devuelve false si no hay resultados para responder el usuario
                       if (!rs.isBeforeFirst()){
                           JOptionPane.showMessageDialog(null, "No se encontraron Clientes con ese Documento. Verifique e intente nuevamente.", "Cliente no encontrado", JOptionPane.WARNING_MESSAGE);
                       } else {
                           while(rs.next()){
                               //creamos un array para recibir todos los datos
                               Object[] fila = new Object[5];
                               
                               //asignamos que dato va ir en cada Posición
                               fila[0]= rs.getInt("Documento");
                               fila[1]= rs.getString("Nombre");
                               fila[2]= rs.getString("Direccion");
                               fila[3]= rs.getString("Telefono");
                               fila[4]= rs.getString("Ciudad");
                               
                               modelo.addRow(fila);
                           }
                       }
                   } catch (SQLException ex) {
                       ex.printStackTrace();
                   }
               }
           }
       });
       
       txtDocModificarC.addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    Connection conexion = ConexionDB.conectar();
                    String Documento = txtDocModificarC.getText();
                    
                    try{
                        String sql = "SELECT * FROM clientes WHERE Documento = ?";
                        PreparedStatement pst = conexion.prepareStatement(sql);
                        pst.setString(1, Documento);

                        ResultSet rs = pst.executeQuery();
                        
                        if (!rs.isBeforeFirst()) {
                            JOptionPane.showMessageDialog(null, "No se encontraron clientes con ese Documento. Verifique e intente nuevamente.", "Producto no encontrado", JOptionPane.WARNING_MESSAGE);
                        } else {
                            while (rs.next()){
                                txtNombreModificarC.setText(rs.getString("Nombre"));
                                txtDirModificarC.setText(rs.getString("Direccion"));
                                txtTelModificarC.setText(rs.getString("Telefono"));
                                txtCiudadModificarC.setText(rs.getString("Ciudad"));
                            }
                        }
                        rs.close();
                        pst.close();
                        conexion.close();
                    } catch (SQLException ex){
                        ex.printStackTrace();
                    }
                }
           }
       });
 
       
       //metodo para buscar productos
       jTextCodigoBuscar.addKeyListener(new KeyAdapter() {
         @Override
            public void keyPressed(KeyEvent e) {
               if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Connection conexion = ConexionDB.conectar();
                String Codigo = jTextCodigoBuscar.getText();

                try {
                    String sql = "SELECT * FROM productos WHERE Codigo = ?";
                    PreparedStatement pst = conexion.prepareStatement(sql);
                    pst.setString(1, Codigo);

                    ResultSet rs = pst.executeQuery();

                    DefaultTableModel modelo = (DefaultTableModel) tablaResultados.getModel();
                    modelo.setRowCount(0);  // Limpiar la tabla antes de agregar nuevas filas

                    if (!rs.isBeforeFirst()) {
                        // Si no hay resultados
                        JOptionPane.showMessageDialog(null, "No se encontraron productos con ese Código. Verifique e intente nuevamente.", "Producto no encontrado", JOptionPane.WARNING_MESSAGE);
                     } else {
                        while (rs.next()) {
                            // Obtener los datos del ResultSet y agregarlos como fila
                            Object[] fila = new Object[5];  // Suponiendo que tienes 5 columnas

                            fila[0] = rs.getString("Codigo");
                            fila[1] = rs.getString("Descripcion");
                            fila[2] = rs.getInt("Stock");
                            fila[3] = rs.getDouble("Precio");
                            fila[4] = rs.getString("Categoria");

                            modelo.addRow(fila);  // Añadir la fila al modelo de la tabla
                         }
                    }
                    
                    jTextCodigoBuscar.setText("");
                    rs.close();
                    pst.close();
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();  // Manejar excepciones
                }
            }
        }
    });

    }
    
    //funcion para poner efecto hover
    private void ponerHover(JMenuItem boton){
        boton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(Color.GRAY); // color al pasar el ratón
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(colorMenu); // Volver al color original
            }
        });
    }
    
    //funcion para obtener el icono usando la ruta como parametro, 
    private Icon getIcono(String ruta){
        return new ImageIcon(new ImageIcon(getClass().getResource(ruta)).getImage().getScaledInstance(30, 30, 0));
    }
    
    //Funcion para cambiar entre los poneles que contienen las vistas
    private void cambiarVista(JPanel panel){
        panel.setSize(jPanelPrincipal.getWidth(), jPanelPrincipal.getHeight());//para que se adapte al tamaño del panel principal
        jPanelPrincipal.removeAll();//para cerrar lo que este abierto
        jPanelPrincipal.add(panel);//añdimos el panel que se verá
        jPanelPrincipal.repaint();//re-cargamos su contenido
        
        activarVista(panel); //llamamos a la funcion activarVista y le pasamos el panel con su contenido para que lo muestre.
    }
    
    //Se crea funcion para acultar los demas paneles y mostrar solo el que se pasa por parametro
    private void activarVista(JPanel panel){
        //cerramos cada panel que hayamos creado.
        jPanelProductos.setEnabled(false);
        jPanelProductos.setVisible(false);
        
       jPanelClientes.setEnabled(false);
       jPanelClientes.setVisible(false); 
       
       jPanelVentas.setEnabled(false);
       jPanelVentas.setVisible(false);
       
       
       panel.setVisible(true);
       panel.setEnabled(true);
    }
    
    //funciones para cambiar las vistas de productos
    private void cambiarVistaProductos(JPanel panel){
        panel.setSize(panelCrudProductos.getWidth(), panelCrudProductos.getHeight());
        panelCrudProductos.removeAll();
        panelCrudProductos.add(panel);
        jPanelProductos.repaint();
        panelCrudProductos.repaint();
        
        activarVistaProductos(panel);
    }
    
    private void activarVistaProductos(JPanel panel){
        
        panelBuscar.setEnabled(false);
        panelBuscar.setVisible(false);
        
        PanelCrear.setEnabled(false);
        PanelCrear.setVisible(false);
        
        panelModificar.setEnabled(false);
        panelModificar.setVisible(false);
        
        panel.setVisible(true);
        panel.setEnabled(true);
    }
    
     //funciones para cambiar las vistas de clientes
    private void cambiarVistaClientes(JPanel panel){
        panel.setSize(panelContenidoClientes.getWidth(), panelContenidoClientes.getHeight());
        panelContenidoClientes.removeAll();
        panelContenidoClientes.add(panel);
        panelContenidoClientes.repaint();
        
        activarVistaClientes(panel);
    }
    
    private void activarVistaClientes(JPanel panel){
        
        panelBuscarCliente.setEnabled(false);
        panelBuscarCliente.setVisible(false);
        
        PanelCrearCliente.setEnabled(false);
        PanelCrearCliente.setVisible(false);
        
        panelModificarCliente.setEnabled(false);
        panelModificarCliente.setVisible(false);
        
        panel.setVisible(true);
        panel.setEnabled(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelPrincipal = new javax.swing.JPanel();
        jPanelVentas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelNit = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanelProductos = new javax.swing.JPanel();
        panelTituloProductos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        PanelBotones = new javax.swing.JPanel();
        panelCrudProductos = new javax.swing.JPanel();
        panelBuscar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        jTextCodigoBuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnBuscarRegistros = new javax.swing.JButton();
        PanelCrear = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Precio = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCodigoCrear = new javax.swing.JTextField();
        txtDescripcionCrear = new javax.swing.JTextField();
        txtPrecioCrear = new javax.swing.JTextField();
        txtImpuestoCrear = new javax.swing.JTextField();
        txtCategoriaCrear = new javax.swing.JTextField();
        txtStockCrear = new javax.swing.JTextField();
        btnGuardarProducto = new javax.swing.JButton();
        panelModificar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Precio1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtCodigoModificar = new javax.swing.JTextField();
        txtDescripcionModificar = new javax.swing.JTextField();
        txtPrecioModificar = new javax.swing.JTextField();
        txtImpuestoModificar = new javax.swing.JTextField();
        txtCategoriaModificar = new javax.swing.JTextField();
        txtStockModificar = new javax.swing.JTextField();
        btnModificarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        btnCancelarProducto = new javax.swing.JButton();
        jPanelClientes = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelBotonesClientes = new javax.swing.JPanel();
        panelContenidoClientes = new javax.swing.JPanel();
        panelBuscarCliente = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaResultadosClientes = new javax.swing.JTable();
        txtDocCliente = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnBuscarClientes = new javax.swing.JButton();
        PanelCrearCliente = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        Precio2 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtDocCrearC = new javax.swing.JTextField();
        txtNombreCrearC = new javax.swing.JTextField();
        txtTelefonoCrearC = new javax.swing.JTextField();
        txtCiudadCrearC = new javax.swing.JTextField();
        txtDireccionCrearC = new javax.swing.JTextField();
        btnGuardarCliente = new javax.swing.JButton();
        panelModificarCliente = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        Precio3 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtDocModificarC = new javax.swing.JTextField();
        txtNombreModificarC = new javax.swing.JTextField();
        txtDirModificarC = new javax.swing.JTextField();
        txtTelModificarC = new javax.swing.JTextField();
        txtCiudadModificarC = new javax.swing.JTextField();
        btnModificarProducto1 = new javax.swing.JButton();
        btnEliminarProducto1 = new javax.swing.JButton();
        btnCancelarProducto1 = new javax.swing.JButton();
        jPanelEmpresa = new javax.swing.JPanel();
        jPanelInventarios = new javax.swing.JPanel();
        jPanelReportes = new javax.swing.JPanel();
        jPanelResolucion = new javax.swing.JPanel();
        jPanelMensajes = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelPrincipal.setBackground(new java.awt.Color(153, 153, 255));

        jPanelVentas.setBackground(new java.awt.Color(102, 102, 255));
        jPanelVentas.setBorder(javax.swing.BorderFactory.createTitledBorder("Facturacion"));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setText("Facturación");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la Empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTelefono)
                    .addComponent(labelDireccion)
                    .addComponent(labelNit)
                    .addComponent(labelNombre))
                .addContainerGap(1015, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(labelNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTelefono)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel29.setText("Factura de Venta N°");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel29)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelVentasLayout = new javax.swing.GroupLayout(jPanelVentas);
        jPanelVentas.setLayout(jPanelVentasLayout);
        jPanelVentasLayout.setHorizontalGroup(
            jPanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(615, 615, 615))
            .addGroup(jPanelVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanelVentasLayout.setVerticalGroup(
            jPanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentasLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 1066, Short.MAX_VALUE))
        );

        jPanelProductos.setBackground(new java.awt.Color(102, 102, 255));
        jPanelProductos.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion de Productos"));

        panelTituloProductos.setBackground(new java.awt.Color(102, 153, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel4.setText("Gestion de Productos");

        javax.swing.GroupLayout panelTituloProductosLayout = new javax.swing.GroupLayout(panelTituloProductos);
        panelTituloProductos.setLayout(panelTituloProductosLayout);
        panelTituloProductosLayout.setHorizontalGroup(
            panelTituloProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloProductosLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTituloProductosLayout.setVerticalGroup(
            panelTituloProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloProductosLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel4)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        PanelBotones.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout PanelBotonesLayout = new javax.swing.GroupLayout(PanelBotones);
        PanelBotones.setLayout(PanelBotonesLayout);
        PanelBotonesLayout.setHorizontalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        PanelBotonesLayout.setVerticalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        panelCrudProductos.setLayout(new java.awt.CardLayout());

        jLabel7.setText("Ingrese el Codigo:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setText("Buscar Productos");

        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Stock", "Precio", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaResultados);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Busqueda por Codigo");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setText("Obtener todos los Registros");

        btnBuscarRegistros.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscarRegistros.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnBuscarRegistros.setText("Buscar");
        btnBuscarRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRegistrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBuscarLayout = new javax.swing.GroupLayout(panelBuscar);
        panelBuscar.setLayout(panelBuscarLayout);
        panelBuscarLayout.setHorizontalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(580, 580, 580))
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBuscarLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBuscarLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBuscarLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19)
                                .addGap(133, 133, 133))
                            .addGroup(panelBuscarLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(213, 213, 213)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBuscarLayout.setVerticalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jTextCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBuscarLayout.createSequentialGroup()
                        .addComponent(btnBuscarRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(656, Short.MAX_VALUE))
        );

        panelCrudProductos.add(panelBuscar, "card3");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel8.setText("Crear Productos");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Código:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Descripción:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setText("Stock:");

        Precio.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Precio.setText("Precio:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setText("% Impuesto:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setText("Categoría:");

        btnGuardarProducto.setBackground(new java.awt.Color(153, 153, 0));
        btnGuardarProducto.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnGuardarProducto.setText("Guardar");
        btnGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCrearLayout = new javax.swing.GroupLayout(PanelCrear);
        PanelCrear.setLayout(PanelCrearLayout);
        PanelCrearLayout.setHorizontalGroup(
            PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCrearLayout.createSequentialGroup()
                .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCrearLayout.createSequentialGroup()
                        .addGap(593, 593, 593)
                        .addComponent(jLabel8))
                    .addGroup(PanelCrearLayout.createSequentialGroup()
                        .addGap(660, 660, 660)
                        .addComponent(btnGuardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCrearLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCrearLayout.createSequentialGroup()
                                .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel10))
                                .addGap(295, 295, 295)
                                .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Precio)
                                    .addGroup(PanelCrearLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(PanelCrearLayout.createSequentialGroup()
                                                .addComponent(txtPrecioCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(94, 94, 94)
                                                .addComponent(jLabel12)
                                                .addGap(30, 30, 30)
                                                .addComponent(txtImpuestoCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtDescripcionCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtStockCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelCrearLayout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtCategoriaCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelCrearLayout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(txtCodigoCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        PanelCrearLayout.setVerticalGroup(
            PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCrearLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel8)
                .addGap(51, 51, 51)
                .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDescripcionCrear)
                    .addGroup(PanelCrearLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtCodigoCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))))
                .addGap(30, 30, 30)
                .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtStockCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Precio)
                        .addComponent(txtPrecioCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(txtImpuestoCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(PanelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCategoriaCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 443, Short.MAX_VALUE)
                .addComponent(btnGuardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );

        panelCrudProductos.add(PanelCrear, "card2");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel11.setText("Modificar Productos");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setText("Ingrese el Código Del producto:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setText("Descripción:");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel16.setText("Stock:");

        Precio1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Precio1.setText("Precio:");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel17.setText("% Impuesto:");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel18.setText("Categoría:");

        txtStockModificar.setEnabled(false);

        btnModificarProducto.setBackground(new java.awt.Color(153, 153, 0));
        btnModificarProducto.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnModificarProducto.setText("Guardar Cambios");
        btnModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminarProducto.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        btnCancelarProducto.setBackground(new java.awt.Color(204, 204, 255));
        btnCancelarProducto.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnCancelarProducto.setText("Cancelar");
        btnCancelarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelModificarLayout = new javax.swing.GroupLayout(panelModificar);
        panelModificar.setLayout(panelModificarLayout);
        panelModificarLayout.setHorizontalGroup(
            panelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarLayout.createSequentialGroup()
                .addGroup(panelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModificarLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(panelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelModificarLayout.createSequentialGroup()
                                .addGap(291, 291, 291)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelModificarLayout.createSequentialGroup()
                                .addComponent(Precio1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(jLabel17)
                                .addGap(36, 36, 36)
                                .addComponent(txtImpuestoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(122, 122, 122)
                                .addComponent(jLabel18)
                                .addGap(34, 34, 34)
                                .addComponent(txtCategoriaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelModificarLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(txtDescripcionModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtStockModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelModificarLayout.createSequentialGroup()
                        .addGap(593, 593, 593)
                        .addComponent(jLabel11))
                    .addGroup(panelModificarLayout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(btnModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        panelModificarLayout.setVerticalGroup(
            panelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel11)
                .addGroup(panelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModificarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Precio1)
                            .addComponent(jLabel17)
                            .addComponent(txtImpuestoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(txtCategoriaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelModificarLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcionModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(txtStockModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)))
                .addGap(148, 148, 148)
                .addGroup(panelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(165, 165, 165))
        );

        panelCrudProductos.add(panelModificar, "card4");

        javax.swing.GroupLayout jPanelProductosLayout = new javax.swing.GroupLayout(jPanelProductos);
        jPanelProductos.setLayout(jPanelProductosLayout);
        jPanelProductosLayout.setHorizontalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelTituloProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelProductosLayout.createSequentialGroup()
                        .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCrudProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelProductosLayout.setVerticalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductosLayout.createSequentialGroup()
                .addComponent(panelTituloProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCrudProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelProductosLayout.createSequentialGroup()
                        .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanelClientes.setBackground(new java.awt.Color(102, 102, 255));
        jPanelClientes.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion de Clientes"));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setBackground(new java.awt.Color(153, 153, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("Gestion de Clientes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(526, 526, 526))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout panelBotonesClientesLayout = new javax.swing.GroupLayout(panelBotonesClientes);
        panelBotonesClientes.setLayout(panelBotonesClientesLayout);
        panelBotonesClientesLayout.setHorizontalGroup(
            panelBotonesClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );
        panelBotonesClientesLayout.setVerticalGroup(
            panelBotonesClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );

        panelContenidoClientes.setLayout(new java.awt.CardLayout());

        jLabel20.setText("Ingrese el Documento:");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel21.setText("Buscar Cliente");

        tablaResultadosClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Documento", "Nombre", "Direccion", "Telefono", "Ciudad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaResultadosClientes);

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel22.setText("Busqueda por Documento");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel23.setText("Obtener todos los Registros");

        btnBuscarClientes.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscarClientes.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnBuscarClientes.setText("Buscar");
        btnBuscarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBuscarClienteLayout = new javax.swing.GroupLayout(panelBuscarCliente);
        panelBuscarCliente.setLayout(panelBuscarClienteLayout);
        panelBuscarClienteLayout.setHorizontalGroup(
            panelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscarClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(580, 580, 580))
            .addGroup(panelBuscarClienteLayout.createSequentialGroup()
                .addGroup(panelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBuscarClienteLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBuscarClienteLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(panelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBuscarClienteLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel23)
                                .addGap(133, 133, 133))
                            .addGroup(panelBuscarClienteLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDocCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(213, 213, 213)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBuscarClienteLayout.setVerticalGroup(
            panelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarClienteLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(panelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(panelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(txtDocCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBuscarClienteLayout.createSequentialGroup()
                        .addComponent(btnBuscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        panelContenidoClientes.add(panelBuscarCliente, "card3");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel24.setText("Crear Clientes");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel25.setText("Documento");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel26.setText("Nombre");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel27.setText("Direccion");

        Precio2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Precio2.setText("Telefono");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel28.setText("Ciudad");

        btnGuardarCliente.setBackground(new java.awt.Color(153, 153, 0));
        btnGuardarCliente.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnGuardarCliente.setText("Guardar");
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCrearClienteLayout = new javax.swing.GroupLayout(PanelCrearCliente);
        PanelCrearCliente.setLayout(PanelCrearClienteLayout);
        PanelCrearClienteLayout.setHorizontalGroup(
            PanelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCrearClienteLayout.createSequentialGroup()
                .addGroup(PanelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCrearClienteLayout.createSequentialGroup()
                        .addGap(593, 593, 593)
                        .addComponent(jLabel24))
                    .addGroup(PanelCrearClienteLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(PanelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCrearClienteLayout.createSequentialGroup()
                                .addGroup(PanelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel27))
                                .addGap(295, 295, 295)
                                .addGroup(PanelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Precio2)
                                    .addGroup(PanelCrearClienteLayout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(PanelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(PanelCrearClienteLayout.createSequentialGroup()
                                                .addComponent(txtTelefonoCrearC, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(94, 94, 94)
                                                .addComponent(jLabel28)
                                                .addGap(30, 30, 30)
                                                .addComponent(txtCiudadCrearC, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtNombreCrearC, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(PanelCrearClienteLayout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addGroup(PanelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDireccionCrearC, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDocCrearC, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PanelCrearClienteLayout.createSequentialGroup()
                        .addGap(494, 494, 494)
                        .addComponent(btnGuardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(242, Short.MAX_VALUE))
        );
        PanelCrearClienteLayout.setVerticalGroup(
            PanelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCrearClienteLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(PanelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(txtDocCrearC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombreCrearC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(PanelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(txtDireccionCrearC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCrearClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Precio2)
                        .addComponent(txtTelefonoCrearC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28)
                        .addComponent(txtCiudadCrearC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(109, 109, 109)
                .addComponent(btnGuardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );

        panelContenidoClientes.add(PanelCrearCliente, "card2");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel30.setText("Modificar Productos");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel31.setText("Ingrese el Documento:");

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel32.setText("Nombre:");

        Precio3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Precio3.setText("Direccion:");

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel34.setText("Telefono");

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel35.setText("Ciudad:");

        btnModificarProducto1.setBackground(new java.awt.Color(153, 153, 0));
        btnModificarProducto1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnModificarProducto1.setText("Guardar Cambios");
        btnModificarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProducto1ActionPerformed(evt);
            }
        });

        btnEliminarProducto1.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminarProducto1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnEliminarProducto1.setText("Eliminar");
        btnEliminarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProducto1ActionPerformed(evt);
            }
        });

        btnCancelarProducto1.setBackground(new java.awt.Color(204, 204, 255));
        btnCancelarProducto1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnCancelarProducto1.setText("Cancelar");
        btnCancelarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProducto1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelModificarClienteLayout = new javax.swing.GroupLayout(panelModificarCliente);
        panelModificarCliente.setLayout(panelModificarClienteLayout);
        panelModificarClienteLayout.setHorizontalGroup(
            panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarClienteLayout.createSequentialGroup()
                .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelModificarClienteLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelModificarClienteLayout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(jLabel34)
                                .addGap(28, 28, 28)
                                .addComponent(txtTelModificarC, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel35)
                                .addGap(18, 18, 18)
                                .addComponent(txtCiudadModificarC, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelModificarClienteLayout.createSequentialGroup()
                                .addGap(473, 473, 473)
                                .addComponent(jLabel30))
                            .addGroup(panelModificarClienteLayout.createSequentialGroup()
                                .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNombreModificarC, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelModificarClienteLayout.createSequentialGroup()
                                        .addGap(291, 291, 291)
                                        .addComponent(jLabel31)))
                                .addGap(18, 18, 18)
                                .addComponent(txtDocModificarC, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelModificarClienteLayout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Precio3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDirModificarC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))))
                    .addGroup(panelModificarClienteLayout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(btnModificarProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnEliminarProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnCancelarProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(346, Short.MAX_VALUE))
        );
        panelModificarClienteLayout.setVerticalGroup(
            panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarClienteLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel30)
                .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModificarClienteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txtTelModificarC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addComponent(txtCiudadModificarC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelModificarClienteLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDocModificarC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)
                        .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreModificarC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(Precio3)
                            .addComponent(txtDirModificarC, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)))
                .addGap(148, 148, 148)
                .addGroup(panelModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(165, 165, 165))
        );

        panelContenidoClientes.add(panelModificarCliente, "card4");

        javax.swing.GroupLayout jPanelClientesLayout = new javax.swing.GroupLayout(jPanelClientes);
        jPanelClientes.setLayout(jPanelClientesLayout);
        jPanelClientesLayout.setHorizontalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelClientesLayout.createSequentialGroup()
                .addComponent(panelBotonesClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenidoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPanelClientesLayout.setVerticalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClientesLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelClientesLayout.createSequentialGroup()
                        .addComponent(panelBotonesClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 436, Short.MAX_VALUE))
                    .addGroup(jPanelClientesLayout.createSequentialGroup()
                        .addComponent(panelContenidoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanelEmpresa.setBackground(new java.awt.Color(102, 102, 255));
        jPanelEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajustes de Empresa"));

        javax.swing.GroupLayout jPanelEmpresaLayout = new javax.swing.GroupLayout(jPanelEmpresa);
        jPanelEmpresa.setLayout(jPanelEmpresaLayout);
        jPanelEmpresaLayout.setHorizontalGroup(
            jPanelEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1509, Short.MAX_VALUE)
        );
        jPanelEmpresaLayout.setVerticalGroup(
            jPanelEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
        );

        jPanelInventarios.setBackground(new java.awt.Color(102, 102, 255));
        jPanelInventarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Inventarios"));

        javax.swing.GroupLayout jPanelInventariosLayout = new javax.swing.GroupLayout(jPanelInventarios);
        jPanelInventarios.setLayout(jPanelInventariosLayout);
        jPanelInventariosLayout.setHorizontalGroup(
            jPanelInventariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1619, Short.MAX_VALUE)
        );
        jPanelInventariosLayout.setVerticalGroup(
            jPanelInventariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1031, Short.MAX_VALUE)
        );

        jPanelReportes.setBackground(new java.awt.Color(102, 102, 255));
        jPanelReportes.setBorder(javax.swing.BorderFactory.createTitledBorder("Reportes"));

        javax.swing.GroupLayout jPanelReportesLayout = new javax.swing.GroupLayout(jPanelReportes);
        jPanelReportes.setLayout(jPanelReportesLayout);
        jPanelReportesLayout.setHorizontalGroup(
            jPanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1608, Short.MAX_VALUE)
        );
        jPanelReportesLayout.setVerticalGroup(
            jPanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1013, Short.MAX_VALUE)
        );

        jPanelResolucion.setBackground(new java.awt.Color(102, 102, 255));
        jPanelResolucion.setBorder(javax.swing.BorderFactory.createTitledBorder(" Ajustes de Resolución"));

        javax.swing.GroupLayout jPanelResolucionLayout = new javax.swing.GroupLayout(jPanelResolucion);
        jPanelResolucion.setLayout(jPanelResolucionLayout);
        jPanelResolucionLayout.setHorizontalGroup(
            jPanelResolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1180, Short.MAX_VALUE)
        );
        jPanelResolucionLayout.setVerticalGroup(
            jPanelResolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );

        jPanelMensajes.setBackground(new java.awt.Color(102, 102, 255));
        jPanelMensajes.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajustes de Mensajes Adicionales"));

        javax.swing.GroupLayout jPanelMensajesLayout = new javax.swing.GroupLayout(jPanelMensajes);
        jPanelMensajes.setLayout(jPanelMensajesLayout);
        jPanelMensajesLayout.setHorizontalGroup(
            jPanelMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1506, Short.MAX_VALUE)
        );
        jPanelMensajesLayout.setVerticalGroup(
            jPanelMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(116, Short.MAX_VALUE)))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelResolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(445, Short.MAX_VALUE)))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(119, Short.MAX_VALUE)))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(115, 115, 115)))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(666, Short.MAX_VALUE)))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(246, Short.MAX_VALUE)))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(264, Short.MAX_VALUE)))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelResolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(672, Short.MAX_VALUE)))
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                    .addComponent(jPanelMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 579, Short.MAX_VALUE)))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProductoActionPerformed
        //obtener los valores de los campos del formulario
        String Codigo = txtCodigoCrear.getText();
        String Descripcion = txtDescripcionCrear.getText();
        int Stock = Integer.parseInt(txtStockCrear.getText());
        int Precio = Integer.parseInt(txtPrecioCrear.getText());
        int Impuesto = Integer.parseInt(txtImpuestoCrear.getText());
        String Categoria = txtCategoriaCrear.getText();

        //obtener la conexion y declarar las varibles para sql y Preparedstatement 
        try {
            Connection conexion = ConexionDB.conectar();
            String sql = "INSERT INTO productos (Codigo, Descripcion, Stock, Precio, Impuesto, Categoria) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, Codigo);
            pst.setString(2, Descripcion);
            pst.setInt(3, Stock);            
            pst.setInt(4, Precio);           
            pst.setInt(5, Impuesto);         
            pst.setString(6, Categoria); 

            //enviar la consulta y resibir la respuesta 
            int filasAfectadas = pst.executeUpdate();

            //comprobar si se hicieron cambios y enviar mensaje en torno a eso
            if ( filasAfectadas > 0){
                JOptionPane.showMessageDialog(null, "EL Producto ha sido guardado" );
            } else {
                JOptionPane.showMessageDialog(null, "A ocurrido un error al Guardar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }   
            
            //limpiar los campos
            txtCodigoCrear.setText("");
            txtDescripcionCrear.setText("");
            txtStockCrear.setText("");
            txtPrecioCrear.setText("");
            txtImpuestoCrear.setText("");
            txtCategoriaCrear.setText("");
            
            //cerrar la conexion
            pst.close();
            conexion.close();
        } catch (SQLException ex){
            ex.printStackTrace();

        }    
    }//GEN-LAST:event_btnGuardarProductoActionPerformed

    
    private void btnModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProductoActionPerformed
        //Obtener la Conexion
        Connection conexion = ConexionDB.conectar();
        
        //Recibir los valores del formulario
        String Codigo = txtCodigoModificar.getText();
        String Descripcion = txtDescripcionModificar.getText();
        int Stock = Integer.parseInt(txtStockModificar.getText());
        int Precio = Integer.parseInt(txtPrecioModificar.getText());
        int Impuesto = Integer.parseInt(txtImpuestoModificar.getText());
        String Categoria = txtCategoriaModificar.getText();
        
        //declarar variables para consulta sql y preparedStatement
        try {
            String sql = "UPDATE productos SET Descripcion = ?, Stock = ?, Precio = ?, Impuesto = ?, Categoria = ? WHERE Codigo = ? ";
            PreparedStatement pst = conexion.prepareStatement(sql);
            
            //asignar valores de los campos al pst en el mismo orden que estan en la consulta sql
            pst.setString(1, Descripcion);
            pst.setInt(2, Stock);            
            pst.setInt(3, Precio);           
            pst.setInt(4, Impuesto);         
            pst.setString(5, Categoria);
            pst.setString(6, Codigo);
            
            //relizar la consulta y recibir la respuesta en una varible de tipo Int ya que con executeUpdate lo que llega es el numero de filas afectadas
            int filasAfectadas = pst.executeUpdate();
            
            //configurar la respuesta al cliente
            if (filasAfectadas > 0){
                JOptionPane.showMessageDialog(null, "El priducto ha sido Actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "No ha sido posible actualizar el Producto", "Error Al Actualizar", JOptionPane.ERROR_MESSAGE);
            }
            
            //limpiar los campos
            txtCodigoModificar.setText("");
            txtDescripcionModificar.setText("");
            txtStockModificar.setText("");
            txtPrecioModificar.setText("");
            txtImpuestoModificar.setText("");
            txtCategoriaModificar.setText("");
            
            //cerrar pst y conexion
            pst.close();
            conexion.close();
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
    }//GEN-LAST:event_btnModificarProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        //Obtener Conexion
        Connection conexion = ConexionDB.conectar();
        
        //Obtenemos los valores que necesitaremos del fomulario
        String Codigo = txtCodigoModificar.getText();
        String Descripcion = txtDescripcionModificar.getText();
        
        //confirmar la Eliminacion
        int confirmacion = JOptionPane.showConfirmDialog(null, 
            "¿Estás seguro de que quieres eliminar el producto '" + Descripcion + "'?", 
            "Confirmar eliminación", 
            JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION){
             //crear la consulta y el preparedStatement
            try {
                String sql = "DELETE FROM productos WHERE Codigo = ? ";
                PreparedStatement pst = conexion.prepareStatement(sql);
                
                //asignar valores al pst
                pst.setString(1, Codigo);
                
                //enviar consulta y recibir respuesta
                int filasAfectadas = pst.executeUpdate();
                
                if (filasAfectadas > 0){
                    JOptionPane.showMessageDialog(null, "El producto a sido Eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "No ha sido posible eliminar el Producto", "Error Al Eliminar", JOptionPane.ERROR_MESSAGE);
                }
                
                //limpiar los campos
                txtCodigoModificar.setText("");
                txtDescripcionModificar.setText("");
                txtStockModificar.setText("");
                txtPrecioModificar.setText("");
                txtImpuestoModificar.setText("");
                txtCategoriaModificar.setText("");
                
                //cerrar las conexiones 
                pst.close();
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Eliminacion Cancelada");
            
            //limpiar los campos
            txtCodigoModificar.setText("");
            txtDescripcionModificar.setText("");
            txtStockModificar.setText("");
            txtPrecioModificar.setText("");
            txtImpuestoModificar.setText("");
            txtCategoriaModificar.setText("");
        }  
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnCancelarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProductoActionPerformed
        txtCodigoModificar.setText("");
        txtDescripcionModificar.setText("");
        txtStockModificar.setText("");
        txtPrecioModificar.setText("");
        txtImpuestoModificar.setText("");
        txtCategoriaModificar.setText("");
    }//GEN-LAST:event_btnCancelarProductoActionPerformed

    private void btnBuscarRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRegistrosActionPerformed
        //obtener la conexion
        Connection conexion = ConexionDB.conectar();
        
        //preparar consulta y preparesStatement
        try {
            String sql = "SELECT * FROM productos";
            PreparedStatement pst;
            pst = conexion.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();

            DefaultTableModel modelo = (DefaultTableModel) tablaResultados.getModel();
            modelo.setRowCount(0);  // Limpiar la tabla antes de agregar nuevas filas
            
            if (!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "No se encontraron Registros");
            } else {
                while(rs.next()){
                    // Obtener los datos del ResultSet y agregarlos como fila
                    Object[] fila = new Object[5];  // Suponiendo que tienes 5 columnas

                    fila[0] = rs.getString("Codigo");
                    fila[1] = rs.getString("Descripcion");
                    fila[2] = rs.getInt("Stock");
                    fila[3] = rs.getInt("Precio");
                    fila[4] = rs.getString("Categoria");

                    modelo.addRow(fila);  // Añadir la fila al modelo de la tabla
                }
                
                rs.close();
                pst.close();
                conexion.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnBuscarRegistrosActionPerformed

    private void btnBuscarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClientesActionPerformed
                //obtener la conexion
        Connection conexion = ConexionDB.conectar();
        
        //preparar consulta y preparesStatement
        try {
            String sql = "SELECT * FROM clientes";
            PreparedStatement pst;
            pst = conexion.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();

            DefaultTableModel modelo = (DefaultTableModel) tablaResultadosClientes.getModel();
            modelo.setRowCount(0);  // Limpiar la tabla antes de agregar nuevas filas
            
            if (!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "No se encontraron Registros");
            } else {
                while(rs.next()){
                    // Obtener los datos del ResultSet y agregarlos como fila
                    Object[] fila = new Object[5];  // Suponiendo que tienes 5 columnas

                    fila[0]= rs.getInt("Documento");
                    fila[1]= rs.getString("Nombre");
                    fila[2]= rs.getString("Direccion");
                    fila[3]= rs.getString("Telefono");
                    fila[4]= rs.getString("Ciudad");

                    modelo.addRow(fila);  // Añadir la fila al modelo de la tabla
                }
                
                rs.close();
                pst.close();
                conexion.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnBuscarClientesActionPerformed

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
        //obtener conexion
        Connection conexion = ConexionDB.conectar();

        //obtener datos en variables
        int Documento = Integer.parseInt(txtDocCrearC.getText());
        String Nombre = txtNombreCrearC.getText();
        String Direccion = txtDireccionCrearC.getText();
        String Telefono = txtTelefonoCrearC.getText();
        String Ciudad = txtCiudadCrearC.getText();
        
        try {
            //variables para consulta sql
            String sql = "INSERT INTO clientes (Documento, Nombre, Direccion, Telefono, Ciudad) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pst = conexion.prepareStatement(sql);
            
            //asignar valores al pst
            pst.setInt(1, Documento);
            pst.setString(2, Nombre);
            pst.setString(3, Direccion);
            pst.setString(4, Telefono);
            pst.setString(5, Ciudad);
            
            //hacer consulta con executeUpdate para recibir filas afectadas en la variable
            int affectedRows = pst.executeUpdate();
            
            //responder al usuario
            if ( affectedRows > 0){
                JOptionPane.showMessageDialog(null, "EL Cliente ha sido guardado" );
            } else {
                JOptionPane.showMessageDialog(null, "A ocurrido un error al Guardar el Cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            //limpiar campos
            txtDocCrearC.setText("");
            txtNombreCrearC.setText("");
            txtDireccionCrearC.setText("");
            txtTelefonoCrearC.setText("");
            txtCiudadCrearC.setText("");
            
            //cerrar conexiones para liberar recursos de memoria
            pst.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hay un error de sintaxis en la consulta SQL o No hay Conexion a la Base de Datos", "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void btnModificarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProducto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarProducto1ActionPerformed

    private void btnEliminarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProducto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarProducto1ActionPerformed

    private void btnCancelarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProducto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarProducto1ActionPerformed
   
 
    
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JPanel PanelCrear;
    private javax.swing.JPanel PanelCrearCliente;
    private javax.swing.JLabel Precio;
    private javax.swing.JLabel Precio1;
    private javax.swing.JLabel Precio2;
    private javax.swing.JLabel Precio3;
    private javax.swing.JButton btnBuscarClientes;
    private javax.swing.JButton btnBuscarRegistros;
    private javax.swing.JButton btnCancelarProducto;
    private javax.swing.JButton btnCancelarProducto1;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnEliminarProducto1;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnGuardarProducto;
    private javax.swing.JButton btnModificarProducto;
    private javax.swing.JButton btnModificarProducto1;
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
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelClientes;
    private javax.swing.JPanel jPanelEmpresa;
    private javax.swing.JPanel jPanelInventarios;
    private javax.swing.JPanel jPanelMensajes;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelProductos;
    private javax.swing.JPanel jPanelReportes;
    private javax.swing.JPanel jPanelResolucion;
    private javax.swing.JPanel jPanelVentas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextCodigoBuscar;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelNit;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JPanel panelBotonesClientes;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JPanel panelBuscarCliente;
    private javax.swing.JPanel panelContenidoClientes;
    private javax.swing.JPanel panelCrudProductos;
    private javax.swing.JPanel panelModificar;
    private javax.swing.JPanel panelModificarCliente;
    private javax.swing.JPanel panelTituloProductos;
    private javax.swing.JTable tablaResultados;
    private javax.swing.JTable tablaResultadosClientes;
    private javax.swing.JTextField txtCategoriaCrear;
    private javax.swing.JTextField txtCategoriaModificar;
    private javax.swing.JTextField txtCiudadCrearC;
    private javax.swing.JTextField txtCiudadModificarC;
    private javax.swing.JTextField txtCodigoCrear;
    private javax.swing.JTextField txtCodigoModificar;
    private javax.swing.JTextField txtDescripcionCrear;
    private javax.swing.JTextField txtDescripcionModificar;
    private javax.swing.JTextField txtDirModificarC;
    private javax.swing.JTextField txtDireccionCrearC;
    private javax.swing.JTextField txtDocCliente;
    private javax.swing.JTextField txtDocCrearC;
    private javax.swing.JTextField txtDocModificarC;
    private javax.swing.JTextField txtImpuestoCrear;
    private javax.swing.JTextField txtImpuestoModificar;
    private javax.swing.JTextField txtNombreCrearC;
    private javax.swing.JTextField txtNombreModificarC;
    private javax.swing.JTextField txtPrecioCrear;
    private javax.swing.JTextField txtPrecioModificar;
    private javax.swing.JTextField txtStockCrear;
    private javax.swing.JTextField txtStockModificar;
    private javax.swing.JTextField txtTelModificarC;
    private javax.swing.JTextField txtTelefonoCrearC;
    // End of variables declaration//GEN-END:variables
}
