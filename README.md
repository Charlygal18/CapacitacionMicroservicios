# CapacitacionMicroservicios

**Proyecto 1: h2**

Proyecto API RESTful con una base de datos temporal usando h2.

**Proyecto 2: proyecto2**

Proyecto API RESTful con una base de datos en MySQL, primer ejercicio solicitado, añadir servicio que reciba nombre y contraseña y que lo
valide con lo que hay de ese cliente en la base de datos, además que valide que el cliente no esté bloqueado y pueda cambiar su Session a true,
también retornar UUID random en header de la respuesta.

**Proyecto 3: login**

Proyecto API RESTful con una base de datos en MySQL, tabla customers, segunda tarea: añadir servicio para que valide si el cliente
se encuentra bloqueado de ser así, lanzará mensaje de que está bloqueado y servicio para validar sesión en caso de que en la tabla 
sesión se encuentre en true lanzará un sesión ya iniciada, de no ser así y el cliente esté desbloqueado y sesión en 0 mensaje 200 sesión iniciada correctamente.

**Proyecto 4: account**

Proyecto API RESTful con una base de datos en MySQL, tabla accounts, tercer tarea: servicio de traer información por customerNumber, además
de traer información de la tarjeta mediante un DTO para solo mostrar información de la cuenta.
