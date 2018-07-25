package org.anhu.XSD;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XsdElements {

	public static void main(String args[]) {
		try {
			// parse the document
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File("C:/Users/anneke.huijsmans/Documents/filefile.xsd"));
			NodeList list = doc.getElementsByTagName("xsd:element");
			// loop to print data
			for (int i = 0; i < list.getLength(); i++) {
				Element first = (Element) list.item(i);
				if (first.hasAttributes()) {
					String nm = first.getAttribute("name");
					System.out.println(nm);
					String nm1 = first.getAttribute("type");
					System.out.println(nm1);
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException ed) {
			ed.printStackTrace();
		}
	}
}
