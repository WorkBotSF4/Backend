package com.uco.backend.api.trasformate.application;

import com.uco.backend.api.trasformate.domain.model.Document;
import com.uco.backend.api.trasformate.domain.port.IDocumentRepository;

public class DocumentService {
    private final IDocumentRepository documentRepository;
    public DocumentService(IDocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document findByNumber (String number) {
        return documentRepository.findByNumber(number);
    }
    public Document save(Document document) {
        return documentRepository.save(document);
    }
    public Document findById(int id) {
        return documentRepository.findById(id);
    }
    public void deleteById(int document) {
        documentRepository.deleteById(document);
    }
    public Document update(Document document) {
        return documentRepository.updateDocument(document);
    }
}
