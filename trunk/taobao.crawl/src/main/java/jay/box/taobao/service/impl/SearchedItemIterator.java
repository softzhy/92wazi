package jay.box.taobao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

import jay.box.crawl.util.HtmlDOM;
import jay.box.taobao.domain.Item;
import jay.box.taobao.service.WebCrawler;

/**
 * iterate over search list
 * @author Jay liulijie@ruijiansoft.com
 */
public class SearchedItemIterator extends AbstractPagedResultIterator<Item> {
	
	private String nextURL;
	
	@SuppressWarnings("unchecked")
	protected void requestNextPage() {
		if(nextURL == null)
			nextURL = getStartURL();
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
		setCurrentPageIterator(answer.iterator());
		//next page url 
		String href = doc.valueOf("//A[@class='page-next' and position()=1]/attribute::href");
		if(href == null || href.isEmpty()){
			setHasNextPage(false);
		}else{
			nextURL = "http://search.taobao.com" + href;
		}
	}

	private WebCrawler webCrawler;
	
	public void setWebCrawler(WebCrawler webCrawler){
		this.webCrawler = webCrawler;
	}
}