
package handler;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import view.SimpleView20180913Q1KwokSunCheng;

public class ReverseHandler {
	@Inject
	private EPartService epartService;

	@Execute
	public void execute() {

		MPart findPart = epartService.findPart(SimpleView20180913Q1KwokSunCheng.VIEW_ID);
		Object findPartObj = findPart.getObject();

		if (findPartObj instanceof SimpleView20180913Q1KwokSunCheng) {
			SimpleView20180913Q1KwokSunCheng v = (SimpleView20180913Q1KwokSunCheng) findPartObj;			
			
			v.reverse();
			
		}
		

	}

}