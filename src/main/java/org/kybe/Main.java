package org.kybe;

import org.rusherhack.client.api.RusherHackAPI;
import org.rusherhack.client.api.plugin.Plugin;


public class Main extends Plugin {
	
	@Override
	public void onLoad() {
		//creating and registering a new module
		final SpaceModule spaceModule = new SpaceModule();
		RusherHackAPI.getModuleManager().registerFeature(spaceModule);
	}
	
	@Override
	public void onUnload() {
	}
	
}