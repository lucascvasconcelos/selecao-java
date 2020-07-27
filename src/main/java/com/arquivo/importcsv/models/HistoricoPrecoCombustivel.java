package com.arquivo.importcsv.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "TB_HISTORICO")
public class HistoricoPrecoCombustivel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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

    public HistoricoPrecoCombustivel() {

    }

    public HistoricoPrecoCombustivel(
            String regiao,
            String uf,
            String cidade,
            String revenda,
            String cnpjRevenda,
            String produto,
            Date dataColeta,
            float valorVenda,
            float valorCompra,
            String unidadeMedida,
            String bandeira
    ) {
        this.regiao = regiao;
        this.uf = uf;
        this.cidade = cidade;
        this.revenda = revenda;
        this.cnpjRevenda = cnpjRevenda;
        this.produto = produto;
        this.dataColeta = dataColeta;
        this.valorVenda = valorVenda;
        this.valorCompra = valorCompra;
        this.unidaMedida = unidadeMedida;
        this.bandeira = bandeira;
    }

}
