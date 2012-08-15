package br.gov.frameworkdemoiselle.sample.business;

import br.gov.frameworkdemoiselle.annotation.Shutdown;
import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.sample.domain.Bookmark;
import br.gov.frameworkdemoiselle.sample.persistence.BookmarkDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@BusinessController
public class BookmarkBC extends DelegateCrud<Bookmark, Long, BookmarkDAO> {

	private static final long serialVersionUID = 1L;

	@Startup(priority = 2)
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new Bookmark("Demoiselle Portal", "http://www.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Demoiselle SourceForge", "http://sf.net/projects/demoiselle"));
			insert(new Bookmark("Twitter", "http://twitter.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Blog", "http://blog.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Wiki", "http://wiki.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Bug Tracking", "http://tracker.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Forum", "http://forum.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("SVN", "http://svn.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Maven", "http://repository.frameworkdemoiselle.gov.br"));
			insert(new Bookmark("Downloads", "http://download.frameworkdemoiselle.gov.br"));
		}
	}

	@Startup(priority = 1)
	public void initServer() {
		System.out.println("********************** INICIANDO O SERVIDOR 1 ********************** ");
	}

	@Startup(priority = 3)
	public void executeGrant() {
		System.out.println("********************** HABILITANDO AS PERMISSÕES 1********************** ");
	}

	@Shutdown(priority = 1)
	public void removeGrant() {
		System.out.println("********************** DESABILITANDO AS PERMISSÕES 1 ********************** ");
	}

	@Shutdown(priority = 2)
	public void stopServer() {
		System.out.println("********************** FINALIZANDO O SERVIDOR 1 ********************** ");
	}

}
