
package handler;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import analysis.ProjectAnalyzer;
import view.SimpleZestGraphView;

public class FindEmptyMethodHandler {
   @Execute
   public void execute(EPartService service) {
      try {
         MPart findPart = service.findPart(SimpleZestGraphView.SIMPLEZESTVIEW);
         if (findPart != null && findPart.getObject() instanceof SimpleZestGraphView) {
            ProjectAnalyzer analyzer = new ProjectAnalyzer();
            analyzer.analyze();

            SimpleZestGraphView zestView = (SimpleZestGraphView) findPart.getObject();
            if (!analyzer.getNodeList().isEmpty()) {
               zestView.updateByContextMenu(analyzer.getNodeList());
            }
         }
      } catch (CoreException e) {
         e.printStackTrace();
      }
   }
}
