package pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paul
 *
 */
public class Trainer {
	/** */
	private String firstname;
	/** */
	private String lastname;
	/** */
	private List<Pokemon> pokemons = new ArrayList<Pokemon>();

	/**
	 * @param firstname
	 * @param lastname
	 */
	public Trainer(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	/**
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return
	 */
	public List<Pokemon> getPokemons() {
		return pokemons;
	}

 
	/**
	 * @param pokemons
	 * 
	 * for bidirectional linking it is necessary to set this as trainer
	 */
	public void setPokemons(List<Pokemon> pokemons) {
	        for (Pokemon p1 : this.pokemons) {
	            if (!pokemons.contains(p1)) {
	                p1.setTrainer(null);
	            }
	        }
		this.pokemons = pokemons; //TODO ERROR? die bisherige Pokemonliste wird gelöscht
		                          //was passiert mit den Pokemons die davor in der Liste waren???
		                          //falls sie freigegeben werden muss ihr Trainer zurückgesetzt werden!!!
		for (Pokemon p : getPokemons()) {
			p.setTrainer(this); // set this as trainer for all
		}
	}
	
	/**
	 * @param index
	 * @return
	 */
	public Pokemon getPokemon(int index) {
		return getPokemons().get(index); //TODO ERROR es wird immer nur ein Nullpointer übergeben!!!
	}

	/**
	 * @param pokemon
	 */
	public void addPokemon(Pokemon pokemon) {
		getPokemons().add(pokemon); // add to list 
		pokemon.setTrainer(this); // set as trainer
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return getFirstname() +" " + getLastname();
	}
	
}
