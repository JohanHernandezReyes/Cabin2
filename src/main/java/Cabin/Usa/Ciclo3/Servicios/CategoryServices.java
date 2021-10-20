package Cabin.Usa.Ciclo3.Servicios;

import Cabin.Usa.Ciclo3.Modelo.Categoria;
import Cabin.Usa.Ciclo3.Repositorio.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServices {
    
    @Autowired
    private CategoryRepository CategoryRepository;
    
    public List <Categoria> MostrarCategorias(){
        return CategoryRepository.MostrarCategorias();
    }    
    
    public Optional<Categoria> BuscarCategoria(int id){
        return CategoryRepository.BuscarCategoria(id);
    }
    
    public Categoria GuardarCategoria(Categoria C){
        if (C.getId()==null){
            return CategoryRepository.GuardarCategoria(C);
        }else{
            Optional<Categoria> CategoryX=CategoryRepository.BuscarCategoria(C.getId());
            if(!CategoryX.isPresent()){
                return CategoryRepository.GuardarCategoria(C);
            } else {
                return C;
            }     
        }
    }  
}
