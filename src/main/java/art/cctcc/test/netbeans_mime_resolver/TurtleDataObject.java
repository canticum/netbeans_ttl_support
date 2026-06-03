package art.cctcc.test.netbeans_mime_resolver;

import java.io.IOException;
import java.util.prefs.Preferences;
import org.netbeans.api.editor.mimelookup.MimeLookup;
import org.netbeans.api.editor.settings.SimpleValueNames;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.MIMEResolver;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.util.NbBundle.Messages;

//@Messages({"LBL_Turtle_LOADER=Files of Turtle"})
@Messages({"LBL_Turtle_LOADER=TURTLE TEST LOADER"})
@MIMEResolver.ExtensionRegistration(
        displayName = "#LBL_Turtle_LOADER",
        mimeType = "text/turtle",
        extension = {"ttl"},
        position = 250)
@DataObject.Registration(
        mimeType = "text/turtle",
        iconBase = "art/cctcc/test/netbeans_mime_resolver/turtle-icon.png",
        //    iconBase = "/art/cctcc/test/netbeans_mime_resolver/turtle-icon.png",
        displayName = "#LBL_Turtle_LOADER",
        position = 250)
@ActionReferences({
  @ActionReference(
          path = "Loaders/text/turtle/Actions",
          id = @ActionID(category = "System",
                  id = "org.openide.actions.OpenAction"),
          position = 100,
          separatorAfter = 200),
  @ActionReference(
          path = "Loaders/text/turtle/Actions",
          id = @ActionID(category = "Edit", id = "org.openide.actions.CutAction"),
          position = 300),
  @ActionReference(
          path = "Loaders/text/turtle/Actions",
          id = @ActionID(category = "Edit",
                  id = "org.openide.actions.CopyAction"),
          position = 400,
          separatorAfter = 500),
  @ActionReference(
          path = "Loaders/text/turtle/Actions",
          id = @ActionID(category = "Edit",
                  id = "org.openide.actions.DeleteAction"),
          position = 600),
  @ActionReference(
          path = "Loaders/text/turtle/Actions",
          id = @ActionID(category = "System",
                  id = "org.openide.actions.RenameAction"),
          position = 700,
          separatorAfter = 800),
  @ActionReference(
          path = "Loaders/text/turtle/Actions",
          id = @ActionID(category = "System",
                  id = "org.openide.actions.SaveAsTemplateAction"),
          position = 900,
          separatorAfter = 1000),
  @ActionReference(
          path = "Loaders/text/turtle/Actions",
          id = @ActionID(category = "System",
                  id = "org.openide.actions.FileSystemAction"),
          position = 1100,
          separatorAfter = 1200),
  @ActionReference(
          path = "Loaders/text/turtle/Actions",
          id = @ActionID(category = "System",
                  id = "org.openide.actions.ToolsAction"),
          position = 1300),
  @ActionReference(
          path = "Loaders/text/turtle/Actions",
          id = @ActionID(category = "System",
                  id = "org.openide.actions.PropertiesAction"),
          position = 1400)
})
//@GrammarRegistration(
//    grammar = "/art/cctcc/test/netbeans_mime_resolver/turtle.tmLanguage.json",
//    mimeType = "text/turtle")

public class TurtleDataObject extends MultiDataObject {

//  public TurtleDataObject(FileObject pf, MultiFileLoader loader)
//          throws DataObjectExistsException, IOException {
//    super(pf, loader);
//    registerEditor("text/turtle", true);
//  }
  public TurtleDataObject(FileObject pf, MultiFileLoader loader)
          throws DataObjectExistsException, IOException {
    super(pf, loader);

    Preferences prefs = MimeLookup.getLookup("text/turtle")
            .lookup(Preferences.class);

    if (prefs != null) {
      prefs.put(SimpleValueNames.TEXT_LINE_WRAP, "words");
    }

    registerEditor("text/turtle", true);
  }

  @Override
  protected int associateLookup() {
    return 1;
  }
}
