

//        El programa pedirá los datos necesarios para crear una cuenta bancaria. Si son
//        válidos, creará la cuenta y mostrará el menú principal para permitir actuar sobre
//        la cuenta. Tras cada acción se volverá a mostrar el menú.
//           1. Datos de la cuenta. Mostrará el IBAN, el titular y el saldo.
//           2. IBAN. Mostrará el IBAN.
//           3. Titular. Mostrará el titular.
//           4. Saldo. Mostrará el saldo disponible.
//           5. Ingreso. Pedirá la cantidad a ingresar y realizará el ingreso si es posible.
//           6. Retirada. Pedirá la cantidad a retirar y realizará la retirada si es posible.
//           7. Salir. Termina el programa.
//
public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria();
        CuentaBancaria cuenta2 = new CuentaBancaria("Jhon Doe",1000);
        cuenta2.crearCuenta();
        //cuenta2.mostrarMenu();
    }


}