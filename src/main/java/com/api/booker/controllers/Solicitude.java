package com.api.booker.controllers;

import com.api.booker.models.entity.SolicitudeEntity;
import com.api.booker.models.in.SolicitudeModel;
import com.api.booker.models.out.ResponseApi;
import com.api.booker.repository.SolicitudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/")
@RestController
public class Solicitude {

    @Autowired
    SolicitudeRepository solicitudeRepository;

    @PostMapping("/solicitude")
    public ResponseApi create(@RequestBody SolicitudeModel solicitude){
        try{

            var time = java.time.LocalDate.now().toString();
            var state = "Pendiente";
            var description = solicitude.getDescription();
            var value = solicitude.getValue();
            var user = solicitude.getId_user();
            var book = solicitude.getId_book();

            var solicitudeCreate = new SolicitudeEntity(time,state,description,value,user,book);

            this.solicitudeRepository.save(solicitudeCreate);

            return new ResponseApi<String>("Solicitud creada.",200,null,true);
        }  catch (Exception e){
            return new ResponseApi<String>(e.getMessage(),500,"Error",false);
        }
    }

    @GetMapping("/solicitude/getAll")
    public ResponseApi getAll(){
        try {

            var solicitudes = this.solicitudeRepository.findByState("Pendiente");

            return new ResponseApi<List<SolicitudeEntity>>(solicitudes,200,null,true);
        }   catch (Exception e){
            return new ResponseApi<String>(e.getMessage(),500,"Error",false);
        }
    }

    @GetMapping("/solicitude/{idUser}")
    public ResponseApi getByIdUser(@PathVariable int idUser){
        try {

            var solicitudes = this.solicitudeRepository.findByIdUser(idUser);

            return new ResponseApi<List<SolicitudeEntity>>(solicitudes,200,null,true);
        }   catch (Exception e){
            return new ResponseApi<String>(e.getMessage(),500,"Error",false);
        }
    }


}
