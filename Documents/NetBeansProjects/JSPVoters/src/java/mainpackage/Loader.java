package mainpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;


public class Loader {
    
    public static TreeSet<String> dni;
    public static HashMap<Integer, List<String>> vyvod;
    
    public static void Rascet(String filePath) {
        
        HashMap<Integer, OneTime> result;
        File xmlFile = new File(filePath + "res/data.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);
        SAXParser parser;
        Handler handler = new Handler();
        List<String> arrayDni;
        
        try {
            InputStream xmlData = new FileInputStream(xmlFile);
            parser = factory.newSAXParser();
            parser.parse(xmlData, handler);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (SAXException ex) {
                Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
        result = handler.results();
        Set stationSet = result.entrySet();
/*  Общее число дней работы участков        */
        dni = handler.getDni();
        
        vyvod = new HashMap<Integer, List<String>>();
/*  Формируем набор строк для участков с часами работы для каждого дня        */
        Iterator it = stationSet.iterator();
        while (it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            arrayDni = new ArrayList();
            for (int i = 0; i < dni.size(); i++) {
                arrayDni.add("           ");
            }
            OneTime marks = (OneTime) me.getValue();
            Set dayMarks = (Set) marks.getMarks().entrySet();
            Iterator mt = dayMarks.iterator();
/*  Формируем строку с часами работы для данного участка        */
            while (mt.hasNext()) {
                Map.Entry times = (Map.Entry) mt.next();
                String stationDay = (String) times.getKey();
                int nom = 0;
                for (String den : dni) {
                    if (den.equals(stationDay)) {
                        arrayDni.set(nom, ((String) times.getValue() ));
                    }
                    nom++;
                }
            }
            vyvod.put((Integer) me.getKey(), arrayDni);
        }
   }

}
