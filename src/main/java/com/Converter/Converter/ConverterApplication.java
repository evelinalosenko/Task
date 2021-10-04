package com.Converter.Converter;

import com.Converter.Converter.Security.AllData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class ConverterApplication {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, SQLException {
		SpringApplication.run(ConverterApplication.class, args);
		DownloadXML saveXML = new DownloadXML();
		saveXML.saveXml();
		AllData get = new AllData();
		get.GetAllData();
	}

}
