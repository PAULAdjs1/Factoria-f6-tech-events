package com.example.TechEvents.controller;

import com.example.TechEvents.models.entity.Usuario;
import com.example.TechEvents.models.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("views/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/")
    public String listarUsuarios(Model model){
        List<Usuario> listadoUsuarios = usuarioService.listarTodos();
        model.addAttribute("titulo", "Lista de Usuarios");
        model.addAttribute("usuarios", listadoUsuarios);
        return "views/usuarios/listar";
    }

    @GetMapping("/create")
    public String crear(){
        return "views/usuarios/frmCrear";
    }

}
