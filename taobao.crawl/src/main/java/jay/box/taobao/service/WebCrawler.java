package jay.box.taobao.service;

import java.io.InputStream;

public interface WebCrawler {
	
	/**
	 * request for content of the url
	 * @param url target address to request
	 * @param responseEncoding in which encoding to read out he response content
	 * @return response content
	 */
	String wget(String url);
	
	InputStream wgetStream(String url);
}
