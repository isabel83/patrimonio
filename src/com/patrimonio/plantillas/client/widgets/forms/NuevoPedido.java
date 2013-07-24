package com.patrimonio.plantillas.client.widgets.forms;

import java.util.ArrayList;
import java.util.Date;
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
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
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
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
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
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoBuscar;
import com.patrimonio.plantillas.shared.RpcUtilsArticulos;
import com.patrimonio.plantillas.shared.RpcUtilsProveedores;

public class NuevoPedido extends FormPanel{

	RpcUtilsArticulos artiUtils = new RpcUtilsArticulos();
	RpcUtilsProveedores provUtils = new RpcUtilsProveedores();
	
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
	   
	  
	    final LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	  
	    // introducimos los valores a seleccionar para comenzar el pedido
	    LayoutContainer left = new LayoutContainer();  
	    left.setStyleAttribute("paddingRight", "10px");  
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    left.setLayout(layout);  
	    
	    LayoutContainer mRight = new LayoutContainer();  
	    mRight.setStyleAttribute("paddingLeft", "10px");  
	    FormLayout lay = new FormLayout(); 
	    lay.setLabelAlign(LabelAlign.TOP);
	    mRight.setLayout(lay);  
	    
	    LayoutContainer mLeft = new LayoutContainer();  
	    mLeft.setStyleAttribute("paddingRight", "10px");
	    lay = new FormLayout();  
	    lay.setLabelAlign(LabelAlign.TOP);
	    mLeft.setLayout(lay); 
	  
	    DateTimeFormat dtFormat = DateTimeFormat.getFormat("dd-MM-yyyy");
	    final DateField fechaPedido = new DateField();
	    fechaPedido.getPropertyEditor().setFormat(dtFormat);
	    fechaPedido.setValue(new Date()); //fecha de hoy por defecto
	    fechaPedido.setTitle("Seleccione la fecha en la que desea realizar el pedido");
	    fechaPedido.setFieldLabel("Fecha del pedido");
	    fechaPedido.setStyleAttribute("paddingBottom", "5px");
	    mLeft.add(fechaPedido,formData);
	    
	    final TextField<String> numExp = new TextField<String>();  
	    numExp.setFieldLabel("Número de expediente");  
	    mRight.add(numExp,formData);
	    
	    LayoutContainer subM = new LayoutContainer();  
	    subM.setLayout(new ColumnLayout()); 
	    subM.add(mLeft, new ColumnData(.5));
	    subM.add(mRight, new ColumnData(.5));  
	    left.add(subM,formData);
	       
	  
	    final TextField<String> numPedido = new TextField<String>();  
	    numPedido.setFieldLabel("Número de pedido");  
	    left.add(numPedido,formData);
	    
	    final TextField<String> nifProv = new TextField<String>();  
	    nifProv.setFieldLabel("NIF del proveedor");
	    nifProv.disable();
	    left.add(nifProv,formData);
	    

	    ListStore<BaseModel> proveedores = new ListStore<BaseModel>();  
	    provUtils.loadProveedoresCombo(proveedores);
	  
	    final ComboBox<BaseModel> combo = new ComboBox<BaseModel>();  
	    combo.setEmptyText("Selecciona un proveedor");  
	    combo.setStore(proveedores);  
	    combo.setDisplayField("nombre");  
	    combo.setValueField("id");
	    combo.setFieldLabel("Proveedor");
	    combo.setWidth(150);  
	    combo.setTriggerAction(TriggerAction.ALL);  
	    
	    left.add(combo,formData);
	    
	    // vamos creando el pedido
	    final LayoutContainer right = new LayoutContainer(); 
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setVisible(false);
	    right.setLayout(layout);  
	    
	    final LayoutContainer bottom = new LayoutContainer();  
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    bottom.setLayout(layout);
	    
	    
	    ContentPanel cpRight = new ContentPanel();
	    RowLayout rgtLayout = new RowLayout();
	    rgtLayout.setOrientation(Orientation.VERTICAL);
	    cpRight.setLayout(rgtLayout);
	    cpRight.setHeading("Seleccione los artículos a incluir en el pedido");
	    cpRight.setBodyBorder(false);
	    
	   // Log.debug("Antes de ir a cargar el combo");
	    final ListStore<BaseModel> art = new ListStore<BaseModel>();  
	   
	    
	    final ComboBox<BaseModel> comboA = new ComboBox<BaseModel>();  
	    comboA.setEmptyText("Selecciona un articulo");  
	    comboA.setStore(art);  
	    comboA.setDisplayField("nombre");  
	    comboA.setValueField("id");
	    comboA.setFieldLabel("Artículo");
	    comboA.setWidth(150);  
	    cpRight.add(comboA, new RowData(1,-1, new Margins(4)));
	    
	    Label lblMarca = new Label("Marca:");
	    lblMarca.addStyleName("etiqueta");
	    final TextField<String> marca = new TextField<String>();  
	    marca.setEnabled(false);
	    cpRight.add(lblMarca,  new RowData(1, -1, new Margins(4,1,4,4)));
	    cpRight.add(marca, new RowData(1, -1, new Margins(1,4,4,4)));	   
	  	    
	    LayoutContainer subMain = new LayoutContainer();  
	    subMain.setLayout(new ColumnLayout());  
	    
	    LayoutContainer midRight = new LayoutContainer();  
	    midRight.setStyleAttribute("paddingLeft", "10px");  
	    lay = new FormLayout(); 
	    lay.setLabelAlign(LabelAlign.TOP);
	    midRight.setLayout(lay);  
	    
