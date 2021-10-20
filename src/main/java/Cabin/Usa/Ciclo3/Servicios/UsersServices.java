package Cabin.Usa.Ciclo3.Servicios;

import Cabin.Usa.Ciclo3.Modelo.Users;
import Cabin.Usa.Ciclo3.Repositorio.UsersRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServices {
    
    @Autowired
    private UsersRepository UsersRepository;
    
 
    public List <Users> MostrarUsers(){
        return (List<Users>) UsersRepository.MostrarUsuarios();
    }    
    
 
    public Optional<Users> BuscarUser(int id){
        return UsersRepository.BuscarUsuario(id);
    }
    

    public Users GuardarUser(Users U){
        if (U.getId()==null){
            return UsersRepository.GuardarUsuario(U);
        }else{
            Optional<Users> UserX=UsersRepository.BuscarUsuario(U.getId());
            if(!UserX.isPresent()){
                return UsersRepository.GuardarUsuario(U);
            } else {
                return U;
            }     
        }
    }  
}