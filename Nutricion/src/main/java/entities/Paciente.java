/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ozkrp
 */
@Entity
@Table(name = "paciente")
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.getMaxCodigoPaciente", query = "SELECT MAX(p.codigoPaciente) FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByCodigoPaciente", query = "SELECT p FROM Paciente p WHERE p.codigoPaciente = :codigoPaciente"),
    @NamedQuery(name = "Paciente.findByNombre", query = "SELECT p FROM Paciente p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Paciente.findByApellido", query = "SELECT p FROM Paciente p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Paciente.findBySexo", query = "SELECT p FROM Paciente p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Paciente.findByTalla", query = "SELECT p FROM Paciente p WHERE p.talla = :talla"),
    @NamedQuery(name = "Paciente.findByEstadoCivil", query = "SELECT p FROM Paciente p WHERE p.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Paciente.findByFechaNacimiento", query = "SELECT p FROM Paciente p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Paciente.findByPesoActual", query = "SELECT p FROM Paciente p WHERE p.pesoActual = :pesoActual"),
    @NamedQuery(name = "Paciente.findByPesoHabitual", query = "SELECT p FROM Paciente p WHERE p.pesoHabitual = :pesoHabitual"),
    @NamedQuery(name = "Paciente.findByPesoAjusta", query = "SELECT p FROM Paciente p WHERE p.pesoAjusta = :pesoAjusta"),
    @NamedQuery(name = "Paciente.findByPesoSaludable", query = "SELECT p FROM Paciente p WHERE p.pesoSaludable = :pesoSaludable"),
    @NamedQuery(name = "Paciente.findByPorcentajePesoIdeal", query = "SELECT p FROM Paciente p WHERE p.porcentajePesoIdeal = :porcentajePesoIdeal"),
    @NamedQuery(name = "Paciente.findByImc", query = "SELECT p FROM Paciente p WHERE p.imc = :imc"),
    @NamedQuery(name = "Paciente.findByCiaMuneca", query = "SELECT p FROM Paciente p WHERE p.ciaMuneca = :ciaMuneca"),
    @NamedQuery(name = "Paciente.findByCiaBrazo", query = "SELECT p FROM Paciente p WHERE p.ciaBrazo = :ciaBrazo"),
    @NamedQuery(name = "Paciente.findByBiotipo", query = "SELECT p FROM Paciente p WHERE p.biotipo = :biotipo"),
    @NamedQuery(name = "Paciente.findByAntecedenteObesidad", query = "SELECT p FROM Paciente p WHERE p.antecedenteObesidad = :antecedenteObesidad"),
    @NamedQuery(name = "Paciente.findByAntecedenteCardiopatias", query = "SELECT p FROM Paciente p WHERE p.antecedenteCardiopatias = :antecedenteCardiopatias"),
    @NamedQuery(name = "Paciente.findByAntecedenteHta", query = "SELECT p FROM Paciente p WHERE p.antecedenteHta = :antecedenteHta"),
    @NamedQuery(name = "Paciente.findByAntecedenteDiabetes", query = "SELECT p FROM Paciente p WHERE p.antecedenteDiabetes = :antecedenteDiabetes"),
    @NamedQuery(name = "Paciente.findByMedicacion", query = "SELECT p FROM Paciente p WHERE p.medicacion = :medicacion"),
    @NamedQuery(name = "Paciente.findByDiagnosticoMedico", query = "SELECT p FROM Paciente p WHERE p.diagnosticoMedico = :diagnosticoMedico"),
    @NamedQuery(name = "Paciente.findByDiagnosticoNutricional", query = "SELECT p FROM Paciente p WHERE p.diagnosticoNutricional = :diagnosticoNutricional"),
    @NamedQuery(name = "Paciente.findByLaboratorioGlicemiaBasal", query = "SELECT p FROM Paciente p WHERE p.laboratorioGlicemiaBasal = :laboratorioGlicemiaBasal"),
    @NamedQuery(name = "Paciente.findByLaboratorioCreatinina", query = "SELECT p FROM Paciente p WHERE p.laboratorioCreatinina = :laboratorioCreatinina"),
    @NamedQuery(name = "Paciente.findByLaboratorioProteinasTotales", query = "SELECT p FROM Paciente p WHERE p.laboratorioProteinasTotales = :laboratorioProteinasTotales"),
    @NamedQuery(name = "Paciente.findByLaboratorioUrea", query = "SELECT p FROM Paciente p WHERE p.laboratorioUrea = :laboratorioUrea"),
    @NamedQuery(name = "Paciente.findByLaboratorioAcidoUrico", query = "SELECT p FROM Paciente p WHERE p.laboratorioAcidoUrico = :laboratorioAcidoUrico"),
    @NamedQuery(name = "Paciente.findByLaboratorioProteinuria", query = "SELECT p FROM Paciente p WHERE p.laboratorioProteinuria = :laboratorioProteinuria"),
    @NamedQuery(name = "Paciente.findByLaboratorioAlbumina", query = "SELECT p FROM Paciente p WHERE p.laboratorioAlbumina = :laboratorioAlbumina"),
    @NamedQuery(name = "Paciente.findByLaboratorioTriglicerios", query = "SELECT p FROM Paciente p WHERE p.laboratorioTriglicerios = :laboratorioTriglicerios"),
    @NamedQuery(name = "Paciente.findByLaboratorioColesterolTotal", query = "SELECT p FROM Paciente p WHERE p.laboratorioColesterolTotal = :laboratorioColesterolTotal"),
    @NamedQuery(name = "Paciente.findByLaboratorioLdl", query = "SELECT p FROM Paciente p WHERE p.laboratorioLdl = :laboratorioLdl"),
    @NamedQuery(name = "Paciente.findByLaboratorioHdl", query = "SELECT p FROM Paciente p WHERE p.laboratorioHdl = :laboratorioHdl"),
    @NamedQuery(name = "Paciente.findByLaboratorioGlucosa", query = "SELECT p FROM Paciente p WHERE p.laboratorioGlucosa = :laboratorioGlucosa"),
    @NamedQuery(name = "Paciente.findByLaboratorioHb", query = "SELECT p FROM Paciente p WHERE p.laboratorioHb = :laboratorioHb"),
    @NamedQuery(name = "Paciente.findByLaboratorioHematocrito", query = "SELECT p FROM Paciente p WHERE p.laboratorioHematocrito = :laboratorioHematocrito"),
    @NamedQuery(name = "Paciente.findByLaboratorioGlobulosRojos", query = "SELECT p FROM Paciente p WHERE p.laboratorioGlobulosRojos = :laboratorioGlobulosRojos"),
    @NamedQuery(name = "Paciente.findByLaboratorioPotasio", query = "SELECT p FROM Paciente p WHERE p.laboratorioPotasio = :laboratorioPotasio"),
    @NamedQuery(name = "Paciente.findByLaboratorioCi", query = "SELECT p FROM Paciente p WHERE p.laboratorioCi = :laboratorioCi"),
    @NamedQuery(name = "Paciente.findByLaboratorioNa", query = "SELECT p FROM Paciente p WHERE p.laboratorioNa = :laboratorioNa"),
    @NamedQuery(name = "Paciente.findByLaboratorioGlobulosBlancos", query = "SELECT p FROM Paciente p WHERE p.laboratorioGlobulosBlancos = :laboratorioGlobulosBlancos"),
    @NamedQuery(name = "Paciente.findByLaboratorioHba", query = "SELECT p FROM Paciente p WHERE p.laboratorioHba = :laboratorioHba")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_paciente")
    private Integer codigoPaciente;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "talla")
    private Integer talla;
    @Size(max = 45)
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso_actual")
    private Double pesoActual;
    @Column(name = "peso_habitual")
    private Double pesoHabitual;
    @Column(name = "peso_ajusta")
    private Double pesoAjusta;
    @Column(name = "peso_saludable")
    private Double pesoSaludable;
    @Column(name = "porcentaje_peso_ideal")
    private Double porcentajePesoIdeal;
    @Column(name = "imc")
    private Double imc;
    @Column(name = "cia_muneca")
    private Double ciaMuneca;
    @Column(name = "cia_brazo")
    private Double ciaBrazo;
    @Size(max = 45)
    @Column(name = "biotipo")
    private String biotipo;
    @Column(name = "antecedente_obesidad")
    private Boolean antecedenteObesidad;
    @Column(name = "antecedente_cardiopatias")
    private Boolean antecedenteCardiopatias;
    @Column(name = "antecedente_hta")
    private Boolean antecedenteHta;
    @Column(name = "antecedente_diabetes")
    private Boolean antecedenteDiabetes;
    @Size(max = 500)
    @Column(name = "medicacion")
    private String medicacion;
    @Size(max = 500)
    @Column(name = "diagnostico_medico")
    private String diagnosticoMedico;
    @Size(max = 500)
    @Column(name = "diagnostico_nutricional")
    private String diagnosticoNutricional;
    @Column(name = "laboratorio_glicemia_basal")
    private Double laboratorioGlicemiaBasal;
    @Column(name = "laboratorio_creatinina")
    private Double laboratorioCreatinina;
    @Column(name = "laboratorio_proteinas_totales")
    private Double laboratorioProteinasTotales;
    @Column(name = "laboratorio_urea")
    private Double laboratorioUrea;
    @Column(name = "laboratorio_acido_urico")
    private Double laboratorioAcidoUrico;
    @Column(name = "laboratorio_proteinuria")
    private Double laboratorioProteinuria;
    @Column(name = "laboratorio_albumina")
    private Double laboratorioAlbumina;
    @Column(name = "laboratorio_triglicerios")
    private Double laboratorioTriglicerios;
    @Column(name = "laboratorio_colesterol_total")
    private Double laboratorioColesterolTotal;
    @Column(name = "laboratorio_ldl")
    private Double laboratorioLdl;
    @Column(name = "laboratorio_hdl")
    private Double laboratorioHdl;
    @Column(name = "laboratorio_glucosa")
    private Double laboratorioGlucosa;
    @Column(name = "laboratorio_hb")
    private Double laboratorioHb;
    @Column(name = "laboratorio_hematocrito")
    private Double laboratorioHematocrito;
    @Column(name = "laboratorio_globulos_rojos")
    private Double laboratorioGlobulosRojos;
    @Column(name = "laboratorio_potasio")
    private Double laboratorioPotasio;
    @Column(name = "laboratorio_ci")
    private Double laboratorioCi;
    @Column(name = "laboratorio_na")
    private Double laboratorioNa;
    @Column(name = "laboratorio_globulos_blancos")
    private Double laboratorioGlobulosBlancos;
    @Column(name = "laboratorio_hba")
    private Double laboratorioHba;
    @Column(name = "cia_cintura1")
    private Double ciaCintura1;
    @Column(name = "cia_cintura2")
    private Double ciaCintura2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPaciente")
    private List<Dieta> dietaList;

    public Paciente() {
    }

    public Paciente(Integer codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public Integer getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Integer codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
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

    public Double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public Double getPesoHabitual() {
        return pesoHabitual;
    }

    public void setPesoHabitual(Double pesoHabitual) {
        this.pesoHabitual = pesoHabitual;
    }

    public Double getPesoAjusta() {
        return pesoAjusta;
    }

    public void setPesoAjusta(Double pesoAjusta) {
        this.pesoAjusta = pesoAjusta;
    }

    public Double getPesoSaludable() {
        return pesoSaludable;
    }

    public void setPesoSaludable(Double pesoSaludable) {
        this.pesoSaludable = pesoSaludable;
    }

    public Double getPorcentajePesoIdeal() {
        return porcentajePesoIdeal;
    }

    public void setPorcentajePesoIdeal(Double porcentajePesoIdeal) {
        this.porcentajePesoIdeal = porcentajePesoIdeal;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public Double getCiaMuneca() {
        return ciaMuneca;
    }

    public void setCiaMuneca(Double ciaMuneca) {
        this.ciaMuneca = ciaMuneca;
    }

    public Double getCiaBrazo() {
        return ciaBrazo;
    }

    public void setCiaBrazo(Double ciaBrazo) {
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

    public Double getLaboratorioGlicemiaBasal() {
        return laboratorioGlicemiaBasal;
    }

    public void setLaboratorioGlicemiaBasal(Double laboratorioGlicemiaBasal) {
        this.laboratorioGlicemiaBasal = laboratorioGlicemiaBasal;
    }

    public Double getLaboratorioCreatinina() {
        return laboratorioCreatinina;
    }

    public void setLaboratorioCreatinina(Double laboratorioCreatinina) {
        this.laboratorioCreatinina = laboratorioCreatinina;
    }

    public Double getLaboratorioProteinasTotales() {
        return laboratorioProteinasTotales;
    }

    public void setLaboratorioProteinasTotales(Double laboratorioProteinasTotales) {
        this.laboratorioProteinasTotales = laboratorioProteinasTotales;
    }

    public Double getLaboratorioUrea() {
        return laboratorioUrea;
    }

    public void setLaboratorioUrea(Double laboratorioUrea) {
        this.laboratorioUrea = laboratorioUrea;
    }

    public Double getLaboratorioAcidoUrico() {
        return laboratorioAcidoUrico;
    }

    public void setLaboratorioAcidoUrico(Double laboratorioAcidoUrico) {
        this.laboratorioAcidoUrico = laboratorioAcidoUrico;
    }

    public Double getLaboratorioProteinuria() {
        return laboratorioProteinuria;
    }

    public void setLaboratorioProteinuria(Double laboratorioProteinuria) {
        this.laboratorioProteinuria = laboratorioProteinuria;
    }

    public Double getLaboratorioAlbumina() {
        return laboratorioAlbumina;
    }

    public void setLaboratorioAlbumina(Double laboratorioAlbumina) {
        this.laboratorioAlbumina = laboratorioAlbumina;
    }

    public Double getLaboratorioTriglicerios() {
        return laboratorioTriglicerios;
    }

    public void setLaboratorioTriglicerios(Double laboratorioTriglicerios) {
        this.laboratorioTriglicerios = laboratorioTriglicerios;
    }

    public Double getLaboratorioColesterolTotal() {
        return laboratorioColesterolTotal;
    }

    public void setLaboratorioColesterolTotal(Double laboratorioColesterolTotal) {
        this.laboratorioColesterolTotal = laboratorioColesterolTotal;
    }

    public Double getLaboratorioLdl() {
        return laboratorioLdl;
    }

    public void setLaboratorioLdl(Double laboratorioLdl) {
        this.laboratorioLdl = laboratorioLdl;
    }

    public Double getLaboratorioHdl() {
        return laboratorioHdl;
    }

    public void setLaboratorioHdl(Double laboratorioHdl) {
        this.laboratorioHdl = laboratorioHdl;
    }

    public Double getLaboratorioGlucosa() {
        return laboratorioGlucosa;
    }

    public void setLaboratorioGlucosa(Double laboratorioGlucosa) {
        this.laboratorioGlucosa = laboratorioGlucosa;
    }

    public Double getLaboratorioHb() {
        return laboratorioHb;
    }

    public void setLaboratorioHb(Double laboratorioHb) {
        this.laboratorioHb = laboratorioHb;
    }

    public Double getLaboratorioHematocrito() {
        return laboratorioHematocrito;
    }

    public void setLaboratorioHematocrito(Double laboratorioHematocrito) {
        this.laboratorioHematocrito = laboratorioHematocrito;
    }

    public Double getLaboratorioGlobulosRojos() {
        return laboratorioGlobulosRojos;
    }

    public void setLaboratorioGlobulosRojos(Double laboratorioGlobulosRojos) {
        this.laboratorioGlobulosRojos = laboratorioGlobulosRojos;
    }

    public Double getLaboratorioPotasio() {
        return laboratorioPotasio;
    }

    public void setLaboratorioPotasio(Double laboratorioPotasio) {
        this.laboratorioPotasio = laboratorioPotasio;
    }

    public Double getLaboratorioCi() {
        return laboratorioCi;
    }

    public void setLaboratorioCi(Double laboratorioCi) {
        this.laboratorioCi = laboratorioCi;
    }

    public Double getLaboratorioNa() {
        return laboratorioNa;
    }

    public void setLaboratorioNa(Double laboratorioNa) {
        this.laboratorioNa = laboratorioNa;
    }

    public Double getLaboratorioGlobulosBlancos() {
        return laboratorioGlobulosBlancos;
    }

    public void setLaboratorioGlobulosBlancos(Double laboratorioGlobulosBlancos) {
        this.laboratorioGlobulosBlancos = laboratorioGlobulosBlancos;
    }

    public Double getLaboratorioHba() {
        return laboratorioHba;
    }

    public void setLaboratorioHba(Double laboratorioHba) {
        this.laboratorioHba = laboratorioHba;
    }

    public Double getCiaCintura1() {
        return ciaCintura1;
    }

    public void setCiaCintura1(Double ciaCintura1) {
        this.ciaCintura1 = ciaCintura1;
    }

    public Double getCiaCintura2() {
        return ciaCintura2;
    }

    public void setCiaCintura2(Double ciaCintura2) {
        this.ciaCintura2 = ciaCintura2;
    }

    public List<Dieta> getDietaList() {
        return dietaList;
    }

    public void setDietaList(List<Dieta> dietaList) {
        this.dietaList = dietaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPaciente != null ? codigoPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.codigoPaciente == null && other.codigoPaciente != null) || (this.codigoPaciente != null && !this.codigoPaciente.equals(other.codigoPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Paciente[ codigoPaciente=" + codigoPaciente + " ]";
    }
    
}
