package pokemon;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class PokemonAverageForceTest extends TestCase {

	private Pokemon pokemon0;
	private Pokemon pokemon1;
	private Pokemon pokemon2;
	
	private Pokemon pokemon00;
	private static final double DELTA = 1e-15;
	
	private Pokemon pokemon000;
	private Pokemon pokemon001;
	private Pokemon pokemon002;
	private Pokemon pokemon003;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp() throws Exception {
		super.setUp();
		pokemon0 = new Pokemon("Pikachu1", Type.Poison);
		pokemon1 = new Pokemon("Carapuce", Type.Water);
		pokemon2 = new Pokemon("Raupy", Type.Fire);		
		Trainer t0 = new Trainer("Peter", "Lustig");
		Trainer t1 = new Trainer("Alisa", "Traurig");
		t0.addPokemon(pokemon0);
		List<Pokemon> ps = new ArrayList<Pokemon>();
		ps.add(pokemon1);
		ps.add(pokemon2);
		t1.setPokemons(ps);
		Competition c0 = new Competition();
		c0.execute(pokemon0, pokemon1);
		
		
		//SetUp for the Test ISW20EXA08-23 testPokemonAverageForceTypeFireZeroCompetitions
	        pokemon00 = new Pokemon("Glumander", Type.Fire);
	        Trainer t00 = new Trainer("Alan", "Turing");
	        t00.addPokemon(pokemon00);
	        
	        //SetUp for the Test ISW20EXA08-24 testPokemonAverageForceTypePoisonSeveralCompetitions
	        pokemon000 = new Pokemon("Bisasam",Type.Poison);
	        pokemon001 = new Pokemon("Glumander",Type.Fire);
	        pokemon002 = new Pokemon("Schiggy",Type.Water);
	        pokemon003 = new Pokemon("Pikachu",Type.Poison);
	        Trainer t000 = new Trainer("Alan", "Turing");
	        Trainer t001 = new Trainer("Konrad", "Zuse");
	        t000.addPokemon(pokemon000);
	        t001.addPokemon(pokemon001);
	        t001.addPokemon(pokemon002);
	        t001.addPokemon(pokemon003);
                Competition c000 = new Competition();
                Competition c001 = new Competition();
                Competition c002 = new Competition();
                c000.execute(pokemon000, pokemon001);
                c001.execute(pokemon000, pokemon002);
	        c002.execute(pokemon000, pokemon003);
	}
	
	public void testPokemonAverageForceTypeWaterOneScore() throws Exception {
		System.out.println("\nStart TestCase 1");
		assertNotNull(pokemon1);
		// ensure pokemon has the desired type
		assertEquals(Type.Water, pokemon1.getType());
		// max force value for pokemon type
		double maxForce = pokemon1.getType().ordinal() + 1;
		// check that the average force is below the allowed maximum force
		// this is the most important call of the test
		assertTrue(maxForce > pokemon1.averageForce());
		assertEquals("Carapuce", pokemon1.getName());
		System.out.println(pokemon1 + "averageForce:" + pokemon1.averageForce());
		System.out.println("End TestCase 1\n");
	}
	
	public void testPokemonAverageForceTypeFireZeroCompetitions() throws Exception {
	        System.out.println("\nStart TestCase 2");
	        assertNotNull(pokemon00);
	        // ensure pokemon has the desired type
	        assertEquals(Type.Fire, pokemon00.getType());
	        // ensure pokemon has no Competition yet
	        assertTrue(pokemon00.getCompetitions().isEmpty());
	        // check that the average force is 0
	        assertEquals(pokemon00.averageForce(), 0, DELTA);
	        assertEquals("Glumander",pokemon00.getName());
                System.out.println(pokemon00 + "averageForce:" + pokemon00.averageForce());
                System.out.println("End TestCase 2\n");
	        
	}
	
	public void testPokemonAverageForceTypePoisonSeveralCompetitions() throws Exception {
	        System.out.println("\nStart TestCase 3");
                assertNotNull(pokemon000);
                assertNotNull(pokemon001);
                assertNotNull(pokemon002);
                assertNotNull(pokemon003);
                // ensure pokemons have the desired type
                assertEquals(Type.Poison, pokemon000.getType());
                assertEquals(Type.Fire, pokemon001.getType());
                assertEquals(Type.Water, pokemon002.getType());
                assertEquals(Type.Poison, pokemon003.getType());
                // ensure pokemons have the desired name
                assertEquals("Bisasam",pokemon000.getName());
                assertEquals("Glumander",pokemon001.getName());
                assertEquals("Schiggy",pokemon002.getName());
                assertEquals("Pikachu",pokemon003.getName());
                // ensure pokemons have a Competition
                assertFalse(pokemon000.getCompetitions().isEmpty());
                assertFalse(pokemon001.getCompetitions().isEmpty());
                assertFalse(pokemon002.getCompetitions().isEmpty());
                assertFalse(pokemon003.getCompetitions().isEmpty());
                // check that the average force is greater than 0
                assertTrue(0 < pokemon000.averageForce());
                assertTrue(0 < pokemon001.averageForce());
                assertTrue(0 < pokemon002.averageForce());
                assertTrue(0 < pokemon003.averageForce());
                // check that the average force is smaller than 
                // 3 for type Poison
                // 2 for type Water
                // 1 for type Fire 
                assertTrue(3 > pokemon000.averageForce());
                assertTrue(1 > pokemon001.averageForce());
                assertTrue(2 > pokemon002.averageForce());
                assertTrue(3 > pokemon003.averageForce());

                System.out.println(pokemon000 + "averageForce: " + pokemon000.averageForce());
                System.out.println(pokemon001 + "averageForce: " + pokemon001.averageForce());
                System.out.println(pokemon002 + "averageForce: " + pokemon002.averageForce());
                System.out.println(pokemon003 + "averageForce: " + pokemon003.averageForce());
                System.out.println("End TestCase 3\n");	       
	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		pokemon0 = null;
		pokemon1 = null;
		pokemon2 = null;
		
		pokemon00 = null;
		
                pokemon000 = null;
                pokemon001 = null;
                pokemon002 = null;
                pokemon003 = null;
	}
}
