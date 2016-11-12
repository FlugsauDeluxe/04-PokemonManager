package pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonManager {

	public static void main(String[] args) {	    
		Pokemon p0 = new Pokemon("Pikachu", Type.Poison);
		Pokemon p1 = new Pokemon("Carapuce", Type.Water);
		Pokemon p2 = new Pokemon("Raupy", Type.Fire);
		Trainer t0 = new Trainer("Peter", "Lustig");
		Trainer t1 = new Trainer("Alisa", "Traurig");
		t0.addPokemon(p0);
		System.out.println("Pokemon p0:");
		System.out.println(p0);
		System.out.println("Pokemons of " + t0 + ": ");
		System.out.println(t0.getPokemons());
		List<Pokemon> ps = new ArrayList<Pokemon>();
		ps.add(p1);
		ps.add(p2);
		t1.setPokemons(ps);
		System.out.println("Pokemons of " + t1 + ": ");
		System.out.println(t1.getPokemons());
		System.out.println();
		System.out.println("Before Swap:1");
		System.out.println(p0);
		System.out.println(p1);
		Swap s1 = new Swap();
		s1.execute(p0, p1);
		System.out.println("After Swap:1");
		System.out.println(p0);
		System.out.println(p1);
		System.out.println();
		System.out.println("Before Swap:2");
		System.out.println(p0);
		System.out.println(p2);
		Swap s2 = new Swap();
		s2.execute(p0, p2);
		System.out.println("After Swap:2");
		System.out.println(p0);
		System.out.println(p2);
		System.out.println();
		System.out.println("Before Swap:3");
		System.out.println(p1);
		System.out.println(p2);
		p2.setType(Type.Water);
		Swap s3 = new Swap();
		s3.execute(p1, p2);
		System.out.println("After Swap:3");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println();
		p2.setType(Type.Fire);
		System.out.println("Before Swap:4");
		System.out.println(p1);
		System.out.println(p2);
		p1.setSwapAllow(false);
		Swap s4 = new Swap();
		s4.execute(p1, p2);
		System.out.println("After Swap:4");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println();
		System.out.println("Before Competition:5");
		System.out.println(p1);
		System.out.println(p2);
		Competition c0 = new Competition();
		c0.execute(p1, p2);
		System.out.println("After Competition:5");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println();

	}

}
