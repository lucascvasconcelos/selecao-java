package com.arquivo.importcsv.services;

import com.arquivo.importcsv.dto.FileDto;
import com.arquivo.importcsv.dto.HistoricoDTO;
import com.arquivo.importcsv.dto.ValorCompraVendaDTO;
import com.arquivo.importcsv.models.HistoricoPrecoCombustivel;
import com.arquivo.importcsv.repositorys.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;

@Service
public class HistoricoService {
    @Autowired
    private HistoricoRepository historicoRepository;

    @Transactional
    public void build(List<FileDto> linhasCsv) throws ParseException {
        for (FileDto linha : linhasCsv) {
            this.montaHistorico(linha);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void montaHistorico(FileDto linha) throws ParseException {
        HistoricoDTO historicoDTO = new HistoricoDTO();
        historicoDTO
                .setRegiao(linha.getRegiao())
                .setUf(linha.getUf())
                .setCidade(linha.getCidade())
                .setRevenda(linha.getRevenda())
                .setCnpjRevenda(linha.getCnpjRevenda())
                .setProduto(linha.getProduto())
                .setDataColeta(linha.getDataColeta())
                .setValorVenda(linha.getValorVenda())
                .setValorCompra(linha.getValorCompra())
                .setUnidaMedida(linha.getUnidaMedida())
                .setBandeira(linha.getBandeira());

        HistoricoPrecoCombustivel historico = historicoDTO.transformaParaObjeto();
        historicoRepository.save(historico);
    }

    public List<HistoricoPrecoCombustivel> listaHistoricos () {
        return this.historicoRepository.findAll();
    }

    public List<HistoricoPrecoCombustivel> findHistoricoPrecoCombustivelsByRegiao(String regiao) {
        return this.historicoRepository.findByRegiao(regiao);
    }

    public List<HistoricoPrecoCombustivel> findByUf(String uf) {
        return this.historicoRepository.findByUf(uf);
    }

    public float getMediaValorVendaPorMunicipio(String cidade) {
        return this.historicoRepository.getMediaValorVendaPorMunicipio(cidade);
    }

    public ValorCompraVendaDTO getPrecoMediaCompraVendaPorMunicipio(String cidade) {

        List<Object[]> query = Collections.singletonList(this.historicoRepository.getPrecoMediaCompraVendaPorMunicipio(cidade));

        ValorCompraVendaDTO valorMedioCompraVenda = new ValorCompraVendaDTO();

        for (Object[] value : query) {
            valorMedioCompraVenda.setValorCompra((Double) ((Object[]) value[0])[0]);
            valorMedioCompraVenda.setValorVenda((Double) ((Object[]) value[0])[1]);
        }

        return valorMedioCompraVenda;
    }

    public ValorCompraVendaDTO getPrecoMediaCompraVendaPorBandeira(String bandeira) {

        List<Object[]> query = Collections.singletonList(this.historicoRepository.getPrecoMediaCompraVendaPorBandeira(bandeira));

        ValorCompraVendaDTO valorMedioCompraVenda = new ValorCompraVendaDTO();

        for (Object[] value : query) {
            valorMedioCompraVenda.setValorCompra((Double) ((Object[]) value[0])[0]);
            valorMedioCompraVenda.setValorVenda((Double) ((Object[]) value[0])[1]);
        }

        return valorMedioCompraVenda;
    }

    public List<HistoricoPrecoCombustivel> agrupaPorDataColeta() {
        return this.historicoRepository.agrupaPorDataColeta();
    }
}
