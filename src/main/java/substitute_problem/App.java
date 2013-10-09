package substitute_problem;

import org.xml.sax.SAXException;
import substitute_problem.generated.*;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException, SAXException {
        System.out.println( "Hello World!" );
        unmarshall();
    }

    public static void unmarshall() throws SAXException, JAXBException {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("d:\\projects\\coursera\\substitute_problem\\src\\main\\java\\substitute_problem\\sample.xsd"));

        JAXBContext jc = JAXBContext.newInstance(ItemsType.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setSchema(schema);
        JAXBElement<ItemsType> customer = (JAXBElement<ItemsType>) unmarshaller.unmarshal(new File("d:\\projects\\coursera\\substitute_problem\\src\\main\\java\\substitute_problem\\sample.xml"));
        list(customer);
    }

    public static void list(JAXBElement<ItemsType> items){
        ItemsType itemsType=items.getValue();
        for(JAXBElement<? extends ProductType> productType : itemsType.getProduct()){
            System.out.println(productType.getValue().toString());
        }
    }
}

