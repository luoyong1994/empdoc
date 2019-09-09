package com.ynet.empdoc;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.Iterator;

public class ApplicationTest {

    @Test
    public void testXML() throws DocumentException {
        String xml="<persion><name>罗勇</name><sex>男</sex></persion>";
        Document document = DocumentHelper.parseText(xml);
        Element rootElement = document.getRootElement();
        String stringValue = rootElement.getStringValue();
        System.out.println(stringValue);
        System.out.println(rootElement.toString());
    }
}
