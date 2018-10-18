
package handler;

import java.io.IOException;
import java.util.*;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import javax.inject.Inject;

import model.Person;
import model.PersonModelProvider;
import view.SimpleTalbeView20181011MidtermKwokSunCheng;
import util.UtilFile;

public class ExportHandler {
	@Inject
	private ESelectionService selectionService;

	@Execute
	public void execute(EPartService epartService, Shell shell) {
		MPart findPart = epartService.findPart(SimpleTalbeView20181011MidtermKwokSunCheng.ID);
		Object findPartObj = findPart.getObject();

		if (findPartObj instanceof SimpleTalbeView20181011MidtermKwokSunCheng) {
			SimpleTalbeView20181011MidtermKwokSunCheng v = (SimpleTalbeView20181011MidtermKwokSunCheng) findPartObj;
			Object selection = selectionService.getSelection();
			List<Person> listPersons = PersonModelProvider.INSTANCE.getPersons();
			//List<Person> listPersons = (List)selection;
			List<String> listContents = new ArrayList<String>();

			listContents.add(
					quote("First Name") + "," + quote("Last Name") + "," + quote("Phone") + "," + quote("Address"));

			for (Person iPerson : listPersons) {
				String iLine = quote(iPerson.getFirstName()) + "," + quote(iPerson.getLastName()) + ","
						+ quote(iPerson.getPhone()) + "," + quote(iPerson.getAddress());
				listContents.add(iLine);
			}
			String FilePath = "C:\\Users\\ksche\\workspaceCSCI4980\\workspaceCSCI4980CHENG\\project2018-1011-Midterm-KwokSun-Cheng\\src\\output-midterm-1011-KwokSun-Cheng.csv";
			try {
				UtilFile.saveFile(FilePath, listContents);
				MessageDialog.openInformation(shell, "Export", "Saved output-midterm-1011-KwokSun-Cheng.csv");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	String quote(String s) {
		return "\"" + s + "\"";
	}

}