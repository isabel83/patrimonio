package com.patrimonio.plantillas.client.utils;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoAlbaranTotal;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoAlbaranesPedidos;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoBuscarPedidos;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoNuevoArticulo;
import com.patrimonio.plantillas.shared.RpcUtilsArticulos;
import com.patrimonio.plantillas.shared.RpcUtilsDestinatarios;
import com.patrimonio.plantillas.shared.RpcUtilsFamilias;
import com.patrimonio.plantillas.shared.RpcUtilsPersonas;
import com.patrimonio.plantillas.shared.RpcUtilsProveedores;
import com.patrimonio.plantillas.shared.RpcUtilsSecciones;
import com.patrimonio.plantillas.shared.RpcUtilsSubfamilias;
import com.patrimonio.plantillas.shared.clases.Proveedores;

public class LoadConsultasUtils {
	
	public String titularPrevisiones = "Previsión de vestuario ";
	
	
	RpcUtilsArticulos artiUtils = new RpcUtilsArticulos();
	RpcUtilsProveedores provUtils = new RpcUtilsProveedores();
	RpcUtilsSecciones secUtils = new RpcUtilsSecciones();
	RpcUtilsDestinatarios destiUtils = new RpcUtilsDestinatarios();
	RpcUtilsPersonas personUtils = new RpcUtilsPersonas();
	RpcUtilsFamilias famiUtils = new RpcUtilsFamilias();
	RpcUtilsSubfamilias subUtils = new RpcUtilsSubfamilias();
	protected long seccion=0;
	protected long familia=0;
	protected long subfamilia=0;
	
	
	

