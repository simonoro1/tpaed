package menus;

import java.util.Scanner;

public class menus {
	
//    public static int menuOrigen() {
//
//        int selection;
//        Scanner input = new Scanner(System.in);
//
//        /***************************************************/
//
//        System.out.println("Origen");
//        System.out.println("-------------------------\n");
//        System.out.println("1 - Buenos Aires");
//        System.out.println("2 - Cordoba");
//        System.out.println("3 - San Luis");
//        System.out.println("4 - Mendoza");
//
//
//
//        selection = input.nextInt();
//        return selection;    
//    }
    
    public static String[] menuConsulta() {

        String[] respuestas = new String[5];

        Scanner input = new Scanner(System.in);

        /***************************************************/

        System.out.println("Consulta de Viajes");
        System.out.println("-------------------------\n");
        System.out.println("Nombre:");
        respuestas[0] = input.next();
        System.out.println("Apellido:");
        respuestas[1] = input.next();
        System.out.println("Fecha(Formato: DD-MM-AA):");
        respuestas[2]= input.next();
        System.out.println("Origen(1-BA, 2-CBA, 3-MDZA):");
        respuestas[3] = input.next();
        System.out.println("Destino(1-BA, 2-CBA, 3-MDZA):");
        respuestas[4] = input.next();
        System.out.println("============================");




        return respuestas;    
    }
    
    
    
}
