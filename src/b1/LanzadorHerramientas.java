package b1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LanzadorHerramientas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Menú de opciones
        System.out.println("1. Bloc de notas");
        System.out.println("2. Calculadora");
        System.out.println("3. Listar C:\\Windows");
        System.out.println("4. Programa inexistente4");
        System.out.print("Elige una opción: ");

        String opcion = sc.nextLine().trim();
        sc.close();

        ProcessBuilder pb = new ProcessBuilder();

        switch (opcion) {
            case "1":
                 pb.command("notepad.exe");
                break;

            case "2":
                pb.command("calc.exe");
                break;

            case "3":
                pb.command("cmd.exe", "/c", "dir");
                pb.directory(new File("C:\\Windows"));
                pb.inheritIO();
                break;

            case "4":
                pb.command("programaquenoexiste.exe");
                break;

            default:
                System.out.println("Opción no válida");
                return;
        }

        try {

            Process p = pb.start();
            System.out.println("Lanzado: " + pb.command());

     
            p.waitFor();

        } catch (IOException e) {
            System.out.println("No se pudo lanzar " + pb.command() + ": sin excepción no capturada.");
        } catch (InterruptedException e) {
            System.out.println("La espera del proceso fue interrumpida: " + e.getMessage());
        }
    }
}