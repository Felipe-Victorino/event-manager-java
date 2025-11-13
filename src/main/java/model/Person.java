package model;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {

	protected String name;
	protected String cpf;
}