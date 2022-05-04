package com.company.documents.screen.document;

import io.jmix.ui.screen.*;
import com.company.documents.entity.Document;

@UiController("Document.edit")
@UiDescriptor("document-edit.xml")
@EditedEntityContainer("documentDc")
public class DocumentEdit extends StandardEditor<Document> {
}