package xml;

import static java.lang.System.*;

import java.io.Writer;

import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class SolutionEventWriter {

	public static void main(String[] args) {
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEventWriter xmlEventWriter = null;
		try {
			xmlEventWriter = xmlOutputFactory.createXMLEventWriter(out);
			XMLEvent event = eventFactory.createStartDocument();
			xmlEventWriter.add(event);
			event = eventFactory.createStartElement("jenkov", "http://jenkov.com", "document");
			xmlEventWriter.add(event);
			event = eventFactory.createNamespace("jenkov", "http://jenkov.com");
			xmlEventWriter.add(event);
			event = eventFactory.createAttribute("attribute", "value");
			xmlEventWriter.add(event);
			event = eventFactory.createEndElement("jenkov", "http://jenkov.com", "document");
			xmlEventWriter.add(event);
			
			xmlEventWriter.flush();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} finally {
			if (xmlEventWriter != null) {
				try {
					xmlEventWriter.close();
				} catch (XMLStreamException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