	public void loadFormConsultaPedido(FormPanel frmConsultaPedido) {
		FormData formData = new FormData("40%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmConsultaPedido.setSize("100%", "100%");  
		frmConsultaPedido.setBodyBorder(false);
		frmConsultaPedido.setLabelAlign(LabelAlign.TOP);  
		frmConsultaPedido.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
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
	    right.setStyleAttribute("paddingRight", "10px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	    
	    LayoutContainer center = new LayoutContainer();
	    center.setStyleAttribute("paddingRight", "5px");
	    center.setStyleAttribute("paddingLeft", "5px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    center.setLayout(layout);  
	    
	    LayoutContainer bottom = new LayoutContainer();  
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    bottom.setLayout(layout); 
	    bottom.setStyleAttribute("paddingLeft", "10px");
	    bottom.setStyleAttribute("paddingRight", "10px");
	    
	    TextField<String> anyo = new TextField<String>();  
	    anyo.setFieldLabel("Año");  
	    left.add(anyo,formData);	    
	    
	    DateTimeFormat dtFormat = DateTimeFormat.getFormat("dd-MM-yyyy");
	    DateField fechaDesde = new DateField();
	    fechaDesde.getPropertyEditor().setFormat(dtFormat);
	    fechaDesde.setTitle("Seleccione la fecha desde la que quiere consultar los pedidos");
	    fechaDesde.setFieldLabel("Fecha desde");
	    fechaDesde.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaDesde,formData);
	    
	    DateField fechaHasta = new DateField();
	    fechaHasta.getPropertyEditor().setFormat(dtFormat);
	    fechaHasta.setTitle("Seleccione la fecha hasta la que quiere consultar los pedidos");
	    fechaHasta.setFieldLabel("Fecha hasta");
	    fechaHasta.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaHasta,formData);  
	    
	    	       
	    Radio rdReSi = new Radio();
	    rdReSi.setBoxLabel("Si");
	    Radio rdReNo = new Radio();
	    rdReNo.setBoxLabel("No");
	    
	    RadioGroup rGrpRecepcionado = new RadioGroup();
	    rGrpRecepcionado.setFieldLabel("Recepcionados");
	    rGrpRecepcionado.setBorders(true);
	    rGrpRecepcionado.setStyleName("radioGroup");
	    rGrpRecepcionado.setOrientation(Orientation.VERTICAL);
	    rGrpRecepcionado.setStyleAttribute("paddingLeft", "30px");
	    rGrpRecepcionado.add(rdReSi);
	    rGrpRecepcionado.add(rdReNo);
	    center.add(rGrpRecepcionado,formData);
	    
	    Radio rdAnSi = new Radio();
	    rdAnSi.setBoxLabel("Si");
	    Radio rdAnNo = new Radio();
	    rdAnNo.setBoxLabel("No");
	    
	    RadioGroup rGrpAnulado = new RadioGroup();
	    rGrpAnulado.setFieldLabel("Anulados");
	    rGrpAnulado.setStyleName("radioGroup");
	    rGrpAnulado.setBorders(true);
	    rGrpAnulado.setOrientation(Orientation.VERTICAL);
	    rGrpAnulado.setStyleAttribute("paddingLeft", "30px");
	    rGrpAnulado.add(rdAnSi);
	    rGrpAnulado.add(rdAnNo);
	    right.add(rGrpAnulado, formData);
    

	    TextField<String> numDesde = new TextField<String>();  
	    numDesde.setFieldLabel("Número desde");  
	    center.add(numDesde,formData);
	    
	    TextField<String> numHasta = new TextField<String>();  
	    numHasta.setFieldLabel("Número hasta");  
	    right.add(numHasta,formData);	
	    
	    
	    
	    ListStore<BaseModel> proveedores = new ListStore<BaseModel>();  
	    provUtils.loadProveedoresCombo(proveedores);
	  
	    ComboBox<BaseModel> combo = new ComboBox<BaseModel>();  
	    combo.setEmptyText("Selecciona un proveedor");  
	    combo.setStore(proveedores);  
	    combo.setDisplayField("nombre");  
	    combo.setValueField("id");
	    combo.setFieldLabel("Proveedor");
	    combo.setWidth(150);  
	    
	    

	    bottom.add(combo,new FormData("100%"));
	    
	    
	    ButtonGroup gButtons = new ButtonGroup(2);
	    Button b1  = new Button(), b2 = new Button();
	    b1.setText("Buscar");
	    b1.addListener(Events.OnClick, new Listener<BaseEvent>(){ 
			@Override
			public void handleEvent(BaseEvent be) {
				DialogoBuscarPedidos dlgBuscar = new DialogoBuscarPedidos();
				dlgBuscar.show();				
			}
	    });
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Deshacer");
	    b2.setStyleAttribute("padding-right", "5px");

	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    main.add(left, new ColumnData(.4));
	    main.add(center, new ColumnData(.3));
	    main.add(right, new ColumnData(.3));
	    main.add(bottom, new ColumnData(1));

	    main.add(gButtons, new ColumnData(1));
	    
	    frmConsultaPedido.add(main, new FormData("100%"));
	}

	public void loadFormConsultaAlbMatSolicitado(FormPanel frmConsultaAlbaranesMSolicitado) {
		FormData formData = new FormData("40%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmConsultaAlbaranesMSolicitado.setSize("100%", "100%");  
		frmConsultaAlbaranesMSolicitado.setBodyBorder(false);
		frmConsultaAlbaranesMSolicitado.setLabelAlign(LabelAlign.TOP);  
		frmConsultaAlbaranesMSolicitado.setButtonAlign(HorizontalAlignment.CENTER);  
		frmConsultaAlbaranesMSolicitado.setLayout(new FormLayout());
	   
	  
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
	    right.setStyleAttribute("paddingRight", "10px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	    
	    LayoutContainer center = new LayoutContainer();
	    center.setStyleAttribute("paddingRight", "10px");
	    center.setStyleAttribute("paddingLeft", "10px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    center.setLayout(layout);  
	    
	      
	    TextField<String> anyo = new TextField<String>();  
	    anyo.setFieldLabel("Año");  
	    left.add(anyo,formData);	    
	    
	    DateTimeFormat dtFormat = DateTimeFormat.getFormat("dd-MM-yyyy");
	    DateField fechaDesde = new DateField();
	    fechaDesde.getPropertyEditor().setFormat(dtFormat);
	    fechaDesde.setTitle("Seleccione la fecha desde la que quiere consultar los pedidos");
	    fechaDesde.setFieldLabel("Fecha desde");
	    fechaDesde.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaDesde,formData);
	    
	    DateField fechaHasta = new DateField();
	    fechaHasta.getPropertyEditor().setFormat(dtFormat);
	    fechaHasta.setTitle("Seleccione la fecha hasta la que quiere consultar los pedidos");
	    fechaHasta.setFieldLabel("Fecha hasta");
	    fechaHasta.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaHasta,formData);  
	    
	    	       
	    Radio rdReSi = new Radio();
	    rdReSi.setBoxLabel("Si");
	    Radio rdReNo = new Radio();
	    rdReNo.setBoxLabel("No");
	    
	    RadioGroup rGrpRecepcionado = new RadioGroup();
	    rGrpRecepcionado.setFieldLabel("Recepcionados");
	    rGrpRecepcionado.setBorders(true);
	    rGrpRecepcionado.setStyleName("radioGroup");
	    rGrpRecepcionado.setOrientation(Orientation.VERTICAL);
	    rGrpRecepcionado.setStyleAttribute("paddingLeft", "30px");
	    rGrpRecepcionado.add(rdReSi);
	    rGrpRecepcionado.add(rdReNo);
	    center.add(rGrpRecepcionado,formData);
	    
	    Radio rdAnSi = new Radio();
	    rdAnSi.setBoxLabel("Si");
	    Radio rdAnNo = new Radio();
	    rdAnNo.setBoxLabel("No");
	    
	    RadioGroup rGrpAnulado = new RadioGroup();
	    rGrpAnulado.setFieldLabel("Anulados");
	    rGrpAnulado.setStyleName("radioGroup");
	    rGrpAnulado.setBorders(true);
	    rGrpAnulado.setOrientation(Orientation.VERTICAL);
	    rGrpAnulado.setStyleAttribute("paddingLeft", "30px");
	    rGrpAnulado.add(rdAnSi);
	    rGrpAnulado.add(rdAnNo);
	    right.add(rGrpAnulado, formData);
    

	    TextField<String> numDesde = new TextField<String>();  
	    numDesde.setFieldLabel("Número desde");  
	    numDesde.setStyleName("margenB");
	    center.add(numDesde,formData);
	    
	    TextField<String> numHasta = new TextField<String>();  
	    numHasta.setFieldLabel("Número hasta");
	    numHasta.setStyleName("margenB");
	    right.add(numHasta,formData);	
	    
	    ListStore<BaseModel> secciones = new ListStore<BaseModel>();  
	    secUtils.loadSeccionesCombo(secciones);
	  
	    final ComboBox<BaseModel> comboSeccion = new ComboBox<BaseModel>();  
	    comboSeccion.setEmptyText("Selecciona una sección");  
	    comboSeccion.setStore(secciones);  
	    comboSeccion.setDisplayField("nombre");  
	    comboSeccion.setValueField("id");
	    comboSeccion.setFieldLabel("Secciones");
	    comboSeccion.setWidth(150);  
	    comboSeccion.setEnabled(true);
	    left.add(comboSeccion, new FormData("100%"));
	    

	    ListStore<BaseModel> unidades = new ListStore<BaseModel>();  
	    destiUtils.loadUnidadCombo(unidades);
	  
	    final ComboBox<BaseModel> comboUnidad = new ComboBox<BaseModel>();  
	    comboUnidad.setEmptyText("Unidad");  
	    comboUnidad.setStore(unidades);  
	    comboUnidad.setDisplayField("nombre");  
	    comboUnidad.setValueField("id");
	    comboUnidad.setFieldLabel("Secciones");
	    comboUnidad.setWidth(150);  
	    comboUnidad.setEnabled(true);
	    center.add(comboUnidad, new FormData("100%"));
	    
	    ListStore<BaseModel> personas = new ListStore<BaseModel>();  
	    personUtils.loadPersonasCombo(personas);
	  
	    final ComboBox<BaseModel> comboPersonas = new ComboBox<BaseModel>();  
	    comboPersonas.setEmptyText("Persona");  
	    comboPersonas.setStore(personas);  
	    comboPersonas.setDisplayField("nombre");  
	    comboPersonas.setValueField("id");
	    comboPersonas.setFieldLabel("Secciones");
	    comboPersonas.setWidth(150);  
	    comboPersonas.setEnabled(true);
	    right.add(comboPersonas, new FormData("100%"));
	    
	    
	    ButtonGroup gButtons = new ButtonGroup(3);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button();
	    b1.setText("Buscar");
	    b1.addListener(Events.OnClick, new Listener<BaseEvent>(){ 
			@Override
			public void handleEvent(BaseEvent be) {
				DialogoAlbaranesPedidos dlgBuscar = new DialogoAlbaranesPedidos(true);
				dlgBuscar.show();				
			}
	    });
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Deshacer");
	   // b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Salir");
	   
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	   // gButtons.add(b3);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    main.add(left, new ColumnData(.35));
	    main.add(center, new ColumnData(.35));
	    main.add(right, new ColumnData(.3));

	    main.add(gButtons, new ColumnData(1));
	    
	    frmConsultaAlbaranesMSolicitado.add(main, new FormData("100%"));
		
	}

	public void loadFormConsultaAlbMatServido(FormPanel frmConsultaAlbaranesMServido) {
		FormData formData = new FormData("40%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmConsultaAlbaranesMServido.setSize("100%", "100%");  
		frmConsultaAlbaranesMServido.setBodyBorder(false);
		frmConsultaAlbaranesMServido.setLabelAlign(LabelAlign.TOP);  
		frmConsultaAlbaranesMServido.setButtonAlign(HorizontalAlignment.CENTER);  
		frmConsultaAlbaranesMServido.setLayout(new FormLayout());
	   
	  
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
	    right.setStyleAttribute("paddingRight", "10px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	    
	    LayoutContainer center = new LayoutContainer();
	    center.setStyleAttribute("paddingRight", "10px");
	    center.setStyleAttribute("paddingLeft", "10px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    center.setLayout(layout);  
	    
	      
	    TextField<String> anyo = new TextField<String>();  
	    anyo.setFieldLabel("Año");  
	    left.add(anyo,formData);	    
	    
	    DateTimeFormat dtFormat = DateTimeFormat.getFormat("dd-MM-yyyy");
	    DateField fechaDesde = new DateField();
	    fechaDesde.getPropertyEditor().setFormat(dtFormat);
	    fechaDesde.setTitle("Seleccione la fecha desde la que quiere consultar los pedidos");
	    fechaDesde.setFieldLabel("Fecha desde");
	    fechaDesde.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaDesde,formData);
	    
	    DateField fechaHasta = new DateField();
	    fechaHasta.getPropertyEditor().setFormat(dtFormat);
	    fechaHasta.setTitle("Seleccione la fecha hasta la que quiere consultar los pedidos");
	    fechaHasta.setFieldLabel("Fecha hasta");
	    fechaHasta.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaHasta,formData);  
	    
	    TextField<String> numDesde = new TextField<String>();  
	    numDesde.setFieldLabel("Número desde");  
	    center.add(numDesde,formData);
	    
	    TextField<String> numHasta = new TextField<String>();  
	    numHasta.setFieldLabel("Número hasta");
	    numHasta.setStyleName("bottom59");
	    center.add(numHasta,formData);	
	    
	    
	    	       
	   
	    Radio rdTotal = new Radio();
	    rdTotal.setBoxLabel("Totalmente devuelto");
	    Radio rdParcial = new Radio();
	    rdParcial.setBoxLabel("Parcialmente devuelto");
	    Radio rdNoDev = new Radio();
	    rdNoDev.setBoxLabel("No devuelto");
	    
	    RadioGroup rGrpDev = new RadioGroup();
	    rGrpDev.setFieldLabel("Estado");
	    rGrpDev.setStyleName("bottom52");
	    rGrpDev.setAutoWidth(true);
	    rGrpDev.setBorders(true);
	    rGrpDev.setOrientation(Orientation.VERTICAL);
	    rGrpDev.setStyleAttribute("paddingLeft", "30px");
	    rGrpDev.add(rdTotal);
	    rGrpDev.add(rdParcial);
	    rGrpDev.add(rdNoDev);
	    right.add(rGrpDev, formData);
    
	    ListStore<BaseModel> secciones = new ListStore<BaseModel>();  
	    secUtils.loadSeccionesCombo(secciones);
	  
	    final ComboBox<BaseModel> comboSeccion = new ComboBox<BaseModel>();  
	    comboSeccion.setEmptyText("Selecciona una sección");  
	    comboSeccion.setStore(secciones);  
	    comboSeccion.setDisplayField("nombre");  
	    comboSeccion.setValueField("id");
	    comboSeccion.setFieldLabel("Secciones");
	    comboSeccion.setWidth(150);  
	    comboSeccion.setEnabled(true);
	    left.add(comboSeccion, new FormData("100%"));
	    

	    ListStore<BaseModel> unidades = new ListStore<BaseModel>();  
	    destiUtils.loadUnidadCombo(unidades);
	  
	    final ComboBox<BaseModel> comboUnidad = new ComboBox<BaseModel>();  
	    comboUnidad.setEmptyText("Unidad");  
	    comboUnidad.setStore(unidades);  
	    comboUnidad.setDisplayField("nombre");  
	    comboUnidad.setValueField("id");
	    comboUnidad.setFieldLabel("Secciones");
	    comboUnidad.setWidth(150);  
	    comboUnidad.setEnabled(true);
	    center.add(comboUnidad, new FormData("100%"));
	    
	    ListStore<BaseModel> personas = new ListStore<BaseModel>();  
	    personUtils.loadPersonasCombo(personas);
	  
	    final ComboBox<BaseModel> comboPersonas = new ComboBox<BaseModel>();  
	    comboPersonas.setEmptyText("Persona");  
	    comboPersonas.setStore(personas);  
	    comboPersonas.setDisplayField("nombre");  
	    comboPersonas.setValueField("id");
	    comboPersonas.setFieldLabel("Secciones");
	    comboPersonas.setWidth(150);  
	    comboPersonas.setEnabled(true);
	    right.add(comboPersonas, new FormData("100%"));
	    
	    
	    ButtonGroup gButtons = new ButtonGroup(3);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button();
	    b1.setText("Grabar");
	    b1.setText("Buscar");
	    b1.addListener(Events.OnClick, new Listener<BaseEvent>(){ 
			@Override
			public void handleEvent(BaseEvent be) {
				DialogoAlbaranTotal dlgBuscar = new DialogoAlbaranTotal(true);
				dlgBuscar.show();				
			}
	    });
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Deshacer");
	    //b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Salir");
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	   // gButtons.add(b3);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    main.add(left, new ColumnData(.35));
	    main.add(center, new ColumnData(.35));
	    main.add(right, new ColumnData(.3));

	    main.add(gButtons, new ColumnData(1));
	    
	    frmConsultaAlbaranesMServido.add(main, new FormData("100%"));
		
		
	}

	public void loadFormConsultaControlMaterial(FormPanel frmControlMaterial) {
		FormData formData = new FormData("40%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmControlMaterial.setSize("100%", "100%");  
		frmControlMaterial.setBodyBorder(false);
		frmControlMaterial.setLabelAlign(LabelAlign.TOP);  
		frmControlMaterial.setButtonAlign(HorizontalAlignment.CENTER);  
		frmControlMaterial.setLayout(new FormLayout());
	   
	  
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
	    right.setStyleAttribute("paddingRight", "10px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	    
	    LayoutContainer center = new LayoutContainer();
	    center.setStyleAttribute("paddingRight", "10px");
	    center.setStyleAttribute("paddingLeft", "10px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    center.setLayout(layout);  
	    
	      
	    TextField<String> anyo = new TextField<String>();  
	    anyo.setFieldLabel("Año");  
	    left.add(anyo,formData);	    
	    
	    DateTimeFormat dtFormat = DateTimeFormat.getFormat("dd-MM-yyyy");
	    DateField fechaDesde = new DateField();
	    fechaDesde.getPropertyEditor().setFormat(dtFormat);
	    fechaDesde.setTitle("Seleccione la fecha desde la que quiere consultar los pedidos");
	    fechaDesde.setFieldLabel("Fecha desde");
	    fechaDesde.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaDesde,formData);
	    
	    DateField fechaHasta = new DateField();
	    fechaHasta.getPropertyEditor().setFormat(dtFormat);
	    fechaHasta.setTitle("Seleccione la fecha hasta la que quiere consultar los pedidos");
	    fechaHasta.setFieldLabel("Fecha hasta");
	    fechaHasta.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaHasta,formData);  
	    
	    	       
	    Radio rdSrSi = new Radio();
	    rdSrSi.setBoxLabel("Si");
	    Radio rdSrNo = new Radio();
	    rdSrNo.setBoxLabel("No");
	    
	    RadioGroup rGrpServido = new RadioGroup();
	    rGrpServido.setFieldLabel("Servido");
	    rGrpServido.setBorders(true);
	    rGrpServido.setStyleName("radioGroup");
	    rGrpServido.setOrientation(Orientation.VERTICAL);
	    rGrpServido.setStyleAttribute("paddingLeft", "30px");
	    rGrpServido.add(rdSrSi);
	    rGrpServido.add(rdSrNo);
	    center.add(rGrpServido,formData);
	    
	    Radio rdAnSi = new Radio();
	    rdAnSi.setBoxLabel("Si");
	    Radio rdAnNo = new Radio();
	    rdAnNo.setBoxLabel("No");
	    
	    RadioGroup rGrpAnulado = new RadioGroup();
	    rGrpAnulado.setFieldLabel("Anulado");
	    rGrpAnulado.setStyleName("radioGroup");
	    rGrpAnulado.setBorders(true);
	    rGrpAnulado.setOrientation(Orientation.VERTICAL);
	    rGrpAnulado.setStyleAttribute("paddingLeft", "30px");
	    rGrpAnulado.add(rdAnSi);
	    rGrpAnulado.add(rdAnNo);
	    right.add(rGrpAnulado, formData);
    

	    TextField<String> numDesde = new TextField<String>();  
	    numDesde.setFieldLabel("Número desde");  
	    numDesde.setStyleName("margenB");
	    center.add(numDesde,formData);
	    
	    TextField<String> numHasta = new TextField<String>();  
	    numHasta.setFieldLabel("Número hasta");
	    numHasta.setStyleName("margenB");
	    right.add(numHasta,formData);	
	    
	    ListStore<BaseModel> secciones = new ListStore<BaseModel>();  
	    secUtils.loadSeccionesCombo(secciones);
	  
	    final ComboBox<BaseModel> comboSeccion = new ComboBox<BaseModel>();  
	    comboSeccion.setEmptyText("Selecciona una sección");  
	    comboSeccion.setStore(secciones);  
	    comboSeccion.setDisplayField("nombre");  
	    comboSeccion.setValueField("id");
	    comboSeccion.setFieldLabel("Secciones");
	    comboSeccion.setWidth(150);  
	    comboSeccion.setEnabled(true);
	    left.add(comboSeccion, new FormData("100%"));
	    

	    ListStore<BaseModel> unidades = new ListStore<BaseModel>();  
	    destiUtils.loadUnidadCombo(unidades);
	  
	    final ComboBox<BaseModel> comboUnidad = new ComboBox<BaseModel>();  
	    comboUnidad.setEmptyText("Unidad");  
	    comboUnidad.setStore(unidades);  
	    comboUnidad.setDisplayField("nombre");  
	    comboUnidad.setValueField("id");
	    comboUnidad.setFieldLabel("Secciones");
	    comboUnidad.setWidth(150);  
	    comboUnidad.setEnabled(true);
	    center.add(comboUnidad, new FormData("100%"));
	    
	    ListStore<BaseModel> personas = new ListStore<BaseModel>();  
	    personUtils.loadPersonasCombo(personas);
	  
	    final ComboBox<BaseModel> comboPersonas = new ComboBox<BaseModel>();  
	    comboPersonas.setEmptyText("Persona");  
	    comboPersonas.setStore(personas);  
	    comboPersonas.setDisplayField("nombre");  
	    comboPersonas.setValueField("id");
	    comboPersonas.setFieldLabel("Secciones");
	    comboPersonas.setWidth(150);  
	    comboPersonas.setEnabled(true);
	    right.add(comboPersonas, new FormData("100%"));
	    
	    
	    ButtonGroup gButtons = new ButtonGroup(3);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button();
	    b1.setText("Buscar");
	    b1.addListener(Events.OnClick, new Listener<BaseEvent>(){ 
			@Override
			public void handleEvent(BaseEvent be) {
				DialogoAlbaranesPedidos dlgBuscar = new DialogoAlbaranesPedidos(false);
				dlgBuscar.show();				
			}
	    });
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Deshacer");
	    //b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Salir");
	   
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    //gButtons.add(b3);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    main.add(left, new ColumnData(.35));
	    main.add(center, new ColumnData(.35));
	    main.add(right, new ColumnData(.3));

	    main.add(gButtons, new ColumnData(1));
	    
	    frmControlMaterial.add(main, new FormData("100%"));
		
	}

	public void loadFormConsultaArticulos(FormPanel frmConsultaArticulos) {
		FormData formData = new FormData("100%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmConsultaArticulos.setSize("100%", "100%");  
		frmConsultaArticulos.setBodyBorder(false);
		frmConsultaArticulos.setLabelAlign(LabelAlign.TOP);  
		frmConsultaArticulos.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
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
	    bottom.setStyleAttribute("paddingRight", "10px");
	    
	    ListStore<BaseModel> secciones = new ListStore<BaseModel>();  
	    secUtils.loadSeccionesCombo(secciones);
	  
	    final ComboBox<BaseModel> comboSeccion = new ComboBox<BaseModel>();  
	    comboSeccion.setEmptyText("Selecciona una sección");  
	    comboSeccion.setStore(secciones);  
	    comboSeccion.setDisplayField("nombre");  
	    comboSeccion.setValueField("id");
	    comboSeccion.setFieldLabel("Secciones");
	    comboSeccion.setWidth(150);  
	    comboSeccion.setEnabled(true);
	    
	    
	    left.add(comboSeccion, formData);

	    final ListStore<BaseModel> familias = new ListStore<BaseModel>();  
	    final ComboBox<BaseModel> comboFamilia = new ComboBox<BaseModel>();  
	    comboFamilia.setEmptyText("Selecciona una familia");  
	    comboFamilia.setStore(familias);  
	    comboFamilia.setDisplayField("nombre");  
	    comboFamilia.setValueField("id");
	    comboFamilia.setFieldLabel("Familias");
	    comboFamilia.setWidth(150);  
	    comboFamilia.setEnabled(false);
	    
	    right.add(comboFamilia,formData);
	    
	    final ListStore<BaseModel> subFamilia = new ListStore<BaseModel>();  
	    final ComboBox<BaseModel> comboSubFamilia = new ComboBox<BaseModel>();  
	    comboSubFamilia.setEmptyText("Selecciona una subfamilia");  
	    comboSubFamilia.setStore(subFamilia);  
	    comboSubFamilia.setDisplayField("nombre");  
	    comboSubFamilia.setValueField("id");
	    comboSubFamilia.setFieldLabel("Subfamilias");
	    comboSubFamilia.setWidth(150);  
	    comboSubFamilia.setEnabled(false);
	    
	    right.add(comboSubFamilia,formData);
	    
	    
	    /*LE DAMOS A LOS COMBOS EL LISTENER*/
	    comboSeccion.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				Log.debug("El id seleccionado es: " + se.getSelectedItem().get("id"));
				seccion = se.getSelectedItem().get("id");
				famiUtils.loadFamiliasComboFiltrado(familias, seccion);
				comboFamilia.setEnabled(true);
				comboFamilia.recalculate();
			}
	    	
	    });
	    
	    comboFamilia.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				Log.debug("El id seleccionado es: " + se.getSelectedItem().get("id"));
				familia = se.getSelectedItem().get("id");
				subUtils.loadSubFamiliasComboFiltrado(subFamilia, familia);
				comboSubFamilia.setEnabled(true);
				comboSubFamilia.recalculate();
			}
	    	
	    });
	    
