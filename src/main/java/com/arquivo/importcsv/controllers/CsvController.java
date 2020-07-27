package com.arquivo.importcsv.controllers;
import com.arquivo.importcsv.services.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping("/csv")
public class CsvController {

    @Autowired
    public CsvService csvService;

    @PostMapping
    public void upload(@RequestParam MultipartFile arquivo) throws IOException, ParseException {
            this.csvService.uploadCsv(arquivo);
        }
}
