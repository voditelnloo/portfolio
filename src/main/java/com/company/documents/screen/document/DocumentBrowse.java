package com.company.documents.screen.document;

import io.jmix.ui.UiComponents;
import io.jmix.ui.action.BaseAction;
import io.jmix.ui.component.Component;
import io.jmix.ui.component.LinkButton;
import io.jmix.ui.component.Table;
import io.jmix.ui.download.Downloader;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;
import com.company.documents.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Document.browse")
@UiDescriptor("document-browse.xml")
@LookupComponent("documentsTable")
@Route("documents")
public class DocumentBrowse extends StandardLookup<Document> {

    @Autowired
    private UiComponents uiComponents;
    @Autowired
    private Downloader downloader;

    @Install(to = "documentsTable.file", subject = "columnGenerator")
    private Component attachmentsTableFileColumnGenerator(Document attachment) {
        if (attachment.getFile() != null) {
            LinkButton linkButton = uiComponents.create(LinkButton.class);
            linkButton.setAction(new BaseAction("download")
                    .withCaption(attachment.getFile().getFileName())
                    .withHandler(actionPerformedEvent ->
                            downloader.download(attachment.getFile())
                    )
            );
            return linkButton;
        } else {
            return new Table.PlainTextCell("<empty>");
        }
    }
}