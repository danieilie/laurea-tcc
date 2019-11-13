package model;

import java.util.Date;

public class Mensalidade {

    private int idmensalidade, status;
    private Date datav, datap;
    private double valor, multa, desconto;

    public Mensalidade() {
    }

    public Mensalidade(int idmensalidade, int status, double valor, double multa, double desconto, Date datav, Date datap) {
        this.idmensalidade = idmensalidade;
        this.status = status;
        this.valor = valor;
        this.multa = multa;
        this.desconto = desconto;
        this.datav = datav;
        this.datap = datap;
    }

    public int getIdmensalidade() {
        return idmensalidade;
    }

    public void setIdmensalidade(int idmensalidade) {
        this.idmensalidade = idmensalidade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Date getDatav() {
        return datav;
    }

    public void setDatav(Date datav) {
        this.datav = datav;
    }

    public Date getDatap() {
        return datap;
    }

    public void setDatap(Date datap) {
        this.datap = datap;
    }

}
