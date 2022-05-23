package br.com.flpbd.email.controller;

import br.com.flpbd.email.model.EmailModel;
import br.com.flpbd.email.model.dto.EmailDTO;
import br.com.flpbd.email.services.EmailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/send-email")
public class EmailController {
    final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    @ApiOperation("Tste Swagger")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDTO emailDTO) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);

    }
}
