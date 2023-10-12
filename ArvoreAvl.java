import org.w3c.dom.Node;

public class ArvoreAvl {
    // definindo atributos
    private NodeTree raiz;
    // metodo construtor
    public ArvoreAvl(){
        this.raiz = null;
    }
    // metodo para inserir dados na arvore

    public void inserir(int dado){
        NodeTree no = new NodeTree(); // instancia o novo no
        no.setInformacao(dado); // seta o dado
        if(raiz == null){ // caso a raiz esteja vazia
            raiz = no;
        } else { // se nao
            NodeTree atual = raiz; // cria auxiliar
            while(true){
                // condicoes de insercao
                if(atual.getEsquerdo() == null){ // se o ultimo da esquerda for uma folha
                    if(dado < atual.getInformacao()){ // caso o dado seja menor que o da folha
                        atual.setEsquerdo(no); // insere a esquerda da folha
                        break; // para o loop
                    }
                }
                if(atual.getDireito() == null){ // se o ultimo da direita for folha
                    if(dado >= atual.getInformacao()){ // caso o dado seja maior ou igual o da folha
                        atual.setDireito(no); // insere a direita da folha
                        break; // para o loop
                    }
                }
                // condicoes de navegabilidade
                if(dado >= atual.getInformacao()){ // se o dado for maior que o do no
                    atual = atual.getDireito(); // caminha pra direita
                } else { // se for menor
                    atual = atual.getEsquerdo(); // caminha pra esquerda
                }
            }
        }
        verificarArvore(no); // verifica se a arvore precisa ser balanceada e atualiza a arvore
    }
    // metodo pa imprimir os dados da arvore
    public void imprimir(){
        System.out.println("Árvore AVL:");
        System.out.print("Pré-ordem: "); // tipo de organizacao
        preOrdem(raiz); // metodo que imprime
        System.out.println("\n"); // pula uma linha
        System.out.print("In-ordem: "); // tipo de organizacao
        inOrdem(raiz); // metodo que imprime
        System.out.println("\n"); // pula uma linha
        System.out.print("Pós-ordem: "); // tipo de organizacao
        posOrdem(raiz); // metodo que imprime
        System.out.println("\n"); // pula uma linha
    }
    // metodo para imprimir pre-ordem
    public void preOrdem(NodeTree arvore){
        if (arvore != null){ // se o no nao for nulo
            System.out.print(arvore.getInformacao() + " "); // printa a informacao
            preOrdem(arvore.getEsquerdo()); // chamada recursiva com o proximo da esquerda
            preOrdem(arvore.getDireito()); // chamada recursiva com o proximo da direita
        }
    }
    // metodo para imprimir in-ordem
    private void inOrdem(NodeTree arvore){
        if(arvore != null){ // se o no nao for nulo
            inOrdem(arvore.getEsquerdo()); // chamada recursiva com o proximo da esquerda
            System.out.print(arvore.getInformacao() + " "); // printa a informacao
            inOrdem(arvore.getDireito()); // chamada recursiva com o proximo da direita
        }
    }
    // metodo para imprimir pos-ordem
    private void posOrdem(NodeTree arvore){
        if(arvore != null){ // se o no nao for nulo
            posOrdem(arvore.getEsquerdo()); // chamada recursiva com o proximo da esquerda
            posOrdem(arvore.getDireito()); // chamada recursiva com o proximo da direita
            System.out.print(arvore.getInformacao() + " "); // printa a informacao
        }
    }
    // metodo para remover o maior elemento da arvore
    public void removerMaior(NodeTree arvore){
        NodeTree atual = arvore; // auxiliar
        if(atual.getDireito() == null){ // se nao tiver nenhum a direita
            removerRaiz(); // remove a raiz
        } else { // se nao
            while (atual.getDireito().getDireito() != null){ // enquanto o atual nao for anterior ao ultimo a direita
                atual = atual.getDireito(); // percorre
            }
            if(isFolha(atual.getDireito())){ // se o proximo for folha
                atual.setDireito(null); // seta o proximo como null removendo o maior
            } else{ // se nao for folha
                NodeTree removido = atual.getDireito(); // armazena o removido em uma variavel
                atual.setDireito(removido.getEsquerdo()); // reposiciona o no esquerdo do removido
            }
        }
    }
    // metodo para remover o menor elemento da arvore
    public void removerMenor(NodeTree arvore){
        NodeTree atual = arvore; // auxiliar
        if(atual.getEsquerdo() == null){ // se nao tiver nenhuma a esquerda
            removerRaiz(); // remove a raiz
        } else { // se nao
            while (atual.getEsquerdo().getEsquerdo() != null){ // enquanto o atual nao for anterior ao ultimo da esquerda
                atual = atual.getEsquerdo(); // percorre
            }
            if(isFolha(atual.getEsquerdo())){ // se o proximo for folha
                atual.setEsquerdo(null); // seta o proximo como null removendo o menor
            } else{ // se nao for folha
                NodeTree removido = atual.getEsquerdo(); // armazena o removido em uma variavel
                atual.setEsquerdo(removido.getDireito()); // reposiciona o no direito do removido
            }
        }
    }
    // metodo para remover a raiz da arvore
    private void removerRaiz(){
        if(isFolha(raiz)){ // se a raiz for folha
            raiz = null; // iguala a null
        } else { // se nao
            if(temDireito(raiz) && temEsquerdo(raiz)){ // se o no tem direito e tem esquerdo
                NodeTree novaRaiz = raiz.getDireito(); // nova raiz sera o no da direita
                if(novaRaiz.getEsquerdo() == null){ // se a nova raiz nao tiver nenhum no a esquerda
                    novaRaiz.setEsquerdo(raiz.getEsquerdo()); // posiciona a nova raiz da arvore setando no esquerdo o lado esquerdo da arvore                    raiz = novaRaiz;
                } else { // se a nova raiz tiver um no a esquerda
                    NodeTree esq = novaRaiz.getEsquerdo(); // armazena
                    while(esq.getEsquerdo() != null){ // enquanto nao estiver no ultimo no a esquerda da nova raiz
                        esq = esq.getEsquerdo(); // percorre
                    }
                    esq.setEsquerdo(raiz.getEsquerdo()); // seta a esquerda desse no toda a subarvore esquerda da antiga raiz
                    raiz = novaRaiz; // atualizo minha arvore
                }
            } else if(temEsquerdo(raiz) && !temDireito(raiz)){ // se a raiz tiver esquerdo e nao tiver direito
                raiz = raiz.getEsquerdo(); // percorre um no
            } else { // se tiver direito e nao tiver esquerdo
                raiz = raiz.getDireito(); // percorre um no
            }
            verificarArvore(raiz);
        }
    }
    // metodo para calcular altura da arvore
    private int altura(NodeTree no){
        if(no == null){ // se o no for null
            return -1; // retorna -1
        }
        int esquerda = altura(no.getEsquerdo()); // percorre a esquerda
        int direita = altura(no.getDireito()); // percorre a direita
        if(esquerda > direita){
            return 1 + esquerda;
        } else {
            return 1 + direita;
        }
    }
    // metodo que realiza rotacao esquerda
    private NodeTree rotacaoEsquerda(NodeTree no){
        NodeTree novaRaiz = no.getDireito(); // seta a nova raiz como sendo o no da direita
        no.setDireito(novaRaiz.getEsquerdo()); // seta a direita da antiga raiz o esquerdo da nova raiz
        novaRaiz.setEsquerdo(no); // atualiza o esquerdo da nova raiz como sendo a raiz antiga
        return novaRaiz; // retorna a raiz rotacionada
    }
    // metodo que realiza rotacao a direita
    private NodeTree rotacaoDireita(NodeTree no){
        NodeTree novaRaiz = no.getEsquerdo(); // seta a nova raiz como sendo o no da esquerda
        no.setEsquerdo(novaRaiz.getDireito()); // seta a esquerda da raiz antiga o no direito da nova raiz
        novaRaiz.setDireito(no); // atualiza a direita da nova raiz como sendo o no antigo
        return novaRaiz; // retorna a raiz rotacionada
    }
    // metodo que realiza dupla rotacao a esquerda
    private NodeTree duplaRotacaoEsquerda(NodeTree no){
        NodeTree novaRaiz = no.getDireito().getEsquerdo(); // pega a nova raiz da arvore que vai ser o neto da raiz que entrou
        NodeTree pai = no.getDireito(); // armazena o pai
        NodeTree vo = no; // armazena o vo
        pai.setEsquerdo(novaRaiz.getDireito());
        vo.setDireito(novaRaiz.getEsquerdo());
        novaRaiz.setEsquerdo(vo);  // seta o vo a esquerda da nova raiz
        novaRaiz.setDireito(pai); // seta o pai a direita da nova raiz
        return novaRaiz; // retorna a raiz balanceada
    }
    // metodo que realiza dupla rotacao a direita
    private NodeTree duplaRotacaoDireita(NodeTree no){
        NodeTree novaRaiz = no.getEsquerdo().getDireito(); // pega a nova raiz da arvore que vai ser o neto da raiz que entrou
        NodeTree pai = no.getEsquerdo(); // armazena o pai
        NodeTree vo = no; // armazena o vo
        pai.setDireito(novaRaiz.getEsquerdo());
        vo.setEsquerdo(novaRaiz.getDireito());
        novaRaiz.setDireito(vo);  // seta o vo a direita da nova raiz
        novaRaiz.setEsquerdo(pai); // seta o pai a esquerda da nova raiz
        return novaRaiz; // retorna a raiz balanceada
    }
    // metodo para balancear a arvore
    private NodeTree balancear(NodeTree no, int balanceamento){
        NodeTree balanceado = null; // inicializa o no que vai ser retornado
        if(balanceamento == -2){ // verifica se o no esta desbalanceado para direita
            NodeTree filho = no.getDireito(); // armazena o filho
            int verificaFilho = (altura(filho.getEsquerdo()) - altura(filho.getDireito())); // verifica o balanceamento do filho
            if(verificaFilho == 1){ // se o balanceamento do filho for 1
                balanceado = duplaRotacaoEsquerda(no); // faz uma dupla rotacao
            } else { // se nao
                balanceado = rotacaoEsquerda(no); // faz uma rotacao simples
            }
        } else if(balanceamento == 2){ // verifica se o no esta desbalanceado para a esquerda
            NodeTree filho = no.getEsquerdo(); // armazena o filho
            int verificaFilho = (altura(filho.getEsquerdo()) - altura(filho.getDireito())); // verifica o balanceamento do filho
            if(verificaFilho == -1){ // se o balanceamento do filho for -1
                balanceado = duplaRotacaoDireita(no); // faz uma dupla rotacao
            } else { // se nao
                balanceado = rotacaoDireita(no); // faz uma rotacao simples
            }
        }
        return balanceado; // retorna o no balanceado
    }
    // metodo para verificar se a arvore precisa ser balanceada
    private void verificarArvore(NodeTree no){
        if(no == null){ // se o no for null
            return; // para o metodo
        }
        int balanceamento = (altura(no.getEsquerdo()) - altura(no.getDireito())); // calcula o balanceamento do no baseado na diferenca de altura de suas duas subarvores
        NodeTree pai = encontrarPai(no);
        if(pai != null){
            if((balanceamento == 2) || (balanceamento == -2)){ //se o balanceamento for igaul a 2 ou -2
                NodeTree balanceado = balancear(no, balanceamento); // balanceia o no
                if(balanceado.getInformacao() >= pai.getInformacao()){
                    pai.setDireito(balanceado);
                } else {
                    pai.setEsquerdo(balanceado);
                }
            }
            verificarArvore(pai);
        } else {
            if((balanceamento == 2) || (balanceamento == -2)){
                raiz = balancear(raiz, balanceamento);
            }
        }
    }
    // metodo para buscar um elemento na arvore
    public int buscar(int dado){
        int resultado;
        NodeTree percorre = raiz;
        while(true){
            if(percorre.getInformacao() == dado){
                resultado = dado;
                break;
            }
            if(dado >= percorre.getInformacao()){
                percorre = percorre.getDireito();
            } else if (dado < percorre.getInformacao()){
                percorre = percorre.getEsquerdo();
            }
        }
        return resultado;
    }
    public void balancearRaiz(int balanceamento){
        if(balanceamento == -2){ // verifica se o no esta desbalanceado para direita
            NodeTree filho = raiz.getDireito(); // armazena o filho
            int verificaFilho = (altura(filho.getEsquerdo()) - altura(filho.getDireito())); // verifica o balanceamento do filho
            if(verificaFilho == 1){ // se o balanceamento do filho for 1
                raiz = duplaRotacaoEsquerda(raiz); // faz uma dupla rotacao
            } else { // se nao
                raiz = rotacaoEsquerda(raiz); // faz uma rotacao simples
            }
        } else if(balanceamento == 2){ // verifica se o no esta desbalanceado para a esquerda
            NodeTree filho = raiz.getEsquerdo(); // armazena o filho
            int verificaFilho = (altura(filho.getEsquerdo()) - altura(filho.getDireito())); // verifica o balanceamento do filho
            if(verificaFilho == -1){ // se o balanceamento do filho for -1
                raiz = duplaRotacaoDireita(raiz); // faz uma dupla rotacao
            } else { // se nao
                raiz = rotacaoDireita(raiz); // faz uma rotacao simples
            }
        }
    }
    // metodo para encontra o pai de um determinado no
    public NodeTree encontrarPai(NodeTree no) {
        if (no == null || no == raiz) {
            return null; // O nó alvo não tem pai ou é a raiz.
        }
        NodeTree percorre = raiz;
        NodeTree pai = null;
        while (percorre != null) {
            if ((percorre.getEsquerdo() == no) || (percorre.getDireito() == no)) {
                pai = percorre;
                break; // Encontramos o pai do nó alvo.
            } else if (no.getInformacao() >= percorre.getInformacao()) {
                percorre = percorre.getDireito();
            } else {
                percorre = percorre.getEsquerdo();
            }
        }
        return pai;
    }

