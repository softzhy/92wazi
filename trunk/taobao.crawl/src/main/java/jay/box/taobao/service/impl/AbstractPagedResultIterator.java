package jay.box.taobao.service.impl;

import java.util.Iterator;

import jay.box.taobao.service.WebIterator;

public abstract class AbstractPagedResultIterator<T> implements WebIterator<T> {
	
	private Iterator<T> currentPageIterator;
	
	public void remove(){
		throw new UnsupportedOperationException();
	}
	
	public boolean hasNext(){
		boolean b1 = currentPageIterator.hasNext();
		if(b1 == false){
			if(hasNextPage == false){
				return false;
			}else{
				requestNextPage();
			}
		}
		return true;
	}
	
	public T next(){
		return currentPageIterator.next();
	}
	
	protected abstract void requestNextPage();
	
	private String startURL;
	
	public void setStartURL(String startURL) {
		this.startURL = startURL;
	}
	
	protected String getStartURL(){
		return startURL;
	}
	
	/**
	 * is there 'next page' available ?
	 */
	private boolean hasNextPage;
	
	protected void setHasNextPage(boolean has){
		hasNextPage = has;
	}

	protected void setCurrentPageIterator(Iterator<T> currentPageIterator) {
		this.currentPageIterator = currentPageIterator;
	}
}