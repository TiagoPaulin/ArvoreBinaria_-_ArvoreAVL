import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        RefatorandoAvl arvore = new RefatorandoAvl();
        ArvoreAvl arvoreAvl = new ArvoreAvl();

//        arvore.inserir(20);
//        arvore.imprimir();
//        arvore.inserir(40);
//        arvore.imprimir();
//        arvore.inserir(25);
//        arvore.imprimir();
//        arvoreBinaria.inserir(14);
//        arvoreBinaria.inserir(15);
//        arvoreBinaria.inserir(4);
//        arvoreBinaria.inserir(9);
//        arvoreBinaria.inserir(7);
//        arvoreBinaria.inserir(18);
//        arvoreBinaria.inserir(3);
//        arvoreBinaria.inserir(5);
//        arvoreBinaria.inserir(16);
//        arvoreBinaria.inserir(4);
//        arvoreBinaria.inserir(20);
//        arvoreBinaria.inserir(17);
//        arvoreBinaria.inserir(9);
//        arvoreBinaria.inserir(14);
//        arvoreBinaria.inserir(5);
//
//        arvoreBinaria.imprimir();
//        System.out.println("\n");

//        arvoreAvl.inserir(14);
//        arvoreAvl.inserir(15);
//        arvoreAvl.inserir(4);
//        arvoreAvl.inserir(9);
//        arvoreAvl.inserir(7);
//        arvoreAvl.inserir(18);
//        arvoreAvl.inserir(3);
//        arvoreAvl.inserir(5);
//        arvoreAvl.inserir(16);
//        arvoreAvl.inserir(4);
//        arvoreAvl.inserir(20);
//        arvoreAvl.inserir(17);
//        arvoreAvl.inserir(9);
//        arvoreAvl.inserir(14);
//        arvoreAvl.inserir(5);

        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < 1000; i ++){
            int v = random.nextInt(100) + 1;
            arvore.inserir(v);
            arvore.preOrdem(arvore.getRaiz());
            System.out.println("\n");
        }
//        arvoreAvl.imprimir();
//        System.out.println("\n");

//        while(true){
//            int dado = sc.nextInt();
//            arvoreAvl.inserir(dado);
//            arvoreAvl.imprimir();
//        }






//      34 32 90 31 91 58 35 14 26 79 34 84 77 61 85 32 28 98 62 60


//        arvoreAvl.inserir(75);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(16);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(23);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(38);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(32);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(61);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(89);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(66);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(7);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(2);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(91);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(48);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(3);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(2);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(61);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(1);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(1);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(98);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(62);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//        arvoreAvl.inserir(60);
//        arvoreAvl.preOrdem(arvoreAvl.getRaiz());
//        System.out.println("\n");
//
//        arvoreAvl.imprimir();
//        System.out.println("\n");
    }
}