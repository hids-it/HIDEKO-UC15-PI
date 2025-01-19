/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author hidek
 */
public class Produto {
    private int id;
    private String nomeprod;
    private String descricao;
    private Double vcusto;
    private Double vvenda;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeprod() {
        return nomeprod;
    }

    public void setNomeprod(String nomeprod) {
        this.nomeprod = nomeprod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getVcusto() {
        return vcusto;
    }

    public void setVcusto(Double vcusto) {
        this.vcusto = vcusto;
    }

    public Double getVvenda() {
        return vvenda;
    }

    public void setVvenda(Double vvenda) {
        this.vvenda = vvenda;
    }
    
    
    
    
}
