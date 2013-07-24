package com.patrimonio.plantillas.client.widgets.forms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadConfig;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.patrimonio.plantillas.client.services.ProveedorService;
import com.patrimonio.plantillas.client.services.ProveedorServiceAsync;
import com.patrimonio.plantillas.shared.RpcUtilsArticulos;
import com.patrimonio.plantillas.shared.RpcUtilsFamilias;
import com.patrimonio.plantillas.shared.RpcUtilsProveedores;
import com.patrimonio.plantillas.shared.RpcUtilsSecciones;
import com.patrimonio.plantillas.shared.RpcUtilsSubfamilias;
import com.patrimonio.plantillas.shared.clases.Proveedores;

public class NuevoArticulo extends FormPanel{

	RpcUtilsArticulos artiUtils = new RpcUtilsArticulos();
	RpcUtilsProveedores provUtils = new RpcUtilsProveedores();
	RpcUtilsSecciones secUtils = new RpcUtilsSecciones();
	RpcUtilsFamilias famiUtils = new RpcUtilsFamilias();
	RpcUtilsSubfamilias subUtils = new RpcUtilsSubfamilias();
	
	ProveedorServiceAsync proService = GWT.create(ProveedorService.class);
	
	protected long seccion=0;
	protected long familia=0;
	protected long subfamilia=0;
	
