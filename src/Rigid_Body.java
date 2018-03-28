import java.util.ArrayList;
import java.util.Random;
import static java.lang.Math.*;

/**
 * Class whose aim is to generate list of points which will create a rigid body 
 * and also to calculate its specific features like Rigid's Inertia, Inertia towards specific axis
 * and so on
 * 
 * @author Kamil Bogdanowski
 *
 */

public class Rigid_Body {
	
	private int Amount_Of_Points;
	private float minrange;
	private float maxrange; 
	private float SteinerX;
	private float SteinerY;
	private float SteinerZ;
	private float distance_x;
	private float distance_y;
	private float distance_z;
	private float Xcentr;
	private float Ycentr;
	private float Zcentr;
	private float wholemass;
	private float ProductOfMassandX;
	private float ProductOfMassandY;
	private float ProductOfMassandZ;
	private float RigidInertiaX;
	private float RigidInertiaY;
	private float RigidInertiaZ;
	
	/**
	 * Constructor of the class whose aim is to initialize main parameters of points of the rigid body
	 * @param AmPo - Amount of points of the rigid body
	 * @param minran - Min range of the mass; x,y,z coordinates
	 * @param maxran - Max range of the mass; x,y,z coordinates
	 */
	public Rigid_Body (int AmPo,float minran ,float maxran)
		{
			if(AmPo>0 && minran>=0 && maxran>0) 
			{
			Amount_Of_Points = AmPo;
			minrange = minran;
			maxrange = maxran;
			} else {
				System.out.print("Wrong datas including negative values");
			}
		}

	/**
	 * Method whose aim is to declare the coordinates of the Steiner Axis
	 * @param x - x coordinate
	 * @param y - y coordinate 
	 * @param z - z coordinate
	 */
	public void SteinerAxis(float x,float y,float z)
		{
			SteinerX = x;
			SteinerY = y;
			SteinerZ = z;	
		}
	
	/**
	 * Method whose aim is to generate list of points with random masses, x coordinates, y coordinates and z coordinates
	 * 
	 * @param wholemass - mass of whole rigid body
	 * @param ProductOfMassandX - sum of every single multiplication of mass and its x coordinate
	 * @param ProductOfMassandY - sum of every single multiplication of mass and its y coordinate
	 * @param ProductOfMassandZ - sum of every single multiplication of mass and its z coordinate
	 * @param Xcentr - it is coordinate of the middle x point of the rigid body
	 * @param Ycentr - it is coordinate of the middle y point of the rigid body
	 * @param Zcentr - it is coordinate of the middle z point of the rigid body
	 * 
	 */
	public void newArrayXYZ()

		{
			ArrayList <Float> MassList = new ArrayList<Float>() ;
			ArrayList <Float> XcoordinateList = new ArrayList<Float>() ;
			ArrayList <Float> YcoordinateList = new ArrayList<Float>() ;
			ArrayList <Float> ZcoordinateList = new ArrayList<Float>() ;
				
			for (int i = 0; i<Amount_Of_Points;i++ )
				{	
					Random rand = new Random();
					float randomMass = rand.nextFloat()* (maxrange - minrange) + minrange;
					MassList.add(i,randomMass);
						
					float x = rand.nextFloat()* (maxrange - minrange) + minrange;
					XcoordinateList.add(i,x);
						
					float y = rand.nextFloat()* (maxrange - minrange) + minrange;
					YcoordinateList.add(i,y);
						
					float z = rand.nextFloat()* (maxrange - minrange) + minrange;
					ZcoordinateList.add(i,z);	
					
					///MaterialPoint MaterialPoint = new MaterialPoint(MassList.get(i),XcoordinateList.get(i),YcoordinateList.get(i),ZcoordinateList.get(i));
						
					wholemass = wholemass + MassList.get(i);
					ProductOfMassandX = ProductOfMassandX +	 MassList.get(i) * XcoordinateList.get(i);
					ProductOfMassandY= ProductOfMassandY + MassList.get(i) *YcoordinateList.get(i);
					ProductOfMassandZ= ProductOfMassandZ+ MassList.get(i) * ZcoordinateList.get(i);
					
					Xcentr = ProductOfMassandX / wholemass;
					Ycentr = ProductOfMassandY/ wholemass;
					Zcentr = ProductOfMassandZ/ wholemass;
					RigidInertiaX = RigidInertiaX + MassList.get(i)*(Xcentr-XcoordinateList.get(i))*(Xcentr-XcoordinateList.get(i));
					RigidInertiaY =RigidInertiaY+ MassList.get(i)*(Ycentr-YcoordinateList.get(i))*(Ycentr-YcoordinateList.get(i));
					RigidInertiaZ =RigidInertiaZ+ MassList.get(i)*(Zcentr-ZcoordinateList.get(i))*(Zcentr-ZcoordinateList.get(i));
					
					System.out.println("Material Point of mass " + MassList.get(i) + " whose x coordinate is "+	XcoordinateList.get(i)+"\n");
					
					System.out.println("and y coordinate is " + YcoordinateList.get(i) + " and z coordinate is " + ZcoordinateList.get(i));
					System.out.println();
					System.out.println();
				
					}
				}					
	
