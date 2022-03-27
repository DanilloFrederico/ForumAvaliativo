import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @Column(name="CPF", nullable=false, length=15)
    private String cpf;
    @Column(name="NOME", nullable=false, length=40)
    private String nome;
    @Column(name="TELEFONE", nullable=false, length=15)
    private String fone;
    @Column(name="ENDERECO", nullable=false, length=30)
    private String endereco;

    public Cliente() {
    }

    public Cliente(String cpf, String nome, String fone, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.fone = fone;
        this.endereco = endereco;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
