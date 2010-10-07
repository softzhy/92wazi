package jay.box.taobao.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import jay.box.taobao.domain.Item;
import jay.box.taobao.service.impl.WebIteratorLocator;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

@ContextConfiguration(locations={"applicationContext.xml"})
public class WebCrawlerTest extends AbstractJUnit38SpringContextTests {

	@Resource(name="simpleWebCrawler")
	private WebCrawler simpleWebCrawler;
	
	@Resource(name="httpClientWebCrawler")
	private WebCrawler httpClientWebCrawler;
	
	public void testFoo() throws Exception {
		assertNotNull(simpleWebCrawler);
		assertNotNull(httpClientWebCrawler);
	}
	
	public void testCrawlPage() throws Exception {
		String resp = simpleWebCrawler.wget("http://www.taobao.com");
		System.out.println(resp);
		
		String html = simpleWebCrawler.wget("http://search.taobao.com/search?q=%CD%E0&commend=all&sort=sale-desc&style=list&isnew=2&source=search1&s=40#J_FilterTabBar");
		System.out.println(html);
	}
	
	@Resource
	private WebIteratorLocator locator;
	
	public void testWebIteratorLocator() throws Exception {
		String url = "http://search.taobao.com/search?q=%CD%E0&commend=all&sort=sale-desc&isnew=2&source=search1&style=list&s=0";
		WebIterator<Item> itemIterator = locator.createInstance(url, null);
		ArrayList<Item> items = new ArrayList<Item>();
		while(itemIterator.hasNext()){
			Item item = itemIterator.next();
			items.add(item);
			System.out.println(item);
		}
	}
}
