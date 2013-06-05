package com.patrimonio.plantillas.client.layouts;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;

public class LayoutOnePanel extends LayoutContainer{

	public ContentPanel cPanel = new ContentPanel();
	
	@Override
	protected void onLoad() {
		// TODO Auto-generated method stub
		super.onLoad();
		
	
		cPanel.setHeaderVisible(false);
		cPanel.setCollapsible(false);
		cPanel.setBodyBorder(false);
		cPanel.setBorders(false);

	    
	    BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);  
	    centerData.setMargins(new Margins(0)); 
	    
	    add(cPanel, centerData); 
		
	}
	
}
