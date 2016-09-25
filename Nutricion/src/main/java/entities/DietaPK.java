/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ozkrp
 */
@Embeddable
public class DietaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_dieta")
    private int codigoDieta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_alimento")
    private int codigoAlimento;

    public DietaPK() {
    }

    public DietaPK(int codigoDieta, int codigoAlimento) {
        this.codigoDieta = codigoDieta;
        this.codigoAlimento = codigoAlimento;
    }

    public int getCodigoDieta() {
        return codigoDieta;
    }

    public void setCodigoDieta(int codigoDieta) {
        this.codigoDieta = codigoDieta;
    }

    public int getCodigoAlimento() {
        return codigoAlimento;
    }

    public void setCodigoAlimento(int codigoAlimento) {
        this.codigoAlimento = codigoAlimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoDieta;
        hash += (int) codigoAlimento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DietaPK)) {
            return false;
        }
        DietaPK other = (DietaPK) object;
        if (this.codigoDieta != other.codigoDieta) {
            return false;
        }
        if (this.codigoAlimento != other.codigoAlimento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DietaPK[ codigoDieta=" + codigoDieta + ", codigoAlimento=" + codigoAlimento + " ]";
    }
    
}
