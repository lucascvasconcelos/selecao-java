package com.arquivo.importcsv.controllers;


import com.arquivo.importcsv.dto.ValorCompraVendaDTO;
import com.arquivo.importcsv.models.HistoricoPrecoCombustivel;
import com.arquivo.importcsv.services.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/historico")
public class HistoricoController {
    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/regiao/{regiao}")
    public ResponseEntity<List<HistoricoPrecoCombustivel>> listaHistoricoPorRegiao(@PathVariable String regiao) {
        List<HistoricoPrecoCombustivel> historicos = this.historicoService
                .findHistoricoPrecoCombustivelsByRegiao(regiao.toUpperCase());

        return ResponseEntity.ok().body(historicos);
    }

    @GetMapping("/uf/{uf}")
    public ResponseEntity<List<HistoricoPrecoCombustivel>> listaHistoricoPorUf(@PathVariable String uf) {
        List<HistoricoPrecoCombustivel> historicos = this.historicoService.findByUf(uf.toUpperCase());

        return ResponseEntity.ok().body(historicos);
    }

    @GetMapping("/valor-venda/{cidade}")
    public ResponseEntity<Float> getMediaValorVendaPorMunicipio(@PathVariable String cidade) {
        float valorVenda = this.historicoService.getMediaValorVendaPorMunicipio(cidade.toUpperCase());

        return ResponseEntity.ok().body(valorVenda);
    }

    @GetMapping("/media-compra-venda/municipio/{cidade}")
    public ResponseEntity<ValorCompraVendaDTO> getMediaCompraVendaPorMunicipio(@PathVariable String cidade) {
        ValorCompraVendaDTO valorCompraVendaDTO = this.historicoService
                .getPrecoMediaCompraVendaPorMunicipio(cidade.toUpperCase());

        return ResponseEntity.ok(valorCompraVendaDTO);
    }

    @GetMapping("/media-compra-venda/bandeira/{bandeira}")
    public ResponseEntity<ValorCompraVendaDTO> getMediaCompraVendaPorBandeira(@PathVariable String bandeira) {
        ValorCompraVendaDTO valorCompraVendaDTO = this.historicoService
                .getPrecoMediaCompraVendaPorBandeira(bandeira.toUpperCase());

        return ResponseEntity.ok(valorCompraVendaDTO);
    }

    @GetMapping("/agrupa/data-coleta")
    public ResponseEntity<List<HistoricoPrecoCombustivel>> listaAgrupadoDataColeta() {
        return ResponseEntity.ok(this.historicoService.agrupaPorDataColeta());
    }
}
