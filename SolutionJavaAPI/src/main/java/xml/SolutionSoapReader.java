package xml;

import static java.lang.System.out;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.w3c.dom.NodeList;

public class SolutionSoapReader {

	public static void main(String[] args) {
		MessageFactory messageFactor = null;
		try {
			messageFactor = MessageFactory.newInstance();
			SOAPMessage soapMessage = messageFactor.createMessage(new MimeHeaders(),
					new FileInputStream("c:\\text\\soap.txt"));

			SOAPBody body = soapMessage.getSOAPBody();
			NodeList returnList = body.getElementsByTagName("example:VerifyEmail");
			for (int i = 0; i < returnList.getLength(); i++) {
				out.println(returnList.item(i).getLocalName());
				out.println(returnList.item(i).getTextContent());
			}
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
