# CapacitacionMicroservicios

**Video 1: Proyecto h2**

Proyecto API RESTful con una base de datos temporal usando h2.

**Video 2: Proyecto proyecto2**

Proyecto API RESTful con una base de datos en MySQL, primer ejercicio solicitado, añadir servicio que reciba nombre y contraseña y que lo
valide con lo que hay de ese cliente en la base de datos, además que valide que el cliente no esté bloqueado y pueda cambiar su Session a true,
también retornar UUID random en header de la respuesta.

**Video 3: Proyecto login**

Proyecto API RESTful con una base de datos en MySQL, tabla customers, segunda tarea: añadir servicio para que valide si el cliente
se encuentra bloqueado de ser así, lanzará mensaje de que está bloqueado y servicio para validar sesión en caso de que en la tabla 
sesión se encuentre en true lanzará un sesión ya iniciada, de no ser así y el cliente esté desbloqueado y sesión en 0 mensaje 200 sesión iniciada correctamente.

**Video 4: Proyecto account**

Proyecto API RESTful con una base de datos en MySQL, tabla accounts, tercer tarea: servicio de traer información por customerNumber, además
de traer información de la tarjeta mediante un DTO para solo mostrar información de la cuenta.

**Video 5: Proyecto cards**

Proyecto API RESTful con una base de datos en MySQL, tabla cards, se empieza a usar FeignClient para desde account llamar a servicios externos 
en este caso de cards.

**Video 6**

Se comienza a pulir la seguridad de los microservicios para que con la generación del token en el login ese se use como customerNumber en 
las peticiones que se hagan en otros microservicios. La tarea del video es validar el token para que en caso de que sea incorrecto se 
lance un FORBIDDEN.

**Video 7**

Se añaden Packages para Excepciones y una clase para lanzar el UNAUTHORIZED y FORBIDDEN en proyecto login, cuidando la seguridad de no especificar que credencial que se está introduciendo está incorrecta para no dar pista a posibles Hackers, se maneja la sesión en una clase poniendo duración definida al token que indica cuanto puede durar la sesión activa, además de actualizar la base de datos la columna SESSION a true para también hacer esa validación de que ya tiene una sesión activa. De tarea hacer un servicio Delete para cerrar la sesión del usuario y meter el Pakage de Excepciones y la clase para lanzar el UNAUTHORIZED y FORBIDDEN en proyecto Accounts