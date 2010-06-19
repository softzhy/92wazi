package jay.box.crawl.util;

import java.io.IOException;
import java.io.StringReader;

import org.cyberneko.html.parsers.DOMParser;
import org.dom4j.io.DOMReader;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * HTML text to DOM 
 * @author Jay
 */
public class HtmlDOM {
	
	/**
	 * parse string text into w3c {@link Document}
	 * @param html HTML text
	 * @return {@link Document} the HTML DOM
	 */
	public final static Document nekohtml(String html){
		DOMParser parser1 = new DOMParser();
		try {
			parser1.parse(new InputSource(new StringReader(html)));
		} catch (SAXException e) {
			System.err.println("error parsing " + e);
		} catch (IOException e) {
			System.err.println("error parsing " + e);
		}
		return parser1.getDocument();
	}
	
	/**
	 * parse string text into dom4j {@link org.dom4j.Document}
	 * @param html HTML text
	 * @return {@link org.dom4j.Document} the HTML DOM
	 */
	public final static org.dom4j.Document dom4j(String html){
		//NekoHtml does better in parsing not well-formed HTML .
		Document d = nekohtml(html);
		return new DOMReader().read(d);
	}
}
