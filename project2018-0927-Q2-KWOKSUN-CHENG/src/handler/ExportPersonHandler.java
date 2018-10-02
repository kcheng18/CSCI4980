 
package handler;

import java.io.IOException;
import java.util.*;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import model.Person;
import model.PersonModelProvider;
import util.UtilFile;

public class ExportPersonHandler {
	@Execute
	public void execute(Shell shell) {
		List<Person> listPersons = PersonModelProvider.INSTANCE.getPersons();
		List<String> listContents = new ArrayList<String>();
		
		listContents.add(quote("First Name") + "," + quote("Last Name") + "," + quote("Phone") + "," + quote("Address"));
		
		for(Person iPerson : listPersons) {
			String iLine = quote(iPerson.getFirstName()) + "," + quote(iPerson.getLastName()) + "," + quote(iPerson.getPhone()) + "," + quote(iPerson.getAddress());
			listContents.add(iLine);
		}
		String FilePath ="C:\\Users\\ksche\\workspaceCSCI4980\\workspaceCSCI4980CHENG\\project2018-0927-Q2-KWOKSUN-CHENG\\src\\output-q2-0927-KwokSun-Cheng.csv";
		try {
			UtilFile.saveFile(FilePath, listContents);
			MessageDialog.openInformation(shell, "Export", "Saved output-q2-0927-KwokSun-Cheng.csv");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	String quote(String s) {
		return "\"" + s + "\"";
	}
		
}