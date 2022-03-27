import javax.persistence.EntityManager;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;


public class Principal {

    static int menu = 0;
    static int opcao = 0;

    public static void main( String[] args ) {
        interfaceMenuPrincipal();
    }

    public static void interfaceMenuPrincipal() {

        Scanner teclado = new Scanner(System.in);

        System.out.println("**** MENU ****");
        System.out.println("1 - Cliente");
        System.out.println("2 - Produto");
        System.out.println("3 - Exit");
        menu = teclado.nextInt();

        if(menu == 3){
            System.exit(3);
        }
        if(menu == 1 || menu == 2){
            opcao();
        }else{
            interfaceMenuPrincipal();
        }
    }

    public static void opcao() {

        Scanner teclado = new Scanner(System.in);

        System.out.println("**** CATEGORIA ****");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Pesquisar Todos");
        System.out.println("3 - Pesquisar Por Id");
        System.out.println("4 - Alterar");
        System.out.println("5 - Excluir");
        System.out.println("6 - Voltar");

        opcao = teclado.nextInt();
        if(opcao == 6){
            interfaceMenuPrincipal();
        }
        if(opcao > 0 && opcao < 6) {
            opcaoInterface();
        }else{
            opcao();
        }

    }
    public static void opcaoInterface() {
//Cadastrar Cliente
        if(menu == 1 && opcao == 1){
            Scanner teclado = new Scanner(System.in);
            System.out.println("CPF:");
            String cpf = teclado.next();
            System.out.println("NOME:");
            String nome = teclado.next();
            System.out.println("TELEFONE:");
            String fone = teclado.next();
            System.out.println("ENDERECO:");
            String endereco = teclado.next();

            Cliente cliente = new Cliente(cpf, nome, fone, endereco);

            EntityManager em = JPAutil.getEntityManager();
            {
            }
            HibernateDB db = new HibernateDB(em);

            em.getTransaction().begin();

            db.cadastrarCliente(cliente);
            em.getTransaction().commit();
            em.close();
            opcao();
        }
        //Buscar Todos Clientes
        if(menu == 1 && opcao == 2){
            EntityManager em = JPAutil.getEntityManager();
            HibernateDB bd = new HibernateDB(em);
            List<Cliente> clientes = bd.buscarTodosClientes();
            clientes.forEach(
                    c -> System.out.println(">> Nome: " + c.getNome() + " | CPF "
                            + c.getCpf() + " | Telefone: " + c.getFone() + " <<")
            );

            opcao();
        }
        //Buscar Cliente Por ID
        if(menu == 1 && opcao == 3){
            Scanner teclado = new Scanner(System.in);
            System.out.println("CPF:");
            String cpf = teclado.next();
            EntityManager em = JPAutil.getEntityManager();
            HibernateDB bd = new HibernateDB(em);
            Cliente c = bd.buscarPorIdCliente(cpf);
            System.out.println(">> Nome: " + c.getNome() + " | CPF "
                    + c.getCpf() + " | Telefone: " + c.getFone() + " <<");
            opcao();

        }
        //Alteração cadastro cliente
        if(menu == 1 && opcao == 4){
            Scanner teclado = new Scanner(System.in);
            System.out.println("CPF:");
            String cpf = teclado.next();
            System.out.println("NOME:");
            String nome = teclado.next();
            System.out.println("TELEFONE:");
            String fone = teclado.next();
            System.out.println("ENDERECO:");
            String endereco = teclado.next();

            Cliente cliente = new Cliente(cpf, nome, fone, endereco);

            EntityManager em = JPAutil.getEntityManager();
            HibernateDB bd = new HibernateDB(em);
            em.getTransaction().begin();
            bd.atualizarCliente(cliente);
            em.getTransaction().commit();
            em.close();
            opcao();

        }
        //Remover Cliente
        if(menu == 1 && opcao == 5){
            Scanner teclado = new Scanner(System.in);
            System.out.println("CPF:");
            String cpf = teclado.next();

            EntityManager em = JPAutil.getEntityManager();
            HibernateDB bd = new HibernateDB(em);
            em.getTransaction().begin();
            bd.removerCliente(cpf);
            em.getTransaction().commit();
            em.close();
            opcao();

        }

        if(menu == 2 && opcao == 1){
            Scanner teclado = new Scanner(System.in);
            System.out.println("Descricao do Produto:");
            String nome = teclado.next();
            System.out.println("Valor:");
            double preco = teclado.nextDouble();

            Produto produto = new Produto(nome, preco);

            EntityManager em = JPAutil.getEntityManager();
            {
            }
            HibernateDB db = new HibernateDB(em);

            em.getTransaction().begin();

            db.cadastrarProduto(produto);
            em.getTransaction().commit();
            em.close();
            opcao();
        }
        if(menu == 2 && opcao == 2){
            EntityManager em = JPAutil.getEntityManager();
            HibernateDB bd = new HibernateDB(em);
            List<Produto> produto = bd.buscarTodosProdutos();
            produto.forEach(c -> System.out.println(">> Codigo: " + c.getCod() + " | Descricao: "
                    + c.getNome() + " | Valor: " + NumberFormat.getCurrencyInstance().format(c.getPreco()) + " <<"));
            opcao();
        }
        if(menu == 2 && opcao == 3) {
            Scanner teclado = new Scanner(System.in);
            System.out.println("CODIGO:");
            int cod = teclado.nextInt();
            EntityManager em = JPAutil.getEntityManager();
            HibernateDB bd = new HibernateDB(em);
            Produto c = bd.buscarPorIdProduto(cod);
            System.out.println(">> Codigo: " + c.getCod() + " | Descrição: "
                    + c.getNome() + " | Valor: R$ " + NumberFormat.getCurrencyInstance().format(c.getPreco()) + " <<");
            opcao();
        }
        if(menu == 2 && opcao == 4){
            Scanner teclado = new Scanner(System.in);
            System.out.println("NOME:");
            String nome = teclado.next();
            System.out.println("VALOR:");
            double preco = teclado.nextDouble();

            Produto produto = new Produto(nome,preco);

            EntityManager em = JPAutil.getEntityManager();
            HibernateDB bd = new HibernateDB(em);
            em.getTransaction().begin();
            bd.atualizarProduto(produto);
            em.getTransaction().commit();
            em.close();
            opcao();
        }
        if(menu == 2 && opcao == 5) {
            Scanner teclado = new Scanner(System.in);
            System.out.println("CODIGO:");
            int cod = teclado.nextInt();

            EntityManager em = JPAutil.getEntityManager();
            HibernateDB bd = new HibernateDB(em);
            em.getTransaction().begin();
            bd.removerProduto(cod);
            em.getTransaction().commit();
            em.close();
            opcao();

        }

    }
}
