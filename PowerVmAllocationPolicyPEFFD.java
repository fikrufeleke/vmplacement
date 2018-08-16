package org.cloudbus.cloudsim.power;




import java.util.List;
import java.util.Set;

import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Vm;



public class PowerVmAllocationPolicyPEFFD extends PowerVmAllocationPolicyMigrationLocalRegression{
	
	public PowerVmAllocationPolicyPEFFD(
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

		double bestPowerEfficiency = Double.MIN_VALUE;
		double inactiveEff = Double.MIN_VALUE;
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
				
			try {
				double powerEfficiency = host.getTotalMips() / host.getMaxPower();
				if(host.getUtilizationMips() == 0) {			
					if (powerEfficiency > inactiveEff ) {
						inactiveEff = powerEfficiency;
						inactiveHost = host;
						}	
					continue;
					}				

			       if (powerEfficiency > bestPowerEfficiency) {
			    	   bestPowerEfficiency = powerEfficiency;
			           allocatedHost = host;
			            }
										
					} catch (Exception e) {
				}
			}
		}
		return (allocatedHost!=null) ?allocatedHost:inactiveHost;
	}

}
