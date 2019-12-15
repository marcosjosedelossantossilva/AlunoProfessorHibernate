/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasdedados;

import javax.swing.JOptionPane;
import modelo.ProfessorModel;
import modelo.AreaModel;
import dao.AreaDAO;


public class ProfessorEntradaDeDados {
    AreaDAO daoArea = new AreaDAO();
    public ProfessorModel entradaProfessor(){
        
        ProfessorModel professor = new ProfessorModel();
        professor.setNome(JOptionPane.showInputDialog("Nome: "));
        professor.setSexo(JOptionPane.showInputDialog("Sexo: "));
        professor.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        professor.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
        professor.setSiape(Long.parseLong(JOptionPane.showInputDialog("SIAPE: ")));
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID da area: "));
        AreaModel area = daoArea.buscarPorId(id);
        professor.setArea(area);
        return professor;
    }
    public ProfessorModel novaEntradaProfessor(ProfessorModel professor){
        professor.setNome(JOptionPane.showInputDialog("Nome: "));
        professor.setSexo(JOptionPane.showInputDialog("Sexo: "));
        professor.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        professor.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
        professor.setSiape(Long.parseLong(JOptionPane.showInputDialog("SIAPE: ")));
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID da area: "));
        AreaModel area = daoArea.buscarPorId(id);
        professor.setArea(area);
        return professor;
    
    }
    public String leituraCPF() {
        String cpf = JOptionPane.showInputDialog("Entre com o CPF: ");
        return cpf;
    }
    
}
