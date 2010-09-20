package jay.box.taobao.service.impl;

import jay.box.taobao.service.WebCrawler;
import jay.box.taobao.service.WebIterator;

import org.springframework.stereotype.Service;

/**
 * factory for creating web iterator
 * @author Jay liulijie@ruijiansoft.com
 */
@Service
public class WebIteratorLocator {
	
	public <T> WebIterator<T> createInstance(String startURL, Class<T> clazz){
		SearchedItemIterator sii = new SearchedItemIterator();
		return (WebIterator<T>) sii;
	}

	
	private WebCrawler webCrawler;
}
