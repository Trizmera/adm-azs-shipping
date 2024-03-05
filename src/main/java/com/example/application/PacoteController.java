package com.example.application;

import com.example.domain.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pacotes")
public class PacoteController {
    @Autowired
    private PacoteService pacoteService;

}
