/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.ProfessorModel;

/**
 *
 * @author Frank
 */
public class ProfessorDAO extends Conexao{
    public void salvarOuAtualizar(ProfessorModel professor) {
        try {
            super.iniciar();
            super.getSessao().saveOrUpdate(professor);
            super.fechar();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }

    }
    public ProfessorModel buscaPorCPF(long cpf) {
       List<ProfessorModel> listaDeProfessor = new ArrayList();
       try {
            iniciar();
            listaDeProfessor = getSessao().createQuery("from ProfessorModel where cpf="+cpf+"").list();
            fechar();
            return listaDeProfessor.get(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return null;
    }
    public List<ProfessorModel> buscarTodos() {
        List<ProfessorModel> listaDeProfessor = new ArrayList<>();
        try {
            iniciar();
            listaDeProfessor = getSessao().createQuery("from ProfessorModel").list();
            fechar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return listaDeProfessor;
    }
    public void remover(ProfessorModel professor) {
        try {
            iniciar();
            getSessao().delete(professor);
            fechar();
            JOptionPane.showMessageDialog(null, "Removido com sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + e.getMessage());
        }
    }
}
