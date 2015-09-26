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
import Main.Vector;

public class CosineDistance implements DistanceMeasure {

	@Override
	public double distance(Vector one, Vector other) {
		double distance=0;
		double similarity = one.dot(other) / Math.sqrt(one.dot(one) * other.dot(other));
		distance = 1 - similarity;
		return distance;
	}
}