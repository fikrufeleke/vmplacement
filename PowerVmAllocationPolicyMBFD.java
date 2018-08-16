package org.cloudbus.cloudsim.power;




import java.util.List;
import java.util.Set;

import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Vm;



public class PowerVmAllocationPolicyMBFD extends PowerVmAllocationPolicyMigrationLocalRegression{
	
	public PowerVmAllocationPolicyMBFD(
			List<? extends Host> hostList,
			PowerVmSelectionPolicy vmSelectionPolicy,
			double safetyParameter,
			double schedulingInterval,
			PowerVmAllocationPolicyMigrationAbstract fallbackVmAllocationPolicy){
		super(hostList,
				vmSelectionPolicy,
				safetyParameter,
				schedulingInterval,
				fallbackVmAllocationPolicy);
		
	}
	
	@Override
	public PowerHost findHostForVm(Vm vm, Set<? extends Host> excludedHosts) {

		double minCPU = Double.MAX_VALUE;
		double inactiveCPU = Double.MAX_VALUE;
		PowerHost allocatedHost = null;
		PowerHost inactiveHost = null;

		for (PowerHost host : this.<PowerHost> getHostList()) {
			if (excludedHosts.contains(host)) {
				continue;
			}
			if (host.isSuitableForVm(vm)) {				
				if (getUtilizationOfCpuMips(host) != 0 && isHostOverUtilizedAfterAllocation(host, vm)) {
					continue;
				}
				
				double availableCPU = host.getAvailableMips();
				if(host.getUtilizationMips() == 0) {			
					if (availableCPU < inactiveCPU ) {
						inactiveCPU = availableCPU;
						inactiveHost = host;
						}	
					continue;
					}			
				
				if (availableCPU < minCPU ) {
					minCPU = availableCPU;
					allocatedHost = host;
					}
				else if (availableCPU == minCPU ) {
					if (host.getRamProvisioner().getAvailableRam() < allocatedHost.getRamProvisioner().getAvailableRam()) {
						allocatedHost = host;							
					}
				}
				
			}
		}
		
		return (allocatedHost!=null) ?allocatedHost:inactiveHost;
	}

}
