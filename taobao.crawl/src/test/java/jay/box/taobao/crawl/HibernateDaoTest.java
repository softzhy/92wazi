package jay.box.taobao.crawl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jay.box.taobao.crawl.hibernate.TaobaoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

@ContextConfiguration(locations={"applicationContext.xml"})
public class HibernateDaoTest extends AbstractJUnit38SpringContextTests {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void testFirstEntityManager() throws Exception {
		TaobaoItem ti = new TaobaoItem();
		ti.setItemURL("kjslkdjflsjdlfxxxxxxxj");
		ti = em.merge(ti);
	}
	
	@Autowired
	private TaobaoDataAnalyzer tda;
	
	public void testTaobaoDataAnalyzer() throws Exception {
		tda.setMaxPages(1);
		tda.pagesNav("http://search.taobao.com/search?q=%CD%E0&commend=all&sort=sale-desc&isnew=2&source=search1&style=list&s=0");
		System.out.println("over");
	}
}
