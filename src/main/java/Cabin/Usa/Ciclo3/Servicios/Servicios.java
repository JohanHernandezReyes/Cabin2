package Cabin.Usa.Ciclo3.Servicios;

import Cabin.Usa.Ciclo3.Modelo.Cliente;
import Cabin.Usa.Ciclo3.Repositorio.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicios {
    
    @Autowired
    private ClientRepository ClientRepository;
    
    public List <Cliente> MostrarCliente(){
        return ClientRepository.MostrarClientes();
    }    
    
    public Optional<Cliente> BuscarCliente(int id){
        return ClientRepository.BuscarCliente(id);
    }
    
    public Cliente GuardarCliente(Cliente C){
        if (C.getId()==null){
            return ClientRepository.GuardarCliente(C);
        }else{
            Optional<Cliente> ClientX=ClientRepository.BuscarCliente(C.getId());
            if(ClientX.equals("")){
                return ClientRepository.GuardarCliente(C);
            } else {
                return C;
            }     
        }
    }  
}