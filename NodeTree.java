public class NodeTree {
    // definindo atributos
    private Integer informacao;
    private NodeTree esquerdo;
    private NodeTree direito;
    // metodo construtor
    public NodeTree() {
        this.informacao = null;
        this.esquerdo = null;
        this.direito = null;
    }
    // metodos get
    public Integer getInformacao() {
        return informacao;
    }
    public NodeTree getEsquerdo() {
        return esquerdo;
    }
    public NodeTree getDireito() {
        return direito;
    }
    // metodos set
    public void setInformacao(Integer informacao) {
        this.informacao = informacao;
    }
    public void setEsquerdo(NodeTree esquerdo) {
        this.esquerdo = esquerdo;
    }
    public void setDireito(NodeTree direito) {
        this.direito = direito;
    }
}