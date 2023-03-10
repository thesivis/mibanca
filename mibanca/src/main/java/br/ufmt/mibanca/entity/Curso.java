package br.ufmt.mibanca.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.ufmt.mibanca.formacao.Formacao;
import br.ufmt.mibanca.instituto.Instituto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "curso")
@SequenceGenerator(name = "seqCurso", sequenceName = "seq_curso_id")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "seqCurso",strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "descricao",length = 1000,  nullable = false)
    private String descricao;

    @Column(name = "carga_horaria", nullable = false)
    private int cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "instituto_id")
    private Instituto instituto;

    @OneToMany(mappedBy = "curso")
    private List<Formacao> formacoes;
    


}