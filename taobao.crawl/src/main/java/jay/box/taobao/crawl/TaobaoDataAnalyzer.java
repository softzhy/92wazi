/**
 * 
 */
package jay.box.taobao.crawl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.Node;

import jay.box.crawl.util.HtmlDOM;
import jay.box.crawl.util.WebRobot;
import jay.box.taobao.crawl.hibernate.TaobaoItem;

/**
 * @author Jay
 *
 */
@SuppressWarnings("unchecked")
public abstract class TaobaoDataAnalyzer extends WebRobot {
	
	//http://search.taobao.com/search?q=%CD%E0&commend=all&sort=sale-desc&isnew=2&source=search1&style=list&s=0
	public void pagesNav(String startURL) throws Exception{
		String url = startURL;

		Integer pagesCounter = 0;
		while(url != null){
			String page = wget(startURL, "GBK");
			url = analyzePage(page);
			pagesCounter++;
			if(maxPages != -1){
				if(pagesCounter >= maxPages)break;
			}
		}
	}
	
	/**
	 * 
	 * @param html html text
	 * @return next page url
	 * @throws Exception 
	 */
	private String analyzePage(String html) throws Exception{
		Document doc = HtmlDOM.dom4j(html);
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
			finish(ti);
		}
			
		//get next page url.
		String nextPageUrl = "http://search.taobao.com" + doc.valueOf("//A[@class='page-next' and position()=1]/attribute::href");
		return nextPageUrl;
	}
	
	protected abstract void finish(TaobaoItem ti);
	
	private final static Pattern p = Pattern.compile("\\d+(\\.\\d+)?");
	//get first number serial in string
	private String getFirstNumber(String txt){
		Matcher m = p.matcher(txt);
		if(m.find())
			return m.group();
		return null;
	}
	
	public final static String START_PAGE = "http://search.taobao.com/search?q=%CD%E0&commend=all&sort=sale-desc&isnew=2&source=search1&style=list&s=0";
	
	public static void main(String[] args) throws Exception{
		TaobaoDataAnalyzer tda = new TaobaoDataAnalyzerImpl();
		tda.pagesNav(START_PAGE);
	}
	
	private Integer maxPages = -1;//no limit

	public Integer getMaxPages() {
		return maxPages;
	}

	public void setMaxPages(Integer maxPages) {
		this.maxPages = maxPages;
	}
}
