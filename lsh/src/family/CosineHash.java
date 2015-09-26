/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package family;

import Main.Vector;
import java.util.Random;

/**
 *
 * @author JanithaT
 */
public class CosineHash implements HashFunction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 778951747630668248L;
	final Vector randomProjection;
	
	public CosineHash(int dimensions){
		Random rand  = new Random();
		randomProjection = new Vector(dimensions);
		for(int d=0; d<dimensions; d++) {
			//mean 0
			//standard deviation 1.0
			double val = rand.nextGaussian();
			randomProjection.set(d, val);
		}
	}
	
	@Override
	public int hash(Vector vector) {
		//calculate the dot product.
		double result = vector.dot(randomProjection);
		//returns a 'bit' encoded as an integer.
		//1 when positive or zero, 0 otherwise.
		return result > 0 ? 1 : 0;
	}
}
