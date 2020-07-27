package com.arquivo.importcsv.dto;

import com.opencsv.bean.CsvBindByPosition;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDto {
    @CsvBindByPosition(position = 0)
    private String regiao;

    @CsvBindByPosition(position = 1)
    private String uf;

    @CsvBindByPosition(position = 2)
    private String cidade;

    @CsvBindByPosition(position = 3)
    private String revenda;

    @CsvBindByPosition(position = 4)
    private String cnpjRevenda;

    @CsvBindByPosition(position = 5)
    private String produto;

    @CsvBindByPosition(position = 6)
    private String dataColeta;

    @CsvBindByPosition(position = 7)
    private String valorVenda;

    @CsvBindByPosition(position = 8)
    private String valorCompra;

    @CsvBindByPosition(position = 9)
    private String unidaMedida;

    @CsvBindByPosition(position = 10)
    private String bandeira;

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setRevenda(String revenda) {
        this.revenda = revenda;
    }

    public void setCnpjRevenda(String cnpjRevenda) {
        this.cnpjRevenda = cnpjRevenda;
    }

    public void setProduto(String produto) {
        this.produto = produto.replace("\0", "").trim();
    }

    public void setDataColeta(String dataColeta) {
        this.dataColeta = dataColeta.replace("\0", "").trim();
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda.replace("\0", "").trim();
    }

    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra.replace("\0", "").trim();
    }

    public void setUnidaMedida(String unidaMedida) {
        this.unidaMedida = unidaMedida.replace("\0", "").trim();
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira.replace("\0", "").trim();
    }

    public String getRegiao() {
        if (regiao == null) {
            return "";
        }
        return regiao.replace("\0", "").trim();
    }

    public String getUf() {
        if (uf == null) {
            return "";
        }
        return uf.replace("\0", "").trim();
    }

    public String getCidade() {
        if (cidade == null) {
            return "";
        }
        return cidade.replace("\0", "").trim();
    }

    public String getRevenda() {
        if (revenda == null) {
            return "";
        }

        return revenda.replace("\0", "").trim();
    }

    public String getCnpjRevenda() {
        if (cnpjRevenda == null) {
            return "";
        }
        return cnpjRevenda.replace("\0", "").trim();
    }

    public String getProduto() {
        if (produto == null) {
            return "";
        }
        return produto.replace("\0", "").trim();
    }

    public Date getDataColeta() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        if (dataColeta == null) {
            return null;
        }
        String stringData = dataColeta.replace("\0", "").trim().replace(",", "").replace("\n", "");
        Date data = formato.parse(stringData);
        return data;
    }

    public float getValorVenda() {
        if (valorVenda == null || valorCompra.equals("")) {
            return 0;
        }
        return Float.parseFloat(valorVenda.replace("\0", "").trim().replace(",", "").replace("\n", ""));
    }

    public float getValorCompra() {
        if (valorCompra == null || valorCompra.equals("")) {
            return 0;
        }
        return Float.parseFloat(valorCompra.replace("\0", "").trim().replace(",", "").replace("\n", ""));
    }

    public String getUnidaMedida() {
        if (unidaMedida == null) {
            return "";
        }
        return unidaMedida.replace("\0", "").trim();
    }

    public String getBandeira() {
        if (bandeira == null) {
            return "";
        }
        return bandeira.replace("\0", "").trim();
    }
}
