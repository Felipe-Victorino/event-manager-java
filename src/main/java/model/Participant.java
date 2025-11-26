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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@Transient //Contrário de persistente, não é colocado no banco de dados
	private DateIntervalTree intervalTree;


	public Participant(){

	}

	@Override
	public String toString(){
		return getNome() + '\n' +
				getCpf() + '\n';
	}

    public long getId(){ return this.id;}
    public String getNome(){return this.name;}
    public String getCpf(){return this.cpf;}
	public DateIntervalTree getIntervalTree(){return this.intervalTree;}

    public void setNome(String nome){this.name = nome;}
    public void setCpf(String cpf){this.cpf = cpf;}




}