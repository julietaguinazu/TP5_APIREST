package com.example.persona.services;

import com.example.persona.entities.Persona;
import com.example.persona.repositeries.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class PersonaService implements BaseService<Persona> {

    @Autowired
    private PersonaRepository personaRepository;

   /* public PersonaService(PersonaRepository personaRepository){
        this.personaRepository= personaRepositery;
    }*/

    @Override
    @Transactional//significa que van a hacer transaciones estos metodos con la base de datos
    public List<Persona> findAll() throws Exception {
       try{
           List<Persona> entities = personaRepository.findAll();
           return entities;
       }catch (Exception e){
           throw new Exception(e.getMessage());
       }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try{
            Optional<Persona> entityOptional= personaRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try{
            entity=personaRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try{
            Optional<Persona> entityOptional = personaRepository.findById(id);
            Persona persona= entityOptional.get();
            persona= personaRepository.save(persona);
            return persona;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(personaRepository.existsById(id)){
                personaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }
}
