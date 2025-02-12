package com.practice.alpha.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewProductDTO(

        @NotNull(message = "{alpha.products.create.errors.title_is_null}")
        @Size(min = 3, max = 50, message = "{alpha.products.create.errors.title_size_is_invalid}")
        String title,

        @Size(max = 1000, message = "{alpha.products.create.errors.details_size_is_invalid}")
        String details
) {}
