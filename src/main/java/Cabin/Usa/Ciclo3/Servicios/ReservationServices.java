package Cabin.Usa.Ciclo3.Servicios;

import Cabin.Usa.Ciclo3.Modelo.Reservation;
import Cabin.Usa.Ciclo3.Repositorio.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServices {
    
    @Autowired
    private ReservationRepository ReservationRepository;
    
 
    public List <Reservation> MostrarReservaciones(){
        return (List<Reservation>) ReservationRepository.MostrarReservaciones();
    }    
    
 
    public Optional<Reservation> BuscarReservacion(int id){
        return ReservationRepository.BuscarReservacion(id);
    }
    

    public Reservation GuardarReservacion(Reservation R){
        if (R.getIdReservation()==null){
            return ReservationRepository.GuardarReservacion(R);
        }else{
            Optional<Reservation> ReservationX=ReservationRepository.BuscarReservacion(R.getIdReservation());
            if(!ReservationX.isPresent()){
                return ReservationRepository.GuardarReservacion(R);
            } else {
                return R;
            }     
        }
    }  
}