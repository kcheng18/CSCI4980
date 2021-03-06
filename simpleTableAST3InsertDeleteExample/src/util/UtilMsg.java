package util;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class UtilMsg {
   @Inject
   @Named(IServiceConstants.ACTIVE_SHELL)
   static Shell shell;

   public static void openMsg(String message) {
      MessageDialog.openInformation(shell, "Info", message);
   }

   public static void openWarning() {
      MessageDialog.openWarning(shell, "Warning", "I am warning you!");
   }

   public static boolean openQuestion() {
      return MessageDialog.openQuestion(shell, "Question", "Really, really?");
   }

   public static boolean openQuestion(String msg) {
      return MessageDialog.openQuestion(shell, "Question", msg);
   }

   public static void openWarning(String msg) {
      MessageDialog.openWarning(shell, "Warning", msg);
   }
}
