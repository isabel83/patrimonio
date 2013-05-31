package com.patrimonio.plantillas.client.layouts;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;

public class LayoutTwoPanels extends LayoutContainer{

	public ContentPanel wPanel = new ContentPanel();
	public ContentPanel cPanel = new ContentPanel();
	
	@Override
	protected void onLoad() {
		// TODO Auto-generated method stub
		super.onLoad();
		
		wPanel.setHeaderVisible(false);
		wPanel.setCollapsible(false);
		wPanel.setBodyBorder(false);
		wPanel.setBorders(false);
		
		cPanel.setHeaderVisible(false);
		cPanel.setCollapsible(false);
		cPanel.setBodyBorder(false);
		cPanel.setBorders(false);
		
		BorderLayoutData westData = new BorderLayoutData(LayoutRegion.WEST, 150);  
	    westData.setSplit(true);  
	    westData.setCollapsible(true);  
	    westData.setMargins(new Margins(0,5,0,0));  
	    
	    BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);  
	    centerData.setMargins(new Margins(0)); 
	    
	    add(wPanel, westData);  
	    add(cPanel, centerData); 
		
	}
	
}
