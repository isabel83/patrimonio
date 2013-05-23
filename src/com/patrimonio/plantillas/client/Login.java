package com.patrimonio.plantillas.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Login {

	public void onModuleLoad() {
		final TextBox nameField = new TextBox();
		nameField.setText("Bego\u00F1a Encinas");
		final Label errorLabel = new Label();


		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		
		rootPanel.add(nameField, 664, 332);
		nameField.setSize("143px", "10px");
		nameField.setFocus(true);
		
		ButtonWithImageAndText btnAceptar = new ButtonWithImageAndText(new Image("resources/images/icons/tick.png"),"Aceptar");
		rootPanel.add(btnAceptar, 642, 408);
		btnAceptar.setSize("80px", "30px");
		
		ButtonWithImageAndText closeButton = new ButtonWithImageAndText(new Image("resources/images/icons/eject.png"), "Salir");
		rootPanel.add(closeButton, 788, 408);
		closeButton.setSize("60px", "30px");
		
		
		Label lblNewLabel = new Label("Contrase\u00F1a:");
		rootPanel.add(lblNewLabel, 533, 368);
		
		
		
		PasswordTextBox pswrdtxtbxPrueba = new PasswordTextBox();
		pswrdtxtbxPrueba.setText("mico");
		rootPanel.add(pswrdtxtbxPrueba, 663, 368);
		pswrdtxtbxPrueba.setSize("143px", "6px");
		
		Label lblNombre = new Label("Usuario:");
		rootPanel.add(lblNombre, 534, 332);
		lblNombre.setSize("87px", "18px");
		
		Image image = new Image("resources/images/logoPatrimonioPrueba.png");
		rootPanel.add(image, 348, 71);
		image.setSize("291px", "158px");
		nameField.selectAll();
		
	}
}
