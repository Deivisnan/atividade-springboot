package com.example.deivisnan_atividade_6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexApiController {

    @GetMapping("/index_api")
    public String indexApi() {
        // Vai procurar o arquivo templates/index_api.html
        return "index_api";
    }
}
