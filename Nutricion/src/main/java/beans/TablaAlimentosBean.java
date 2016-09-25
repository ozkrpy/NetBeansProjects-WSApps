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
import entities.Paciente;
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
    private int cantidadNuevoAlimentoPAVB;
    private int cantidadNuevoAlimentoNoPAVB;
    private List<AlimentoBasico> listaDesplegableAlimentosPAVB;
    //private List<AlimentoBasico> listaDesplegableAlimentosNoPAVB;
    private List listaDesplegableDietas;
    private int codigoAlimentoSeleccionado;
    private int codigoPaciente = 1;
    private List<DatosDieta> tablaAlimentos = new ArrayList<DatosDieta>();
    private List<DatosDieta> tablaAlimentosNoPAVB = new ArrayList<DatosDieta>();
    private ReferenciasDieta referencias;
    private Paciente paciente;
    private DatosDieta modificarDieta;

    /**
     * FIELDS FOR OUTPUT
     */
    private int cantidadAlimentoModificado;
    private double sumatoriaHidratosCarbono;
    private double sumatoriaHidratosCarbonoPAVB;
    private double sumatoriaProteina;
    private double sumatoriaProteinaPAVB;
    private double sumatoriaGrasa;
    private double sumatoriaGrasaPAVB;
    private double sumatoriaFibra;
    private double sumatoriaFibraPAVB;
    private double sumatoriaCalorias;
    private double sumatoriaCaloriasPAVB;

    /**
     * CAMPOS PARA CALCULOS
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
        listaDesplegableAlimentosPAVB = managerBeanLocal.nombreAlimentosPAVB();
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

    public int getCantidadNuevoAlimentoPAVB() {
        return cantidadNuevoAlimentoPAVB;
    }

    public void setCantidadNuevoAlimentoPAVB(int cantidadNuevoAlimentoPAVB) {
        this.cantidadNuevoAlimentoPAVB = cantidadNuevoAlimentoPAVB;
    }

    public List<AlimentoBasico> getListaDesplegableAlimentosPAVB() {
        return listaDesplegableAlimentosPAVB;
    }

    public void setListaDesplegableAlimentosPAVB(List<AlimentoBasico> listaDesplegableAlimentosPAVB) {
        this.listaDesplegableAlimentosPAVB = listaDesplegableAlimentosPAVB;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public DatosDieta getModificarDieta() {
        return modificarDieta;
    }

    public void setModificarDieta(DatosDieta modificarDieta) {
        this.modificarDieta = modificarDieta;
    }

    public int getCantidadAlimentoModificado() {
        return cantidadAlimentoModificado;
    }

    public void setCantidadAlimentoModificado(int cantidadAlimentoModificado) {
        this.cantidadAlimentoModificado = cantidadAlimentoModificado;
    }

    public int getCantidadNuevoAlimentoNoPAVB() {
        return cantidadNuevoAlimentoNoPAVB;
    }

    public void setCantidadNuevoAlimentoNoPAVB(int cantidadNuevoAlimentoNoPAVB) {
        this.cantidadNuevoAlimentoNoPAVB = cantidadNuevoAlimentoNoPAVB;
    }

    public List<DatosDieta> getTablaAlimentosNoPAVB() {
        return tablaAlimentosNoPAVB;
    }

    public void setTablaAlimentosNoPAVB(List<DatosDieta> tablaAlimentosNoPAVB) {
        this.tablaAlimentosNoPAVB = tablaAlimentosNoPAVB;
    }

    public double getSumatoriaProteinaPAVB() {
        return sumatoriaProteinaPAVB;
    }

    public void setSumatoriaProteinaPAVB(double sumatoriaProteinaPAVB) {
        this.sumatoriaProteinaPAVB = sumatoriaProteinaPAVB;
    }

    public double getSumatoriaGrasaPAVB() {
        return sumatoriaGrasaPAVB;
    }

    public void setSumatoriaGrasaPAVB(double sumatoriaGrasaPAVB) {
        this.sumatoriaGrasaPAVB = sumatoriaGrasaPAVB;
    }

    public double getSumatoriaFibraPAVB() {
        return sumatoriaFibraPAVB;
    }

    public void setSumatoriaFibraPAVB(double sumatoriaFibraPAVB) {
        this.sumatoriaFibraPAVB = sumatoriaFibraPAVB;
    }

    public double getSumatoriaCaloriasPAVB() {
        return sumatoriaCaloriasPAVB;
    }

    public void setSumatoriaCaloriasPAVB(double sumatoriaCaloriasPAVB) {
        this.sumatoriaCaloriasPAVB = sumatoriaCaloriasPAVB;
    }

    public double getSumatoriaHidratosCarbonoPAVB() {
        return sumatoriaHidratosCarbonoPAVB;
    }

    public void setSumatoriaHidratosCarbonoPAVB(double sumatoriaHidratosCarbonoPAVB) {
        this.sumatoriaHidratosCarbonoPAVB = sumatoriaHidratosCarbonoPAVB;
    }
    
    /**
     * METHODS
     */
    public String agregarAlimentoDieta() {
        System.out.println(TablaAlimentosBean.class.getSimpleName() + " invoco agregarAlimentoDieta");
        if (codigoAlimentoSeleccionado != 0 && cantidadNuevoAlimentoPAVB != 0 && codigoPaciente != 0) {
            System.out.println(TablaAlimentosBean.class.getSimpleName() + " if distinto a cero");
            int codigoDietaAfterInsert = managerBeanLocal.agregarAlimentoDieta(codigoDieta, codigoAlimentoSeleccionado, cantidadNuevoAlimentoPAVB, codigoPaciente);
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
        sumatoriaHidratosCarbonoPAVB = 0;
        sumatoriaProteina = 0;
        sumatoriaProteinaPAVB = 0;
        sumatoriaGrasa = 0;
        sumatoriaGrasaPAVB = 0;
        sumatoriaFibra = 0;
        sumatoriaFibraPAVB = 0;
        int cantidadAlimentoDieta;

        tablaAlimentos.removeAll(tablaAlimentos);
        tablaAlimentosNoPAVB.removeAll(tablaAlimentosNoPAVB);
        List<Dieta> recuperaDietasPorCodigo = managerBeanLocal.detalleDieta(codigoDieta);
        for (Dieta detalle : recuperaDietasPorCodigo) {
            cantidadAlimentoDieta = detalle.getCantidadAlimento();
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

            agregaNuevaFila(nuevaFilaDieta, alimento);

            paciente = detalle.getCodigoPaciente();
        }
    }

    public void changeListenerCodigoDieta() {
        if (codigoDieta != 0) {
                actualizaListaAlimentos(codigoDieta);
        }
    }

    public boolean cambiaColorHCmin() {
        if ((minHC > sumatoriaHidratosCarbono) && (HC != 0.0 && sumatoriaHidratosCarbono != 0.0)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorHCmax() {
        if ((maxHC < sumatoriaHidratosCarbono && (HC != 0.0 && sumatoriaHidratosCarbono != 0.0))) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorHCcalculado() {
        if ((sumatoriaHidratosCarbono != 0.0) && (sumatoriaHidratosCarbono >= minHC) && (sumatoriaHidratosCarbono <= maxHC)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorProteinaMin() {
        if ((minProteina > sumatoriaProteina) && (proteina != 0.0 && sumatoriaProteina != 0.0)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorProteinaMax() {
        if ((maxProteina < sumatoriaProteina) && (proteina != 0.0 && sumatoriaProteina != 0.0)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorProteinaCalculado() {
        if ((sumatoriaProteina != 0.0) && (sumatoriaProteina >= minProteina) && (sumatoriaProteina <= maxProteina)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorGrasaMin() {
        if ((minGrasa > sumatoriaGrasa) && (grasa != 0.0 && sumatoriaGrasa != 0.0)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorGrasaMax() {
        if ((maxGrasa < sumatoriaGrasa) && (grasa != 0.0 && sumatoriaGrasa != 0.0)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorGrasaCalculado() {
        if ((sumatoriaGrasa != 0.0) && (sumatoriaGrasa >= minGrasa) && (sumatoriaGrasa <= maxGrasa)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorFibraMin() {
        if ((minFibra > sumatoriaFibra) && (fibra != 0.0 && sumatoriaFibra != 0.0)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorFibraMax() {
        if ((maxFibra < sumatoriaFibra) && (fibra != 0.0 && sumatoriaFibra != 0.0)) {
            return true;
        }
        return false;
    }

    public boolean cambiaColorFibraCalculado() {
        if ((sumatoriaFibra != 0.0) && (sumatoriaFibra >= minFibra) && (sumatoriaFibra <= maxFibra)) {
            return true;
        }
        return false;
    }

    public void borrarAlimentoDieta(int codigoDietaBorrar, int codigoAlimentoBorrar, int cantidadBorrar) {
        managerBeanLocal.borrarAlimentoDieta(codigoDietaBorrar, codigoAlimentoBorrar, cantidadBorrar);
        actualizaListaAlimentos(codigoDieta);
        listaDesplegableDietas = managerBeanLocal.listadoDietas();
    }

    public String seleccionarAlimentoDieta(DatosDieta dietaSeleccionada) {

        modificarDieta = dietaSeleccionada;
        return null;
    }

    public String editarAlimentoDieta() {
        try {
            managerBeanLocal.actualizarDieta(modificarDieta.getDatosDieta().getDietaPK(), cantidadAlimentoModificado);
            modificarDieta = null;
            cantidadAlimentoModificado = 0;
            actualizaListaAlimentos(codigoDieta);
        } catch (Exception e) {
            System.err.println("ERROR al intentar modificar :" + e.getMessage());
        }

        return null;
    }

    private void agregaNuevaFila(DatosDieta nuevaFilaDieta, Alimentos alimento) {
        if (alimento.getTipoAlimento().getCodigoTipoAlimento() <= 5) {
            tablaAlimentos.add(nuevaFilaDieta);
            sumatoriaProteinaPAVB = sumatoriaProteinaPAVB + alimento.getProteina();
            sumatoriaHidratosCarbonoPAVB = sumatoriaHidratosCarbonoPAVB + alimento.getHidratosCarbono();
            sumatoriaGrasaPAVB = sumatoriaGrasaPAVB + alimento.getGrasa();
            sumatoriaFibraPAVB = sumatoriaFibraPAVB + alimento.getFibra();
        } else {
            tablaAlimentosNoPAVB.add(nuevaFilaDieta);
        }
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
