import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        ArrayList<Livro> livros = new ArrayList<Livro>();
        int option = 0;
        Scanner input = new Scanner(System.in);

        do {
            exibirMenu();
            System.out.println("Digite a opção desejada: ");
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Digite o nome do livro: ");
                    String nomeLivro = input.next();
                    System.out.println("Digite o autor do livro: ");
                    String autorLivro = input.next();
                    System.out.println("Digite o ano de publicação do livro: ");
                    int anoPublicacaoLivro = input.nextInt();
                    System.out.println("Insira a disponibilidade do livro: True ou False");
                    boolean disponibilidadeLivro = input.nextBoolean();
                    Livro livro = new Livro(nomeLivro, autorLivro, anoPublicacaoLivro, disponibilidadeLivro);
                    break;
                case 2:
                    System.out.println("Digite o nome do livro que deseja remover: ");
                    String nomeLivroRemover = input.next();
                    break;
                case 4:
                    System.out.println("Digite o nome do livro que deseja buscar: ");
                    String tituloLivroBuscar = input.next();
                    for(Livro l: livros){
                        if(l.titulo.equalsIgnoreCase(tituloLivroBuscar)){
                            System.out.println(l);
                        }
                    };
                    break;
                }
                case 7:
                    System.out.println("Digite o nome do usuário: ");
                    String nomeUsuario = input.nextLine();
                    System.out.println("Digite o ID do usuário: ");
                    int idUsuario = input.nextInt();
                    System.out.println("Digite o telefone do usuário: ");
                    String telefoneUsuario = input.next();
                    System.out.println("Digite o endereço do usuário: ");
                    String enderecoUsuario = input.next();
                    break;
                default:
                    System.out.println("Opção inválida, insira um valor entre 0 e 8");
                    break;
            }
        }while(option!=0);

}

public static void exibirMenu() {
    System.out.println("1 - Cadastrar Livro");
    System.out.println("2 - Remover Livro");
    System.out.println("3 - Listar Livros");
    System.out.println("4 - Buscar Livro");
    System.out.println("5 - Emprestar Livro");
    System.out.println("6 - Devolver Livro");
    System.out.println("7 - Adicionar Usuário");
    System.out.println("8 - Listar Usuários");
    System.out.println("0 - Sair");
}

    public class Livro {

        public String titulo;
        public String autor;
        public int anoPublicacao;
        public boolean disponibilidade;

        public Livro(String titulo, String autor, int anoPublicacao, boolean disponibilidade) {
            this.titulo = titulo;
            this.autor = autor;
            this.anoPublicacao = anoPublicacao;
            this.disponibilidade = disponibilidade;

        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public int getAnoPublicacao() {
            return anoPublicacao;
        }

        public void setAnoPublicacao(int anoPublicacao) {
            this.anoPublicacao = anoPublicacao;
        }

        public boolean isDisponibilidade() {
            return disponibilidade;
        }

        public void setDisponibilidade(boolean disponibilidade) {
            this.disponibilidade = disponibilidade;
        }

        public void alterarDisponibilidade() {
            this.disponibilidade = !this.disponibilidade;
        }

        @Override
        public String toString() {
            return "Livro{" +
                    "Título='" + titulo + '\'' +
                    ", Autor='" + autor + '\'' +
                    ", Ano de Publicação=" + anoPublicacao +
                    ", Disponibilidade=" + (disponibilidade ? "Disponível" : "Indisponível") +
                    '}';
        }

    }

}