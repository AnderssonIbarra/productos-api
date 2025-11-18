# Productos API – Prueba Técnica

Proyecto base para la prueba técnica de desarrollador **Java Spring Boot + JavaScript**.
---

## 1. Cómo clonar el proyecto

### 🔹 Opción 1 – Usando Git (recomendado)

1. Clonar el proyecto:
   ```bash
   git clone https://github.com/MI-USUARIO/productos-api.git
   cd productos-api
3. Crear Rama con el nombre con base en la rama develop:
   ```bash
   git checkout -b nombre-apellido


### 🔹 Opción 2 – Descargar ZIP

1. Ir al repositorio en GitHub.
2. Clic en "Code" → "Download ZIP".
3. Descomprimir y abrir en tu IDE.
NOTA: Si usas esta opción, deberás crear luego la rama con tu nombre si subes los cambios al repo o enviar el Proyecto en .ZIP
---
## 2. Requerimientos técnicos

| Herramienta | Versión recomendada |
|-------------|---------------------|
| Java        | 17+                 |
| Maven       | 3.8+                |
| IDE         | Eclipse, IntelliJ o VS Code |
| Postman     | Opcional (para pruebas)     |

---

## 2. Cómo ejecutar el proyecto

### Opción 1: Desde IDE (recomendado)
1. Importar como proyecto **Maven**.
2. Ejecutar la clase principal: com.evaluacion.productosapi.ProductosApiApplication

3. La API estará disponible en:
`http://localhost:8080`

### Opción 2: Desde consola
```bash
mvn spring-boot:run
