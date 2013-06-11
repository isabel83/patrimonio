package com.patrimonio.plantillas.client.widgets.dialogs;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Label;

public class DialogoRecepcionarArticulo extends Dialog {
	
	ColumnData cData = new ColumnData();
	
	
	@Override
	protected void onRender(Element parent, int pos) {
		// TODO Auto-generated method stub
		super.onRender(parent, pos);
				 		    
		setHeading("Introduce las cantidades recepcionadas y la fecha para cada artículo");
		setLayout(new BorderLayout());
		setModal(true);
		setSize(875, 50);
		//setHideOnButtonClick(true);
		addStyleName("dlgBusqueda");
		
		//CREAMOS EL FORMULARIO CON LOS CAMPOS ADECUADOS
		
		FormPanel cp = new FormPanel();
		cp.setHeaderVisible(false);
		cp.setBorders(false);
		cp.setBodyBorder(false);
		
		FormData formData = new FormData("100%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
				

		LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingTop", "15px");
	  
	    LayoutContainer top = new LayoutContainer();
	    top.setStyleAttribute("paddingBottom", "10px");
	    FormLayout layout = new FormLayout();
	    layout.setLabelAlign(LabelAlign.TOP);
	    top.setLayout(layout);
	    
	    LayoutContainer subMain = new LayoutContainer();  
	    subMain.setLayout(new ColumnLayout());  
	    
	    LayoutContainer midRight = new LayoutContainer();  
	    midRight.setStyleAttribute("paddingLeft", "10px");
	    midRight.setStyleAttribute("paddingTop", "20px");
	    FormLayout lay = new FormLayout(); 
	    lay.setLabelAlign(LabelAlign.TOP);
	    midRight.setLayout(lay);  
	   
	    
	    LayoutContainer midLeft = new LayoutContainer();  
	    midLeft.setStyleAttribute("paddingRight", "10px");
	    lay = new FormLayout();  
	    lay.setLabelAlign(LabelAlign.TOP);
	    midLeft.setLayout(lay); 
	    
	    LayoutContainer left = new LayoutContainer();  
	    left.setStyleAttribute("paddingRight", "10px");  
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    left.setLayout(layout);
	  
	    LayoutContainer right = new LayoutContainer(); 
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	    
	    TextField<String> txtMarca = new TextField<String>();  
	    txtMarca.setFieldLabel("Marca");
	    txtMarca.setValue("Aqui va la marca del artículo o nada si no tiene marca");
	    
	    TextField<String> txtObservaciones = new TextField<String>();  
	    txtObservaciones.setFieldLabel("Observaciones");
	    txtObservaciones.setValue("Aqui va algun tipo de dato a tener en cuenta para la peticion de este artículo");
	    
	    TextField<String> txtArticulo = new TextField<String>();  
		txtArticulo.setFieldLabel("Artículo");
		txtArticulo.setValue("12-003-9999999");	
		
		Label lblArticulo = new Label("Texto con la descripción del artículo");
			  
		TextField<String> txtCantidad = new TextField<String>();  
		txtCantidad.setFieldLabel("Cantidad de la petición");
		txtCantidad.setValue("25");
		left.add(txtCantidad,formData);
				
		TextField<String> txtCantidadR = new TextField<String>();  
		txtCantidadR.setFieldLabel("Cantidad recepcionada");
		txtCantidadR.setValue("0");
		right.add(txtCantidadR,formData);
		
		//left.add(null, formData);
		
		TextField<String> txtCantidadA = new TextField<String>();  
		txtCantidadA.setFieldLabel("Cantidad anulada");
		txtCantidadA.setValue("0");
		left.add(txtCantidadA,formData);
		
				
	    final TextField<String> fechaRecepcion = new TextField<String>();  
	    fechaRecepcion.setFieldLabel("Fecha de recepción");
	    fechaRecepcion.setVisible(false);
	    left.add(fechaRecepcion,formData);
	    
	    final TextField<String> txtCantRecepciona = new TextField<String>();  
	    txtCantRecepciona.setFieldLabel("Cantidad que se recepciona");
	    txtCantRecepciona.setVisible(false);
		left.add(txtCantRecepciona,formData);
		
		final CheckBox completo = new CheckBox();  
		completo.setFieldLabel("Recepcionado completo");
		completo.setStyleAttribute("float", "left");
		completo.setVisible(false);
		left.add(completo, formData);
		
		
		final ButtonGroup btnsRecepcion = new ButtonGroup(2);
	    Button btnAcepta  = new Button();
		Button btnCancela = new Button();
	    btnAcepta.setText("Aceptar recepción de artículo");
	    btnAcepta.setStyleAttribute("padding-right", "5px");
	    btnCancela.setText("Cancelar");	    
		btnCancela.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				fechaRecepcion.setVisible(false);
				txtCantRecepciona.setVisible(false);
				completo.setVisible(false);
				btnsRecepcion.setVisible(false);
			}
			
		});
		btnsRecepcion.setVisible(false);
		btnsRecepcion.add(btnAcepta);
		btnsRecepcion.add(btnCancela);
		left.add(btnsRecepcion, formData);
	    
	    midLeft.add(txtArticulo,formData);
	    midRight.add(lblArticulo, formData);
	    subMain.add(midLeft,new ColumnData(.3));
	    subMain.add(midRight,new ColumnData(.7));
	    top.add(subMain,formData);
	    top.add(txtMarca,formData);
	    top.add(txtObservaciones,formData);
	    
	    DataProxy proxy = null; 
	    
 		final BasePagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
 	            proxy, new BeanModelReader());  
 	        loader.setRemoteSort(true); 
 	    
 	    final PagingToolBar pagingToolBar = new PagingToolBar(50); 
 	    pagingToolBar.bind(loader);
 	    pagingToolBar.setStyleName("paginacion");
	    
	    
	    
	    main.add(top, new ColumnData(1));
	    main.add(left, new ColumnData(.5));  
	    main.add(right, new ColumnData(.5));  
	    cp.setBottomComponent(pagingToolBar);
	    
	    cp.add(main, new FormData("100%"));  
		add(cp);
		

	    setButtons(Dialog.YESNOCANCEL);
	    
	    getButtonById(Dialog.YES).setText("Recepcionar artículos");
		getButtonById(Dialog.YES).setStyleAttribute("padding-right", "5px");
		getButtonById(Dialog.YES).addListener(Events.OnClick, new Listener<BaseEvent>(){ 
	    	
			@Override
			public void handleEvent(BaseEvent be) {
				fechaRecepcion.setVisible(true);
				txtCantRecepciona.setVisible(true);
				completo.setVisible(true);
				btnsRecepcion.setVisible(true);
			}
	    	
	    });
	    getButtonById(Dialog.NO).setText("Salir");
		getButtonById(Dialog.NO).setStyleAttribute("padding-right", "5px");
	    getButtonById(Dialog.NO).addListener(Events.OnClick, new Listener<BaseEvent>(){ 
	    	
			@Override
			public void handleEvent(BaseEvent be) {
				hide();
			}
	    	
	    });
	    getButtonById(Dialog.CANCEL).setText("Buscar");
	    getButtonById(Dialog.CANCEL).addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				DialogoBuscar buscar = new DialogoBuscar();
				buscar.show();
			}
	    	
	    });

	}
}
