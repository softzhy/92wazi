package jay.box.taobao.service;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

@ContextConfiguration(locations={"applicationContext.xml"})
public class WebCrawlerTest extends AbstractJUnit38SpringContextTests {

	@Autowired
	private WebCrawler webCrawler;
	
	public void testFoo() throws Exception {
		assertNotNull(webCrawler);
	}
	
	public void testCrawlPage() throws Exception {
//		String resp = webCrawler.wget("www.taobao.com");
//		System.out.println(resp);
		
		URL url = new URL("http://www.taobao.com");
		InputStream stream = url.openStream();
		String resp2 = IOUtils.toString(stream);
		System.out.println(resp2);
	}
}
