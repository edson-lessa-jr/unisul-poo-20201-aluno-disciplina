package br.unisul.aula;

public class Disciplina {
    private int codigo;
    private String nome;
    private String sala;

    public Disciplina(int codigo, String nome, String sala) {
        this.codigo = codigo;
        this.nome = nome;
        this.sala = sala;
    }

    public Disciplina(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getSala() {
        return sala;
    }

    @Override
    public boolean equals(Object objeto){
        if (this == objeto) {
            return true;
        }
        if (!(objeto instanceof Disciplina)) {
            return false;
        }

        Disciplina disciplina = (Disciplina) objeto;
        if (this.getCodigo()== disciplina.getCodigo()) {
            return true;
        } else {
            return  false;
        }
        /*
        // OU PODE FAZER ASSIM
        if (this.getCodigo() == ((Disciplina) objeto).getCodigo()) {
            return true;
        } else {
            return false;
        }
        // OU PODE FAZER ASSIM
        return this.getCodigo() == ((Disciplina) objeto).getCodigo();
         */
    }

}
