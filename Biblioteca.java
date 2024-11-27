import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        ArrayList<Livro> livros = new ArrayList<Livro>();
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
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
                    livros.add(livro);
                    break;
                case 2:
                    System.out.println("Digite o nome do livro que deseja remover: ");
                    String nomeLivroRemover = input.next();
                    for (Livro l : livros) {
                        if (l.titulo.equalsIgnoreCase(nomeLivroRemover)) {
                            livros.remove(l);
                            break;
                        }
                    }
                    break;
                case 3:
                    for (Livro l : livros) {
                        System.out.println("\nLista de Livros:");
                        System.out.println(l);
                    }
                    break;
                case 4:
                    System.out.println("Digite o nome do livro que deseja buscar: ");
                    String tituloLivroBuscar = input.next();
                    for (Livro l : livros) {
                        if (l.titulo.equalsIgnoreCase(tituloLivroBuscar)) {
                            System.out.println(l);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Digite o nome do livro que deseja emprestar: ");
                    String tituloLivroEmprestar = input.nextLine();
                    System.out.println("Digite o nome do usuário que deseja receber o livro: ");
                    String nomeUsuarioEmprestar = input.nextLine();

                    for (Usuario usuario : usuarios) {
                        if (usuario.nome.equalsIgnoreCase(nomeUsuarioEmprestar)) {
                            for (Livro l : livros) {
                                if (l.titulo.equalsIgnoreCase(tituloLivroEmprestar)) {
                                    if (!l.disponibilidade) {
                                        System.out.println("Livro indisponível");
                                        break;
                                    }
                                    usuario.adicionarLivro(l.titulo);
                                    l.alterarDisponibilidade();
                                    System.out.println("Livro emprestado com sucesso!");

                                } else {
                                    System.out.println("Livro não encontrado");
                                }
                            }
                        } else {
                            System.out.println("Usuário não encontrado");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Digite o nome do livro que deseja devolver: ");
                    String tituloLivroDevolver = input.nextLine();
                    System.out.println("Digite o nome do usuário que deseja devolver o livro: ");
                    String nomeUsuarioDevolver = input.nextLine();
                    for (Usuario usuario : usuarios) {
                        if (usuario.nome.equalsIgnoreCase(nomeUsuarioDevolver)) {
                            for (Livro l : livros) {
                                if (l.titulo.equalsIgnoreCase(tituloLivroDevolver)) {
                                    if (l.disponibilidade) {
                                        System.out.println("Livro devolvido");
                                        break;
                                    }
                                    usuario.removerLivro(l.titulo);
                                    l.alterarDisponibilidade();
                                    System.out.println("Livro devolvido com sucesso!");
                                } else {
                                    System.out.println("Livro não encontrado");
                                }
                            }
                        } else {
                            System.out.println("Usuário não encontrado");
                        }
                    }
                    break;
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
                case 8:
                    for (Usuario u : usuarios) {
                        System.out.println("\nLista de Usuários:");
                        System.out.println(u);
                    }
                    break;
                default:
                    System.out.println("Opção inválida, insira um valor entre 0 e 8");
                    break;
            }
        } while (option != 0);

        input.close();
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

    public static void criarUsuario() {
        System.out.println("Qual o nome do usuario? ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        String id = String.valueOf(Math.random());
        Usuario novoUsuario = new Usuario(nome, id);

        System.out.println("Usuario criado com sucesso");
    }

    public static class Livro {

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

    public static class Usuario {
        String nome;
        String id;
        List<String> livros;

        public Usuario(String nome, String id) {
            this.nome = nome;
            this.id = id;
            this.livros = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "Usuario{" +
                    "nome='" + nome + '\'' +
                    ", id='" + id + '\'' +
                    ", livros=" + livros +
                    '}';
        }

        public void adicionarLivro(String livro) {
            this.livros.add(livro);
        }

        public void removerLivro(String livro) {
            this.livros.remove(livro);
        }
    }
}
