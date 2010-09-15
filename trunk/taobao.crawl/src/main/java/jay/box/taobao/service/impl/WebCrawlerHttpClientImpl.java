package jay.box.taobao.service.impl;

import java.io.IOException;
import java.io.InputStream;

import jay.box.taobao.service.WebCrawler;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Using HttpClient as the executor 
 * @author Jay
 */
@Service("httpClientWebCrawler")
public class WebCrawlerHttpClientImpl implements WebCrawler {
	
	private final static Logger log = LoggerFactory.getLogger(WebCrawlerHttpClientImpl.class);

	private HttpClient httpClient;
	
	public String wget(String url){
		InputStream stream = wgetStream(url);
		log.debug("get stream object, convert to string content with encoding {}", "gb2312");
		try {
			IOUtils.toString(stream, "GB2312");
		} catch (IOException e) {
			log.error("IO failed while converting requested stream {} to string using encoding {}", stream, "GB2312");
		}
		throw new RuntimeException("fail to crawl url");
	}
	
	public InputStream wgetStream(String url) {
		log.debug("starting to crawl url {} ", url);
		GetMethod gm = new GetMethod(url);
		try {
			httpClient.executeMethod(gm);
			return gm.getResponseBodyAsStream();
		} catch (HttpException e) {
			log.error("httpclient {} error with url {}", httpClient, url);
		} catch (IOException e) {
			log.error("fail to read url {} with error {}", url, e);
		}
		throw new RuntimeException("fail to crawl url");
	}
	
	@Autowired
	public void setHttpClient(HttpClient hc){
		this.httpClient = hc;
	}
}
