package fr.uvsq.pglp5_2;




import java.util.ArrayList;
import java.util.Iterator;



public class CompositePerso {

	
	private static final long serialVersionUID = 963852077410L;
	private ArrayList<InterfacePerso> personnels;
	private final int id;
	private static int cpt  = 0 ;


	public CompositePerso() {
		cpt=cpt+1;
		id = cpt;
		personnels = new ArrayList<InterfacePerso>();
	}
	
	public void print() {
		System.out.println("Id: " + id);
		for (InterfacePerso ip	 : personnels) {
			ip.print();
		}
	}
	public final int getid() {
		return id;
	}
	 
		public CompositePerso add(final InterfacePerso ip) {
			if (personnels.contains(ip))
			{
				
			}
			else {personnels.add(ip);}
			return this;
		}
		
		public CompositePerso remove(final InterfacePerso ip) {
			if (personnels.contains(ip))  {
				 personnels.remove(ip);
			}
			
			return this;
			
		}
		
		 public Iterator<InterfacePerso> iterator() {
			return personnels.iterator();
			
		}
		
}
