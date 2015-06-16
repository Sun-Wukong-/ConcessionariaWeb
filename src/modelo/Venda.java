package modelo;

import java.util.Date;

/**
 *
 * @author Wukong
 */
public class Venda {
    
    private long codigo;
    private Date data;
    private long registroVendedor;
    private long codigoProduto; 
    private double desconto;
    private double valorAcessorios;
    private double valorTotal;

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
