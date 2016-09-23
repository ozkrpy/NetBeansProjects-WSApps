/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ozkrp
 */
@Entity
@Table(name = "dieta")
@NamedQueries({
    @NamedQuery(name = "Dieta.findAll", query = "SELECT d FROM Dieta d"),
    @NamedQuery(name = "Dieta.maxCodigoDieta", query = "SELECT MAX(d.dietaPK.codigoDieta) FROM Dieta d"),
    @NamedQuery(name = "Dieta.findAllCodigoDieta", query = "SELECT DISTINCT(d.dietaPK.codigoDieta) FROM Dieta d ORDER BY d.dietaPK.codigoDieta"),
    @NamedQuery(name = "Dieta.findByCodigoDieta", query = "SELECT d FROM Dieta d WHERE d.dietaPK.codigoDieta = :codigoDieta"),
    @NamedQuery(name = "Dieta.findByCodigoAlimento", query = "SELECT d FROM Dieta d WHERE d.dietaPK.codigoAlimento = :codigoAlimento"),
    @NamedQuery(name = "Dieta.findByCantidadAlimento", query = "SELECT d FROM Dieta d WHERE d.dietaPK.cantidadAlimento = :cantidadAlimento")})
public class Dieta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DietaPK dietaPK;
    @JoinColumn(name = "codigo_alimento", referencedColumnName = "codigo_alimento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alimentos alimentos;
    @JoinColumn(name = "codigo_paciente", referencedColumnName = "codigo_paciente")
    @ManyToOne
    private Paciente codigoPaciente;

    public Dieta() {
    }

    public Dieta(DietaPK dietaPK) {
        this.dietaPK = dietaPK;
    }

    public Dieta(int codigoDieta, int codigoAlimento, int cantidadAlimento) {
        this.dietaPK = new DietaPK(codigoDieta, codigoAlimento, cantidadAlimento);
    }

    public DietaPK getDietaPK() {
        return dietaPK;
    }

    public void setDietaPK(DietaPK dietaPK) {
        this.dietaPK = dietaPK;
    }

    public Alimentos getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(Alimentos alimentos) {
        this.alimentos = alimentos;
    }

    public Paciente getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Paciente codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dietaPK != null ? dietaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dieta)) {
            return false;
        }
        Dieta other = (Dieta) object;
        if ((this.dietaPK == null && other.dietaPK != null) || (this.dietaPK != null && !this.dietaPK.equals(other.dietaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Dieta[ dietaPK=" + dietaPK + " ]";
    }
    
}
