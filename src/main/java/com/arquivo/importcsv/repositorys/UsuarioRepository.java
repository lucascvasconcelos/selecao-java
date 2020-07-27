package com.arquivo.importcsv.repositorys;

import com.arquivo.importcsv.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
