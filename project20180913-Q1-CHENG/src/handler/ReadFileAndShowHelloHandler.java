 
package handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.widgets.Shell;

import view.SimpleView20180913Q1KwokSunCheng;

public class ReadFileAndShowHelloHandler {
	
	@Inject
	private EPartService epartService;
	
	@Execute
	public void execute(Shell shell) throws IOException {
		
		MPart findPart = epartService.findPart(SimpleView20180913Q1KwokSunCheng.VIEW_ID);
		Object findPartObj = findPart.getObject();

		if (findPartObj instanceof SimpleView20180913Q1KwokSunCheng) {
			SimpleView20180913Q1KwokSunCheng v = (SimpleView20180913Q1KwokSunCheng) findPartObj;
			
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ksche\\workspaceCSCI4980\\workspaceCSCI4980CHENG\\project20180913-Q1-CHENG\\src\\config.txt"));
			String[] text = br.readLine().split(":");		
			
			v.appendText("Hello " + text[1]);
		}
		
	}
		
}