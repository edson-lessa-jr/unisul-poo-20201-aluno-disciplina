package br.unisul.aula;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Turma {
    private Disciplina disciplina;
    // SET, lista no qual aceita somente um único objeto fazendo uso do equals para verificar se existe já na lista
    private Set<Aluno> alunoSet;
    private static Set<Turma> listaTurmas = new HashSet<Turma>();

    public Turma (Disciplina disciplina){
        this.disciplina = disciplina;
        this.alunoSet = new HashSet<Aluno>();
    }

    public static void matricular(Disciplina disciplina, Aluno aluno){
        Turma turma = new Turma(disciplina);
        if (Turma.listaTurmas.contains(turma)){
            for(Turma turmaEncontrada: Turma.listaTurmas){
                if(turmaEncontrada.equals(turma)){
                    turmaEncontrada.alunoSet.add(aluno);
                }
            }
        } else {
            turma.alunoSet.add(aluno);
            Turma.listaTurmas.add(turma);
        }
    }
    public static List<Aluno> alunosMaisTresDisciplinas(){
        Set<Aluno> alunoMat = new HashSet<Aluno>();

        for (Turma turma: Turma.listaTurmas){
            for (Aluno aluno: turma.getAlunoSet()) {
                int qtdMatriculas =0;
                for (Turma turmaBusca: Turma.listaTurmas){
                    if (turmaBusca.getAlunoSet().contains(aluno)){
                        qtdMatriculas++;
                    }
                }
                if (qtdMatriculas>=3){
                    alunoMat.add(aluno);
                }
            }
        }

        if (alunoMat.size()>0){
            return new ArrayList<>(alunoMat);
        }

        return null;
    }
    // REPLICA A LISTA QUE SERÁ TRADA, traz informações em duplicidade que não auxiliam o usuário
    /*
    public static List<Aluno> alunosMaisTresDisciplinas(){
        List<Aluno> alunoMat = new ArrayList<Aluno>();

        for (Turma turma: Turma.listaTurmas){
            for (Aluno aluno: turma.getAlunoSet()) {
                int qtdMatriculas =0;
                for (Turma turmaBusca: Turma.listaTurmas){
                    if (turmaBusca.getAlunoSet().contains(aluno)){
                        qtdMatriculas++;
                    }
                }
                if ((qtdMatriculas>=3){
                    alunoMat.add(aluno);
                }
            }
        }

        if (alunoMat.size()>0){
            return alunoMat;
        }

        return null;
    }

     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Set<Aluno> getAlunoSet() {
        return alunoSet;
    }

    public static Set<Turma> getTurma(){
        if (Turma.listaTurmas.size()>0)
            return Turma.listaTurmas;
        else return null;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turma)) return false;

        Turma turma = (Turma) o;

        return disciplina != null ? disciplina.equals(turma.disciplina) : turma.disciplina == null;
    }

    @Override
    public int hashCode() {
        return disciplina != null ? disciplina.hashCode() : 0;
    }
}
