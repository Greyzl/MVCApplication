package collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service("injectCollection")
public class CollectionInjection {
    @Resource(name = "map")
    private Map<String,Object> map;
    @Resource(name = "props")
    private Properties props;
    @Resource(name = "set")
    private Set set;
    @Resource(name = "list")
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext crx = new GenericXmlApplicationContext();
        crx.load("app-context-annotation.xml");
        crx.refresh();
        CollectionInjection instance = (CollectionInjection) crx.getBean("injectCollection");
        instance.displayInfo();
        crx.close();
    }
    public void displayInfo(){
        System.out.println("Map content: \n");
        map.entrySet().stream().forEach( e -> System.out.println("Key :"+ e.getKey() + " Value :" + e.getValue()));

        System.out.println("Properties content: \n");
        props.entrySet().stream().forEach(e -> System.out.println("Key :"+ e.getKey() + " Value :" + e.getValue()));

        System.out.println("\nSet content: \n");
        set.stream().forEach(obj -> System.out.println("Value: " + obj));

        System.out.println("\nList content: \n");
        list.stream().forEach(obj -> System.out.println("Value: " + obj));

    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }
}
