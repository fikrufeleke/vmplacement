package org.cloudbus.cloudsim.power;




import java.util.List;
import java.util.Set;

import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Vm;



public class PowerVmAllocationPolicyMFPED extends PowerVmAllocationPolicyMigrationLocalRegression{
	
	public PowerVmAllocationPolicyMFPED(
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

		double minDiff = Double.MAX_VALUE;
		PowerHost allocatedHost = null;

		for (PowerHost host : this.<PowerHost> getHostList()) {
			if (excludedHosts.contains(host)) {
				continue;
			}
			if (host.isSuitableForVm(vm)) {
				double utilization = host.getUtilizationOfCpu();
				if ( getUtilizationOfCpuMips(host)!= 0 && isHostOverUtilizedAfterAllocation(host, vm)) {
					continue;
				}
				
				double diff = Math.abs(utilization - 0.60);
				try {
					if (diff < minDiff ) {
						minDiff = diff;
						allocatedHost = host;
						}
					if (diff == minDiff) {
						if (allocatedHost.getTotalMips()/allocatedHost.getMaxPower() < host.getTotalMips()/host.getMaxPower()) allocatedHost = host;
					} 
									
					
				} catch (Exception e) {
				}
			}
		}
		
		return allocatedHost;
	}

}
