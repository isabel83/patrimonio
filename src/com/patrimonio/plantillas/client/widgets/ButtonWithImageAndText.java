package com.patrimonio.plantillas.client.widgets;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;

public class ButtonWithImageAndText extends PushButton {

	   public ButtonWithImageAndText(Image upImage, String text) {
	       super(upImage);
	       this.setHTML("<Table cellspacing=2> <tr> <td>" + upImage.toString() + "</td> <td  align=middle>" + text + "</td></tr></Table>");

	 }

	}
