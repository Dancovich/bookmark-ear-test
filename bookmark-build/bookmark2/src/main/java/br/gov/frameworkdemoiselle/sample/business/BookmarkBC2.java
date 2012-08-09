package br.gov.frameworkdemoiselle.sample.business;

import br.gov.frameworkdemoiselle.annotation.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import br.gov.frameworkdemoiselle.sample.domain.Bookmark2;
import br.gov.frameworkdemoiselle.sample.persistence.BookmarkDAO2;

@BusinessController
public class BookmarkBC2 extends DelegateCrud<Bookmark2, Long, BookmarkDAO2> {
	
	private static final long serialVersionUID = 1L;
	
	@Startup
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
	
}
