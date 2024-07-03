package br.com.allanpt.AppPessoas.resource;


import br.com.allanpt.AppPessoas.dto.PessoaDTO;
import br.com.allanpt.AppPessoas.model.Pessoa;
import br.com.allanpt.AppPessoas.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaResource {

    @Autowired
    PessoaService pessoaService;

    @Operation(summary = "Grava o registro da Pessoa")
    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
        Pessoa newPessoa = pessoaService.save(pessoa);

        if (newPessoa == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(newPessoa);
    }

    @Operation(summary = "Busca registros por ID da Pessoa")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);

        if (pessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pessoa);
    }

    @Operation(summary = "Busca todos os registros de Pessoas")
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> pessoas = pessoaService.findAll();

        if (pessoas == null) {
            return ResponseEntity.notFound().build();
        }

        if (pessoas.size() == 0) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pessoas);
    }

    @Operation(summary = "Atualiza o registro da pessoa. Validação por ID")
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa) {

        Pessoa updatePessoa = pessoaService.update(id,
                pessoa
        );

        if (updatePessoa == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatePessoa);
    }

    @Operation(summary = "Exclui o registro da pessoa por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Busca registros por ID da Pessoa com a mala direta do seu endereço")
    @GetMapping("maladireta/{id}")
    public ResponseEntity<PessoaDTO> malaDireta(@PathVariable Long id) {
        PessoaDTO pessoaDTO = pessoaService.findPessoaMalaDireta(id);

        if (pessoaDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pessoaDTO);
    }
}

