package com.patrimonio.plantillas.client.widgets.dialogs;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
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
import com.patrimonio.plantillas.shared.RpcUtilsArticulos;
import com.patrimonio.plantillas.shared.RpcUtilsFamilias;
import com.patrimonio.plantillas.shared.RpcUtilsProveedores;
import com.patrimonio.plantillas.shared.RpcUtilsSecciones;
import com.patrimonio.plantillas.shared.RpcUtilsSubfamilias;

public class DialogoNuevoArticulo extends Dialog{
	
	RpcUtilsArticulos artiUtils = new RpcUtilsArticulos();
	RpcUtilsSecciones secUtils = new RpcUtilsSecciones();
	RpcUtilsFamilias famiUtils = new RpcUtilsFamilias();
	RpcUtilsSubfamilias subUtils = new RpcUtilsSubfamilias();
	protected long seccion=0;
	protected long familia=0;
	protected long subfamilia=0;
	
	
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
			setSize(875, 730);
		}
		else if(darBaja){
			setHeading("Baja de artículo");
			setSize(875, 730);
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
	    
	    ListStore<BaseModel> secciones = new ListStore<BaseModel>();  
	    secUtils.loadSeccionesCombo(secciones);
	  
	    final ComboBox<BaseModel> comboSeccion = new ComboBox<BaseModel>();  
	    comboSeccion.setEmptyText("Selecciona una sección");  
	    comboSeccion.setStore(secciones);  
	    comboSeccion.setDisplayField("nombre");  
	    comboSeccion.setValueField("id");
	    comboSeccion.setFieldLabel("Sección");
	    comboSeccion.setWidth(100);  
	    comboSeccion.setEnabled(true);
	    left.add(comboSeccion, formData);

	    final ListStore<BaseModel> familias = new ListStore<BaseModel>();  
	    final ComboBox<BaseModel> comboFamilia = new ComboBox<BaseModel>();  
	    comboFamilia.setEmptyText("Selecciona una familia");  
	    comboFamilia.setStore(familias);  
	    comboFamilia.setDisplayField("nombre");  
	    comboFamilia.setValueField("id");
	    comboFamilia.setFieldLabel("Familia");
	    comboFamilia.setWidth(100);  
	    comboFamilia.setEnabled(false);
	    
	    right.add(comboFamilia,formData);
	    
	    final ListStore<BaseModel> subFamilia = new ListStore<BaseModel>();  
	    final ComboBox<BaseModel> comboSubFamilia = new ComboBox<BaseModel>();  
	    comboSubFamilia.setEmptyText("Selecciona una subfamilia");  
	    comboSubFamilia.setStore(subFamilia);  
	    comboSubFamilia.setDisplayField("nombre");  
	    comboSubFamilia.setValueField("id");
	    comboSubFamilia.setFieldLabel("Subfamilia");
	    comboSubFamilia.setWidth(100);  
	    comboSubFamilia.setEnabled(false);
	    
	    right.add(comboSubFamilia,formData);
	    
	    
	    
	    final TextField<String> codigoArt = new TextField<String>();  
	    codigoArt.setFieldLabel("Código de Artículo");
	    bottom.add(codigoArt,formData);
	    
	    final TextField<String> nombreArt = new TextField<String>();  
	    nombreArt.setFieldLabel("Nombre del artículo");
	    bottom.add(nombreArt,formData);
	    
	    final TextField<String> marcaArt = new TextField<String>();  
	    marcaArt.setFieldLabel("Marca del artículo");
	    bottom.add(marcaArt,formData);
	    
	    final TextField<String> obsArt = new TextField<String>();  
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
	    
	    final TextField<String> minimas = new TextField<String>();  
	    cpExistencias.add(lblMinimas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(minimas, new RowData(-1, -1, new Margins(10)));
	    
	    
	    Label lblIdoneas = new Label();
	    lblIdoneas.setText("Idoneas");
	    
	    final TextField<String> idoneas = new TextField<String>();  

	    cpExistencias.add(lblIdoneas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(idoneas, new RowData(-1, -1, new Margins(10)));
	    
	    
	    Label lblReales = new Label();
	    lblReales.setText("Reales");
	    
	    final TextField<String> reales = new TextField<String>();  

	    cpExistencias.add(lblReales, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(reales, new RowData(-1, -1, new Margins(10)));
	    
	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
	    
	    if(darBaja || consultaArt){
			ColumnConfig column = new ColumnConfig();  
		    column.setId("nif");  
		    column.setHeader("NIF");  
		    column.setWidth(200);  
		    column.setRowHeader(true);  
		    configs.add(column);  
		  
		    column = new ColumnConfig();  
		    column.setId("nombre");  
		    column.setHeader("Nombre");  
		    column.setWidth(200);  
		    configs.add(column);  
		  
		    column = new ColumnConfig();  
		    column.setId("actividad");  
		    column.setHeader("Actividad");  
		    column.setWidth(200); 
		    configs.add(column);  
		    
		}
		else{
			ColumnConfig column = new ColumnConfig();  
		    column.setId("marca");  
		    column.setHeader("Marca");  
		    column.setWidth(200);  
		    column.setRowHeader(true);  
		    configs.add(column);  
		  
		    column = new ColumnConfig();  
		    column.setId("nif");  
		    column.setHeader("NIF");  
		    column.setWidth(200);  
		    configs.add(column);  
		  
		    column = new ColumnConfig();  
		    column.setId("nombre");  
		    column.setHeader("Nombre");  
		    column.setWidth(200); 
		    configs.add(column);  
		  
		    column = new ColumnConfig();  
		    column.setId("actividad");  
		    column.setHeader("Actividad");  
		    column.setWidth(200); 
		    configs.add(column);  
		}
	    
	    
	    final ListStore<BaseModel> store = new ListStore<BaseModel>();
	  //  store.add(getStocks()); //(REVISAR ESTO PORQUE DA ERROR EN LA DEMO)
	    
	    final ColumnModel cm = new ColumnModel(configs);  
	  
	    final Grid<BaseModel> grid = new Grid<BaseModel>(store,cm);
	    grid.setBorders(false);  
	    grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  

	    
	    ContentPanel cpProveedores = new ContentPanel();  
	    cpProveedores.setBodyBorder(false);  
	    cpProveedores.setHeading("Proveedores");
	    cpProveedores.setButtonAlign(HorizontalAlignment.CENTER);  
	    cpProveedores.setLayout(new FitLayout());
	    cpProveedores.setFrame(true);
	    cpProveedores.setHeight("200px");
	    
	    cpProveedores.add(grid);
	    
	    bottom.add(cpExistencias,formData);
	    
	    
	    DataProxy proxy = null; 
	    
 		final BasePagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
 	            proxy, new BeanModelReader());  
 	        loader.setRemoteSort(true); 
 	    
 	    final PagingToolBar pagingToolBar = new PagingToolBar(50); 
 	    pagingToolBar.bind(loader);
 	    pagingToolBar.setStyleName("paginacion dialog Left");
 	   
	    
 	   /*LE DAMOS A LOS COMBOS EL LISTENER*/
	    comboSeccion.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				if(se.getSelectedItem()!=null){ //estamos vaciando el panel
					seccion = se.getSelectedItem().get("id");
					famiUtils.loadFamiliasComboFiltrado(familias, seccion);
					comboFamilia.setEnabled(true);
					comboFamilia.recalculate();
				}
			}
	    	
	    });
	    
	    comboFamilia.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				if(se.getSelectedItem()!=null){ //estamos vaciando el panel
					familia = se.getSelectedItem().get("id");
					subUtils.loadSubFamiliasComboFiltrado(subFamilia, familia);
					comboSubFamilia.setEnabled(true);
					comboSubFamilia.recalculate();
				}
			}
	    	
	    });
	    
	    comboSubFamilia.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				if(se.getSelectedItem()!=null)
				subfamilia = se.getSelectedItem().get("id");
			}
	    	
	    });
	    
	   
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
			
			else{
				//Estamos en un nuevo articulo
				getButtonById(Dialog.YES).addListener(Events.OnClick, new Listener<BaseEvent>(){ 
					
					@Override
					public void handleEvent(BaseEvent be) {
						artiUtils.checkValuesAndSaveArticulo((int)seccion,(int)familia,(int)subfamilia,Integer.parseInt(codigoArt.getValue()),nombreArt.getValue(),
						marcaArt.getValue(),obsArt.getValue(),Integer.parseInt(minimas.getValue()),Integer.parseInt(idoneas.getValue()));
					}
					
				});
			}
			
			
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
//				comboSeccion.clear();
//				comboFamilia.clear();
//				comboSubFamilia.clear();
//				codigoArt.clear();
//				nombreArt.clear();
//				marcaArt.clear();
//				obsArt.clear();
//				minimas.clear();
//				idoneas.clear();
//				reales.clear();
//				grid.reconfigure(store, cm);
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
