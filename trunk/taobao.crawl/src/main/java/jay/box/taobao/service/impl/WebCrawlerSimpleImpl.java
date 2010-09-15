package jay.box.taobao.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jay.box.taobao.service.WebCrawler;

/**
 * simple web crawler using JDK {@link URLConnection}
 * @author Jay
 */
@Service("simpleWebCrawler")
public class WebCrawlerSimpleImpl implements WebCrawler {
	
	private final static Logger log = LoggerFactory.getLogger(WebCrawlerSimpleImpl.class);

	public String wget(String url) {
		try {
			URL u = new URL(url);
			InputStream stream = u.openStream();
			String answer = IOUtils.toString(stream);
			return answer;
		} catch (MalformedURLException e) {
			log.error("Malformed crawl URL {}", url);
		} catch (IOException e) {
			log.error("cannot open url {} for stream", url);
		}
		throw new RuntimeException("Fail to request " + url);
	}

	public InputStream wgetStream(String url) {
		try {
			URL u = new URL(url);
			InputStream stream = u.openStream();
			return stream;
		} catch (MalformedURLException e) {
			log.error("Malformed crawl URL {}", url);
		} catch (IOException e) {
			log.error("cannot open url {} for stream", url);
		}
		throw new RuntimeException("Fail to request " + url);
	}

}
