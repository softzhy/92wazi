package jay.box.taobao.crawl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.Node;

import jay.box.crawl.util.HtmlDOM;
import jay.box.crawl.util.WebRobot;
import jay.box.taobao.crawl.hibernate.TaobaoItem;

/**
 * iterate taobao items on website taobao.com
 * @author Jay
 *
 */
public class TaobaoItemIterator implements Iterator<TaobaoItem> {
	
	private String nextURL = null;
	
	public TaobaoItemIterator(String startURL){
		this.nextURL = startURL;
	}
	
	Iterator<TaobaoItem> pageItemsIterator;

	public boolean hasNext() {
		
		if(pageItemsIterator == null || pageItemsIterator.hasNext() == false){//page items iterator not initialized or reached its end.
			if(nextURL == null || "".equals(nextURL)){//no 'next page' is available.
				return false;
			}
			try {
				String html = WebRobot.wget(nextURL, "GBK");
				Document doc = HtmlDOM.dom4j(html);
				List<TaobaoItem> pageItems = readItems(doc);
				nextURL = readNexPageUrl(doc);//save ref to next page
				System.out.println("updated next page url " + nextURL);
				pageItemsIterator = pageItems.iterator();
				return pageItemsIterator.hasNext();
			} catch (Exception e) {
				throw new RuntimeException("Reading URL && Parsing HTML page : " + e);
			}
		}else{
			return pageItemsIterator.hasNext();
		}
	}

	public TaobaoItem next() {
		if(hasNext())
			return pageItemsIterator.next();
		else
			throw new RuntimeException("Unexpected behavior, have you called hasNext() before calling next() ?");
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	@SuppressWarnings("unchecked")
	private List<TaobaoItem> readItems(Document doc){
		ArrayList<TaobaoItem> answer = new ArrayList<TaobaoItem>();
		List<Node> nodes = doc.selectNodes("//DIV[@id='list:content']/UL/LI[@class='list-item']");
		for(Node n : nodes){
			TaobaoItem ti = new TaobaoItem();
			ti.setItemURL(n.valueOf("H3/A/attribute::href"));
			ti.setItemTitle(n.valueOf("H3/A/attribute::title"));
			ti.setOwnerNickname(n.valueOf("P/A"));
			ti.setPrice(Double.valueOf(n.valueOf("UL/LI[4]/EM")));
			ti.setShipping(Double.valueOf(getFirstNumber(n.valueOf("UL/LI[4]/SPAN"))));
			ti.setPlace(n.valueOf("UL/LI[3]"));
			ti.setSale(Integer.valueOf(getFirstNumber(n.valueOf("UL/LI[2]"))));
			answer.add(ti);
		}
		return answer;
	}
	
	private String readNexPageUrl(Document doc){
		String href = doc.valueOf("//A[@class='page-next' and position()=1]/attribute::href");
		String nextPageUrl = "http://search.taobao.com" + href;
		return nextPageUrl;
	}
	
	private final static Pattern p = Pattern.compile("\\d+(\\.\\d+)?");
	//get first number serial in string
	private String getFirstNumber(String txt){
		Matcher m = p.matcher(txt);
		if(m.find())
			return m.group();
		return null;
	}
}
