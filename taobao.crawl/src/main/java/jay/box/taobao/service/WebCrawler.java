package jay.box.taobao.service;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebCrawler {

	@Autowired
	private HttpClient httpClient;
	
	/**
	 * request for content of the url
	 * @param url target address to request
	 * @param responseEncoding in which encoding to read out he response content
	 * @see org.apache.commons.httpclient.HttpMethodBase#getResponseBodyAsString()
	 * @return response content
	 */
	public String wget(String url){
		GetMethod gm = new GetMethod(url);
		try {
			httpClient.executeMethod(gm);
			String response = gm.getResponseBodyAsString();
			return response;
		} catch (HttpException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
