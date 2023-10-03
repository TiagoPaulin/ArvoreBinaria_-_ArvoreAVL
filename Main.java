public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        ArvoreAvl arvoreAvl = new ArvoreAvl();

        arvoreBinaria.inserir(14);
        arvoreBinaria.inserir(15);
        arvoreBinaria.inserir(4);
        arvoreBinaria.inserir(9);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(18);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(16);
        arvoreBinaria.inserir(4);
        arvoreBinaria.inserir(20);
        arvoreBinaria.inserir(17);
        arvoreBinaria.inserir(9);
        arvoreBinaria.inserir(14);
        arvoreBinaria.inserir(5);

        arvoreBinaria.imprimir();
        System.out.println("\n");

        arvoreAvl.inserir(14);
        arvoreAvl.inserir(15);
        arvoreAvl.inserir(4);
        arvoreAvl.inserir(9);
        arvoreAvl.inserir(7);
        arvoreAvl.inserir(18);
        arvoreAvl.inserir(3);
        arvoreAvl.inserir(5);
        arvoreAvl.inserir(16);
        arvoreAvl.inserir(4);
        arvoreAvl.inserir(20);
        arvoreAvl.inserir(17);
        arvoreAvl.inserir(9);
        arvoreAvl.inserir(14);
        arvoreAvl.inserir(5);

        arvoreAvl.imprimir();
        System.out.println("\n");
    }
}