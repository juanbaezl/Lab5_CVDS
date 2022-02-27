# LABORATORIO 5 - MVC PRIMEFACES INTRODUCTION


## ESCUELA COLOMBIANA DE INGENIERÍA
## INTRODUCCIÓN A PROYECTOS WEB
### PARTE I. - JUGANDO A SER UN CLIENTE HTTP
1. Abra una terminal Linux o consola de comandos Windows.
2. Realice una conexión síncrona TCP/IP a través de Telnet/Netcat al siguiente servidor:
    - Host: www.escuelaing.edu.co
    - Puerto: 80
    Teniendo en cuenta los parámetros del comando telnet:
    telnet HOST PORT
3. Antes de que el servidor cierre la conexión por falta de comunicación:
    - Revise la página 36 del RFC del protocolo HTTP, sobre cómo realizar una petición GET. Con esto, solicite al servidor el recurso ‘sssss/abc.html’, usando la versión 1.0 de HTTP.  
    Para esto usaremos 
    <pre>GET /sssss/abc.html HTTP/1.0</pre> 
    seguido de
    <pre>Host: escuelaing.edu.co</pre> 
    - Asegúrese de presionar ENTER dos veces después de ingresar el comando.
    - Revise el resultado obtenido. ¿Qué codigo de error sale?, revise el significado del mismo en la lista de códigos de estado HTTP.
    ![](./img/telnetError.png)
    301 Moved Permanently: Esta y todas las solicitudes futuras deben dirigirse al URI dada.
    - ¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?
        1. 1xx informational response – la solicitud fue recibida, proceso continuo
        2. 2xx successful – la solicitud fue recibida, comprendida y aceptada con éxito
        3. 3xx redirection – Se deben tomar más medidas para completar la solicitud.
        4. 4xx client error –la solicitud contiene una sintaxis incorrecta o no se puede cumplir
        5. 5xx server error –el servidor no cumplió con una solicitud aparentemente válida
4. Realice una nueva conexión con telnet, esta vez a:
    - Host: www.httpbin.org
    - Puerto: 80
    - Versión HTTP: 1.1
    Ahora, solicite (GET) el recurso /html. ¿Qué se obtiene como resultado?

    ![](./img/telnetAprobado.png)

¡Muy bien!, ¡Acaba de usar del protocolo HTTP sin un navegador Web!. Cada vez que se usa un navegador, éste se conecta a un servidor HTTP, envía peticiones (del protocolo HTTP), espera el resultado de las mismas, y -si se trata de contenido HTML- lo interpreta y dibuja.

5. Seleccione el contenido HTML de la respuesta y copielo al cortapapeles CTRL-SHIFT-C. Ejecute el comando wc (word count) para contar palabras con la opción -c para contar el número de caracteres:

    <pre>wc -c</pre>

    Pegue el contenido del portapapeles con CTRL-SHIFT-V y presione CTRL-D (fin de archivo de Linux). Si no termina el comando wc presione CTRL-D de nuevo. No presione mas de dos veces CTRL-D indica que se termino la entrada y puede cerrarle la terminal. Debe salir el resultado de la cantidad de caracteres que tiene el contenido HTML que respondió el servidor.

    ![](./img/contadorPalabras.png)

    Claro está, las peticiones GET son insuficientes en muchos casos. Investigue: ¿Cuál es la diferencia entre los verbos GET y POST? ¿Qué otros tipos de peticiones existen?
    1. En el tipo de petición GET los parámetros URL se guardan junto al URL mientras que con POST no. Por lo que POST ofrece mayor discreción debido a que tampoco se guardan los parámetros URL en el caché ni en el registro del servidor caso contrario en GET que se guardan sin cifrar.
    2. - OPTIONS
        - HEAD solo revisa los headers
        - PUT deposita en la ubicación de destino
        - DELETE elimina en la ubicación de destino
        - CONNECT
        - TRACE

6. En la practica no se utiliza telnet para hacer peticiones a sitios web sino el comando curl con ayuda de la linea de comandos:

    <pre>curl www.httpbin.org</pre>
    ![](./img/curl.png)
    Utilice ahora el parámetro -v y con el parámetro -i:
    <pre> curl -v www.httpbin.org</pre>
    ![](./img/curlParametroV.png)
    <pre>curl -i www.httpbin.org</pre>
    ![](./img/curlParametroI.png)

¿Cuáles son las diferencias con los diferentes parámetros?  
- curl -v Make the operation more talkative

- curl -i Include protocol response headers in the output

- como se ve en la imágenes el i incluye todo el protocolo de respuesta la v hacia una mayor descripción de todo lo que pasa