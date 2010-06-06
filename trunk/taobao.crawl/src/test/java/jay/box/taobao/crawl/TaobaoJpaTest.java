package jay.box.taobao.crawl;

import javax.persistence.EntityManager;

import jay.box.taobao.crawl.hibernate.TaobaoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.jpa.AbstractJpaTests;

public class TaobaoJpaTest extends AbstractJpaTests {
	
	protected String[] getConfigLocations() {
		return new String[]{"classpath:applicationContext.xml"};
	}
	
	@Autowired
	private TaobaoDataAnalyzer tda;
	
	public void testA() throws Exception {
		tda.setMaxPages(9);
		tda.pagesNav(TaobaoDataAnalyzer.START_PAGE);
		setComplete();
		System.out.println("b");
	}
	
	public void testEM() throws Exception {
		EntityManager em = sharedEntityManager;
		TaobaoItem ti = new TaobaoItem();
		ti.setItemURL("not is " + System.currentTimeMillis());
		ti.setBaozhang(11);
		em.persist(ti);
		setComplete();
	}
}
