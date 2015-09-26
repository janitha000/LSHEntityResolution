/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package family;

/**
 *
 * @author JanithaT
 */
import java.util.Random;

import Main.Vector;

public class EuclideanHash implements HashFunction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3784656820380622717L;
	private Vector randomProjection;
	private int offset;
	private int w;
	
	public EuclideanHash(int dimensions,int w){
		Random rand = new Random();
		this.w = w;
		this.offset = rand.nextInt(w);
		
		randomProjection = new Vector(dimensions);
		for(int d=0; d<dimensions; d++) {
			//mean 0
			//standard deviation 1.0
			double val = rand.nextGaussian();
			randomProjection.set(d, val);
                        
		}
                //System.out.println("length " + randomProjection.getDimensions());
	}
	
	public int hash(Vector vector){
            //System.out.println("LENGTH "+randomProjection.getDimensions() );
		double hashValue = (vector.dot(randomProjection)+offset)/Double.valueOf(w);
                //System.out.println(hashValue + " Random Projection: " + randomProjection + " random int: " + offset);
		return (int) Math.round(hashValue);
	}
}
