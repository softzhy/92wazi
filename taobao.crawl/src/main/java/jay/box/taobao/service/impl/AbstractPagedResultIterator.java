package jay.box.taobao.service.impl;

import java.util.Iterator;

import jay.box.taobao.service.WebIterator;

public abstract class AbstractPagedResultIterator<T> implements WebIterator<T> {
	
	private Iterator<T> currentPageIterator;
	
	public void remove(){
		throw new UnsupportedOperationException();
	}
	
	public boolean hasNext(){
		if(currentPageIterator == null)//iteration is not start yet
			requestNextPage();
		
		boolean b1 = currentPageIterator.hasNext();
		
		if(b1 == false){
			if(hasNextPage == false){
				return false;//reached last page's last item
			}else{
				requestNextPage();//reached this page's last item
			}
		}
		return true;
	}
	
	public T next(){
		return currentPageIterator.next();
	}
	
	/**
	 * what should be done in this method :
	 * <ul>
	 * <li>make HTTP request, get/analysis the HTML content
	 * <li>make out current page's items list, and {@link #setCurrentPageIterator(Iterator)}
	 * <li>detect if there were more page available and {@link #setHasNextPage(boolean)} 
	 * </ul>
	 */
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