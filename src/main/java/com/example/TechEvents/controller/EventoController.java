package com.example.TechEvents.controller;

import com.example.TechEvents.models.entity.Evento;
import com.example.TechEvents.models.entity.Usuario;
import com.example.TechEvents.models.service.IEventoService;
import com.example.TechEvents.models.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("views/eventos")
public class EventoController {

    @Autowired
    private IEventoService eventoService;

    @GetMapping("/")
    public String listarEventos(Model model){
        List<Evento> listadoEventos = eventoService.listarTodos();
        model.addAttribute("titulo", "Lista de Eventos");
        model.addAttribute("eventos", listadoEventos);
        return "views/eventos/listar";
    }

    @GetMapping("/create")
    public String crear(){
        return "views/eventos/frmCrear";
    }

}