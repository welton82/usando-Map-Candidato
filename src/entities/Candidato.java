package entities;

import java.util.Objects;

public class Candidato {

    private String nome;
    private Integer voto;

    public Candidato() {
    }

    public Candidato(String nome, Integer voto) {
        this.nome = nome;
        this.voto = voto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    @Override
    public String toString() {
        return nome + ", " + voto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidato)) return false;
        Candidato candidato = (Candidato) o;
        return getNome().equals(candidato.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }
}
