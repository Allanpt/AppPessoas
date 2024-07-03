package br.com.allanpt.AppPessoas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_contato")
public class Contato {

    enum TiposContato {
        TELEFONE,
        CELULAR
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer tipoContato;

    @Column(nullable = false)
    private String contato;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @JsonBackReference
    private Pessoa pessoa;

    public Contato(Long id, TiposContato tipoContato, String contato, Pessoa pessoa) {
        this.id = id;

        if (tipoContato == TiposContato.TELEFONE) {
            this.tipoContato = 0;
        } else if (tipoContato == TiposContato.CELULAR) {
            this.tipoContato = 1;
        }

        this.contato = contato;
        this.pessoa = pessoa;
    }

    public Contato() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(Integer tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Contato contatos = (Contato) o;
        return Objects.equals(id,
                contatos.id
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Contatos{" +
                "id=" + id +
                ", tipoContato=" + tipoContato +
                ", contato='" + contato + '\'' +
                '}';
    }
}
