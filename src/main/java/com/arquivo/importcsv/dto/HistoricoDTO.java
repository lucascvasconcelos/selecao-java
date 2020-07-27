package com.arquivo.importcsv.dto;

import com.arquivo.importcsv.models.HistoricoPrecoCombustivel;

import java.util.Date;

public class HistoricoDTO {
    private String regiao;
    private String uf;
    private String cidade;
    private String revenda;
    private String cnpjRevenda;
    private String produto;
    private Date dataColeta;
    private float valorVenda;
    private float valorCompra;
    private String unidaMedida;
    private String bandeira;

    public HistoricoDTO setRegiao(String regiao) {
        this.regiao = regiao;
        return this;
    }

    public HistoricoDTO setUf(String uf) {
        this.uf = uf;
        return this;
    }

    public HistoricoDTO setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public HistoricoDTO setRevenda(String revenda) {
        this.revenda = revenda;
        return this;
    }

    public HistoricoDTO setCnpjRevenda(String cnpjRevenda) {
        this.cnpjRevenda = cnpjRevenda;
        return this;
    }

    public HistoricoDTO setProduto(String produto) {
        this.produto = produto;
        return this;
    }

    public HistoricoDTO setDataColeta(Date dataColeta) {
        this.dataColeta = dataColeta;
        return this;
    }

    public HistoricoDTO setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
        return this;
    }

    public HistoricoDTO setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
        return this;
    }

    public HistoricoDTO setUnidaMedida(String unidaMedida) {
        this.unidaMedida = unidaMedida;
        return this;
    }

    public HistoricoDTO setBandeira(String bandeira) {
        this.bandeira = bandeira;
        return this;
    }

    public HistoricoPrecoCombustivel transformaParaObjeto() {
        return new HistoricoPrecoCombustivel(
                regiao,
                uf,
                cidade,
                revenda,
                cnpjRevenda,
                produto,
                dataColeta,
                valorVenda,
                valorCompra,
                unidaMedida,
                bandeira
        );
    }
}
