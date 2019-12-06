package lab_13;

import countries.Countries;
import countries.Country;
import countries.Currency;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

/*Класс предназначен для маршализации и демершализации*/
public class marsh_Unmarsh {

    public String output;

    //Маршализация
    public void marching() throws ParserConfigurationException, JAXBException, SOAPException, IOException {
        //Анонимный класс
        Countries emp = new Countries() {
            {
                Country country = new Country("Spain", 46704314, "Madrid", Currency.EUR);
                this.add(country);
                country = new Country("Poland", 38186860, "Warsaw", Currency.PLN);
                this.add(country);
            }
        };
        //Фабрика для создания объектов SOAPMessage
        MessageFactory mf = MessageFactory.newInstance();
        //Класс для сообщений SOAP
        SOAPMessage message = mf.createMessage();
        //Объект, который представляет содержание элемента body в сообщении SOAP
        SOAPBody body = message.getSOAPBody();

        JAXBContext jc = JAXBContext.newInstance(Countries.class);
        Marshaller marshaller = jc.createMarshaller();
        //Записать объект в формат soap сообщения
        marshaller.marshal(emp, body);
        //Записать в файл
        OutputStream os = new FileOutputStream(new File("soapCountry.xml"));
        message.writeTo(os);
        //Вывести на консоль
        message.writeTo(System.out);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        message.writeTo(outputStream);
        output = new String(outputStream.toByteArray());
    }

    //Демаршализация
    public void unMarching() throws SOAPException, IOException, JAXBException {
        //Класс для сообщений SOAP
        SOAPMessage message = MessageFactory.newInstance().createMessage(null,
                new ByteArrayInputStream(output.getBytes()));
        Unmarshaller unmarshaller = JAXBContext.newInstance(Countries.class).createUnmarshaller();
        Countries st = (Countries) unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
        System.out.println(st);
    }
}
