package br.com.allanpt.AppPessoas.service.interfaces;

import br.com.allanpt.AppPessoas.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaServiceInterface {

    Pessoa save(Pessoa pessoa);

    Optional<Pessoa> findById(Long id);

    List<Pessoa> findAll();

    Pessoa update(Long id, Pessoa pessoa);

    void delete(Long id);
}
