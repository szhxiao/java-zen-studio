/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

package myssm.ioc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import util.StringUtils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ClassPathXMLApplicationContext implements BeanFactory{

    private Map<String, Object> beanMap = new HashMap<>();
    private String path = "applicationContext.xml";

    public ClassPathXMLApplicationContext() {
        this("applicationContext.xml");
    }

    public ClassPathXMLApplicationContext(String path) {
        if (StringUtils.isEmpty(path)) {
            throw new RuntimeException("异常：IOC容器配置文件未指定");
        }
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(
                    "applicationContext.xml");
            // 1. 创建DocumentBuilderFactory
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            // 2. 创建DocumentBuilder对象
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            // 3. 创建Document对象
            Document document = builder.parse(is);
            // 4. 获取所有bean节点
            NodeList beanNodes = document.getElementsByTagName("bean");

            for (int i = 0; i < beanNodes.getLength(); i++) {
                Node beanNode = beanNodes.item(i);
                if (beanNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element beanElement = (Element) beanNode;
                    String beanId = beanElement.getAttribute("id");
                    String className = beanElement.getAttribute("class");
                    Class beanClass = Class.forName(className);
                    Object beanObj =
                            beanClass.getDeclaredConstructor().newInstance();

                    beanMap.put(beanId, beanObj);
                }
            }
            
            // 5. 组装bean之间的依赖关系
            for (int i = 0; i < beanNodes.getLength(); i++) {
                Node beanNode = beanNodes.item(i);
                if (beanNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element beanElement = (Element) beanNode;
                    String beanId = beanElement.getAttribute("id");
                    NodeList beanChildNodes = beanElement.getChildNodes();
//                    System.out.println(beanChildNodes.getLength());
                    for (int j = 0; j < beanChildNodes.getLength(); j++) {
                        Node childNode = beanChildNodes.item(j);
                        if (childNode.getNodeType() == Node.ELEMENT_NODE &&
                            "property".equals(childNode.getNodeName())) {
                            Element propertyElement = (Element) childNode;
                            String propertyName =
                                    propertyElement.getAttribute("name");
                            String propertyRef =
                                    propertyElement.getAttribute("ref");
                            // 1. 找到propertyRef对应的实例
                            Object refObj = beanMap.get(propertyRef);
                            // 2. 将refObj设置到当前bean对应实例的property属性上
                            Object beanObj = beanMap.get(beanId);
                            Class beanClazz = beanObj.getClass();
                            Field propertyField =
                                    beanClazz.getDeclaredField(propertyName);
                            propertyField.setAccessible(true);
                            propertyField.set(beanObj, refObj);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String id) {
        return beanMap.get(id);
    }
}
