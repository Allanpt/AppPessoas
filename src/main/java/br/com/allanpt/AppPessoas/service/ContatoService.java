package br.com.allanpt.AppPessoas.service;

import br.com.allanpt.AppPessoas.model.Contato;
import br.com.allanpt.AppPessoas.model.Pessoa;
import br.com.allanpt.AppPessoas.repository.ContatoRepository;
import br.com.allanpt.AppPessoas.repository.PessoaRepository;
import br.com.allanpt.AppPessoas.service.interfaces.ContatoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContatoService implements ContatoServiceInterface {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Contato save(Contato contato) {
        Long idPessoa = contato.getPessoa().getId();

        if (idPessoa == null) {
            System.out.println("Pessoa não atribuída ao contato");
            return null;
        }

        Optional<Pessoa> findPessoa = pessoaRepository.findById(idPessoa);

        if (findPessoa.isEmpty()) {
            System.out.println("Pessoa não encontrada na base de dados, id: " + idPessoa);
            return null;
        }

        contato.setPessoa(findPessoa.get());

        return contatoRepository.save(contato);
    }

    @Override
    public Optional<Contato> findById(Long id) {
        return contatoRepository.findById(id);
    }

    @Override
    public List<Contato> findAll(Long id) {
        Optional<Pessoa> findPessoa = pessoaRepository.findById(id);
        if (findPessoa.isEmpty()) {
            System.out.println("Pessoa não encontrada");
            return null;
        }

        Set<Contato> contatoSetList = findPessoa.get().getContatos();
        List<Contato> contatoList = contatoSetList.stream().toList();

        return contatoList;
    }

    @Override
    public Contato update(Long id, Contato contato) {
        Optional<Contato> findContato = contatoRepository.findById(id);

        if(findContato.isPresent()) {
            Contato newContato = findContato.get();
            newContato.setContato(contato.getContato());
            newContato.setTipoContato(contato.getTipoContato());

            return contatoRepository.save(newContato);
        }

        return contatoRepository.save(contato);
    }

    @Override
    public void delete(Long id) {
        contatoRepository.deleteById(id);
    }
}
