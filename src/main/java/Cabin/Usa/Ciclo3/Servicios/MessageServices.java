package Cabin.Usa.Ciclo3.Servicios;

import Cabin.Usa.Ciclo3.Modelo.Message;
import Cabin.Usa.Ciclo3.Repositorio.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServices {
    
    @Autowired
    private MessageRepository MessageRepository;
    
 
    public List <Message> MostrarMensajes(){
        return (List<Message>) MessageRepository.MostrarMensajes();
    }    
    
 
    public Optional<Message> BuscarMensaje(int id){
        return MessageRepository.BuscarMensaje(id);
    }
    

    public Message GuardarMensaje(Message M){
        if (M.getId()>0){
            return MessageRepository.GuardarMensaje(M);
        }else{
            Optional<Message> MessageX=MessageRepository.BuscarMensaje(M.getId());
            if(MessageX == null){
                return MessageRepository.GuardarMensaje(M);
            } else {
                return M;
            }     
        }
    }  
}