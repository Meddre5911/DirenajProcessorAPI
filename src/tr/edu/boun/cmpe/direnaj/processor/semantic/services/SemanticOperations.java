package tr.edu.boun.cmpe.direnaj.processor.semantic.services;

import org.apache.commons.collections15.Bag;

/**
 * FIXME bu interface'in implementation'� Direnaj'a �zg� yaz�lacak
 */
public interface SemanticOperations {
	
	public String freebaseToDbpedia(String freebaseId);
	
	public Bag<String> findRedirects(String dbpediaResource);
	
	public boolean haveDisambiguation(String dbpediaResource);
	
}
