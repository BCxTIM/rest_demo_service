package com.timrusso.bcxtim.controller;

import com.timrusso.bcxtim.model.Notebook;
import com.timrusso.bcxtim.service.NotebookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tmoiseev on 3/2/2018.
 */
@RestController
public class NotebookController {

    @Autowired
    private NotebookService notebookService;

    /*---Add new notebook---*/
    @PostMapping("/notebook")
    public ResponseEntity<?> save(@RequestBody Notebook notebook) {
        notebookService.save(notebook);
        return ResponseEntity.ok().body(notebook);
    }

    /*---Get a notebook by id---*/
    @GetMapping("/notebook/{id}")
    @ApiOperation(value = "Find notebook by id",
            notes = "Also returns a notebook")
    public ResponseEntity<Notebook> get(@PathVariable("id") int id) {
        Notebook notebook = notebookService.get(id);
        return ResponseEntity.ok().body(notebook);
    }

    /*---get all books---*/
    @GetMapping("/notebook")
    public ResponseEntity<List<Notebook>> list() {
        List<Notebook> notebooks = notebookService.list();
        return ResponseEntity.ok().body(notebooks);
    }

    /*---Update a notebook by id---*/
    @PutMapping("/notebook/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Notebook notebook) {
        Notebook existingNotebook = notebookService.get(id);
        if(existingNotebook == null) {
            return ResponseEntity.badRequest().body("Notebook has not been founded");
        } else {
            existingNotebook.setAuthor(notebook.getAuthor());
            existingNotebook.setTitle(notebook.getTitle());
            notebookService.update(existingNotebook);
            return ResponseEntity.ok().body("Notebook has been updated successfully.");
        }

    }

    /*---Delete a notebook by id---*/
    @DeleteMapping("/notebook/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Notebook existingNotebook = notebookService.get(id);
        if(existingNotebook == null) {
            return ResponseEntity.badRequest().body("Notebook has not been founded");
        } else {
            notebookService.delete(existingNotebook);
        }
        return ResponseEntity.ok().body("Notebook has been deleted successfully.");
    }
}