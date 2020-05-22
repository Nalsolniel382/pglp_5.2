package fr.uvsq.pglp5_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class DAOCompositePerso implements DAOapp<CompositePerso>, Serializable {
	
	 private static final long serialVersionUID = 123456789L;
	 
	  private ArrayList<CompositePerso> list;
	  
	  //constru
	  public DAOCompositePerso() {
	        list = new ArrayList<CompositePerso>();
	    }
	  //Sere
	  public void serialize(final CompositePerso c, final String f) {
		  
		  ObjectOutputStream out = null;
          try {
            final FileOutputStream fichier = new FileOutputStream(f);
            out = new ObjectOutputStream(fichier);
            out.writeObject(c);
            
            out.flush();
            
          }
          catch (java.io.IOException e)
          {
            e.printStackTrace();
          }
          
          try {
              out.close();
              
          } 
          catch (IOException e)
          {
              e.printStackTrace();
          }
	       
	    }
	 //desere
	  public CompositePerso deserialize(final String f) {
	        ObjectInputStream in = null;
	        CompositePerso ret = null;
	        try {
	            final FileInputStream fichier = new FileInputStream(f);
	            in = new ObjectInputStream(fichier);
	            ret = (CompositePerso) in.readObject();
	            fichier.close();
	        }
	        catch (java.io.IOException e)
	        {
	            e.printStackTrace();
	        }
	        catch (ClassNotFoundException e) 
	        {
	            e.printStackTrace();
	        }
	        return ret;
	    }
	  //get 
	  
	  public CompositePerso get(final int ID) {
	      /*  for (CompositePerso c : list) {
	            if (c.getid() != id);
	            else{ return c;}
	        }
	        return null;*/
		  int i;
	        
	        File repertoire = new File("CompositePerso");
	        String[] liste = repertoire.list();
	        if (liste.length == 0) {
	            return null;
	        } else {
	            for (i = 0; i < liste.length; i++)
	            {
	                if (liste[i].equals(ID))
	                {
	                    return this.deserialize("CompositePerso\\" + liste[i]);
	                }
	                else {System.out.println("le CompositePerso n'a pas Ã©tÃ© trouvÃ©");}
	            }
	        }
	        return null;
	    }
	  
	  //add 
	  public void add(final CompositePerso New) {
	       // list.add(New);
		  int i;
	        File repertoire = new File("CompositePerso");
	        String[] liste = repertoire.list();
	        for (i = 0; i < liste.length; i++) {
	            if (Integer.parseInt(liste[i]) == New.getid()) {
	              return;
	            }
	        }
	        this.serialize(New, "CompositePerso\\" + (New.getid()));
	    }
	    
	 
	  
	  //up 
	  public CompositePerso update(final CompositePerso New) {
		  CompositePerso old = this.get(New.getid() );
	        if (old!= null) {
	            this.remove(old);
	          
	                this.add(New);
	            
	            return New;
	        }
	        System.out.println("le composite personnel n'a pas Ã©tÃ© trouvÃ©");
	        return null;
	    }
	  //remove
	  public void remove(final CompositePerso obj) {
	        list.remove(obj);
	    }
	 
}
