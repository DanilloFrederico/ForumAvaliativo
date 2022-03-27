

import javax.persistence.EntityManager;
import java.util.List;

public class HibernateDB {

    private EntityManager em;

    public HibernateDB( EntityManager em ) {
        this.em = em;
    }

    public void cadastrarCliente( Cliente cliente ) {
        this.em.persist(cliente);
    }

    public List<Cliente> buscarTodosClientes() {
        String jpql = "SELECT c FROM Cliente c";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public void atualizarCliente( Cliente cliente ) {
        this.em.merge(cliente);
    }

    public void removerCliente( String id ) {
        Cliente cliente = em.find(Cliente.class, id);
        this.em.remove(cliente);
    }

    public Cliente buscarPorIdCliente( String id ) {
        return em.find(Cliente.class, id);
    }
    ///////////////////////////Serviços Produto ////////////////////////////////////
    public void cadastrarProduto( Produto produto ) {
        this.em.persist(produto);
    }

    public List<Produto> buscarTodosProdutos() {
        String jpql = "SELECT c FROM Produto c";
        return em.createQuery(jpql, Produto.class).getResultList();
    }
    public Produto buscarPorIdProduto( int id ) {
        return em.find(Produto.class, id);
    }
    public void atualizarProduto( Produto produto ) {
        this.em.merge(produto);
    }
    public void removerProduto( int id ) {
        Produto produto = em.find(Produto.class, id);
        this.em.remove(produto);
    }
}