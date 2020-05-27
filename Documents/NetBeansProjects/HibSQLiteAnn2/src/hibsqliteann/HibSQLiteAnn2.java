/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibsqliteann;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Alexander
 */
public class HibSQLiteAnn2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//     Source database -> SQLite (Loto94.db)
         Configuration configuration= new Configuration().configure("/hibernate1.cfg.xml");
         ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder()
                      .applySettings(configuration.getProperties()).build();
         SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
         Session session= sessionFactory.openSession();
//     Destination datatable ->MySQL    (test)        
         Configuration cfg= new Configuration().configure("/hibernate2.cfg.xml");                
         ServiceRegistry serviceRegistry1= new StandardServiceRegistryBuilder()
                        .applySettings(cfg.getProperties()).build();              
         SessionFactory sessionFactory1 = cfg.buildSessionFactory(serviceRegistry1);         
         Session session1= sessionFactory1.openSession();  
         
         
         session.beginTransaction();
 
        
         List <Dann> dn = session.createCriteria(Dann.class,"from dann").list(); 
        session.getTransaction().commit();
        session.flush();
        session.close();          

        Dann dn2=new Dann();
        
// clearing MySQL database        
        session1.beginTransaction();        
        session1.createQuery("delete from Dann").executeUpdate();      
        session1.getTransaction().commit();
        session1.flush();
 //       session1.close();  
//  copy SQLite -> MySQL                 
 //       session1= sessionFactory1.openSession();                   
        session1.beginTransaction();       
        session1.createCriteria("insert into dann ");
        int i=0;
        int sz=dn.size();
        for (Iterator<Dann> iterator = dn.iterator(); iterator.hasNext();) {
            i++;
            Dann next = iterator.next();
            next.setId(i);
 //           if(i < sz) 
                session1.save(next);
        }

        session1.getTransaction().commit();
        session1.flush();
        session1.close();
        sessionFactory1.close();       
        sessionFactory.close();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
        StandardServiceRegistryBuilder.destroy(serviceRegistry1);
    }
}
