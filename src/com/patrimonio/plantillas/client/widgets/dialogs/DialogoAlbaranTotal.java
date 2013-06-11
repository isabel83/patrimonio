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
import com.extjs.gxt.ui.client.widget.form.DateField;
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
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Element;
import com.patrimonio.plantillas.client.widgets.Stock;

public class DialogoAlbaranTotal extends Dialog{
	
	boolean consulta;
	
	

	public DialogoAlbaranTotal(boolean b) {
		consulta = b;
	}



	@Override
	protected void onRender(Element parent, int pos) {

		super.onRender(parent, pos);
		
		setHeading("Albarán de Material Servido");
		setLayout(new BorderLayout());
		setModal(true);
		if(!consulta)
			setSize(875, 550);
		else
			setSize(875, 600);
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
	  
	    LayoutContainer l1 = new LayoutContainer();  
	    l1.setStyleAttribute("paddingLeft", "10px");
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    l1.setLayout(layout);  
	    
	    LayoutContainer r1 = new LayoutContainer();
	    r1.setStyleAttribute("paddingLeft", "100px");
	    r1.setStyleAttribute("paddingRight", "10px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    r1.setLayout(layout);  
	    
	    LayoutContainer mid = new LayoutContainer();  
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    mid.setLayout(layout); 
	    mid.setStyleAttribute("padding", "10px");
	    
	    LayoutContainer l2 = new LayoutContainer();  
	    l2.setStyleAttribute("paddingLeft", "10px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    l2.setLayout(layout);  
	    
	    LayoutContainer r2 = new LayoutContainer();
	    r2.setStyleAttribute("paddingLeft", "100px");
	    r2.setStyleAttribute("paddingRight", "10px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    r2.setLayout(layout);
	    
	    TextField<String> numAlbaran = new TextField<String>();  
	    numAlbaran.setFieldLabel("Número de Albarán");
	    l1.add(numAlbaran,formData);
	    
	    
	    DateTimeFormat dtFormat = DateTimeFormat.getFormat("dd-MM-yyyy");
	    DateField fecha = new DateField();
	    fecha.getPropertyEditor().setFormat(dtFormat);
	    fecha.setFieldLabel("Fecha");
	    r1.add(fecha, formData);
	    
	    TextField<String> destinatario = new TextField<String>();  
	    destinatario.setFieldLabel("Destinatario");
	    mid.add(destinatario,formData);
	    
	    TextField<String> seccion = new TextField<String>();  
	    seccion.setFieldLabel("Sección");
	    mid.add(seccion,formData);
	    
	    TextField<String> persona = new TextField<String>();  
	    persona.setFieldLabel("Persona");
	    mid.add(persona,formData);
	    
	    
	    TextField<String> numAlbaranSolicitud = new TextField<String>();  
	    numAlbaranSolicitud.setFieldLabel("Número de Albarán de Solicitud");
	    l2.add(numAlbaranSolicitud,formData);
	    
	    
	    DateField fechaSolicitud = new DateField();
	    fechaSolicitud.getPropertyEditor().setFormat(dtFormat);
	    fechaSolicitud.setFieldLabel("Fecha de la solicitud");
	    r2.add(fechaSolicitud, formData);
	    
	    
	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
	    
	    ColumnConfig column = new ColumnConfig();  
	    column.setId("cantidad");  
	    column.setHeader("Cantidad");  
	    column.setWidth(200);  
	    column.setRowHeader(true);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("codigo");  
	    column.setHeader("Código");  
	    column.setWidth(200);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("articulo");  
	    column.setHeader("Artículo");  
	    column.setWidth(200); 
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
	    grid.setStyleAttribute("borderTop", "none");  
	    grid.setAutoExpandColumn("articulo");  
	    grid.setAutoExpandColumn("observaciones");
	    grid.setBorders(false);  
	    grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
	    grid.setColumnLines(true);
	    

	    
	    ContentPanel cpArticulos = new ContentPanel();  
	    cpArticulos.setBodyBorder(true);  
	    cpArticulos.setHeading("Relación de Artículos Servidos");
	    cpArticulos.setButtonAlign(HorizontalAlignment.CENTER);  
	    cpArticulos.setLayout(new FitLayout());
	    cpArticulos.setFrame(true);
	    cpArticulos.setHeight("200px");
	    cpArticulos.setStyleAttribute("padding", "5px 10px");
	    
	    cpArticulos.add(grid);
	    
	    DataProxy proxy = null; 
	    
 		final BasePagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
 	            proxy, new BeanModelReader());  
 	        loader.setRemoteSort(true); 
 	    
 	    final PagingToolBar pagingToolBar = new PagingToolBar(50); 
 	    pagingToolBar.bind(loader);
 	    pagingToolBar.setStyleName("paginacion Left");
	    
	    
	    main.add(l1, new ColumnData(.5));
	    main.add(r1, new ColumnData(.5));
	    main.add(mid, new ColumnData(1));
	    main.add(l2, new ColumnData(.5));
	    main.add(r2, new ColumnData(.5));
	    main.add(cpArticulos, new ColumnData(1));
	    if(consulta){
	    	main.add(pagingToolBar, new ColumnData(1));
	    }
	   
		cp.add(main, new FormData("100%"));  
		
		add(cp);
		
		
		setButtons(Dialog.YESNOCANCEL);
		
		getButtonById(Dialog.YES).setText("Imprimir");
		getButtonById(Dialog.YES).setEnabled(false);
		getButtonById(Dialog.YES).setStyleAttribute("padding-right", "5px");
		getButtonById(Dialog.NO).setText("Salir");
		getButtonById(Dialog.NO).setStyleAttribute("padding-right", "5px");
		getButtonById(Dialog.NO).addListener(Events.OnClick, new Listener<BaseEvent>(){ 
			
			@Override
			public void handleEvent(BaseEvent be) {
				hide();
			}
			
		});
		getButtonById(Dialog.CANCEL).setText("Devolver");
		if(!consulta){
			getButtonById(Dialog.CANCEL).setVisible(false);
		}
	
	    
	}
	
}
