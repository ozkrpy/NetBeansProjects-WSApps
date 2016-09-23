/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ozkrp
 */
@Entity
@Table(name = "peso_ideal")
@NamedQueries({
    @NamedQuery(name = "PesoIdeal.findAll", query = "SELECT p FROM PesoIdeal p"),
    @NamedQuery(name = "PesoIdeal.findByTallaCm", query = "SELECT p FROM PesoIdeal p WHERE p.tallaCm = :tallaCm"),
    @NamedQuery(name = "PesoIdeal.findByEdad1516", query = "SELECT p FROM PesoIdeal p WHERE p.edad1516 = :edad1516"),
    @NamedQuery(name = "PesoIdeal.findByEdad1719", query = "SELECT p FROM PesoIdeal p WHERE p.edad1719 = :edad1719"),
    @NamedQuery(name = "PesoIdeal.findByEdad2024", query = "SELECT p FROM PesoIdeal p WHERE p.edad2024 = :edad2024"),
    @NamedQuery(name = "PesoIdeal.findByEdad2529", query = "SELECT p FROM PesoIdeal p WHERE p.edad2529 = :edad2529"),
    @NamedQuery(name = "PesoIdeal.findByEdad3039", query = "SELECT p FROM PesoIdeal p WHERE p.edad3039 = :edad3039"),
    @NamedQuery(name = "PesoIdeal.findByEdad4049", query = "SELECT p FROM PesoIdeal p WHERE p.edad4049 = :edad4049"),
    @NamedQuery(name = "PesoIdeal.findByEdad5059", query = "SELECT p FROM PesoIdeal p WHERE p.edad5059 = :edad5059"),
    @NamedQuery(name = "PesoIdeal.findByEdad6069", query = "SELECT p FROM PesoIdeal p WHERE p.edad6069 = :edad6069"),
    @NamedQuery(name = "PesoIdeal.findByContexturaPequenaIni", query = "SELECT p FROM PesoIdeal p WHERE p.contexturaPequenaIni = :contexturaPequenaIni"),
    @NamedQuery(name = "PesoIdeal.findByContexturaPequenaFin", query = "SELECT p FROM PesoIdeal p WHERE p.contexturaPequenaFin = :contexturaPequenaFin"),
    @NamedQuery(name = "PesoIdeal.findByContexturaMedianaIni", query = "SELECT p FROM PesoIdeal p WHERE p.contexturaMedianaIni = :contexturaMedianaIni"),
    @NamedQuery(name = "PesoIdeal.findByContexturaMedianaFin", query = "SELECT p FROM PesoIdeal p WHERE p.contexturaMedianaFin = :contexturaMedianaFin"),
    @NamedQuery(name = "PesoIdeal.findByContexturaGrandeIni", query = "SELECT p FROM PesoIdeal p WHERE p.contexturaGrandeIni = :contexturaGrandeIni"),
    @NamedQuery(name = "PesoIdeal.findByContexturaGrandeFin", query = "SELECT p FROM PesoIdeal p WHERE p.contexturaGrandeFin = :contexturaGrandeFin"),
    @NamedQuery(name = "PesoIdeal.findBySexo", query = "SELECT p FROM PesoIdeal p WHERE p.sexo = :sexo")})
