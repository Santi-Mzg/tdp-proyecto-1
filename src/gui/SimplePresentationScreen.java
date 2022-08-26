package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/tdp.png")));
		setTitle("TdP-DCIC-UNS 2022 :: Pantalla de presentaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 270));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		// Imagen Tdp.
		JLabel imageLabel = new JLabel();
		imageLabel.setIcon(new ImageIcon(getClass().getResource(studentData.getPathPhoto())));
		contentPane.add(imageLabel, BorderLayout.EAST);
		
		// Fecha y hora de ejecución.
		DateTimeFormatter formatFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fecha = formatFecha.format(LocalDateTime.now());
		DateTimeFormatter formatHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		String hora = formatHora.format(LocalDateTime.now());
		
		JLabel fechaYHoraLabel = new JLabel("Esta ventana fue generada el " + fecha + " a las " + hora);
		contentPane.add(fechaYHoraLabel, BorderLayout.SOUTH);
		
		// Información del alumno
		JLabel LULabel = new JLabel("L.U");
		tabInformation.add(LULabel);
		
		JLabel lastNameLabel = new JLabel("Apellido");
		tabInformation.add(LULabel);
		
		JLabel firstNameLabel = new JLabel("Nombre");
		tabInformation.add(LULabel);
		
		JLabel emailLabel = new JLabel("E-mail");
		tabInformation.add(LULabel);
		
		JLabel githubURLLabel = new JLabel("Github URL");
		tabInformation.add(githubURLLabel);
		
		JTextArea LUTextArea =new JTextArea();
		LUTextArea.setEditable(false);
		LUTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		LUTextArea.setText(" "+Integer.toString(studentData.getId()));
		LUTextArea.setForeground(Color.GRAY);
		LUTextArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabInformation.add(LUTextArea);
		
		JTextArea lastNameTextArea = new JTextArea();
		lastNameTextArea.setEditable(false);
		lastNameTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		lastNameTextArea.setText(" "+studentData.getLastName());
		lastNameTextArea.setForeground(Color.GRAY);
		lastNameTextArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabInformation.add(lastNameTextArea);
		
		JTextArea firstNameTextArea = new JTextArea();
		firstNameTextArea.setEditable(false);
		firstNameTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		firstNameTextArea.setText(" "+studentData.getFirstName());
		firstNameTextArea.setForeground(Color.GRAY);
		firstNameTextArea.setFont(new Font("Tahoma", Font.PLAIN, 12));		
		tabInformation.add(firstNameTextArea);
		
		JTextArea emailTextArea = new JTextArea();
		emailTextArea.setEditable(false);
		emailTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		emailTextArea.setText(" "+studentData.getMail());
		emailTextArea.setForeground(Color.GRAY);
		emailTextArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabInformation.add(emailTextArea);
		
		JTextArea githubURLTextArea = new JTextArea();
		githubURLTextArea.setEditable(false);
		githubURLTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		githubURLTextArea.setText(" "+studentData.getGithubURL());
		githubURLTextArea.setForeground(Color.GRAY);
		githubURLTextArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabInformation.add(githubURLTextArea);
		
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(LULabel)
						.addComponent(githubURLLabel)
						.addComponent(emailLabel)
						.addComponent(firstNameLabel)
						.addComponent(lastNameLabel))
					.addGap(10)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(emailTextArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
						.addComponent(firstNameTextArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
						.addComponent(LUTextArea, Alignment.LEADING)
						.addComponent(lastNameTextArea, Alignment.LEADING)
						.addComponent(githubURLTextArea, Alignment.LEADING))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tabInformation.createSequentialGroup()
							.addContainerGap()
							.addComponent(LUTextArea, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
								.addComponent(lastNameTextArea, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lastNameLabel))
							.addGap(18)
							.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
								.addComponent(firstNameTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(firstNameLabel))
							.addGap(18)
							.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
								.addComponent(emailTextArea, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(emailLabel))
							.addGap(18)
							.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
								.addComponent(githubURLTextArea, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(githubURLLabel)))
						.addGroup(gl_tabInformation.createSequentialGroup()
							.addGap(12)
							.addComponent(LULabel)))
					.addContainerGap())
		);
		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane, BorderLayout.WEST);
	}
}
