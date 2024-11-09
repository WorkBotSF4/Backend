package com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Document.mapper;

import com.uco.backend.api.trasformate.domain.model.Document;
import com.uco.backend.api.trasformate.infraestructure.infraestructureDomain.Document.DocumentEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IDocumentMapper {

    @Mappings(
            {
                    @Mapping(source = "id" , target = "id" ),
                    @Mapping(source = "number" , target = "number" ),
                    @Mapping(source = "documentType" , target = "documentType" )

            }
    )
    Document toDocument(DocumentEntity documentEntity);
    Iterable<Document> toDocuments(Iterable<DocumentEntity> documentEntityIterable);

    @InheritInverseConfiguration
    DocumentEntity toDocumentEntity (Document document);
    Iterable<DocumentEntity> toDocumentEntities(Iterable<Document> documents);
}
