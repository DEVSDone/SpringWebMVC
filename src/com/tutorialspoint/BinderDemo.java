package com.tutorialspoint;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import java.io.File;

import javax.xml.bind.Binder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class BinderDemo {

	public static void main(String[] args) 
	{
		 try {
			 String filepath = "D:/JCI project/XMLToCsvConversion/Testing/Student.xml";
	         // we need a blank document to store final xml output			 
	         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = dbf.newDocumentBuilder();	         
	         Document document = docBuilder.parse(filepath);
	          
	         // create JAXBContext which will be used to create a Binder
	         JAXBContext jc = JAXBContext.newInstance(Student.class);

	         Binder<Node> binder = jc.createBinder();

	         // set output as formatted one
	         binder.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	         // get xml node from the document
	         Node xmlNode = document.getDocumentElement();
	         
	         // Returns the updated JAXB object
	         Student st = (Student)binder.updateJAXB(xmlNode);
	         
	         // set age and name
	         st.setAge(11);
	         st.setName("Amol & Mira");
	         st.setGender("M");
	         // update xml node with new data
	         xmlNode = binder.updateXML(st);
	         
	         // set node value to the document
	         document.setNodeValue(xmlNode.getNodeValue());

	         // finally print the edited object on stdout
	         TransformerFactory tf = TransformerFactory.newInstance();
	         Transformer t = tf.newTransformer();
	         t.setOutputProperty(OutputKeys.METHOD, "xml");
	         t.setOutputProperty(OutputKeys.INDENT, "yes");
	         t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	         t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	         t.transform(new DOMSource(document), new StreamResult(new File(filepath)));
	        // System.out.println();
	         t.transform(new DOMSource(document), new StreamResult(System.out));
	         
	      }catch(Exception ex) {
	         ex.printStackTrace();
	      }

	}

}
