//aun me falta hacer que juegue con un rival
package gato;

import java.util.Scanner;

/**
 *
 * @author Sony
 */
public class Gato {

    private static String gato[][]= {{"1","2","3"},
            {"4","5","6"},
            {"7","8","9"}};
    private static int turno=0;
    private static int turnos=0;
    
    public static void main(String[] args) {
        imprimir();
        for (int turnos = 0; turnos < 9; turnos++) {
        if (turnos<5) {
            jugar();
            System.out.println(turnos);
            imprimir();
        }else{
            jugar();
            System.out.println(turnos);
            verificar();
            imprimir();
        }
        }
        
        
    }
        
    public static void imprimir(){
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j <3; j++) {
                System.out.print(gato[i][j]);
                if (j!=2)
                    System.out.print("\t");
            }
            System.out.println("|");
        }
    }
    
    public static void verificar(){
        int ganador=0;
        for (int i = 0; i < 3; i++) {
            if(gato[0][i]=="X" && gato[1][i]=="X" && gato[2][i]=="X" ){
                ganador=1;
            }
            if(gato[i][0]=="X" && gato[i][1]=="X" && gato[i][2]=="X" ){
                ganador=1;
            }
            if(gato[0][0]=="X" && gato[1][1]=="X" && gato[2][2]=="X" ){
                ganador=1;
            }
            if(gato[0][2]=="X" && gato[1][1]=="X" && gato[2][0]=="X" ){
                ganador=1;
            }
            if(gato[0][i]=="O" && gato[1][i]=="O" && gato[2][i]=="O" ){
                ganador=1;
            }
            if(gato[i][0]=="O" && gato[i][1]=="O" && gato[i][2]=="O" ){
                ganador=1;
            }
            if(gato[0][0]=="O" && gato[1][1]=="O" && gato[2][2]=="O" ){
                ganador=1;
            }
            if(gato[0][2]=="O" && gato[1][1]=="O" && gato[2][0]=="O" ){
                ganador=1;
            }
        }
        if(ganador==1){
            System.out.println("ganaste J1");
        }
        if(ganador==2){
            System.out.println("ganaste J2");
        }
    }
    
    public static void jugar(){
        Scanner teclado = new Scanner(System.in);
        
        if(turno==0){
            System.out.println("En que posicion desea Jugar J1?");
        int pos= Integer.parseInt(teclado.nextLine());
            if(pos==1){
                gato[0][0]="X";
            }
            if(pos==2){
                gato[0][1]="X";
            }
            if(pos==3){
                gato[0][2]="X";
            }
            if(pos==4){
                gato[1][0]="X";
            }
            if(pos==5){
                gato[1][1]="X";
            }
            if(pos==6){
                gato[1][2]="X";
            }
            if(pos==7){
                gato[2][0]="X";
            }
            if(pos==8){
                gato[2][1]="X";
            }
            if(pos==9){
                gato[2][2]="X";
            }
            turno=1;
        }else{
            System.out.println("En que posicion desea Jugar J2?");
        int pos= Integer.parseInt(teclado.nextLine());
            if(pos==1){
                gato[0][0]="O";
            }
            if(pos==2){
                gato[0][1]="O";
            }
            if(pos==3){
                gato[0][2]="O";
            }
            if(pos==4){
                gato[1][0]="O";
            }
            if(pos==5){
                gato[1][1]="O";
            }
            if(pos==6){
                gato[1][2]="O";
            }
            if(pos==7){
                gato[2][0]="O";
            }
            if(pos==8){
                gato[2][1]="O";
            }
            if(pos==9){
                gato[2][2]="O";
            }
            turno=0;
        }
    }
    
}
