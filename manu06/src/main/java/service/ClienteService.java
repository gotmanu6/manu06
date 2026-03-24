package service;

import models.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> findAll(){
        return clienteRepository.findAll();
    }

    public ClienteModel criarCliente (ClienteModel cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<ClienteModel> findById(Long id){
        return clienteRepository.findById(id);
    }

    public ClienteModel atualizarCliente (Long id, ClienteModel cliente){
        ClienteModel requeste = clienteRepository.findById(id).get();
        requeste.setNome(cliente.getNome());
        return clienteRepository.save(requeste);
    }

    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }

}
