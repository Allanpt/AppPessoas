package br.com.allanpt.AppPessoas.repository;

import br.com.allanpt.AppPessoas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
