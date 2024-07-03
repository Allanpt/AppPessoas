package br.com.allanpt.AppPessoas.repository;

import br.com.allanpt.AppPessoas.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
