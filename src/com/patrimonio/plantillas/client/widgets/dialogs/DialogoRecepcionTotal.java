package com.patrimonio.plantillas.client.widgets.dialogs;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Element;

public class DialogoRecepcionTotal extends Dialog {

	
	@Override
	protected void onRender(Element parent, int pos) {
		super.onRender(parent, pos);
		

		setHeading("Recepción total");
		setLayout(new BorderLayout());
		setModal(true);
		
	    DateTimeFormat dtFormat = DateTimeFormat.getFormat("dd-MM-yyyy");
	    DateField fechaSolicitud = new DateField();
	    fechaSolicitud.getPropertyEditor().setFormat(dtFormat);
	    fechaSolicitud.setFieldLabel("Fecha de la recepción total");
	    fechaSolicitud.setTitle("Seleccione la fecha en la que se recepciona el pedido");
		
		BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
		data.setMargins(new Margins(10, 2, 10, 2));
		
		FormPanel cp = new FormPanel();
		cp.setHeaderVisible(false);
		cp.setBodyBorder(false);
		cp.setBorders(false);
		cp.setLayout(new FormLayout());
		cp.setLabelAlign(LabelAlign.TOP);
		cp.add(fechaSolicitud, new FormData("100%"));
		
		add(cp,data);
		
		setSize(350, 150);
		
		setHideOnButtonClick(true);
		setButtons(Dialog.YESNO);
		getButtonById(Dialog.YES).setText("Aceptar");
		getButtonById(Dialog.YES).setStyleAttribute("padding-right", "5px");
		getButtonById(Dialog.YES).addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				hide();
			}
			
		});
		getButtonById(Dialog.NO).setText("Cancelar");
		getButtonById(Dialog.NO).addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				hide();
			}
			
		});
		
		addStyleName("dlgBusqueda");
				
	}
	
}
