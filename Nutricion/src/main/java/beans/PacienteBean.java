/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ManagerBeans.ManagerBeanLocal;
import entities.ElementoListaBasico;
import entities.Paciente;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author ozkrp
 */
@Named(value = "pacienteBean")
@SessionScoped
public class PacienteBean implements Serializable {

    private List<Paciente> listaPacientes;
    private List<ElementoListaBasico> listaNombrePacientes;
    private Paciente detalle;

    /*
    Datos del paciente
     */
    private String nombre;
    private String apellido;
    private String sexo = "M";
    private Integer talla;
    private double meters;
    private String estadoCivil;
    private Date fechaNacimiento;
    private double pesoActual;
    private double pesoHabitual;
    private double pesoAjusta;
    private double pesoSaludable;
    private double porcentajePesoIdeal;
    private double imc;
    private String imcTipo;
    private String porcentajePesoIdealTipo;
    private double ciaMuneca;
    private double ciaBrazo;
    private String biotipo;
    private Boolean antecedenteObesidad;
    private Boolean antecedenteCardiopatias;
    private Boolean antecedenteHta;
    private Boolean antecedenteDiabetes;
    private String medicacion;
    private String diagnosticoMedico;
    private String diagnosticoNutricional;
    private double laboratorioGlicemiaBasal;
    private double laboratorioCreatinina;
    private double laboratorioProteinasTotales;
    private double laboratorioUrea;
    private double laboratorioAcidoUrico;
    private double laboratorioProteinuria;
    private double laboratorioAlbumina;
    private double laboratorioTriglicerios;
    private double laboratorioColesterolTotal;
    private double laboratorioLdl;
    private double laboratorioHdl;
    private double laboratorioGlucosa;
    private double laboratorioHb;
    private double laboratorioHematocrito;
    private double laboratorioGlobulosRojos;
    private double laboratorioPotasio;
    private double laboratorioCi;
    private double laboratorioNa;
    private double laboratorioGlobulosBlancos;
    private double laboratorioHba;

    @EJB
    private ManagerBeanLocal manager;
    private int edad;
    private Date fechaMinima = new Date();
    private double pesoIdeal;
    private double ciaCintura1;
    private double ciaCintura2;

    /**
     * Creates a new instance of PacienteBean
     */
    public PacienteBean() {
    }

    @PostConstruct
    public void init() {
        listaPacientes = manager.listadoPacientes();
    }

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public List<ElementoListaBasico> getListaNombrePacientes() {
        return listaNombrePacientes;
    }

    public void setListaNombrePacientes(List<ElementoListaBasico> listaNombrePacientes) {
        this.listaNombrePacientes = listaNombrePacientes;
    }

    public List<ElementoListaBasico> listarPacientes() {
        return manager.nombrePacientes();
    }

    public Paciente getDetalle() {
        return detalle;
    }

