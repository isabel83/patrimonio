package com.patrimonio.plantillas.client.utils;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
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
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;

public class LoadInformesUtils {
	
	 DateTimeFormat dtFormat = DateTimeFormat.getFormat("dd-MM-yyyy");

	public void loadPedidos(FormPanel frmPedidos) {
		FormData formData = new FormData("40%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmPedidos.setSize("100%", "100%");  
		frmPedidos.setBodyBorder(false);
		frmPedidos.setLabelAlign(LabelAlign.TOP);  
		frmPedidos.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	    main.setBorders(false);
	  
	    LayoutContainer left = new LayoutContainer();  
	    left.setStyleAttribute("paddingLeft", "5px");
	    left.setStyleAttribute("paddingTop", "15px");
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    left.setLayout(layout);  
	    
	    LayoutContainer right = new LayoutContainer();
	    right.setStyleAttribute("paddingRight", "5px");
	    right.setStyleAttribute("paddingTop", "15px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	    
	    LayoutContainer center = new LayoutContainer();
	    center.setStyleAttribute("paddingRight", "5px");
	    center.setStyleAttribute("paddingLeft", "5px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    center.setLayout(layout);  
	    
	    Label lblProveedor = new Label("Proveedor:");
	    lblProveedor.setStyleName("etiqueta margen");
	    ListBox lstProveedor = new ListBox();
	    lstProveedor.setVisibleItemCount(1);
	    center.add(lblProveedor,new FormData("100%"));
	    center.add(lstProveedor,new FormData("100%"));
	    
	    Label lblArticulo = new Label("Artículo:");
	    lblArticulo.setStyleName("etiqueta margen");
	    ListBox lstArticulo = new ListBox();
	    lstArticulo.setVisibleItemCount(1);
	    center.add(lblArticulo,new FormData("100%"));
	    center.add(lstArticulo,new FormData("100%"));
	   
	    
	   
	    DateField fechaDesde = new DateField();
	    fechaDesde.getPropertyEditor().setFormat(dtFormat);
	    fechaDesde.setTitle("Seleccione la fecha desde la que quiere que se genere el informe");
	    fechaDesde.setFieldLabel("Fecha desde");
	    fechaDesde.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaDesde,formData);
	    
	    DateField fechaHasta = new DateField();
	    fechaHasta.getPropertyEditor().setFormat(dtFormat);
	    fechaHasta.setTitle("Seleccione la fecha hasta la que quiere que se genere el informe");
	    fechaHasta.setFieldLabel("Fecha hasta");
	    fechaHasta.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaHasta,formData);  
	    
	    TextField<String> numDesde = new TextField<String>();  
	    numDesde.setFieldLabel("Número desde");  
	    numDesde.setStyleAttribute("paddingBottom", "10px");
	    right.add(numDesde,formData);	   
	    
	    TextField<String> numHasta = new TextField<String>();  
	    numHasta.setFieldLabel("Número hasta");  
	    numHasta.setStyleAttribute("paddingBottom", "5px");
	    right.add(numHasta,formData);
	    
	    ButtonGroup gButtons = new ButtonGroup(3);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button();
	    b1.setText("Imprimir");
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
	    
	    main.add(center, new ColumnData(1));
	    main.add(left, new ColumnData(.5));
	    main.add(right, new ColumnData(.5));


	    main.add(gButtons, new ColumnData(1));
	    
	    frmPedidos.add(main, new FormData("100%"));
	}

	public void loadSolicitudes(FormPanel frmSolicitudes) {
		FormData formData = new FormData("40%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmSolicitudes.setSize("100%", "100%");  
		frmSolicitudes.setBodyBorder(false);
		frmSolicitudes.setLabelAlign(LabelAlign.TOP);  
		frmSolicitudes.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
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
	    
	    LayoutContainer bottom = new LayoutContainer();  
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    bottom.setLayout(layout); 
	    bottom.setStyleAttribute("paddingLeft", "10px");
	    bottom.setStyleAttribute("paddingRight", "10px");
	    
	    Label lblSeccion = new Label("Sección:");
	    lblSeccion.setStyleName("etiqueta margen");
	    ListBox lstSeccion = new ListBox();
	    lstSeccion.setVisibleItemCount(1);
	    bottom.add(lblSeccion,new FormData("100%"));
	    bottom.add(lstSeccion,new FormData("100%"));
	    
	    Label lblUnidad = new Label("Unidad:");
	    lblUnidad.setStyleName("etiqueta margen");
	    ListBox lstUnidad = new ListBox();
	    lstUnidad.setVisibleItemCount(1);
	    bottom.add(lblUnidad,new FormData("100%"));
	    bottom.add(lstUnidad,new FormData("100%"));
	    
	    Label lblPersona = new Label("Persona:");
	    lblPersona.setStyleName("etiqueta margen");
	    ListBox lstPersona = new ListBox();
	    lstPersona.setVisibleItemCount(1);
	    bottom.add(lblPersona,new FormData("100%"));
	    bottom.add(lstPersona,new FormData("100%"));
	    
	    DateField fechaDesde = new DateField();
	    fechaDesde.getPropertyEditor().setFormat(dtFormat);
	    fechaDesde.setTitle("Seleccione la fecha desde la que quiere que se genere el informe");
	    fechaDesde.setFieldLabel("Fecha desde");
	    fechaDesde.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaDesde,formData);
	    
	    DateField fechaHasta = new DateField();
	    fechaHasta.getPropertyEditor().setFormat(dtFormat);
	    fechaHasta.setTitle("Seleccione la fecha hasta la que quiere que se genere el informe");
	    fechaHasta.setFieldLabel("Fecha hasta");
	    fechaHasta.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaHasta,formData);  
	    
	    TextField<String> numDesde = new TextField<String>();  
	    numDesde.setFieldLabel("Número desde");  
	    numDesde.setStyleAttribute("paddingBottom", "10px");
	    right.add(numDesde,formData);	   
	    
	    TextField<String> numHasta = new TextField<String>();  
	    numHasta.setFieldLabel("Número hasta"); 
	    numHasta.setStyleAttribute("paddingBottom", "5px");
	    right.add(numHasta,formData);
	    
	    ButtonGroup gButtons = new ButtonGroup(3);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button();
	    b1.setText("Imprimir");
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
	    
	   
	    main.add(left, new ColumnData(.5));
	    main.add(right, new ColumnData(.5));
	    main.add(bottom, new ColumnData(1));

	    main.add(gButtons, new ColumnData(1));
	    
	    frmSolicitudes.add(main, new FormData("100%"));
	}

