package b3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

public class BuscadorArchivos {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[]args) {
			
		System.out.println("Carpeta: ");
		String ruta = sc.nextLine().trim();
		System.out.println("extension (Sin punto): ");
		String extension = sc.nextLine().trim();
		sc.close();
		
		File carpeta = new File(ruta);
		if(!carpeta.isDirectory()) {
			System.out.println("La carpeta no existe");
			return;
		}
		if(extension.isEmpty()) {
			System.out.println("La extensión es obligatoria");
			return;
		}
		
		File archivoErrores = new File("errores_inspector.txt");
		ProcessBuilder pb = new ProcessBuilder("cmd.exe /c dir /b"+ extension);
		pb.directory(carpeta);
		Map<String, String> entorno = pb.environment();
		entorno.put("DIRCMD", "/b");
		
		
		
		try {
			Process proceso = pb.start();
			int total=0;
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
