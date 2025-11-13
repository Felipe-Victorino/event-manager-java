package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table (name = "speaker")
public class Speaker{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String cpf;

    public Speaker(){

    }

    public long getId() {return this.id;}
    public String getNome() {return this.name;}
    public String getCpf() {return this.cpf;}

    public void setNome(String nome){this.name = nome;}
    public void setCpf(String cpf){this.cpf = cpf;}
}