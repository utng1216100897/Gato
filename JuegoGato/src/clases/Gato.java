/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author gerardo
 */
public class Gato {

    private String jugador1; // dara el nombre del jugador 1
    private String jugador2; // dara el nombre del jugador 2
    private int tiro1; //tiro del jugador 1: 1="X" 2="O";
    private int tiro2;
    private boolean banTurnoJ1;// <-- true = jugador1
    private int tiros;// <--- numero de tiros

    private int[][] datos; //arreglo para los datos

    public Gato() {
        datos = new int[3][3];
        banTurnoJ1 = true;
//        tiro1 = 1;
//        tiro2 = 2;
    }
    /**
     * da un valor para ver quien tira primero
     * @param banTurnoJ1 
     */

    public void setBanTurnoJ1(boolean banTurnoJ1) {
        this.banTurnoJ1 = banTurnoJ1;
    }
    

    /**
     * realiza un borrado de los datos
     */
    public void reiniciar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                datos[i][j] = 0;
            }
        }
        tiros = 0;
       
    }
    
    /**
     * indica si se dio un empate
     * @return 
     */

    public boolean esEmpate() {
        return (tiros == 9);
    }

    /**
     * pone el tiro segun el jugador
     * @param pos 
     */
    public void setTiro(int pos) {
        int x;
        int y;
        if (tiros < 9) {

            x = pos / 3;  //fila
            y = pos % 3;  // columna
            if (banTurnoJ1) {
                datos[x][y] = tiro1;
            } else {
                datos[x][y] = tiro2;
            }
            tiros++;
        }
    }
    
   /**
    * devuelve si ya se gano y en donde se gano
    * @return 
    */ 

    public int  yaGano() {
        int salida=0; // cero es igual no se ha ganado!!
        for (int i = 0; i < 3; i++) {

            if (datos[i][0] != 0 && datos[i][0] == datos[i][1] && datos[i][0] == datos[i][2]) {
                salida= i+1; // fila 1, fila 2, y fila 3
            }
        }
        for (int j = 0; j < 3; j++) {
            if (datos[0][j] != 0 && datos[0][j] == datos[1][j] && datos[0][j] == datos[2][j]) {
                salida=j+4; // columnas 4, 5 y 6;

            }
            
            if (datos[0][0] != 0 && datos[0][0] == datos[1][1] && datos[0][0] == datos[2][2]) {
                salida=7; // diagonal 7
            }
            
            if (datos[0][2] != 0 && datos[0][2] == datos[1][1] && datos[0][2] == datos[2][0]) {
                salida=8;  // diagonal 8
            }
            
        }
        return salida;
    }
    
    /**
     * pone el valor del tiro1 y del tiro2
     * @param tiro 
     */

    public void setTiro1(int tiro) {
        this.tiro1 = tiro;
        if (tiro1 == 1) {    // si es una "X"
            tiro2 = 2;      // le toca un "O"
        } else {
            tiro2 = 1;   // le toca una "X"
        }
    }
    
    /**
     * verfica si la posicion es valida
     * @param pos
     * @return 
     */

    public boolean verificar(int pos) {
        int x;
        int y;
        x = pos / 3; //Fila
        y = pos % 3; //Columna
        if (datos[x][y] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public String getJugador1() {
        return jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public int getTiro1() {
        return tiro1;
    }

    public int getTiro2() {
        return tiro2;
    }

    /**
     * cambia el turno de los jugadores
     */
    public void cambiarTurno() {
        if (banTurnoJ1) {
            banTurnoJ1 = false;
        } else {
            banTurnoJ1 = true;
        }

    }

    public boolean isBanTurnoJ1() {
        return banTurnoJ1;
    }

}
