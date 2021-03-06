package modelo;

/**
 *
 * @author Wukong
 */
public class Venda {
    
    private long codigo;
    private String data;
    private long registroVendedor;
    private long codigoProduto; 
    private double desconto;
    private double valorAcessorios;
    private double valorTotal;
    private int qtd;
    private double valorTotalVendas;

    /**
     * @return the codigo
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the registroVendedor
     */
    public long getRegistroVendedor() {
        return registroVendedor;
    }

    /**
     * @param registroVendedor the registroVendedor to set
     */
    public void setRegistroVendedor(long registroVendedor) {
        this.registroVendedor = registroVendedor;
    }

    /**
     * @return the desconto
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

	public long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public double getValorAcessorios() {
		return valorAcessorios;
	}

	public void setValorAcessorios(double valorAcessorios) {
		this.valorAcessorios = valorAcessorios;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getValorTotalVendas() {
		return valorTotalVendas;
	}

	public void setValorTotalVendas(double valorTotalVendas) {
		this.valorTotalVendas = valorTotalVendas;
	}
}
