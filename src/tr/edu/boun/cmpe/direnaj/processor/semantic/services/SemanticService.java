package tr.edu.boun.cmpe.direnaj.processor.semantic.services;

import tr.edu.boun.cmpe.direnaj.processor.semantic.repositories.clients.DbPediaClient;
import tr.edu.boun.cmpe.direnaj.processor.semantic.repositories.clients.FreeBaseClient;
import tr.edu.boun.cmpe.direnaj.processor.semantic.repositories.resources.DbpediaResource;
import tr.edu.boun.cmpe.direnaj.processor.semantic.repositories.resources.FreeBaseTopic;

/**
 * FIXME Buradaki SemanticOperations sýnýfý Burak'ýn kodundaki SemanticDao
 * sýnýfýndan alýnma. Bu interface için Direnaj'a ozgu bir implementation
 * yapilacak
 */
public class SemanticService {

	private SemanticOperations dao;

	public SemanticService(SemanticOperations dao) {
		this.dao = dao;
	}

	public DbpediaResource toDbpediaResource(FreeBaseTopic freeBaseTopic) {

		DbpediaResource dbpediaResource = null;

		String resource = dao.freebaseToDbpedia(FreeBaseClient.RDF_URL_TEMPLATE
				.replace("{x}", freeBaseTopic.getMid()[0]));

		System.out.println("corresponding dbpedia resource -> " + resource);

		if (resource != null) {
			dbpediaResource = new DbpediaResource(resource);
			enhanceDbpediaResource(dbpediaResource);
		}

		return dbpediaResource;
	}

	private void enhanceDbpediaResource(DbpediaResource dbpediaResource) {

		String resource = dbpediaResource.getResource();

		dbpediaResource.setRedirects(dao.findRedirects(resource));
		dbpediaResource.setCategories(DbPediaClient.categories(resource));

		dbpediaResource.setHasDisambiguation(dao.haveDisambiguation(resource));

	}

	/*
	 * public Bag<String> _findRedirects(String name) { return
	 * dao.findRedirects(
	 * SemanticDaoImpl.DBPEDIA_RESOURCE_PRE+WordUtils.capitalize
	 * (name).replace(' ', '_')+SemanticDaoImpl.DBPEDIA_RESOURCE_POST); }
	 */
}
