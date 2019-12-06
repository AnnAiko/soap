
package countries;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//Задать последовательности элементов XML
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "country"
})
//Элемент самого верхнего уровня, все остальные элементы лежат в нем
@XmlRootElement(name = "body")
public class Countries {
    @XmlElement(required = true)
    protected List<Country> country = new ArrayList<Country>();
    public List<Country> getEmployment() {
        if (country == null) {
            country = new ArrayList<Country>();
        }
        return this.country;
    }

    //Добавить элемент в список
    public boolean add(Country emp) {
        return country.add(emp);
    }

    //Преопределить метод 
    @Override
    public String toString() {
        return "Countries [list=" + country + "]";
    }
}
