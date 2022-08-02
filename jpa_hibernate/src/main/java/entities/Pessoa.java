package entities;
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Pessoa implements Serializable {
    @Id
    private int id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String cpf;
    @Column
    private int DataNascimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
        DataNascimento = dataNascimento;
    }
}
