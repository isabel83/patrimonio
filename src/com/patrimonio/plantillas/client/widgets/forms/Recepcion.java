package com.patrimonio.plantillas.client.widgets.forms;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseModel;
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
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.user.client.Element;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoRecepcionTotal;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoRecepcionarArticulo;

public class Recepcion  extends FormPanel{

	@Override
	protected void onRender(Element target, int index) {
		// TODO Auto-generated method stub
		super.onRender(target, index);
		
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
	   
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	  
	    // introducimos los valores a seleccionar para comenzar el pedido
	    LayoutContainer left = new LayoutContainer();  
	    
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    left.setLayout(layout);  
	  
	    TextField<String> numPeticion = new TextField<String>();  
	    numPeticion.setFieldLabel("Número de petición");
	    left.add(numPeticion,formData);
	    
	    
	    // vamos creando el pedido
	    LayoutContainer right = new LayoutContainer(); 
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	  
	    TextField<String> fechaPeticion = new TextField<String>();  
	    fechaPeticion.setFieldLabel("Fecha de la petición");
	    right.add(fechaPeticion,formData);
	    
	    LayoutContainer bottom = new LayoutContainer();  
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    bottom.setLayout(layout); 
	    bottom.getAriaSupport().setPresentation(true);  
	    
	    TextField<String> codigoProveedor = new TextField<String>();  
	    codigoProveedor.setFieldLabel("Proveedor");
	    bottom.add(codigoProveedor,formData);

	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
	    
	    ColumnConfig column = new ColumnConfig();  
	    column.setId("pedido");  
	    column.setHeader("Pedido");  
	    column.setWidth(100);  
	    column.setRowHeader(true);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("recepcion");  
	    column.setHeader("Recepción");  
	    column.setWidth(100);  
	    configs.add(column);  
	    
	    column = new ColumnConfig();  
	    column.setId("anulado");  
	    column.setHeader("Anulado");  
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
	    column.setWidth(200); 
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("observaciones");  
	    column.setHeader("Observaciones");  
	    column.setWidth(200); 
	    configs.add(column);  
	    
	    column = new ColumnConfig();  
	    column.setId("marca");  
	    column.setHeader("Marca");  
	    column.setWidth(200);  
	    configs.add(column);  
	      
	    
	    ListStore<BaseModel> store = new ListStore<BaseModel>();
	  //  store.add(getStocks()); //(REVISAR ESTO PORQUE DA ERROR EN LA DEMO)
	    
	    ColumnModel cm = new ColumnModel(configs);  
	  
	    Grid<BaseModel> grid = new Grid<BaseModel>(store,cm);
	    grid.setBorders(false);  
	    grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
	    
	    
	    ContentPanel cp = new ContentPanel();  
	    cp.setBodyBorder(true);  
	    cp.setHeading("Relación de artículos de la petición");
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setFrame(true);
	    cp.setHeight("200px");
	    
	    cp.add(grid);
	    bottom.add(cp, formData);
	 
	    
	    ButtonGroup gButtons = new ButtonGroup(2);
	    Button b1  = new Button(), b2 = new Button();
	    b1.setText("Recepción Total");
	    b1.addListener(Events.OnClick, new Listener<BaseEvent>(){ 
			@Override
			public void handleEvent(BaseEvent be) {
					DialogoRecepcionTotal dlgTotal = new DialogoRecepcionTotal();
					dlgTotal.show();
			}
	    });
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Recepción por Artículo");
	    b2.addListener(Events.OnClick, new Listener<BaseEvent>(){ 
			@Override
			public void handleEvent(BaseEvent be) {
				DialogoRecepcionarArticulo dlgBuscarArticulo = new DialogoRecepcionarArticulo();
				dlgBuscarArticulo.show();				
			}
	    });
	    
	    
	    b2.setStyleAttribute("padding-left", "5px");
	   
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    DataProxy<?> proxy = null; 
		final BasePagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
	            proxy, new BeanModelReader());  
	        loader.setRemoteSort(true); 
	    
	    final PagingToolBar toolBar = new PagingToolBar(50); 
	    toolBar.bind(loader);
	    toolBar.addStyleName("paginacion");
	    
		main.add(left, new ColumnData(.4));  
		main.add(right, new ColumnData(.6));  
		main.add(bottom, new ColumnData(1));
		main.add(toolBar, new ColumnData(.6));
		main.add(gButtons, new ColumnData(.4));
		
		
		add(main, new FormData("100%"));  
		
	}
	
}
