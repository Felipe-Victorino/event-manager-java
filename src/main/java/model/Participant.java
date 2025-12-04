package model;

import util.interval.DateIntervalTree;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

@Entity
@Table (name = "participant")
public class Participant extends Person {

	@Transient //Contrário de persistente, não é colocado no banco de dados
	// estou com a impressão que esse não é o melhor lugar pra arvore
	private DateIntervalTree intervalTree;


	public Participant(){

	}

	public Participant(String name, String cpf){
		super(name, cpf);
	}

	@Override
	public String toString(){
		return getNome() + " | " +
				getCpf() + " | ";
	}

    public long getId(){ return this.id;}
    public String getNome(){return this.name;}
    public String getCpf(){return this.cpf;}
	public DateIntervalTree getIntervalTree(){return this.intervalTree;}
	public void setIntervalTree(DateIntervalTree tree){this.intervalTree = tree;}

    public void setNome(String nome){this.name = nome;}
    public void setCpf(String cpf){this.cpf = cpf;}




}