	/**
	 * It is a getter method which returns Inertia in X axis of Rigid Body
	 */
	public float getRigidX()
	{
		return RigidInertiaX;
		
	}
	
	/**
	 * It is a getter method which returns Inertia in Y axis of Rigid Body
	 */
	public float getRigidY()
	{
		
		return RigidInertiaY;
	}
	
	/**
	 * 	It is a getter method which returns Inertia in Z axis of Rigid Body
	 */
	public float getRigidZ()
	{
		return RigidInertiaZ;
		
	}
	
	/**
	 * It is a getter method which returns amount of points of the rigid body
	 */
	public int getAmountofpoints()
	{
		return Amount_Of_Points;
	}
	
	/**
	 * It is a getter method which returns whole mass of points of the rigid body
	 */
	public float getwholemass()
	{
		return wholemass;
		
	}
	
	/**
	 * It is a getter method which returns central x coordinate the rigid body
	 */
	public float getXc(){
		return Xcentr;
	}
	
	/**
	 * It is a getter method which returns central y coordinate of the rigid body
	 */
	public float getYc()
	{
		return Ycentr;
	}
	
	/**
	 * It is a getter method which returns central z coordinate of the rigid body
	 */
	public float getZc()
	{
		return Zcentr;
	}
	
	/**
	 * It is a method which set specific distances between axis and central coordinates of the rigid body
	 */
	public void distances()
	{
		
		distance_x = abs(SteinerX - Xcentr);
		distance_y = abs(SteinerY - Ycentr);
		distance_z = abs(SteinerZ - Zcentr);
	}
	
	/**
	 * It is a method which returns Steiner Inertia in the X axis of the rigid body
	 */
	public float SteinerX()
	{
		float IsteinerX;
		IsteinerX = RigidInertiaX + wholemass * distance_x * distance_x;
		return IsteinerX;
	}

	/**
	 * It is a method which returns Steiner Inertia in the Y axis of the rigid body
	 */
	public float SteinerY()
	{
		float IsteinerY;
		IsteinerY= RigidInertiaY + wholemass * distance_y * distance_y;
		return IsteinerY;
				
	}
	
	/**
	 * It is a method which returns Steiner Inertia in the Z axis of the rigid body
	 */
	public float SteinerZ()
	{
		float IsteinerZ;
		IsteinerZ = RigidInertiaZ + wholemass * distance_z * distance_z;
		return IsteinerZ;
	}
	
	/**
	 * It is a method whose aim is to show full information of the rigid body
	 */
	public void ShowFullInfo()
	{
		System.out.println("This Rigid consists of " + getAmountofpoints() + " points, whose whole mass is " +  getwholemass());
		System.out.println("and coordinates of the middle are " + getXc() +" and " + getYc() + " and " + getZc());
		System.out.println("Its Inertia in the X axis is " + getRigidX() + " and in the Y axis " + getRigidY());
		System.out.println("and in the Z axis " + getRigidZ() );
		System.out.println("Its Inertia towards axis X in coordinate " + SteinerX + " is " + SteinerX());
		System.out.println("Its Inertia towards axis Y in coordinate " + SteinerY + " is " + SteinerY());
		System.out.println("Its Inertia towards axis Z in coordinate " + SteinerZ + " is " + SteinerZ());
		
	}
}



