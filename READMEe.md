# Cuenta Bancaria Program

Este programa simula un sistema bancario básico que permite a los usuarios crear una cuenta bancaria y realizar diversas operaciones, como consultar detalles de la cuenta, ingresar dinero, retirar dinero, y más.

## Archivos Principales

### `Main.java`
El archivo `Main.java` es el punto de entrada del programa. Contiene el método `main`, que inicializa y utiliza la clase `CuentaBancaria` para demostrar las funcionalidades del sistema bancario.

#### Características Clave
1. **Creación de Cuentas**:
   - Se pueden crear cuentas bancarias con o sin detalles iniciales.
   - Ejemplo:
     ```java
     CuentaBancaria cuenta1 = new CuentaBancaria();
     CuentaBancaria cuenta2 = new CuentaBancaria("Jhon Doe", 1000);
     ```

2. **Demostración**:
   - El método `crearCuenta()` se utiliza para simular la creación de una cuenta.
   - El método `mostrarMenu()` (comentado en el código) permite interactuar con la cuenta a través de un menú.

3. **Ejecución**:
   - Compila y ejecuta el programa para probar las funcionalidades básicas.

---

### `CuentaBancaria.java`
El archivo `CuentaBancaria.java` contiene la implementación de la clase `CuentaBancaria`, que maneja la lógica principal del sistema bancario.

#### Características Clave
1. **Atributos**:
   - `iban`: Identificador único de la cuenta bancaria, generado automáticamente.
   - `nombreCompleto`: Nombre del titular de la cuenta.
   - `saldo`: Saldo actual de la cuenta.

2. **Constructores**:
   - Constructor con parámetros para inicializar una cuenta con un titular y saldo inicial.
   - Constructor vacío para crear una cuenta sin detalles iniciales.

3. **Métodos Principales**:
   - **`crearCuenta()`**:
     Solicita el nombre del titular y crea una cuenta con un IBAN generado automáticamente y saldo inicial de 0.
   - **`mostrarMenu()`**:
     Muestra un menú interactivo para realizar las siguientes operaciones:
     1. Ver datos de la cuenta (IBAN, titular, saldo).
     2. Ver el IBAN.
     3. Ver el titular.
     4. Ver el saldo.
     5. Ingresar dinero.
     6. Retirar dinero.
     7. Salir del programa.
   - **`imprimir()`**:
     Muestra los detalles de la cuenta (IBAN, titular, saldo).
   - **`ingresar()`**:
     Permite ingresar dinero en la cuenta, con validaciones para cantidades negativas o superiores a 3000 (requiere notificación a Hacienda).
   - **`retirar()`**:
     Permite retirar dinero, asegurando que el saldo no sea inferior a -50 y validando cantidades negativas o superiores a 3000.
   - **`crecionIban()`**:
     Genera un IBAN aleatorio con el prefijo "ES".
   - Métodos auxiliares como `mostrarSaldo()`, `mostrarTitular()` y `mostrarIBAN()` para mostrar información específica de la cuenta.

4. **Validaciones**:
   - Evita saldos negativos inferiores a -50.
   - Notifica a Hacienda para transacciones mayores a 3000.
   - Maneja errores de entrada con excepciones (`InputMismatchException`).

---

## Cómo Ejecutar el Programa
1. Asegúrate de que los archivos `Main.java` y `CuentaBancaria.java` estén en el mismo paquete o directorio.
2. Compila los archivos:
   ```bash
   javac Main.java CuentaBancaria.java
