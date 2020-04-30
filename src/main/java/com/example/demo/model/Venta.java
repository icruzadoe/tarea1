package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_persona"))
    private Persona persona;

    @Column(name = "importe", nullable = false)
    private Double importe;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
}
