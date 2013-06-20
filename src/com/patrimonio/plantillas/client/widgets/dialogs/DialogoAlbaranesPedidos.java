package com.patrimonio.plantillas.client.widgets.dialogs;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.user.client.Element;
import com.patrimonio.plantillas.client.widgets.Stock;

public class DialogoAlbaranesPedidos extends Dialog{

	boolean soloSolicitado;
	
	public DialogoAlbaranesPedidos(boolean b) {
		soloSolicitado = b;
	}

	@Override
	protected void onRender(Element parent, int pos) {
		super.onRender(parent, pos);
		

		if(soloSolicitado)
			setHeading("Albaranes de material solicitado");
		else
			setHeading("Control de material solicitado y servido");
		setLayout(new BorderLayout());
		setModal(true);
		setSize(875, 550);
		//setHideOnButtonClick(true);
		addStyleName("dlgBusqueda");
		
		//CREAMOS EL FORMULARIO CON LOS CAMPOS ADECUADOS
		
		FormPanel cp = new FormPanel();
		cp.setHeaderVisible(false);
		cp.setBorders(false);
		cp.setBodyBorder(false);
		cp.setLabelAlign(LabelAlign.TOP);  
		
		FormData formData = new FormData("100%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	    main.setBorders(false);
	    
	    LayoutContainer left = new LayoutContainer();  
	    left.setStyleAttribute("paddingLeft", "10px");
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    left.setLayout(layout);  
	    
	    LayoutContainer right = new LayoutContainer();
	    right.setStyleAttribute("paddingLeft", "100px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);
	    
	    LayoutContainer bottom = new LayoutContainer();  
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    bottom.setLayout(layout); 
	    bottom.setStyleAttribute("paddingLeft", "10px");
	    bottom.setStyleAttribute("paddingLRight", "10px");
	    
	    
	    TextField<String> numero = new TextField<String>();  
	    if(!soloSolicitado)
	    	numero.setFieldLabel("Número de solicitud");
	    else
	    	numero.setFieldLabel("Número");
	    left.add(numero,formData);
	    
	    TextField<String> fecha = new TextField<String>();  
	    if(!soloSolicitado)
	    	fecha.setFieldLabel("Fecha");
	    else 
	    	fecha.setFieldLabel("Fecha de pedido");
	    right.add(fecha,formData);
	    
	    TextField<String> seccion = new TextField<String>();  
	    seccion.setFieldLabel("Sección");
	    bottom.add(seccion, formData);
	    
	    TextField<String> destinatario = new TextField<String>();  
	    destinatario.setFieldLabel("Destinatario");
	    bottom.add(destinatario, formData);
	    
	    TextField<String> persona = new TextField<String>();  
	    persona.setFieldLabel("Persona");
	    bottom.add(persona, formData);
	    
	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
	    
	    ColumnConfig column = new ColumnConfig();  
	    column.setId("solicitado");  
	    column.setHeader("Solicitado");  
	    column.setWidth(100);  
	    column.setRowHeader(true);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("servido");  
	    column.setHeader("Servido");  
	    column.setWidth(100);  
	    configs.add(column);
	  
	    column = new ColumnConfig();  
	    column.setId("anulado");  
	    column.setHeader("Anulado");  
	    column.setWidth(100);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("devuelto");  
	    column.setHeader("Devuelto");  
	    column.setWidth(100);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("codigo");  
	    column.setHeader("Código");  
	    column.setWidth(200);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("nombre");  
	    column.setHeader("Nombre");  
	    column.setWidth(300); 
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("observaciones");  
	    column.setHeader("Observaciones");  
	    column.setWidth(200); 
	    configs.add(column);  
	    
	      
	    
	    ListStore<Stock> store = new ListStore<Stock>();
	  //  store.add(getStocks()); //(REVISAR ESTO PORQUE DA ERROR EN LA DEMO)
	    
	    ColumnModel cm = new ColumnModel(configs);  
	  
	    Grid<Stock> grid = new Grid<Stock>(store,cm);
	    grid.setBorders(false);  
	    grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
	    
	    ContentPanel cpArticulos = new ContentPanel();  
	    cpArticulos.setBodyBorder(false);  
	    cpArticulos.setHeading("Relación de artículos de la petición");
	    cpArticulos.setButtonAlign(HorizontalAlignment.CENTER);  
	    cpArticulos.setLayout(new FitLayout());
	    cpArticulos.setHeight("200px");
	    cpArticulos.setFrame(true);
	    cpArticulos.setStyleAttribute("padding", "5px 10px");
	    
	    cpArticulos.add(grid);
	    
	    DataProxy proxy = null; 
	    
 		final BasePagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
 	            proxy, new BeanModelReader());  
 	        loader.setRemoteSort(true); 
 	    
 	    final PagingToolBar pagingToolBar = new PagingToolBar(50); 
 	    pagingToolBar.bind(loader);
 	    pagingToolBar.setStyleName("paginacion Left");
 	   
	    
    
	   
	    main.add(left, new ColumnData(.4));
	    main.add(right, new ColumnData(.6));
	    main.add(bottom, new ColumnData(1));
	    main.add(cpArticulos, new ColumnData(1));
	    main.add(pagingToolBar, new ColumnData(1));
	    
	    setButtons(Dialog.YESNOCANCEL);
		
		getButtonById(Dialog.YES).setText("Anular");
		getButtonById(Dialog.YES).setStyleAttribute("padding-right", "5px");
		getButtonById(Dialog.NO).setText("Imprimir");
		getButtonById(Dialog.NO).setStyleAttribute("padding-right", "5px");
		getButtonById(Dialog.CANCEL).setText("Salir");
		getButtonById(Dialog.CANCEL).addListener(Events.OnClick, new Listener<BaseEvent>(){
		
			@Override
			public void handleEvent(BaseEvent be) {
				hide();
			}
			
		});
		if(!soloSolicitado)
		getButtonById(Dialog.YES).setVisible(false);

		cp.add(main, new FormData("100%"));
		add(cp);
	}
}