public class PesoIdeal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "talla_cm")
    private Integer tallaCm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad15_16")
    private double edad1516;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad17_19")
    private double edad1719;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad20_24")
    private double edad2024;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad25_29")
    private double edad2529;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad30_39")
    private double edad3039;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad40_49")
    private double edad4049;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad50_59")
    private double edad5059;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad60_69")
    private double edad6069;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contextura_pequena_ini")
    private double contexturaPequenaIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contextura_pequena_fin")
    private double contexturaPequenaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contextura_mediana_ini")
    private double contexturaMedianaIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contextura_mediana_fin")
    private double contexturaMedianaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contextura_grande_ini")
    private double contexturaGrandeIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contextura_grande_fin")
    private double contexturaGrandeFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "sexo")
    private String sexo;

    public PesoIdeal() {
    }

    public PesoIdeal(Integer tallaCm) {
        this.tallaCm = tallaCm;
    }

    public PesoIdeal(Integer tallaCm, double edad1516, double edad1719, double edad2024, double edad2529, double edad3039, double edad4049, double edad5059, double edad6069, double contexturaPequenaIni, double contexturaPequenaFin, double contexturaMedianaIni, double contexturaMedianaFin, double contexturaGrandeIni, double contexturaGrandeFin, String sexo) {
        this.tallaCm = tallaCm;
        this.edad1516 = edad1516;
        this.edad1719 = edad1719;
        this.edad2024 = edad2024;
        this.edad2529 = edad2529;
        this.edad3039 = edad3039;
        this.edad4049 = edad4049;
        this.edad5059 = edad5059;
        this.edad6069 = edad6069;
        this.contexturaPequenaIni = contexturaPequenaIni;
        this.contexturaPequenaFin = contexturaPequenaFin;
        this.contexturaMedianaIni = contexturaMedianaIni;
        this.contexturaMedianaFin = contexturaMedianaFin;
        this.contexturaGrandeIni = contexturaGrandeIni;
        this.contexturaGrandeFin = contexturaGrandeFin;
        this.sexo = sexo;
    }

    public Integer getTallaCm() {
        return tallaCm;
    }

    public void setTallaCm(Integer tallaCm) {
        this.tallaCm = tallaCm;
    }

    public double getEdad1516() {
        return edad1516;
    }

    public void setEdad1516(double edad1516) {
        this.edad1516 = edad1516;
    }

    public double getEdad1719() {
        return edad1719;
    }

    public void setEdad1719(double edad1719) {
        this.edad1719 = edad1719;
    }

    public double getEdad2024() {
        return edad2024;
    }

    public void setEdad2024(double edad2024) {
        this.edad2024 = edad2024;
    }

    public double getEdad2529() {
        return edad2529;
    }

    public void setEdad2529(double edad2529) {
        this.edad2529 = edad2529;
    }

    public double getEdad3039() {
        return edad3039;
    }

    public void setEdad3039(double edad3039) {
        this.edad3039 = edad3039;
    }

    public double getEdad4049() {
        return edad4049;
    }

    public void setEdad4049(double edad4049) {
        this.edad4049 = edad4049;
    }

    public double getEdad5059() {
        return edad5059;
    }

    public void setEdad5059(double edad5059) {
        this.edad5059 = edad5059;
    }

    public double getEdad6069() {
        return edad6069;
    }

    public void setEdad6069(double edad6069) {
        this.edad6069 = edad6069;
    }

    public double getContexturaPequenaIni() {
        return contexturaPequenaIni;
    }

    public void setContexturaPequenaIni(double contexturaPequenaIni) {
        this.contexturaPequenaIni = contexturaPequenaIni;
    }

    public double getContexturaPequenaFin() {
        return contexturaPequenaFin;
    }

    public void setContexturaPequenaFin(double contexturaPequenaFin) {
        this.contexturaPequenaFin = contexturaPequenaFin;
    }

    public double getContexturaMedianaIni() {
        return contexturaMedianaIni;
    }

    public void setContexturaMedianaIni(double contexturaMedianaIni) {
        this.contexturaMedianaIni = contexturaMedianaIni;
    }

    public double getContexturaMedianaFin() {
        return contexturaMedianaFin;
    }

    public void setContexturaMedianaFin(double contexturaMedianaFin) {
        this.contexturaMedianaFin = contexturaMedianaFin;
    }

    public double getContexturaGrandeIni() {
        return contexturaGrandeIni;
    }

    public void setContexturaGrandeIni(double contexturaGrandeIni) {
        this.contexturaGrandeIni = contexturaGrandeIni;
    }

    public double getContexturaGrandeFin() {
        return contexturaGrandeFin;
    }

    public void setContexturaGrandeFin(double contexturaGrandeFin) {
        this.contexturaGrandeFin = contexturaGrandeFin;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tallaCm != null ? tallaCm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PesoIdeal)) {
            return false;
        }
        PesoIdeal other = (PesoIdeal) object;
        if ((this.tallaCm == null && other.tallaCm != null) || (this.tallaCm != null && !this.tallaCm.equals(other.tallaCm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PesoIdeal[ tallaCm=" + tallaCm + " ]";
    }
    
}
