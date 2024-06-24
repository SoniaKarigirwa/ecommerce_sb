package rw.ac.rca.online_shopping_system.utils;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rw.ac.rca.online_shopping_system.DTO.Response;
import rw.ac.rca.online_shopping_system.enums.ResponseType;
import rw.ac.rca.online_shopping_system.exceptions.AuthenticationFailedException;
import rw.ac.rca.online_shopping_system.exceptions.DuplicateEmailException;
import rw.ac.rca.online_shopping_system.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerUtil {
    public static ResponseEntity<Response> handleException(Exception e) {
        if(e instanceof ResourceNotFoundException) {
            return ResponseEntity.status(404).body(new Response().setResponseType(ResponseType.RESOURCE_NOT_FOUND).setPayload(e.getMessage()));
        } else if (e instanceof DuplicateEmailException) {
            return ResponseEntity.status(400).body(new Response().setResponseType(ResponseType.BAD_REQUEST).setPayload(e.getMessage()));
        } else if (e instanceof AuthenticationFailedException) {
            return ResponseEntity.status(401).body(new Response().setResponseType(ResponseType.UNAUTHORIZED).setPayload(e.getMessage()));
        }  else {
            return ResponseEntity.status(500).body(new Response().setResponseType(ResponseType.INTERNAL_SERVER_ERROR).setPayload(e.getMessage()));
        }

    }
}
