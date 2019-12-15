/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="curso")
public class CursoModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idpessoa", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private ProfessorModel professor;
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name= "cursoaluno",
            joinColumns = @JoinColumn(name="curso_id"),
            inverseJoinColumns = @JoinColumn(name ="aluno_id"))
    private List<AlunoModel> listadealunos;
    
    @Column(length = 40, nullable = false)
    private String titulo;
    
    @Column(length = 40, nullable = false)
    private String descricao;
    
    @Column(length = 40, nullable = false)
    private String localidade;
    @Column
    private int qntVagas;
    
    
    public CursoModel(){}
    public CursoModel(ProfessorModel professor,String titulo,String descricao,String localidade,int qntVagas){
            this.professor = professor;
            this.titulo = titulo;
            this.descricao = descricao;
            this.localidade = localidade;
            this.qntVagas = qntVagas;
    
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
    this.id = id;
    }
    public List<AlunoModel> getListadealunos(){
        return listadealunos;
    }
    public void setListadealunos(List<AlunoModel> listadealunos){
        this.listadealunos = listadealunos;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public ProfessorModel  getProfessor(){
        return professor;
    }
    public void setProfessor(ProfessorModel professor){
        this.professor = professor;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
    this.descricao = descricao;
    }
    public String getLocalidade(){
        return localidade;
    }
    public void setLocalidade(String localidade){
        this.localidade = localidade;
    }
    public int getQntVagas (){
        return qntVagas;
    
    }
    public void setQntVagas(int qntVagas){
        this.qntVagas = qntVagas;
    
    }
}
