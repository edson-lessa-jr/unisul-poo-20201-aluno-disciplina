package br.unisul.aula;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    //List - Lista ordenada que permite duplicidade
    private List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
    private List<Aluno> listaAlunos = new ArrayList<Aluno>();

    private App(){
        listaDisciplinas.add(new Disciplina(1, "Prog Web", "Sala 1"));
        listaDisciplinas.add(new Disciplina(2, "Algoritmo", "Sala 2"));
        listaDisciplinas.add(new Disciplina(3, "POO", "Sala 3"));
        listaDisciplinas.add(new Disciplina(4, "Tópicos Avançado de Programação", "Sala 4"));
    }

    public static void main(String[] args) {
        App app = new App();
        int opc = 0;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha a opção do menu pelos números:\n" +
                    "1 - Cadastrar Aluno\n" +
                    "2 - Listar alunos\n" +
                    "3 - Listar alunos com mais de 3 disciplinas\n" +
                    "4 - Alunos matriculados na mesma disciplina\n" +
                    "0 - Sair"));
            switch (opc){
                case 1:
                    app.cadastrarAluno();
                    break;
                case 2:
                    app.listarAlunos();
                    break;
                case 3:
                    app.listarMatriculadosVariasDisciplinas();
                    break;
                case 4:
                    app.listarMatriculadosMesmaDisciplinas();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do programa!!!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida, saindo do programa");
                    break;
            }
        }while (opc>0);
    }
    private void cadastrarAluno(){
        String matricula = JOptionPane.showInputDialog("Informe a matricula do aluno");
        String nome = JOptionPane.showInputDialog("Informe o nome do aluno");
        Aluno aluno = new Aluno(matricula, nome);
        this.listaAlunos.add(aluno);
        String msg = "Informe o código da disciplina:";
        for (Disciplina disciplina: listaDisciplinas){
            msg+= "\n"+disciplina.getCodigo() + " - "+disciplina.getNome() + ", "+disciplina.getSala();
        }
        this.cadDisciplina(msg, aluno);
    }

    private void cadDisciplina(String msg,Aluno aluno){
        String sair ="n";
        sair =JOptionPane.showInputDialog("Deseja matricular uma disciplina?(S/N)");
        while (sair.equalsIgnoreCase("s")){
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(msg));
            Disciplina discEscolhida = new Disciplina(codigo);
            for (Disciplina disciplina: listaDisciplinas){
                if (disciplina.equals(discEscolhida)){
                    Turma.matricular(disciplina, aluno);
                    break;
                }
            }
            sair = JOptionPane.showInputDialog("Deseja continuar matriculando em outra turma?(S/N)");
        }
    }

    private void listarAlunos(){
        String msg = "Todos os alunos acadastrados:";
        for (Aluno aluno: this.listaAlunos){
            msg+= "\n"+aluno.getMatricula()+" - "+aluno.getNome();
        }
        JOptionPane.showMessageDialog(null,msg);
    }


    private void listarMatriculadosVariasDisciplinas(){
        String msg = "Os alunos com 3 ou mais disciplinas são:";
        List<Aluno> alunoList = Turma.alunosMaisTresDisciplinas();
        for (Aluno aluno: alunoList) {
            msg+="\n"+aluno.getNome();
        }
        JOptionPane.showMessageDialog(null, msg);
    }


    private void listarMatriculadosMesmaDisciplinas(){
        String msg = "Os alunos com a mesma disciplina são:\n";
        for (Turma turma: Turma.getTurma()){
            List<Aluno> alunoList = new ArrayList<Aluno>(turma.getAlunoSet());
            if (alunoList.size()>1){
                msg+= "\n*****\n" +
                        turma.getDisciplina().getNome()+"\n";
                for(int i=0;i<alunoList.size();i++){
                    msg += (i+1) + " - " + alunoList.get(i).getNome()+"\n";
                }
            }

        }
        JOptionPane.showMessageDialog(null, msg);

    }
}
