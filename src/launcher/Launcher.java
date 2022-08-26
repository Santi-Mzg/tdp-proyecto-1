package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student Me = new Student(125932, "Maszong", "Santiago", "santimaszong@gmail.com", "https://github.com/Santi-Mzg", "/images/imagenAlumno.jpg");
            	SimplePresentationScreen frame = new SimplePresentationScreen(Me);
            	frame.setVisible(true);
            }
        });
    }
}