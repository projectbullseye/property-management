package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.PropertyDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    @GetMapping("/add")
    public Double add(Double a, Double b){
        return a+b;
    }
}
