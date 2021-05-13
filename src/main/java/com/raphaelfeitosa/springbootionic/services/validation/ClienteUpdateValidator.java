package com.raphaelfeitosa.springbootionic.services.validation;

import com.raphaelfeitosa.springbootionic.domain.Cliente;
import com.raphaelfeitosa.springbootionic.dto.ClienteDTO;
import com.raphaelfeitosa.springbootionic.dto.ClienteNewDTO;
import com.raphaelfeitosa.springbootionic.enums.TipoCliente;
import com.raphaelfeitosa.springbootionic.repositories.ClienteRepository;
import com.raphaelfeitosa.springbootionic.resources.exceptions.FieldMessage;
import com.raphaelfeitosa.springbootionic.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.remote.server.HandlerMapper;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(ClienteUpdate ann) {
    }
    @Override
    public boolean isValid(ClienteDTO clienteDTO, ConstraintValidatorContext context) {

        @SuppressWarnings("uncheched")
        Map<String, String> map = (Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        Cliente aux = clienteRepository.findByEmail(clienteDTO.getEmail());

        if (aux != null && !aux.equals(uriId)) {

            list.add(new FieldMessage("email", "Email já cadastrado"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getField()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}