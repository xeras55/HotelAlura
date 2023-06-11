<h1>Challenge Oracle One - Hotel Alura</h1>
<header><img src="src\main\java\imagenes\aH-150px.png" alt=""></header>
<h2>Descripción</h2>
 <p>Actividad presentada por el equipo de Oracle ONE para poner a prueba las habilidades obtenidas durante el curso. Enfocado principalmente al uso de JDBC para poder conectarnos a bases de datos.
</p>
 <h2>Funciones principales </h2>
<ul>
  <li>Login: permite acceder de forma sencilla únicamente como administrador.</li>
  <li>Reservas: permite crear, editar y borrar reservas.</li>
  <li>Huéspedes: permite crear, editar, borrar los datos de los huéspedes.</li>
  <li>Búsqueda: permite buscar de distintas formas, ya sea las reservas o los huéspedes.</li>
</ul>
<h2>Tecnologías utilizadas:</h2>
<ul>
  <li>MySQL Community Server</li>
  <li>VS Code</li>
  <li>Java</li>
</ul>
<h2>Aplicación</h2>
<h3>1.- Registro reserva</h3>
<p>Registramos la reserva ingresando la fecha de entrada, fecha de salida, el valor que tiene dicha reserva y el método de pago.</p>
<img src="src\main\java\imagenes\screens\primer.jpg">
<h3>Registro de los huéspedes</h3>

<p>El usuario quedará registrado y será ligado automáticamente a la reserva echa anteriormente, se ingresará el nombre, apellido y fecha de nacimiento y se omitirá la opción de agregar la reserva.</p>
<img src="src\main\java\imagenes\screens\segundo.jpg">
<h3>Búsqueda de las reservas</h3>
<p>Para poder buscar las reservas podemos usar únicamente el id, en caso de que el cliente no recuerde su id, podremos buscar al huésped de distintas formas.</p>
<img src="src\main\java\imagenes\screens\busquedaR.png">
<h3>Búsqueda Huéspedes</h3>
<p>Para buscar a los huéspedes tenemos dos métodos, el primero es con el id.</p>
<img src="src\main\java\imagenes\screens\busquedaH1.png">

<p>Como segundo método tenemos la búsqueda por nombre y fecha de nacimiento, de esta forma tenemos una opción más exacta para ubicar al huésped, si es que no recordara su id, es importante ingresar la información de en el formato correcto que sería: nombre dd/mm/yyyy.</p>
<img src="src\main\java\imagenes\screens\busquedaH2.png">
<p>Si no se ingresara información aparecerá una alerta indicándolo, así como una para indicar que información se está ingresando mal.</p>
<img src="src\main\java\imagenes\screens\busquedasinId.png">
<img src="src\main\java\imagenes\screens\busquedaSinFecha.png">
<img src="src\main\java\imagenes\screens\busquedaSinDia.png">