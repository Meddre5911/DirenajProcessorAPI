package tr.edu.boun.cmpe.direnaj.processor.semantic.services;

import org.apache.commons.collections15.Bag;

/**
 * FIXME bu interface'in implementation'ý Direnaj'a özgü yazýlacak
 */
public interface SemanticOperations {
	
	public String freebaseToDbpedia(String freebaseId);
	
	public Bag<String> findRedirects(String dbpediaResource);
	
	public boolean haveDisambiguation(String dbpediaResource);
	
}
