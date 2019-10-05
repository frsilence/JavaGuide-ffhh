package dome4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yfzhao
 * Date: 2019/9/30
 * Time: 15:23
 * Description: No Description
 */
public class Dom4jDemo {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        InputStream in = Document.class.getClassLoader().getResourceAsStream("dome4j/dom4jdemo.xml");
        Document document = reader.read(in);
        //查询
        Element root = document.getRootElement();
        String rootname = root.getName();
        System.out.println(rootname);

        List<Element> cpuList = root.selectNodes("cpu");
        for (Element cpu:cpuList){
            Element model = (Element) cpu.selectSingleNode("model");//取单个子节点
            System.out.println(model.attributeValue("c"));//取属性
            System.out.println(model.getText());//取节点文本
        }
    }
}
