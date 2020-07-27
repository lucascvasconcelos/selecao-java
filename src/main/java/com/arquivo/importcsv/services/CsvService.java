package com.arquivo.importcsv.services;

import com.arquivo.importcsv.dto.FileDto;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.util.List;

@Service
public class CsvService {

    @Autowired
    private HistoricoService historicoService;

    public void uploadCsv(MultipartFile file) throws IOException, ParseException {
        Reader reader = new InputStreamReader(file.getInputStream());

        CsvToBean<FileDto> fileDtoCsvToBean = new CsvToBeanBuilder<FileDto>(reader)
                .withSeparator('\t')
                .withType(FileDto.class)
                .withSkipLines(1)
                .withIgnoreEmptyLine(true)
                .build();

        List<FileDto> linhas = fileDtoCsvToBean.parse();
        this.removeObjetosvazios(linhas);
        this.historicoService.build(linhas);
    }

    private void removeObjetosvazios(List<FileDto> linhasCsv) {
        linhasCsv.removeIf(linha -> linha.getProduto().equals(""));
    }
}
