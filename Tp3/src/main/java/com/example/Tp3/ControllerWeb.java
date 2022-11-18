package com.example.Tp3;

import java.text.DecimalFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

 

@Controller
public class ControllerWeb {
   

    @GetMapping("/")
    public String getIndex(
        @RequestParam(name="peso",defaultValue = "0", required = false) Double peso,
        @RequestParam(name="altura",defaultValue = "0", required = false) Double altura,
        Model model){
        double IMC=peso/(altura*altura);
        
        
        model.addAttribute("IMC", calcularMasaCorporal(peso, altura));
        model.addAttribute("Estado", obtenerEstado(IMC));
        
        return "index";
    }
    
    double peso;
    double altura;
    public static String calcularMasaCorporal(double peso, double altura){
        DecimalFormat df = new DecimalFormat("###.00");
        return df.format(peso/(altura*altura));

   
  
    }

 
    public static String obtenerEstado(double IMC){ 
        if (IMC < 15) return ("Delgadez muy Severa "); 
        if (IMC >= 15 && IMC < 15.9) return ("Delgadez Severa"); 
        if (IMC > 16 && IMC < 18.4) return ("Delgadez");
        if (IMC > 18.5 && IMC < 24.9) return ("Peso Saludable");
        if (IMC > 25 && IMC < 29.9)return ("Sobrepeso");
        if (IMC > 30 && IMC < 34.9)return ("Obesidad Moderada");   
        if (IMC > 35 && IMC < 39.9)return("Obesidad Severa");
        if (IMC > 40)return("Obesidad Morbida");
        
        return"";
          
    }
}
