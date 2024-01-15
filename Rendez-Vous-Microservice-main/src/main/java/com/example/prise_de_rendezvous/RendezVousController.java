package com.example.prise_de_rendezvous;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.io.IOException;
import java.util.List;

@RestController
public class RendezVousController {
    @Autowired
    RendezVousService rendezVousService;

    @GetMapping("/findByRef/{ref}")
    public RendezVous findByRef(@PathVariable("ref") String ref){
        return rendezVousService.findByRef(ref);
    }

    @PostMapping("/priseRendezVous/{nom_donneur}")
    public Document priseRendezVous(@RequestBody RendezVous rendezVous, @PathVariable("nom_donneur")String nom, HttpServletResponse response) throws DocumentException, IOException {
        return rendezVousService.prendreRendezvous(rendezVous,nom,response);
    }

   @GetMapping("/listByUserName/{username}")
    public List<RendezVous> listByUserName(@PathVariable("username")String username){
        return rendezVousService.listByUserName(username);
    }

    @GetMapping("/findAll")
    public List<RendezVous> findAll(){
        return rendezVousService.findAll();
    }

    @GetMapping("/getPdf/{username}/{reference}")
    public Document prendreRendezvous(@PathVariable("username")String nom,@PathVariable("reference")String ref,HttpServletResponse response) throws IOException, DocumentException {
        return rendezVousService.exportPDF(nom,ref,response);
    }
}
