package com.patrimonio.plantillas.client.widgets.dialogs;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
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
import com.extjs.gxt.ui.client.widget.button.Button;
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
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.patrimonio.plantillas.client.widgets.Stock;

public class DialogoNuevoArticulo extends Dialog{
	
	
	public boolean darBaja;
	public boolean consultaArt; 
	
	public DialogoNuevoArticulo(int valor) {
		if(valor == 1){
			darBaja = true;
			consultaArt = false;
		}
		else if(valor == 2){
			consultaArt = true;
			darBaja = false;
		}
		else{
			consultaArt = darBaja = false;
		}
			
	}

	@Override
	protected void onRender(Element parent, int pos) {
		super.onRender(parent, pos);
		
		if(consultaArt){
			setHeading("Consulta artículos");
		}
		else if(darBaja){
			setHeading("Baja de artículo");
			setSize(875, 725);
		}
		else{
			setHeading("Nuevo artículo");
			setSize(875, 710);
		}
		setLayout(new BorderLayout());
		setModal(true);
		
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
	    
	    
	   
	    Label lblSeccion = new Label("Sección:");
	    lblSeccion.setStyleName("etiqueta");
	    ListBox lstSeccion = new ListBox();
	    lstSeccion.setVisibleItemCount(1);
	    lstSeccion.addItem("3M España S.A.");
	    lstSeccion.addItem("ABAISA S.L.");
	    lstSeccion.addItem("AF STEELCASE S.A.");
	    lstSeccion.addItem("AGUDEL S.L.");
	    lstSeccion.addItem("AHOSMA S.L.");
	    lstSeccion.addItem("...");
	    left.add(lblSeccion,formData);
	    left.add(lstSeccion,formData);

	    Label lblFamilia = new Label("Familia:");
	    lblFamilia.setStyleName("etiqueta");
	    ListBox lstFamilia = new ListBox();
	    lstFamilia.setVisibleItemCount(1);
	    lstFamilia.setWidth("400px");
	    lstFamilia.addItem("AHOSMA S.L.");
	    lstFamilia.addItem("...");
	    right.add(lblFamilia,formData);
	    right.add(lstFamilia,formData);
	    
	    Label lblSubFamilia = new Label("Subfamilia:");
	    lblSubFamilia.setStyleName("etiqueta");
	    ListBox lstSubFamilia = new ListBox();
	    lstSubFamilia.setVisibleItemCount(1);
	    lstSubFamilia.setWidth("400px");
	    lstSubFamilia.addItem("3M España S.A.");
	    lstSubFamilia.addItem("ABAISA S.L.");
	    lstSubFamilia.addItem("...");
	    right.add(lblSubFamilia,formData);
	    right.add(lstSubFamilia,formData);
	    
	    
	    TextField<String> codigoArt = new TextField<String>();  
	    codigoArt.setFieldLabel("Código de Artículo");
	    bottom.add(codigoArt,formData);
	    
	    TextField<String> nombreArt = new TextField<String>();  
	    nombreArt.setFieldLabel("Nombre del artículo");
	    bottom.add(nombreArt,formData);
	    
	    TextField<String> marcaArt = new TextField<String>();  
	    marcaArt.setFieldLabel("Marca del artículo");
	    bottom.add(marcaArt,formData);
	    
	    TextField<String> obsArt = new TextField<String>();  
	    obsArt.setFieldLabel("Observaciones");
	    bottom.add(obsArt,formData);
	    
	    ContentPanel cpExistencias = new ContentPanel();
	    cpExistencias.setHeading("Existencias");
	    cpExistencias.setLayout(new RowLayout(Orientation.HORIZONTAL));  
	    cpExistencias.setSize("820px", "90px");
	    cpExistencias.setFrame(true);
	    cpExistencias.addStyleName("panelDialogo");
	    cpExistencias.setStyleAttribute("paddingBottom", "10px");
	    
	    Label lblMinimas = new Label();
	    lblMinimas.setText("Mínimas");
	    
	    TextField<String> minimas = new TextField<String>();  
	    cpExistencias.add(lblMinimas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(minimas, new RowData(-1, -1, new Margins(10)));
	    
	    
	    Label lblIdoneas = new Label();
	    lblIdoneas.setText("Idoneas");
	    
	    TextField<String> idoneas = new TextField<String>();  

	    cpExistencias.add(lblIdoneas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(idoneas, new RowData(-1, -1, new Margins(10)));
	    
	    
	    Label lblReales = new Label();
	    lblReales.setText("Reales");
	    
	    TextField<String> reales = new TextField<String>();  

	    cpExistencias.add(lblReales, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(reales, new RowData(-1, -1, new Margins(10)));
	    
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
	    

	    
	    ContentPanel cpProveedores = new ContentPanel();  
	    cpProveedores.setBodyBorder(true);  
	    cpProveedores.setHeaderVisible(false);
	    cpProveedores.setButtonAlign(HorizontalAlignment.CENTER);  
	    cpProveedores.setLayout(new FitLayout());
	    cpProveedores.setHeight("200px");
	    
	    cpProveedores.add(grid);
	    
	    bottom.add(cpExistencias,formData);
	    
	    
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
	    main.add(cpProveedores, new ColumnData(1));
	    
	    if(darBaja==true || consultaArt == true){
	    	main.add(pagingToolBar, new ColumnData(1));
	    }
		cp.add(main, new FormData("100%"));  
		
		add(cp);
		
		
		setButtons(Dialog.YESNOCANCEL);
		
		if(!darBaja){
			getButtonById(Dialog.YES).setText("Grabar");
			if(consultaArt)
				getButtonById(Dialog.YES).setEnabled(false);
		}
		else{
			getButtonById(Dialog.YES).setText("Eliminar");
		}
		getButtonById(Dialog.YES).setStyleAttribute("padding-right", "5px");
		if(!darBaja && !consultaArt){
			getButtonById(Dialog.NO).setVisible(false);
		}
		else{
			getButtonById(Dialog.NO).setText("Buscar");
			getButtonById(Dialog.NO).addListener(Events.OnClick, new Listener<BaseEvent>(){ 
				
				@Override
				public void handleEvent(BaseEvent be) {
					DialogoBuscar buscar = new DialogoBuscar();
					buscar.show();
				}
				
			});
			
		}
		getButtonById(Dialog.NO).setStyleAttribute("padding-right", "5px");
		getButtonById(Dialog.CANCEL).setText("Salir");
		getButtonById(Dialog.CANCEL).addListener(Events.OnClick, new Listener<BaseEvent>(){
		
			@Override
			public void handleEvent(BaseEvent be) {
				hide();
			}
			
		});
		
		
		
		if(consultaArt){
			Button modificar = new Button();
			modificar.setText("Modificar");
			modificar.setStyleAttribute("padding-left", "5px");
			getButtonBar().add(modificar);
			Button deshacer = new Button();
			deshacer.setStyleAttribute("padding-left", "5px");
			deshacer.setText("Deshacer");
			getButtonBar().add(deshacer);
			
		}
		

	}

	@Override
	protected void onShow() {
		// TODO Auto-generated method stub
		super.onShow();
		repaint();
	}
	
}
