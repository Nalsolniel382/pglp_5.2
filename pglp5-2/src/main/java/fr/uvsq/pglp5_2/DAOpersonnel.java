package fr.uvsq.pglp5_2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.io.IOException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class DAOpersonnel implements DAOapp<Personnel>, Serializable {
	
	 private static final long serialVersionUID = 963258741L;
	    
	 private ArrayList<Personnel> list;
	
	
	///constructeur
	 public DAOpersonnel() {
	        list = new ArrayList<Personnel>();
	    }
	 //sere
	    public void serialize(final Personnel p, final String f) {
	     
	    	  ObjectOutputStream out = null;
	          try {
	            final FileOutputStream fichier = new FileOutputStream(f);
	            out = new ObjectOutputStream(fichier);
	            out.writeObject(p);
	            
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
	    public Personnel deserialize(final String f) {
	        ObjectInputStream in = null;
	        Personnel ret = null;
	        try {
	            final FileInputStream fichier = new FileInputStream(f);
	            in = new ObjectInputStream(fichier);
	            ret = (Personnel) in.readObject();
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
	  public Personnel get(final int ID)
	  {
	       /* for (Personnel p : list) 
	        {
	            if (p.getid() != ID);
	            else { return p;}
	           
	        }
	        System.out.println("le personnel n'a pas Ã©tÃ© trouvÃ©");
	        return null;*/
		  int i;
	        
	        File repertoire = new File("Personnel");
	        String[] liste = repertoire.list();
	        if (liste.length == 0) {
	            return null;
	        } else {
	            for (i = 0; i < liste.length; i++)//parcourt de toute la liste de preso dans le fichier Presonnel
	            {
	                if (liste[i].equals(ID))
	                {
	                    return this.deserialize("Personnel\\" + liste[i]);
	                }
	                else {System.out.println("le personnel n'a pas Ã©tÃ© trouvÃ©");}
	            }
	        }
	        return null;
	    }
	    
	  
	   public void add(final Personnel object) {
		   int i;
	      //  list.add(object);
		   
	        File repertoire = new File("Personnel");
	        String[] liste = repertoire.list();
	        for (i = 0; i < liste.length; i++) {
	            if (Integer.parseInt(liste[i]) == object.getid()) {
	              return;
	            }
	        }
	        this.serialize(object, "Personnel\\" + (object.getid()));
	    }
	    
	   
	   public Personnel update(final Personnel New) 
	   {
	        Personnel old  = this.get (New.getid() );
	        if (old  != null) {
	            this.remove(old);
	            
	                this.add(New);
	             
	            return New;
	        }
	        return null;
	    }
	   
	 
	   public void remove(final Personnel object) {
	        list.remove(object);
	    }
}