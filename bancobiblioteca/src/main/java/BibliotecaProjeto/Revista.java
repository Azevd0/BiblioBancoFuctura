package BibliotecaProjeto;

import jakarta.persistence.Entity;

@Entity
public class Revista extends Item{
    public Revista() {}

	public Revista(String t, String c, String a, String y) {
		super(t, c, a, y);	}

	@Override
	public String toString() {
        return super.toString() + "Tipo: Revista\n--------------------------";
    }

	
	
	
	
	
}