	    LayoutContainer midLeft = new LayoutContainer();  
	    midLeft.setStyleAttribute("paddingRight", "10px");
	    lay = new FormLayout();  
	    lay.setLabelAlign(LabelAlign.TOP);
	    midLeft.setLayout(lay); 
	    midLeft.addStyleName("check");
	  
	    
	    final CheckBox seleccionar = new CheckBox();  
	    seleccionar.setFieldLabel("Seleccionar");
	    midLeft.add(seleccionar, formData);
	    	    
	    final TextField<Integer> cantidad = new TextField<Integer>();  
	    cantidad.setFieldLabel("Cantidad");  
	    cantidad.setValue(0);
	    midRight.add(cantidad, formData);
	    
	    subMain.add(midLeft, new ColumnData(.5));
	    subMain.add(midRight, new ColumnData(.5));  
	    cpRight.add(subMain,new RowData(1, -1, new Margins(4,0,4,4)));
	    
	    
	    
	    Label lblObs = new Label("Observaciones");
	    lblObs.addStyleName("etiqueta");
	    cpRight.add(lblObs, formData);
	    final TextArea observaciones = new TextArea();
	    observaciones.setVisibleLines(4);
	    cpRight.add(observaciones,new RowData(1, -1, new Margins(4)));
	    
	    ButtonGroup gButtonsCP = new ButtonGroup(2);
	    Button bt1 = new Button(), bt2 = new Button();
	   
	    bt1.setText("Aceptar");
	    
	    bt1.setStyleAttribute("padding-right", "5px");
	    bt2.setText("Buscar");
	    bt2.addListener(Events.OnClick, new Listener<BaseEvent>(){ 
			@Override
			public void handleEvent(BaseEvent be) {
				DialogoBuscar dlgBuscar = new DialogoBuscar();
				dlgBuscar.show();				
			}
	    });
	    
	    gButtonsCP.add(bt1);
	    gButtonsCP.add(bt2);
	    gButtonsCP.setBodyBorder(false);
	    gButtonsCP.setBorders(false);
	    gButtonsCP.addStyleName("botonesFuncionales");
	    
	    cpRight.setBottomComponent(gButtonsCP);
	    
	    right.add(cpRight);
	    

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
	    
	    final ListStore<BaseModel> store = new ListStore<BaseModel>();
	  //  store.add(getArticulos()); //(REVISAR ESTO PORQUE DA ERROR EN LA DEMO)
	    
	    final ColumnModel cm = new ColumnModel(configs);  
	  
	    DataProxy proxy = null; 
		final BasePagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
	            proxy, new BeanModelReader());  
	        loader.setRemoteSort(true);
	    
	    
	    final Grid<BaseModel> grid = new Grid<BaseModel>(store,cm);
	    grid.setStyleAttribute("borderTop", "none");  
	    grid.setBorders(false);
	    grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
	    grid.setColumnLines(true);
	      
	    
	   
	    
	    final PagingToolBar toolBar = new PagingToolBar(50); 
	    toolBar.bind(loader);
	    toolBar.setStyleName("paginacion");
	    
	    final ContentPanel cp = new ContentPanel();  
	    cp.setBodyBorder(true);  
	    cp.setHeading("Pedido");
	    cp.setFrame(true);
	    cp.setVisible(false);
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setHeight("200px");
	    
	    cp.add(grid);
	    bottom.add(cp, formData);
	    
	    
	    final ButtonGroup gButtons = new ButtonGroup(2);
	    Button b1 = new Button(), b2 = new Button();
	   
	    b1.setText("Guardar Pedido");
	    b1.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				//aqui tenemos que seleccionar todos los datos para  V_PEDIDO
				
			}
	    	
	    });
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Vaciar");
	    b2.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				MessageBox.confirm("Atención", "Estas a punto de vaciar los datos ¿Estas seguro?", new Listener<MessageBoxEvent>() {

					@Override
					public void handleEvent(MessageBoxEvent be) {
						String button_id = be.getButtonClicked().getItemId();
						if (Dialog.YES == button_id) {
							fechaPedido.setValue(new Date());
							numPedido.clear();
							nifProv.clear();
							marca.clear();
							combo.clear();
							art.removeAll();
							comboA.clear();
							seleccionar.clear();
							cantidad.clear();
							observaciones.setValue(null);
							right.setVisible(false);
							grid.reconfigure(store, cm);
							bottom.setVisible(false);
							gButtons.setVisible(false);
							main.recalculate();
							main.layout(true);
						}
					}
				});
				
			}
	    	
	    });
	    
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.setVisible(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    //***************************************************************************************//
	    combo.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				if(se.getSelectedItem()!=null){ //si es nulo, estaremos vaciando la pantalla
					long id= se.getSelectedItem().get("id");
					artiUtils.loadArticulosCombo(art,(int)id);
					right.setVisible(true);
					right.recalculate();
					main.layout(true);
				}
			}
	    	
	    });
	    bt1.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				//Pedidos p = artiUtils.loadArticuloGrid(comboA.getValue());
				//grid.getStore().add(p);
				cp.setVisible(true);
				cp.recalculate();
				gButtons.setVisible(true);
				bottom.setVisible(true);
				bottom.recalculate();
				main.layout(true);
			}
	    	
	    });
	    
	    main.add(left, new ColumnData(.4));  
	    main.add(right, new ColumnData(.6));  
	    main.add(bottom, new ColumnData(1));
	    main.add(gButtons, new ColumnData(1));
	    add(main, new FormData("100%"));  
	    
		
	}
	
}
