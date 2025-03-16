package spring.boot.desafio.cnab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.boot.desafio.cnab.model.Transacao;
import spring.boot.desafio.cnab.service.CnabService;

import java.util.List;

@RestController
@RequestMapping("/cnab")
public class CnabController {

    @Autowired
    private CnabService cnabService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        cnabService.arquivoProcessar(file);
        return ResponseEntity.ok("Arquivo processado com sucesso!");
    }

    @GetMapping("/trasacao")
    public List<Transacao> listarTransacoes() {
        return cnabService.listarTransacoes();
    }

}
