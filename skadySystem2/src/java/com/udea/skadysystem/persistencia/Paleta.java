package com.udea.skadysystem.persistencia;
// Generated 4/06/2017 08:00:08 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Paleta generated by hbm2java
 */
@Entity
@Table(name="paleta"
    ,catalog="skady"
)
public class Paleta  implements java.io.Serializable {


     private Integer codigo;
     private String nombre;
     private int tipoPaleta;
     private double precio;

    public Paleta() {
    }

    public Paleta(String nombre, int tipoPaleta, double precio) {
       this.nombre = nombre;
       this.tipoPaleta = tipoPaleta;
       this.precio = precio;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="CODIGO", unique=true, nullable=false)
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    
    @Column(name="NOMBRE", nullable=false, length=20)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="TIPO_PALETA", nullable=false)
    public int getTipoPaleta() {
        return this.tipoPaleta;
    }
    
    public void setTipoPaleta(int tipoPaleta) {
        this.tipoPaleta = tipoPaleta;
    }

    
    @Column(name="PRECIO", nullable=false, precision=22, scale=0)
    public double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }




}


