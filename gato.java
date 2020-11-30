
package gato;

import java.util.Arrays;
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
    private static int ganador=0;
    private static int utl[]=new int[9];
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
       
        System.out.println("Desea Iniciar? 1-Si/2-No");
        int res= Integer.parseInt(teclado.nextLine());
        if(res==1){
            turno=1;
        }else{
            turno=0;
        }
        imprimir();
        
        for ( turnos = 0; turnos < 9; turnos++) {
        if (turnos<5) {
            if (turno==0) {
                calcularUtl();
                imprimir();
            } else {
                jugar();
                System.out.println("TURNO: "+turnos);
                imprimir();
            }
            
        }else{
            if (turno==0) {
                calcularUtl();
                imprimir();
            } else {
                jugar();
                System.out.println("TURNO: "+turnos);
                verificar();
            if (ganador!=0) {
                imprimir();
                System.out.println("Felicidades J"+ganador+" GANASTE");
                break;
            } else {
                imprimir();
            }
            }
            
            
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
    
    public static void calcularUtl(){
        if (turnos==0) {
            gato[0][0]="X";
            
        } else {
            for (int p = 1; p < 9; p++) {
                //////
                if(p==1){
                if (gato[0][0]=="X" || gato[0][0]=="O") {
                    utl[p-1]=0;
                }else{
                    calc(p);
                }                
            }
            if(p==2){
                if (gato[0][1]=="X" || gato[0][1]=="O") {
                    utl[p-1]=0;
                }else{
                    calc(p);
                }                        
            }
            if(p==3){
                if (gato[0][2]=="X" || gato[0][2]=="O") {
                    utl[p-1]=0;
                }else{
                    calc(p);
                }          
            }
            if(p==4){
                if (gato[1][0]=="X" || gato[1][0]=="O") {
                    utl[p-1]=0;
                }else{
                    calc(p);
                }          
            }
            if(p==5){
                if (gato[1][1]=="X" || gato[1][1]=="O") {
                    utl[p-1]=0;
                }else{
                    calc(p);
                }          
            }
            if(p==6){
                if (gato[1][2]=="X" || gato[1][2]=="O") {
                    utl[p-1]=0;
                }else{
                    calc(p);
                }          
            }
            if(p==7){
                if (gato[2][0]=="X" || gato[2][0]=="O") {
                    utl[p-1]=0;
                }else{
                    calc(p);
                }          
            }
            if(p==8){
                if (gato[2][1]=="X" || gato[2][1]=="O") {
                    utl[p-1]=0;
                }else{
                    calc(p);
                }          
            }
            if(p==9){
                if (gato[2][2]=="X" || gato[2][2]=="O") {
                    utl[p-1]=0;
                }else{
                    calc(p);
                }          
            }
            }
            int maxValue = Arrays.stream(utl).max().getAsInt();
            for (int i = 0; i < utl.length; i++) {
                if (utl[i]==maxValue) {
                    int pm=i+1;
                    jugarm(pm);
                    break;
                }
                
            }
        }
    }
    
    public static void calc(int pos){
        int x=0;
        int y=0;
        int utilidad;  
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
        for (int i = 0; i < 3; i++) {
                if(gato[0][i]!="X" && gato[1][i]!="X" && gato[2][i]!="X" ){
                    y++;
                }
                if(gato[i][0]!="X" && gato[i][1]!="X" && gato[i][2]!="X" ){
                    y++;
                }
                if(gato[0][0]!="X" && gato[1][1]!="X" && gato[2][2]!="X" ){
                    y++;
                }
                if(gato[0][2]!="X" && gato[1][1]!="X" && gato[2][0]!="X" ){
                    y++;
                }
                if(gato[0][i]!="O" && gato[1][i]!="O" && gato[2][i]!="O" ){
                    x++;
                }
                if(gato[i][0]!="O" && gato[i][1]!="O" && gato[i][2]!="O" ){
                    x++;
                }
                if(gato[0][0]!="O" && gato[1][1]!="O" && gato[2][2]!="O" ){
                    x++;
                }
                if(gato[0][2]!="O" && gato[1][1]!="O" && gato[2][0]!="O" ){
                    x++;
                }
        }
            utilidad=x-y;
            utl[pos-1]=utilidad;
            if(pos==1){
                gato[0][0]="1";
            }
            if(pos==2){
                gato[0][1]="2";
            }
            if(pos==3){
                gato[0][2]="3";
            }
            if(pos==4){
                gato[1][0]="4";
            }
            if(pos==5){
                gato[1][1]="5";
            }
            if(pos==6){
                gato[1][2]="6";
            }
            if(pos==7){
                gato[2][0]="7";
            }
            if(pos==8){
                gato[2][1]="8";
            }
            if(pos==9){
                gato[2][2]="9";
            }
    }
    
    public static int jugar(){
        Scanner teclado = new Scanner(System.in);
        
        if(turno==0){
            System.out.println("En que posicion desea Jugar J1?");
        int pos= Integer.parseInt(teclado.nextLine());
            if(pos==1){
                if (gato[0][0]=="X" || gato[0][0]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[0][0]="X";
            }
            if(pos==2){
                if (gato[0][1]=="X" || gato[0][1]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[0][1]="X";
            }
            if(pos==3){
                if (gato[0][2]=="X" || gato[0][2]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[0][2]="X";
            }
            if(pos==4){
                if (gato[1][0]=="X" || gato[1][0]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[1][0]="X";
            }
            if(pos==5){
                if (gato[1][1]=="X" || gato[1][1]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[1][1]="X";
            }
            if(pos==6){
                if (gato[1][2]=="X" || gato[1][2]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[1][2]="X";
            }
            if(pos==7){
                if (gato[2][0]=="X" || gato[2][0]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[2][0]="X";
            }
            if(pos==8){
                if (gato[2][1]=="X" || gato[2][1]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[2][1]="X";
            }
            if(pos==9){
                if (gato[2][2]=="X" || gato[2][2]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[2][2]="X";
            }
            turno=1;
            return turno;
        }else{
            System.out.println("En que posicion desea Jugar J2?");
        int pos= Integer.parseInt(teclado.nextLine());
            if(pos==1){
                if (gato[0][0]=="X" || gato[0][0]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[0][0]="O";
            }
            if(pos==2){
                if (gato[0][1]=="X" || gato[0][1]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[0][1]="O";
            }
            if(pos==3){
                if (gato[0][2]=="X" || gato[0][2]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[0][2]="O";
            }
            if(pos==4){
                if (gato[1][0]=="X" || gato[1][0]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[1][0]="O";
            }
            if(pos==5){
                if (gato[1][1]=="X" || gato[1][1]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[1][1]="O";
            }
            if(pos==6){
                if (gato[1][2]=="X" || gato[1][2]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[1][2]="O";
            }
            if(pos==7){
                if (gato[2][0]=="X" || gato[2][0]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[2][0]="O";
            }
            if(pos==8){
                if (gato[2][1]=="X" || gato[2][1]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[2][1]="O";
            }
            if(pos==9){
                if (gato[2][2]=="X" || gato[2][2]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[2][2]="O";
            }
            turno=0;
            return turno;
        }
    }
    
    public static int jugarm(int pos){
         if(pos==1){
                if (gato[0][0]=="X" || gato[0][0]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[0][0]="X";
            }
            if(pos==2){
                if (gato[0][1]=="X" || gato[0][1]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[0][1]="X";
            }
            if(pos==3){
                if (gato[0][2]=="X" || gato[0][2]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[0][2]="X";
            }
            if(pos==4){
                if (gato[1][0]=="X" || gato[1][0]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[1][0]="X";
            }
            if(pos==5){
                if (gato[1][1]=="X" || gato[1][1]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[1][1]="X";
            }
            if(pos==6){
                if (gato[1][2]=="X" || gato[1][2]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[1][2]="X";
            }
            if(pos==7){
                if (gato[2][0]=="X" || gato[2][0]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[2][0]="X";
            }
            if(pos==8){
                if (gato[2][1]=="X" || gato[2][1]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[2][1]="X";
            }
            if(pos==9){
                if (gato[2][2]=="X" || gato[2][2]=="O") {
                    System.out.println("Esa posicion ya esta ocupada elija otrar por favor.");
                    turnos--;
                    return turnos;
                }
                gato[2][2]="X";
            }
            turno=1;
            return turno;
    }
    
}
