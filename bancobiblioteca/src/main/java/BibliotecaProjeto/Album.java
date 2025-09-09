package BibliotecaProjeto;

import jakarta.persistence.Entity;

@Entity
public class Album extends Item {
    public Album() {}

	public Album(String t, String c, String a, String y) {
		super(t, c, a, y);
	}

	@Override
	public String toString() {
        return super.toString() + "Tipo: Album\n--------------------------";
    }

}
