package xml;

import static java.lang.System.out;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import org.xml.sax.XMLReader;

public class SolutionXMLStreamReader {

	public static void main(String[] args) {
		String file = "c:\\text\\bookxml.txt";
		FileInputStream fileInputStream = null;
		XMLStreamReader xmlStreamReader = null;
		try {
			fileInputStream = new FileInputStream(file);
			XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
			xmlStreamReader = xmlInputFactory.createXMLStreamReader(fileInputStream);
			
			out.println("Event Type : " + getEventTypeString(xmlStreamReader.getEventType()));
			
			
			while(xmlStreamReader.hasNext()){
				xmlStreamReader.next();
			    if(xmlStreamReader.getEventType() == XMLStreamReader.START_ELEMENT){
			    	String localName = xmlStreamReader.getLocalName();
			        out.println(localName);
			        if (localName.equals("Title")) {
						out.print(xmlStreamReader.getElementText());
					}
			    }
			    
			    if (xmlStreamReader.getEventType() == XMLStreamReader.START_DOCUMENT) {
			    	 out.println("Document : " + xmlStreamReader.getLocalName());
				}
			}
			
			
			
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} finally {
			if (xmlStreamReader != null) {
				try {
					xmlStreamReader.close();
				} catch (XMLStreamException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public final static String getEventTypeString(int eventType) {
	    switch (eventType) {
	        case XMLEvent.START_ELEMENT:
	            return "START_ELEMENT";

	        case XMLEvent.END_ELEMENT:
	            return "END_ELEMENT";

	        case XMLEvent.PROCESSING_INSTRUCTION:
	            return "PROCESSING_INSTRUCTION";

	        case XMLEvent.CHARACTERS:
	            return "CHARACTERS";

	        case XMLEvent.COMMENT:
	            return "COMMENT";

	        case XMLEvent.START_DOCUMENT:
	            return "START_DOCUMENT";

	        case XMLEvent.END_DOCUMENT:
	            return "END_DOCUMENT";

	        case XMLEvent.ENTITY_REFERENCE:
	            return "ENTITY_REFERENCE";

	        case XMLEvent.ATTRIBUTE:
	            return "ATTRIBUTE";

	        case XMLEvent.DTD:
	            return "DTD";

	        case XMLEvent.CDATA:
	            return "CDATA";

	        case XMLEvent.SPACE:
	            return "SPACE";
	    }
	    return "UNKNOWN_EVENT_TYPE," + eventType;
	}

}
