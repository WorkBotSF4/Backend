package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Document.adapter;

import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Document.DocumentEntity;
import org.springframework.data.repository.CrudRepository;

public interface IDocumentCrudRepository extends CrudRepository<DocumentEntity, Integer> {

    DocumentEntity findByNumber(String number);
}
