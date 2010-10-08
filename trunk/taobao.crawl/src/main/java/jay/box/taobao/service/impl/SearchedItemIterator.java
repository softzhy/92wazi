package jay.box.taobao.service.impl;

import java.util.ArrayList;
import java.util.List;

import jay.box.crawl.util.HtmlDOM;
import jay.box.taobao.domain.Item;
import jay.box.taobao.service.WebCrawler;

import org.dom4j.Document;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * iterate over search list
 * @author Jay liulijie@ruijiansoft.com
 */
public class SearchedItemIterator extends AbstractPagedResultIterator<Item> {
	
	private final static Logger log = LoggerFactory.getLogger(SearchedItemIterator.class);
	
	private String nextURL;
	
	@SuppressWarnings("unchecked")
	protected void requestNextPage() {
		
		if(nextURL == null){
			nextURL = getStartURL();
			log.debug("first url");
		}
		
		log.debug("current url is {}", nextURL);
		
		String html = webCrawler.wget(nextURL);
		Document doc = HtmlDOM.dom4j(html);
		
		//read items in page 
		ArrayList<Item> answer = new ArrayList<Item>();
		List<Node> nodes = doc.selectNodes("//DIV[@id='list:content']/UL/LI[@class='list-item']");
		for(Node n : nodes){
			Item item = new Item();
			item.setItemUrl(n.valueOf("H3/A/attribute::href"));
			item.setTitle(n.valueOf("H3/A/attribute::title"));
			item.setPrice(Double.valueOf(n.valueOf("UL/LI[4]/EM")));
			answer.add(item);
		}
		
		log.debug("{} items found", answer.size());
		
		setCurrentPageIterator(answer.iterator());
		
		//next page url 
		String href = doc.valueOf("//A[@class='page-next']/attribute::href");
		if(href == null || href.isEmpty()){
			log.debug("no more page is available ");
			setHasNextPage(false);
		}else{
			nextURL = "http://search.taobao.com" + href;
			setHasNextPage(true);
		}
	}

	private WebCrawler webCrawler;
	
	public void setWebCrawler(WebCrawler webCrawler){
		this.webCrawler = webCrawler;
	}
}