package br.com.flpbd.email.repository;

import br.com.flpbd.email.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
