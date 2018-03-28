public class Testing 
{	
	public static void main(String[] args)
	{
		//Declaration of the new object of the class - New - it is a rigid body 
		Rigid_Body New = new Rigid_Body(12,1,20);
		
		//Declaration of the coordinates od the Steiner Axises
		New.SteinerAxis(2,4,12);
		
		//Setting and calculating required distances
		New.distances();
		
		//Creating rigid body on the basis on the datas we put into the constructor
		New.newArrayXYZ();
		
		//Showing full info of the rigid body
		New.ShowFullInfo();
					
	}
}


//SettingRandomArray Array1 = new SettingRandomArray(10,12,20,12);
		//Rigid_Body New = new Rigid_Body(12,1,20);
///New.SteinerAxis(2,4,12);
		//New.distances();
		//New.newArrayXYZ();
		//New.ShowFullInfo();