	public void loadArticulos(FormPanel frmArticulos) {
		FormData formData = new FormData("40%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmArticulos.setSize("100%", "100%");  
		frmArticulos.setBodyBorder(false);
		frmArticulos.setLabelAlign(LabelAlign.TOP);  
		frmArticulos.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	    main.setBorders(false);
	    
	    LayoutContainer bottom = new LayoutContainer();  
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    bottom.setLayout(layout); 
	    bottom.setStyleAttribute("paddingLeft", "10px");
	    bottom.setStyleAttribute("paddingRight", "10px");
	    
	    Label lblSeccion = new Label("Sección:");
	    lblSeccion.setStyleName("etiqueta margen");
	    ListBox lstSeccion = new ListBox();
	    lstSeccion.setVisibleItemCount(1);
	    bottom.add(lblSeccion,new FormData("100%"));
	    bottom.add(lstSeccion,new FormData("100%"));
	    
	    Label lblFamilia = new Label("Familia:");
	    lblFamilia.setStyleName("etiqueta margen");
	    ListBox lstFamilia = new ListBox();
	    lstFamilia.setVisibleItemCount(1);
	    bottom.add(lblFamilia,new FormData("100%"));
	    bottom.add(lstFamilia,new FormData("100%"));
	    
	    Label lblSubFamilia = new Label("Subfamilia:");
	    lblSubFamilia.setStyleName("etiqueta margen");
	    ListBox lstSubFamilia = new ListBox();
	    lstSubFamilia.setVisibleItemCount(1);
	    lstSubFamilia.addStyleName("ultimoListado");
	    bottom.add(lblSubFamilia,new FormData("100%"));
	    bottom.add(lstSubFamilia,new FormData("100%"));
	    
	    Radio rdSi = new Radio();
	    rdSi.setBoxLabel("Si");
	    Radio rdNo = new Radio();
	    rdNo.setBoxLabel("No");
	    
	    RadioGroup rGrpEliminados = new RadioGroup();
	    rGrpEliminados.setFieldLabel("Eliminados");
	    rGrpEliminados.setBorders(true);
	    rGrpEliminados.setOrientation(Orientation.HORIZONTAL);
	    rGrpEliminados.setStyleAttribute("paddingLeft", "30px");
	    rGrpEliminados.add(rdSi);
	    rGrpEliminados.add(rdNo);
	    bottom.add(rGrpEliminados,new FormData("15%"));
	    
	    ButtonGroup gButtons = new ButtonGroup(3);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button();
	    b1.setText("Imprimir");
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
	    
	   
	    main.add(bottom, new ColumnData(1));

	    main.add(gButtons, new ColumnData(1));
	    
	    frmArticulos.add(main, new FormData("100%"));
	}

	public void loadProveedores(FormPanel frmProveedores) {
		FormData formData = new FormData("40%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmProveedores.setSize("100%", "100%");  
		frmProveedores.setBodyBorder(false);
		frmProveedores.setLabelAlign(LabelAlign.TOP);  
		frmProveedores.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	    main.setBorders(false);
	    
	    Label lblProveedor = new Label("Proveedor:");
	    lblProveedor.setStyleName("etiqueta margen");
	    ListBox lstProveedor = new ListBox();
	    lstProveedor.setVisibleItemCount(1);
	    
	    Label lblArticulo = new Label("Artículo:");
	    lblArticulo.setStyleName("etiqueta margen");
	    ListBox lstArticulo = new ListBox();
	    lstArticulo.setVisibleItemCount(1);
	   
	    ButtonGroup gButtons = new ButtonGroup(3);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button();
	    b1.setText("Imprimir");
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
	    
	    
	    main.add(lblProveedor,new ColumnData(1));
	    main.add(lstProveedor,new ColumnData(1));
	    
	    main.add(lblArticulo,new ColumnData(1));
	    main.add(lstArticulo,new ColumnData(1));
	    
	  

	    main.add(gButtons, new ColumnData(1));
	    
	    frmProveedores.add(main, new FormData("100%"));
	}

	public void loadPuestos(FormPanel frmPuestos) {
		FormData formData = new FormData("40%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmPuestos.setSize("100%", "100%");  
		frmPuestos.setBodyBorder(false);
		frmPuestos.setLabelAlign(LabelAlign.TOP);  
		frmPuestos.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	    main.setBorders(false);
	    
	    Label lblUnidad = new Label("Unidad:");
	    lblUnidad.setStyleName("etiqueta margen");
	    ListBox lstUnidad = new ListBox();
	    lstUnidad.setVisibleItemCount(1);
	    
	    Label lblFamilia = new Label("Familia:");
	    lblFamilia.setStyleName("etiqueta margen");
	    ListBox lstFamilia = new ListBox();
	    lstFamilia.setVisibleItemCount(1);
	    
	    
	   
	    
	    Label lblSubFamilia = new Label("Subfamilia:");
	    lblSubFamilia.setStyleName("etiqueta margen");
	    ListBox lstSubFamilia = new ListBox();
	    lstSubFamilia.setVisibleItemCount(1);
	    

	    
	    ButtonGroup gButtons = new ButtonGroup(3);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button();
	    b1.setText("Imprimir");
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
	    
	   
	    main.add(lblUnidad,new ColumnData(1));
	    main.add(lstUnidad,new ColumnData(1));
	    main.add(lblFamilia,new ColumnData(1));
	    main.add(lstFamilia,new ColumnData(1));
	    main.add(lblSubFamilia,new ColumnData(1));
	    main.add(lstSubFamilia,new ColumnData(1));
	    
	    main.add(gButtons, new ColumnData(1));
	    
	    frmPuestos.add(main, new FormData("100%"));
	}

	public void loadPrevision(FormPanel frmPrevision) {
		FormData formData = new FormData("40%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmPrevision.setSize("100%", "100%");  
		frmPrevision.setBodyBorder(false);
		frmPrevision.setLabelAlign(LabelAlign.TOP);  
		frmPrevision.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
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
	    
	    
	    ButtonGroup gButtons = new ButtonGroup(3);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button();
	    b1.setText("Imprimir");
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
	    
	   
	    main.add(left, new ColumnData(.5));
	    main.add(right, new ColumnData(.5));
	    main.add(bottom, new ColumnData(1));

	    main.add(gButtons, new ColumnData(1));
	    
	    frmPrevision.add(main, new FormData("100%"));
	}

}
