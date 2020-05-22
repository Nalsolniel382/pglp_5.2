package fr.uvsq.pglp5_2;


import java.util.ArrayList;
import java.time.LocalDate;


public class Personnel {
	
	 private static final long serialVersionUID = 147258369L;
	 private final String nom;
	 private final String prenom;
	 private final LocalDate dateNaissance;
	 private ArrayList<String> tel;
	 private String fonctions;
	 private final int id;
	 
	 
	  public static class builder {
	   
	        private final String nom;
	        private final String prenom;
	        private final LocalDate dateNaissance;
	        private ArrayList<String> tel;
	        private String fonctions;
	        private final int id;
	       
	        
	        builder(final String nom, final String prenom, final  LocalDate dateNaissance,ArrayList<String> num,final int id) {
	            this.nom = nom;
	            this.prenom = prenom;
	            this.dateNaissance=dateNaissance;
	            this.fonctions = "employer";
	            this.tel = num;
	            this.id=id;
	            }
	 
	 
	 
	 
	        public Personnel  build( ){
	        	return new Personnel(this);
	        }
	  } 
	 
	 
	 
	 private Personnel(final builder build) {
		 	nom = build.nom;
			prenom = build.prenom;
			dateNaissance = build.dateNaissance;
			tel= build.tel;
			fonctions = build.fonctions;
			id=build.id;
	        }
	 public int getid() {
	        return id;
	    }
	 //faire serealisable 
	public void print() {
			System.out.print("Prenom: "+prenom + " nom: "+ nom + " naissance: " + dateNaissance );
			
			System.out.println();
		}

	

}
