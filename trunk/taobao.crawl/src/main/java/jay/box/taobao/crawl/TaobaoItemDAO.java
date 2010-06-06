package jay.box.taobao.crawl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jay.box.taobao.crawl.hibernate.TaobaoItem;

import org.springframework.stereotype.Service;

/**
 * 
 * @author Jay
 */
@Service("taobaoItemDao")
public class TaobaoItemDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Boolean hasTaobaoItem(String id){
		TaobaoItem ti = em.find(TaobaoItem.class, id);
		if(ti != null)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}
	
	public void saveTaobaoItem(TaobaoItem ti){
		
	}
}
