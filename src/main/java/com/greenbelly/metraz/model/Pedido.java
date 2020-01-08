package com.greenbelly.metraz.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PEDIDOS")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    @Column(name = "status_pedido")
    private StatusPedido statusPedido;

    @Column(name = "data_abertura")
    private Date dataAbertura;

    @Column(name = "data_fechamento")
    private Date dataFechamento;

    private StatusCobranca statusCobranca;

    private TipoPagamento tipoPagamento;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Loja loja;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco enderecoEntrega;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario Entregador;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "loja")
    private List<Produto> produtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public StatusCobranca getStatusCobranca() {
        return statusCobranca;
    }

    public void setStatusCobranca(StatusCobranca statusCobranca) {
        this.statusCobranca = statusCobranca;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Usuario getEntregador() {
        return Entregador;
    }

    public void setEntregador(Usuario entregador) {
        Entregador = entregador;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
