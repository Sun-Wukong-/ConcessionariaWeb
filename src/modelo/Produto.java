package modelo;

public class Produto {
   
   private long codigo; 
   private String cor;
   private String marca;
   private String modelo;
   private int ano;
   private double preco;

   /**
    * @return the cor
    */
   public String getCor() {
       return cor;
   }

   /**
    * @param cor the cor to set
    */
   public void setCor(String cor) {
       this.cor = cor;
   }

   /**
    * @return the marca
    */
   public String getMarca() {
       return marca;
   }

   /**
    * @param marca the marca to set
    */
   public void setMarca(String marca) {
       this.marca = marca;
   }

   /**
    * @return the modelo
    */
   public String getModelo() {
       return modelo;
   }

   /**
    * @param modelo the modelo to set
    */
   public void setModelo(String modelo) {
       this.modelo = modelo;
   }  

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
   
   // Inicio Método Cadastrar
   public void Cadastrar(){
       
   }

   /**
    * @return the preco
    */
   public double getPreco() {
       return preco;
   }

   /**
    * @param preco the preco to set
    */
   public void setPreco(double preco) {
       this.preco = preco;
   }

   /**
    * @return the ano
    */
   public int getAno() {
       return ano;
   }

   /**
    * @param ano the ano to set
    */
   public void setAno(int ano) {
       this.ano = ano;
   }

}
