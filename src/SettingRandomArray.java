import java.util.ArrayList;
import java.util.Random;

/**
 * SettingRandomArray is an inherited class whose purpose is to generate the array of the points
 * of different random masses and their Steiner Inertia towards specific axis
 * 
 * @author Kamil Bogdanowski
 *
 */

public class SettingRandomArray extends MaterialPoint 
{ 
	private int Amount_Of_Points;
	private float minrange;
	private float maxrange; 
	private float Steiner_Distance;

	/**
	 * Constructor whose aim is to set Amount of points, Min range, Max range and distance of Steiner Axis
	 * @param AmPo - Amount of Points required
	 * @param minran - Minimal range of mass ( float type )
	 * @param maxran - Maximal range of mass ( float type )
	 * @param stdis - Coordinate of Steiner Axis 
	 */
	public SettingRandomArray (int AmPo,float minran ,float maxran ,float stdis)
	{
		Amount_Of_Points = AmPo;
		minrange = minran;
		maxrange = maxran;
		Steiner_Distance = stdis;
		System.out.println("You declared Point List including " + Amount_Of_Points +" Points of mass oscilating between " + minrange);
		System.out.println("and "+ maxrange + " and its Steiner Inertia will be calculated towards axis in the coordinate " + Steiner_Distance) ;
	}
	
	/**
	 * Method whose aim is to generate array of points and showing info about them
	 *@param rand - random value from defined range 
	 *@param randomMass - it is random mass created by the rand method and loop
	 */
	public void newArray()
		{
			ArrayList <Float> PointList = new ArrayList<Float>() ;
			
			for (int i = 0; i<Amount_Of_Points; i++ )
				{	
					Random rand = new Random();
					float randomMass = rand.nextFloat()* (maxrange - minrange) + minrange;
					PointList.add(i,randomMass);
					MaterialPoint Material_Point = new MaterialPoint(PointList.get(i));
					Material_Point.Steiner(Steiner_Distance);
					Material_Point.Show_Info();
					System.out.println();
				}		
		}
}



