package jay.box.taobao.service.impl;

import javax.annotation.Resource;

import jay.box.taobao.service.WebCrawler;
import jay.box.taobao.service.WebIterator;

import org.springframework.stereotype.Service;

/**
 * factory for creating web iterator
 * @author Jay liulijie@ruijiansoft.com
 */
@Service
public class WebIteratorLocator {
	
	@SuppressWarnings("unchecked")
	public <T> WebIterator<T> createInstance(String startURL, Class<T> clazz){
		SearchedItemIterator sii = new SearchedItemIterator();
		sii.setStartURL(startURL);
		sii.setWebCrawler(webCrawler);
		return (WebIterator<T>) sii;
	}

	private WebCrawler webCrawler;

	@Resource(name="simpleWebCrawler")
	public void setWebCrawler(WebCrawler webCrawler) {
		this.webCrawler = webCrawler;
	}
}