/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

import javax.persistence.ManyToMany;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;




@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "idpessoa")
public class AlunoModel extends PessoaModel implements Serializable{
    
    private int ra; 
    
    @ManyToMany(mappedBy = "listadealunos")
    @Cascade(CascadeType.ALL)
    private List<CursoModel> listaDeCurso;
    
    public AlunoModel(String nome, int idade, long cpf, String sexo) {
        super(nome, idade, cpf, sexo);
    }

    public AlunoModel() {}
   
    
    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }
    public List<CursoModel> getListaDeCurso(){
        return listaDeCurso;
    }
    public void setListaDeCurso(List<CursoModel> listaDeCurso){
        this.listaDeCurso = listaDeCurso;
    }
    
}