    // metodo para remover um elemento qualquer da arvore
    public void remover(int dado){
        NodeTree remover = raiz;
        NodeTree pai = raiz;
        NodeTree newFilho;
        if(dado == raiz.getInformacao()){
            removerRaiz();
        } else {
            while(dado != remover.getInformacao()){
                if(dado >= remover.getInformacao()){
                    pai = remover;
                    remover = remover.getDireito();
                } else {
                    pai = remover;
                    remover = remover.getEsquerdo();
                }
            }
        }
        if(isFolha(remover)){
            if(remover.getInformacao() >= pai.getInformacao()){ // se o pai for maior que o removido
                pai.setDireito(null); // apago o da esquerda
            } else { // se nao
                pai.setEsquerdo(null); // apaga o da direita
            }
        } else {
            if(temDireito(remover) && !temEsquerdo(remover)){
                newFilho = remover.getDireito();
                if(newFilho.getInformacao() >= pai.getInformacao()){
                    pai.setDireito(newFilho);
                } else {
                    pai.setEsquerdo(newFilho);
                }
                verificarArvore(pai);
            } else if (!temDireito(remover) && temEsquerdo(remover)){
                newFilho = remover.getEsquerdo();
                if(newFilho.getInformacao() >= pai.getInformacao()){
                    pai.setDireito(newFilho);
                } else {
                    pai.setEsquerdo(newFilho);
                }
                verificarArvore(pai);
            } else {
                newFilho = remover.getDireito();
                if(isFolha(newFilho) || (!temEsquerdo(newFilho) && temDireito(newFilho))){
                    if(newFilho.getInformacao() >= pai.getInformacao()){
                        pai.setDireito(newFilho);
                    } else {
                        pai.setEsquerdo(newFilho);
                    }
                    newFilho.setEsquerdo(remover.getEsquerdo());
                    verificarArvore(newFilho);
                } else {
                    NodeTree menorPossivel = newFilho;
                    NodeTree paiMenorPossivel = newFilho;
                    while(menorPossivel.getEsquerdo() != null){
                        paiMenorPossivel = menorPossivel;
                        menorPossivel = menorPossivel.getEsquerdo();
                    }
                    paiMenorPossivel.setEsquerdo(menorPossivel.getDireito());
                    verificarArvore(paiMenorPossivel);
                    newFilho = menorPossivel;
                    if(newFilho.getInformacao() >= pai.getInformacao()){
                        pai.setDireito(newFilho);
                    } else {
                        pai.setEsquerdo(newFilho);
                    }
                    newFilho.setDireito(remover.getDireito());
                    newFilho.setEsquerdo(remover.getEsquerdo());
                    verificarArvore(newFilho);
                }
            }
        }
    }
    // metodo para verificar se o no tem direito
    private boolean temDireito(NodeTree arvore){
        if(arvore.getDireito() == null){ // se o no a direita for null
            return false; // nao tem direito
        } else { // se noa
            return true; // tem direito
        }
    }
    // metodo para verificar se o no tem esquerdo
    private boolean temEsquerdo(NodeTree arvore){
        if(arvore.getEsquerdo() == null){ // se o no a esquerda for null
            return false; // nao tem esquerdo
        } else { // se nao
            return true; // tem esquerdo
        }
    }
    // metodo para verificar se o no e folha
    private boolean isFolha(NodeTree no){
        if(no.getEsquerdo() == null && no.getDireito() == null){ // se o esquerdo e o direito for null
            return true; // e folha
        } else { // se nao
            return false; // nao e folha
        }
    }
    // metodo get da arvore
    public NodeTree getRaiz() {
        return raiz; // retorna a arvore
    }

}