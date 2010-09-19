package jay.box.taobao.service;

import javax.annotation.Resource;

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
	}
}
