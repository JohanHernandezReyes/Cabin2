package Cabin.Usa.Ciclo3.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name="Reservation")
@Data
public class Reservation implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
     
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechainicio;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaentrega;
    
    @ManyToOne
    @JoinColumn(name="cabin_id")
    @JsonIgnoreProperties("cabinsreservations")
    private Cabin cabin_id; 
           
    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonIgnoreProperties("clientsreservations")
    private Cliente client_id; 
    
       
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="score")
    @JsonIgnoreProperties("score")
    public List<Score> calificaciones;
  
}
