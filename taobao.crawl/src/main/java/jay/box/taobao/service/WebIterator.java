package jay.box.taobao.service;

import java.util.Iterator;

public interface WebIterator<T> extends Iterator<T> {
	
	void setStartURL(String startURL);
}
