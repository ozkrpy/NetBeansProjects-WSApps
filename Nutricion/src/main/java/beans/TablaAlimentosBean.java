/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ManagerBeans.ManagerBeanLocal;
import entities.AlimentoBasico;
import entities.Alimentos;
import entities.DatosDieta;
import entities.Dieta;
import entities.ReferenciasDieta;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author ozkrp
 */
@Named(value = "tablaAlimentosBean")
@SessionScoped
public class TablaAlimentosBean implements Serializable {

    /**
     * FIELDS FOR INPUT
     */
    private int codigoDieta;
    private int cantidadNuevoAlimento;
    private List<AlimentoBasico> listaDesplegableAlimentos;
    private List listaDesplegableDietas;
    private int codigoAlimentoSeleccionado;
    private int codigoPaciente = 1;
    private List<DatosDieta> tablaAlimentos = new ArrayList<DatosDieta>();
    private ReferenciasDieta referencias;

    /**
     * FIELDS FOR OUTPUT
     */
    private int cantidadAlimentoDieta;
    private double sumatoriaHidratosCarbono;
    private double sumatoriaProteina;
    private double sumatoriaGrasa;
    private double sumatoriaFibra;
    private double sumatoriaCalorias;

    @EJB
    private ManagerBeanLocal managerBeanLocal;

    /**
     * CONSTRUCTORS
     */
    public TablaAlimentosBean() {
    }

    /**
     * PAGE VARIABLES PRE-LOAD
     */
    @PostConstruct
    public void init() {
        listaDesplegableAlimentos = managerBeanLocal.nombreAlimentos();
        listaDesplegableDietas = managerBeanLocal.listadoDietas();
    }

    /**
     * GETTERs & SETTERs
     */
    public int getCodigoAlimentoSeleccionado() {
        return codigoAlimentoSeleccionado;
    }

    public void setCodigoAlimentoSeleccionado(int codigoAlimentoSeleccionado) {
        this.codigoAlimentoSeleccionado = codigoAlimentoSeleccionado;
    }

    public int getCantidadNuevoAlimento() {
        return cantidadNuevoAlimento;
    }

    public void setCantidadNuevoAlimento(int cantidadNuevoAlimento) {
        this.cantidadNuevoAlimento = cantidadNuevoAlimento;
    }

    public List<AlimentoBasico> getListaDesplegableAlimentos() {
        return listaDesplegableAlimentos;
    }

    public void setListaDesplegableAlimentos(List<AlimentoBasico> listaDesplegableAlimentos) {
        this.listaDesplegableAlimentos = listaDesplegableAlimentos;
    }

