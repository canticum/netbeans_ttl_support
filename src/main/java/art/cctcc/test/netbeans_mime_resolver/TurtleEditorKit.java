package art.cctcc.test.netbeans_mime_resolver;

import javax.swing.text.EditorKit;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.editor.NbEditorKit;

@MimeRegistration(mimeType = "text/turtle", service = EditorKit.class)
public class TurtleEditorKit extends NbEditorKit {

    @Override
    public String getContentType() {
        return "text/turtle";
    }
}