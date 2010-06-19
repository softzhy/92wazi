package jay.box.taobao.crawl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jay.box.crawl.util.HtmlDOM;
import jay.box.crawl.util.WebRobot;

import org.dom4j.Document;
import org.dom4j.Node;

import junit.framework.TestCase;

@SuppressWarnings("unchecked")
public class DomTest extends TestCase {
	
	public void testXPath() throws Exception {
		String html = WebRobot.request("http://search.taobao.com/search?q=%CD%E0&commend=all&sort=sale-desc&isnew=2&source=search1&style=list&s=0");
		Document d = HtmlDOM.dom4j(html);
		List<Node> nodes = d.selectNodes("//DIV[@id='list:content']/UL/LI[@class='list-item']");
		assertEquals(40, nodes.size());
		
		Node n = d.selectSingleNode("//DIV[@id='list:content']/UL/LI[@class='list-item']");
		assertNotNull(n);
		
		List<Node> nodes2 = n.selectNodes("*");//all children of LI
		assertEquals(4, nodes2.size());
		
		n = d.selectSingleNode("//DIV[@id='list:content']/UL/LI[@class='list-item' and position()=26]");
		
		String title = n.valueOf("H3/A/attribute::title");
		System.out.println(title);
		
		String url = n.valueOf("H3/A/attribute::href");
		System.out.println(url);
		
		String price = n.valueOf("UL/LI[4]/EM");
		System.out.println(price);
		
		String ship = n.valueOf("UL/LI[4]/SPAN");
		System.out.println(ship);
		
		String place = n.valueOf("UL/LI[3]");
		System.out.println(place);
		
		String sale = n.valueOf("UL/LI[2]");
		System.out.println(sale);
		
		String baozhang = n.valueOf("UL/LI[1]/A");
		System.out.println("baozhang:" + baozhang);
	}
	
	public void testPattern() throws Exception {
		Pattern p = Pattern.compile("\\d+(\\.\\d+)?");
		
		Matcher m = p.matcher("12.0");
		assertTrue(m.find());
		assertEquals("12.0", m.group());
		
		m = p.matcher("12.");
		assertTrue(m.find());
		assertEquals("12", m.group());
		
		m = p.matcher("abc12.");
		assertTrue(m.find());
		assertEquals("12", m.group());
	}
}
