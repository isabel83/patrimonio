package com.patrimonio.plantillas.client.design;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;

public class DialogoBuscar extends Dialog{
	
	ContentPanel cp = new ContentPanel();
	
	@Override
	protected void onRender(Element parent, int pos) {
		// TODO Auto-generated method stub
		super.onRender(parent, pos);
		
		
		setHeading("Buscar elemento");
		setLayout(new BorderLayout());
		setModal(true);
		
		TextField<String> busqueda = new TextField<String>();  
		busqueda.addStyleName("txtDlgBusqueda");
		
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
		data.setMargins(new Margins(10, 2, 10, 2));
		
		cp.setHeaderVisible(false);
		cp.setBodyBorder(false);
		cp.setBorders(false);
		cp.add(busqueda);
		
		add(cp,data);
		
		setSize(450, 120);
		
		setHideOnButtonClick(true);
		setButtons(Dialog.YESNO);
		getButtonById(Dialog.YES).setText("Buscar");
		getButtonById(Dialog.NO).setText("Cancelar");
		
		addStyleName("dlgBusqueda");
		
	}
}
