package com.patrimonio.plantillas.client;


import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.patrimonio.plantillas.client.design.ButtonWithImageAndText;
import com.allen_sauer.gwt.log.client.Log;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Plantillas implements EntryPoint {

	private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	private FormPanel formulario;

	@Override
	public void onModuleLoad() {
		
		final Label errorLabel = new Label();

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		
		formulario = new FormPanel();
		formulario.setHeaderVisible(false);
		formulario.setWidth("550px");
		formulario.setBodyBorder(false);
		formulario.setLabelAlign(LabelAlign.TOP);  
		formulario.setMethod(Method.POST);
		formulario.setLabelAlign(LabelAlign.TOP);  
		formulario.setButtonAlign(HorizontalAlignment.CENTER);  
		
		final TextBox nameField = new TextBox();
		nameField.setText("Bego\u00F1a Encinas");
		nameField.setSize("143px", "10px");
		nameField.setFocus(true);
		nameField.selectAll();
		nameField.addStyleName("margen");
		
		Label lblNombre = new Label("Usuario:");
		formulario.add(lblNombre, new FormData("10%"));
		//lblNombre.setSize("87px", "18px");
		lblNombre.addStyleName("margen");
		formulario.add(nameField, new FormData("50%"));
		
		
		Label lblNewLabel = new Label("Contrase\u00F1a:");
		lblNewLabel.addStyleName("margen");
		//lblNewLabel.setSize("87px", "18px");
		formulario.add(lblNewLabel, new FormData("10%"));
		
		
		
		final PasswordTextBox pswrdtxtbxPrueba = new PasswordTextBox();
		formulario.add(pswrdtxtbxPrueba, new FormData("50%"));
		pswrdtxtbxPrueba.setText("mico");
		pswrdtxtbxPrueba.setSize("143px", "10px");
		pswrdtxtbxPrueba.addStyleName("margen");
		
		
		final ButtonWithImageAndText btnAceptar = new ButtonWithImageAndText(new Image("resources/images/icons/tick.png"),"Aceptar");
		formulario.add(btnAceptar, new FormData("50%"));
		btnAceptar.setSize("60px", "30px");
		btnAceptar.addStyleName("margen-left");
		
		
		ButtonWithImageAndText closeButton = new ButtonWithImageAndText(new Image("resources/images/icons/eject.png"), "Salir");
		formulario.add(closeButton, new FormData("50%"));
		closeButton.setSize("60px", "30px");
		closeButton.addStyleName("margen-left");
		//btnAceptar.addClickHandler(handler);
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	   
	  //vamos añadiendo todo al formulario
  		main.add(lblNombre, new ColumnData(.5));
  		main.add(nameField, new ColumnData(.5));
  		main.add(lblNewLabel, new ColumnData(.5));
  		main.add(pswrdtxtbxPrueba, new ColumnData(.5));
  		main.add(btnAceptar, new ColumnData(.3));
  		main.add(closeButton, new ColumnData(.3));
  		FormData formData = new FormData();
  		formData.setMargins(new Margins(300,0,0,100));
  		formulario.add(main, formData);
  		
  		rootPanel.add(formulario, 664, 332);
	    
		
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendValuesToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendValuesToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendValuesToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				String passToServer = pswrdtxtbxPrueba.getText();
				if (!com.patrimonio.plantillas.shared.FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				btnAceptar.setEnabled(false);
				 
				Log.debug("Estamos en sendValuesToServer, ANTES DE LA LLAMADA AL SERVER");
				Log.debug("El valor de texto es: " + textToServer);
				Log.debug("El valor de password es: " + passToServer);

				loginService.loginServer(textToServer, passToServer,  
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								Log.debug("ERROR EN EL SERVIDOR: " + caught.getLocalizedMessage());
							}

							public void onSuccess(String result) {
								Log.debug("Estamos en el onSuccess y el usuario es: " + nameField.getText());
								MessageBox msg = new MessageBox();
								msg.setMessage(result);
									msg.show();
							}
						});
				Log.debug("Estamos DESPUES DE LA LLAMADA AL SERVER");
			}
		}
		
		
		
		MyHandler handler = new MyHandler();
		btnAceptar.addClickHandler(handler);
		
		
		Image image = new Image("resources/images/logoPatrimonioPrueba.png");
		rootPanel.add(image, 348, 71);
		image.setSize("291px", "158px");
	}

}
