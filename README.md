# VM Placement Algorithms
This project is a collection of virtual machine placement classes for efficient energy utilization and reduced service level agreement 
violation in cloud datacenter. The codes are to be implemented in CloudSim-3.0.3 simulator and all extend the class
PowerVmAllocationPolicyMigrationLocalRegression which is available in the power package of the simulator.

The following three classes in this project are based on algorithms from the research work (Moges, F. & Abebe, S. (2019) Energy-aware VM placement algorithms for the OpenStack Neat consolidation framework. Journal of Cloud Computing 8:2. 10.1186/s13677-019-0126-y).
1. PowerVmAllocationPolicyMFPED.java 
2. PowerVmAllocationPolicyPEBFD.java 
3. PowerVmAllocationPolicyPEFFD.java 

The following class is based on the virtual machine placement of OpenStack Neat (http://openstack-neat.org/) :
 
4. PowerVmAllocationPolicyMBFD.java 

If you are to use any of these project files (the virtual machine placement classes or converted workload traces), please cite the following paper:

Moges, F. & Abebe, S. (2019) Energy-aware VM placement algorithms for the OpenStack Neat consolidation framework. Journal of Cloud Computing 8:2. 10.1186/s13677-019-0126-y

Usage : 
1. Include the the above virtual machine placement classes in power package of CloudSim simulator.
2. Create your simulation environment such that  the VM AllocationPolicy of the power datacenter is set to one of the above virtual machine placement class.
3. Run your simulation.