    public int getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(int codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public List<DatosDieta> getTablaAlimentos() {
        return tablaAlimentos;
    }

    public void setTablaAlimentos(List<DatosDieta> tablaAlimentos) {
        this.tablaAlimentos = tablaAlimentos;
    }

    public int getCodigoDieta() {
        return codigoDieta;
    }

    public void setCodigoDieta(int codigoDieta) {
        this.codigoDieta = codigoDieta;
    }

    public List getListaDesplegableDietas() {
        return listaDesplegableDietas;
    }

    public void setListaDesplegableDietas(List listaDesplegableDietas) {
        this.listaDesplegableDietas = listaDesplegableDietas;
    }

    public double getSumatoriaHidratosCarbono() {
        return sumatoriaHidratosCarbono;
    }

    public void setSumatoriaHidratosCarbono(double sumatoriaHidratosCarbono) {
        this.sumatoriaHidratosCarbono = sumatoriaHidratosCarbono;
    }

    public double getSumatoriaProteina() {
        return sumatoriaProteina;
    }

    public void setSumatoriaProteina(double sumatoriaProteina) {
        this.sumatoriaProteina = sumatoriaProteina;
    }

    public double getSumatoriaGrasa() {
        return sumatoriaGrasa;
    }

    public void setSumatoriaGrasa(double sumatoriaGrasa) {
        this.sumatoriaGrasa = sumatoriaGrasa;
    }

    public double getSumatoriaFibra() {
        return sumatoriaFibra;
    }

    public void setSumatoriaFibra(double sumatoriaFibra) {
        this.sumatoriaFibra = sumatoriaFibra;
    }

    public double getSumatoriaCalorias() {
        return sumatoriaCalorias;
    }

    public void setSumatoriaCalorias(double sumatoriaCalorias) {
        this.sumatoriaCalorias = sumatoriaCalorias;
    }

    public ReferenciasDieta getReferencias() {
        return referencias;
    }

    public void setReferencias(ReferenciasDieta referencias) {
        this.referencias = referencias;
    }

    /**
     * METHODS
     */
    public String agregarAlimentoDieta() {
        System.out.println(TablaAlimentosBean.class.getSimpleName() + " invoco agregarAlimentoDieta");
        if (codigoAlimentoSeleccionado != 0 && cantidadNuevoAlimento != 0 && codigoPaciente != 0) {
            int codigoDietaAfterInsert = managerBeanLocal.agregarAlimentoDieta(codigoDieta, codigoAlimentoSeleccionado, cantidadNuevoAlimento, codigoPaciente);
            System.out.println(TablaAlimentosBean.class.getSimpleName() + " tras la insercion retorno codigo dieta: " + codigoDietaAfterInsert);
            codigoDieta = codigoDietaAfterInsert;
            listaDesplegableDietas = managerBeanLocal.listadoDietas();
            changeListenerCodigoDieta();
        }
        return null;
    }

    private void actualizaListaAlimentos(int codigoDieta) {
        //CONSULTA LA TABLA DE DIETA Y RECUPERA LOS ITEMS PARA MOSTRAR DE ACUERDO A LA CANTIDAD
        sumatoriaHidratosCarbono = 0;
        sumatoriaProteina = 0;
        sumatoriaGrasa = 0;
        sumatoriaFibra = 0;

        tablaAlimentos.removeAll(tablaAlimentos);
        System.out.println(TablaAlimentosBean.class.getSimpleName() + " invoco actualizaListaAlimentos(int codigoDieta)");
        List<Dieta> recuperaDietasPorCodigo = managerBeanLocal.detalleDieta(codigoDieta);
        System.out.println(TablaAlimentosBean.class.getSimpleName() + " Recupero listado de dietas: " + recuperaDietasPorCodigo.toString());
        for (Dieta detalle : recuperaDietasPorCodigo) {
            cantidadAlimentoDieta = detalle.getDietaPK().getCantidadAlimento();
            Alimentos alimento = managerBeanLocal.detalleAlimento(detalle.getDietaPK().getCodigoAlimento());
            double tempMedidaCasera = (Double.valueOf(alimento.getMedidaCasera())) * cantidadAlimentoDieta;
            alimento.setMedidaCasera(String.valueOf(tempMedidaCasera));
            alimento.setMedidaReal(alimento.getMedidaReal() * cantidadAlimentoDieta);
            alimento.setHidratosCarbono(alimento.getHidratosCarbono() * cantidadAlimentoDieta);
            alimento.setProteina(alimento.getProteina() * cantidadAlimentoDieta);
            alimento.setGrasa(alimento.getGrasa() * cantidadAlimentoDieta);
            alimento.setSodio(alimento.getSodio() * cantidadAlimentoDieta);
            alimento.setPotasio(alimento.getPotasio() * cantidadAlimentoDieta);
            alimento.setFosforo(alimento.getFosforo() * cantidadAlimentoDieta);
            alimento.setCalcio(alimento.getCalcio() * cantidadAlimentoDieta);
            alimento.setHierro(alimento.getHierro() * cantidadAlimentoDieta);
            alimento.setColesterol(alimento.getColesterol() * cantidadAlimentoDieta);
            alimento.setPurinas(alimento.getPurinas() * cantidadAlimentoDieta);
            alimento.setFibra(alimento.getFibra() * cantidadAlimentoDieta);
            alimento.setAgua(alimento.getAgua() * cantidadAlimentoDieta);
            alimento.setCalorias(alimento.getCalorias() * cantidadAlimentoDieta);

            DatosDieta nuevaFilaDieta = new DatosDieta();
            nuevaFilaDieta.setDatosDieta(detalle);
            nuevaFilaDieta.setDatosAlimento(alimento);

            tablaAlimentos.add(nuevaFilaDieta);

            sumatoriaHidratosCarbono = sumatoriaHidratosCarbono + alimento.getHidratosCarbono();
            sumatoriaProteina = sumatoriaProteina + alimento.getProteina();
            sumatoriaGrasa = sumatoriaGrasa + alimento.getGrasa();
            sumatoriaFibra = sumatoriaFibra + alimento.getFibra();
            sumatoriaCalorias = sumatoriaCalorias + alimento.getCalorias();
            kcalHC = sumatoriaHidratosCarbono * 4;
            kcalProteina = sumatoriaProteina * 4;
            kcalGrasa = sumatoriaGrasa * 9;
            kcalFibra = kcalGrasa + kcalHC + kcalProteina;
        }
    }

    public void changeListenerCodigoDieta() {
        System.out.println(TablaAlimentosBean.class.getSimpleName() + " invoco changeListenerCodigoDieta()");
        if (codigoDieta != 0) {
            System.out.println(TablaAlimentosBean.class.getSimpleName() + " codigo de dieta cambio: " + codigoDieta);
            actualizaListaAlimentos(codigoDieta);
        }
    }

    /**
     * METODOS PARA CALCULOS
     */
    private double HC;
    private double minHC;
    private double maxHC;
    private double kcalHC;

    private double proteina;
    private double minProteina;
    private double maxProteina;
    private double kcalProteina;

    private double grasa;
    private double minGrasa;
    private double maxGrasa;
    private double kcalGrasa;

    private double fibra;
    private double minFibra;
    private double maxFibra;
    private double kcalFibra;

    public double getHC() {
        return HC;
    }

    public void setHC(double HC) {
        this.HC = HC;
        this.minHC = HC - 5;
        this.maxHC = HC + 5;
        
    }

    public double getMinHC() {
        return minHC;
    }

    public void setMinHC(double minHC) {
        this.minHC = HC - 5;
    }

    public double getMaxHC() {
        return maxHC;
    }

    public void setMaxHC(double maxHC) {
        this.maxHC = HC + 5;
    }

    public double getKcalHC() {
        return kcalHC;
    }

    public void setKcalHC(double kcalHC) {
        this.kcalHC = sumatoriaHidratosCarbono * 4;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
        this.minProteina = proteina - 5;
        this.maxProteina = proteina + 5;
        
    }

    public double getMinProteina() {
        return minProteina;
    }

    public void setMinProteina(double minProteina) {
        this.minProteina = proteina - 5;
    }

    public double getMaxProteina() {
        return maxProteina;
    }

    public void setMaxProteina(double maxProteina) {
        this.maxProteina = proteina + 5;
    }

    public double getKcalProteina() {
        return kcalProteina;
    }

    public void setKcalProteina(double kcalProteina) {
        this.kcalProteina = kcalProteina;
    }

    public double getGrasa() {
        return grasa;
    }

    public void setGrasa(double grasa) {
        this.grasa = grasa;
        this.minGrasa = grasa - 5;
        this.maxGrasa = grasa + 5;
        
    }

    public double getMinGrasa() {
        return minGrasa;
    }

    public void setMinGrasa(double minGrasa) {
        this.minGrasa = grasa - 5;
    }

    public double getMaxGrasa() {
        return maxGrasa;
    }

    public void setMaxGrasa(double maxGrasa) {
        this.maxGrasa = grasa + 5;
    }

    public double getKcalGrasa() {
        return kcalGrasa;
    }

    public void setKcalGrasa(double kcalGrasa) {
        this.kcalGrasa = kcalGrasa;
    }

    public double getFibra() {
        return fibra;
    }

    public void setFibra(double fibra) {
        this.fibra = fibra;
        this.minFibra = fibra * 0.95;
        this.maxFibra = fibra * 1.05;
        
    }

    public double getMinFibra() {
        return minFibra;
    }

    public void setMinFibra(double minFibra) {
        this.minFibra = fibra * 0.95;
    }

    public double getMaxFibra() {
        return maxFibra;
    }

    public void setMaxFibra(double maxFibra) {
        this.maxFibra = fibra * 1.05;
    }

    public double getKcalFibra() {
        return kcalFibra;
    }

    public void setKcalFibra(double kcalFibra) {
        this.kcalFibra = kcalFibra;
    }
    
    public void changeListenerCampos() {
        System.out.println("Se instancio el modulo");
    }
}
