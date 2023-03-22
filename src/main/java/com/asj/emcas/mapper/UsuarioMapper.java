package com.asj.emcas.mapper;


import com.asj.emcas.dto.UsuarioDTO;
import com.asj.emcas.dto.UsuarioSinIdDTO;
import com.asj.emcas.entidad.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario UsuarioDTORegistroToUsuarioEntity(UsuarioSinIdDTO usuarioSinIdDTO);

    UsuarioDTO UsuarioEntityToUsuarioDTO(Usuario usuario);


}
