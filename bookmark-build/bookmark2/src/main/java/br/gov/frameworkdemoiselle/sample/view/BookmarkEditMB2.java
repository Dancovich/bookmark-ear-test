package br.gov.frameworkdemoiselle.sample.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import br.gov.frameworkdemoiselle.sample.business.BookmarkBC2;
import br.gov.frameworkdemoiselle.sample.domain.Bookmark2;

@ViewController
@PreviousView("/bookmark_list.xhtml")
public class BookmarkEditMB2 extends AbstractEditPageBean<Bookmark2, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BookmarkBC2 bookmarkBC;

	@Override
	@Transactional
	public String delete() {
		this.bookmarkBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.bookmarkBC.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.bookmarkBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {
		setBean(this.bookmarkBC.load(getId()));
	}

}
