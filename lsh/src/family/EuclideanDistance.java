/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package family;
import Main.Vector;

/**
 *
 * @author JanithaT
 */
public class EuclideanDistance implements DistanceMeasure {
	
	/* (non-Javadoc)
	 * @see be.hogent.tarsos.lsh.families.DistanceMeasure#distance(be.hogent.tarsos.lsh.Vector, be.hogent.tarsos.lsh.Vector)
	 */
	@Override
	public double distance(Vector one, Vector other) {
		double sum = 0.0;
		for(int d = 0 ; d < one.getDimensions() ; d++) {
			double delta = one.get(d) - other.get(d);
			sum += delta * delta;
		}
		return Math.sqrt(sum);
	}
}
