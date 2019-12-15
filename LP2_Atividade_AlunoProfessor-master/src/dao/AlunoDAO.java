/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AlunoModel;


/**
 *
 * @author Frank
 */
public class AlunoDAO extends Conexao {

    public void salvarOuAtualizar(AlunoModel aluno) {
        try {
            super.iniciar();
            super.getSessao().saveOrUpdate(aluno);
            super.fechar();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }

    }

    public AlunoModel buscaPorRA(int ra) {
        List<AlunoModel> listaDeAlunos = new ArrayList<>();
       try {
            iniciar();
            listaDeAlunos = getSessao().createQuery("from AlunoModel where ra="+ra+"").list();
            fechar();
            
            return listaDeAlunos.get(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return null;
    }

    public List<AlunoModel> buscarTodos() {
        List<AlunoModel> listaDeAlunos = new ArrayList<>();
        try {
            iniciar();
            listaDeAlunos = getSessao().createQuery("from AlunoModel").list();
            fechar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return listaDeAlunos;
    }
    
    public void remover(AlunoModel aluno) {
        try {
            iniciar();
            getSessao().delete(aluno);
            fechar();
            JOptionPane.showMessageDialog(null, "Removido com sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + e.getMessage());
        }
    }

}
