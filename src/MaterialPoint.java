/**
 * Class MaterialPoint is a super class for further inherited classes
 * Its purpose is to define a very first object of each thing - MaterialPoint
 * 
 * @author Kamil Bogdanowski
 *
 */

public class MaterialPoint 

{
	private float mass;
	private float distance;
	private String name;
	private float x_coordinate;
	private float y_coordinate;
	private float z_coordinate;

	/** 
	 * Constructor without implementing the mass of the point
	 * @param mass defines the mass of a material point
	 */
	public MaterialPoint()
	{
		mass = 1f;
	}
	
	/**
	 *Overloaded constructor with implementing the mass of the point
	 * @param MaterialPointMass
	 */
	public MaterialPoint(float MaterialPointMass)
	{	
		this.mass = MaterialPointMass;
		System.out.println("You generated point of mass " + this.mass);
		System.out.println();
	}
	
	/**
	 * Overloaded constructor with implementing Mass; x,y,z coordinates
	 * @param PointMass it is a mass of the point
	 * @param x it is a x coordinate of the point
	 * @param y it is a y coordinate of the point
	 * @param z it is a z coordinate of the point
	 */
	public MaterialPoint(float PointMass, float x, float y, float z)
	{
		x_coordinate = x;
		y_coordinate = y;
		z_coordinate = z;
		mass = PointMass;
	}
	
	/**
	 * Getter of x coordinate of the point
	 * @return x_coordinate - it returns the value of the x coordinate
	 */
	public float getxcoordinate()
	{
		return x_coordinate;
	}
	
	/**
	 * Getter of y coordinate of the point
	 * @return y_coordinate - it returns the value of the y coordinate
	 */
	public float getycoordinate()
	{
		return y_coordinate;
	}
	
	/**
	 * Getter of z coordinate of the point
	 * @return z_coordinate - it returns the value of the z coordinate
	 */
	public float getzcoordinate()
	{
		return z_coordinate;
	}
	
	/**
	 * Getter of the mass of the point
	 * @return mass - it returns mass of the point
	 */
	public float getMass()
	{
		return mass;
	}
	
	/**
	 * String type Method whose aim is to show "Material Point"
	 * @return name - it returns the title of the Material Point
	 */
	public String ShowMaterialPoint()
	{
		name = "Material Point";
		return name;
	}
	
	/**
	 * Void type Method whose aim is to change mass of the point
	 * @param newMass it is a new changed mass defined by the user
	 * Value control included
	 */
	public void ChangeMass(int newMass)
	{
		if ( newMass <= 0 )
		{
			System.out.println("The mass you chose is probably either negative or zero.");
			System.out.println();
		}
		else 
		{
			mass = newMass;
			System.out.println("New Mass is " + mass);
			System.out.println();
		}
	}
	
	/**
	 * Float type Method whose aim is to calculate the Inertia of each individual point
	 * @return I - returns value of the Inertia
	 */
	public float Inertia()
	{
		float I = 0f;
		return I;
	}
	
	/**
	 * Float type Method whose aim is to calculate the Inertia of each indiviudal point towards specific axis in coordinate " d "
	 * @param d - distance between axis and point needed to Steiner Inertia
	 * @return Isteiner - returns Steiner Inertia 
	 */
	public float Steiner(float d)
	{
		distance = d;
		float Isteiner = Inertia() + getMass() * distance * distance;
		return Isteiner;
	}

	/**
	 * Float type Method whose aim is to calculate the Inertia of each individual point towards no distance ( no error while forgetting the distance of specific axis)
	 * @return Isteiner - returns Steiner Inertia in the default distance of 0 from the inital point
	 */
	public float Steiner()
	{
		distance = 0;
		float Isteiner = Inertia() + getMass() * distance * distance;
		return Isteiner;
	}
	
	/**
	 * Float type Method whose aim is to show main info about each individual point
	 * Value control included
	 */
	public void Show_Info()
	{
		if (getMass()>0)
		{
		System.out.println("The mass of a " + ShowMaterialPoint() + " is " + getMass() + " whose Inertia is " + 
		Inertia() + " and Inertia towards a specific\naxis in the distance of " + distance + " from the point 0 is "
		+ Steiner(distance));
		System.out.println();
		} else {
		System.out.println("The mass you chose is probably either negative or zero.");
		System.out.println();
		}
	}

}
	
	
		
		
		
		
		
		

		
		
		
		
		
		
		
	


