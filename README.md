# Proyecto Backend de Inventario de Productos

Este proyecto es una API RESTful para gestionar un inventario de productos. Permite a los usuarios realizar operaciones básicas como agregar, editar, eliminar y consultar productos de un inventario. La API está diseñada para ser utilizada en aplicaciones de gestión de inventarios y se comunica con una base de datos para almacenar la información de los productos.



## Endpoints de la API

### 1. Obtener todos los productos

**Método:** `GET`  
**Ruta:** `/api/v1/producto`

Obtiene la lista de todos los productos en el inventario.

**Respuesta:**
```json
[
    {
        "id_producto": "1",
        "nombre_producto": "Producto 1",
        "descripcion": "Descripción del producto 1",
        "categoria" : "Categoria del producto 1"
        "cantidad_disponible": 100,
        "precio_unitario": 50.0,
        "Fecha_Ingreso": "2025-02-02",
        "proveedor" : "proveedor 1",
        "estado_producto": "activo"
    },
    ...
]
