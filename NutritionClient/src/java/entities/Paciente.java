package entities;
// Generated Aug 26, 2016 6:11:56 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Paciente generated by hbm2java
 */
@Entity
@Table(name="paciente"
    ,catalog="nutriciondb"
)
public class Paciente  implements java.io.Serializable {


     private int idpaciente;
     private String nombre;
     private String apellido;
     private Integer edad;
     private String sexo;

    public Paciente() {
    }

	
    public Paciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }
    public Paciente(int idpaciente, String nombre, String apellido, Integer edad, String sexo) {
       this.idpaciente = idpaciente;
       this.nombre = nombre;
       this.apellido = apellido;
       this.edad = edad;
       this.sexo = sexo;
    }
   
     @Id 

    
    @Column(name="idpaciente", unique=true, nullable=false)
    public int getIdpaciente() {
        return this.idpaciente;
    }
    
    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    
    @Column(name="nombre", length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="apellido", length=45)
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    @Column(name="edad")
    public Integer getEdad() {
        return this.edad;
    }
    
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    
    @Column(name="sexo", length=1)
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }




}

