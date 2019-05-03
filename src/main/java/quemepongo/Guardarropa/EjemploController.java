package quemepongo.Guardarropa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //en Spring un Controller es el que handlea los requests
public class EjemploController {

    @GetMapping("/metodoPrueba") //Esto mapea los request "GET" que sean "/metodoPrueba" con este metodo "metodo"
    public String metodo(@RequestParam(name="nombre", required=false, defaultValue="carlos") String parametroUno, Model modelo) {
        /*
            Con "@RequestParam" Spring lo que hace es mapear el parametro "parametroUno" a lo que venga en GET:
            por ejemplo si el GET es /metodoPrueba?nombre=pepe entonces:
            - Con la opcion "name" se ejecutara este metodo "metodo" recibiendo como parametro a "parametroUno" con el valor "pepe"
            - Con la opcion "required" se especifica justamente si es obligatorio o no
            - Con la opcion "defaultValue", si no se recibio el parametro porque era opcional, se setea con el valor "carlos"
        */

        //le digo a la vista que en la variable "variableEnLaVista" le clave el valor de parametroUno
        modelo.addAttribute("variableEnLaVista",parametroUno);
            //el "s:" se pone solo, es porque usa Spring
            //Agrega al modelo el parametro reicbido
        return "nombreVista"; //devuelve el nombre de la vista (una vista seria el HTML que ve el usuario, y que va guardado en src/main/resources/templates)
    }

    @GetMapping("/parteFruta")
    public String metodoDos(@RequestParam(name="parametroNoObligatorio", required=false, defaultValue = "defaultttt") String param,
                            @RequestParam(name="valor", required=true) Boolean eleccion,
                            Model modelo) {
        if("defaultttt".equals(param)){
            modelo.addAttribute("varr","tiraste fruta en el parametro opcional");
        } else {
            modelo.addAttribute("varr","\"parametro opcional" + " bla bla bla\"");
        }
        modelo.addAttribute("fruta",!eleccion);
        return "vistaMentirosa";
    }

}