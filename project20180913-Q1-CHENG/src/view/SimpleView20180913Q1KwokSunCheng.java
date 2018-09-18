
package view;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class SimpleView20180913Q1KwokSunCheng {

	// Use Part Descriptor's ID in fragment.e4xmi.
	public static final String VIEW_ID = "project20180913-q1-cheng.partdescriptor.simpleview20180913q1kwoksuncheng";
	// Use Popup Menu's ID in fragment.e4xmi.
	public final static String POPUPMENU_ID = "project20180913-q1-cheng.popupmenu.mypopup";
	// Text box object.
	private StyledText styledText = null;

	@PostConstruct
	public void postConstruct(Composite parent, EMenuService menuService) {
		
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		styledText = new StyledText(container, SWT.BORDER);
		menuService.registerContextMenu(styledText, POPUPMENU_ID);

	}	

	// Pass an empty string parameter here to clear the text box.
	public void setText(String str) {
		this.styledText.setText(str);
	}
	
	public void reverse() {
		
		StringBuilder sb = new StringBuilder();
        sb.append(styledText.getText());
        sb = sb.reverse(); 
        String[] text = sb.toString().split(" ");
        String rtext = "";
        
        for(int i = 1; i < text.length + 1; i++ ) 
        {
        	rtext = rtext + text[text.length - i] + " ";
        }
        this.styledText.setText(rtext);
		
	}

	public void appendText(String str) {
		this.styledText.append(str);
	}

}