package jay.box.taobao.crawl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

public class TaobaoItemIteratorTest extends TestCase {
	
	public void testNullStartURL() throws Exception {
		String startURL = null;
		TaobaoItemIterator ite = new TaobaoItemIterator(startURL);
		assertFalse(ite.hasNext());
		
		startURL = "";
		ite = new TaobaoItemIterator(startURL);
		assertFalse(ite.hasNext());
	}
	
	private final static String START_URL = "http://search.taobao.com/search?q=%CD%E0&commend=all&sort=sale-desc&isnew=2&source=search1&style=list&s=0";
	
	public void testNormalStartURL() throws Exception {
		String startURL = START_URL;
		TaobaoItemIterator ite = new TaobaoItemIterator(startURL);
		assertTrue(ite.hasNext());
		assertNotNull(ite.next());
	}
	
	public void testNormalStartURLNextPage() throws Exception {
		String startURL = START_URL;
		TaobaoItemIterator ite = new TaobaoItemIterator(startURL);
		while(ite.hasNext()){
			assertNotNull(ite.next());
		}
	}
	
	public void testIteratorOfList() throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("Jay");
		assertNotNull(list);
		assertEquals(1, list.size());
		
		Iterator<String> ite = list.iterator();
		assertNotNull(ite);
		assertTrue(ite.hasNext());
		assertTrue(ite.hasNext());
		assertTrue(ite.hasNext());
		assertEquals("Jay", ite.next());
		assertFalse(ite.hasNext());
	}
}
