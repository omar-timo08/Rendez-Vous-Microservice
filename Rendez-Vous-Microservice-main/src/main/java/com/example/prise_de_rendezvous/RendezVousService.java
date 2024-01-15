package com.example.prise_de_rendezvous;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

@Service
public class RendezVousService {

    @Autowired
    RendezVousRepo rendezVousRepo;

    @Autowired
    FetchUser fetchUser;

    public RendezVous findByRef(String ref){
        return rendezVousRepo.findByReference(ref);
    }

    public Document prendreRendezvous(RendezVous rendezVous, String nom, HttpServletResponse response) throws IOException, DocumentException {

            UserBean userBean=fetchUser.findUserByName(nom);
            rendezVous.setNomDonneur(nom);
            rendezVousRepo.save(rendezVous);
            Document document=new Document(PageSize.A4);
            PdfWriter.getInstance(document,response.getOutputStream());
            document.open();
            Font font= FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            font.setSize(18);
            Paragraph paragraph=new Paragraph("Attestation de prise de rendez-vous");
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);
            Font font1= FontFactory.getFont(FontFactory.HELVETICA);
            font1.setSize(15);
            Paragraph paragraph1=new Paragraph("\nNom complet : "+nom+"\nGroupe Sanguin : "+userBean.getGroupeSanguin()+"\nAge : "+userBean.getAge()+"\nVille : "+rendezVous.getVille()+"\nCentre : "+rendezVous.getCentre()+"\nDate de rendez-vous : "+rendezVous.getDate());
            paragraph1.setAlignment(Paragraph.ALIGN_LEFT);
            Font font2= FontFactory.getFont(FontFactory.HELVETICA);
            font2.setSize(15);
            Paragraph paragraph2=new Paragraph("\nVeuillez vous présenter au centre de don avec la présente attestation. Nous vous remercions énormément pour votre geste humanitaire !");
            paragraph2.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(paragraph);
            document.add(paragraph1);
            document.add(paragraph2);
            document.close();
            return document;
        }

    public Document exportPDF(String nom, String ref, HttpServletResponse response) throws IOException, DocumentException {
        UserBean userBean=fetchUser.findUserByName(nom);
        RendezVous rendezVous=rendezVousRepo.findByReference(ref);
        Document document=new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());
        document.open();
        Font font= FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        Paragraph paragraph=new Paragraph("Attestation de prise de rendez-vous");
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        Font font1= FontFactory.getFont(FontFactory.HELVETICA);
        font1.setSize(15);
        Paragraph paragraph1=new Paragraph("\nNom complet : "+nom+"\nGroupe Sanguin : "+userBean.getGroupeSanguin()+"\nAge : "+userBean.getAge()+"\nVille : "+rendezVous.getVille()+"\nCentre : "+rendezVous.getCentre()+"\nDate de rendez-vous : "+rendezVous.getDate());
        paragraph1.setAlignment(Paragraph.ALIGN_LEFT);
        Font font2= FontFactory.getFont(FontFactory.HELVETICA);
        font2.setSize(15);
        Paragraph paragraph2=new Paragraph("\nVeuillez vous présenter au centre de don avec la présente attestation. Nous vous remercions énormément pour votre geste humanitaire !");
        paragraph2.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph);
        document.add(paragraph1);
        document.add(paragraph2);
        document.close();
        return document;

    }

    public List<RendezVous> listByUserName(String name){
        return rendezVousRepo.findRendezVousByNomDonneur(name);
    }
    public List<RendezVous> findAll(){
        return rendezVousRepo.findAll();
    }
}
