package com.backend.crud.model;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "empregado")
public class Empregado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Size(max = 70)
    @Column(name = "nome", nullable = false)
    private String nome;
    @Size(max = 100)
    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;
    @Size(max = 200)
    @Column(name = "email", nullable = false)
    private String email;
    @Size(max = 70)
    @Column(name = "genero", nullable = false)
    private String genero;
    @Size(max = 70)
    @Column(name = "telefone", nullable = false)
    private String telefone;
    @Column(name = "active")
    private Boolean active;

    public Empregado() {
    }

    public Empregado(String nome, String sobrenome, String email, String genero, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.genero = genero;
        this.telefone = telefone;
        this.active = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
