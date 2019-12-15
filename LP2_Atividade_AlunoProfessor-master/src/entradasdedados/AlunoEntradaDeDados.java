/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasdedados;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.AlunoModel;

public class AlunoEntradaDeDados {

    public AlunoModel entradaAluno(){
        
        AlunoModel aluno = new AlunoModel();
        aluno.setNome(JOptionPane.showInputDialog("Nome: "));
        aluno.setSexo(JOptionPane.showInputDialog("Sexo: "));
        aluno.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
        aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("RA: ")));        
        return aluno;
    }
    public AlunoModel novaEntradaAluno(AlunoModel aluno){
        aluno.setNome(JOptionPane.showInputDialog("Nome: "));
        aluno.setSexo(JOptionPane.showInputDialog("Sexo: "));
        aluno.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
        aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("RA: ")));
        
        return aluno;
    
    }
    public String leituraRA() {
        String Ra = JOptionPane.showInputDialog("Entre com o RA: ");
        return Ra;
    }
}
