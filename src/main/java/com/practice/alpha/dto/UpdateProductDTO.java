package com.practice.alpha.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateProductDTO(

        @NotNull(message = "{alpha.products.update.errors.title_size_is_invalid}")
        @Size(min = 3, max = 50, message = "{alpha.products.update.errors.title_size_is_invalid}")
        String title,

        @Size(max = 100, message = "{alpha.products.update.errors.details_size_is_invalid}")
        String details
) {}
