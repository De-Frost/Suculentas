package com.practica01.practica01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "suculenta")
public class Suculenta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suculenta")
    private Integer idSuculenta;

    @Column(name = "nombre_comun", nullable = false, length = 50)
    private String nombreComun;

    @Column(name = "nombre_cientifico", nullable = false, length = 80)
    private String nombreCientifico;

    @Column(nullable = false, length = 50)
    private String familia;

    @Column(name = "color_principal", nullable = false, length = 30)
    private String colorPrincipal;

    @Column(name = "altura_cm", nullable = false, precision = 5, scale = 2)
    private BigDecimal alturaCm;

    @Column(name = "precio_estimado", nullable = false, precision = 8, scale = 2)
    private BigDecimal precioEstimado;

    @Column(name = "nivel_riego", nullable = false, length = 20)
    private String nivelRiego;

    @Column(name = "ruta_imagen", length = 500)
    private String rutaImagen;
}