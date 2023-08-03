package com.example.commerce.DTO;

import java.util.List;

public record ClientePageDTO(List<ClienteDTO> clienteDTOList,long totalElements, int totalPages ) {
}
