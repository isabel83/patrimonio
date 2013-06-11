package com.patrimonio.plantillas.client.widgets.dialogs;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.TextArea;

public class DialogoAlbaranParcial extends Dialog{

	@Override
	protected void onRender(Element parent, int pos) {
		super.onRender(parent, pos);
		
		setHeading("Nuevo artículo");
		setLayout(new BorderLayout());
		setModal(true);
		setSize(875, 500);
		//setHideOnButtonClick(true);
		addStyleName("dlgBusqueda");
		
		

		FormPanel cpAlbaran = new FormPanel();
		cpAlbaran.setHeaderVisible(false);
		cpAlbaran.setBorders(false);
		cpAlbaran.setBodyBorder(false);
		cpAlbaran.setLabelAlign(LabelAlign.TOP);  
	    cpAlbaran.setHeading("Introduce las cantidades servidas y la fecha para cada artículo");
	    
	    
	   //***********************************************************************************************************************//
	    
	    final FormPanel frmArticulos = new FormPanel();
	    frmArticulos.setHeaderVisible(false);
	    frmArticulos.setAutoHeight(true);
	    frmArticulos.setLabelAlign(LabelAlign.TOP);
	    frmArticulos.setSize("100%", "100%");
	    
		
	    final LayoutContainer subMain = new LayoutContainer();  
	    subMain.setLayout(new ColumnLayout());  
	    subMain.setStyleAttribute("paddingBottom", "15px");
	    subMain.setBorders(false);
	  
	    LayoutContainer left = new LayoutContainer();  
	    left.setStyleAttribute("paddingLeft", "10px");
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    left.setLayout(layout);  
	    
	    LayoutContainer right = new LayoutContainer();
	    right.setStyleAttribute("paddingLeft", "50px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);
	    right.setStyleName("derecha");

	    
	    TextField<String> articulo = new TextField<String>();
	    articulo.setFieldLabel("Articulo");
	    articulo.setValue("0016512-653-8569");
	    articulo.setEnabled(false);
	    articulo.addInputStyleName("noBorder");
	    left.add(articulo, new FormData("100%"));
	    TextField<String> descArticulo = new TextField<String>();
	    descArticulo.setEnabled(false);
	    descArticulo.setValue("Descripción del tipo de artículo");
	    descArticulo.setLabelStyle("display: none");
	    left.add(descArticulo, new FormData("100%")); 
   
	    TextField<String> marca = new TextField<String>();  
	    marca.setFieldLabel("Marca");
	    marca.setEnabled(false);
	    left.add(marca, new FormData("100%"));	 
	    
	    Label lblObs = new Label("Observaciones");
	    lblObs.addStyleName("etiqueta");
	    left.add(lblObs, new FormData("100%"));
	    TextArea obs = new TextArea();
	    obs.setVisibleLines(5);
	    obs.setStyleName("ultimoListado");
	    left.add(obs, new FormData("100%"));
	  	
	    TextField<String> txtCantSol = new TextField<String>();  
	    txtCantSol.setFieldLabel("Cantidad de la solicitud");
	    right.add(txtCantSol, new FormData("100%"));
	  
	    TextField<String> txtCantSer = new TextField<String>();
	    txtCantSer.setFieldLabel("Cantidad Servida");
	    right.add(txtCantSer, new FormData("100%"));
	  
	    TextField<String> txtCantAn = new TextField<String>();  
	    txtCantAn.setFieldLabel("Cantidad anulada");
	    right.add(txtCantAn, new FormData("100%"));
	  
	    TextField<String> txtCantDev = new TextField<String>();
	    txtCantDev.setFieldLabel("Cantidad Devuelta");
	    right.add(txtCantDev, new FormData("100%"));
	    
	    TextField<String> txtExReales = new TextField<String>();
	    txtExReales.setFieldLabel("Existencias REALES");
	    right.add(txtExReales, new FormData("100%"));
	    
	    TextField<String> txtExMinimas = new TextField<String>();
	    txtExMinimas.setFieldLabel("Existencias MÍNIMAS");
	    right.add(txtExMinimas, new FormData("100%"));
	    
	    ContentPanel cpServido = new ContentPanel();
	    FormLayout lay = new FormLayout();
	    lay.setLabelAlign(LabelAlign.TOP);
	    cpServido.setHeading("Existencias");
	    cpServido.setLayout(lay);  
	    cpServido.setSize("820px", "90px");
	    cpServido.setFrame(true);
	    cpServido.addStyleName("panel");
	    cpServido.setStyleAttribute("paddingBottom", "10px");
	    
	    LayoutContainer layCantidad = new LayoutContainer();
	    layCantidad.setLayout(new ColumnLayout());  
	    layCantidad.setStyleAttribute("paddingBottom", "15px");
	    layCantidad.setBorders(false);
	    
	    Label lblChek = new Label();
	    lblChek.setText("Servido completo");
	    lblChek.setStyleAttribute("padding-top", "2px");
	    layCantidad.add(lblChek, new ColumnData(.2));
	    
	    CheckBox servido = new CheckBox();  
	    layCantidad.add(servido, new ColumnData(.2));
	    
	    Label lblText = new Label();
	    lblText.setText("Cantidad que se sirve");
	    lblText.setStyleAttribute("padding-top", "2px");
	    lblText.setStyleAttribute("padding-left", "10px");
	    lblText.setStyleAttribute("position", "relative");
	    layCantidad.add(lblText, new ColumnData(.2));
	    	    
	    TextField<Integer> txtCantSirve = new TextField<Integer>();  
	    txtCantSirve.setValue(0);
	    layCantidad.add(txtCantSirve, new ColumnData(.4));
	    
	    cpServido.add(layCantidad, new FormData("100%"));
	    
	    ButtonGroup gButtons = new ButtonGroup(3);
	    Button bt1  = new Button(), bt2 = new Button(), bt3 = new Button();
	    bt1.setText("Modificar");
	    bt1.setStyleAttribute("padding-right", "5px");
	    bt2.setText("Aceptar modificación");
	    bt2.setEnabled(false);
	    bt2.setStyleAttribute("padding-right", "5px");
	    bt3.setText("Cancelar");
	    bt3.setEnabled(false);
	    
	    gButtons.add(bt1);
	    gButtons.add(bt2);
	    gButtons.add(bt3);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    cpServido.setBottomComponent(gButtons);
	    left.add(cpServido, new FormData("100%"));
	    
	    DataProxy proxy = null; 
	    
		final BasePagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
	            proxy, new BeanModelReader());  
	        loader.setRemoteSort(true); 
	    
	    final PagingToolBar pagingToolBar = new PagingToolBar(50); 
	    pagingToolBar.bind(loader);
	    pagingToolBar.setStyleName("paginacionFinal");
	    
	    
	    subMain.add(left, new ColumnData(.7));
	    subMain.add(right, new ColumnData(.3));
	  
	    subMain.add(pagingToolBar, new ColumnData(1));
	    frmArticulos.add(subMain, new FormData("100%"));
	    
	    cpAlbaran.add(frmArticulos, new BorderLayoutData(LayoutRegion.CENTER));
	      
	    add(cpAlbaran);
		
		
		setButtons(Dialog.YESNOCANCEL);
		
		getButtonById(Dialog.YES).setText("Recepcionar artículos");
		getButtonById(Dialog.YES).setEnabled(false);
		getButtonById(Dialog.YES).setStyleAttribute("padding-right", "5px");
		getButtonById(Dialog.NO).setText("Buscar");
		getButtonById(Dialog.NO).setStyleAttribute("padding-right", "5px");
		getButtonById(Dialog.NO).addListener(Events.OnClick, new Listener<BaseEvent>(){ 
			
			@Override
			public void handleEvent(BaseEvent be) {
				DialogoBuscar buscar = new DialogoBuscar();
				buscar.show();
			}
			
		});
		getButtonById(Dialog.CANCEL).setText("Salir");
		getButtonById(Dialog.CANCEL).addListener(Events.OnClick, new Listener<BaseEvent>(){
		
			@Override
			public void handleEvent(BaseEvent be) {
				hide();
			}
			
		});
		
		
	}
	
}
