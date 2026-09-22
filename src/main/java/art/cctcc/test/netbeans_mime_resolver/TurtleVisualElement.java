/*
 * Copyright 2026 Chun-yien Chang
 *
 * Licensed under the Apache License, Version 2.0.
 * See the LICENSE file in the project root for license information.
 */
package art.cctcc.test.netbeans_mime_resolver;

import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.text.MultiViewEditorElement;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

public final class TurtleVisualElement {

  private TurtleVisualElement() {
  }

  @Messages("LBL_Turtle_EDITOR=Source")
  @MultiViewElement.Registration(
          displayName = "#LBL_Turtle_EDITOR",
          mimeType = "text/turtle",
          persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED,
          preferredID = "Turtle.source",
          position = 100
  )
  public static MultiViewElement createEditor(Lookup lookup) {

    return new MultiViewEditorElement(lookup);
  }
}
