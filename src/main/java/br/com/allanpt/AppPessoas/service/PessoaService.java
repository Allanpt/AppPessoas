package br.com.allanpt.AppPessoas.service;

import br.com.allanpt.AppPessoas.dto.PessoaDTO;
import br.com.allanpt.AppPessoas.model.Pessoa;
import br.com.allanpt.AppPessoas.repository.PessoaRepository;
import br.com.allanpt.AppPessoas.service.interfaces.PessoaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService implements PessoaServiceInterface {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa save(Pessoa pessoa) {
        if (pessoa.getNome() == null) {
            System.out.println("Nome da Pessoa vazio");
            return null;
        }

        try {
            return pessoaRepository.save(pessoa);
        } catch (Exception e) {
            System.out.println("ERR: Erro ao inserir produto " +
                    pessoa.toString() + ": " + e.getMessage());
            return null;
        }
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa update(Long id, Pessoa pessoa) {
        Optional<Pessoa> findPessoa = pessoaRepository.findById(id);

        if (findPessoa.isPresent()) {
            Pessoa newPessoa = findPessoa.get();

            newPessoa.setNome(pessoa.getNome());
            newPessoa.setCep(pessoa.getCep());
            newPessoa.setCidade(pessoa.getCidade());
            newPessoa.setEndereco(pessoa.getEndereco());
            newPessoa.setUf(pessoa.getUf());

            return pessoaRepository.save(newPessoa);
        }
        return pessoaRepository.save(pessoa);
    }

    @Override
    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }

    public PessoaDTO findPessoaMalaDireta(Long id) {
        Pessoa findPessoa = findById(id).get();

        Long idPessoa = findPessoa.getId();
        String nomePessoa = findPessoa.getNome();
        String malaDireta =
                findPessoa.getEndereco() + " – CEP: " + findPessoa.getCep() + " – " + findPessoa.getCidade() + "/" + findPessoa.getUf();

        PessoaDTO pessoaDTO = new PessoaDTO(idPessoa,
                nomePessoa,
                malaDireta
        );

        return pessoaDTO;
    }
}
