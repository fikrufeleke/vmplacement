# vmplacement
The project is a collection of virtual machine placement classes for efficient energy utilization and reduced service level agreement 
violation in cloud datacenter. The codes are to be implemented in CloudSim-3.0.3 simulator and all extend the class
PowerVmAllocationPolicyMigrationLocalRegression which available in the power package of the simulator.

The following three classes in this project are based on algorithms in the thesis work of the author (Fikru Feleke Moges, "Energy-aware  VM placement algorithms in an OpenStack cloud, "  MSc thesis, Addis Ababa University, Sep 2018.)

1. PowerVmAllocationPolicyMFPED.java	
2. PowerVmAllocationPolicyPEBFD.java	
3. PowerVmAllocationPolicyPEFFD.java	
The following class is based on the virtual machine placement of OpenStack Neat (http://openstack-neat.org/)
4. PowerVmAllocationPolicyMBFD.java	


If you are to use any of the virtual machine placement classes in this classes, please site the following paper:
Fikru Feleke Moges, "Energy-aware  VM placement algorithms in an OpenStack cloud, "  MSc thesis, Addis Ababa University, Sep 2018.



Usage : 
1. Create the power datacenter and for the policy argument call one of  our virtual machine placement class.
2. Run the simulation

