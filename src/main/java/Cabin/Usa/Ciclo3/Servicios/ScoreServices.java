package Cabin.Usa.Ciclo3.Servicios;

import Cabin.Usa.Ciclo3.Modelo.Score;
import Cabin.Usa.Ciclo3.Repositorio.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServices {
    
    @Autowired
    private ScoreRepository ScoreRepository;
    
 
    public List <Score> MostrarScore(){
        return (List<Score>) ScoreRepository.MostrarScore();
    }    
    
 
    public Optional<Score> BuscarScore(int id){
        return ScoreRepository.BuscarScore(id);
    }
    

    public Score GuardarScore(Score S){
        if (S.getId()==null){
            return ScoreRepository.GuardarScore(S);
        }else{
            Optional<Score> ScoreX=ScoreRepository.BuscarScore(S.getId());
            if(!ScoreX.isPresent()){
                return ScoreRepository.GuardarScore(S);
            } else {
                return S;
            }     
        }
    }  
}