package acoes;

import acoes.Actions;
import models.Atividade;
import models.Project;

import java.util.List;
import java.util.Scanner;

public class Relatorio extends Actions {
    public static void projetoRelatorio(List<Project> listProject){
        Scanner input = new Scanner(System.in);
        System.out.println("Selecionar um projeto:\n");
        for(int i = 0; i < listProject.size();  i++){
            System.out.println(listProject.get(i).getId() + " -  " + listProject.get(i).getIdent() + " ( " + listProject.get(i).getIdent() + " )");
        }
        int opt = input.nextInt();
        input.nextLine();
        gerarRelatorioProject(listProject, opt);
    }
    static void gerarRelatorioProject(List<Project> listProject, int ident){
        System.out.println("Nome do Projeto: ");
        System.out.println(listProject.get(ident).getIdent());
        System.out.println("Descricao: \n" + listProject.get(ident).getDesc());
        System.out.println("Status atual: ");
        System.out.println(listProject.get(ident).getStatus());
        System.out.println("models.Coordenador: " +
                listProject.get(ident).getCoord().getName());
        System.out.println("Profissionais envolvidos: ");
        for (int i = 0; i < listProject.get(ident).getProfs().size(); i++){
            System.out.println(listProject.get(ident).getProfs().get(i).getName());
        }
        System.out.println("Atividades envolvidas no Projeto:\n");
        for (int i = 0; i < listProject.get(ident).getAtividades().size(); i++){
            System.out.println(listProject.get(ident).getAtividades().get(i).getIdent() + " "  + listProject.get(ident).getAtividades().get(i).getDesc());
        }
        System.out.println("Inicio: " + listProject.get(ident).getInicio() + " \n" + "Termino: " + listProject.get(ident).getTermino());
        System.out.println("Tempo: " + listProject.get(ident).getTempo());
    }
    public static void atividadeRelatorio(List<Atividade> listAtividade){
        Scanner input = new Scanner(System.in);
        System.out.println("Selecionar uma models.Atividade:\n");
        for(int i = 0; i < listAtividade.size();  i++){
            System.out.println(listAtividade.get(i).getId() + " -  " + listAtividade.get(i).getIdent() + " ( " + listAtividade.get(i).getIdent() + " )");
        }
        int opt = input.nextInt();
        input.nextLine();
        gerarRelatorioAtividade(listAtividade, opt);
    }
    static void gerarRelatorioAtividade(List<Atividade> listAtividade, int ident){
        System.out.println("Nome do Projeto: ");
        System.out.println(listAtividade.get(ident).getIdent());
        System.out.println("Descricao: \n" + listAtividade.get(ident).getDesc());
        System.out.println("Inicio: " + listAtividade.get(ident).getInicio() + " \n" + "Termino: " + listAtividade.get(ident).getTermino());
        System.out.println("Responsavel pela models.Atividade: \n" +
                listAtividade.get(ident).getResp().getName());
        System.out.println("Profissionais envolvidos: ");
        for (int i = 0; i < listAtividade.get(ident).getProfs().size(); i++){
            System.out.println(listAtividade.get(ident).getProfs().get(i).getName());
        }
    }
}