	    comboSubFamilia.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				Log.debug("El id seleccionado es: " + se.getSelectedItem().get("id"));
				subfamilia = se.getSelectedItem().get("id");
			}
	    	
	    });
	    
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
	    
	    TextField<String> minimas = new TextField<String>();  
	    cpExistencias.add(lblMinimas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(minimas, new RowData(-1, -1, new Margins(20,20,20,0)));
	    
	    
	    Label lblIdoneas = new Label();
	    lblIdoneas.setText("Idoneas");
	    
	    TextField<String> idoneas = new TextField<String>();  

	    cpExistencias.add(lblIdoneas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(idoneas, new RowData(-1, -1, new Margins(20)));
	    
	    
	    Label lblReales = new Label();
	    lblReales.setText("Reales");
	    
	    TextField<String> reales = new TextField<String>();  

	    cpExistencias.add(lblReales, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(reales, new RowData(-1, -1, new Margins(20,20,20,0)));
	    
	    bottom.add(cpExistencias,formData);
	    
	    Radio rdESi = new Radio();
	    rdESi.setBoxLabel("Si");
	    Radio rdENo = new Radio();
	    rdENo.setBoxLabel("No");
	    
	    RadioGroup rGrpServido = new RadioGroup();
	    rGrpServido.setFieldLabel("Eliminado");
	    rGrpServido.setBorders(true);
	    rGrpServido.setStyleAttribute("paddingLeft", "10px");
	    rGrpServido.setOrientation(Orientation.HORIZONTAL);
	    rGrpServido.add(rdESi);
	    rGrpServido.add(rdENo);
	    bottom.add(rGrpServido,new FormData("10%"));
	    
	   
	    ButtonGroup gButtons = new ButtonGroup(3);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button();
	    b1.setText("Buscar");
	    b1.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				DialogoNuevoArticulo nuevoArticulo = new DialogoNuevoArticulo(2);//consulta articulo
				nuevoArticulo.show();
			}
	    	
	    });
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Deshacer");
	   // b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Salir");
	    b3.setEnabled(false);
	   
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    //gButtons.add(b3);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    

	    
	    main.add(left, new ColumnData(.4));
	    main.add(right, new ColumnData(.6));
	    main.add(bottom, new ColumnData(1));

	    main.add(gButtons, new ColumnData(1));
	    
	    frmConsultaArticulos.add(main, new FormData("100%"));
		
	}

	public void loadFormConsultaPrevision(FormPanel frmCPrevision) {
		FormData formData = new FormData("100%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmCPrevision.setSize("100%", "100%");  
		frmCPrevision.setBodyBorder(false);
		frmCPrevision.setLabelAlign(LabelAlign.TOP);  
		frmCPrevision.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	    main.setBorders(false);
	  
	    LayoutContainer top = new LayoutContainer();  
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    top.setLayout(layout);  
	    
	    LayoutContainer central = new LayoutContainer();
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    central.setLayout(layout);  
	    
	    TextField<String> delegacion = new TextField<String>();  
	    delegacion.setFieldLabel("Código de Artículo");
	    top.add(delegacion,formData);
	    
	    TextField<String> colectivo = new TextField<String>();  
	    colectivo.setFieldLabel("Nombre del artículo");
	    top.add(colectivo,formData);
	    
	    TextField<String> nomTrabajador = new TextField<String>();  
	    nomTrabajador.setFieldLabel("Marca del artículo");
	    top.add(nomTrabajador,formData);
	    
	    
	    ContentPanel cpEntregas = new ContentPanel();
	    cpEntregas.setHeading("Entregas de Vestuario");
	    cpEntregas.setLayout(new ColumnLayout());  
	    cpEntregas.setHeight("300px");
	    cpEntregas.setFrame(true);
	    cpEntregas.setStyleAttribute("paddingBottom", "10px");
	    cpEntregas.setStyleName("body");
	    
	    loadEntregas(cpEntregas);
	    
	    ButtonGroup gButtons = new ButtonGroup(2);
	    Button b1  = new Button(), b2 = new Button();
	    b1.setText("Buscar Trabajador");
	    //b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Salir");

	   
	    
	    gButtons.add(b1);
	    //gButtons.add(b2);
	    gButtons.addStyleName("botonesFuncionales");
	     
	       
	    top.add(delegacion, formData);
	    top.add(colectivo, formData);
	    top.add(nomTrabajador, formData);
	    
	    central.add(cpEntregas, formData);
	    
	    main.add(top, new ColumnData(1));
	    main.add(central, new ColumnData(1));
	    
	    ////*************************************************** AQUI LA PAGINACION SERA LA DEL MENU ICONOS //////
	    main.add(b1, new ColumnData(.18));
	    
		frmCPrevision.add(main, formData);
		
		frmCPrevision.setExpanded(false);
		
		//Log.debug("TERMINO DE CARGAR EL FORMULARIO");
	}

	private void loadEntregas(final ContentPanel cpEntregas) {
		
			 
	    LayoutContainer left = new LayoutContainer();  
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    left.setLayout(layout);  
	    left.setStyleAttribute("paddingTop", "5px");
	    
	    LayoutContainer right = new LayoutContainer();
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	    right.setStyleAttribute("paddingTop", "5px");
	    
	    ListStore<BaseModel> articulos = new ListStore<BaseModel>();  
	    artiUtils.loadArticulosCombo(articulos);
	  
	    final ComboBox<BaseModel> comboArticulo = new ComboBox<BaseModel>();  
	    comboArticulo.setEmptyText("Selecciona un artículo");  
	    comboArticulo.setStore(articulos);  
	    comboArticulo.setDisplayField("nombre");  
	    comboArticulo.setValueField("id");
	    comboArticulo.setFieldLabel("Articulos");
	    comboArticulo.setWidth(150);  
	    comboArticulo.setEnabled(true);
	    cpEntregas.add(comboArticulo,new ColumnData(1));
	    
	    DateTimeFormat dtFormat = DateTimeFormat.getFormat("dd-MM-yyyy");
	    DateField fechaCancelacion = new DateField();
	    fechaCancelacion.getPropertyEditor().setFormat(dtFormat);
	    fechaCancelacion.setTitle("Seleccione la fecha de cancelación");
	    fechaCancelacion.setFieldLabel("Fecha de cancelación");
	    fechaCancelacion.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaCancelacion,new FormData("50%"));  
	    
	    TextField<String> cantEntregar = new TextField<String>();  
	    cantEntregar.setFieldLabel("Cantidad que se debe entregar");
	    right.add(cantEntregar, new FormData("50%"));
	    
	    DateField fechaUEntrega = new DateField();
	    fechaUEntrega.getPropertyEditor().setFormat(dtFormat);
	    fechaUEntrega.setTitle("Seleccione la fecha en la que desea realizar la solicitud");
	    fechaUEntrega.setFieldLabel("Fecha de la última entrega");
	    fechaUEntrega.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaUEntrega,new FormData("50%"));  
	    
	    TextField<String> cantEntregada = new TextField<String>();  
	    cantEntregada.setFieldLabel("Cantidad entregada");
	    right.add(cantEntregada,new FormData("50%"));
	    
	    CheckBox entCompletada = new CheckBox();  
	    entCompletada.setFieldLabel("¿Entrega completada? (SI/NO)");
	    left.add(entCompletada, new FormData("50%"));
	    
	    CheckBox incCalculosP = new CheckBox();  
	    incCalculosP.setFieldLabel("¿Incluir en los cálculos de la Previsión? (SI/NO)");
	    right.add(incCalculosP, new FormData("50%"));
	    
	    cpEntregas.add(left, new ColumnData(.5));
	    cpEntregas.add(right, new ColumnData(.5));
	    
	    DataProxy entregasPRx = null; 
		final BasePagingLoader<PagingLoadResult<ModelData>> entregasLoader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
				entregasPRx, new BeanModelReader());  
	        entregasLoader.setRemoteSort(true); 
	    
	    final PagingToolBar paginacionEntregas = new PagingToolBar(50); 
	    paginacionEntregas.bind(entregasLoader);
	    paginacionEntregas.addStyleName("paginacionFinal bajoMargen");
	    
	    final ButtonGroup gButtons = new ButtonGroup(53);
	    final Button b1  = new Button(), b2 = new Button(), b3 = new Button(), b4 = new Button(), b5 = new Button();
	    b1.setText("Agregar artículo");
	    b1.setStyleAttribute("padding-right", "5px");
	    b1.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(false);
				b4.setVisible(true);
				b5.setVisible(true);
				gButtons.layout(true);
			}
	    	
	    });
	    b2.setText("Modificar artículo");
	    b2.setStyleAttribute("padding-right", "5px");
	    b2.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(false);
				b4.setVisible(true);
				b5.setVisible(true);
				gButtons.layout(true);
			}
	    	
	    });
	    b3.setText("Eliminar artículo");
	    b4.setText("Grabar");
	    b4.setVisible(false);
	    b4.setStyleAttribute("padding-right", "5px");
	    b4.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				b1.setVisible(true);
				b2.setVisible(true);
				b3.setVisible(true);
				b4.setVisible(false);
				b5.setVisible(false);
				gButtons.layout(true);
			}
	    	
	    });
	    b5.setText("Deshacer");
	    b5.setVisible(false);
	    b5.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				b1.setVisible(true);
				b2.setVisible(true);
				b3.setVisible(true);
				b4.setVisible(false);
				b5.setVisible(false);
				gButtons.layout(true);
			}
	    	
	    });
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.add(b3);
	    gButtons.add(b4);
	    gButtons.add(b5);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    cpEntregas.add(paginacionEntregas, new ColumnData(.63));
	    cpEntregas.add(gButtons, new ColumnData(.37));
	    
	}


}
