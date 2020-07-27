package com.arquivo.importcsv.repositorys;

import com.arquivo.importcsv.dto.ValorCompraVendaDTO;
import com.arquivo.importcsv.models.HistoricoPrecoCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HistoricoRepository extends JpaRepository<HistoricoPrecoCombustivel, Long> {
     @Query(value = "select h from TB_HISTORICO h where h.regiao = ?1")
     List<HistoricoPrecoCombustivel> findByRegiao(String regiao);

     @Query(value = "select h from TB_HISTORICO h where h.uf = ?1")
     List<HistoricoPrecoCombustivel> findByUf(String regiao);

     @Query("select avg(H.valorVenda) from TB_HISTORICO H where H.cidade = ?1")
     float getMediaValorVendaPorMunicipio(String cidade);

     @Query(value = "select avg(h.valorCompra) as valorCompra, avg(h.valorVenda) as valorVenda from TB_HISTORICO h where h.cidade = ?1")
     Object[] getPrecoMediaCompraVendaPorMunicipio(String cidade);


     @Query(value = "select avg(h.valorCompra) as valorCompra, avg(h.valorVenda) as valorVenda from TB_HISTORICO h where h.bandeira = ?1")
     Object[] getPrecoMediaCompraVendaPorBandeira(String bandeira);

     @Query("select h from TB_HISTORICO h order by h.dataColeta")
     List<HistoricoPrecoCombustivel> agrupaPorDataColeta();
}
