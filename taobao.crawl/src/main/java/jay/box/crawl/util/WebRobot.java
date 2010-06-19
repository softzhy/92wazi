package jay.box.crawl.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;

/**
 * Encapsulate the HttpClient API
 * @author Jay
 */
public abstract class WebRobot {
	
	/**
	 * share between its children
	 */
	protected final static HttpClient CLIENT = new HttpClient();
	static {
		CLIENT.getParams().setParameter(HttpMethodParams.USER_AGENT, "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.0.13) Gecko/2009073022 Firefox/3.0.13");
		CLIENT.getParams().setParameter(HttpMethodParams.COOKIE_POLICY, CookiePolicy.RFC_2109);
	}
	
	/**
	 * default response content encoding : GBK
	 */
	public static String wget(String url)throws Exception{
		return wget(url, "GBK");
	}
	
	/**
	 * crawl web page
	 * @param url web page URL
	 * @param responseEncoding char encoding of the response HTML content
	 * @return string of HTML page
	 * @throws Exception if IO or HTTP exception occurs.
	 */
	public static String wget(String url, String responseEncoding)throws Exception{
		GetMethod gm = new GetMethod(url);
		CLIENT.executeMethod(gm);
		String page = IOUtils.toString(gm.getResponseBodyAsStream(), responseEncoding);
		return page;
	}
	
	/**
	 * @see #wget(String)
	 * @param url full qualified HTTP URL
	 * @return {@link String} representation of HTTP response HTML
	 */
	public static String request(String url){
		String answer = null;
		try {
			answer = wget(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answer;
	}
}
