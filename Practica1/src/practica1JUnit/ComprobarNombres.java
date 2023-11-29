package practica1JUnit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComprobarNombres extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		ComprobarNombres ventana1 = new ComprobarNombres();
		ventana1.setVisible(true);
		
		String prueba = "usuario@dominio.com";
		String prueba2 = "usuario@dominio";
		
		if (validarCorreo(prueba)) {
			System.out.println( "OK" );
		} else {
			System.out.println( "FAIL" );
		}
		// System.out.println( wrapString( prueba, 3 ) );
		if (!validarCorreo(prueba2)) {
			System.out.println( "OK" );
		} else {
			System.out.println( "FAIL" );
		}
		
		if (validarCorreo(prueba2)) {
			System.out.println( "EL CORREO ESTA BIEN" );
		} else {
			System.out.println( "EL CORREO ESTA MAL" );
		}
	}
	private JTextField txtUsuario;
	
	public ComprobarNombres() {
		//Características de la ventana principal
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(500,300, 500, 250);
		this.setTitle("Sell-It");
		
		//Ceracion de paneles 
		JPanel panelVentanaInicio = new JPanel(new BorderLayout());
		JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panelNorte = new JPanel(new BorderLayout());
		JPanel panelCentro = new JPanel(new GridLayout(3,2));
		
		panelVentanaInicio.add(panelSur, BorderLayout.SOUTH);
		panelVentanaInicio.add(panelNorte, BorderLayout.NORTH);
		panelVentanaInicio.add(panelCentro,BorderLayout.CENTER);
		
		panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelSur.setLayout(new FlowLayout(FlowLayout.CENTER));

		
		this.getContentPane().add(panelVentanaInicio);

		//Creacion de los JTextFields, JLabels, JButtons y JPasswordField
		
		txtUsuario = new JTextField();
		JTextField txtContrasenia = new JTextField();
		JLabel etiquetaUsuario = new JLabel("Correo:");
		JLabel etiquetaContrasenia = new JLabel("Contraseña:");
		
		JButton botonRegistroEntidad = new JButton("Registro Entidad");
		JButton botonRegistroUsuario = new JButton("Registro Usuario");
		JButton botonIniciarSesion = new JButton("Iniciar Sesion");
		
		JLabel etiquetaBienvenido = new JLabel("Bienvenido a Sell-It");
		
		JLabel etiquetaPregunta = new JLabel("¿No tienes cuenta?");
		
		
		//Añadimos los elementos previamente creados a los paneles
		
		panelNorte.add(etiquetaBienvenido,BorderLayout.NORTH);
		panelSur.add(etiquetaPregunta);
		panelSur.add(botonRegistroEntidad);
		panelSur.add(botonRegistroUsuario);
	//	panelSur.add(botonIniciarSesion);
		
		panelCentro.add(etiquetaUsuario);
		panelCentro.add(txtUsuario);
		panelCentro.add(etiquetaContrasenia);
		panelCentro.add(txtContrasenia);	
		
		JPanel panel = new JPanel();
		panelCentro.add(panel);
		panel.add(botonIniciarSesion);
		//panel.add(mostrarContra);		

		//Eventos
		
		 botonIniciarSesion.addActionListener((e) -> {
	            String correo = txtUsuario.getText(); // Obtén el correo del JTextField

	            if (validarCorreo(correo)) {
	                // El correo es válido, puedes realizar acciones adicionales aquí
	                JOptionPane.showMessageDialog(null, "Correo válido");
	            } else {
	                // El correo no es válido, muestra un mensaje de error
	                JOptionPane.showMessageDialog(null, "Correo no válido");
	            }
	        });
		 
	}

	 public String getTxtUsuario() {
		return txtUsuario.getText();
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public static boolean validarCorreo(String correo) {
	        if (correo == null || correo.isEmpty()) {
	            return false; // Correo nulo o vacío es inválido
	        }

	        // Expresión regular para validar un correo electrónico
	        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

	        return correo.matches(regex);
	    }
	 public boolean botonIniciarSesion() {
			String correo = txtUsuario.getText(); // Obtén el correo del JTextField
		    // Validar el correo después de hacer clic
		    return validarCorreo(correo);
		}
}