import java.util.Scanner;

public class nota {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

            System.out.print("Digite uma nota entre A e E: ");
            char notaDigitanda = scanner.next().toUpperCase().charAt(0);

        switch (notaDigitanda) {
            case 'A':
                System.out.println("Excelente");
                break;
            case 'B':
                System.out.println("Bom");
                break;
            case 'C':
                System.out.println("Regular");
                break;
            case 'D':
                System.out.println("Ruim");
                break;
            case 'E':
                System.out.println("Reprovado.");
                break;
            default:
                System.out.println("Nota inválida.");
                break;
        }
        scanner.close();
    }
}