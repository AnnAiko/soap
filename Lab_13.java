package lab_13;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;

public class Lab_13 {

    public static void main(String[] args) {
        try {
            //Экземпляр класса marshDemarsh
            marsh_Unmarsh marsh = new marsh_Unmarsh();
            System.out.println("Маршализация");
            //Маршализация
            marsh.marching();
            System.out.println();
            System.out.println("----------------------------");
            System.out.println("Демаршализация");
            //Демаршализация
            marsh.unMarching();
        } catch (ParserConfigurationException e) {
            System.out.println(e);
        } catch (JAXBException e) {
            System.out.println(e);
        } catch (SOAPException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
