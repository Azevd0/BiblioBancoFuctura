package BibliotecaProjeto;

import jakarta.persistence.Entity;

@Entity
public class Livro extends Item{
    public Livro() {}

	public Livro(String t, String c, String a,String y) {
		super(t, c, a,y);	}

	@Override
	public String toString() {
        return super.toString() + "Tipo: Livro\n--------------------------";
    }
	
	
	



}
