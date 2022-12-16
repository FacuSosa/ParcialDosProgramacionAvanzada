# ParcialDosProgramacionAvanzada

Escribir las clases necesarias para controlar el acceso de clientes a un servicio
mecánico.
Cada cliente tiene un nombre, un número de móvil.
Junto al cliente se guarda su fecha y hora de llegada, y su fecha y hora de atención.

## Funcionalidades requeridas:

• Añadir un cliente (nuevoCliente).

• Atender a un cliente (atenderCliente). Retorna el cliente atendido y lanzará
una Exception en el caso de no haber clientes que atender.

• Obtener el tiempo medio de espera de los clientes que aún no han sido
atendidos (tiempoEsperaNoAtendidos). Expresado en minutos.

• Obtener el tiempo medio de espera de los clientes ya atendidos
(tiempoEsperaAtendidos).

• Obtener cantidad de clientes en espera
(obtenerCantidadClientesEnEspera).

• Obtener cantidad de clientes atendidos (obtenerCantidadClientesAtenidos)

### Nota:

Para la fecha y hora usar la clase predefinida Calendar.
Vamos a implementar la clase Reloj, que nos dará una medida para calcular el
tiempo que tarda en ser atendido un cliente:


```java
import java.util.Calendar;
/**
* Clase que permite obtener la fecha y hora actual,
* en milisegundos desde la época
*/
public class Reloj {
public static long ahora() {
return Calendar.getInstance().getTimeInMillis();
}
}
```
Implementar al menos CINCO (5) casos de prueba representativos de la clase que
controla el acceso al servicio y uno de ellos debe ser la prueba de Exception.
