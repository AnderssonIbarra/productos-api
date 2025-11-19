package com.evaluacion.productosapi.advice;

import com.evaluacion.productosapi.entity.CategoriaProducto;
import com.evaluacion.productosapi.service.exception.CategoriaNoEncontradoException;
import com.evaluacion.productosapi.service.exception.ProductoNoEncontradoException;
import com.evaluacion.productosapi.service.exception.StockInsuficienteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    // --- MANEJAR 404 NOT FOUND ---
    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFound(ProductoNoEncontradoException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiErrorResponse response = new ApiErrorResponse(
                "Producto no encontrado",
                ex.getMessage(),
                status
        );
        return new ResponseEntity<>(response, status); // 404
    }

    // --- MANEJAR 400 BAD REQUEST ---
    @ExceptionHandler({
            StockInsuficienteException.class,
            IllegalArgumentException.class,
    })
    public ResponseEntity<ApiErrorResponse> handleBadRequest(RuntimeException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        // Define el título del error basado en la excepción
        String errorTitle = "Petición Inválida";
        if (ex instanceof StockInsuficienteException) {
            errorTitle = "Stock Insuficiente";
        }

        ApiErrorResponse response = new ApiErrorResponse(
                errorTitle,
                ex.getMessage(),
                status
        );
        return new ResponseEntity<>(response, status); // 400
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)

    public void handleConversionMismatch(MethodArgumentTypeMismatchException ex) {

        if (ex.getName().equals("categoria") && ex.getRequiredType() != null && ex.getRequiredType().isEnum()) {

            String valoresValidos = Arrays.stream(CategoriaProducto.values())
                    .map(Enum::toString)
                    .collect(Collectors.joining(", "));

            throw new CategoriaNoEncontradoException(ex.getValue().toString(), valoresValidos);
        }

        throw ex;
    }

    @ExceptionHandler(CategoriaNoEncontradoException.class)
    public ResponseEntity<ApiErrorResponse> handleCategoriaNoEncontrada(CategoriaNoEncontradoException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ApiErrorResponse response = new ApiErrorResponse(
                "Categoría Inválida", // <-- Título para este caso específico
                ex.getMessage(),      // <-- Mensaje formateado de la excepción
                status
        );
        return new ResponseEntity<>(response, status); // 400 Bad Request
    }

}