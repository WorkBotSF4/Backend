package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Document.adapter;

import com.uco.backend.api.trasformate.domain.model.Document;
import com.uco.backend.api.trasformate.domain.port.IDocumentRepository;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Document.mapper.IDocumentMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentCrudRepositoryImp implements IDocumentRepository {
   private final IDocumentCrudRepository documentCrudRepository;
    private final IDocumentMapper documentMapper;
    public DocumentCrudRepositoryImp(IDocumentCrudRepository documentCrudRepository, IDocumentMapper documentMapper) {
        this.documentCrudRepository = documentCrudRepository;
        this.documentMapper = documentMapper;
    }

    @Override
    public Document save(Document document) {
        return documentMapper.toDocument(documentCrudRepository.save(documentMapper.toDocumentEntity(document)));
    }

    @Override
    public Document findByNumber(String number) {
        return documentMapper.toDocument(documentCrudRepository.findByNumber(number));
    }

    @Override
    public Document findById(int id) {
        return documentMapper.toDocument(documentCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("NO EXISTE EN LA BASE DE DATOS EL ELEMENTO CON ID " + id)
        ));
    }

    @Override
    public void deleteById(int id) {
        documentCrudRepository.deleteById(id);
    }

    @Override
    public Document updateDocument(Document document) {
        return documentMapper.toDocument(documentCrudRepository.save(documentMapper.toDocumentEntity(document)));
    }
}
