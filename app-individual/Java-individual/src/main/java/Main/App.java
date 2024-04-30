package Main;

import Entidades.*;
import Models.*;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.janelas.Janela;
import com.github.britooo.looca.api.group.janelas.JanelaGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.sistema.Sistema;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {


        HistoricoConsumoDAO histConsmRecurso = new HistoricoConsumoDAO();
        System.out.println("""
                Seja Bem Vindo(a) a
                
                **      **  **  **   **  *******         ********  **********  *********    *********
                ** **** **  **  ***  **  **     **      **         **      **  **      **   **
                **  **  **  **  ** * **  **      **    **          **      **  *********    *****
                **      **  **  **  ***  **     **      **         **      **  **   **      **
                **      **  **  **   **  *******         ********  **********  **     **    *********
                
                """);

        Usuario.FazerLogin();




        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("""
                    +------------------------------------+
                    |         Escolha uma opção:         |    
                    +------------------------------------+
                    | 1 - Visualizar dados da CPU        |
                    | 2 - Visualizar dados da RAM        |
                    | 3 - Visualizar dados das Janelas   |
                    | 4 - Visualizar dados gerais        |
                    | 0 - Sair                           |
                    +------------------------------------+
                    """);

            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    // Visualizar dados da CPU
                    System.out.println("+--------------------------+");
                    System.out.println("| Opção selecionada: 1     |");
                    System.out.println("+--------------------------+");
                    histConsmRecurso.insertHistoricoCpu();

                    break;
                case 2:
                    // Visualizar dados da RAM
                    System.out.println("+--------------------------+");
                    System.out.println("| Opção selecionada: 2     |");
                    System.out.println("+--------------------------+");
                    histConsmRecurso.insertHistoricoRam();
                    break;
                case 3:
                    // Visualizar dados das Janelas
                    System.out.println("+--------------------------+");
                    System.out.println("| Opção selecionada: 3     |");
                    System.out.println("+--------------------------+");
                    histConsmRecurso.insertHistoricoJanelas();
                    break;
                case 4:
                    // Visualizar dados gerais
                    System.out.println("+--------------------------+");
                    System.out.println("| Opção selecionada: 4     |");
                    System.out.println("+--------------------------+");
                    histConsmRecurso.insertHistoricoGeral();

                    break;
                case 0:
                    System.out.println("Até uma próxima!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();

    }



}

