/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg19_02_lp2_alunoprofessor;

import entradasdedados.AlunoEntradaDeDados;
import entradasdedados.ProfessorEntradaDeDados;
import entradasdedados.AreaEntradaDeDados;
import entradasdedados.CursoEntradaDeDados;
import dao.AlunoDAO;
import dao.AreaDAO;
import dao.CursoDAO;
import dao.ProfessorDAO;

import java.util.List;
import javax.swing.JOptionPane;

import modelo.AlunoModel;
import modelo.AreaModel;
import modelo.CursoModel;
import modelo.ProfessorModel;


public class Main {

   public static void main(String[] args) {
        AlunoEntradaDeDados entradaAluno = new AlunoEntradaDeDados();
        AreaEntradaDeDados entradaArea = new AreaEntradaDeDados();
        CursoEntradaDeDados entradaCurso = new CursoEntradaDeDados();
        ProfessorEntradaDeDados entradaProfessor = new ProfessorEntradaDeDados();
        
        AlunoDAO daoAluno = new AlunoDAO();
        AreaDAO daoArea = new AreaDAO();
        CursoDAO daoCurso = new CursoDAO();
        ProfessorDAO daoProfessor = new ProfessorDAO();
        
        AlunoModel alunoModel = new AlunoModel();
        AreaModel areaModel = new AreaModel();
        CursoModel cursoModel = new CursoModel();
        ProfessorModel professorModel = new ProfessorModel();
        
        String menu = "0- Sair\n1 - Aluno\n2 - Area\n3 - Curso\n4 - Professor";
        String menuCurso = "0- Sair\n1- Voltar\n2 - Salvar\n3 - Exibir Todos\n4 - Editar\n5 - Remover\n6 - Exibir Por ID\n7- matricular";
        String menuAluno = "0- Sair\n1- Voltar\n2 - Salvar\n3 - Exibir Por CPF\n4 - Exibir Todos\n5 - Editar\n6 - Remover";
        String menuProfessor = "0- Sair\n1- Voltar\n2 - Salvar\n3 - Exibir Por CPF\n4 - Exibir Todos\n5 - Editar\n6 - Remover";
        String menuArea = "0- Sair\n1- Voltar\n2 - Salvar\n3 - Exibir Todos\n4 - Editar\n5 - Remover\n6 - Exibir Por ID";
        String opt = "";
        do {
            opt = JOptionPane.showInputDialog(menu);
            switch (opt) {
                case "0":
                    break;
                case "1":
                    opt = JOptionPane.showInputDialog(menuAluno);
                    switch (opt) {
                        case "1":
                            break;
                        case "2":
                            daoAluno.salvarOuAtualizar(entradaAluno.entradaAluno());
                            break;
                        case "3":
                            alunoModel = daoAluno.buscaPorRA( Integer.parseInt(entradaAluno.leituraRA()));
                            if(alunoModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrado o aluno com o CPF informado");
                            }else{
                                JOptionPane.showMessageDialog(null, "Nome do Aluno: " +alunoModel.getNome()+"RA:"+alunoModel.getRa());
                            }
                            break;
                        case "4":
                            List<AlunoModel> listaDeAlunos = daoAluno.buscarTodos();
                            for (AlunoModel aluno : listaDeAlunos) {
                                JOptionPane.showMessageDialog(null, "Descrição da Area: " + aluno.getNome());
                            }
                            break;
                        case "5":
                           
                           alunoModel = daoAluno.buscaPorRA( Integer.parseInt(entradaAluno.leituraRA()));
                            if(alunoModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrado o Cpf informado");
                            }else{
                                daoAluno.salvarOuAtualizar(entradaAluno.novaEntradaAluno(alunoModel));
                            }
                            break;
                        case "6":
                           alunoModel = daoAluno.buscaPorRA( Integer.parseInt(entradaAluno.leituraRA()));
                            if(alunoModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada aluno com CPF informado");
                            }else{
                                daoAluno.remover(alunoModel);
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    break;
                case "2":
                    opt = JOptionPane.showInputDialog(menuArea);
                    switch (opt) {
                        case "0":
                            break;
                        case "1":
                            break;
                        case "2":
                            daoArea.salvarOuAtualizar(entradaArea.entradaArea());
                            break;
                        case "3":
                            List<AreaModel> listaDeArea = daoArea.buscarTodos();
                            for (AreaModel area : listaDeArea) {
                                JOptionPane.showMessageDialog(null, "Descrição da Area: " + area.getDescricao());
                            }
                            break;
                        case "4":
                            areaModel = daoArea.buscarPorId(entradaArea.informarID("Editar"));
                            if(areaModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            }else{
                                daoArea.salvarOuAtualizar(entradaArea.novaEntradaArea(areaModel));
                            }
                            break;
                        case "5":
                            areaModel = daoArea.buscarPorId(entradaArea.informarID("Remover"));
                            if(areaModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            }else{
                                daoArea.remover(areaModel);
                            }
                            break;
                        case "6":
                            areaModel = daoArea.buscarPorId(entradaArea.informarID("Buscar"));
                            if(areaModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            }else{
                                JOptionPane.showMessageDialog(null, "Descrição da Area: " + areaModel.getDescricao()+"ListaDeProfessores:"+areaModel.getListaDeProfessores().get(0).getNome());
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    break;
                case "3":
                    opt = JOptionPane.showInputDialog(menuCurso);
                    switch (opt) {
                        case "0":
                            break;
                        case "1":
                            break;
                        case "2":
                            daoCurso.salvarOuAtualizar(entradaCurso.entradaCurso());
                            break;
                        case "3":
                            List<CursoModel> listaDeCurso = daoCurso.buscarTodos();
                            for (CursoModel curso : listaDeCurso) {
                                JOptionPane.showMessageDialog(null, "Descrição do Curso: " + curso.getDescricao());
                            }
                            break;
                        case "4":
                            cursoModel = daoCurso.buscarPorId(entradaArea.informarID("Editar"));
                            if(cursoModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            }else{
                                daoCurso.salvarOuAtualizar(entradaCurso.novaEntradaCurso(cursoModel));
                            }
                            break;
                        case "5":
                            cursoModel = daoCurso.buscarPorId(entradaCurso.informarID("Remover"));
                            if(cursoModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            }else{
                                daoCurso.remover(cursoModel);
                            }
                            break;
                        case "6":
                            cursoModel = daoCurso.buscarPorId(entradaCurso.informarID("Buscar"));
                            if(cursoModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            }else{
                                JOptionPane.showMessageDialog(null, "Descrição do curso: " + cursoModel.getDescricao());
                            }
                            break;
                        case "7":
                            List<CursoModel> lista = daoCurso.buscarTodos();
                            int i =1;
                            String str = "";
                            for(CursoModel curso : lista){
                                String titulo ="("+i+"):"+curso.getTitulo()+"\n";
                                str = str+titulo;
                                i++;
                            }
                            int id = Integer.parseInt(JOptionPane.showInputDialog(str+"Digite o Id do curso:"));
                            cursoModel = daoCurso.buscarPorId(id);
                            if(cursoModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada curso com a ID informado");
                            }else{
                                daoCurso.salvarOuAtualizar(entradaCurso.CursoAluno(cursoModel));
                            }
                            
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    
                    break;
                case "4":
                    opt = JOptionPane.showInputDialog(menuProfessor);
                    switch (opt) {
                        case "1":
                            break;
                        case "2":
                            daoProfessor.salvarOuAtualizar(entradaProfessor.entradaProfessor());
                            break;
                        case "3":
                            professorModel = daoProfessor.buscaPorCPF(Long.parseLong(entradaProfessor.leituraCPF()));
                            if(professorModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrado o professor com o CPF informado");
                            }else{
                                JOptionPane.showMessageDialog(null, "Nome do Aluno: " +professorModel.getNome()+"SIAPE:"+professorModel.getSiape()+"Area:"+professorModel.getArea().getDescricao());
                            }
                            break;
                        case "4":
                            List<ProfessorModel> listaDeProfessores = daoProfessor.buscarTodos();
                            for (ProfessorModel professor : listaDeProfessores) {
                                JOptionPane.showMessageDialog(null, "Nome do Professor: " + professor.getNome());
                            }
                            break;
                        case "5":
                            //depois de buscar que quer editar, tem que entrar com as novas informações
                            professorModel = daoProfessor.buscaPorCPF(Long.parseLong(entradaProfessor.leituraCPF()));
                            if(professorModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrado o Cpf informado");
                            }else{
                                daoProfessor.salvarOuAtualizar(entradaProfessor.novaEntradaProfessor(professorModel));
                            }
                            break;
                        case "6":
                            professorModel = daoProfessor.buscaPorCPF(Long.parseLong(entradaProfessor.leituraCPF()));
                            if(professorModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada aluno com CPF informado");
                            }else{
                                daoProfessor.remover(professorModel);
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (!opt.equals("0"));
        daoAluno.encerrar();
    }

}
