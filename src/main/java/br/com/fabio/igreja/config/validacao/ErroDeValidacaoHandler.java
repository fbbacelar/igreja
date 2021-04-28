package br.com.fabio.igreja.config.validacao;

import br.com.fabio.igreja.exceptions.ServiceException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception) {
        List<ErroDeFormularioDto> dto = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String menssagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), menssagem);
            dto.add(erro);
            try {
                throw new ServiceException(menssagem);
            } catch (ServiceException ex) {
                Logger.getLogger(ErroDeValidacaoHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return dto;
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErroGenericoDto handle(EntityNotFoundException exception) {

        String[] mensagem = exception.getMessage().split(" ");
        String idErro = mensagem[mensagem.length-1];
        ErroGenericoDto erro = null;

        if (isNumeric(idErro) && Integer.parseInt(idErro) > 0 ){
            erro = new ErroGenericoDto("Desculpe! Não foi possível encontrar um registro com o id informado (" + idErro + ").");
        }else if (isNumeric(idErro) && Integer.parseInt(idErro) <= 0 ){
            erro = new ErroGenericoDto("Desculpe! Não é possível identificar um registro com id menor que 1 (id informado: " + idErro + ").");
        }
            
            try {
                throw new ServiceException(exception.getMessage());
            } catch (ServiceException ex) {
                Logger.getLogger(ErroDeValidacaoHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        return erro;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErroGenericoDto handle(MethodArgumentTypeMismatchException exception) {

            ErroGenericoDto erro = new ErroGenericoDto("Requisição inválida.");
            
            try {
                throw new ServiceException(exception.getMessage());
            } catch (ServiceException ex) {
                Logger.getLogger(ErroDeValidacaoHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        return erro;
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ErroGenericoDto handle(EmptyResultDataAccessException exception) {

        String[] mensagem = exception.getMessage().split(" ");
        String idErro = mensagem[mensagem.length-2];
        ErroGenericoDto erro = null;

        if (isNumeric(idErro) && Integer.parseInt(idErro) > 0 ){
            erro = new ErroGenericoDto("Desculpe! Não foi possível encontrar um registro com o id informado (" + idErro + ").");
        }else if (isNumeric(idErro) && Integer.parseInt(idErro) <= 0 ){
            erro = new ErroGenericoDto("Desculpe! Não é possível identificar um registro com id menor que 1 (id informado: " + idErro + ").");
        }
            try {
                throw new ServiceException(exception.getMessage());
            } catch (ServiceException ex) {
                Logger.getLogger(ErroDeValidacaoHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        return erro;
    }

    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ErroGenericoDto handle(InvalidDataAccessApiUsageException exception) {

            ErroGenericoDto erro = new ErroGenericoDto("Desculpe! Algo deu errado do nosso lado. Por gentileza, atualize a página e tente novamente.");
            
            try {
                throw new ServiceException(exception.getMessage());
            } catch (ServiceException ex) {
                Logger.getLogger(ErroDeValidacaoHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        return erro;
    }
    
    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ErroGenericoDto handle(HttpRequestMethodNotSupportedException exception) {

            ErroGenericoDto erro = new ErroGenericoDto("Desculpe! Você não em permissão para acessar o endereço solicitado.");
            
            try {
                throw new ServiceException(exception.getMessage());
            } catch (ServiceException ex) {
                Logger.getLogger(ErroDeValidacaoHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        return erro;
    }

    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErroGenericoDto handle(DataIntegrityViolationException exception) {

        List<String> mensagem = Arrays.asList(exception.getMostSpecificCause().getLocalizedMessage().split(" "));
        String tabelaErro = mensagem.get(14);
        ErroGenericoDto erro = new ErroGenericoDto("Desculpe! Algo deu errado do nosso lado. Possivelmente o registro está sendo usado pela tabela " + tabelaErro.replace("\"", "").replace("\n", "") + ".");
    
            try {
                throw new ServiceException(exception.getMessage());
            } catch (ServiceException ex) {
                Logger.getLogger(ErroDeValidacaoHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        return erro;
    }

    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(ServiceException.class)
    public ErroGenericoDto handle(ServiceException exception) {

        ErroGenericoDto erro = new ErroGenericoDto(exception.getMessage());
    
            try {
                throw new ServiceException(exception.getMessage());
            } catch (ServiceException ex) {
                Logger.getLogger(ErroDeValidacaoHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        return erro;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
}