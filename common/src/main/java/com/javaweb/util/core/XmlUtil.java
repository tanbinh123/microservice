package com.javaweb.util.core;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtil {
	
    public static DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        documentBuilderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        documentBuilderFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        documentBuilderFactory.setXIncludeAware(false);
        documentBuilderFactory.setExpandEntityReferences(false);

        return documentBuilderFactory.newDocumentBuilder();
    }

    public static Document newDocument() throws ParserConfigurationException {
        return newDocumentBuilder().newDocument();
    }
	
    //XML格式字符串转换为Map
    public static Map<String, String> xmlToMap(String strXML) throws Exception {
        try {
            Map<String, String> data = new HashMap<String, String>();
            DocumentBuilder documentBuilder = newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            try {
                stream.close();
            } catch (Exception e) {
                
            }
            return data;
        } catch (Exception e) {
            throw e;
        }
    }

    //将Map转换为XML格式的字符串
    public static String mapToXml(Map<String, String> data) throws Exception {
    	org.w3c.dom.Document document = newDocument();
        org.w3c.dom.Element root = document.createElement("xml");
        document.appendChild(root);
        for (String key: data.keySet()) {
            String value = data.get(key);
            if (value == null) {
                value = "";
            }
            value = value.trim();
            org.w3c.dom.Element filed = document.createElement(key);
            filed.appendChild(document.createTextNode(value));
            root.appendChild(filed);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source,result);
        String output = writer.getBuffer().toString();//.replaceAll("\n|\r", "");
        try {
            writer.close();
        }
        catch (Exception e) {
        }
        return output;
    }
    
    /**
    org.dom4j.Element rootElement = document.getRootElement();
    org.dom4j.Element processElement = rootElement.element("process");
    org.dom4j.Attribute attribute = processElement.attribute("attributeName");
    String value = attribute.getStringValue();
	*/
	public static org.dom4j.Document getDocument(File file) throws Exception {
		SAXReader saxReader = new SAXReader();
		org.dom4j.Document document = null;
		try {
			document = saxReader.read(file);
			if(!"UTF-8".equals(document.getXMLEncoding().trim().toUpperCase())){
				throw new Exception("文件编码需要UTF-8");
			}
		} catch (Exception e) {
			throw new Exception("文档读取失败");
		}
		return document;
	}
	
    /**
    org.dom4j.Element rootElement = document.getRootElement();
    org.dom4j.Element processElement = rootElement.element("process");
    org.dom4j.Attribute attribute = processElement.attribute("attributeName");
    String value = attribute.getStringValue();
	*/
	public static org.dom4j.Document getDocument(InputStream inputStream) throws Exception {
		SAXReader saxReader = new SAXReader();
		org.dom4j.Document document = null;
		try {
			document = saxReader.read(inputStream);
			if(!"UTF-8".equals(document.getXMLEncoding().trim().toUpperCase())){
				throw new Exception("文件编码需要UTF-8");
			}
		} catch (Exception e) {
			throw new Exception("文档读取失败");
		}
		return document;
	}
	
    /**
    org.dom4j.Element rootElement = document.getRootElement();
    org.dom4j.Element processElement = rootElement.element("process");
    org.dom4j.Attribute attribute = processElement.attribute("attributeName");
    String value = attribute.getStringValue();
	*/
	public static org.dom4j.Document getDocument(String xmlInfo) throws Exception {
		SAXReader saxReader = new SAXReader();
		org.dom4j.Document document = null;
		try {
			InputStream inputStream = IOUtils.toInputStream(xmlInfo,"UTF-8");
			document = saxReader.read(inputStream);
			if(!"UTF-8".equals(document.getXMLEncoding().trim().toUpperCase())){
				throw new Exception("文件编码需要UTF-8");
			}
		} catch (Exception e) {
			throw new Exception("文档读取失败");
		}
		return document;
	}

}
