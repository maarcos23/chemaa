package b3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BuscadorArchivos {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[]args) {
		
		
		
		System.out.println("ruta de una carpeta");
		String ruta = sc.nextLine();
		System.out.println("extension de la carpeta(Sin punto)");
		String extension = sc.nextLine();
		
		File carpeta = new File(ruta);
		if(!carpeta.exists()) {
			System.out.println("ERROR");
			return;
		}
		
		ProcessBuilder pb = new ProcessBuilder("cmd.exe /c dir /b");
		pb.directory(carpeta);
		
		int total;
		String punto = "." + extension.toLowerCase(); // para q den igual las mayusculas
		
		try {
			Process proceso = pb.start();
			
			//esto esta para q se cierre automaticamente los recursos al acabar con su uso 	
			try(BufferedReader brErro = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
				BufferedReader brSalida = new BufferedReader(new InputStreamReader(proceso.getInputStream()))){
				
				String linea;
				
			}
		}catch(IOException e) {
			System.out.println("ERROR..." +e.getMessage());
		}
	}
}
