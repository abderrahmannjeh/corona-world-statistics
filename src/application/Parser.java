package application;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import application.model.DateDeathRapport;
import application.model.DateRapport;
import application.model.Rapport;
import application.model.Record;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//this parser will read data from the url 
public class Parser {

	 String url;
	 DocumentBuilderFactory dbFactory ;
      DocumentBuilder dBuilder ;
      Document doc ;
	
    
    

	public Parser(String url) throws ParserConfigurationException, MalformedURLException, SAXException, IOException {
		super();
		this.url = url;
		dbFactory = DocumentBuilderFactory.newInstance();
	      dBuilder = dbFactory.newDocumentBuilder();
	      dBuilder.parse(new URL(url).openStream());
	     doc = dBuilder.parse(new URL(url).openStream());
	}

	/*
	 this method return rapport for each contry that contain all the informations (name,new Caces , new Death....)
	 
	 
	 */
	public  ObservableList<Rapport> readFile() throws NumberFormatException, DOMException, ParserConfigurationException, SAXException, IOException{
		
         
         doc.getDocumentElement().normalize();
         NodeList nList = doc.getElementsByTagName("record");
         ObservableList<Rapport>rapports =FXCollections.observableArrayList();
         for (int temp = 0; temp < nList.getLength(); temp++) {
             Node nNode = nList.item(temp);
             
             NodeList chiledes= nNode.getChildNodes();
             Rapport rapport =new Rapport();
             if(chiledes.item(13).getTextContent()!="")
             {rapport.setContry(chiledes.item(13).getTextContent());
             
             if(rapports.contains(rapport))
            	 {rapport=rapports.get(rapports.indexOf(rapport));
            	 rapport.setTotal(rapport.getTotal()+Integer.parseInt(chiledes.item(9).getTextContent()));
            	 rapport.setTotalDeaths(rapport.getTotalDeaths()+Integer.parseInt(chiledes.item(11).getTextContent()));
            	 }
             else
             {
          
            
             rapport.setNewCases(Integer.parseInt(chiledes.item(9).getTextContent()));
             rapport.setNewdeath(Integer.parseInt(chiledes.item(11).getTextContent()));
             
             if(chiledes.item(19).getTextContent()!="")
             {
            	 rapport.setPopulation(Integer.parseInt(chiledes.item(19).getTextContent()));
            	 
             }
            	 
             rapport.setTotal(Integer.parseInt(chiledes.item(9).getTextContent()));
             rapport.setTotalDeaths(Integer.parseInt(chiledes.item(11).getTextContent()));
             rapports.add(rapport);
             }
             
             
             
             if(rapport.getTotal()>0)
             rapport.setMortaility((float) rapport.getTotalDeaths()/rapport.getTotal());
             if(rapport.getPopulation()>0)
        	 rapport.setAttackRate((float) rapport.getTotal()/rapport.getPopulation());
             
             
             
             }
         }
         return rapports;
		
	}
	
	/*
	 this methode return the number of new Case for each continent and sorted by date 
	 * */
	public  ObservableList<DateRapport> readFile2() throws NumberFormatException, DOMException, ParserConfigurationException, SAXException, IOException, ParseException{
		 
       
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("record");
        ObservableList<DateRapport>rapports =FXCollections.observableArrayList();
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            
            NodeList chiledes= nNode.getChildNodes();
            DateRapport rapport=new DateRapport();
            String date1 =chiledes.item(1).getTextContent();
           
           Date date2 = null;
           DateFormat df = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
           date2 = df.parse(date1); 
            String continent=chiledes.item(21).getTextContent();
            rapport.setContinent(continent);
        	Integer newCases=Integer.parseInt(chiledes.item(9).getTextContent());

            if(rapports.contains(rapport))
            {
            	rapport=rapports.get(rapports.indexOf(rapport));
            	
            	if(rapport.getValues().containsKey(date2))
            	{rapport.getValues().put(date2,rapport.getValues().get(date2)+newCases);
            		
            	}
            	else
            		rapport.getValues().put(date2,newCases);
            		
            	
            }
            else
            {
            	rapport.setValues(new TreeMap<Date, Integer>());
            	rapport.getValues().put(date2,newCases );
            	rapports.add(rapport);
            }
            	
        }
        return rapports;
        
	
	
	}
	public  ObservableList<DateDeathRapport> readFile3() throws NumberFormatException, DOMException, ParserConfigurationException, SAXException, IOException, ParseException{
		 
	       
        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("record");
        ObservableList<DateDeathRapport>rapports =FXCollections.observableArrayList();
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            
            NodeList chiledes= nNode.getChildNodes();
            DateDeathRapport rapport=new DateDeathRapport();
            String date1 =chiledes.item(1).getTextContent();
           
           Date date2 = null;
           DateFormat df = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
           date2 = df.parse(date1); 
            String continent=chiledes.item(21).getTextContent();
            rapport.setContinent(continent);
        	Integer newDeath=Integer.parseInt(chiledes.item(11).getTextContent());

            if(rapports.contains(rapport))
            {
            	rapport=rapports.get(rapports.indexOf(rapport));
            	
            	if(rapport.getValues().containsKey(date2))
            	{rapport.getValues().put(date2,rapport.getValues().get(date2)+newDeath);
            		
            	}
            	else
            		rapport.getValues().put(date2,newDeath);
            		
            	
            }
            else
            {
            	rapport.setValues(new TreeMap<Date, Integer>());
            	rapport.getValues().put(date2,newDeath);
            	rapports.add(rapport);
            }
            System.out.println(date2);
            	
        }
        System.out.println(rapports);
        return rapports;
        
	
	
	}
}
