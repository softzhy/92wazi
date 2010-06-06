package jay.box.taobao.crawl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jay.box.taobao.crawl.hibernate.TaobaoItem;

@Service("tda")
public class TaobaoDataAnalyzerImpl extends TaobaoDataAnalyzer {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	protected void finish(TaobaoItem ti) {
		TaobaoItem tt = em.find(TaobaoItem.class, ti.getItemURL());
		if(tt != null){
			System.out.println("this item already exists " + tt.getItemURL());
		}else{
			em.persist(ti);
		}
	}
}
