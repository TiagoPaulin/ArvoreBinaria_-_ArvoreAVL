import java.util.Random;

public class Main {
    public static void main(String[] args) {

//        =========== TESTES PARA AS DUAS ARVORES ===========

        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
//
//        arvoreBinaria.inserir(34);
//        arvoreBinaria.inserir(32);
//        arvoreBinaria.inserir(90);
//        arvoreBinaria.inserir(31);
//        arvoreBinaria.inserir(91);
//        arvoreBinaria.inserir(58);
//        arvoreBinaria.inserir(35);
//        arvoreBinaria.inserir(14);
//        arvoreBinaria.inserir(26);
//        arvoreBinaria.inserir(79);
//        arvoreBinaria.inserir(84);
//        arvoreBinaria.inserir(77);
//        arvoreBinaria.inserir(61);
//        arvoreBinaria.inserir(85);
//        arvoreBinaria.inserir(28);
//        arvoreBinaria.inserir(98);
//        arvoreBinaria.inserir(62);
//        arvoreBinaria.inserir(60);
//
//        arvoreBinaria.imprimir();
//
//        arvoreBinaria.remover(14);
//        arvoreBinaria.remover(28);
//
//        arvoreBinaria.imprimir();
//
        ArvoreAvl arvoreAvl = new ArvoreAvl();
//
//        arvoreAvl.inserir(34);
//        arvoreAvl.inserir(32);
//        arvoreAvl.inserir(90);
//        arvoreAvl.inserir(31);
//        arvoreAvl.inserir(91);
//        arvoreAvl.inserir(58);
//        arvoreAvl.inserir(35);
//        arvoreAvl.inserir(14);
//        arvoreAvl.inserir(26);
//        arvoreAvl.inserir(79);
//        arvoreAvl.inserir(84);
//        arvoreAvl.inserir(77);
//        arvoreAvl.inserir(61);
//        arvoreAvl.inserir(85);
//        arvoreAvl.inserir(28);
//        arvoreAvl.inserir(98);
//        arvoreAvl.inserir(62);
//        arvoreAvl.inserir(60);
//
//        arvoreAvl.imprimir();
//
//        arvoreAvl.remover(14);
//        arvoreAvl.remover(28);
//
//        arvoreAvl.imprimir();



//        =========== TESTES PARA COMPARAÇÃO DE DESMPENHO ENTRE AS DUAS ARVORES ===========

        // preenchendo os vetores com os valores que serao utilizados nos testes

        Random random = new Random();

        int[] vetorDe100 = new int[100];
        int[] vetorDe500 = new int[500];
        int[] vetorDe1000 = new int[1000];
        int[] vetorDe10000 = new int[10000];
        int[] vetorDe20000 = new int[20000];

        for(int i = 0; i < 100; i++){
            int dado = random.nextInt(1000000) + 1;
            vetorDe100[i] = dado;
        }
        for(int i = 0; i < 500; i++){
            int dado = random.nextInt(1000000) + 1;
            vetorDe500[i] = dado;
        }
        for(int i = 0; i < 1000; i++){
            int dado = random.nextInt(1000000) + 1;
            vetorDe1000[i] = dado;
        }
        for(int i = 0; i < 10000; i++){
            int dado = random.nextInt(1000000) + 1;
            vetorDe10000[i] = dado;
        }
        for(int i = 0; i < 20000; i++){
            int dado = random.nextInt(1000000) + 1;
            vetorDe20000[i] = dado;
        }

        // definindo atributos que irão armazenar os dados de tempo

        long binariaInicio;
        long binariaFim;

        long bin100;
        long bin500;
        long bin1000;
        long bin10000;
        long bin20000;

        long avlInicio;
        long avlFim;

        long avl100;
        long avl500;
        long avl1000;
        long avl10000;
        long avl20000;

        // realizando as inserções

        binariaInicio = System.nanoTime();
        for (int dado: vetorDe100) {
            arvoreBinaria.inserir(dado);
        }
        binariaFim = System.nanoTime();

        bin100 = binariaFim - binariaInicio;

        avlInicio = System.nanoTime();
        for (int dado: vetorDe100) {
            arvoreAvl.inserir(dado);
        }
        avlFim = System.nanoTime();

        avl100 = avlFim - avlInicio;

        binariaInicio = System.nanoTime();
        for (int dado: vetorDe500) {
            arvoreBinaria.inserir(dado);
        }
        binariaFim = System.nanoTime();

        bin500 = binariaFim - binariaInicio;

        avlInicio = System.nanoTime();
        for (int dado: vetorDe500) {
            arvoreAvl.inserir(dado);
        }
        avlFim = System.nanoTime();

        avl500 = avlFim - avlInicio;

        binariaInicio = System.nanoTime();
        for (int dado: vetorDe1000) {
            arvoreBinaria.inserir(dado);
        }
        binariaFim = System.nanoTime();

        bin1000 = binariaFim - binariaInicio;

        avlInicio = System.nanoTime();
        for (int dado: vetorDe1000) {
            arvoreAvl.inserir(dado);
        }
        avlFim = System.nanoTime();

        avl1000 = avlFim - avlInicio;

        binariaInicio = System.nanoTime();
        for (int dado: vetorDe10000) {
            arvoreBinaria.inserir(dado);
        }
        binariaFim = System.nanoTime();

        bin10000 = binariaFim - binariaInicio;

        avlInicio = System.nanoTime();
        for (int dado: vetorDe10000) {
            arvoreAvl.inserir(dado);
        }
        avlFim = System.nanoTime();

        avl10000 = avlFim - avlInicio;

        binariaInicio = System.nanoTime();
        for (int dado: vetorDe20000) {
            arvoreBinaria.inserir(dado);
        }
        binariaFim = System.nanoTime();

        bin20000 = binariaFim - binariaInicio;

        avlInicio = System.nanoTime();
        for (int dado: vetorDe20000) {
            arvoreAvl.inserir(dado);
        }
        avlFim = System.nanoTime();

        avl20000 = avlFim - avlInicio;

        // printando resultados no terminal

        System.out.println("Tempo em nanossegundos para inserção de 100 elementos");
        System.out.println("Binária: " + bin100 + "ns");
        System.out.println("AVL:     " + avl100 + "ns");

        System.out.println("Tempo em nanossegundos para inserção de 500 elementos");
        System.out.println("Binária: " + bin500 + "ns");
        System.out.println("AVL:     " + avl500 + "ns");

        System.out.println("Tempo em nanossegundos para inserção de 1000 elementos");
        System.out.println("Binária: " + bin1000 + "ns");
        System.out.println("AVL:     " + avl1000 + "ns");

        System.out.println("Tempo em nanossegundos para inserção de 10000 elementos");
        System.out.println("Binária: " + bin10000 + "ns");
        System.out.println("AVL:     " + avl10000 + "ns");

        System.out.println("Tempo em nanossegundos para inserção de 20000 elementos");
        System.out.println("Binária: " + bin20000 + "ns");
        System.out.println("AVL:     " + avl20000 + "ns");

        System.out.println("\n");
        System.out.println("===================================================================================================================================================");
        System.out.println("\n");

        // selecionando um dado de cada vetor para testar a busca e a remoção

        int dado100 = vetorDe100[87];
        int dado500 = vetorDe500[398];
        int dado1000 = vetorDe1000[826];
        int dado10000 = vetorDe10000[7692];
        int dado20000 = vetorDe20000[15834];

        // número de repetições para o teste de busca

        int numRepeticoes = 100;

        // realizando as buscas

        binariaInicio = System.nanoTime();
        for (int i = 0; i < numRepeticoes; i++) {
            arvoreBinaria.buscar(dado100);
        }
        binariaFim = System.nanoTime();
        bin100 = (binariaFim - binariaInicio) / numRepeticoes;

        avlInicio = System.nanoTime();
        for (int i = 0; i < numRepeticoes; i++) {
            arvoreAvl.buscar(dado100);
        }
        avlFim = System.nanoTime();
        avl100 = (avlFim - avlInicio) / numRepeticoes;

        binariaInicio = System.nanoTime();
        for (int i = 0; i < numRepeticoes; i++) {
            arvoreBinaria.buscar(dado500);
        }
        binariaFim = System.nanoTime();
        bin500 = (binariaFim - binariaInicio) / numRepeticoes;

        avlInicio = System.nanoTime();
        for (int i = 0; i < numRepeticoes; i++) {
            arvoreAvl.buscar(dado500);
        }
        avlFim = System.nanoTime();
        avl500 = (avlFim - avlInicio) / numRepeticoes;

        binariaInicio = System.nanoTime();
        for (int i = 0; i < numRepeticoes; i++) {
            arvoreBinaria.buscar(dado1000);
        }
        binariaFim = System.nanoTime();
        bin1000 = (binariaFim - binariaInicio) / numRepeticoes;

        avlInicio = System.nanoTime();
        for (int i = 0; i < numRepeticoes; i++) {
            arvoreAvl.buscar(dado1000);
        }
        avlFim = System.nanoTime();
        avl1000 = (avlFim - avlInicio) / numRepeticoes;

        binariaInicio = System.nanoTime();
        for (int i = 0; i < numRepeticoes; i++) {
            arvoreBinaria.buscar(dado10000);
        }
        binariaFim = System.nanoTime();
        bin10000 = (binariaFim - binariaInicio) / numRepeticoes;

        avlInicio = System.nanoTime();
        for (int i = 0; i < numRepeticoes; i++) {
            arvoreAvl.buscar(dado10000);
        }
        avlFim = System.nanoTime();
        avl10000 = (avlFim - avlInicio) / numRepeticoes;

        binariaInicio = System.nanoTime();
        for (int i = 0; i < numRepeticoes; i++) {
            arvoreBinaria.buscar(dado20000);
        }
        binariaFim = System.nanoTime();
        bin20000 = (binariaFim - binariaInicio) / numRepeticoes;

        avlInicio = System.nanoTime();
        for (int i = 0; i < numRepeticoes; i++) {
            arvoreAvl.buscar(dado20000);
        }
        avlFim = System.nanoTime();
        avl20000 = (avlFim - avlInicio) / numRepeticoes;

        // printando os resultados no terminal

        System.out.println("Media de tempo em nanossegundos para buscar o elemento com " + numRepeticoes + " repeticoes " + dado100);
        System.out.println("Binaria: " + bin100 + "ns");
        System.out.println("AVL:     " + avl100 + "ns");

        System.out.println("Media de tempo em nanossegundos para buscar o elemento com " + numRepeticoes + " repeticoes " + dado500);
        System.out.println("Binaria: " + bin500 + "ns");
        System.out.println("AVL:     " + avl500 + "ns");

        System.out.println("Media de tempo em nanossegundos para buscar o elemento com " + numRepeticoes + " repeticoes " + dado1000);
        System.out.println("Binaria: " + bin1000 + "ns");
        System.out.println("AVL:     " + avl1000 + "ns");

        System.out.println("Media de tempo em nanossegundos para buscar o elemento com " + numRepeticoes + " repeticoes " + dado10000);
        System.out.println("Binaria: " + bin10000 + "ns");
        System.out.println("AVL:     " + avl10000 + "ns");

        System.out.println("Media de tempo em nanossegundos para buscar o elemento com " + numRepeticoes + " repeticoes " + dado20000);
        System.out.println("Binaria: " + bin20000 + "ns");
        System.out.println("AVL:     " + avl20000 + "ns");

        System.out.println("\n");
        System.out.println("===================================================================================================================================================");
        System.out.println("\n");

        // realizando testes de remoção

        binariaInicio = System.nanoTime();
        arvoreBinaria.remover(dado100);
        binariaFim = System.nanoTime();
        bin100 = binariaFim - binariaInicio;

        avlInicio = System.nanoTime();
        arvoreAvl.remover(dado100);
        avlFim = System.nanoTime();
        avl100 = avlFim - avlInicio;

        binariaInicio = System.nanoTime();
        arvoreBinaria.remover(dado500);
        binariaFim = System.nanoTime();
        bin500 = binariaFim - binariaInicio;

        avlInicio = System.nanoTime();
        arvoreAvl.remover(dado500);
        avlFim = System.nanoTime();
        avl500 = avlFim - avlInicio;

        binariaInicio = System.nanoTime();
        arvoreBinaria.remover(dado1000);
        binariaFim = System.nanoTime();
        bin1000 = binariaFim - binariaInicio;

        avlInicio = System.nanoTime();
        arvoreAvl.remover(dado1000);
        avlFim = System.nanoTime();
        avl1000 = avlFim - avlInicio;

        binariaInicio = System.nanoTime();
        arvoreBinaria.remover(dado10000);
        binariaFim = System.nanoTime();
        bin10000 = binariaFim - binariaInicio;

        avlInicio = System.nanoTime();
        arvoreAvl.remover(dado10000);
        avlFim = System.nanoTime();
        avl10000 = avlFim - avlInicio;

        binariaInicio = System.nanoTime();
        arvoreBinaria.remover(dado20000);
        binariaFim = System.nanoTime();
        bin20000 = binariaFim - binariaInicio;

        avlInicio = System.nanoTime();
        arvoreAvl.remover(dado20000);
        avlFim = System.nanoTime();
        avl20000 = avlFim - avlInicio;

        // printando resultados no terminal

        System.out.println("Tempo em nanossegundos para remoção do dado " + dado100);
        System.out.println("Binária: " + bin100 + "ns");
        System.out.println("AVL:     " + avl100 + "ns");

        System.out.println("Tempo em nanossegundos para remoção do dado " + dado500);
        System.out.println("Binária: " + bin500 + "ns");
        System.out.println("AVL:     " + avl500 + "ns");

        System.out.println("Tempo em nanossegundos para remoção do dado " + dado1000);
        System.out.println("Binária: " + bin1000 + "ns");
        System.out.println("AVL:     " + avl1000 + "ns");

        System.out.println("Tempo em nanossegundos para remoção do dado " + dado10000);
        System.out.println("Binária: " + bin10000 + "ns");
        System.out.println("AVL:     " + avl10000 + "ns");

        System.out.println("Tempo em nanossegundos para remoção do dado " + dado20000);
        System.out.println("Binária: " + bin20000 + "ns");
        System.out.println("AVL:     " + avl20000 + "ns");

        System.out.println("\n");
        System.out.println("===================================================================================================================================================");
        System.out.println("\n");
    }
}