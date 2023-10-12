public class ArvoreBinaria {
    // definindo atributos
    private NodeTree raiz;
    // metodo construtor
    public ArvoreBinaria(){
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
    }
    // metodo pa imprimir os dados da arvore
    public void imprimir(){
        System.out.println("Árvore Binária: ");
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
    private void preOrdem(NodeTree arvore){
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
        }
    }
    // metodo para remover um elemento qualquer da arvore
    public void remover(int dado){
        NodeTree remover = raiz; // inicializa o no que sera removido
        NodeTree pai = raiz; // inicializa o pai do removido
        NodeTree newFilho; // inicializa o novo filho
        if(dado == raiz.getInformacao()){ // se o dado coincidir com a raiz
            removerRaiz(); // remove a raiz
        } else{ // se nao
            while(dado != remover.getInformacao()){ // enquanto eu nao encontrar o dado na arvore
                if(dado > remover.getInformacao()){ // se o dado for maior que o que esta no remover
                    pai = remover; // atualiza o pai
                    remover = remover.getDireito(); // caminha pra direita
                } else { // se nao
                    pai = remover; // atualiza o pai
                    remover = remover.getEsquerdo(); // caminha pra esquerda
                }
            }
            if(isFolha(remover)){ // se o remover for folha
                if(pai.getInformacao() > remover.getInformacao()){ // se o pai for maior que o removido
                    pai.setEsquerdo(null); // apago o da esquerda
                } else { // se nao
                    pai.setDireito(null); // apaga o da direita
                }
            } else { // se nao for folha
                if (temEsquerdo(remover) && !temDireito(remover)){ // se o no tiver esquerdo e nao tiver direito
                    newFilho = remover.getEsquerdo(); // seta o novo filho
                    if(newFilho.getInformacao() >= pai.getInformacao()){ // se o novo filho for maior ou igual ao pai
                        pai.setDireito(newFilho); // seta o novo filho a direita do pai
                    } else { // se nao
                        pai.setEsquerdo(newFilho); // seta o novo filho a esquerda do pai
                    }
                } else if (temDireito(remover) && !temEsquerdo(remover)){ // se tem direito e nao tem esquerdo
                    newFilho = remover.getDireito(); // seta o novo filho
                    if(newFilho.getInformacao() >= pai.getInformacao()){ // se o novo filho for maior ou igual ao pai
                        pai.setDireito(newFilho); // seta o novo filho a direita do pai
                    } else { // se nao
                        pai.setEsquerdo(newFilho); // seta o novo filho a esquerda do pai
                    }
                } else { // se o removido tiver direito e esquerdo
                    newFilho = remover.getDireito(); // seta o novo filho
                    if(isFolha(newFilho)){ // se o novo filho for folha
                        if(newFilho.getInformacao() >= pai.getInformacao()){ // se o novo filho for maior ou igual ao pai
                            pai.setDireito(newFilho); // seta o novo filho a direita do pai
                        } else { // se nao
                            pai.setEsquerdo(newFilho); // seta o novo filho a esquerda do pai
                        }
                        if(remover.getEsquerdo() != null){ // se o removido tiver um esquerdo
                            newFilho.setEsquerdo(remover.getEsquerdo()); //seta o esquerdo do removido a esquerda do novo filho
                        }
                    }  else { // se o novo filho nao for folha
                        NodeTree menorPossivel = newFilho; // variavel para armazenar o menor possivel
                        NodeTree aux = newFilho; // auxiliar
                        while (true){
                            if(menorPossivel.getEsquerdo() != null){ // enquanto nao for o menor possivel
                                aux = menorPossivel; // armazena na auxiliar
                                menorPossivel = menorPossivel.getEsquerdo(); // percorre
                            }
                            if(menorPossivel.getEsquerdo() == null || isFolha(menorPossivel)){ // se o menor passivel for o ultimo a esquerda ou for uma folha
                                break; // para o loop
                            }
                        }
                        if(menorPossivel.getDireito() != null){ // se tiver algum no a direita do menor possivel
                            aux.setEsquerdo(menorPossivel.getDireito()); // seta o no a esquerda do auxiliar
                        }
                        newFilho = menorPossivel; // novo filho vira o menor passivel
                        if(newFilho.getInformacao() >= pai.getInformacao()){ // se o novo filho for maior ou igual ao pai
                            pai.setDireito(newFilho); // insere a direita do pai
                        } else { // se nao
                            pai.setEsquerdo(newFilho); // seta a esquerda do pai
                        }
                        // atualiza a esquerda e a direita do novo filho
                        newFilho.setEsquerdo(remover.getEsquerdo());
                        newFilho.setDireito(remover.getDireito());
                    }
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
    // metodo para buscar um elemenrto na arvore
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
    // metodo get da arvore
    public NodeTree getRaiz() {
        return raiz; // retorna a arvore
    }

}
