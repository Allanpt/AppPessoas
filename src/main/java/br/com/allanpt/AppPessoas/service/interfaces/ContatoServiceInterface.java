package br.com.allanpt.AppPessoas.service.interfaces;

import br.com.allanpt.AppPessoas.model.Contato;

import java.util.List;
import java.util.Optional;

public interface ContatoServiceInterface {

    Contato save(Contato contato);

    Optional<Contato> findById(Long id);

    List<Contato> findAll(Long id);

    Contato update(Long id, Contato contato);

    void delete(Long id);
}
