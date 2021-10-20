package Cabin.Usa.Ciclo3.Servicios;

import Cabin.Usa.Ciclo3.Modelo.Cabin;
import Cabin.Usa.Ciclo3.Repositorio.CabinRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CabinServices {
    
    @Autowired
    private CabinRepository CabinRepository;
    
    public List <Cabin> MostrarCabañas(){
        return CabinRepository.MostrarCabañas();
    }    
    
    public Optional<Cabin> BuscarCabaña(int id){
        return CabinRepository.BuscarCabaña(id);
    }
    
    public Cabin GuardarCabaña(Cabin C){
        if (C.getId()==null){
            return CabinRepository.GuardarCabaña(C);
        }else{
            Optional<Cabin> CabinX=CabinRepository.BuscarCabaña(C.getId());
            if(!CabinX.isPresent()){
                return CabinRepository.GuardarCabaña(C);
            } else {
                return C;
            }     
        }
    }  
}