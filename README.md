# INFORMACION PROYECTO INGRESOS EGRESOS MED135

## Estructura 
El proyecto esta formado por la clases:

- Ingreso (idIngreso, idConcepto, total, fecha)
- Egreso (idIngreso, idConcepto, total, fecha)
- Concepto (idConcepto, idCategoria, categoria)
- Categoria (idcategoria, nombre)

Clase manejadora
- Mantenimiento

Clase Principal( metodo main)
- main

## ¿Como usar el programa? 
- Agregar una categoria
    - Agregar el tipo de categoria en formato alfanumerico
-  Agregar un Concepto
    - Se lista el id de *categoria* ingresar el id que desea en formato numerico
    - Ingresar el monto en formato numerico (con punto decimal si es nesesario)
    - Ingresar la fecha, se pide los dias, meses y años separados por lo que se debe ingresar solo en formato numerico      con 2 digitos para dias y meses y y digitos para año
-  Agregar  Ingreso y Agregar  Egreso:
    - Se lista el id de *concepto* ingresar el id que desea en formato numerico
    - Ingresar  el total en formato numerico (con punto decimal si es nesesario)
    - Ingresar la fecha, se pide los dias, meses y años separados por lo que se debe ingresar solo en formato
-  Ver resumen
    - Ingresar la fechaInicio, se pide los dias, meses y años separados por lo que se debe ingresar solo en formato
    - Ingresar la fechaFin, se pide los dias, meses y años separados por lo que se debe ingresar solo en formato


## Consideraciones
Para ejecutar el programa se deben considerar lo siguiente:

 - no usar espacios en las oraciones, si no que se debe usar guio bajo "_" debido a que esto podria generar errores
- Es imprescindible agregar como minimo una categoria, para poder agregar un concepto
- Cuando se ingresa la fecha es obligatorio introducir solo numeros.
*
Este proyecto fue generado con fines educativos y de practica en el lenguaje de java con el objetivo de poder realizar un mantenimiento de egresos e ingresos en la cual se le solicita al usuario agregar una categoria y agregar un catalogo en base a que concepto sera  ingreso o egreso.
### Screenshot
![Egresos e Ingresos](https://media0.giphy.com/media/l4Ki4brqR7uZHy0ZW/giphy.gif?cid=ecf05e47dmfovfajnlsmqesylj4vchzcbhseg59jxdpnlghf&ep=v1_gifs_search&rid=giphy.gif&ct=g)
## Technologies
*
A list of technologies used within the project:
*[Netbeans ide](https://netbeans.apache.org/download/nb17/): Version 17 
* [NetBeans GUI Library](https://github.com/Cristhoper-Mendez/IngresosEgresosProject): Version 1.2
## Installation
*
Una pequeña introducción sobre la instalación.. 

$ git clone https:https://github.com/Cristhoper-Mendez/IngresosEgresosProject

Información adicional:
## Collaboradores
*
- Cristopher Alexander Mendez Montes MM22116
- Jose Franklin Angel Guevara AG19030
- Mario Alexis Miranda Reyes MR22058
- Saul Otoniel Valdez Vazques VV22029
