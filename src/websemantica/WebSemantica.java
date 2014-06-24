package websemantica;

import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WebSemantica {

    final public static List<String> csb = new ArrayList<>();
    final public static List<String> individuo = new ArrayList<>();
    final public static List<String> relaciones = new ArrayList<>();
    final public static List<String> propiedades = new ArrayList<>();
   
      
    public void recuperarInformacion() {
        OntModel areaOntology = ModelFactory.createOntologyModel();

        try {
            InputStream file = new FileInputStream("C:/Users/Ronald/Documents/NetBeansProjects"
                    + "/WebSemantica/Archivos/CIS.owl");
            areaOntology.read(file, "");

        } catch (FileNotFoundException ex) {
        }
        Iterator<Individual> individuos = areaOntology.listIndividuals();
        
        while (individuos.hasNext()) {
            individuo.add("\n"+individuos.next().getLocalName());

        }
       Iterator<OntClass> clases = areaOntology.listClasses();
                    
       while (clases.hasNext()) {
           if (clases.next().getLocalName() != null) {
            csb.add("\n"+clases.next().getLocalName());

        }
       }
        Iterator<ObjectProperty> relacion = areaOntology.listObjectProperties();
        while (relacion.hasNext()) {
            relaciones.add("\n"+relacion.next().getLocalName());

        }
        
        
    }
}
