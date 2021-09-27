package application;


import entities.Candidato;

//import java.io.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//import java.util.*;

public class Program {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        //Map é uma coleção de chave e valor
        operacao(sc);




    }
    public static int opcao(Scanner sc){
        System.out.println("0 - Sair");
        System.out.println("1 - Inserir na lista Map");
        System.out.println("2 - Listar");
        System.out.println("3 - Arquivar Lista Gerada");
        System.out.print("Opção: ");
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }

    public static void operacao(Scanner sc) throws IOException {

        Map<Candidato, Integer> candidatos = new HashMap<>();
        int op = -1;

        while (op != 0) {

            op = opcao(sc);
            switch (op) {
                case 1:
                    System.out.print("Informe o nome do Candidato: ");
                    String nome = sc.nextLine();
                    System.out.print("Informe a Quantidade de Votos: ");
                    Integer vt = sc.nextInt();
                    candidatos.put(new Candidato(nome, vt), vt);
                    break;
                case 2:
                    System.out.println("Listando os Candidatos");
                    for (Candidato x : candidatos.keySet()) {
                        System.out.println(x);
                    }
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.print("Informe o Caminho para Arquivar: ");
                    String caminho = sc.next();
                    caminho += ".txt";

                   //FileReader fr = new FileReader(caminho);
                   //BufferedReader br = new BufferedReader(fr);
                   String line;// = br.readLine();

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {

                        int i = 1;
                        line = "";
                        for (Candidato x : candidatos.keySet()) {
                            line += x.toString() + "\n";
                            i++;
                        }
                        String[] lines = {line};

                        for (String l : lines) {
                            bw.write(l);
                            bw.newLine();
                        }

                    } catch (ExceptionInInitializerError e) {
                        System.out.println(e.getMessage());
                    }
                break;
                case 4:
                    //somar todos os votos com MAP
                    break;
            }//Fim Switch



        }//fim while

    }//Fim Método


}
