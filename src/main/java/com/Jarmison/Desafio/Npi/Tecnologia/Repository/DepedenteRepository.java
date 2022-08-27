package com.Jarmison.Desafio.Npi.Tecnologia.Repository;

import com.Jarmison.Desafio.Npi.Tecnologia.Entity.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("http://localhost:4200")
public interface DepedenteRepository extends JpaRepository <Dependente,Long> {
}
