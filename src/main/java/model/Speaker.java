package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table (name = "speaker")
public class Speaker extends Person{

    public Speaker(){

    }

	public Speaker(String nome, String cpf){
		super(nome, cpf);
	}

	@Override
	public String toString(){
		return getId() + " | " +
				getNome() + " | " +
				getCpf() + " | ";
	}

    public long getId() {return this.id;}
    public String getNome() {return this.name;}
    public String getCpf() {return this.cpf;}

    public void setNome(String nome){this.name = nome;}
    public void setCpf(String cpf){this.cpf = cpf;}
}