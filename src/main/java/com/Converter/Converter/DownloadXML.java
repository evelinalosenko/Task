package com.Converter.Converter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class DownloadXML {
    public static void saveXml() throws ParserConfigurationException, IOException, SAXException {
        String url = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
        String fileName = "xmlfile.xml";

        FileOutputStream fout = null;
        BufferedInputStream in = null;

        try {
            in = new BufferedInputStream(new URL(url).openStream());
            fout = new FileOutputStream(fileName);
            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1){
                fout.write(data, 0, count);
                fout.flush();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                parseXml();

            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }

     public static void parseXml() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document =  builder.parse(new File("xmlfile.xml"));

        Element element = document.getDocumentElement();
       getElements(element.getElementsByTagName("Cube"));

    }
     public static void getElements(NodeList nodeList) {
        /*String time, rate,currency;

         for (int i = 0; i < nodeList.getLength(); i++) {

             if (((Element) nodeList.item(i)).hasAttribute("time") || ((Element) nodeList.item(i)).hasAttribute("currency") && ((Element) nodeList.item(i)).hasAttribute("rate")) {
                 time = ((Element) nodeList.item(i)).getAttribute("time");
                 currency = ((Element) nodeList.item(i)).getAttribute("currency");
                 rate = ((Element) nodeList.item(i)).getAttribute("rate");
                 i = i - 1;
                 try {
                     //database.insert(i, time, rate, currency);
                     return;
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }

         }*/
         try {
         String[] country = {"US dollar", "Japanese yen", "Bulgarian lev", "Czech koruna",
                 "Danish krone", "Pound sterling", "Hungarian forint", "Polish zloty", "Romanian leu", "Swedish krona", "Swiss franc", "Icelandic krona",
                 "Norwegian krone", "Croatian kuna", "Russian rouble", "Turkish lira", "Australian dollar", "Brazilian real", "Canadian dollar",
                 "Chinese yuan renminbi", "Hong Kong dollar", "Indonesian rupiah", "Israeli shekel", "Indian rupee", "South Korean won", "Mexican peso",
                 "Malaysian ringgit", "New Zealand dollar", "Philippine peso", "Singapore dollar", "Thai baht", "South African rand"
         };

             for (int temp = 0; temp < nodeList.getLength(); temp++) {
                 Node nNode = nodeList.item(temp);

                 if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                     Element eElement = (Element) nNode;
                     if(eElement.hasAttributes()){
                         database.insert(temp, eElement.getAttribute("time"), eElement.getAttribute("rate"), eElement.getAttribute("currency"), country);
                         System.out.println(temp +""+ eElement.getAttribute("time")+""+ eElement.getAttribute("rate")+""+ eElement.getAttribute("currency")+""+ country);

                     }


                 }
             }
         } catch (Exception e) {
             e.printStackTrace();
         }


     }
}



