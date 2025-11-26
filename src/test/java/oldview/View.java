package oldview;

import javax.swing.*;

public class View {

	String LookAndFeelMetal = "javax.swing.plaf.metal.MetalLookAndFeel";
	public View(){
		String laf = LookAndFeelMetal;
		try{
			UIManager.setLookAndFeel(laf);
		} catch (UnsupportedLookAndFeelException e) {
			System.err.println(laf + "is unsupported");
		} catch (ClassNotFoundException e) {
			System.err.println(laf + "class not found");
		} catch (InstantiationException e) {
			System.err.println(laf + "could not be instantiated");
		} catch (IllegalAccessException e ) {
			System.err.println(laf + "cannot be accessed");
		}

	}

	public void startView(){
		new MainPage();
	}
}