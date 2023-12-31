package com.bolsaideas.springbootform.controllers;

import com.bolsaideas.springbootform.models.domain.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {

    //Metodo GET
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("titulo", "formulario usuarios");
        return "form";
    }

    //Metodo POST
    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
        //tenemos que manejar si el usuario es valido
        model.addAttribute("titulo", "formulario usuarios");

        if (result.hasErrors()) {
            Map<String,String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err ->
                    errores.put(err.getField(),"El campo "
                            .concat(err.getField())
                            .concat(" ")
                            .concat(err.getDefaultMessage()))
                    );
            model.addAttribute("error",errores);
            return "form"; //regresamos la vista al formulario
        }

        model.addAttribute("usuario", usuario);
        return "resultado";
    }
}
