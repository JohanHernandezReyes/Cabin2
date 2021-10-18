package Cabin.Usa.Ciclo3.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name="client")
@Data
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 250)
    private String nombre;
    @Column(length = 45)
    private String email;
    @Column(length = 45)
    private String password;
    private Integer edad; 
    
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="client_id")
    @JsonIgnoreProperties("client_id")
    public List<Reservation> clientsreservations;
}

