package br.com.allanpt.AppPessoas.resource;

import br.com.allanpt.AppPessoas.model.Contato;
import br.com.allanpt.AppPessoas.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contatos")
public class ContatoResource {

    @Autowired
    ContatoService contatoService;

    @Operation(summary = "Grava o registro do Contato utilizando o id da Pessoa")
    @PostMapping
    public ResponseEntity<Contato> save(@RequestBody Contato contato) {
        Contato newContato = contatoService.save(contato);

        if (newContato == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(newContato);
    }

    @Operation(summary = "Busca registros por ID do Contato")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id) {
        Optional<Contato> contato = contatoService.findById(id);

        if (contato.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contato);
    }

    @Operation(summary = "Busca todos os registros de Contatos por Pessoa")
    @GetMapping("pessoa/{id}")
    public ResponseEntity<List<Contato>> findAllContactsByPerson(@PathVariable Long id) {
        List<Contato> contatos = contatoService.findAll(id);

        if (contatos == null) {
            return ResponseEntity.notFound().build();
        }

        if (contatos.size() == 0) {
            return ResponseEntity.noContent().build();
        }


        return ResponseEntity.ok(contatos);
    }

    @Operation(summary = "Atualiza o registro do Contato. Validação por ID")
    @PutMapping("/{id}")
    public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody Contato contato) {

        Contato updateContato = contatoService.update(id,
                contato
        );

        if (updateContato == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updateContato);
    }

    @Operation(summary = "Exclui o registro do Contato por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        contatoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

