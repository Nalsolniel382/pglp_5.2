package fr.uvsq.pglp5_2;

import java.util.ArrayList;
import java.util.Map;

public interface DAOapp<D> {
	
	D get(int id);
	void add(D object);
	abstract D update(D object);
	void remove(D object);
	abstract void serialize(D object, String f);
	  public abstract D deserialize(String f);
}
