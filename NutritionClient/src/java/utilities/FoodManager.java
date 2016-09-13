/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entities.Alimentos;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ozkrp
 */
public class FoodManager {

    Session session = null;

    public FoodManager() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List getFood() {
        List<Alimentos> alimentos = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Alimentos");
            alimentos = (List<Alimentos>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        return alimentos;
    }

    public Alimentos getAlimentosPorID(int alimentoId) {

        Alimentos alimento = null;

        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Alimentos as alimentos where alimentos.codigoAlimento = " + alimentoId);
            alimento = (Alimentos) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return alimento;
    }

}
