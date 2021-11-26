package co.edu.unbosque.controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AplMain {

	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            // UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); // NUEVO
		} catch (UnsupportedLookAndFeelException e) {
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
        Controller controller = new Controller();
	}
}
