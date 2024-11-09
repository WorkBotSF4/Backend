package com.uco.backend.api.trasformate.domain.port;

import com.uco.backend.api.trasformate.domain.model.Document;

public interface IDocumentRepository {

    Document save(Document document);
    Document findByNumber(String number);
    Document findById(int id);
    void deleteById(int id);
    Document updateDocument(Document document);

}
