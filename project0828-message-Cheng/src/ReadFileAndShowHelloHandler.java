import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import java.io.*;

public class ReadFileAndShowHelloHandler {
	@Execute
	public void execute(Shell shell) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ksche\\workspaceCSCI4980\\workspaceCSCI4980CHENG\\project0828-message-Cheng\\src\\config.txt"));


		String[] text = br.readLine().split(":");		
		
		MessageDialog.openInformation(shell, "Title", "Hello " + text[1]);
	}
		
}