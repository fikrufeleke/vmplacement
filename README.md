# VM Placement
The project is a collection of virtual machine placement classes for efficient energy utilization and reduced service level agreement 
violation in cloud datacenter. The codes are to be implemented in CloudSim-3.0.3 simulator and all extend the class
PowerVmAllocationPolicyMigrationLocalRegression which is available in the power package of the simulator.

The following three classes in this project are based on algorithms in the thesis work of the author (Fikru Feleke Moges, "Energy-aware  VM placement algorithms in an OpenStack cloud, "  MSc thesis, Addis Ababa University, Sep 2018.)

1. PowerVmAllocationPolicyMFPED.java	
2. PowerVmAllocationPolicyPEBFD.java	
3. PowerVmAllocationPolicyPEFFD.java	

The following class is based on the virtual machine placement of OpenStack Neat (http://openstack-neat.org/) :
 
4. PowerVmAllocationPolicyMBFD.java	

If you are to use any the three above virtual machine placement classes (1-3), please cite the following paper:

F.F. Moges, "Energy-aware  VM placement algorithms in an OpenStack cloud",  MSc thesis, Addis Ababa University, Sep 2018.

Usage : 
1. Include the the above virtual machine placement classes in power package of CloudSim simulator.
2. Create your simulation environment such that  the VM AllocationPolicy of the power datacenter is set to one of the above virtual machine placement class.
3. Run your simulation.

