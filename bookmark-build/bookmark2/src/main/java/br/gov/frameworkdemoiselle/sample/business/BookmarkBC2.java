package br.gov.frameworkdemoiselle.sample.business;

import static br.gov.frameworkdemoiselle.annotation.Startup.MAX_PRIORITY;
import static br.gov.frameworkdemoiselle.annotation.Startup.MIN_PRIORITY;
import br.gov.frameworkdemoiselle.annotation.Shutdown;
import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import br.gov.frameworkdemoiselle.sample.domain.Bookmark2;
import br.gov.frameworkdemoiselle.sample.persistence.BookmarkDAO2;

@BusinessController
public class BookmarkBC2 extends DelegateCrud<Bookmark2, Long, BookmarkDAO2> {
	
	private static final long serialVersionUID = 1L;
	
	@Startup(priority = 2)
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new Bookmark2("Demoiselle Portal", "http://www.frameworkdemoiselle.gov.br"));
			insert(new Bookmark2("Demoiselle SourceForge", "http://sf.net/projects/demoiselle"));
			insert(new Bookmark2("Twitter", "http://twitter.frameworkdemoiselle.gov.br"));
			insert(new Bookmark2("Blog", "http://blog.frameworkdemoiselle.gov.br"));
			insert(new Bookmark2("Wiki", "http://wiki.frameworkdemoiselle.gov.br"));
			insert(new Bookmark2("Bug Tracking", "http://tracker.frameworkdemoiselle.gov.br"));
			insert(new Bookmark2("Forum", "http://forum.frameworkdemoiselle.gov.br"));
			insert(new Bookmark2("SVN", "http://svn.frameworkdemoiselle.gov.br"));
			insert(new Bookmark2("Maven", "http://repository.frameworkdemoiselle.gov.br"));
			insert(new Bookmark2("Downloads", "http://download.frameworkdemoiselle.gov.br"));
		}
	}
	
	@Startup(priority = 1)
	public void initServer() {
		System.out.println("********************** INICIANDO O SERVIDOR 2 ********************** ");
	}
	
	@Startup(priority = 2)
	public void executeGrant() {
		System.out.println("********************** HABILITANDO AS PERMISSÕES 2 ********************** ");
	}
	
	@Shutdown(priority = 1)
	public void removeGrant() {
		System.out.println("********************** DESABILITANDO AS PERMISSÕES 2 ********************** ");
	}
	
	@Shutdown(priority = 2)
	public void stopServer() {
		System.out.println("********************** FINALIZANDO O SERVIDOR 2 ********************** ");
	}		
	
}