	@Override
	protected void onRender(Element parent, int pos) {
		super.onRender(parent, pos);
		
		FormData formData = new FormData("100%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		
		setHeaderVisible(false);
		setExpanded(true);
		setAutoHeight(true);
		setBodyBorder(false);
		setBorders(false);
		setStyleName("DND");
		setSize("100%", "100%");  
		setLabelAlign(LabelAlign.TOP);  
		setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
	    final LayoutContainer main = new LayoutContainer();  
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
	    bottom.setStyleAttribute("paddingRight", "10px");
	    
	    
	   
	    ListStore<BaseModel> secciones = new ListStore<BaseModel>();  
	    secUtils.loadSeccionesCombo(secciones);
	  
	    final ComboBox<BaseModel> comboSeccion = new ComboBox<BaseModel>();  
	    comboSeccion.setEmptyText("Selecciona una sección");  
	    comboSeccion.setStore(secciones);  
	    comboSeccion.setDisplayField("nombre");  
	    comboSeccion.setValueField("id");
	    comboSeccion.setFieldLabel("Sección");
	    comboSeccion.setWidth(150);  
	    comboSeccion.setEnabled(true);
	    
	    
	    left.add(comboSeccion, formData);

	    final ListStore<BaseModel> familias = new ListStore<BaseModel>();  
	    final ComboBox<BaseModel> comboFamilia = new ComboBox<BaseModel>();  
	    comboFamilia.setEmptyText("Selecciona una familia");  
	    comboFamilia.setStore(familias);  
	    comboFamilia.setDisplayField("nombre");  
	    comboFamilia.setValueField("id");
	    comboFamilia.setFieldLabel("Familia");
	    comboFamilia.setWidth(150);  
	    comboFamilia.setEnabled(false);
	    
	    right.add(comboFamilia,formData);
	    
	    final ListStore<BaseModel> subFamilia = new ListStore<BaseModel>();  
	    final ComboBox<BaseModel> comboSubFamilia = new ComboBox<BaseModel>();  
	    comboSubFamilia.setEmptyText("Selecciona una subfamilia");  
	    comboSubFamilia.setStore(subFamilia);  
	    comboSubFamilia.setDisplayField("nombre");  
	    comboSubFamilia.setValueField("id");
	    comboSubFamilia.setFieldLabel("Subfamilia");
	    comboSubFamilia.setWidth(150);  
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
	    
	    
	    RowLayout rgtLayout = new RowLayout();
	    rgtLayout.setOrientation(Orientation.HORIZONTAL);
	    ContentPanel cpExistencias = new ContentPanel();
	    cpExistencias.setHeading("Existencias");
	    cpExistencias.setLayout(rgtLayout);  
	    cpExistencias.setHeight("90px");
	    cpExistencias.setFrame(true);
	    cpExistencias.setStyleAttribute("paddingBottom", "10px");
	    
	    Label lblMinimas = new Label();
	    lblMinimas.setText("Mínimas");
	    
	    final TextField<String> minimas = new TextField<String>();  
	    cpExistencias.add(lblMinimas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(minimas, new RowData(-1, -1, new Margins(20,20,20,0)));
	    
	    
	    Label lblIdoneas = new Label();
	    lblIdoneas.setText("Idoneas");
	    
	    final TextField<String> idoneas = new TextField<String>();  

	    cpExistencias.add(lblIdoneas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(idoneas, new RowData(-1, -1, new Margins(20)));
	    
	    
	    Label lblReales = new Label();
	    lblReales.setText("Reales");
	    
	    final Label reales = new Label(); //ES UN COUNT DE LAS IDONEAS - TODAS LAS ENTREGADAS EN PEDIDOS  

	    cpExistencias.add(lblReales, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(reales, new RowData(-1, -1, new Margins(20,20,20,0)));
	    
	    
	    
	    RpcProxy<PagingLoadResult<Proveedores>> proxy = new RpcProxy<PagingLoadResult<Proveedores>>() {  

			@Override
			protected void load(Object loadConfig, AsyncCallback<PagingLoadResult<Proveedores>> callback) {
				proService.findAll((PagingLoadConfig) loadConfig, callback);  
				Log.debug("Hemos cargado el proxy " + callback);
			}  
	    };  
	    
	    final PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);  
		loader.setRemoteSort(true);  
		    	
		   
	    
	    final ListStore<Proveedores> store = new ListStore<Proveedores>(loader);  
	    
	    final PagingToolBar toolBar = new PagingToolBar(30);  
	    toolBar.bind(loader);  
	    
	      
	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
	    
		
		CheckColumnConfig checkColumn = new CheckColumnConfig("ID_ESTADO", "Marcar", 100);  
		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
		checkColumn.setEditor(checkBoxEditor);  
		configs.add(checkColumn); 
	  
	    ColumnConfig column = new ColumnConfig();  
	    column.setId("NIF");  
	    column.setHeader("N.I.F.");  
	    column.setWidth(150);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("NOMBRE");  
	    column.setHeader("Nombre");  
	    column.setWidth(200); 
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("ACTIVIDAD");  
	    column.setHeader("Actividad");  
	    column.setWidth(200); 
	    configs.add(column);  
	    
	      
	    
	    
	    final ColumnModel cm = new ColumnModel(configs);  
	    
	    final Grid<Proveedores> grid = new Grid<Proveedores>(store,cm);
	    grid.setAutoExpandColumn("NOMBRE");  
	    grid.setAutoExpandColumn("ACTIVIDAD");
	    grid.addPlugin(checkColumn);
	    grid.setBorders(false);  
	    grid.setStripeRows(true); 
	    grid.addListener(Events.Attach, new Listener<GridEvent<BeanModel>>(){

			@Override
			public void handleEvent(GridEvent<BeanModel> be) {
				PagingLoadConfig config = new BasePagingLoadConfig();
				config.setOffset(0);
				config.setLimit(30);

				Map<String, Object> state = grid.getState();
				if (state.containsKey("offset")) {
					int offset = (Integer) state.get("offset");
					int limit = (Integer) state.get("limit");
					config.setOffset(offset);
					config.setLimit(limit);
				}

				loader.load(config);
				
			}
	    	
	    });
	    
	    ButtonGroup gButtons = new ButtonGroup(2);
	    Button b1  = new Button(), b2 = new Button();
	    b1.setText("Grabar");
	    b1.setStyleAttribute("padding-right", "5px");
	    b1.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				artiUtils.checkValuesAndSaveArticulo((int)seccion,(int)familia,(int)subfamilia,Integer.parseInt(codigoArt.getValue()),nombreArt.getValue(),
						marcaArt.getValue(),obsArt.getValue(),Integer.parseInt(minimas.getValue()),Integer.parseInt(idoneas.getValue()));
			}
	    });
	    b2.setText("Deshacer");
	    b2.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				MessageBox.confirm("Atención", "Estas a punto de vaciar los datos ¿Estas seguro?", new Listener<MessageBoxEvent>() {

					@Override
					public void handleEvent(MessageBoxEvent be) {
						String button_id = be.getButtonClicked().getItemId();
						if (Dialog.YES == button_id) {
							comboSeccion.clear();
							comboFamilia.clear();
							familias.removeAll();
							comboFamilia.setEnabled(false);
							subFamilia.removeAll();
							comboSubFamilia.clear();
							comboSubFamilia.setEnabled(false);
							codigoArt.clear();
							nombreArt.clear();
							marcaArt.clear();
							obsArt.clear();
							minimas.clear();
							idoneas.clear();
							reales.setText("");
							grid.reconfigure(store, cm);
						}
					}
				});
			}
	    	
	    });
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    bottom.add(cpExistencias,formData);
	    
	    ContentPanel cp = new ContentPanel();  
	    cp.setBodyBorder(false);  
	    cp.setHeading("Proveedores");
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setFrame(true);
	    cp.setHeight("200px");
	    cp.setStyleAttribute("paddingLeft", "10px");
	    cp.setStyleAttribute("paddingRight", "10px");
	    cp.add(grid);
	    
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

	    main.add(cp, new ColumnData(1));
	    main.add(toolBar, new ColumnData(.6));
	    main.add(gButtons, new ColumnData(.4));
	    
	    add(main, new FormData("100%"));
		
	}
}
