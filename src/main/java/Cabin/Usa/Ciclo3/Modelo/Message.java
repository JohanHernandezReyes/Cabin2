package Cabin.Usa.Ciclo3.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name="message")
@Data
public class Message implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 250)
    private String txtmessage;
    
    @ManyToOne
    @JoinColumn(name="cabin_id")
    @JsonIgnoreProperties("cabinsmessages")
    private Cabin cabin_id; 
           
  
}

