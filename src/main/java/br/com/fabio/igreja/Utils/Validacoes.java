package br.com.fabio.igreja.Utils;

import br.com.fabio.igreja.exceptions.ServiceException;

public class Validacoes {

  public static boolean verificaId(Long id) throws ServiceException{
    if (id == null || id < 1){
      throw new ServiceException("O id não pode ser nulo ou menor que 1!");
  }
    return true;
  }
}