    public void setDetalle(Paciente detalle) {
        this.detalle = detalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getTalla() {
        return talla;
    }

    public void setTalla(Integer talla) {
        this.talla = talla;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public double getPesoHabitual() {
        return pesoHabitual;
    }

    public void setPesoHabitual(double pesoHabitual) {
        this.pesoHabitual = pesoHabitual;
    }

    public double getPesoAjusta() {
        return pesoAjusta;
    }

    public void setPesoAjusta(double pesoAjusta) {
        this.pesoAjusta = pesoAjusta;
    }

    public double getPesoSaludable() {
        return pesoSaludable;
    }

    public void setPesoSaludable(double pesoSaludable) {
        this.pesoSaludable = pesoSaludable;
    }

    public double getPorcentajePesoIdeal() {
        return porcentajePesoIdeal;
    }

    public void setPorcentajePesoIdeal(double porcentajePesoIdeal) {
        this.porcentajePesoIdeal = porcentajePesoIdeal;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getImcTipo() {
        return imcTipo;
    }

    public void setImcTipo(String imcTipo) {
        this.imcTipo = imcTipo;
    }

    public double getCiaMuneca() {
        return ciaMuneca;
    }

    public void setCiaMuneca(double ciaMuneca) {
        this.ciaMuneca = ciaMuneca;
    }

    public double getCiaBrazo() {
        return ciaBrazo;
    }

    public void setCiaBrazo(double ciaBrazo) {
        this.ciaBrazo = ciaBrazo;
    }

    public String getBiotipo() {
        return biotipo;
    }

    public void setBiotipo(String biotipo) {
        this.biotipo = biotipo;
    }

    public Boolean getAntecedenteObesidad() {
        return antecedenteObesidad;
    }

    public void setAntecedenteObesidad(Boolean antecedenteObesidad) {
        this.antecedenteObesidad = antecedenteObesidad;
    }

    public Boolean getAntecedenteCardiopatias() {
        return antecedenteCardiopatias;
    }

    public void setAntecedenteCardiopatias(Boolean antecedenteCardiopatias) {
        this.antecedenteCardiopatias = antecedenteCardiopatias;
    }

    public Boolean getAntecedenteHta() {
        return antecedenteHta;
    }

    public void setAntecedenteHta(Boolean antecedenteHta) {
        this.antecedenteHta = antecedenteHta;
    }

    public Boolean getAntecedenteDiabetes() {
        return antecedenteDiabetes;
    }

    public void setAntecedenteDiabetes(Boolean antecedenteDiabetes) {
        this.antecedenteDiabetes = antecedenteDiabetes;
    }

    public String getMedicacion() {
        return medicacion;
    }

    public void setMedicacion(String medicacion) {
        this.medicacion = medicacion;
    }

    public String getDiagnosticoMedico() {
        return diagnosticoMedico;
    }

    public void setDiagnosticoMedico(String diagnosticoMedico) {
        this.diagnosticoMedico = diagnosticoMedico;
    }

    public String getDiagnosticoNutricional() {
        return diagnosticoNutricional;
    }

    public void setDiagnosticoNutricional(String diagnosticoNutricional) {
        this.diagnosticoNutricional = diagnosticoNutricional;
    }

    public double getLaboratorioGlicemiaBasal() {
        return laboratorioGlicemiaBasal;
    }

    public void setLaboratorioGlicemiaBasal(double laboratorioGlicemiaBasal) {
        this.laboratorioGlicemiaBasal = laboratorioGlicemiaBasal;
    }

    public double getLaboratorioCreatinina() {
        return laboratorioCreatinina;
    }

    public void setLaboratorioCreatinina(double laboratorioCreatinina) {
        this.laboratorioCreatinina = laboratorioCreatinina;
    }

    public double getLaboratorioProteinasTotales() {
        return laboratorioProteinasTotales;
    }

    public void setLaboratorioProteinasTotales(double laboratorioProteinasTotales) {
        this.laboratorioProteinasTotales = laboratorioProteinasTotales;
    }

    public double getLaboratorioUrea() {
        return laboratorioUrea;
    }

    public void setLaboratorioUrea(double laboratorioUrea) {
        this.laboratorioUrea = laboratorioUrea;
    }

    public double getLaboratorioAcidoUrico() {
        return laboratorioAcidoUrico;
    }

    public void setLaboratorioAcidoUrico(double laboratorioAcidoUrico) {
        this.laboratorioAcidoUrico = laboratorioAcidoUrico;
    }

    public double getLaboratorioProteinuria() {
        return laboratorioProteinuria;
    }

    public void setLaboratorioProteinuria(double laboratorioProteinuria) {
        this.laboratorioProteinuria = laboratorioProteinuria;
    }

    public double getLaboratorioAlbumina() {
        return laboratorioAlbumina;
    }

    public void setLaboratorioAlbumina(double laboratorioAlbumina) {
        this.laboratorioAlbumina = laboratorioAlbumina;
    }

    public double getLaboratorioTriglicerios() {
        return laboratorioTriglicerios;
    }

    public void setLaboratorioTriglicerios(double laboratorioTriglicerios) {
        this.laboratorioTriglicerios = laboratorioTriglicerios;
    }

    public double getLaboratorioColesterolTotal() {
        return laboratorioColesterolTotal;
    }

    public void setLaboratorioColesterolTotal(double laboratorioColesterolTotal) {
        this.laboratorioColesterolTotal = laboratorioColesterolTotal;
    }

    public double getLaboratorioLdl() {
        return laboratorioLdl;
    }

    public void setLaboratorioLdl(double laboratorioLdl) {
        this.laboratorioLdl = laboratorioLdl;
    }

    public double getLaboratorioHdl() {
        return laboratorioHdl;
    }

    public void setLaboratorioHdl(double laboratorioHdl) {
        this.laboratorioHdl = laboratorioHdl;
    }

    public double getLaboratorioGlucosa() {
        return laboratorioGlucosa;
    }

    public void setLaboratorioGlucosa(double laboratorioGlucosa) {
        this.laboratorioGlucosa = laboratorioGlucosa;
    }

    public double getLaboratorioHb() {
        return laboratorioHb;
    }

    public void setLaboratorioHb(double laboratorioHb) {
        this.laboratorioHb = laboratorioHb;
    }

    public double getLaboratorioHematocrito() {
        return laboratorioHematocrito;
    }

    public void setLaboratorioHematocrito(double laboratorioHematocrito) {
        this.laboratorioHematocrito = laboratorioHematocrito;
    }

    public double getLaboratorioGlobulosRojos() {
        return laboratorioGlobulosRojos;
    }

    public void setLaboratorioGlobulosRojos(double laboratorioGlobulosRojos) {
        this.laboratorioGlobulosRojos = laboratorioGlobulosRojos;
    }

    public double getLaboratorioPotasio() {
        return laboratorioPotasio;
    }

    public void setLaboratorioPotasio(double laboratorioPotasio) {
        this.laboratorioPotasio = laboratorioPotasio;
    }

    public double getLaboratorioCi() {
        return laboratorioCi;
    }

    public void setLaboratorioCi(double laboratorioCi) {
        this.laboratorioCi = laboratorioCi;
    }

    public double getLaboratorioNa() {
        return laboratorioNa;
    }

    public void setLaboratorioNa(double laboratorioNa) {
        this.laboratorioNa = laboratorioNa;
    }

    public double getLaboratorioGlobulosBlancos() {
        return laboratorioGlobulosBlancos;
    }

    public void setLaboratorioGlobulosBlancos(double laboratorioGlobulosBlancos) {
        this.laboratorioGlobulosBlancos = laboratorioGlobulosBlancos;
    }

    public double getLaboratorioHba() {
        return laboratorioHba;
    }

    public void setLaboratorioHba(double laboratorioHba) {
        this.laboratorioHba = laboratorioHba;
    }

    public double getMeters() {
        return meters;
    }

    public void setMeters(double meters) {
        this.meters = meters;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaMinima() {
        return fechaMinima;
    }

    public void setFechaMinima(Date fechaMinima) {
        this.fechaMinima = fechaMinima;
    }

    public double getPesoIdeal() {
        return pesoIdeal;
    }

    public void setPesoIdeal(double pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
    }

    public String getPorcentajePesoIdealTipo() {
        return porcentajePesoIdealTipo;
    }

    public void setPorcentajePesoIdealTipo(String porcentajePesoIdealTipo) {
        this.porcentajePesoIdealTipo = porcentajePesoIdealTipo;
    }

    public double getCiaCintura1() {
        return ciaCintura1;
    }

    public void setCiaCintura1(double ciaCintura1) {
        this.ciaCintura1 = ciaCintura1;
    }

    public double getCiaCintura2() {
        return ciaCintura2;
    }

    public void setCiaCintura2(double ciaCintura2) {
        this.ciaCintura2 = ciaCintura2;
    }

    public String recuperaDetalles(int codigo) {

        detalle = manager.detallePaciente(codigo);
        return "detallePaciente";
    }

    public String cancelar() {
        detalle = null;
        return "dietas";
    }

    public String guardarDatos() {
        Paciente registrar = new Paciente();
        try {
            registrar.setNombre(nombre);
            registrar.setApellido(apellido);
            registrar.setSexo(sexo);
            registrar.setTalla(talla);
            registrar.setEstadoCivil(estadoCivil);
            registrar.setFechaNacimiento(fechaNacimiento);
            registrar.setPesoActual(pesoActual);
            registrar.setPesoHabitual(pesoHabitual);
            registrar.setPesoAjusta(pesoAjusta);
            registrar.setPesoSaludable(pesoSaludable);
            registrar.setPorcentajePesoIdeal(porcentajePesoIdeal);
            registrar.setImc(imc);
            registrar.setCiaMuneca(ciaMuneca);
            registrar.setCiaBrazo(ciaBrazo);
            registrar.setBiotipo(biotipo);
            registrar.setAntecedenteObesidad(antecedenteObesidad);
            registrar.setAntecedenteCardiopatias(antecedenteCardiopatias);
            registrar.setAntecedenteHta(antecedenteHta);
            registrar.setAntecedenteDiabetes(antecedenteDiabetes);
            registrar.setMedicacion(medicacion);
            registrar.setDiagnosticoMedico(diagnosticoMedico);
            registrar.setDiagnosticoNutricional(diagnosticoNutricional);
            registrar.setLaboratorioGlicemiaBasal(laboratorioGlicemiaBasal);
            registrar.setLaboratorioCreatinina(laboratorioCreatinina);
            registrar.setLaboratorioProteinasTotales(laboratorioProteinasTotales);
            registrar.setLaboratorioUrea(laboratorioUrea);
            registrar.setLaboratorioAcidoUrico(laboratorioAcidoUrico);
            registrar.setLaboratorioProteinuria(laboratorioProteinuria);
            registrar.setLaboratorioAlbumina(laboratorioAlbumina);
            registrar.setLaboratorioTriglicerios(laboratorioTriglicerios);
            registrar.setLaboratorioColesterolTotal(laboratorioColesterolTotal);
            registrar.setLaboratorioLdl(laboratorioLdl);
            registrar.setLaboratorioHdl(laboratorioHdl);
            registrar.setLaboratorioGlucosa(laboratorioGlucosa);
            registrar.setLaboratorioHb(laboratorioHb);
            registrar.setLaboratorioHematocrito(laboratorioHematocrito);
            registrar.setLaboratorioGlobulosRojos(laboratorioGlobulosRojos);
            registrar.setLaboratorioPotasio(laboratorioPotasio);
            registrar.setLaboratorioCi(laboratorioCi);
            registrar.setLaboratorioNa(laboratorioNa);
            registrar.setLaboratorioGlobulosBlancos(laboratorioGlobulosBlancos);
            registrar.setLaboratorioHba(laboratorioHba);
            registrar.setCiaCintura1(ciaCintura1);
            registrar.setCiaCintura2(ciaCintura2);
            manager.registrarPaciente(registrar);
        } catch (Exception e) {
            System.err.println("ERROR AL REGISTRAR PACIENTE: " + e.getMessage());
        }
        vaciarDatos();
        return "dietas";
    }

    public void changeListenerCalculos() {
        meters = (double) talla / 100;
        System.out.println("changeListenerCalculos talla (cm): " + talla + " (m): " + meters + " sexo: " + sexo);
        if ((pesoActual != 0) && (ciaMuneca != 0) && (talla != 0) && (edad != 0) && (sexo != null)) {
            System.out.println("changeListenerCalculos pesoActual: " + pesoActual + " ciaMuneca: " + ciaMuneca + " edad: " + edad);
            imc = (pesoActual / (Math.pow(meters, 2)));
            calcularTipoImc();
            calcularBiotipo();
            calcularPesoIdeal();
            calcularPesoAjustado();
            calcularPorcentajePesoIdeal();
            pesoSaludable = pesoIdeal;
        }
    }

    public void changeListenerFechaNacimiento() {
        edad = 0;
        Instant instant = Instant.ofEpochMilli(fechaNacimiento.getTime());
        int edadRecuperada = cambiarEdad(instant);
        if (edadRecuperada != 0) {
            edad = edadRecuperada;
            //calcularPesoIdeal();
        }
        System.out.println("Calculada: " + edad);
    }

    private void calcularTipoImc() {
        String tipo;
        if (imc < 18.5) {
            tipo = "Delgadez";
        } else if ((imc >= 18.5) && (imc <= 24.9)) {
            tipo = "Normal o sano";
        } else if ((imc >= 25) && (imc <= 29.9)) {
            tipo = "Sobrepeso";
        } else if ((imc >= 30) && (imc <= 34.9)) {
            tipo = "Obesidad Grado I";
        } else if ((imc >= 35) && (imc <= 39.9)) {
            tipo = "Obesidad Grado II";
        } else if (imc >= 40) {
            tipo = "Obesidad morbida";
        } else {
            tipo = " ";
        }
        imcTipo = tipo;
        System.out.println("calcularTipoImc " + imcTipo);

    }

    public void calcularBiotipo() {
        String contextura = "no calculada (Menor a 25 años)";
        if (edad >= 25) {
            System.out.println("entro al if de mayor a 25");
            double biotipoCalculado;
            biotipoCalculado = (talla / ciaMuneca);
            /*M: Hombre F: Mujer*/
            switch (sexo) {
                case "M":
                    contextura = calculoContexturaHombre(biotipoCalculado);
                    break;
                case "F":
                    contextura = calculoContexturaMujer(biotipoCalculado);
                    break;
                default:
                    contextura = "no calculada.";
                    break;
            }
        }
        String retorno = contextura;
        biotipo = retorno;
    }

    private String calculoContexturaHombre(double biotipoParametro) {
        String contexturaCalculada = null;
        System.out.println("entro al if de Masculino");
        if (biotipoParametro > 0) {
            if (biotipoParametro > 10.4) {
                contexturaCalculada = "Pequeña";
            } else if (biotipoParametro > 9.6 && biotipoParametro <= 10.4) {
                contexturaCalculada = "Mediana";
            } else if (biotipoParametro < 9.6) {
                contexturaCalculada = "Grande";
            }
        } else {
            contexturaCalculada = "Sin calcular";
        }
        return contexturaCalculada;
    }

    private String calculoContexturaMujer(double biotipoParametro) {
        String contexturaCalculada = null;
        System.out.println("entro al if de Femenino");
        if (biotipoParametro > 0) {
            if (biotipoParametro > 11) {
                contexturaCalculada = "Pequeña";
            } else if (biotipoParametro >= 10.1 && biotipoParametro <= 11) {
                contexturaCalculada = "Mediana";
            } else if (biotipoParametro < 10.1) {
                contexturaCalculada = "Grande";
            }
        } else {
            contexturaCalculada = "Sin calcular";
        }
        return contexturaCalculada;
    }

    private int cambiarEdad(Instant instant) {
        int edadCalculada = 0;
        LocalDate birthDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        System.out.println("birthDate: " + birthDate.toString());
        System.out.println("currentDate: " + currentDate.toString());

        if ((fechaNacimiento != null) && (currentDate != null)) {
            edadCalculada = Period.between(birthDate, currentDate).getYears();
            System.out.println("edad: " + edad);
        }
        return edadCalculada;
    }

    private void calcularPesoAjustado() {
        if ((pesoActual != 0) && (pesoIdeal != 0)) {
            pesoAjusta = (pesoActual - pesoIdeal) * 0.25 + pesoIdeal;
            System.out.println("calcularPesoAjustado datos entrada - peso actual: " + pesoActual + " peso ideal: " + pesoIdeal + " peso ajustado: " + pesoAjusta);
        
        }
    }

    private void calcularPesoIdeal() {
        System.out.println("calcularPesoIdeal datos entrada - edad: " + edad + " talla: " + talla + " cia. munheca: " + ciaMuneca + " sexo: " + sexo + " biotipo: " + biotipo);
        if (edad != 0 && sexo != null && talla != 0 && biotipo != null) {
            pesoIdeal = manager.calcularPI(edad, sexo, talla, biotipo);
        }
    }

    private void calcularPorcentajePesoIdeal() {
        System.out.println("calcularPorcentajePesoIdeal datos entrada - peso actual: " + pesoActual + " peso ideal: " + pesoIdeal);
        if ((pesoActual != 0) && (pesoIdeal != 0)) {
            porcentajePesoIdeal = (pesoActual / pesoIdeal) * 100;
            porcentajePesoIdealTipo = calcularTipoPorcentajePI();
        }
    }

    private String calcularTipoPorcentajePI() {
        System.out.println("calcularPorcentajePesoIdeal datos entrada - porcentaje peso ideal: " + porcentajePesoIdeal);
        String retorno = "No calculado";
        if (porcentajePesoIdeal > 180) {
            retorno = "Obesidad morbida";
        } else if (porcentajePesoIdeal >= 140 && porcentajePesoIdeal <= 179) {
            retorno = "Obesidad II";
        } else if (porcentajePesoIdeal >= 120 && porcentajePesoIdeal <= 139) {
            retorno = "Obesidad I";
        } else if (porcentajePesoIdeal >= 110 && porcentajePesoIdeal <= 119) {
            retorno = "Sobrepeso";
        } else if (porcentajePesoIdeal >= 90 && porcentajePesoIdeal <= 109) {
            retorno = "Normal";
        } else if (porcentajePesoIdeal >= 84 && porcentajePesoIdeal <= 89) {
            retorno = "Desnutricion leve";
        } else if (porcentajePesoIdeal >= 75 && porcentajePesoIdeal <= 84) {
            retorno = "Desnutricion moderada";
        } else if (porcentajePesoIdeal < 75) {
            retorno = "Desnutricion severa";
        }
        return retorno;
    }

    public String vaciarDatos() {
        nombre = null;
        apellido = null;
        sexo = "M";
        talla = 0;
        meters = 0;
        estadoCivil = null;
        fechaNacimiento = null;
        pesoActual = 0;
        pesoHabitual = 0;
        pesoAjusta = 0;
        pesoSaludable = 0;
        porcentajePesoIdeal = 0;
        imc = 0;
        imcTipo = null;
        porcentajePesoIdealTipo = null;
        ciaMuneca = 0;
        ciaBrazo = 0;
        biotipo = null;
        antecedenteObesidad = false;
        antecedenteCardiopatias = false;
        antecedenteHta = false;
        antecedenteDiabetes = false;
        medicacion = null;
        diagnosticoMedico = null;
        diagnosticoNutricional = null;
        laboratorioGlicemiaBasal = 0;
        laboratorioCreatinina = 0;
        laboratorioProteinasTotales = 0;
        laboratorioUrea = 0;
        laboratorioAcidoUrico = 0;
        laboratorioProteinuria = 0;
        laboratorioAlbumina = 0;
        laboratorioTriglicerios = 0;
        laboratorioColesterolTotal = 0;
        laboratorioLdl = 0;
        laboratorioHdl = 0;
        laboratorioGlucosa = 0;
        laboratorioHb = 0;
        laboratorioHematocrito = 0;
        laboratorioGlobulosRojos = 0;
        laboratorioPotasio = 0;
        laboratorioCi = 0;
        laboratorioNa = 0;
        laboratorioGlobulosBlancos = 0;
        laboratorioHba = 0;
        edad = 0;
        pesoIdeal = 0;
        ciaCintura1 = 0;
        ciaCintura2 = 0;
        return null;
    }
}
