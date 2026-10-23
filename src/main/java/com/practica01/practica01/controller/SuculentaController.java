package com.practica01.practica01.controller;

import com.practica01.practica01.domain.Suculenta;
import com.practica01.practica01.service.SuculentaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/suculenta")
public class SuculentaController {

    private final SuculentaService suculentaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var suculentas = suculentaService.getSuculentas();
        model.addAttribute("suculentas", suculentas);
        model.addAttribute("totalSuculentas", suculentas.size());
        return "suculenta/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Suculenta suculenta, RedirectAttributes redirectAttributes) {
        boolean esNueva = suculenta.getIdSuculenta() == null;
        String titulo = "todoOk";
        String mensaje = esNueva ? "Suculenta Guardada" : "Los datos se guardaron correctamente";
        try {
            suculentaService.save(suculenta);
        } catch (DataIntegrityViolationException e) {
            titulo = "error";
            mensaje = "Error al guardar suculenta. Intenta de Nuevo";
            log.error("Error al guardar suculenta", e);
        }
        redirectAttributes.addFlashAttribute(titulo, mensaje);
        return "redirect:/suculenta/listado";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer idSuculenta, RedirectAttributes redirectAttributes) {
        String titulo = "todoOk";
        String mensaje = "La suculenta fue eliminada de tu coleccion";
        try {
            suculentaService.delete(idSuculenta);
        } catch (IllegalArgumentException e) {
            titulo = "error";
            mensaje = "Esa suculenta ya no existe";
        } catch (IllegalStateException e) {
            titulo = "error";
            mensaje = "No se pudo eliminar la suculenta";
        }
        redirectAttributes.addFlashAttribute(titulo, mensaje);
        return "redirect:/suculenta/listado";
    }

    @GetMapping("/")
    public String raiz() {
        return "redirect:/suculenta/listado";
    }
}