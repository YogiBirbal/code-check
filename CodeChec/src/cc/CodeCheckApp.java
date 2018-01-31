/*b
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc;
import cc.data.CodeCheckData;
import cc.file.CodeCheckFiles;
import cc.workspace.CodeCheckWorkspace;
import djf.AppTemplate;
import java.util.Locale;
import static javafx.application.Application.launch;

/**
 *
 * @author Yogi
 */
public class CodeCheckApp extends AppTemplate {
    
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        launch(args);
    }

    @Override
    public void buildAppComponentsHook() {
        System.out.println("dci");
        dataComponent =  new CodeCheckData(this);
        workspaceComponent = new CodeCheckWorkspace(this);
        fileComponent = new CodeCheckFiles(this);
    }
    
}
