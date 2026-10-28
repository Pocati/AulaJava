import java.util.ArrayList;
import java.util.Scanner;

public class sistemadevotacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Candidato> candidatos = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n---Sistema de votação Eletrônica---");
            System.out.println("1 - Cadastrar candidato");
            System.out.println("2 - Consultar candidatos");
            System.out.println("3 - Remover candidato");
            System.out.println("0 - Sair");

            opcao = lerMenu(scanner, "Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do candidato: ");
                    String nome = scanner.nextLine();

                    int numero = lerMenu(scanner, "Digite o número do candidato: ");
                    if (indiceCandidato(candidatos, numero) != -1) {
                        System.out.println("Já existe um candidato cadastrado com esse número.");
                        break;
                    }

                    System.out.print("Digite o partido do candidato: ");
                    String partido = scanner.nextLine();

                    candidatos.add(new Candidato(nome, numero, partido));
                    System.out.println("Candidato cadastrado com sucesso.");
                    break;
                case 2:
                    if (candidatos.isEmpty()) {
                        System.out.println("Nenhum candidato cadastrado.");
                        break;
                    }

                    System.out.println("\nCandidatos cadastrados:");
                    for (Candidato candidato : candidatos) {
                        System.out.println("Nome: " + candidato.nome
                                + " | Número: " + candidato.numero
                                + " | Partido: " + candidato.partido);
                    }
                    break;
                case 3:
                    if (candidatos.isEmpty()) {
                        System.out.println("Nenhum candidato cadastrado para remover.");
                        break;
                    }

                    int numeroRemover = lerMenu(scanner, "Digite o número do candidato que deseja remover: ");
                    int indice = indiceCandidato(candidatos, numeroRemover);
                    if (indice == -1) {
                        System.out.println("Não foi encontrado candidato com esse número.");
                    } else {
                        candidatos.remove(indice);
                        System.out.println("Candidato removido com sucesso.");
                    }
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static int lerMenu(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static int indiceCandidato(ArrayList<Candidato> candidatos, int numero) {
        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).numero == numero) {
                return i;
            }
        }
        return -1;
    }

    private static class Candidato {
        private final String nome;
        private final int numero;
        private final String partido;

        private Candidato(String nome, int numero, String partido) {
            this.nome = nome;
            this.numero = numero;
            this.partido = partido;
        }
    }
}
