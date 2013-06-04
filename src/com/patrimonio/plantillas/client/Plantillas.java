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
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.patrimonio.plantillas.client.layouts.LayoutTwoPanels;
import com.patrimonio.plantillas.client.widgets.ButtonWithImageAndText;
import com.patrimonio.plantillas.client.widgets.forms.FormEntradas;
import com.patrimonio.plantillas.client.widgets.menus.MenuNavegacion;
import com.allen_sauer.gwt.log.client.Log;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Plantillas implements EntryPoint {

	private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	private FormPanel formulario;
	
	LayoutTwoPanels layoutPrincipal = new LayoutTwoPanels();

	@Override
	public void onModuleLoad() {
		
		final Label errorLabel = new Label();

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		final RootPanel rootPanel = RootPanel.get("principalContainer");
		
		rootPanel.setLayoutData(layoutPrincipal);
		
		
		formulario = new FormPanel();
		formulario.setLayout(new FormLayout());
		formulario.setHeaderVisible(false);
		formulario.setWidth("550px");
		formulario.setBodyBorder(false);
		formulario.setLabelAlign(LabelAlign.TOP);  
		formulario.setMethod(Method.POST);
		formulario.setButtonAlign(HorizontalAlignment.CENTER);  
		formulario.setAction("../j_spring_security_check");
		
		LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	    
	    LayoutContainer left = new LayoutContainer();  
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    left.setLayout(layout);
	    
	    LayoutContainer right = new LayoutContainer(); 
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout); 
				
		final TextBox nameField = new TextBox();
		nameField.setText("Bego\u00F1a Encinas");
		nameField.setName("j_username");
		nameField.setFocus(true);
		nameField.selectAll();
		nameField.addStyleName("margen");
		
		Label lblNombre = new Label("Usuario:");
		left.add(lblNombre, new FormData("100%"));
		lblNombre.addStyleName("margen");
		right.add(nameField, new FormData("100%"));
		
		
		Label lblNewLabel = new Label("Contrase\u00F1a:");
		lblNewLabel.addStyleName("lblPass");
		left.add(lblNewLabel, new FormData("100%"));
		
		final PasswordTextBox txtPassword = new PasswordTextBox();
		right.add(txtPassword, new FormData("100%"));
		txtPassword.setText("mico");
		txtPassword.setName("j_password");
		txtPassword.addStyleName("margen");
		
		
		final ButtonWithImageAndText btnAceptar = new ButtonWithImageAndText(new Image("resources/images/icons/tick.png"),"Aceptar");
		left.add(btnAceptar, new FormData("100%"));
		btnAceptar.addStyleName("loginButons");
		
		
		ButtonWithImageAndText closeButton = new ButtonWithImageAndText(new Image("resources/images/icons/eject.png"), "Salir");
		right.add(closeButton, new FormData("100%"));
		closeButton.addStyleName("loginButons");
		//btnAceptar.addClickHandler(handler);
	   
	  
	    
	    
	    
	  //vamos añadiendo todo al formulario
  		main.add(left, new ColumnData(.5));
  		main.add(right, new ColumnData(.5));
  		
  		FormData formData = new FormData("100%");
  		formData.setMargins(new Margins(300,0,0,100));
  		formulario.add(main, formData);
  		

  		rootPanel.add(formulario, 664, 332);
		
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				Log.debug("Hemos hecho click en el boton");
				//sendValuesToServer();
				
				
				//**************************POR AHORA OBVIAMOS LA AUTENTICACION****************************//
				rootPanel.clear();
				
				rootPanel.add(new MenuNavegacion(rootPanel));
				
				FormEntradas frm = new FormEntradas();
				frm.setBodyBorder(false);
				frm.setBorders(false);
				frm.setHeaderVisible(false);
				Log.debug("Vamos a añadir el formulario al principal");
				rootPanel.add(frm);	
				
		
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					Log.debug("Hemos pulsado el intro");
					sendValuesToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendValuesToServer() {
				
				final String url = GWT.getHostPageBaseURL() + "/j_spring_security_check";
				Log.debug("El valor de la base url es: " + url);
				
				final RequestBuilder rb = new RequestBuilder(RequestBuilder.POST, url);
				rb.setCallback(new RequestCallback() {

					@Override
					public void onResponseReceived(com.google.gwt.http.client.Request request, Response response) {
						if (response.getStatusCode() == Response.SC_OK) {
							String welcomeMsg = "You are not logged";
							if (response.getText() != null && response.getText().length() > 0) {
								welcomeMsg = "Welcome: " + response.getText();
							}
							Log.debug(welcomeMsg);
						}
					}

					@Override
					public void onError(com.google.gwt.http.client.Request request, Throwable exception) {
						//principalLabel.setText("Can't retrieve principal's name");
					}
				});
				try {
					rb.send();
				} catch (RequestException e) {
					e.printStackTrace();
				}
				
				
				
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				String passToServer = txtPassword.getText();
//				if (!com.patrimonio.plantillas.shared.FieldVerifier.isValidName(textToServer)) {
//					errorLabel.setText("Please enter at least four characters");
//					return;
//				}

				// Then, we send the input to the server.
				//btnAceptar.setEnabled(false);
				 
				Log.debug("Estamos en sendValuesToServer, ANTES DE LA LLAMADA AL SERVER");
				Log.debug("El valor de texto es: " + textToServer);
				Log.debug("El valor de password es: " + passToServer);

				loginService.loginServer(textToServer, passToServer, new AsyncCallback<String>() {
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
	}

}
