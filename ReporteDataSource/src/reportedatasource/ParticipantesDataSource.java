/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportedatasource;

import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author ozkrp
 */
public class ParticipantesDataSource implements JRDataSource{
    
    private List<Participante> listaParticipantes = new ArrayList<Participante>(); 
    //se inicializa el indice en (-1) porque al momento de la carga del reporte, el primer metodo invocado es el next y con esto se indiza a 0 y recorre desde alli.
    private int indiceParticipanteActual = -1;
    
    @Override
    public boolean next() throws JRException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
        boolean retorno = false;
        System.out.println("invoco al metodo next, retorno antes de la ejecucion: " + retorno);
        
        System.out.println("indice actual" + indiceParticipanteActual + " Tamaño listaParticipantes: " + listaParticipantes.size());
        
        retorno = ++indiceParticipanteActual < listaParticipantes.size();
        
        System.out.println("invoco al metodo next, retorno despues de la ejecucion: " + retorno);
        
        return retorno;
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("invoco al metodo getFielValue, JRField: " + jrf.getName());
        
        Object valor = null;
        
        if("nombre".equals(jrf.getName()))
            valor = listaParticipantes.get(indiceParticipanteActual).getNombre();
        else if("username".equals(jrf.getName()))
            valor = listaParticipantes.get(indiceParticipanteActual).getUsername();
        else if("password".equals(jrf.getName()))
            valor = listaParticipantes.get(indiceParticipanteActual).getPassword();
        else if("comentarios".equals(jrf.getName()))
            valor = listaParticipantes.get(indiceParticipanteActual).getComentarios();
        
        return valor;
    }
    
    public void addParticipante (Participante participante) {
        this.listaParticipantes.add(participante);
    }
    
}
