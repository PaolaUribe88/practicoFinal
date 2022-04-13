# practicoFinal Taller MyCar

El taller mecánico “MyCar”, necesita construir una aplicación informática que permita llevar un control de los vehículos que atiende diariamente 

Se requiere por un lado manejar la información de sus clientes, los datos del automóvil y las mantenciones que se le realizan a éstos (se debe considerar que un cliente puede tener más de un vehículo)

A modo de ejemplo para efecto de las mantenciones, se debiesen considerar “cambio de aceite”, “ajuste de frenos”, “afinamiento”, “amortiguadores” y similares

 
## Las clases consideran “a lo menos” los siguientes atributos:

•	Cliente: apellidos, nombres, rut, email y fono contacto
•	Auto: ppu (placa patente única), marca, modelo, año de fabricación 
•	Mantención: mantención realizada (por ejemplo, cambio de aceite), observaciones y monto del servicio (en pesos)
•	Fecha: día, mes y año
Desde el Main debe:

1.	Crear un menú de opciones para el usuario que contemple lo siguiente: 
o	Agregar cliente, auto y/o mantención
o	Eliminar cliente
o	Listar las mantenciones realizadas a un vehículo en particular 
o	Informe de recaudación del día
2.	Crear una colección de tipo ArrayList para almacenar los objetos correspondientes

Además:
•	Construir constructores con y sin parámetros en cada clase
•	Accesadores y mutadores (getter y setter)
•	Método de impresión de clase, además de “toString()”
•	Se debe validar:
o	Datos de tipo String no pueden estar vacíos
o	Fono contacto debe tener a lo menos 9 dígitos numéricos (enteros)
o	PPU debe contemplar 6 caracteres
o	Año de fabricación, debe ser mayor a 1960 y contemplar sólo 4 dígitos
o	La fecha según estructura para el día y el mes
o	Agregar bloque try/catch para controlar excepciones en la lectura de datos

### Jessie Uribe
