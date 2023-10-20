package com.ssafy.reflection.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DaoFactory {
	
	//new 라는 키워드로 결합된것이 아니므로, 컴파일 시점에는 아무 관계가 아님 (결합X)
	//런타임시점에 service와 myuserdao사이에 느슨한 결합이 생긴다.
//	public static UserDao getDao(String type) {
//		switch(type) {
//		case "my":
//			return new MyUserDao();
//		case "ora":
//			return new OraUserDao();
//		default:
//			return null;
//		}
//	}
	
	private static HashMap<String, UserDao> daos = new HashMap<>();// Spring Container
	
	public static UserDao getBean(String type) {
		return daos.get(type);
	}
	
	static { // xml 파일 불러올때 DomParser 사용
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder parser = factory.newDocumentBuilder();

            Document dom = parser.parse(new FileInputStream("./src/com/ssafy/reflection/factory/config.xml"));
            Element root = dom.getDocumentElement();
            NodeList list = root.getChildNodes();
            for (int i=0; i < list.getLength(); i++) {
                if (list.item(i) instanceof Element) {
                    Element el = (Element) list.item(i);
                    String id = el.getAttribute("id");
                    String className = el.getTextContent();
                    
                    //className을 활용해서 리플렉션을 사용하자-------
                    Class daoClass = Class.forName(className);//이름으로 클래스정보 가져오기
                    Object object = daoClass.newInstance();
                    
                    if(UserDao.class.isInstance(object)) {
                    	UserDao dao = (UserDao) object;
                    	 daos.put(id, dao);
                    }
                    //-------------------------------------            
                    System.out.println(id + ":" + className);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
