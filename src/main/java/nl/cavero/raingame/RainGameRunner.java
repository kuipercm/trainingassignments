package nl.cavero.raingame;

import java.util.List;

/**
 * A rain game
 * 
 * <p>
 * The objective of this game is to determine the amount of rain in each pool at the end of the rain season.
 * 
 * <p>
 * Imagine an area on which it rains during a certain period. This area is however not flat but has
 * hills and valleys. It rains on the whole area, but of course the water accumulates in the lowest parts.
 * We want to know how much water is in each pool after the rain stops.
 * 
 * <p>
 * The game starts on a rectangular playing field which has already been divided into smaller areas (squares if you will).
 * Of these areas the altitude is given as well. 
 * When it rains, the water will flow from the highest altitudes to the lowest altitude. Pools form where
 * the (regional) lowest points are. 
 * Initially, it is assumed that the rain is uniform over the entire area, so each smaller area receives the same amount of rain.
 * 
 * <p>
 * The rules of the flow are as follows:
 * -- water flows from high to low regions. It never flows from low to high regions.
 * -- water follows the steepest incline, meaning that a region with an altitude of 8 next to a two regions of 3 and 2 (resp.) will flow towards 2.
 * -- if two inclines should be equally steep, the flow choses the first of North - East - South - West.
 * -- water flows only in east-west (/west-east) and north-south (/south-north) direction. It does not flow diagonally over the region.
 * -- if the altitude of all neighbors is equal, there is no flow.
 *
 */
public class RainGameRunner {
	public static void main(String[] args) {
		int[][] heightMap = createHeightMap();
		int amountOfRainPerSquare = 3;
		
		List<Pool> pools = new RainGame(heightMap, amountOfRainPerSquare).getPools();
		pools.forEach(p -> System.out.println("Pool at (" + p.getX() + "," + p.getY() + ") contains " + p.getVolume()));
	}
	
	/*
	 * Please note, this is an example map to demonstrate a sample input. Not all inputs will be 3x3.
	 */
	private static int[][] createHeightMap() {
		int[][] heights = new int[3][3];
		heights[0][0] = 4;
		heights[1][0] = 7;
		heights[2][0] = 8;
		heights[0][1] = 7;
		heights[1][1] = 5;
		heights[2][1] = 3;
		heights[0][2] = 1;
		heights[1][2] = 6;
		heights[2][2] = 2;
		
		return heights;
	}
}
