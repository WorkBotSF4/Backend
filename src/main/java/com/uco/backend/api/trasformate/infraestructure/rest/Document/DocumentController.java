package com.uco.backend.api.trasformate.infraestructure.rest.Document;

import com.uco.backend.api.trasformate.application.DocumentService;
import com.uco.backend.api.trasformate.domain.model.Document;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/documents")
public class DocumentController {
    private final DocumentService documentService;
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }
    @PostMapping("/crear")
    public Document createDocument(@RequestBody Document document) {
        return documentService.save(document);
    }

    @GetMapping("/get/{id}")
    public Document findDocument(@PathVariable int id) {
        return documentService.findById(id);
    }
}
