package Butelka;

public class Butelka {

    private double ileLitrow;
    private double pojemnosc;
    private int id;
    private static int nastepneId = 1;

    Butelka(double pojemnosc, double ileLitrow){
        this.id += nastepneId;
        nastepneId++;
        this.pojemnosc = pojemnosc;
        if(ileLitrow <= pojemnosc)
            this.ileLitrow = ileLitrow;
        else {
            System.out.println("butelka " + id + " jest przepełniona!");
            this.ileLitrow = -1;
        }
    }

    double getIleLitrow() {
        return ileLitrow;
    }

    double getPojemnosc(){
        return pojemnosc;
    }

    boolean wlej(double ilosc){
        if(ilosc + this.ileLitrow <= this.pojemnosc) {
            this.ileLitrow += ilosc;
            return true;
        }
        else {
            System.out.println("za dużo chcesz wlać do butelki, wyleje się! ID:" + id);
            return false;
        }
    }

    boolean wylej(double ilosc){
        if(ilosc <= ileLitrow) {
            this.ileLitrow -= ilosc;
            return true;
        }
        else {
            System.out.println("za mało jest w tej butelce, nie wystarczy wody! ID:" + id);
            return false;
        }
    }

    void przelejDo(Butelka gdziePrzelac, double ilosc) {
        if (this.ileLitrow >= ilosc && gdziePrzelac.pojemnosc >= ilosc + gdziePrzelac.ileLitrow) {
            this.wylej(ilosc);
            gdziePrzelac.wlej(ilosc);
        }
        else
            System.out.println("nie mozna przelac");
    }

    public static void main(String[] args) {

        //tworzenie butelek o konkretnych wlasnosciach
        Butelka[] butelka = new Butelka[3];
        System.out.println("POCZATKOWE WARTOSCI");
        for(int i = 0; i < butelka.length; i++){
            butelka[i] = new Butelka((i+1)*10, i+5);
            System.out.println("Pojemność(" + (i+1) + "):" + butelka[i].pojemnosc);
            System.out.println("Zawartość(" + (i+1) + "):" + butelka[i].ileLitrow);
        }

        //operacje na butelkach
        butelka[1].wlej(100);
        butelka[0].wylej(200);
        butelka[2].przelejDo(butelka[0], 8);
        butelka[2].przelejDo(butelka[0], 7);
        butelka[2].przelejDo(butelka[0], 5);


        //wypisanie wynikow koncowych
        System.out.println("WYNIKI");
        for(int i = 0; i < butelka.length; i++){
            System.out.println("butelka " + (i+1) + " :" +butelka[i].getIleLitrow() + " litrów");
        }

    }
}
