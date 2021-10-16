package Cabin.Usa.Ciclo3.Controlador;

import Cabin.Usa.Ciclo3.Modelo.Cliente;
import Cabin.Usa.Ciclo3.Servicios.ClientServices;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Client")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class ControladorClient {
    
    @Autowired
    private ClientServices ClienteServices;
    
    @GetMapping("/all")
    public List<Cliente> MostrarClientes(){
        return ClienteServices.MostrarCliente();
    }
    
    @GetMapping("/{id}")
    public Optional<Cliente> BuscarClientes(@PathVariable("id") int id){
        return ClienteServices.BuscarCliente(id);
    }
    
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente GuardarCliente(@RequestBody Cliente C){
        return ClienteServices.GuardarCliente(C);
    }
}
