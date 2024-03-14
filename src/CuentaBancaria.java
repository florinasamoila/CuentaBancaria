import java.util.InputMismatchException;
import java.util.Scanner;

public class CuentaBancaria {
    //colors
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

    //-----------------------------------------------------------------------------------------------------

    //SCANNER--------------------------------
    Scanner leer = new Scanner(System.in);

    //VARIABLES------------------------------
    private String iban;
    private String nombreCompleto;
    private float saldo;


    //CONSTRUCTORS-------------------------------------------------------------
    public CuentaBancaria( String nombreCompleto, float saldo) {
        this.iban = crecionIban();
        this.nombreCompleto = nombreCompleto;
        this.saldo = saldo;
    }

    public CuentaBancaria() {
    }

    //GETTERS AND SETTERS-------------------------------------------------------
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    //METHODS-------------------------------------------------------------------------------------------------

    public void imprimir() {
        System.out.println(ANSI_BLUE + "|---- 1   Datos de la cuenta---------|" + ANSI_RESET);
        System.out.println("IBAN: " + iban + "\nNombre Completo: " + nombreCompleto + "\nSaldo: " + saldo);
    }
    public void crearCuenta(){
        System.out.println("Dime tu nombre completo para crear la cuenta: ");
        String nombrePedido = leer.nextLine();

        if (!nombrePedido.equals("")) {
            setNombreCompleto(nombrePedido);
            setIban(crecionIban());
            setSaldo(0);
            mostrarMenu();
        }else {
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_RED +"ERROR: Introduce un nombre válido" +  ANSI_RESET);
        }
    }
    public String crecionIban(){
        String restoIban = "";
        int maximo = 22, minimo = 0;
        int aleatorio;
        for (int i = 0; i <= 22; i++) {
            aleatorio = (int) ((Math.random() * (maximo - minimo)) + minimo);
            restoIban += aleatorio;
        }

        return "ES"+restoIban;
    }
    public void mostrarMenu() {

        int opcion = 8;
            do {
                try {
                    System.out.println("+------------------------------------------+");
                    System.out.println(ANSI_YELLOW + "|----SELECCIONA LA OPERACIÓN A REALIZAR----|" + ANSI_RESET);
                    System.out.println("|---- 1   Datos de la cuenta---------------|");
                    System.out.println("|---- 2   IBAN-----------------------------|");
                    System.out.println("|---- 3   Titular--------------------------|");
                    System.out.println("|---- 4   Saldo----------------------------|");
                    System.out.println("|---- 5   Ingresar dinero en cuenta--------|");
                    System.out.println("|---- 6   Retirar dinero de cuenta---------|");
                    System.out.println(ANSI_RED + "|---- 7   Salir del programa---------------|" + ANSI_RESET);
                    System.out.println("+------------------------------------------+");
                    opcion = leer.nextInt();

                    switch (opcion) {
                        case 1:
                            imprimir();
                            break;
                        case 2:
                            mostrarIBAN();
                            break;
                        case 3:
                            mostrarTitular();
                            break;
                        case 4:
                            mostrarSaldo();
                            break;
                        case 5:
                            ingresar();
                            break;
                        case 6:
                            retirar();
                            break;
                        case 7:
                            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_RED +"Saliendo..."+ANSI_RESET);break;
                        default:
                            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_RED +"Opción incorrecta"+ANSI_RESET);
                    }
                }catch (InputMismatchException ime){
                    System.out.println(ANSI_BLACK_BACKGROUND + ANSI_RED +"No has introducido ningún valor numérico, inténtalo de nuevo, porfavor"+ANSI_RESET);
                    leer.nextLine();
                }
            } while (opcion != 7);
    }
    private void retirar() {
        System.out.println(ANSI_BLUE + "|---- 6   Retirar dinero de cuenta---------|" + ANSI_RESET);
        System.out.println("¿Cuánto dinero quieres retirar?");
        int respuesta = leer.nextInt();

        if (getSaldo() - respuesta < -50 ) {
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_RED +"AVISO: No puedes tener un saldo en negativo (no inferior a -50)"+ANSI_RESET);

        } else if (respuesta <= 0) {
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_RED +"No se puede retirar una cantidad negativa o nula"+ANSI_RESET);
        }else if (respuesta > 3000 ) {
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_RED +"AVISO: Notificar a hacienda"+ANSI_RESET);
            setSaldo(getSaldo() - respuesta);
        }else {
            setSaldo(getSaldo() - respuesta);
        }
        imprimir();
    }
    private void ingresar() {
        System.out.println(ANSI_BLUE + "|---- 5   Ingresar dinero en cuenta---------|" + ANSI_RESET);
        System.out.println("¿Cuánto dinero quieres ingresar?");
        int respuesta = leer.nextInt();
        if (respuesta <=0) {
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_RED +"AVISO: Ingresa una cantidad mayor a 0"+ANSI_RESET);
        } else if (respuesta >= 3000 ) {
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_RED +"AVISO: Notificar a hacienda"+ANSI_RESET);
            setSaldo(getSaldo() + respuesta);
        } else{
            setSaldo(getSaldo()+respuesta);
        }
        imprimir();
    }
    private void mostrarSaldo() {
        System.out.println(ANSI_BLUE + "|---- 4   Saldo---------|" + ANSI_RESET);
        System.out.println("Saldo: " + this.saldo);
    }
    private void mostrarTitular() {
        System.out.println(ANSI_BLUE + "|---- 3   Titular---------|" + ANSI_RESET);
        System.out.println("Titular: " + this.nombreCompleto);
    }
    private void mostrarIBAN() {
        System.out.println(ANSI_BLUE + "|---- 2   IBAN---------|" + ANSI_RESET);
        System.out.println("IBAN: " + iban);
    }
}
