package xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class SolutionWriteSOAP {

	public static void main(String[] args) {
		SOAPConnectionFactory soapConnectionFactory = null;
		SOAPConnection soapConnection = null;

		try {
			soapConnectionFactory = SOAPConnectionFactory.newInstance();
			soapConnection = soapConnectionFactory.createConnection();

			String url = "http://ws.cdyne.com/emailverify/Emailvernotestemail.asmx";
			SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);
			System.out.print("Response SOAP Message:");
			soapResponse.writeTo(System.out);

			soapConnection.close();

		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static SOAPMessage createSOAPRequest() throws SOAPException, IOException {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		String serverURI = "http://ws.cdyne.com/";

		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("example", serverURI);

		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("VerifyEmail", "example");
		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("email", "example");
		soapBodyElem1.addTextNode("mutantninja@gmail.com");
		SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("LicenseKey", "example");
		soapBodyElem2.addTextNode("123");

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + "VerifyEmail");

		soapMessage.saveChanges();
		
		System.out.print("Request SOAP Message:");
		
		File file = new File("c:\\text\\soap.txt");
		if (file.exists() == false) {
			file.createNewFile();
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		
		soapMessage.writeTo(fileOutputStream);
		System.out.println();

		return soapMessage;
	}

}
