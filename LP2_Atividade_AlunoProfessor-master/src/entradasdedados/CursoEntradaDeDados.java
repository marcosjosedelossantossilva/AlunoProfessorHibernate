/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasdedados;

import javax.swing.JOptionPane;
import modelo.CursoModel;
import modelo.ProfessorModel;
import dao.AlunoDAO;
import dao.ProfessorDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.AlunoModel;

public class CursoEntradaDeDados {
    ProfessorDAO daoProfessor = new ProfessorDAO();
    AlunoDAO daoAluno = new AlunoDAO();
    public CursoModel entradaCurso(){
        CursoModel curso = new CursoModel();
        curso.setTitulo(JOptionPane.showInputDialog("Titulo do Curso: "));
        curso.setDescricao(JOptionPane.showInputDialog("Descrição do Curso:"));
        curso.setLocalidade(JOptionPane.showInputDialog("Local:"));
        curso.setQntVagas(Integer.parseInt(JOptionPane.showInputDialog("Vagas:")));
        long cpf = Long.parseLong(JOptionPane.showInputDialog("CPF DO PROFESOR: "));
        ProfessorModel professor = daoProfessor.buscaPorCPF(cpf);
        curso.setProfessor(professor);
        return curso;
    }

    public CursoModel novaEntradaCurso(CursoModel curso){
        curso.setTitulo(JOptionPane.showInputDialog("Titulo do Curso: "));
        curso.setDescricao(JOptionPane.showInputDialog("Descrição do Curso:"));
        curso.setLocalidade(JOptionPane.showInputDialog("Local:"));
        curso.setQntVagas(Integer.parseInt(JOptionPane.showInputDialog("Vagas:")));
        long cpf = Long.parseLong(JOptionPane.showInputDialog("CPF DO PROFESOR: "));
        ProfessorModel professor = daoProfessor.buscaPorCPF(cpf);
        curso.setProfessor(professor);
        return curso;
    }
    
    public int informarID(String acao){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID do Curso que deseja "+acao+": "));     
        return id;
    }
    public CursoModel CursoAluno(CursoModel curso){
        List<AlunoModel> lista = new ArrayList();
        lista = curso.getListadealunos();
        int ra = Integer.parseInt(JOptionPane.showInputDialog("RA  DO ALUNO: "));
        AlunoModel aluno = daoAluno.buscaPorRA(ra);
        lista.add(aluno);
        curso.setListadealunos(lista);
        return curso;
    }
}
